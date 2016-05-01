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
package de.alpharogroup.duplicate.files.desktoppane.menu;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.help.CSH;
import javax.help.DefaultHelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.help.WindowPresentation;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.find.duplicate.files.utils.Messages;

import de.alpharogroup.duplicate.files.actions.NewAction;
import de.alpharogroup.duplicate.files.actions.OpenBrowserToDonateAction;
import de.alpharogroup.duplicate.files.actions.ShowHelpDialogAction;
import de.alpharogroup.duplicate.files.actions.ShowInfoDialogAction;
import de.alpharogroup.duplicate.files.actions.ShowLicenseFrameAction;
import de.alpharogroup.duplicate.files.desktoppane.MainFrame;
import de.alpharogroup.lang.ClassExtensions;
import de.alpharogroup.swing.actions.ExitApplicationAction;
import de.alpharogroup.swing.laf.actions.LookAndFeelMetalAction;
import de.alpharogroup.swing.laf.actions.LookAndFeelMotifAction;
import de.alpharogroup.swing.laf.actions.LookAndFeelSystemAction;
import de.alpharogroup.swing.menu.MenuExtensions;

/**
 * The Class DesktopMenu.
 */
public class DesktopMenu {

	/** The JMenuBar from the DesktopMenu. */
	private JMenuBar menubar;

	/** The file menu. */
	private JMenu fileMenu;

	/** The look and feel menu. */
	private JMenu lookAndFeelMenu;

	/** The help menu. */
	private JMenu helpMenu;

	/** The help window. */
	private Window helpWindow;

	/**
	 * Gets the help window.
	 *
	 * @return the help window
	 */
	public Window getHelpWindow() {
		return helpWindow;
	}

	/**
	 * Sets the help window.
	 *
	 * @param helpWindow
	 *            the new help window
	 */
	public void setHelpWindow(final Window helpWindow) {
		this.helpWindow = helpWindow;
	}

	/** The instance. */
	private static DesktopMenu instance = new DesktopMenu();

	/**
	 * Gets the single instance of DesktopMenu.
	 *
	 * @return single instance of DesktopMenu
	 */
	public static DesktopMenu getInstance() {
		return instance;
	}

	/**
	 * Returns the field <code>menubar</code>.
	 *
	 * @return The field .
	 */
	public JMenuBar getMenubar() {
		return menubar;
	}

