/**
 */
package de.thm.evolvedb.migration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Resolvable Operator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage#getResolvableOperatorType()
 * @model
 * @generated
 */
public enum ResolvableOperatorType implements Enumerator {
	/**
	 * The '<em><b>CREATE TABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_TABLE_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE_TABLE(0, "CREATE_TABLE", "CREATE_TABLE"),

	/**
	 * The '<em><b>RENAME TABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RENAME_TABLE_VALUE
	 * @generated
	 * @ordered
	 */
	RENAME_TABLE(1, "RENAME_TABLE", "RENAME_TABLE"),

	/**
	 * The '<em><b>CREATE COLUMN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_COLUMN_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE_COLUMN(2, "CREATE_COLUMN", "CREATE_COLUMN"),

	/**
	 * The '<em><b>CREATE PRIMARY KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_PRIMARY_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE_PRIMARY_KEY(3, "CREATE_PRIMARY_KEY", "CREATE_PRIMARY_KEY"),

	/**
	 * The '<em><b>CREATE FOREIGN KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_FOREIGN_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE_FOREIGN_KEY(4, "CREATE_FOREIGN_KEY", "CREATE_FOREIGN_KEY"),

	/**
	 * The '<em><b>SET COLUMN DEFAULT VALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_DEFAULT_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	SET_COLUMN_DEFAULT_VALUE(5, "SET_COLUMN_DEFAULT_VALUE", "SET_COLUMN_DEFAULT_VALUE"),

	/**
	 * The '<em><b>SET COLUMN AUTO INCREMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_AUTO_INCREMENT_VALUE
	 * @generated
	 * @ordered
	 */
	SET_COLUMN_AUTO_INCREMENT(6, "SET_COLUMN_AUTO_INCREMENT", "SET_COLUMN_AUTO_INCREMENT"),

	/**
	 * The '<em><b>RENAME COLUMN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RENAME_COLUMN_VALUE
	 * @generated
	 * @ordered
	 */
	RENAME_COLUMN(7, "RENAME_COLUMN", "RENAME_COLUMN"),

	/**
	 * The '<em><b>CHANGE REFERENTIAL ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_REFERENTIAL_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_REFERENTIAL_ACTION(8, "CHANGE_REFERENTIAL_ACTION", "CHANGE_REFERENTIAL_ACTION"),

	/**
	 * The '<em><b>SET ATTRIBUTE UNIQUE CONSTRAINT NAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME(9, "SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME", "SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME");

	/**
	 * The '<em><b>CREATE TABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_TABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_TABLE_VALUE = 0;

	/**
	 * The '<em><b>RENAME TABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RENAME_TABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RENAME_TABLE_VALUE = 1;

	/**
	 * The '<em><b>CREATE COLUMN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_COLUMN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_COLUMN_VALUE = 2;

	/**
	 * The '<em><b>CREATE PRIMARY KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_PRIMARY_KEY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_PRIMARY_KEY_VALUE = 3;

	/**
	 * The '<em><b>CREATE FOREIGN KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_FOREIGN_KEY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_FOREIGN_KEY_VALUE = 4;

	/**
	 * The '<em><b>SET COLUMN DEFAULT VALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_DEFAULT_VALUE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_COLUMN_DEFAULT_VALUE_VALUE = 5;

	/**
	 * The '<em><b>SET COLUMN AUTO INCREMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_AUTO_INCREMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_COLUMN_AUTO_INCREMENT_VALUE = 6;

	/**
	 * The '<em><b>RENAME COLUMN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RENAME_COLUMN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RENAME_COLUMN_VALUE = 7;

	/**
	 * The '<em><b>CHANGE REFERENTIAL ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_REFERENTIAL_ACTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_REFERENTIAL_ACTION_VALUE = 8;

	/**
	 * The '<em><b>SET ATTRIBUTE UNIQUE CONSTRAINT NAME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME_VALUE = 9;

	/**
	 * An array of all the '<em><b>Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ResolvableOperatorType[] VALUES_ARRAY =
		new ResolvableOperatorType[] {
			CREATE_TABLE,
			RENAME_TABLE,
			CREATE_COLUMN,
			CREATE_PRIMARY_KEY,
			CREATE_FOREIGN_KEY,
			SET_COLUMN_DEFAULT_VALUE,
			SET_COLUMN_AUTO_INCREMENT,
			RENAME_COLUMN,
			CHANGE_REFERENTIAL_ACTION,
			SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME,
		};

	/**
	 * A public read-only list of all the '<em><b>Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ResolvableOperatorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Resolvable Operator Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResolvableOperatorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resolvable Operator Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResolvableOperatorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resolvable Operator Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResolvableOperatorType get(int value) {
		switch (value) {
			case CREATE_TABLE_VALUE: return CREATE_TABLE;
			case RENAME_TABLE_VALUE: return RENAME_TABLE;
			case CREATE_COLUMN_VALUE: return CREATE_COLUMN;
			case CREATE_PRIMARY_KEY_VALUE: return CREATE_PRIMARY_KEY;
			case CREATE_FOREIGN_KEY_VALUE: return CREATE_FOREIGN_KEY;
			case SET_COLUMN_DEFAULT_VALUE_VALUE: return SET_COLUMN_DEFAULT_VALUE;
			case SET_COLUMN_AUTO_INCREMENT_VALUE: return SET_COLUMN_AUTO_INCREMENT;
			case RENAME_COLUMN_VALUE: return RENAME_COLUMN;
			case CHANGE_REFERENTIAL_ACTION_VALUE: return CHANGE_REFERENTIAL_ACTION;
			case SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME_VALUE: return SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME;
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
	private ResolvableOperatorType(int value, String name, String literal) {
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
	
} //ResolvableOperatorType
