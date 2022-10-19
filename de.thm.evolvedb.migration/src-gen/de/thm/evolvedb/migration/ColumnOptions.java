/**
 */
package de.thm.evolvedb.migration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Column Options</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage#getColumnOptions()
 * @model
 * @generated
 */
public enum ColumnOptions implements Enumerator {
	/**
	 * The '<em><b>IGNORE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE_VALUE
	 * @generated
	 * @ordered
	 */
	IGNORE(0, "IGNORE", "No violating data"),

	/**
	 * The '<em><b>UPDATE ROW SET TO NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_ROW_SET_TO_NULL_VALUE
	 * @generated
	 * @ordered
	 */
	UPDATE_ROW_SET_TO_NULL(1, "UPDATE_ROW_SET_TO_NULL", "Set violating rows to null"),

	/**
	 * The '<em><b>UPDATE ROW SET TO DEFAULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_ROW_SET_TO_DEFAULT_VALUE
	 * @generated
	 * @ordered
	 */
	UPDATE_ROW_SET_TO_DEFAULT(2, "UPDATE_ROW_SET_TO_DEFAULT", "Set violating rows to the default value"),

	/**
	 * The '<em><b>DELETE ROW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_ROW_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_ROW(3, "DELETE_ROW", "Delete violating rows"),

	/**
	 * The '<em><b>UPDATE COLUMN SET TO NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_COLUMN_SET_TO_NULL_VALUE
	 * @generated
	 * @ordered
	 */
	UPDATE_COLUMN_SET_TO_NULL(5, "UPDATE_COLUMN_SET_TO_NULL", "Set column to null"),

	/**
	 * The '<em><b>UPDATE COLUMN SET TO DEFAULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_COLUMN_SET_TO_DEFAULT_VALUE
	 * @generated
	 * @ordered
	 */
	UPDATE_COLUMN_SET_TO_DEFAULT(6, "UPDATE_COLUMN_SET_TO_DEFAULT", "Set column to default value"),

	/**
	 * The '<em><b>MIGRATE DATA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIGRATE_DATA_VALUE
	 * @generated
	 * @ordered
	 */
	MIGRATE_DATA(7, "MIGRATE_DATA", "Migrate data"),

	/**
	 * The '<em><b>DELETE DUBLICATES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_DUBLICATES_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_DUBLICATES(8, "DELETE_DUBLICATES", "Remove dublicates"),

	/**
	 * The '<em><b>IGNORE DUBLICATES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE_DUBLICATES_VALUE
	 * @generated
	 * @ordered
	 */
	IGNORE_DUBLICATES(9, "IGNORE_DUBLICATES", "IGNORE_DUBLICATES"), /**
	 * The '<em><b>SPECIFY CONDITION MANUALLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIFY_CONDITION_MANUALLY_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIFY_CONDITION_MANUALLY(10, "SPECIFY_CONDITION_MANUALLY", "Specify condition manually");

	/**
	 * The '<em><b>IGNORE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE
	 * @model literal="No violating data"
	 * @generated
	 * @ordered
	 */
	public static final int IGNORE_VALUE = 0;

	/**
	 * The '<em><b>UPDATE ROW SET TO NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_ROW_SET_TO_NULL
	 * @model literal="Set violating rows to null"
	 * @generated
	 * @ordered
	 */
	public static final int UPDATE_ROW_SET_TO_NULL_VALUE = 1;

	/**
	 * The '<em><b>UPDATE ROW SET TO DEFAULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_ROW_SET_TO_DEFAULT
	 * @model literal="Set violating rows to the default value"
	 * @generated
	 * @ordered
	 */
	public static final int UPDATE_ROW_SET_TO_DEFAULT_VALUE = 2;

	/**
	 * The '<em><b>DELETE ROW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_ROW
	 * @model literal="Delete violating rows"
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_ROW_VALUE = 3;

	/**
	 * The '<em><b>UPDATE COLUMN SET TO NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_COLUMN_SET_TO_NULL
	 * @model literal="Set column to null"
	 * @generated
	 * @ordered
	 */
	public static final int UPDATE_COLUMN_SET_TO_NULL_VALUE = 5;

	/**
	 * The '<em><b>UPDATE COLUMN SET TO DEFAULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_COLUMN_SET_TO_DEFAULT
	 * @model literal="Set column to default value"
	 * @generated
	 * @ordered
	 */
	public static final int UPDATE_COLUMN_SET_TO_DEFAULT_VALUE = 6;

	/**
	 * The '<em><b>MIGRATE DATA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIGRATE_DATA
	 * @model literal="Migrate data"
	 * @generated
	 * @ordered
	 */
	public static final int MIGRATE_DATA_VALUE = 7;

	/**
	 * The '<em><b>DELETE DUBLICATES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_DUBLICATES
	 * @model literal="Remove dublicates"
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_DUBLICATES_VALUE = 8;

	/**
	 * The '<em><b>IGNORE DUBLICATES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE_DUBLICATES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IGNORE_DUBLICATES_VALUE = 9;

	/**
	 * The '<em><b>SPECIFY CONDITION MANUALLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIFY_CONDITION_MANUALLY
	 * @model literal="Specify condition manually"
	 * @generated
	 * @ordered
	 */
	public static final int SPECIFY_CONDITION_MANUALLY_VALUE = 10;

	/**
	 * An array of all the '<em><b>Column Options</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ColumnOptions[] VALUES_ARRAY =
		new ColumnOptions[] {
			IGNORE,
			UPDATE_ROW_SET_TO_NULL,
			UPDATE_ROW_SET_TO_DEFAULT,
			DELETE_ROW,
			UPDATE_COLUMN_SET_TO_NULL,
			UPDATE_COLUMN_SET_TO_DEFAULT,
			MIGRATE_DATA,
			DELETE_DUBLICATES,
			IGNORE_DUBLICATES,
			SPECIFY_CONDITION_MANUALLY,
		};

	/**
	 * A public read-only list of all the '<em><b>Column Options</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ColumnOptions> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Column Options</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ColumnOptions get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ColumnOptions result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Column Options</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ColumnOptions getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ColumnOptions result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Column Options</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ColumnOptions get(int value) {
		switch (value) {
			case IGNORE_VALUE: return IGNORE;
			case UPDATE_ROW_SET_TO_NULL_VALUE: return UPDATE_ROW_SET_TO_NULL;
			case UPDATE_ROW_SET_TO_DEFAULT_VALUE: return UPDATE_ROW_SET_TO_DEFAULT;
			case DELETE_ROW_VALUE: return DELETE_ROW;
			case UPDATE_COLUMN_SET_TO_NULL_VALUE: return UPDATE_COLUMN_SET_TO_NULL;
			case UPDATE_COLUMN_SET_TO_DEFAULT_VALUE: return UPDATE_COLUMN_SET_TO_DEFAULT;
			case MIGRATE_DATA_VALUE: return MIGRATE_DATA;
			case DELETE_DUBLICATES_VALUE: return DELETE_DUBLICATES;
			case IGNORE_DUBLICATES_VALUE: return IGNORE_DUBLICATES;
			case SPECIFY_CONDITION_MANUALLY_VALUE: return SPECIFY_CONDITION_MANUALLY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ColumnOptions(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ColumnOptions
