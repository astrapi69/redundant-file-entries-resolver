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
package com.find.duplicate.files.desktoppane;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.FactoryConfigurationError;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import com.find.duplicate.files.desktoppane.menu.DesktopMenu;
import com.find.duplicate.files.spring.SpringApplicationContext;

import de.alpharogroup.layout.ScreenSizeExtensions;
import de.alpharogroup.swing.laf.LookAndFeels;



/**
 * The Class MainApplication.
 */
public class MainApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplicationContext.getInstance()
		.getApplicationContext();
		Resource resource = ctx.getResource("classpath:conf/log4j/log4jconfig.xml");





        try {
			DOMConfigurator.configure(resource.getURL());
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MainFrame mainFrame = MainFrame.getInstance();
		DesktopMenu menu = DesktopMenu.getInstance();
		mainFrame.setJMenuBar(menu.getMenubar());


		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		mainFrame.setSize( ScreenSizeExtensions.getScreenWidth(), ScreenSizeExtensions.getScreenHeight() );
		mainFrame.setVisible( true );
		mainFrame.getDesktopPane().getDesktopManager().activateFrame(mainFrame.getInternalFrame());
		mainFrame.getDesktopPane().getDesktopManager().maximizeFrame(mainFrame.getInternalFrame());
		mainFrame.getInternalFrame().toFront();

		// Set default look and feel...
		try {
			UIManager.setLookAndFeel(LookAndFeels.SYSTEM.getLookAndFeelName());
			SwingUtilities.updateComponentTreeUI(mainFrame);
			mainFrame.setCurrentLookAndFeels(LookAndFeels.SYSTEM);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
