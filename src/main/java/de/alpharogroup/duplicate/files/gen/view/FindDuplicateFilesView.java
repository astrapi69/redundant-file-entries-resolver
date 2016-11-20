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
package de.alpharogroup.duplicate.files.gen.view;

import de.alpharogroup.duplicate.files.controller.FindDuplicateFilesController;
import de.alpharogroup.duplicate.files.panels.FindDuplicateFilesPanel;
import de.alpharogroup.generic.mvc.view.AbstractGenericView;

/**
 * The Class FindDuplicateFilesView.
 */
public class FindDuplicateFilesView extends AbstractGenericView<FindDuplicateFilesController, FindDuplicateFilesPanel> {

	/**
	 * Instantiates a new find duplicate files view.
	 *
	 * @param controller
	 *            the controller
	 */
	public FindDuplicateFilesView(final FindDuplicateFilesController controller) {
		super(controller);
		controller.setView(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initialize() {
		setComponent(new FindDuplicateFilesPanel());
		getComponent().getBtnSelectSource().addActionListener(getController());
		getComponent().getBtnSelectCompare().addActionListener(getController());
		getComponent().getBtnSearch().addActionListener(getController());
		getComponent().getBtnDeleteSources().addActionListener(getController());
		getComponent().getBtnDeleteCompares().addActionListener(getController());
	}

}
