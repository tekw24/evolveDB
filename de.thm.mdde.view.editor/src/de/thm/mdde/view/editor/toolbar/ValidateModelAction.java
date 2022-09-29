package de.thm.mdde.view.editor.toolbar;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emfforms.spi.editor.messages.Messages;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
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
