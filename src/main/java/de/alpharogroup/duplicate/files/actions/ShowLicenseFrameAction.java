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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.AbstractAction;

import de.alpharogroup.io.StreamExtensions;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import com.find.duplicate.files.help.HelpJFrame;
import com.find.duplicate.files.spring.SpringApplicationContext;

/**
 * The Class ShowLicenseFrameAction.
 */
@SuppressWarnings("serial")
public class ShowLicenseFrameAction extends AbstractAction {

	/** The Constant LICENCE_TITLE. */
	private static final String LICENCE_TITLE = "Licence";


	/**
	 * Instantiates a new show license frame action.
	 *
	 * @param name the name
	 */
	public ShowLicenseFrameAction(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String licence = loadLicense();
        HelpJFrame frame = new HelpJFrame(LICENCE_TITLE, licence);
        frame.setVisible(true);
	}

	/**
	 * Load license.
	 *
	 * @return the string
	 */
	private String loadLicense() {

		ApplicationContext ctx = SpringApplicationContext.getInstance()
		.getApplicationContext();
        Resource resource = ctx.getResource("classpath:LICENSE.txt");
		InputStream is = null;
		StringBuffer license = new StringBuffer();
		try {
			String thisLine;
			is = resource.getInputStream();
			BufferedReader br = new BufferedReader
	         (new InputStreamReader(is));
	      while ((thisLine = br.readLine()) != null) {
	    	  license.append(thisLine + "\n");
	      }
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				StreamExtensions.close(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return license.toString();
	}

}
