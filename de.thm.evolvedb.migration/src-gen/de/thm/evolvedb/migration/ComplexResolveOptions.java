/**
 */
package de.thm.evolvedb.migration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Complex Resolve Options</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage#getComplexResolveOptions()
 * @model
 * @generated
 */
public enum ComplexResolveOptions implements Enumerator {
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
	 * The '<em><b>RESOLVE BY DB ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOLVE_BY_DB_ID_VALUE
	 * @generated
	 * @ordered
	 */
	RESOLVE_BY_DB_ID(1, "RESOLVE_BY_DB_ID", "Match rows by primary key."),

	/**
	 * The '<em><b>CARTESIAN PRODUCT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CARTESIAN_PRODUCT_VALUE
	 * @generated
	 * @ordered
	 */
	CARTESIAN_PRODUCT(2, "CARTESIAN_PRODUCT", "Create a cartesian product of all associated tables.");

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
	 * The '<em><b>RESOLVE BY DB ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOLVE_BY_DB_ID
	 * @model literal="Match rows by primary key."
	 * @generated
	 * @ordered
	 */
	public static final int RESOLVE_BY_DB_ID_VALUE = 1;

	/**
	 * The '<em><b>CARTESIAN PRODUCT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CARTESIAN_PRODUCT
	 * @model literal="Create a cartesian product of all associated tables."
	 * @generated
	 * @ordered
	 */
	public static final int CARTESIAN_PRODUCT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Complex Resolve Options</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ComplexResolveOptions[] VALUES_ARRAY =
		new ComplexResolveOptions[] {
			IGNORE,
			RESOLVE_BY_DB_ID,
			CARTESIAN_PRODUCT,
		};

	/**
	 * A public read-only list of all the '<em><b>Complex Resolve Options</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ComplexResolveOptions> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Complex Resolve Options</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComplexResolveOptions get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComplexResolveOptions result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Complex Resolve Options</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComplexResolveOptions getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComplexResolveOptions result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Complex Resolve Options</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComplexResolveOptions get(int value) {
		switch (value) {
			case IGNORE_VALUE: return IGNORE;
			case RESOLVE_BY_DB_ID_VALUE: return RESOLVE_BY_DB_ID;
			case CARTESIAN_PRODUCT_VALUE: return CARTESIAN_PRODUCT;
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
	private ComplexResolveOptions(int value, String name, String literal) {
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
	
} //ComplexResolveOptions
