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
package de.alpharogroup.duplicate.files.actions;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.AbstractAction;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import de.alpharogroup.duplicate.files.help.HelpJFrame;
import de.alpharogroup.duplicate.files.spring.SpringApplicationContext;
import de.alpharogroup.io.StreamExtensions;

/**
 * The Class ShowLicenseFrameAction.
 */
public class ShowLicenseFrameAction extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant LICENCE_TITLE. */
	private static final String LICENCE_TITLE = "Licence";

	/**
	 * Instantiates a new show license frame action.
	 *
	 * @param name
	 *            the name
	 */
	public ShowLicenseFrameAction(final String name) {
		super(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {
		final String licence = loadLicense();
		final HelpJFrame frame = new HelpJFrame(LICENCE_TITLE, licence);
		frame.setVisible(true);
	}

	/**
	 * Load license.
	 *
	 * @return the string
	 */
	private String loadLicense() {

		final ApplicationContext ctx = SpringApplicationContext.getInstance().getApplicationContext();
		final Resource resource = ctx.getResource("classpath:LICENSE.txt");
		InputStream is = null;
		final StringBuffer license = new StringBuffer();
		try {
			String thisLine;
			is = resource.getInputStream();
			final BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((thisLine = br.readLine()) != null) {
				license.append(thisLine + "\n");
			}
		} catch (final IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				StreamExtensions.close(is);
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
		return license.toString();
	}

}
