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
package de.thm.mdde.codegeneration.api;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import de.thm.mdde.commonui.exception.handler.ErrorHandler;
import de.thm.mdde.ui.MDDECodeGenerationWizard;

public class CodeGeneratorAPI {

	public static void openCodeGenerationWizard(ResourceSet resourceSet, Shell activeShell) {

		// load the ecore file
		//TODO Is the current active model always first?
		try {
			for(Resource resource : resourceSet.getResources()) {
				resource.load(Collections.emptyMap());
				
				WizardDialog dialog = new WizardDialog(activeShell, new MDDECodeGenerationWizard(resource));
				dialog.open();
				return;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
					"An error occured while loading the resource!", activeShell, "Error", e);
			return;
		}

		// IWizard wizard = new MddeDatabaseConnectionModelWizard();
		

	}

}
