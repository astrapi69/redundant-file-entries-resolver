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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.xml.parsers.FactoryConfigurationError;

import de.alpharogroup.layout.CloseWindow;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import de.alpharogroup.duplicate.files.spring.SpringApplicationContext;

/**
 * The Class ImagePanelTest.
 */
public class ImagePanelTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		frame.addWindowListener(new CloseWindow());
		frame.setTitle("ImagePanelTest");

		ApplicationContext ctx = SpringApplicationContext.getInstance()
				.getApplicationContext();
		Resource resource = ctx.getResource("classpath:images/EngineHierarchy.PNG");

		Resource log4jconfig = ctx.getResource("classpath:conf/log4j/log4jconfig.xml");


        try {
			DOMConfigurator.configure(log4jconfig.getURL());
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File imageFile = null;
		try {
			imageFile = resource.getFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedImage image = null;
		try {
			image = javax.imageio.ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ImagePanel pnlIconPanel = new ImagePanel(image);
		frame.add( pnlIconPanel);
        frame.setBounds(0, 0, 534, 336);
        frame.setVisible( true );
	}

}
