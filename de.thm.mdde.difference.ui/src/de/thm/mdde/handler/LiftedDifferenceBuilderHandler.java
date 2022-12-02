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
package de.thm.mdde.handler;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.emf.input.InputModels;

import de.thm.commonui.util.UIUtil;
import de.thm.mdde.commonui.exception.handler.ErrorHandler;
import de.thm.mdde.commonui.model.validation.ModelValidation;
import de.thm.mdde.differenceBuilderWizard.DifferenceType;
import de.thm.mdde.differenceBuilderWizard.MddeDifferenceBuilderWizard;

public class LiftedDifferenceBuilderHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
		Shell activeShell = HandlerUtil.getActiveShell(event);
		boolean result = true;
		for (Object object : selection.toList()) {

			if (object instanceof IFile) {
				// get the selected ecore file
				IFile fileEcore = (IFile) object;

				ResourceSet resourceSet = new ResourceSetImpl();
				// load the ecore file
				URI uriEcoreFile = URI.createFileURI(fileEcore.getRawLocation().toString());
				Resource resModelFile = resourceSet.createResource(uriEcoreFile);
				
				try {
					resModelFile.load(Collections.emptyMap());
				} catch (IOException e) {
					e.printStackTrace();
					ErrorHandler.openErrorDialogWithStatus("de.thm.mdde.difference.ui",
							"An error occured while loading the resource!", activeShell, "Error", e);
				}

				result = (result && ModelValidation.validateModel(resModelFile, "de.thm.mdde.difference.ui", fileEcore, false));

			}
		}

		if (result) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Validation",
					"Validation successfull!");
			Display.getDefault().asyncExec(() -> {
				InputModels inputModels = InputModels.builder().addModels(selection).assertNumModels(2)
						.assertSameDocumentType(true).build();
				new WizardDialog(UIUtil.getActiveShell(),
						new MddeDifferenceBuilderWizard(inputModels, DifferenceType.LIFTEDDIFFERENCE)).open();
			});
		}else {
			ErrorHandler.openErrorDialog("The selected resources contain errors!", activeShell, "Validation error!");
		}
		return null;

	}
}
