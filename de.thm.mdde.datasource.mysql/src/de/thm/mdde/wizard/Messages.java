/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * 
 */
package de.thm.mdde.wizard;

import org.eclipse.osgi.util.NLS;

/**
 * @author Torben
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = Messages.class.getPackageName() + ".messages"; //$NON-NLS-1$
	public static String MddeDatabaseConnectionWizardPage_1_1;
	public static String MddeDatabaseConnectionWizardPage_1_11;
	public static String MddeDatabaseConnectionWizardPage_1_2;
	public static String MddeDatabaseConnectionWizardPage_1_6;
	public static String MddeDatabaseConnectionWizardPage_1_EXPORT_CONFIGURATION;
	public static String MddeDatabaseConnectionWizardPage_1_PRESELECT_SCHEMA;
	public static String MddeDatabaseConnectionWizardPage_1_SELECT_CONFIGURATION_TEXT;
	public static String MddeDatabaseConnectionWizardPage_1_Select_FILE;
	public static String MddeDatabaseConnectionWizardPage_1_SELECT_FILE;
	public static String MddeDatabaseConnectionWizardPage_1_SELECT_WORKSPACE_FILE;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
