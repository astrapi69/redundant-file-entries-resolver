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
package com.find.duplicate.files.factories;

import javax.swing.JInternalFrame;

/**
 * A factory for creating JInternalFrame objects.
 */
public class JInternalFrameFactory {
	
	/**
	 * Creates a new JInternalFrame object.
	 *
	 * @param title the title
	 * @param resizable the resizable
	 * @param closable the closable
	 * @param maximizable the maximizable
	 * @param iconifiable the iconifiable
	 * @return the j internal frame
	 */
	public JInternalFrame createInternalFrame(String title, boolean resizable, boolean closable,
            boolean maximizable, boolean iconifiable) {
		JInternalFrame internalFrame = new JInternalFrame(
					title, resizable, closable, maximizable, iconifiable );
		return internalFrame;
	}

}