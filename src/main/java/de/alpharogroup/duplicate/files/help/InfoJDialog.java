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
package de.alpharogroup.duplicate.files.help;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import de.alpharogroup.actions.DisposeWindowAction;
import de.alpharogroup.duplicate.files.utils.Messages;

/**
 * The Class InfoJDialog.
 */
public class InfoJDialog extends JDialog {

	/** The Constant PLACEHOLDER_LABEL. */
	private static final String PLACEHOLDER_LABEL = Messages.getString("info.dialg.label.placeholder"); //$NON-NLS-1$ "
																										// ";

	/** The Constant BUTTONLABEL_CLOSE. */
	private static final String BUTTONLABEL_CLOSE = Messages.getString("info.dialg.label.close"); //$NON-NLS-1$ "Close";
	/** The generaded serialVersionUID. */
	private static final long serialVersionUID = 5646178025613269032L;

	/** The panel. */
	private InfoJPanel panel;

	/** The button close. */
	private JButton buttonClose;

	/** The label placeholder. */
	private JLabel labelPlaceholder;

	/**
	 * Instantiates a new info j dialog.
	 *
	 * @param owner
	 *            the owner
	 * @param title
	 *            the title
	 * @throws HeadlessException
	 *             the headless exception
	 */
	public InfoJDialog(final Frame owner, final String title) throws HeadlessException {
		setTitle(title);
		setModal(true);
		buttonClose = new JButton(BUTTONLABEL_CLOSE);
		buttonClose.addActionListener(new DisposeWindowAction(this));
		labelPlaceholder = new JLabel(PLACEHOLDER_LABEL);
		final Panel buttons = new Panel();
		buttons.add(buttonClose, BorderLayout.EAST);
		buttons.add(labelPlaceholder, BorderLayout.CENTER);
		panel = new InfoJPanel();
		final Container container = getContentPane();
		container.add(panel, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
		final int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		final int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setLocation((x / 3), (y / 3));
		setSize((x / 3), (y / 3));
	}

}