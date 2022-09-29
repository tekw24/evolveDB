/**
 */
package de.thm.evolvedb.migration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Not Automatically Resolvable Operator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage#getNotAutomaticallyResolvableOperatorType()
 * @model
 * @generated
 */
public enum NotAutomaticallyResolvableOperatorType implements Enumerator {
	/**
	 * The '<em><b>MOVE PRIMARY KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_PRIMARY_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE_PRIMARY_KEY(0, "MOVE_PRIMARY_KEY", "MOVE_PRIMARY_KEY"),

	/**
	 * The '<em><b>MOVE FOREIGN KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_FOREIGN_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE_FOREIGN_KEY(1, "MOVE_FOREIGN_KEY", "MOVE_FOREIGN_KEY"),

	/**
	 * The '<em><b>MOVE COLUMN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_COLUMN_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE_COLUMN(2, "MOVE_COLUMN", "MOVE_COLUMN"),

	/**
	 * The '<em><b>JOIN TABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOIN_TABLE_VALUE
	 * @generated
	 * @ordered
	 */
	JOIN_TABLE(3, "JOIN_TABLE", "JOIN_TABLE");

	/**
	 * The '<em><b>MOVE PRIMARY KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_PRIMARY_KEY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_PRIMARY_KEY_VALUE = 0;

	/**
	 * The '<em><b>MOVE FOREIGN KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_FOREIGN_KEY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_FOREIGN_KEY_VALUE = 1;

	/**
	 * The '<em><b>MOVE COLUMN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_COLUMN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_COLUMN_VALUE = 2;

	/**
	 * The '<em><b>JOIN TABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOIN_TABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOIN_TABLE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Not Automatically Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final NotAutomaticallyResolvableOperatorType[] VALUES_ARRAY =
		new NotAutomaticallyResolvableOperatorType[] {
			MOVE_PRIMARY_KEY,
			MOVE_FOREIGN_KEY,
			MOVE_COLUMN,
			JOIN_TABLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Not Automatically Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<NotAutomaticallyResolvableOperatorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Not Automatically Resolvable Operator Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static NotAutomaticallyResolvableOperatorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NotAutomaticallyResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Not Automatically Resolvable Operator Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static NotAutomaticallyResolvableOperatorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NotAutomaticallyResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Not Automatically Resolvable Operator Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static NotAutomaticallyResolvableOperatorType get(int value) {
		switch (value) {
			case MOVE_PRIMARY_KEY_VALUE: return MOVE_PRIMARY_KEY;
			case MOVE_FOREIGN_KEY_VALUE: return MOVE_FOREIGN_KEY;
			case MOVE_COLUMN_VALUE: return MOVE_COLUMN;
			case JOIN_TABLE_VALUE: return JOIN_TABLE;
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
	private NotAutomaticallyResolvableOperatorType(int value, String name, String literal) {
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
	
} //NotAutomaticallyResolvableOperatorType
