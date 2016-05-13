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
public class ShowInfoDialogAction extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The Constant INFO_TITLE. */
	private static final String INFO_TITLE = "Info";

	/**
	 * Instantiates a new show info dialog action.
	 *
	 * @param name
	 *            the name
	 */
	public ShowInfoDialogAction(final String name) {
		super(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {
		final InfoJDialog info = new InfoJDialog(MainFrame.getInstance(), INFO_TITLE);
		info.setVisible(true);
	}

}
