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

import javax.swing.JTextArea;

import de.alpharogroup.file.compare.interfaces.IFileContentResultBean;
import de.alpharogroup.swing.x.GenericJXTable;

import de.alpharogroup.duplicate.files.tablemodel.FileContentResultBeanTableModel;

/**
 * The Class FindDuplicateFilesPanel.
 *
 * @author admin
 */
@SuppressWarnings("serial")
public class FindDuplicateFilesPanel extends javax.swing.JPanel {

    /** The btn delete compares. */
    private javax.swing.JButton btnDeleteCompares;

    /** The btn delete sources. */
    private javax.swing.JButton btnDeleteSources;

    /** The btn search. */
    private javax.swing.JButton btnSearch;

    /** The btn select compare. */
    private javax.swing.JButton btnSelectCompare;

    /** The btn select source. */
    private javax.swing.JButton btnSelectSource;

    /** The chb extension. */
    private javax.swing.JCheckBox chbExtension;

    /** The chb file content. */
    private javax.swing.JCheckBox chbFileContent;

    /** The chb filename. */
    private javax.swing.JCheckBox chbFilename;

    /** The chb last modified. */
    private javax.swing.JCheckBox chbLastModified;

    /** The chb length. */
    private javax.swing.JCheckBox chbLength;

    /** The lbl compare. */
    private org.jdesktop.swingx.JXLabel lblCompare;

    /** The lbl progress. */
    private org.jdesktop.swingx.JXLabel lblProgress;

    /** The lbl results. */
    private org.jdesktop.swingx.JXLabel lblResults;

    /** The lbl source. */
    private org.jdesktop.swingx.JXLabel lblSource;

    /** The prgrs br search. */
    private javax.swing.JProgressBar prgrsBrSearch;

    /** The scr pn tbl results. */
    private javax.swing.JScrollPane scrPnTblResults;

    /** The tbl results. */
    private org.jdesktop.swingx.JXTable tblResults;

    /** The txt compare. */
    private javax.swing.JTextField txtCompare;

    /** The txt source. */
    private javax.swing.JTextField txtSource;

    /** The lbl process. */
    private org.jdesktop.swingx.JXLabel lblProcess;

	/** The scr pn progress. */
	private javax.swing.JScrollPane scrPnProgress;

    /** The txt process description. */
    private javax.swing.JTextField txtProcessDescription;

    /** The txt progress. */
    private JTextArea txtProgress;


    /**
     * Creates new form FindDuplicateFilesPanel2.
     */
    public FindDuplicateFilesPanel() {
        initComponents();
        initLayout();
    }

