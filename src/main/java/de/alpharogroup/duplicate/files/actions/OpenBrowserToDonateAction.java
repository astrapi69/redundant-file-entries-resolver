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

import de.alpharogroup.duplicate.files.desktoppane.MainFrame;
import de.alpharogroup.swing.actions.OpenBrowserAction;

/**
 * The Class OpenBrowserToDonateAction.
 */
@SuppressWarnings("serial")
public class OpenBrowserToDonateAction extends OpenBrowserAction {

	/** The Constant URL_TO_DONATE. */
	public static final String URL_TO_DONATE = "http://sourceforge.net/donate/index.php?group_id=207406";

	/**
	 * Instantiates a new open browser to donate action.
	 *
	 * @param name
	 *            the name
	 */
	public OpenBrowserToDonateAction(final String name) {
		super(name, MainFrame.getInstance(), URL_TO_DONATE);
	}

}