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
package de.alpharogroup.duplicate.files.panels;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTable;

import de.alpharogroup.duplicate.files.tablemodel.FileContentResultBeanTableModel;
import de.alpharogroup.file.compare.interfaces.IFileContentResultBean;
import de.alpharogroup.swing.x.GenericJXTable;
import lombok.Getter;

/**
 * The Class FindDuplicateFilesPanel.
 *
 * @author admin
 */
@SuppressWarnings("serial")
public class FindDuplicateFilesPanel extends JPanel {

	/** The btn delete compares. */
	@Getter
	private JButton btnDeleteCompares;

	/** The btn delete sources. */
	@Getter
	private JButton btnDeleteSources;

	/** The btn search. */
	@Getter
	private JButton btnSearch;

	/** The btn select compare. */
	@Getter
	private JButton btnSelectCompare;

	/** The btn select source. */
	@Getter
	private JButton btnSelectSource;

	/** The chb extension. */
	@Getter
	private JCheckBox chbExtension;

	/** The chb file content. */
	@Getter
	private JCheckBox chbFileContent;

	/** The chb filename. */
	@Getter
	private JCheckBox chbFilename;

	/** The chb last modified. */
	@Getter
	private JCheckBox chbLastModified;

	/** The chb length. */
	@Getter
	private JCheckBox chbLength;

	/** The lbl compare. */
	@Getter
	private JXLabel lblCompare;

	/** The lbl progress. */
	@Getter
	private JXLabel lblProgress;

	/** The lbl results. */
	@Getter
	private JXLabel lblResults;

	/** The lbl source. */
	@Getter
	private JXLabel lblSource;

	/** The prgrs br search. */
	@Getter
	private JProgressBar prgrsBrSearch;

	/** The scr pn tbl results. */
	@Getter
	private JScrollPane scrPnTblResults;

	/** The tbl results. */
	@Getter
	private JXTable tblResults;

	/** The txt compare. */
	@Getter
	private JTextField txtCompare;

	/** The txt source. */
	@Getter
	private JTextField txtSource;

	/** The lbl process. */
	@Getter
	private JXLabel lblProcess;

	/** The scr pn progress. */
	@Getter
	private JScrollPane scrPnProgress;

	/** The txt process description. */
	@Getter
	private JTextField txtProcessDescription;

	/** The txt progress. */
	@Getter
	private JTextArea txtProgress;

	/**
	 * Creates new form FindDuplicateFilesPanel.
	 */
	public FindDuplicateFilesPanel() {
		initComponents();
		initLayout();
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {

		lblSource = new JXLabel();
		txtSource = new JTextField();
		btnSelectSource = new JButton();
		lblCompare = new JXLabel();
		txtCompare = new JTextField();
		btnSelectCompare = new JButton();
		chbFilename = new JCheckBox();
		chbExtension = new JCheckBox();
		chbLastModified = new JCheckBox();
		chbLength = new JCheckBox();
		chbFileContent = new JCheckBox();
		scrPnTblResults = new JScrollPane();
		tblResults = new GenericJXTable<IFileContentResultBean>(new FileContentResultBeanTableModel());
		btnDeleteCompares = new JButton();
		lblResults = new JXLabel();
		btnDeleteSources = new JButton();
		btnSearch = new JButton();
		prgrsBrSearch = new JProgressBar();
		lblProgress = new JXLabel();

		scrPnProgress = new JScrollPane();
		txtProgress = new JTextArea();
		lblProcess = new JXLabel();
		txtProcessDescription = new JTextField();

		lblSource.setText("Source:");

		btnSelectSource.setText("Select");

		lblCompare.setText("Compare:");

		btnSelectCompare.setText("Select");

		chbFilename.setText("Filename");

		chbExtension.setText("Extension");

		chbLastModified.setText("Last modified");

		chbLength.setText("Length");

		chbFileContent.setText("File content");

		scrPnTblResults.setViewportView(tblResults);

		btnDeleteCompares.setText("Delete duplicate compare files");

		lblResults.setText("Results:");

		btnDeleteSources.setText("Delete duplicate source files");

		btnSearch.setText("Search for duplicate files");

		lblProgress.setText("Progress:");

		txtProgress.setBackground(new java.awt.Color(212, 208, 200));

		scrPnProgress.setViewportView(txtProgress);

		lblProcess.setText("Process:");

	}

	/**
	 * Inits the layout.
	 */
	private void initLayout() {
		final GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(scrPnProgress, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1041,
								Short.MAX_VALUE)
						.addGroup(GroupLayout.Alignment.LEADING,
								layout.createSequentialGroup().addComponent(chbExtension).addGap(33, 33, 33)
										.addComponent(chbLength).addGap(18, 18, 18).addComponent(chbLastModified)
										.addGap(18, 18, 18).addComponent(chbFilename).addGap(18, 18, 18)
										.addComponent(chbFileContent))
						.addComponent(lblCompare, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 175,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSource, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 175,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblResults, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(txtSource).addComponent(txtCompare).addComponent(scrPnTblResults,
												GroupLayout.PREFERRED_SIZE, 749, GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(btnDeleteCompares, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
										.addComponent(btnSelectCompare, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
										.addComponent(btnSelectSource, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
										.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
										.addComponent(btnDeleteSources, GroupLayout.DEFAULT_SIZE, 274,
												Short.MAX_VALUE)))
						.addComponent(lblProgress, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 130,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(GroupLayout.Alignment.LEADING,
								layout.createSequentialGroup()
										.addComponent(lblProcess, GroupLayout.PREFERRED_SIZE, 102,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(
												txtProcessDescription, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(lblSource, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtSource, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSelectSource))
						.addGap(19, 19, 19)
						.addComponent(lblCompare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtCompare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSelectCompare))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(chbExtension)
								.addComponent(chbLength).addComponent(chbLastModified).addComponent(chbFilename)
								.addComponent(chbFileContent))
						.addGap(18, 18, 18)
						.addComponent(lblResults, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(btnSearch)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnDeleteSources)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnDeleteCompares))
								.addComponent(scrPnTblResults, GroupLayout.PREFERRED_SIZE, 290,
										GroupLayout.PREFERRED_SIZE))
						.addGap(24, 24, 24)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblProcess, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
								.addComponent(txtProcessDescription, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblProgress, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scrPnProgress, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
						.addGap(48, 48, 48)));
	}

}
