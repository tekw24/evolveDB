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
package de.thm.mdde.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import de.thm.evolvedb.mdde.presentation.MddeEditorPlugin;

public class MDDECodeGenerationWizard extends Wizard implements INewWizard{

	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(
			Arrays.asList("sql"));
	
	private IWorkbench workbench;
	private IStructuredSelection selection;
	
	private MDDECodeGenerationController controller;
	private MDDECodeGenerationWizardPage_1 mddeCodeGenerationWizardPage_1;
	private MDDECodeGenerationWizardPage_2 mddeCodeGenerationWizardPage_2;

	private Resource resModelFile;
	
	public MDDECodeGenerationWizard(Resource resModelFile) {
		super();
		this.resModelFile = resModelFile;
		if(controller != null)
			controller.setResModelFile(resModelFile);
		
		setWindowTitle("SQL Generation Wizard");
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(MddeEditorPlugin.INSTANCE.getImage("full/wizban/NewMdde")));
		
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		
		setWindowTitle("SQL Generation Wizard");
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(MddeEditorPlugin.INSTANCE.getImage("full/wizban/NewMdde")));
		
	}

	@Override
	public boolean performFinish() {
		try {
			// Remember the file.
			//
			final IFile modelFile = getFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
						
						
						controller.generateMigrations(getFile(), mddeCodeGenerationWizardPage_2.getContainerFolder());
						

						// Add the initial model object to the contents.

						

//						// Save the contents of the resource to the file system.

//						Map<Object, Object> options = new HashMap<Object, Object>();
//						options.put(XMLResource.OPTION_ENCODING, mddeCodeGenerationWizardPage_2.getEncoding());
//						resource.save(options);


					} catch (Exception exception) {
						MddeEditorPlugin.INSTANCE.log(exception);
						MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", exception.getLocalizedMessage());
					} finally {
						progressMonitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);
		
			return true;
		} catch (Exception exception) {
			MddeEditorPlugin.INSTANCE.log(exception);
			return false;
		}
	}
	
	@Override
	public boolean canFinish() {
		return mddeCodeGenerationWizardPage_1.isPageComplete() && mddeCodeGenerationWizardPage_2.isPageComplete();
	}
	
	@Override
	public void addPages() {
		controller = new MDDECodeGenerationController(resModelFile);
		mddeCodeGenerationWizardPage_1 = new MDDECodeGenerationWizardPage_1("Erste Seite", "Select Generator",null, controller);
		
		
		addPage(mddeCodeGenerationWizardPage_1);
		
		// Try and get the resource selection to determine a current directory for the
		// file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource) selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					// connectionWizardPage_1.setContainerFullPath(selectedResource.getFullPath());
					// //TODO

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = MddeEditorPlugin.INSTANCE
							.getString("_UI_MddeEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					// connectionWizardPage_1.setFileName(modelFilename); //TODO
				}
			}
			
		}else
			selection = StructuredSelection.EMPTY;
		
		mddeCodeGenerationWizardPage_2 = new MDDECodeGenerationWizardPage_2("Choose file location", selection, controller, "Select directory and set file name");
		addPage(mddeCodeGenerationWizardPage_2);
		
		
		super.addPages();
	}
	
	
	
	/**
	 * Get the file from the page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IFile getFile() {
		return mddeCodeGenerationWizardPage_2.getFile();
	}
	

}
