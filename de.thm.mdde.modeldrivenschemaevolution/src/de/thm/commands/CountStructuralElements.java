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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.thm.evolvedb.statistics.CountCorrespondences;
import de.thm.mdde.commonui.exception.handler.ErrorHandler;
import de.thm.mdde.commonui.model.validation.ModelValidation;
import de.thm.mdde.ui.MDDECodeGenerationWizard;

public class CountStructuralElements extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		String content = "";

		IProject project = null;
		IFile iFile = null;
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);

		List<Object> selectionList = selection.toList();

		for (Object firstElement : selectionList) {

			if (firstElement instanceof IFile) {
				// get the selected ecore file
				IFile fileEcore = (IFile) firstElement;
				
				if(project == null) {
					project = fileEcore.getProject();
					iFile = fileEcore;
				}
				
			

				
				// fileEcore.getLocation().

				// Load the Ressources and get the model URIS
				ResourceSet resourceSet = new ResourceSetImpl();
				// load the ecore file
				URI uriEcoreFile = URI.createFileURI(fileEcore.getRawLocation().toString());
				Resource resModelFile = resourceSet.createResource(uriEcoreFile);
				try {
					resModelFile.load(Collections.emptyMap());
					// Validate the resource
					boolean result = ModelValidation.validateModel(resModelFile, "ModelDrivenSchemaEvolution",
							fileEcore);
					if (!result) {
						return null;
					}

					CountCorrespondences count = new CountCorrespondences();
					
					content += "Dateiname: " + fileEcore.getName() + " \n";
					
					content += count.countStructuralElements(resModelFile);
					

				} catch (IOException e) {
					Shell activeShell = HandlerUtil.getActiveShell(event);
					ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
							"An error occured while creating the statistics!", activeShell, "Error", e);
					e.printStackTrace();
				}

	

			}

			
		}
		
		try {
			createTextFileInSameDirectory(iFile, content);
		} catch (CoreException e) {
			Shell activeShell = HandlerUtil.getActiveShell(event);
			ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
					"An error occured while creating the statistics!", activeShell, "Error", e);
		}

		return null;

	}

	/**
	 * Creates a file of the given content in the given folder. If the folder does
	 * not exist, it will be created.
	 * 
	 * @throws CoreException
	 */
	private void createFile(IFolder folder, IFile iFile, boolean overrideFile, CharSequence content)
			throws CoreException {

		if (!folder.exists()) {
			folder.create(true, true, null);
		}

		if (overrideFile == false && iFile.exists()) {
			return;
		}
		if (!iFile.exists()) {
			iFile.create(null, true, null);
		}

		byte[] bytes;

		bytes = content.toString().getBytes();

		// save the file
		InputStream source = new ByteArrayInputStream(bytes);
		iFile.setContents(source, IResource.FORCE, null);
	}

	public void createTextFileInSameDirectory(IFile originalFile, String content) throws CoreException {
		// 1. Hol das übergeordnete Verzeichnis (Container)
		IContainer parent = originalFile.getParent();

		// 2. Definiere den Namen der neuen Datei
		String newFileName = "statistics.txt";

		// 3. Erstelle ein neues IFile im gleichen Verzeichnis
		IFile newFile = parent.getFile(new Path(newFileName));

		// 4. Inhalt der neuen Datei (optional)
	
		ByteArrayInputStream source = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));

		// 5. Datei anlegen (wenn sie nicht existiert)
		if (!newFile.exists()) {
			newFile.create(source, true, null); // true = überschreiben erlaubt
		} else {
			newFile.setContents(source, true, false, null); // Inhalt aktualisieren
		}
	}
}
