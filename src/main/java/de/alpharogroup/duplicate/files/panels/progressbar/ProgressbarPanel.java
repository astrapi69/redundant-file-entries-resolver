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
package de.alpharogroup.duplicate.files.panels.progressbar;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import de.alpharogroup.duplicate.files.spring.SpringApplicationContext;
import lombok.Getter;

/**
 * The Class ProgressbarPanel.
 *
 * @author admin
 */
public class ProgressbarPanel extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The btn cancel. */
	@Getter
	private JButton btnCancel;

	/** The lbl info. */
	@Getter
	private JLabel lblInfo;

	/** The pnl icon panel. */
	@Getter
	private JPanel pnlIconPanel;

	/** The prgr br task. */
	@Getter
	private JProgressBar prgrBrTask;

	/**
	 * Creates new form ProgressbarPanel.
	 */
	public ProgressbarPanel() {
		initComponents();
		initLayout();
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {

		prgrBrTask = new javax.swing.JProgressBar();
		btnCancel = new javax.swing.JButton();
		lblInfo = new javax.swing.JLabel();
		final ApplicationContext ctx = SpringApplicationContext.getInstance().getApplicationContext();
		final Resource resource = ctx.getResource("classpath:images/nico.gif");

		File imageFile = null;
		try {
			imageFile = resource.getFile();
		} catch (final IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedImage image = null;
		try {
			image = javax.imageio.ImageIO.read(imageFile);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pnlIconPanel = new ImagePanel(image);

		btnCancel.setText("Cancel");
		lblInfo.setText("Info");

	}

	/**
	 * Inits the layout.
	 */
	private void initLayout() {

		final javax.swing.GroupLayout pnlIconPanelLayout = new javax.swing.GroupLayout(pnlIconPanel);
		pnlIconPanel.setLayout(pnlIconPanelLayout);
		pnlIconPanelLayout.setHorizontalGroup(pnlIconPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 44, Short.MAX_VALUE));
		pnlIconPanelLayout.setVerticalGroup(pnlIconPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 41, Short.MAX_VALUE));

		final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(pnlIconPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(btnCancel).addComponent(prgrBrTask,
												javax.swing.GroupLayout.PREFERRED_SIZE, 334,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(21, 21, 21).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup().addComponent(lblInfo)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(prgrBrTask, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlIconPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18).addComponent(btnCancel).addContainerGap()));

	}

}
