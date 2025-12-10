package de.thm.commands;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.thm.evolvedb.statistics.CountCorrespondences;
import de.thm.evolvefb.openai.connector.OpenAIConnect;
import de.thm.mdde.commonui.exception.handler.ErrorHandler;
import de.thm.mdde.commonui.model.validation.ModelValidation;

public class ConnectToOpenAiApi extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		String content = "";

		IProject project = null;
		IFile iFile = null;
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);

		List<Object> selectionList = selection.toList();

		if (selectionList.size() < 2) {
			throw new IllegalArgumentException("At least two models must be selected!");
		}

		Resource firstResource = null;

		for (Object firstElement : selectionList) {

			if (firstElement instanceof IFile) {
				// get the selected ecore file
				IFile fileEcore = (IFile) firstElement;

				if (project == null) {
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

					if (firstResource == null)
						firstResource = resModelFile;
					else {
						
						
						
						OpenAIConnect openAiConnect = new OpenAIConnect();
						content += openAiConnect.compareModels(firstResource, resModelFile);
								
						System.out.println(content);

					}

				} catch (IOException e) {
					Shell activeShell = HandlerUtil.getActiveShell(event);
					ErrorHandler.openErrorDialogWithStatus("ModelDrivenSchemaEvolution",
							"An error occured while creating the statistics!", activeShell, "Error", e);
					e.printStackTrace();
				}

			}

		}

		

		return null;
	}

}
