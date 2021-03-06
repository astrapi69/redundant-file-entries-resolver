/**
 * Copyright (C) 2007 Asterios Raptis
 *
 * This program is open source software; you can redistribute it and/or modify
 * it under the terms of the Apache License V2.0 as published by
 * the Apache Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY.
 */
package de.alpharogroup.duplicate.files.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import de.alpharogroup.regex.RegExExtensions;
import lombok.Getter;

/**
 * The Class GetFilesWorker.
 */
public class GetFilesWorker extends SwingWorker<List<File>, Void> {

	/** The file list. */
	@Getter
	private List<File> fileList;

	/** The progressbar. */
	private final JTextArea progressbar;

	/** The dir. */
	private File dir;

	/** The over. */
	@Getter
	private boolean over;

	/**
	 * Instantiates a new gets the files worker.
	 *
	 * @param dir
	 *            the dir
	 * @param progressbar
	 *            the progressbar
	 * @param info
	 *            the info
	 */
	public GetFilesWorker(final File dir, final JTextArea progressbar, final String info) {
		this.dir = dir;
		this.progressbar = progressbar;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void done() {
		try {
			fileList = get();
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Finds all files that match the search pattern. The search is recursively.
	 *
	 * @param dir
	 *            The directory to search.
	 * @param filenameToSearch
	 *            The search pattern. Allowed wildcards are "*" and "?".
	 * @param progressBar
	 *            the progress bar
	 * @param currentPosition
	 *            the current position
	 * @return A List with all files that matches the search pattern.
	 */
	private List<File> findFilesRecursive(final File dir, final String filenameToSearch, final JTextArea progressBar,
			int currentPosition) {
		final List<File> foundedFileList = new ArrayList<File>();
		final String regex = RegExExtensions.replaceWildcardsWithRE(filenameToSearch);
		// Get all files
		final File[] children = dir.getAbsoluteFile().listFiles();
		if ((children == null) || (children.length < 1)) {
			return foundedFileList;
		}
		for (int i = 0; i < children.length; i++) {
			System.out.println(children[i].getAbsolutePath());
			final String absolutePath = children[i].getAbsolutePath();
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					progressBar.append(absolutePath + "\n");
					progressBar.revalidate();
				}
			});
			// if the entry is a directory
			if (children[i].isDirectory()) { // then
				// find recursively in the directory and put it in a List.
				final List<File> foundedFiles = findFilesRecursive(children[i], filenameToSearch, progressBar,
						currentPosition);
				// Put the founded files in the main List.
				currentPosition += foundedFileList.size();

				foundedFileList.addAll(foundedFiles);
			} else {
				// entry is a file
				currentPosition++;
				final String filename = children[i].getName();

				if (filename.matches(regex)) {
					foundedFileList.add(children[i].getAbsoluteFile());
				}
			}
		}
		return foundedFileList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<File> doInBackground() throws Exception {
		fileList = findFilesRecursive(dir, "*", progressbar, 0);
		over = true;
		System.out.println("Finish...");
		return fileList;
	}
}