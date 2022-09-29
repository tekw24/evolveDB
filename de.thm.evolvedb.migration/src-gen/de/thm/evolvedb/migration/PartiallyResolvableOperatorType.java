/**
 */
package de.thm.evolvedb.migration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Partially Resolvable Operator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage#getPartiallyResolvableOperatorType()
 * @model
 * @generated
 */
public enum PartiallyResolvableOperatorType implements Enumerator {
	/**
	 * The '<em><b>DELETE COLUMN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_COLUMN_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_COLUMN(0, "DELETE_COLUMN", "DELETE_COLUMN"),

	/**
	 * The '<em><b>DELETE FOREIGN KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_FOREIGN_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_FOREIGN_KEY(1, "DELETE_FOREIGN_KEY", "DELETE_FOREIGN_KEY"),

	/**
	 * The '<em><b>DELETE PRIMARY KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_PRIMARY_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_PRIMARY_KEY(2, "DELETE_PRIMARY_KEY", "DELETE_PRIMARY_KEY"),

	/**
	 * The '<em><b>DELETE TABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_TABLE_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_TABLE(3, "DELETE_TABLE", "DELETE_TABLE"),

	/**
	 * The '<em><b>SET COLUMN NOT NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_NOT_NULL_VALUE
	 * @generated
	 * @ordered
	 */
	SET_COLUMN_NOT_NULL(4, "SET_COLUMN_NOT_NULL", "SET_COLUMN_NOT_NULL"),

	/**
	 * The '<em><b>SET COLUMN SIZE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_SIZE_VALUE
	 * @generated
	 * @ordered
	 */
	SET_COLUMN_SIZE(5, "SET_COLUMN_SIZE", "SET_COLUMN_SIZE"),

	/**
	 * The '<em><b>SET FOREIGNKEYS TARGET TABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_FOREIGNKEYS_TARGET_TABLE_VALUE
	 * @generated
	 * @ordered
	 */
	SET_FOREIGNKEYS_TARGET_TABLE(6, "SET_FOREIGNKEYS_TARGET_TABLE", "SET_FOREIGNKEYS_TARGET_TABLE"),

	/**
	 * The '<em><b>SET COLUMN UNIQUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_UNIQUE_VALUE
	 * @generated
	 * @ordered
	 */
	SET_COLUMN_UNIQUE(7, "SET_COLUMN_UNIQUE", "SET_COLUMN_UNIQUE"),

	/**
	 * The '<em><b>SET COLUMN TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	SET_COLUMN_TYPE(8, "SET_COLUMN_TYPE", "SET_COLUMN_TYPE"),

	/**
	 * The '<em><b>CHANGE 1N INTO NM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_1N_INTO_NM_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_1N_INTO_NM(9, "CHANGE_1N_INTO_NM", "CHANGE_1N_INTO_NM"),

	/**
	 * The '<em><b>CHANGE 1N INTO NM PRESERVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_1N_INTO_NM_PRESERVE_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_1N_INTO_NM_PRESERVE(10, "CHANGE_1N_INTO_NM_PRESERVE", "CHANGE_1N_INTO_NM_PRESERVE"),

	/**
	 * The '<em><b>CHANGE NM INTO 1N</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_NM_INTO_1N_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_NM_INTO_1N(11, "CHANGE_NM_INTO_1N", "CHANGE_NM_INTO_1N"),

	/**
	 * The '<em><b>CHANGE NM INTO 1N PRESERVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_NM_INTO_1N_PRESERVE_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_NM_INTO_1N_PRESERVE(12, "CHANGE_NM_INTO_1N_PRESERVE", "CHANGE_NM_INTO_1N_PRESERVE"),

	/**
	 * The '<em><b>SET COLUMN TYPE AND SIZE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_TYPE_AND_SIZE_VALUE
	 * @generated
	 * @ordered
	 */
	SET_COLUMN_TYPE_AND_SIZE(13, "SET_COLUMN_TYPE_AND_SIZE", "SET_COLUMN_TYPE_AND_SIZE");

