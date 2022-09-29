/*******************************************************************************
 * Copyright (c) 2019 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Christian W. Damus - initial API and implementation
 ******************************************************************************/
package org.eclipse.emfforms.spi.editor;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emfforms.spi.core.services.reveal.EMFFormsRevealService;
import org.eclipse.ui.ide.IGotoMarker;

/**
 * Adapter for the {@link IGotoMarker} protocol that delegates to the
 * {@link EMFFormsRevealService}.
 *
 * @since 1.22
 */
public class GotoMarkerAdapter implements IGotoMarker {

	private final MarkerHelper helper = new EditUIMarkerHelper();

	private final ViewModelContext context;
	private final EditingDomain editingDomain;

	/**
	 * Initializes me.
	 *
	 * @param context the editor's view model context
	 * @param editingDomain the eeditor's editing domain
	 */
	public GotoMarkerAdapter(ViewModelContext context, EditingDomain editingDomain) {
		super();

		this.context = context;
		this.editingDomain = editingDomain;
	}

	@Override
	public void gotoMarker(IMarker marker) {
		final List<?> targets = helper.getTargetObjects(editingDomain, marker);
		final EObject object = getEObject(targets);

		if (object != null) {
			final EMFFormsRevealService reveal = context.getService(EMFFormsRevealService.class);
			if (reveal != null) {
				final EStructuralFeature feature = getEStructuralFeature(targets);
				if (feature != null) {
					reveal.reveal(object, feature);
				} else {
					reveal.reveal(object);
				}
			}
		}
	}

	/**
	 * Extract a domain model element in our editor from a marker's {@code targets}.
	 *
	 * @param targets the target objects resolved from a marker to navigate
	 * @return the domain model object to reveal
	 */
	protected EObject getEObject(List<?> targets) {
		if (!targets.isEmpty()) {
			final Object first = targets.get(0);
			if (first instanceof EObject) {
				return (EObject) first;
			}
			final Object unwrapped = AdapterFactoryEditingDomain.unwrap(first);
			if (unwrapped instanceof EObject) {
				return (EObject) unwrapped;
			}
		}

		return null;
	}

	/**
	 * Extract a domain model feature in our editor from a marker's {@code targets}.
	 *
	 * @param targets the target objects resolved from a marker to navigate
	 * @return the feature of the domain model object to reveal, or {@code null} if none
	 */
	protected EStructuralFeature getEStructuralFeature(List<?> targets) {
		if (targets.size() > 1) {
			for (final Iterator<?> iter = targets.listIterator(1); iter.hasNext();) {
				final Object next = iter.next();
				if (next instanceof EStructuralFeature) {
					return (EStructuralFeature) next;
				}
			}
		}

		return null;
	}

}
