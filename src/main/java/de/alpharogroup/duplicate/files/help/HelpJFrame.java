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
import java.awt.Panel;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import de.alpharogroup.actions.DisposeWindowAction;
import de.alpharogroup.duplicate.files.utils.Messages;
import de.alpharogroup.layout.DisposeWindow;

/**
 * The Class HelpJFrame.
 */
public class HelpJFrame extends JFrame {

	/** The Constant BUTTONLABEL_CLOSE. */
	private static final String BUTTONLABEL_CLOSE = Messages.getString("helpframe.button.label.close"); //$NON-NLS-1$

	/** The Constant LABEL_HELP. */
	private static final String LABEL_HELP = Messages.getString("helpframe.label.help"); //$NON-NLS-1$
	/** The generaded serialVersionUID. */
	private static final long serialVersionUID = 4151069054089210855L;

	/** The jlabel title. */
	private JLabel jlabelTitle = null;

	/** The helptext. */
	private String helptext = null;

	/** The dispose window. */
	private DisposeWindow disposeWindow = null;

	/** The jta help. */
	private JTextArea jtaHelp = null;

	/** The jtp help. */
	private JTextPane jtpHelp;

	/** The jscroll panejta help. */
	private JScrollPane jscrollPanejtaHelp = null;

	/** The button close. */
	private JButton buttonClose = null;

	/**
	 * Instantiates a new help j frame.
	 *
	 * @param title
	 *            the title
	 * @param helptext
	 *            the helptext
	 */
	public HelpJFrame(final String title, final String helptext) {
		super(title);
		this.helptext = helptext;
		disposeWindow = new DisposeWindow();
		addWindowListener(disposeWindow);
		// Point parloc = this.getParent().getLocation();
		final Point parloc = new Point(0, 0);
		setLocation(parloc.x + 30, parloc.y + 30);
		setSize(580, 600);
		createLayout();

	}

	/**
	 * Creates the layout.
	 */
	private void createLayout() {
		jlabelTitle = new JLabel(LABEL_HELP);
		getContentPane().add(jlabelTitle, BorderLayout.NORTH);
		// JTextArea Help:
		jtaHelp = new JTextArea(10, 10);
		jtpHelp = new JTextPane();
		jtpHelp.replaceSelection(helptext);
		jtaHelp.setText(helptext);
		jtaHelp.setCaretPosition(0);
		jtaHelp.setLineWrap(true);
		jtaHelp.setWrapStyleWord(true);
		jtaHelp.setEditable(false);
		jscrollPanejtaHelp = new JScrollPane(jtpHelp);
		getContentPane().add(jscrollPanejtaHelp, BorderLayout.CENTER);
		buttonClose = new JButton(BUTTONLABEL_CLOSE);
		buttonClose.addActionListener(new DisposeWindowAction(this));
		final Panel unten = new Panel();
		unten.add(buttonClose, BorderLayout.WEST);
		getContentPane().add(unten, BorderLayout.SOUTH);

	}

}
