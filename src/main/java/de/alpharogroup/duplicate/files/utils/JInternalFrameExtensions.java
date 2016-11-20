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

}
