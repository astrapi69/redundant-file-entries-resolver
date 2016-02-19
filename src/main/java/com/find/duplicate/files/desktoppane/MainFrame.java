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

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

import org.jdesktop.swingx.JXFrame;

import com.find.duplicate.files.controller.FindDuplicateFilesController;
import com.find.duplicate.files.factories.JInternalFrameFactory;
import com.find.duplicate.files.gen.view.FindDuplicateFilesView;
import de.alpharogroup.swing.laf.LookAndFeels;
import com.find.duplicate.files.utils.JInternalFrameUtils;

/**
 * The Class MainFrame.
 */
@SuppressWarnings("serial")
public class MainFrame extends JXFrame {

	/** The instance. */
	private static MainFrame instance = new MainFrame();

	/** The desktop pane. */
	private final JDesktopPane desktopPane = SingletonDesktopPane.getInstance();

	/** The menubar. */
	private JMenuBar menubar;

	/** The toolbar. */
	private JToolBar toolbar;

	/** The internal frame. */
	private JInternalFrame internalFrame;

	/** The internal frame factory. */
	private JInternalFrameFactory internalFrameFactory;

	/** The current look and feels. */
	private LookAndFeels currentLookAndFeels = LookAndFeels.SYSTEM;

	/**
	 * Gets the current look and feels.
	 *
	 * @return the current look and feels
	 */
	public LookAndFeels getCurrentLookAndFeels() {
		return currentLookAndFeels;
	}

	/**
	 * Sets the current look and feels.
	 *
	 * @param currentLookAndFeels the new current look and feels
	 */
	public void setCurrentLookAndFeels(LookAndFeels currentLookAndFeels) {
		this.currentLookAndFeels = currentLookAndFeels;
	}

	/**
	 * Gets the internal frame.
	 *
	 * @return the internal frame
	 */
	public JInternalFrame getInternalFrame() {
		return internalFrame;
	}

	/**
	 * Gets the single instance of MainFrame.
	 *
	 * @return single instance of MainFrame
	 */
	public static MainFrame getInstance() {
		return instance;
	}

	/**
	 * Instantiates a new main frame.
	 */
	private MainFrame(){
		super("Find duplicate files");
		initComponents();
	}
	static{

	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {

		toolbar = new JToolBar(); // create the tool bar
		setJMenuBar(menubar);
		setToolBar(toolbar);

        // create internal frame
		internalFrameFactory = new JInternalFrameFactory();
		internalFrame = internalFrameFactory.createInternalFrame("Find duplicate files", true, true, true, true);

		FindDuplicateFilesView view  = new FindDuplicateFilesView(
                new FindDuplicateFilesController() );
		JInternalFrameUtils.setViewAndControllerForJInternalFrame(internalFrame, view);
        desktopPane.add( internalFrame );
        internalFrame.setVisible( true );

        getContentPane().add(desktopPane);

	}


	/**
	 * Gets the desktop pane.
	 *
	 * @return the desktop pane
	 */
	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	/**
	 * Gets the menubar.
	 *
	 * @return the menubar
	 */
	public JMenuBar getMenubar() {
		return menubar;
	}

	/**
	 * Gets the toolbar.
	 *
	 * @return the toolbar
	 */
	public JToolBar getToolbar() {
		return toolbar;
	}


}
