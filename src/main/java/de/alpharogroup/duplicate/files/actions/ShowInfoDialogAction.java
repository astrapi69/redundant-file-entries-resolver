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


import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import de.alpharogroup.duplicate.files.desktoppane.MainFrame;
import de.alpharogroup.duplicate.files.help.InfoJDialog;

/**
 * The Class ShowInfoDialogAction.
 */
@SuppressWarnings("serial")
public class ShowInfoDialogAction extends AbstractAction {

	/** The Constant INFO_TITLE. */
	private static final String INFO_TITLE = "Info";

	/**
	 * Instantiates a new show info dialog action.
	 *
	 * @param name the name
	 */
	public ShowInfoDialogAction(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        InfoJDialog info = new InfoJDialog(MainFrame.getInstance(), INFO_TITLE);
        info.setVisible(true);
	}


}
