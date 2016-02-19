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
package com.find.duplicate.files.panels.progressbar;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * The Class ImagePanel.
 */
@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
	
	/** The image. */
	BufferedImage image;

	/**
	 * Instantiates a new image panel.
	 *
	 * @param image the image
	 */
	ImagePanel(BufferedImage image) {
		this.image = image;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
}