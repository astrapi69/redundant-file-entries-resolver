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
package de.alpharogroup.duplicate.files.panels.progressbar;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * The Class ImagePanel.
 */
public class ImagePanel extends JPanel {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The image. */
	private BufferedImage image;

	/**
	 * Instantiates a new image panel.
	 *
	 * @param image
	 *            the image
	 */
	public ImagePanel(final BufferedImage image) {
		this.image = image;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
}