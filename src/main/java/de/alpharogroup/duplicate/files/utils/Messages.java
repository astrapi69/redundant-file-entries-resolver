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
package de.alpharogroup.duplicate.files.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The Class Messages.
 */
public class Messages {

	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "ui.messages"; //$NON-NLS-1$

	/** The Constant RESOURCE_BUNDLE. */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	/**
	 * Instantiates a new messages.
	 */
	private Messages() {
	}

	/**
	 * Gets the string.
	 *
	 * @param key
	 *            the key
	 * @return the string
	 */
	public static String getString(final String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (final MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}