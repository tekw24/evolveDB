package de.thm.evolvedb.datasource.messages;

import org.eclipse.osgi.util.NLS;


public class Messages extends NLS{
	
	private static final String BUNDLE_NAME = Messages.class.getPackageName() + ".messages"; //$NON-NLS-1$
	public static String Neo4jDatabaseConnectionWizardPage_1_1;
	public static String Neo4jDatabaseConnectionWizardPage_1_11;
	public static String Neo4jDatabaseConnectionWizardPage_1_2;
	public static String Neo4jDatabaseConnectionWizardPage_1_6;
	public static String Neo4jDatabaseConnectionWizardPage_1_EXPORT_CONFIGURATION;
	public static String Neo4jDatabaseConnectionWizardPage_1_PRESELECT_SCHEMA;
	public static String Neo4jDatabaseConnectionWizardPage_1_SELECT_CONFIGURATION_TEXT;
	public static String Neo4jDatabaseConnectionWizardPage_1_Select_FILE;
	public static String Neo4jDatabaseConnectionWizardPage_1_SELECT_FILE;
	public static String Neo4jDatabaseConnectionWizardPage_1_SELECT_WORKSPACE_FILE;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}
