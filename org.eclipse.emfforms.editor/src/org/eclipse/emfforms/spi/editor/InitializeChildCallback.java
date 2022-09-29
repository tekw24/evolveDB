/*******************************************************************************
 * Copyright (c) 2011-2015 EclipseSource Muenchen GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Clemens Elflein - initial API and implementation
 ******************************************************************************/
package org.eclipse.emfforms.spi.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.emf.ecp.view.spi.model.VViewModelProperties;
import org.eclipse.emf.ecp.view.spi.provider.ViewProviderHelper;
import org.eclipse.emfforms.internal.editor.ui.CreateDialog;
import org.eclipse.emfforms.spi.swt.treemasterdetail.util.CreateElementCallback;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

/**
 * This CreateElementCallback display a CreateDialog to the user that allows setting initial Values for the newly
 * created element.
 *
 * @author Clemens Elflein
 */
public class InitializeChildCallback implements CreateElementCallback {

	@Override
	public void initElement(EObject parent, EReference reference, EObject newObject) {
		/* no op */
	}

	@Override
	public boolean beforeCreateElement(Object newElement) {
		// We won't disturb creation of non EObjects
		if (!(newElement instanceof EObject)) {
			return true;
		}

		final VViewModelProperties properties = VViewFactory.eINSTANCE.createViewModelLoadingProperties();
		properties.addInheritableProperty("useOnModifyDatabinding", "true"); //$NON-NLS-1$ //$NON-NLS-2$
		final VView view = ViewProviderHelper.getView((EObject) newElement, properties);
		final boolean isViewEmpty = view == null ? true : view.getChildren().isEmpty();

		int result = Window.OK;

		if (!isViewEmpty) {
			final CreateDialog diag = new CreateDialog(Display.getCurrent().getActiveShell(), (EObject) newElement);
			result = diag.open();
		}

		return result == Window.OK;
	}

	@Override
	public void afterCreateElement(Object newElement) {
		/* no op */
	}

}
