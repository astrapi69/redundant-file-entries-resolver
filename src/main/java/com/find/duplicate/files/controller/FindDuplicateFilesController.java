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
package com.find.duplicate.files.controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import de.alpharogroup.file.compare.CompareFileExtensions;
import de.alpharogroup.file.compare.interfaces.IFileContentResultBean;
import de.alpharogroup.file.search.SearchFileAttributesBean;
import de.alpharogroup.generic.mvc.controller.AbstractGenericController;

import org.apache.log4j.Logger;

import com.find.duplicate.files.gen.view.FindDuplicateFilesView;
import com.find.duplicate.files.model.FindDuplicateFilesModel;
import com.find.duplicate.files.tablemodel.FileContentResultBeanTableModel;

/**
 * The Class FindDuplicateFilesController.
 */
public class FindDuplicateFilesController extends
		AbstractGenericController<FindDuplicateFilesModel, FindDuplicateFilesView> {

    /** The logger. */
    private static Logger logger = Logger
    .getLogger( FindDuplicateFilesController.class.getName() );

	/* (non-Javadoc)
	 * @see net.sourceforge.jaulp.generic.mvc.controller.AbstractGenericController#process(java.awt.event.ActionEvent)
	 */
	@Override
	public void process(ActionEvent event) {
		if ( event.getSource() == getView().getComponent()
                .getBtnSelectSource()) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int state = fileChooser.showOpenDialog(null);
			File source = fileChooser.getSelectedFile();
			if(null != source && state == JFileChooser.APPROVE_OPTION ){
				if(!source.isDirectory()){
					JOptionPane.showMessageDialog(null, "Source file must be a directory. Please select as a source file that is a directory.");
				} else {
					getView().getComponent().getTxtSource().setText(source.getAbsolutePath());
					getModel().setSource(source);
				}
			}

		} else if( event.getSource() == getView().getComponent()
                .getBtnSelectCompare()) {

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int state = fileChooser.showOpenDialog(null);
			File compare = fileChooser.getSelectedFile();
			if(null != compare && state == JFileChooser.APPROVE_OPTION ){
				if(!compare.isDirectory()){
					JOptionPane.showMessageDialog(null, "Compare file must be a directory. Please select as a compare file that is a directory.");
				} else {
					getView().getComponent().getTxtCompare().setText(compare.getAbsolutePath());
					getModel().setCompare(compare);
				}
			}

		} else if ( event.getSource() == getView().getComponent()
                .getBtnSearch()) {

			final JTextField txtSource = getView().getComponent().getTxtSource();
			final FindDuplicateFilesModel model = getModel();
			final JTextArea textPane = getView().getComponent().getTxtProgress();
			final JTextField txtProcessDescription = getView().getComponent().getTxtProcessDescription();
			SwingUtilities.invokeLater(
				    new Runnable(){
				        public void run(){


							if(null == model.getSource()) {
								String sourceFile = txtSource.getText();
								File source = new File(sourceFile);
								if(source.exists()){
									model.setSource(source);
								} else {
									JOptionPane.showMessageDialog(null, "Source file is not selected. Please select a source file.");
									return;
								}
							}

							if(null == model.getCompare()) {
								String compareFile = txtSource.getText();
								File compare = new File(compareFile);
								if(compare.exists()){
									model.setSource(compare);
								} else {
									JOptionPane.showMessageDialog(null, "Compare file is not selected. Please select a compare file.");
									return;
								}
							}
							txtProcessDescription.setText("Loading the files from the source and compare...");
//							List<File> allSourceFiles = null;
							SwingUtilities.invokeLater(
								    new Runnable(){
								        public void run(){

								        	txtProcessDescription.setText("Loading the files from the source and compare...");
								        }
								    }
								);
							final GetFilesWorker getSourceFilesWorker = new GetFilesWorker(model.getSource(), textPane, "Loading the files from the source...");
							getSourceFilesWorker.execute();

							getView().getComponent().getBtnSearch().setEnabled(false);

							// Nice to have TODO insert a new button cancel to cancel the action...
//
//							List<File> allCompareFiles = null;
							final GetFilesWorker getCompareFilesWorker =  new GetFilesWorker(model.getCompare(), textPane, "Loading the files from the compare...");

							getCompareFilesWorker.execute();

							final GetFilesWorker asf = getSourceFilesWorker;
							final GetFilesWorker acf = getCompareFilesWorker;

							SwingUtilities.invokeLater(
								    new Runnable(){
								        public void run(){

								        	SearchFileAttributesBean searchFileAttributesBean = new SearchFileAttributesBean(
								        			!getView().getComponent().getChbExtension().isSelected(),
													!getView().getComponent().getChbLength().isSelected(),
													!getView().getComponent().getChbLastModified().isSelected(),
													!getView().getComponent().getChbFilename().isSelected(),
													!getView().getComponent().getChbFileContent().isSelected());

								        	FindFilesWorker findFilesWorker = new FindFilesWorker(asf, acf,
								        			searchFileAttributesBean,
													getView().getComponent().getPrgrsBrSearch());

								        	findFilesWorker.execute();

								        	boolean wait = true;
								        	List<IFileContentResultBean> equalFiles = null;
								        	while(wait){
								        		if(findFilesWorker.isDone()){
								        			try {
														equalFiles = findFilesWorker.get();
														wait = false;
														getView().getComponent().getBtnSearch().setEnabled(true);
														break;
													} catch (InterruptedException e) {
														wait = false;
														logger.error("An InterruptedException occured by invoking the get()-method from the class FindFilesWorker.", e);
													} catch (ExecutionException e) {
														wait = false;
														logger.error("An ExecutionException occured by invoking the get()-method from the class FindFilesWorker.", e);
													}
								        		} else {
								        			continue;
								        		}
								        	}

											FileContentResultBeanTableModel tableModel = (FileContentResultBeanTableModel) getView().getComponent().getTblResults().getModel();
											if(!tableModel.getData().isEmpty()){
												tableModel.clear();
									        }
											tableModel.addList(equalFiles);


								        }
								    }
								);
				        }
				    }
				);
		}
	}

	/**
	 * The Class FindFilesWorker.
	 */
	private class FindFilesWorker extends SwingWorker<List<IFileContentResultBean>, Void> {

		/** The all source files. */
		GetFilesWorker allSourceFiles;

		/** The all compare files. */
		GetFilesWorker allCompareFiles;

		/** The ignore extension equality. */
		boolean ignoreExtensionEquality;

		/** The ignore length equality. */
		boolean ignoreLengthEquality;

 		/** The ignore last modified. */
 		boolean ignoreLastModified;

 		/** The ignore name equality. */
 		boolean ignoreNameEquality;

 		/** The ignore content equality. */
 		boolean ignoreContentEquality;

 		/** The progress bar. */
 		JProgressBar progressBar;

		/**
		 * Instantiates a new find files worker.
		 *
		 * @param allSourceFiles the all source files
		 * @param allCompareFiles the all compare files
		 * @param searchFileAttributesBean the search file attributes bean
		 * @param progressBar the progress bar
		 */
		public FindFilesWorker(final GetFilesWorker allSourceFiles, final GetFilesWorker allCompareFiles,
				final SearchFileAttributesBean searchFileAttributesBean, final JProgressBar progressBar) {
			super();
			this.allSourceFiles = allSourceFiles;
			this.allCompareFiles = allCompareFiles;
			this.ignoreExtensionEquality = searchFileAttributesBean.isIgnoreExtensionEquality();
			this.ignoreLengthEquality = searchFileAttributesBean.isIgnoreLengthEquality();
			this.ignoreLastModified = searchFileAttributesBean.isIgnoreLastModified();
			this.ignoreNameEquality = searchFileAttributesBean.isIgnoreNameEquality();
			this.ignoreContentEquality = searchFileAttributesBean.isIgnoreContentEquality();
			this.progressBar = progressBar;
		}

		/* (non-Javadoc)
		 * @see javax.swing.SwingWorker#doInBackground()
		 */
		@Override
		protected List<IFileContentResultBean> doInBackground() throws Exception {
			List<IFileContentResultBean> equalFiles = null;
			equalFiles = findEqualFilesWithSameContent(allSourceFiles, allCompareFiles, ignoreExtensionEquality,
					ignoreLengthEquality, ignoreLastModified, ignoreNameEquality, ignoreContentEquality, progressBar);
			FileContentResultBeanTableModel tableModel = (FileContentResultBeanTableModel) getView().getComponent().getTblResults().getModel();
			if(!tableModel.getData().isEmpty()){
				tableModel.clear();
	        }
			tableModel.addList(equalFiles);
			return equalFiles;
		}

	}



	/**
	 * Find equal files from the given directories.
	 *
	 * @param getSourceFilesWorker the get source files worker
	 * @param getCompareFilesWorker the get compare files worker
	 * @param ignoreExtensionEquality the ignore extension equality
	 * @param ignoreLengthEquality the ignore length equality
	 * @param ignoreLastModified the ignore last modified
	 * @param ignoreNameEquality the ignore name equality
	 * @param ignoreContentEquality the ignore content equality
	 * @param progressBar the progress bar
	 * @return the list
	 */
	public final List<IFileContentResultBean> findEqualFilesWithSameContent(final GetFilesWorker getSourceFilesWorker, final GetFilesWorker getCompareFilesWorker,
			final boolean ignoreExtensionEquality, final boolean ignoreLengthEquality,
			final boolean ignoreLastModified, final boolean ignoreNameEquality,
			final boolean ignoreContentEquality, final JProgressBar progressBar) {
		List<File> allSourceFiles = null;
		boolean wait = true;
		while(wait){
			if(getSourceFilesWorker.isDone()){
				allSourceFiles = getSourceFilesWorker.getFileList();
				wait = false;
				break;
			} else {
				continue;
			}
		}
		List<File> allCompareFiles = null;
		wait = true;
		while(wait){
			if(getCompareFilesWorker.isDone()){
				allCompareFiles = getCompareFilesWorker.getFileList();
				wait = false;
				break;
			} else {
				continue;
			}
		}

		getView().getComponent().getTxtProcessDescription().setText("Searching for duplicate files...");

		final JTextArea txtProgress = 		getView().getComponent().getTxtProgress();
		List<IFileContentResultBean> equalFiles = new ArrayList<IFileContentResultBean>();
		progressBar.setMaximum(allSourceFiles.size());
		progressBar.setValue(0);
		for (int i = 0; i < allSourceFiles.size(); i++) {
			final File toCompare = allSourceFiles.get(i);
			logger.debug(toCompare.getAbsolutePath());

			SwingUtilities.invokeLater(
				    new Runnable(){
				        public void run(){
				        	txtProgress.append(toCompare.getAbsolutePath() + "\n");
				        }
				    }
				);



			final int percent = i;
			progressBar.setValue(percent);
			progressBar.revalidate();
			for (int j = 0; j < allCompareFiles.size(); j++) {
				final File file = allCompareFiles.get(j);

				SwingUtilities.invokeLater(
					    new Runnable(){
					        public void run(){
					        	txtProgress.append(file.getAbsolutePath());
					        }
					    }
					);

				logger.debug(file.getAbsolutePath());
				if (toCompare.equals(file)) {
					continue;
				}
				IFileContentResultBean contentResultBean = (IFileContentResultBean) CompareFileExtensions
						.compareFiles(toCompare, file, ignoreExtensionEquality, ignoreLengthEquality, ignoreLastModified, ignoreNameEquality, ignoreContentEquality);
				boolean equal = CompareFileExtensions
						.validateEquality(contentResultBean);
				// if equal is true and the list does not contain the same
				// compareResultBean then add it.
				if (equal && !equalFiles.contains(contentResultBean)) {
					equalFiles.add(contentResultBean);
				}
			}
		}
		return equalFiles;
	}

    /**
     * Preinitialize.
     */
    protected void preinitialize() {
    	FindDuplicateFilesModel model = new FindDuplicateFilesModel();
    	setModel(model);
    }

	/* (non-Javadoc)
	 * @see net.sourceforge.jaulp.generic.mvc.controller.Controller#getName()
	 */
	public String getName() {
		return this.getClass().getName();
	}

}
