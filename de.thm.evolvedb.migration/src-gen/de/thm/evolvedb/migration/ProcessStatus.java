/**
 */
package de.thm.evolvedb.migration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Process Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage#getProcessStatus()
 * @model
 * @generated
 */
public enum ProcessStatus implements Enumerator {
	/**
	 * The '<em><b>RESOLVED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOLVED_VALUE
	 * @generated
	 * @ordered
	 */
	RESOLVED(0, "RESOLVED", "RESOLVED"),

	/**
	 * The '<em><b>IGNORE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE_VALUE
	 * @generated
	 * @ordered
	 */
	IGNORE(1, "IGNORE", "IGNORE"),

	/**
	 * The '<em><b>UNRESOLVED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNRESOLVED_VALUE
	 * @generated
	 * @ordered
	 */
	UNRESOLVED(2, "UNRESOLVED", "UNRESOLVED");

	/**
	 * The '<em><b>RESOLVED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOLVED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RESOLVED_VALUE = 0;

	/**
	 * The '<em><b>IGNORE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IGNORE_VALUE = 1;

	/**
	 * The '<em><b>UNRESOLVED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNRESOLVED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNRESOLVED_VALUE = 2;

	/**
	 * An array of all the '<em><b>Process Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ProcessStatus[] VALUES_ARRAY =
		new ProcessStatus[] {
			RESOLVED,
			IGNORE,
			UNRESOLVED,
		};

	/**
	 * A public read-only list of all the '<em><b>Process Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ProcessStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Process Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ProcessStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProcessStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Process Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ProcessStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProcessStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Process Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ProcessStatus get(int value) {
		switch (value) {
			case RESOLVED_VALUE: return RESOLVED;
			case IGNORE_VALUE: return IGNORE;
			case UNRESOLVED_VALUE: return UNRESOLVED;
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
	private ProcessStatus(int value, String name, String literal) {
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
	
} //ProcessStatus
