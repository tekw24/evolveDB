/*******************************************************************************
 * Copyright (c) 2011-2018 EclipseSource Muenchen GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Eugen Neufeld - initial API and implementation
 ******************************************************************************/
package org.eclipse.emfforms.spi.editor;

import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * The GenericEditor sets the current EditingDomain.
 *
 * @author Eugen Neufeld
 * @since 1.19
 *
 */
public interface IEditingDomainAware {

	/**
	 * Called by the framework to set the EditingDomain.
	 *
	 * @param editingDomain The {@link EditingDomain} set by the framework
	 */
	void setEditingDomain(EditingDomain editingDomain);
}