	/**
	 * Instantiates a new desktop menu.
	 */
	private DesktopMenu() {
		menubar = new JMenuBar();
		fileMenu = createFileMenu(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("filemenu");
			}
		});

		lookAndFeelMenu = createLookAndFeelMenu(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Look and Feel menu");
			}
		});

		helpMenu = createHelpMenu(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Help menu");
			}
		});

		menubar.add(fileMenu);
		menubar.add(lookAndFeelMenu);
		menubar.add(helpMenu);
	}

	/**
	 * Creates the file menu.
	 *
	 * @param listener
	 *            the listener
	 *
	 * @return the j menu
	 */
	private JMenu createFileMenu(final ActionListener listener) {
		final JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		JMenuItem jmi;

		// New
		jmi = new JMenuItem("New", 'N');
		jmi.addActionListener(new NewAction("New"));
		MenuExtensions.setCtrlAccelerator(jmi, 'N');
		fileMenu.add(jmi);

		// Separator
		fileMenu.addSeparator();

		// Save
		JMenuItem jmiSave;
		jmiSave = new JMenuItem("Save", 'S');
		jmiSave.addActionListener(listener);
		MenuExtensions.setCtrlAccelerator(jmiSave, 'S');
		jmiSave.setEnabled(false);
		fileMenu.add(jmiSave);

		// Separator
		fileMenu.addSeparator();

		// Save as
		JMenuItem jmiSaveAs;
		jmiSaveAs = new JMenuItem("Save as", 'a');
		jmiSaveAs.addActionListener(listener);
		jmiSaveAs.setEnabled(false);
		fileMenu.add(jmiSaveAs);

		// Separator
		fileMenu.addSeparator();

		// Configuration
		JMenuItem jmiPrint;
		jmiPrint = new JMenuItem("Print", 'r');
		jmiPrint.addActionListener(listener);
		jmiPrint.setEnabled(false);
		fileMenu.add(jmiPrint);

		// Separator
		fileMenu.addSeparator();

		// Configuration
		JMenuItem jmiConfiguration;
		jmiConfiguration = new JMenuItem("Configuration", 'C');
		jmiConfiguration.addActionListener(listener);
		jmiConfiguration.setEnabled(false);
		fileMenu.add(jmiConfiguration);

		// Separator
		fileMenu.addSeparator();

		// Configuration
		JMenuItem jmiExit;
		jmiExit = new JMenuItem("Exit", 'E');
		jmiExit.addActionListener(new ExitApplicationAction("Exit"));
		fileMenu.add(jmiExit);

		return fileMenu;
	}

	/**
	 * Creates the look and feel menu.
	 *
	 * @param listener
	 *            the listener
	 * @return the j menu
	 */
	private JMenu createLookAndFeelMenu(final ActionListener listener) {

		final JMenu menuLookAndFeel = new JMenu("Look and Feel");
		menuLookAndFeel.setMnemonic('L');

		// Look and Feel JMenuItems
		// Metal default Metal theme
		JMenuItem jmiLafMetal;
		jmiLafMetal = new JMenuItem("Metal", 'm'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(jmiLafMetal, 'M');
		jmiLafMetal.addActionListener(new LookAndFeelMetalAction("Metal", MainFrame.getInstance()));
		menuLookAndFeel.add(jmiLafMetal);
		// Metal Ocean theme
		JMenuItem jmiLafOcean;
		jmiLafOcean = new JMenuItem("Ocean", 'o'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(jmiLafOcean, 'O');
		jmiLafOcean.addActionListener(new LookAndFeelMetalAction("Ocean", MainFrame.getInstance()));
		menuLookAndFeel.add(jmiLafOcean);
		// Motif
		JMenuItem jmiLafMotiv;
		jmiLafMotiv = new JMenuItem("Motif", 't'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(jmiLafMotiv, 'T');
		jmiLafMotiv.addActionListener(new LookAndFeelMotifAction("Motif", MainFrame.getInstance()));
		menuLookAndFeel.add(jmiLafMotiv);
		// Windows
		JMenuItem jmiLafSystem;
		jmiLafSystem = new JMenuItem("System", 'd'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(jmiLafSystem, 'W');
		jmiLafSystem.addActionListener(new LookAndFeelSystemAction("System", MainFrame.getInstance()));
		menuLookAndFeel.add(jmiLafSystem);

		return menuLookAndFeel;

	}

	/**
	 * Creates the help menu.
	 *
	 * @param listener
	 *            the listener
	 * @return the j menu
	 */
	private JMenu createHelpMenu(final ActionListener listener) {
		// Help menu
		final JMenu menuHelp = new JMenu("Help"); //$NON-NLS-1$
		menuHelp.setMnemonic('H');

		// Help JMenuItems
		// Help content
		final JMenuItem mihHelpContent = new JMenuItem("Content", 'c'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mihHelpContent, 'H');

		menuHelp.add(mihHelpContent);
		// found bug with the javax.help
		// Exception in thread "main" java.lang.SecurityException: no manifiest
		// section for signature file entry
		// com/sun/java/help/impl/TagProperties.class
		// Solution is to remove the rsa files from the jar

		final HelpSet hs = getHelpSet();
		final DefaultHelpBroker helpBroker = (DefaultHelpBroker) hs.createHelpBroker();
		final WindowPresentation pres = helpBroker.getWindowPresentation();
		pres.createHelpWindow();
		helpWindow = pres.getHelpWindow();

		helpWindow.setLocationRelativeTo(null);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final Exception e1) {
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(helpWindow);

		// 2. assign help to components
		CSH.setHelpIDString(mihHelpContent, "Overview");
		// 3. handle events
		final CSH.DisplayHelpFromSource displayHelpFromSource = new CSH.DisplayHelpFromSource(helpBroker);
		mihHelpContent.addActionListener(displayHelpFromSource);
		mihHelpContent.addActionListener(new ShowHelpDialogAction("Content"));

		// Donate
		final JMenuItem mihDonate = new JMenuItem(Messages.getString("com.find.duplicate.files.menu.item.donate")); //$NON-NLS-1$
		mihDonate.addActionListener(new OpenBrowserToDonateAction("Donate"));
		menuHelp.add(mihDonate);

		// Licence
		final JMenuItem mihLicence = new JMenuItem("Licence"); //$NON-NLS-1$
		mihLicence.addActionListener(new ShowLicenseFrameAction("Licence"));
		menuHelp.add(mihLicence);
		// Info
		final JMenuItem mihInfo = new JMenuItem("Info", 'i'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mihInfo, 'I');
		mihInfo.addActionListener(new ShowInfoDialogAction("Info"));
		menuHelp.add(mihInfo);

		return menuHelp;
	}

	/**
	 * Gets the file menu.
	 *
	 * @return the file menu
	 */
	public JMenu getFileMenu() {
		return fileMenu;
	}

	/**
	 * Gets the look and feel menu.
	 *
	 * @return the look and feel menu
	 */
	public JMenu getLookAndFeelMenu() {
		return lookAndFeelMenu;
	}

	/**
	 * Gets the help menu.
	 *
	 * @return the help menu
	 */
	public JMenu getHelpMenu() {
		return helpMenu;
	}

	/**
	 * Gets the help set.
	 *
	 * @return the help set
	 */
	public HelpSet getHelpSet() {
		HelpSet hs = null;
		final String filename = "simple-hs.xml";
		final String path = "help/" + filename;
		URL hsURL;
		if (hs == null) {
			hsURL = ClassExtensions.getResource(path);
			try {
				hs = new HelpSet(null, hsURL);
			} catch (final HelpSetException e) {
				e.printStackTrace();
			}
		}
		return hs;
	}

}
