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
package com.find.duplicate.files.tablemodel;

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
    private String [] columnNames = { SOURCE, COMPARE };

    /** The can edit. */
    boolean [] canEdit = new boolean [] { false, false
//    		, false, false
    		};

    /**
     * (non-Javadoc).
     *
     * @param rowIndex the row index
     * @param columnIndex the column index
     * @return true, if is cell editable
     * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
     */
    public boolean isCellEditable( int rowIndex, int columnIndex ) {
        return canEdit[ columnIndex ];
    }

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() {
		return columnNames.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		IFileContentResultBean fileContentResultBean = getData().get( rowIndex );
        switch ( columnIndex ) {
            case 0:
                return fileContentResultBean.getSourceFile();
            case 1:
                return fileContentResultBean.getFileToCompare();
            default:
                return null;
        }
	}

    /**
     * (non-Javadoc).
     *
     * @param c the c
     *
     * @return the column class
     *
     * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
     */
	public Class<?> getColumnClass(int c) {
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
     * (non-Javadoc).
     *
     * @param col the col
     *
     * @return the column name
     *
     * @see javax.swing.table.AbstractTableModel#getColumnName(int)
     */
    public String getColumnName( int col ) {
        return columnNames[ col ];
    }

}
