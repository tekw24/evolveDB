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
package de.thm.commands;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.symmetric2migration.files.Symmetric2migration;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.thm.mdde.commonui.exception.handler.ErrorHandler;
import de.thm.mdde.commonui.model.validation.ModelValidation;
import de.thm.xtend.ResourceFilter.MigrationModelTransformation;
import de.thm.xtend.ResourceFilter.ResourceFilter;

public class CreateMigrationModelHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IProject project = null;
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		Object firstElement = selection.getFirstElement();
		System.out.println(firstElement.getClass());
		if (firstElement instanceof IFile) {
			// get the selected ecore file
			IFile fileEcore = (IFile) selection.getFirstElement();

			project = fileEcore.getProject();

			// Load the Ressources and get the model URIS
			ResourceSet resourceSet = new ResourceSetImpl();
			// load the ecore file
			URI uriEcoreFile = URI.createFileURI(fileEcore.getRawLocation().toString());
			Resource resModelFile = resourceSet.createResource(uriEcoreFile);
			String uri = "";
			try {
				resModelFile.load(Collections.emptyMap());
				// Validate the resource
				boolean result = ModelValidation.validateModel(resModelFile, "ModelDrivenSchemaEvolution", fileEcore);
				if (!result) {
					return null;
				}

				ResourceFilter a = new ResourceFilter();
				uri = a.filterForSymmetricDifference(resModelFile);

			} catch (IOException e) {
				Shell activeShell = HandlerUtil.getActiveShell(event);
				ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
						"An error occured while creating the model!", activeShell, "Error", e);
				e.printStackTrace();
			}

//			Shell activeShell = HandlerUtil.getActiveShell(event);
			// IWizard wizard = new MddeDatabaseConnectionModelWizard();
//			WizardDialog dialog = new WizardDialog(activeShell, new MDDECodeGenerationWizard(resModelFile));
//			
//			dialog.open();

			try {

				int characters = fileEcore.getFileExtension().toString().length();
				String path = fileEcore.getLocation().toString();
				String migrationPath = path.substring(0, path.length() - characters);
				migrationPath += "migration";
				// String outPath = "file:///"+project.getLocation().toOSString()
				// +"\\generated\\test.migration";
				// String inPath = "file:///"+fileEcore.getLocation().toOSString();
				URI inPlatformUri = URI.createFileURI(fileEcore.getLocation().toOSString());
				// URI outPathPlatformUri = URI.createFileURI(project.getLocation().toString() +
				// "/generated/test.migration");
				URI outPathPlatformUri = URI.createFileURI(migrationPath);

				Symmetric2migration symmetric2migration = new Symmetric2migration();
				// symmetric2migration.runTransformation(inPath, outPath , uri, new
				// NullProgressMonitor() );

				symmetric2migration.runTransformation(inPlatformUri.toString(), outPathPlatformUri.toString(), uri,
						new NullProgressMonitor());

				// Try to load new model for the xtend refinement
				// Load the Ressources and get the model URIS
				ResourceSet resourceSetXtend = new ResourceSetImpl();
				// load the ecore file
				Resource resXtendModelFile = resourceSetXtend.createResource(outPathPlatformUri);
				Resource resSymmetricModel = resourceSetXtend.createResource(uriEcoreFile);
				resSymmetricModel.load(Collections.emptyMap());
				resXtendModelFile.load(Collections.emptyMap());

				MigrationModelTransformation migrationModelTransformation = new MigrationModelTransformation();
				migrationModelTransformation.runMigrtaionTransformation(resXtendModelFile, resSymmetricModel);
				resXtendModelFile.save(Collections.emptyMap());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				Shell activeShell = HandlerUtil.getActiveShell(event);
				ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
						"An error occured while creating the model!", activeShell, "Error", e);
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (project != null) {
			// Refresh the project
			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}

}
