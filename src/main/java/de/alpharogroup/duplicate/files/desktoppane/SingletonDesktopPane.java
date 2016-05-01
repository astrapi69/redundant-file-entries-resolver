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
package de.alpharogroup.duplicate.files.desktoppane;

import javax.swing.JDesktopPane;

/**
 * The Class SingletonDesktopPane.
 */
public class SingletonDesktopPane {

	/** The instance. */
	private static JDesktopPane instance = new JDesktopPane();

	/**
	 * Instantiates a new singleton desktop pane.
	 */
	private SingletonDesktopPane() {
	}

	/**
	 * Gets the single instance of SingletonDesktopPane.
	 *
	 * @return single instance of SingletonDesktopPane
	 */
	public static JDesktopPane getInstance(){
		return instance;
	}

}