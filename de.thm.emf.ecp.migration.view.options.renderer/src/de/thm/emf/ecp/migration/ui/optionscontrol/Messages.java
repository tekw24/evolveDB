/*******************************************************************************
 * Copyright (c) 2011-2022 EclipseSource Muenchen GmbH and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Torben - initial API and implementation
 ******************************************************************************/
package de.thm.emf.ecp.migration.ui.optionscontrol;

import org.eclipse.osgi.util.NLS;

/**
 * @author Torben
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "de.thm.emf.ecp.migration.ui.optionscontrol.messages"; //$NON-NLS-1$
	public static String ColumnOptionsRenderer_0;
	public static String ColumnOptionsRenderer_1;
	public static String ColumnOptionsRenderer_2;
	public static String ColumnOptionsRenderer_DATA_MIGRATE;
	public static String ColumnOptionsRenderer_NOT_NULL;
	public static String ColumnOptionsRenderer_SIZE_COMPATIBLE;
	public static String ColumnOptionsRenderer_TYPE_AND_SIZE_COMPATIBLE;
	public static String ColumnOptionsRenderer_TYPE_COMPATIBLE;
	public static String ColumnOptionsRenderer_UNIQUE_CONSTRAINT;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
