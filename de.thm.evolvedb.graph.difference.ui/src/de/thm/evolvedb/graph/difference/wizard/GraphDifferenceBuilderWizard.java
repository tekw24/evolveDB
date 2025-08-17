/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.thm.evolvedb.graph.difference.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.menus.IWidget;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.input.InputModels;
import org.sidiff.difference.symmetric.SymmetricDifference;

import de.thm.commonui.util.UIUtil;
import de.thm.evolvedb.graph.language.Language;
import de.thm.evolvedb.graph.presentation.GraphEditorPlugin;
import de.thm.mdde.commonui.exception.handler.ErrorHandler;

public class GraphDifferenceBuilderWizard extends Wizard implements INewWizard {

	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays
			.asList(GraphEditorPlugin.INSTANCE.getString("_UI_GraphEditorFilenameExtensions").split("\\s*,\\s*")));

	private IStructuredSelection selection;

	private MddeDifferenceBuilderNewFilePage builderNewFilePage;
	private MddeDifferenceBuilderController controller;

	private MddeDifferenceBuilderInputModelPage inputModelPage;

	private DifferenceType differenceType;

	private MddeDifferenceBuilderMatchingPage matchingPage;

	private MddeDifferenceBuilderMatchingPageLabel matchingPage3;

	private MddeDifferenceBuilderMatchingPageEdgeType edgeTypePage;
	private MddeDifferenceBuilderMatchingPageNodeType nodeTypePage;

	private WizardPage matchingPage2;

	private ProgressMonitorDialog dialog;

	private GraphDifferenceBuilderWizard() {
		super();
	}

	public GraphDifferenceBuilderWizard(InputModels inputModels, DifferenceType differenceType) {
		this();
		this.differenceType = differenceType;
		controller = new MddeDifferenceBuilderController(inputModels);
		setWindowTitle("New Symmetric Difference Wizard");
		setHelpAvailable(false);

	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("New Symmetric Difference Wizard");

		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(GraphEditorPlugin.INSTANCE.getImage("full/wizban/NewGraph")));
		setHelpAvailable(false);

	}

	@Override
	public boolean performFinish() {

		// Remember the file.
		//
		// final IFile modelFile = getModelFile();
		final IFile modelFile = builderNewFilePage.getModelContainer();
		final IFile migrationModelFile = builderNewFilePage.getMigreationModelFile();
		boolean createMigrationFile = builderNewFilePage.isCreateModelSelected();
		String filename = builderNewFilePage.getFileName();
		String migrationFileName = builderNewFilePage.getMigrationFileName();

		Job job = Job.create("Create Matching...", (ICoreRunnable) monitor -> {

//			getShell().getDisplay().asyncExec(new Runnable() {
//
//				public void run() {
//					dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
////						dialog.setCancelable(true);
////						dialog.setExceptionHandler(new IExceptionHandler() {
////							
////							@Override
////							public void handleException(Throwable t) {
////								dialog.close();
////								
////							}
////						});
//					dialog.open();
//				}
//			});

			try {

				// Do the work within an operation.
				//
				WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
					@Override
					protected void execute(IProgressMonitor progressMonitor) {
						try {

							// Get the URI of the model file.
							//
							URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

							SymmetricDifference symmetricDifference = null;

							if (differenceType.equals(DifferenceType.TECHNICALDIFFERENCE)) {
								symmetricDifference = controller.createTechnicalDifference();
							} else if (differenceType.equals(DifferenceType.LIFTEDDIFFERENCE)) {
								symmetricDifference = controller.createLiftedDifference();
							}

							// Add the initial model object to the contents.

							if (symmetricDifference != null) {
								controller.persistSymmetricDifference(symmetricDifference, fileURI, filename);
							}

						} catch (InvalidModelException | NoCorrespondencesException exception) {
							GraphEditorPlugin.INSTANCE.log(exception);
							ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
									"An error occured while matching the models!", getShell(), "Error", exception);
							exception.printStackTrace();
							GraphEditorPlugin.INSTANCE.log(exception);

							((WizardDialog) getContainer()).close();
						} finally {
							progressMonitor.done();
						}

					}
				};

				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						try {

							dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
							dialog.open();

							dialog.run(true, true, operation);

							if (dialog != null)
								dialog.close();
							if (!createMigrationFile)
								((WizardDialog) getContainer()).close();

						} catch (InvocationTargetException | InterruptedException exception) {
							GraphEditorPlugin.INSTANCE.log(exception);
							ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
									"An error occured while matching the models!", getShell(), "Error", exception);
							exception.printStackTrace();
							GraphEditorPlugin.INSTANCE.log(exception);
							((WizardDialog) getContainer()).close();
						}
					}
				});

				if (createMigrationFile) {
					WorkspaceModifyOperation operation2 = new WorkspaceModifyOperation() {
						@Override
						protected void execute(IProgressMonitor progressMonitor) {
							try {
								URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
//								MigrationApi.createMigrationModel(fileURI.toString(), modelFile,
//										filename, migrationFileName);

							} catch (Exception e) {
								ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
										"An error occured while creating the model!", getShell(), "Error", e);
								e.printStackTrace();
								GraphEditorPlugin.INSTANCE.log(e);
								((WizardDialog) getContainer()).close();
							} finally {
								progressMonitor.done();
							}
						}
					};
					Display.getDefault().asyncExec(new Runnable() {

						public void run() {
							try {
								dialog.run(true, true, operation2);

								// Select the new file resource in the current view.
								//
								IWorkbenchWindow workbenchWindow = UIUtil.getActiveWindow();
								IWorkbenchPage page = workbenchWindow.getActivePage();
								final IWorkbenchPart activePart = page.getActivePart();
								if (activePart instanceof ISetSelectionTarget) {
									// Duplicate code because variable has to be final
									if (createMigrationFile) {
										final ISelection targetSelection = new StructuredSelection(migrationModelFile);
										Display.getDefault().asyncExec(new Runnable() {
											@Override
											public void run() {
												((ISetSelectionTarget) activePart).selectReveal(targetSelection);
											}
										});
									} else {
										final ISelection targetSelection = new StructuredSelection(modelFile);
										Display.getDefault().asyncExec(new Runnable() {
											@Override
											public void run() {
												((ISetSelectionTarget) activePart).selectReveal(targetSelection);
											}
										});
									}
								}

								// Refresh the project
								modelFile.getProject().refreshLocal(IResource.DEPTH_INFINITE,
										new NullProgressMonitor());

							} catch (InvocationTargetException | InterruptedException e) {
								GraphEditorPlugin.INSTANCE.log(e);
								e.printStackTrace();
							} catch (CoreException e) {
								GraphEditorPlugin.INSTANCE.log(e);
								e.printStackTrace();
							}

							if (dialog != null)
								dialog.close();
							// ((WizardDialog) getContainer()).close();

						}

					});

				}

			} catch (Exception exception) {
				GraphEditorPlugin.INSTANCE.log(exception);
				ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
						"An error occured while creating the model!", getShell(), "Error", exception);
				exception.printStackTrace();
				GraphEditorPlugin.INSTANCE.log(exception);

			}