	/**
	 * The '<em><b>DELETE COLUMN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_COLUMN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_COLUMN_VALUE = 0;

	/**
	 * The '<em><b>DELETE FOREIGN KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_FOREIGN_KEY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_FOREIGN_KEY_VALUE = 1;

	/**
	 * The '<em><b>DELETE PRIMARY KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_PRIMARY_KEY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_PRIMARY_KEY_VALUE = 2;

	/**
	 * The '<em><b>DELETE TABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_TABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_TABLE_VALUE = 3;

	/**
	 * The '<em><b>SET COLUMN NOT NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_NOT_NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_COLUMN_NOT_NULL_VALUE = 4;

	/**
	 * The '<em><b>SET COLUMN SIZE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_SIZE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_COLUMN_SIZE_VALUE = 5;

	/**
	 * The '<em><b>SET FOREIGNKEYS TARGET TABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_FOREIGNKEYS_TARGET_TABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_FOREIGNKEYS_TARGET_TABLE_VALUE = 6;

	/**
	 * The '<em><b>SET COLUMN UNIQUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_UNIQUE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_COLUMN_UNIQUE_VALUE = 7;

	/**
	 * The '<em><b>SET COLUMN TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_COLUMN_TYPE_VALUE = 8;

	/**
	 * The '<em><b>CHANGE 1N INTO NM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_1N_INTO_NM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_1N_INTO_NM_VALUE = 9;

	/**
	 * The '<em><b>CHANGE 1N INTO NM PRESERVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_1N_INTO_NM_PRESERVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_1N_INTO_NM_PRESERVE_VALUE = 10;

	/**
	 * The '<em><b>CHANGE NM INTO 1N</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_NM_INTO_1N
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_NM_INTO_1N_VALUE = 11;

	/**
	 * The '<em><b>CHANGE NM INTO 1N PRESERVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_NM_INTO_1N_PRESERVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_NM_INTO_1N_PRESERVE_VALUE = 12;

	/**
	 * The '<em><b>SET COLUMN TYPE AND SIZE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_COLUMN_TYPE_AND_SIZE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_COLUMN_TYPE_AND_SIZE_VALUE = 13;

	/**
	 * An array of all the '<em><b>Partially Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PartiallyResolvableOperatorType[] VALUES_ARRAY =
		new PartiallyResolvableOperatorType[] {
			DELETE_COLUMN,
			DELETE_FOREIGN_KEY,
			DELETE_PRIMARY_KEY,
			DELETE_TABLE,
			SET_COLUMN_NOT_NULL,
			SET_COLUMN_SIZE,
			SET_FOREIGNKEYS_TARGET_TABLE,
			SET_COLUMN_UNIQUE,
			SET_COLUMN_TYPE,
			CHANGE_1N_INTO_NM,
			CHANGE_1N_INTO_NM_PRESERVE,
			CHANGE_NM_INTO_1N,
			CHANGE_NM_INTO_1N_PRESERVE,
			SET_COLUMN_TYPE_AND_SIZE,
		};

	/**
	 * A public read-only list of all the '<em><b>Partially Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PartiallyResolvableOperatorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Partially Resolvable Operator Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PartiallyResolvableOperatorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PartiallyResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Partially Resolvable Operator Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PartiallyResolvableOperatorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PartiallyResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Partially Resolvable Operator Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PartiallyResolvableOperatorType get(int value) {
		switch (value) {
			case DELETE_COLUMN_VALUE: return DELETE_COLUMN;
			case DELETE_FOREIGN_KEY_VALUE: return DELETE_FOREIGN_KEY;
			case DELETE_PRIMARY_KEY_VALUE: return DELETE_PRIMARY_KEY;
			case DELETE_TABLE_VALUE: return DELETE_TABLE;
			case SET_COLUMN_NOT_NULL_VALUE: return SET_COLUMN_NOT_NULL;
			case SET_COLUMN_SIZE_VALUE: return SET_COLUMN_SIZE;
			case SET_FOREIGNKEYS_TARGET_TABLE_VALUE: return SET_FOREIGNKEYS_TARGET_TABLE;
			case SET_COLUMN_UNIQUE_VALUE: return SET_COLUMN_UNIQUE;
			case SET_COLUMN_TYPE_VALUE: return SET_COLUMN_TYPE;
			case CHANGE_1N_INTO_NM_VALUE: return CHANGE_1N_INTO_NM;
			case CHANGE_1N_INTO_NM_PRESERVE_VALUE: return CHANGE_1N_INTO_NM_PRESERVE;
			case CHANGE_NM_INTO_1N_VALUE: return CHANGE_NM_INTO_1N;
			case CHANGE_NM_INTO_1N_PRESERVE_VALUE: return CHANGE_NM_INTO_1N_PRESERVE;
			case SET_COLUMN_TYPE_AND_SIZE_VALUE: return SET_COLUMN_TYPE_AND_SIZE;
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
	private PartiallyResolvableOperatorType(int value, String name, String literal) {
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
	
} //PartiallyResolvableOperatorType
