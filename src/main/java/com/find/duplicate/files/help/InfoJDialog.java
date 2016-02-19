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
package com.find.duplicate.files.help;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.find.duplicate.files.utils.Messages;


/**
 * The Class InfoJDialog.
 */
public class InfoJDialog extends JDialog implements ActionListener {
	
	/** The Constant PLACEHOLDER_LABEL. */
	private static final String PLACEHOLDER_LABEL = Messages.getString("info.dialg.label.placeholder"); //$NON-NLS-1$ "   ";
	
	/** The Constant BUTTONLABEL_CLOSE. */
	private static final String BUTTONLABEL_CLOSE = Messages.getString("info.dialg.label.close"); //$NON-NLS-1$ "Close";
	/** The generaded serialVersionUID. */
	private static final long serialVersionUID = 5646178025613269032L;

    /** The panel. */
    InfoJPanel panel = null;
    
    /** The button close. */
    private JButton buttonClose = null;
    
    /** The label placeholder. */
    private JLabel labelPlaceholder = null;
    
    /** The buttons. */
    Panel buttons = null;

    /**
     * Instantiates a new info j dialog.
     *
     * @param owner the owner
     * @param title the title
     * @throws HeadlessException the headless exception
     */
    public InfoJDialog(Frame owner, String title) throws HeadlessException {
        setTitle(title);
        setModal(true);
        buttonClose = new JButton(BUTTONLABEL_CLOSE);
        buttonClose.addActionListener(this);
        labelPlaceholder = new JLabel(PLACEHOLDER_LABEL);
        Panel buttons = new Panel();
        buttons.add(buttonClose, BorderLayout.EAST);
        buttons.add(labelPlaceholder, BorderLayout.CENTER);
        panel = new InfoJPanel();
        Container container = getContentPane();
        container.add(panel, BorderLayout.CENTER);
        container.add(buttons, BorderLayout.SOUTH);
        int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setLocation( (x/3), (y/3) );
        setSize((x/3), (y/3));
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == buttonClose){
            this.dispose();
        }
    }
}