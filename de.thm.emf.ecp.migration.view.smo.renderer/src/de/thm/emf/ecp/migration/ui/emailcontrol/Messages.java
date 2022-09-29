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
package de.thm.emf.ecp.migration.ui.emailcontrol;

import org.eclipse.osgi.util.NLS;

/**
 * @author Torben
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "de.thm.emf.ecp.migration.ui.emailcontrol.messages"; //$NON-NLS-1$
	public static String SemanticChangeSetRenderer_AutoIncrement;
	public static String SemanticChangeSetRenderer_Column;
	public static String SemanticChangeSetRenderer_ColumnDES;
	public static String SemanticChangeSetRenderer_COLUMN_MODELA;
	public static String SemanticChangeSetRenderer_COLUMN_MODELB;
	public static String SemanticChangeSetRenderer_ColumnName;
	public static String SemanticChangeSetRenderer_ColumnType;
	public static String SemanticChangeSetRenderer_CreateTable;
	public static String SemanticChangeSetRenderer_DataType;
	public static String SemanticChangeSetRenderer_DefaultValue;
	public static String SemanticChangeSetRenderer_descriptionSetColumDefaultValue;
	public static String SemanticChangeSetRenderer_descriptionColumnSize;
	public static String SemanticChangeSetRenderer_descriptionColumnSizeDate;
	public static String SemanticChangeSetRenderer_descriptionColumnSizeText;
	public static String SemanticChangeSetRenderer_descriptionColumnSizeDecimal;
	public static String SemanticChangeSetRenderer_descriptionMakeColumnUnique;
	public static String SemanticChangeSetRenderer_descriptionRemoveColumnUnique;
	public static String SemanticChangeSetRenderer_New_Table;

	public static String SemanticChangeSetRenderer_NEW_SIZE;
	public static String SemanticChangeSetRenderer_NEW_TYPE;
	public static String SemanticChangeSetRenderer_newOBJ;
	public static String SemanticChangeSetRenderer_null;
	public static String SemanticChangeSetRenderer_OLD_FOREIGNKEY;
	public static String SemanticChangeSetRenderer_OLD_SIZE;
	public static String SemanticChangeSetRenderer_OLD_TYPE;
	public static String SemanticChangeSetRenderer_Old_Table;
	public static String SemanticChangeSetRenderer_Primary;
	public static String SemanticChangeSetRenderer_Ref_Key;
	public static String SemanticChangeSetRenderer_Ref_Table;
	public static String SemanticChangeSetRenderer_Removed_Elements;
	public static String SemanticChangeSetRenderer_Size;
	public static String SemanticChangeSetRenderer_Table;
	public static String SemanticChangeSetRenderer_Unique;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
