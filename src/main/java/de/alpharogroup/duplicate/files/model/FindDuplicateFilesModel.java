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
import lombok.Getter;
import lombok.Setter;

/**
 * The Class FindDuplicateFilesModel.
 */
public class FindDuplicateFilesModel implements Model<FindDuplicateFilesModel> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The source. */
	@Getter
	@Setter
	private File source;

	/** The compare. */
	@Getter
	@Setter
	private File compare;

	/** The file content result bean. */
	@Getter
	private IFileContentResultBean fileContentResultBean;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FindDuplicateFilesModel getModelObject() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setModelObject(final FindDuplicateFilesModel modelObject) {
		compare = modelObject.compare;
		fileContentResultBean = modelObject.fileContentResultBean;
		source = modelObject.source;
	}
}