    /**
     * Inits the components.
     */
    private void initComponents() {

        lblSource = new org.jdesktop.swingx.JXLabel();
        txtSource = new javax.swing.JTextField();
        btnSelectSource = new javax.swing.JButton();
        lblCompare = new org.jdesktop.swingx.JXLabel();
        txtCompare = new javax.swing.JTextField();
        btnSelectCompare = new javax.swing.JButton();
        chbFilename = new javax.swing.JCheckBox();
        chbExtension = new javax.swing.JCheckBox();
        chbLastModified = new javax.swing.JCheckBox();
        chbLength = new javax.swing.JCheckBox();
        chbFileContent = new javax.swing.JCheckBox();
        scrPnTblResults = new javax.swing.JScrollPane();
        tblResults = new GenericJXTable<IFileContentResultBean>(new FileContentResultBeanTableModel());
        btnDeleteCompares = new javax.swing.JButton();
        lblResults = new org.jdesktop.swingx.JXLabel();
        btnDeleteSources = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        prgrsBrSearch = new javax.swing.JProgressBar();
        lblProgress = new org.jdesktop.swingx.JXLabel();

        scrPnProgress = new javax.swing.JScrollPane();
        txtProgress = new JTextArea();
        lblProcess = new org.jdesktop.swingx.JXLabel();
        txtProcessDescription = new javax.swing.JTextField();

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
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrPnProgress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(chbExtension)
                        .addGap(33, 33, 33)
                        .addComponent(chbLength)
                        .addGap(18, 18, 18)
                        .addComponent(chbLastModified)
                        .addGap(18, 18, 18)
                        .addComponent(chbFilename)
                        .addGap(18, 18, 18)
                        .addComponent(chbFileContent))
                    .addComponent(lblCompare, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSource, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResults, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSource)
                            .addComponent(txtCompare)
                            .addComponent(scrPnTblResults, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteCompares, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(btnSelectCompare, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(btnSelectSource, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(btnDeleteSources, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))
                    .addComponent(lblProgress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProcessDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectSource))
                .addGap(19, 19, 19)
                .addComponent(lblCompare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectCompare))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbExtension)
                    .addComponent(chbLength)
                    .addComponent(chbLastModified)
                    .addComponent(chbFilename)
                    .addComponent(chbFileContent))
                .addGap(18, 18, 18)
                .addComponent(lblResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteSources)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteCompares))
                    .addComponent(scrPnTblResults, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(txtProcessDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrPnProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
	}

	/**
	 * Gets the btn delete compares.
	 *
	 * @return the btn delete compares
	 */
	public javax.swing.JButton getBtnDeleteCompares() {
		return btnDeleteCompares;
	}

	/**
	 * Gets the btn delete sources.
	 *
	 * @return the btn delete sources
	 */
	public javax.swing.JButton getBtnDeleteSources() {
		return btnDeleteSources;
	}

	/**
	 * Gets the btn search.
	 *
	 * @return the btn search
	 */
	public javax.swing.JButton getBtnSearch() {
		return btnSearch;
	}

	/**
	 * Gets the btn select compare.
	 *
	 * @return the btn select compare
	 */
	public javax.swing.JButton getBtnSelectCompare() {
		return btnSelectCompare;
	}

	/**
	 * Gets the btn select source.
	 *
	 * @return the btn select source
	 */
	public javax.swing.JButton getBtnSelectSource() {
		return btnSelectSource;
	}

	/**
	 * Gets the chb extension.
	 *
	 * @return the chb extension
	 */
	public javax.swing.JCheckBox getChbExtension() {
		return chbExtension;
	}

	/**
	 * Gets the chb file content.
	 *
	 * @return the chb file content
	 */
	public javax.swing.JCheckBox getChbFileContent() {
		return chbFileContent;
	}

	/**
	 * Gets the chb filename.
	 *
	 * @return the chb filename
	 */
	public javax.swing.JCheckBox getChbFilename() {
		return chbFilename;
	}

	/**
	 * Gets the chb last modified.
	 *
	 * @return the chb last modified
	 */
	public javax.swing.JCheckBox getChbLastModified() {
		return chbLastModified;
	}

	/**
	 * Gets the chb length.
	 *
	 * @return the chb length
	 */
	public javax.swing.JCheckBox getChbLength() {
		return chbLength;
	}

	/**
	 * Gets the lbl compare.
	 *
	 * @return the lbl compare
	 */
	public org.jdesktop.swingx.JXLabel getLblCompare() {
		return lblCompare;
	}

	/**
	 * Gets the lbl progress.
	 *
	 * @return the lbl progress
	 */
	public org.jdesktop.swingx.JXLabel getLblProgress() {
		return lblProgress;
	}

	/**
	 * Gets the lbl results.
	 *
	 * @return the lbl results
	 */
	public org.jdesktop.swingx.JXLabel getLblResults() {
		return lblResults;
	}

	/**
	 * Gets the lbl source.
	 *
	 * @return the lbl source
	 */
	public org.jdesktop.swingx.JXLabel getLblSource() {
		return lblSource;
	}

	/**
	 * Gets the prgrs br search.
	 *
	 * @return the prgrs br search
	 */
	public javax.swing.JProgressBar getPrgrsBrSearch() {
		return prgrsBrSearch;
	}

	/**
	 * Gets the scr pn tbl results.
	 *
	 * @return the scr pn tbl results
	 */
	public javax.swing.JScrollPane getScrPnTblResults() {
		return scrPnTblResults;
	}

	/**
	 * Gets the tbl results.
	 *
	 * @return the tbl results
	 */
	public org.jdesktop.swingx.JXTable getTblResults() {
		return tblResults;
	}

	/**
	 * Gets the txt compare.
	 *
	 * @return the txt compare
	 */
	public javax.swing.JTextField getTxtCompare() {
		return txtCompare;
	}

	/**
	 * Gets the txt source.
	 *
	 * @return the txt source
	 */
	public javax.swing.JTextField getTxtSource() {
		return txtSource;
	}

    /**
     * Gets the lbl process.
     *
     * @return the lbl process
     */
    public org.jdesktop.swingx.JXLabel getLblProcess() {
		return lblProcess;
	}

	/**
	 * Gets the scr pn progress.
	 *
	 * @return the scr pn progress
	 */
	public javax.swing.JScrollPane getScrPnProgress() {
		return scrPnProgress;
	}

	/**
	 * Gets the txt process description.
	 *
	 * @return the txt process description
	 */
	public javax.swing.JTextField getTxtProcessDescription() {
		return txtProcessDescription;
	}

	/**
	 * Gets the txt progress.
	 *
	 * @return the txt progress
	 */
	public JTextArea getTxtProgress() {
		return txtProgress;
	}

}
