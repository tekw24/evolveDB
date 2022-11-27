package de.thm.mdde.language;

import org.eclipse.swt.widgets.Table;

public class Language {

	// Wizard anlegen
	public static final String WIZARD_USERNAME = "Username:";
	public static final String WIZARD_PASSWORD = "Passwort:";
	public static final String WIZARD_PORT = "Port:";
	public static final String WIZARD_HOST = "Host:";
	public static final String WIZARD_SCHEMA = "Schema:";
	public static final String WIZARD_TEST_CONNECTION = "Test connection";

	public static final String WIZARD_TEST_NOSCHEMA = "In der Datenbank befindet sich kein Schema!";
	
	
	public static final String WIZARD_IMPORT_PARSE_ERROR = "Die Konfigurationsdatei ist fehlerhaft und konnte nicht eingelesen werden!";
	public static final String WIZARD_IMPORT_CONFIG_ERROR = "Die Konfigurationsdatei konnte leider nicht importiert werden!";
	public static final String WIZARD_IMPORT_ERROR_HEADER = "Fehler!";

	// Page 3
	public static final String WIZARD_SINGLE_TABLE_INHERITANCE = "Single table inheritance is a way to emulate object-oriented inheritance in a relational database. "
			+ "When mapping from a database table to an object in an object-oriented language, a field in the database "
			+ "identifies what class in the hierarchy the object belongs to."
			+ "All fields of all the classes are stored in the same table, hence the name Single Table Inheritance. "
			+ "In Hibernate (Java) and Entity Framework this pattern is called Table-Per-Class-Hierarchy and Table-Per-Hierarchy (TPH) respectively"
			+ " and the column containing the class name is called the Discriminator column.";
	
	public static final String WIZARD_CONFIG = "Import an existing configuration file";
	public static final String WIZARD_BUTTON_IMPORT = "Import";
	public static final String WIZARD_SAVE_CONFIG = "Save Settings as Config";
	
	public static final String WIZARD_ORM_TOOL = "Has the schema been created with an ORM tool?";
	public static final String YES = "Yes";
	public static final String No = "No";
	public static final String WIZARD_COMPARE_MODELS = "Compare models with each other";
	public static final String WIZARD_COMPARE_DIRECTION = "Compare two versions of the same model";

}
