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

import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import de.alpharogroup.duplicate.files.desktoppane.MainFrame;
import de.alpharogroup.duplicate.files.desktoppane.menu.DesktopMenu;
import de.alpharogroup.swing.laf.LookAndFeels;

/**
 * The Class ShowHelpDialogAction.
 */
public class ShowHelpDialogAction extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new show help dialog action.
	 *
	 * @param name
	 *            the name
	 */
	public ShowHelpDialogAction(final String name) {
		super(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {
		final LookAndFeels currentLaf = MainFrame.getInstance().getCurrentLookAndFeels();
		final Window helpWindow = DesktopMenu.getInstance().getHelpWindow();
		helpWindow.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(currentLaf.getLookAndFeelName());
		} catch (final Exception e1) {
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(helpWindow);
	}
}
