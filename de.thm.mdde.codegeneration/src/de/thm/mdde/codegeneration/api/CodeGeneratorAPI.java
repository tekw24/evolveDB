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
