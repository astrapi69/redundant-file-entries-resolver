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

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JInternalFrame;

import com.find.duplicate.files.controller.FindDuplicateFilesController;
import com.find.duplicate.files.desktoppane.MainFrame;
import com.find.duplicate.files.factories.JInternalFrameFactory;
import com.find.duplicate.files.gen.view.FindDuplicateFilesView;
import com.find.duplicate.files.utils.JInternalFrameUtils;

/**
 * The Class NewAction.
 */
@SuppressWarnings("serial")
public class NewAction extends AbstractAction {

	/**
	 * Instantiates a new new action.
	 *
	 * @param name the name
	 */
	public NewAction(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// create internal frame
		JInternalFrameFactory internalFrameFactory = new JInternalFrameFactory();
		JInternalFrame internalFrame = internalFrameFactory.createInternalFrame("Find duplicate files", true, true, true, true);

		FindDuplicateFilesView view  = new FindDuplicateFilesView(
                new FindDuplicateFilesController() );
		JInternalFrameUtils.setViewAndControllerForJInternalFrame(internalFrame, view);
        MainFrame.getInstance().getDesktopPane().add( internalFrame );
        internalFrame.setVisible( true );
        internalFrame.toFront();


	}

}
