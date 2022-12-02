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
package de.thm.mdde.migration.view.editor.toolbar;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.FrameworkUtil;

import de.thm.mdde.codegeneration.api.CodeGeneratorAPI;
import de.thm.mdde.commonui.model.validation.ModelValidation;

public class GenerateAction extends Action{
	
	private Object currentObject;

	/**
	 * Creates a new GenerateAction.
	 *
	 * @param currentObject the currently loaded object in the Editor (should be
	 *                      ResourceSet)
	 */
	public GenerateAction(Object currentObject) {
		this(currentObject, "Generate Migration");
	}
	
	/**
	 * Creates a new GenerateAction.
	 *
	 * @param currentObject the currently loaded object in the Editor (should be
	 *                      ResourceSet)
	 * @param actionName    The name of the action
	 */
	public GenerateAction(Object currentObject, String actionName) {
		super(actionName);
		setImageDescriptor(ImageDescriptor.createFromURL(
				FrameworkUtil.getBundle(this.getClass()).getResource("icons/full/obj16/generated16.png"))); //$NON-NLS-1$
		this.currentObject = currentObject;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		if (currentObject != null && currentObject instanceof ResourceSet)
			
			if(ModelValidation.validateModel((ResourceSet) currentObject, "de.thm.mdde.migration.view.editor")) {
				CodeGeneratorAPI.openCodeGenerationWizard((ResourceSet)currentObject, Display.getDefault().getActiveShell());
			}else {
				MessageDialog.openError(Display.getDefault().getActiveShell(), "Validation failed!", "The selected element contains errors!");
			}
		else {
			MessageDialog.openError(Display.getDefault().getActiveShell(), "Error Occured", "The selected element is not a resource!");
		}
	}

}
