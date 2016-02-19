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
package com.find.duplicate.files.actions;


import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import de.alpharogroup.swing.laf.LookAndFeels;

import com.find.duplicate.files.desktoppane.MainFrame;
import com.find.duplicate.files.desktoppane.menu.DesktopMenu;

/**
 * The Class ShowHelpDialogAction.
 */
@SuppressWarnings("serial")
public class ShowHelpDialogAction extends AbstractAction {

	/**
	 * Instantiates a new show help dialog action.
	 *
	 * @param name the name
	 */
	public ShowHelpDialogAction(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		LookAndFeels currentLaf = MainFrame.getInstance().getCurrentLookAndFeels();
		Window helpWindow = DesktopMenu.getInstance().getHelpWindow();
		helpWindow.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(currentLaf.getLookAndFeelName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(helpWindow);
	}
}
