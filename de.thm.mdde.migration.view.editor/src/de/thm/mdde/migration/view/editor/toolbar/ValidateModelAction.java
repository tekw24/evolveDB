package de.thm.mdde.migration.view.editor.toolbar;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.FrameworkUtil;

import de.thm.mdde.commonui.exception.handler.ErrorHandler;
import de.thm.mdde.commonui.model.validation.ModelValidation;

public class ValidateModelAction extends Action {

	private final Object currentObject;

	/**
	 * Creates a new LoadEcoreAction.
	 *
	 * @param currentObject the currently loaded object in the Editor (should be
	 *                      ResourceSet)
	 */
	public ValidateModelAction(Object currentObject) {
		this(currentObject, "Validate Model");
	}

	/**
	 * Creates a new LoadEcoreAction.
	 *
	 * @param currentObject the currently loaded object in the Editor (should be
	 *                      ResourceSet)
	 * @param actionName    The name of the action
	 */
	public ValidateModelAction(Object currentObject, String actionName) {
		super(actionName);
		setImageDescriptor(ImageDescriptor.createFromURL(
				FrameworkUtil.getBundle(this.getClass()).getResource("icons/full/obj16/validate16.png"))); //$NON-NLS-1$
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
			ModelValidation.validateModel((ResourceSet) currentObject, "de.thm.mdde.migration.view.editor");
		else {
			MessageDialog.openError(Display.getDefault().getActiveShell(), "Error Occured", "The selected element is not a resource!");
		}
	}

}
