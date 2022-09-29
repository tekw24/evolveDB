/*******************************************************************************
 * Copyright (c) 2011-2016 EclipseSource Muenchen GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Johannes Faltermeier - initial API and implementation
 ******************************************************************************/
package org.eclipse.emfforms.spi.editor.handler;

import java.util.List;

/**
 * This service will be invoked when the delete shortcut was pressed in the
 * {@link org.eclipse.emfforms.spi.editor.GenericEditor GenericEditor}.
 *
 * @author Johannes Faltermeier
 * @since 1.10
 */
public interface DeleteShortCutHandler {

	/**
	 * Performs the deletion.
	 *
	 * @param toDelete the objects to delete
	 */
	void handleDeleteShortcut(List<Object> toDelete);
}
