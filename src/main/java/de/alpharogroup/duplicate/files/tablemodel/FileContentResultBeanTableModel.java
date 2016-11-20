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
package de.alpharogroup.duplicate.files.tablemodel;

import java.io.File;

import de.alpharogroup.file.compare.interfaces.IFileContentResultBean;
import de.alpharogroup.swing.tablemodel.GenericTableModel;

/**
 * The Class FileContentResultBeanTableModel.
 */
@SuppressWarnings("serial")
public class FileContentResultBeanTableModel extends GenericTableModel<IFileContentResultBean> {

	/** The Constant STREET. */
	public static final String SOURCE = "Source files";

	/** The Constant NUMBER. */
	public static final String COMPARE = "Compare files";

	/** The column names. */
	private String[] columnNames = { SOURCE, COMPARE };

	/** The can edit. */
	boolean[] canEdit = new boolean[] { false, false };

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCellEditable(final int rowIndex, final int columnIndex) {
		return canEdit[columnIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex) {
		final IFileContentResultBean fileContentResultBean = getData().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return fileContentResultBean.getSourceFile();
		case 1:
			return fileContentResultBean.getFileToCompare();
		default:
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<?> getColumnClass(final int c) {
		switch (c) {
		case 0:
			return File.class;
		case 1:
			return File.class;
		default:
			return null;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColumnName(final int col) {
		return columnNames[col];
	}

}
