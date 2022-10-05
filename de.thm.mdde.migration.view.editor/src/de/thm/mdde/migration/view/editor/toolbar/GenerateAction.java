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