//			getShell().getDisplay().asyncExec(new Runnable() {
//
//				public void run() {
//					if (dialog != null)
//						dialog.close();
//				}
//			});

		});
		job.schedule();

		return true;

	}

	/**
	 * Get the file from the page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IFile getModelFile() {
		return builderNewFilePage.getModelFile();
	}

	@Override
	public boolean canFinish() {
		return builderNewFilePage.isPageComplete();
	}

	@Override
	public void addPages() {
		// first page
		inputModelPage = new MddeDifferenceBuilderInputModelPage(Language.WIZARD_COMPARE_MODELS, controller);
		inputModelPage.setTitle(Language.WIZARD_MODEL_COMPARISON);
		inputModelPage.setDescription(Language.WIZARD_COMPARE_DIRECTION);
		addPage(inputModelPage);

		// second page
		matchingPage = new MddeDifferenceBuilderMatchingPage(Language.WIZARD_COMPARE_MODELS, controller);
		matchingPage.setTitle(Language.WIZARD_MODEL_COMPARISON);
		matchingPage.setDescription(Language.WIZARD_COMPARE_DIRECTION);
		addPage(matchingPage);

		// third page
		matchingPage3 = new MddeDifferenceBuilderMatchingPageLabel(Language.WIZARD_COMPARE_MODELS, controller);
		matchingPage3.setTitle(Language.WIZARD_MODEL_COMPARISON);
		matchingPage3.setDescription(Language.WIZARD_COMPARE_DIRECTION);
		addPage(matchingPage3);

		// fourth page
		matchingPage2 = new MddeDifferenceBuilderMatchingPage2(Language.WIZARD_COMPARE_MODELS, controller);
		matchingPage2.setTitle(Language.WIZARD_MODEL_COMPARISON);
		matchingPage2.setDescription(Language.WIZARD_COMPARE_DIRECTION);
		addPage(matchingPage2);

		// fith page
		edgeTypePage = new MddeDifferenceBuilderMatchingPageEdgeType(Language.WIZARD_COMPARE_MODELS, controller);
		edgeTypePage.setTitle(Language.WIZARD_MODEL_COMPARISON);
		edgeTypePage.setDescription(Language.WIZARD_COMPARE_DIRECTION);
		addPage(edgeTypePage);
		
		nodeTypePage = new MddeDifferenceBuilderMatchingPageNodeType(Language.WIZARD_COMPARE_MODELS, controller);
		nodeTypePage.setTitle(Language.WIZARD_MODEL_COMPARISON);
		nodeTypePage.setDescription(Language.WIZARD_COMPARE_DIRECTION);
		addPage(nodeTypePage);

		// Third page
		builderNewFilePage = new MddeDifferenceBuilderNewFilePage("Test", selection);
		addPage(builderNewFilePage);
		builderNewFilePage.setTitle(Language.WIZARD_SYMMETRIC_DIFFERENCE);
		builderNewFilePage.setDescription(Language.WIZARD_CREATE_SYMMETRIC_DIFFERENCE);
		
		
		

		// builderNewFilePage.setPageComplete(false);
	}

}
