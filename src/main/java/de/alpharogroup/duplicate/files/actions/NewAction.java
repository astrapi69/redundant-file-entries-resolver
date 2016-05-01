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

import javax.swing.AbstractAction;
import javax.swing.JInternalFrame;

import de.alpharogroup.duplicate.files.gen.view.FindDuplicateFilesView;
import de.alpharogroup.duplicate.files.utils.JInternalFrameUtils;

import de.alpharogroup.duplicate.files.controller.FindDuplicateFilesController;
import de.alpharogroup.duplicate.files.desktoppane.MainFrame;
import de.alpharogroup.swing.components.factories.JComponentFactory;

/**
 * The Class NewAction.
 */
public class NewAction extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new new action.
	 *
	 * @param name
	 *            the name
	 */
	public NewAction(final String name) {
		super(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {
		// create internal frame
		final JInternalFrame internalFrame = JComponentFactory.newInternalFrame("Find duplicate files", true, true,
				true, true);

		final FindDuplicateFilesView view = new FindDuplicateFilesView(new FindDuplicateFilesController());
		JInternalFrameUtils.setViewAndControllerForJInternalFrame(internalFrame, view);
		MainFrame.getInstance().getDesktopPane().add(internalFrame);
		internalFrame.setVisible(true);
		internalFrame.toFront();

	}

}
