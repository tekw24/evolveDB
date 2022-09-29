package de.thm.commands;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.thm.mdde.commonui.exception.handler.ErrorHandler;
import de.thm.mdde.commonui.model.validation.ModelValidation;
import de.thm.mdde.ui.MDDECodeGenerationWizard;

public class GenerateSQLMigrations extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		System.out.println("Generate SQL Migrations");

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		Object firstElement = selection.getFirstElement();
		System.out.println(firstElement.getClass());
		if (firstElement instanceof IFile) {
			// get the selected ecore file
			IFile fileEcore = (IFile) selection.getFirstElement();

			IProject project = fileEcore.getProject();

			ResourceSet resourceSet = new ResourceSetImpl();
			// load the ecore file
			URI uriEcoreFile = URI.createFileURI(fileEcore.getRawLocation().toString());
			Resource resModelFile = resourceSet.createResource(uriEcoreFile);
			Shell activeShell = HandlerUtil.getActiveShell(event);
			try {
				resModelFile.load(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
				ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
						"An error occured while loading the resource!", activeShell, "Error", e);
			}

			
			boolean result = ModelValidation.validateModel(resModelFile, "ModelDrivenSchemaEvolution", fileEcore);
			if (result) {

				// IWizard wizard = new MddeDatabaseConnectionModelWizard();
				WizardDialog dialog = new WizardDialog(activeShell, new MDDECodeGenerationWizard(resModelFile));

				dialog.open();
			}

		}

		return null;
	}

}
