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
package de.alpharogroup.duplicate.files.utils;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import de.alpharogroup.generic.mvc.view.View;

/**
 * The Class {@link JInternalFrameExtensions}.
 */
public class JInternalFrameExtensions {

	/**
	 * Sets the view and controller for j internal frame.
	 *
	 * @param internalFrame
	 *            the internal frame
	 * @param view
	 *            the view
	 */
	public static void setViewAndControllerForJInternalFrame(final JInternalFrame internalFrame,
			final View<?, ?> view) {
		internalFrame.add(view.getComponent(), BorderLayout.CENTER);
		internalFrame.pack();
	}


	/**
	 * Adds the given {@link JInternalFrame} to the given {@link JDesktopPane} and bring it to the front.
	 *
	 * @param desktopPane the desktop pane
	 * @param internalFrame the internal frame
	 */
	public static void addJInternalFrame(final JDesktopPane desktopPane, final JInternalFrame internalFrame) {
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);
		internalFrame.toFront();
	}

}
