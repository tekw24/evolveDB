/*******************************************************************************
 * Copyright (c) 2011-2013 EclipseSource Muenchen GmbH and others.
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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionProvider;

/**
 * The Interface IToolbarAction allows the creation of ToolBar actions for the Generic Editor.
 */
public interface IToolbarAction {

	/**
	 * Returns the action to add to the toolbar.
	 *
	 * @param currentObject the currently edited object of the editor
	 * @param selectionProvider the selection provider
	 * @return the action
	 */
	Action getAction(Object currentObject, ISelectionProvider selectionProvider);

	/**
	 * @param object the currently edited object of the editor
	 * @return true, if the Action can be executed for the provided input
	 */
	boolean canExecute(Object object);
}
