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
package de.alpharogroup.duplicate.files.model;

import java.io.File;


import de.alpharogroup.file.compare.interfaces.IFileContentResultBean;
import de.alpharogroup.generic.mvc.model.Model;

/**
 * The Class FindDuplicateFilesModel.
 */
public class FindDuplicateFilesModel implements Model<FindDuplicateFilesModel> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The source. */
	private File source;

	/** The compare. */
	private File compare;

	/** The file content result bean. */
	private IFileContentResultBean fileContentResultBean;

	/**
	 * Gets the file content result bean.
	 *
	 * @return the file content result bean
	 */
	public IFileContentResultBean getFileContentResultBean() {
		return fileContentResultBean;
	}

	/**
	 * Sets the file content result bean.
	 *
	 * @param fileContentResultBean the new file content result bean
	 */
	public void setFileContentResultBean(
			IFileContentResultBean fileContentResultBean) {
		this.fileContentResultBean = fileContentResultBean;
	}

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public File getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source the new source
	 */
	public void setSource(File source) {
		this.source = source;
	}

	/**
	 * Gets the compare.
	 *
	 * @return the compare
	 */
	public File getCompare() {
		return compare;
	}

	/**
	 * Sets the compare.
	 *
	 * @param compare the new compare
	 */
	public void setCompare(File compare) {
		this.compare = compare;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.jaulp.generic.mvc.model.Model#getModelContent()
	 */
	@Override
	public FindDuplicateFilesModel getModelObject() {
		return this;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.jaulp.generic.mvc.model.Model#setModelContent(java.io.Serializable)
	 */
	@Override
	public void setModelObject(FindDuplicateFilesModel modelObject) {
		this.compare = modelObject.compare;
		this.fileContentResultBean = modelObject.fileContentResultBean;
		this.source = modelObject.source;
	}
}
