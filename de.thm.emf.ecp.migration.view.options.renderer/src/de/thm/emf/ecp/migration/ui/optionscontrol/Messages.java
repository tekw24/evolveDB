/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
