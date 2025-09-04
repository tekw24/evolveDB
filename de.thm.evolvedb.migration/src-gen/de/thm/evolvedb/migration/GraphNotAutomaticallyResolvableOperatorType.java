/**
 */
package de.thm.evolvedb.migration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Graph Not Automatically Resolvable Operator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage#getGraphNotAutomaticallyResolvableOperatorType()
 * @model
 * @generated
 */
public enum GraphNotAutomaticallyResolvableOperatorType implements Enumerator {
	/**
	 * The '<em><b>MOVE PROPERTY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_PROPERTY_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE_PROPERTY(0, "MOVE_PROPERTY", "MOVE_PROPERTY"),

	/**
	 * The '<em><b>MOVE LABEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_LABEL_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE_LABEL(1, "MOVE_LABEL", "MOVE_LABEL"),

	/**
	 * The '<em><b>MOVE NODE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_NODE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE_NODE_TYPE(2, "MOVE_NODE_TYPE", "MOVE_NODE_TYPE"),

	/**
	 * The '<em><b>MOVE EDGE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_EDGE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE_EDGE_TYPE(3, "MOVE_EDGE_TYPE", "MOVE_EDGE_TYPE"),

	/**
	 * The '<em><b>MOVE COMBINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_COMBINED_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE_COMBINED(4, "MOVE_COMBINED", "MOVE_COMBINED");

	/**
	 * The '<em><b>MOVE PROPERTY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_PROPERTY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_PROPERTY_VALUE = 0;

	/**
	 * The '<em><b>MOVE LABEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_LABEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_LABEL_VALUE = 1;

	/**
	 * The '<em><b>MOVE NODE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_NODE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_NODE_TYPE_VALUE = 2;

	/**
	 * The '<em><b>MOVE EDGE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_EDGE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_EDGE_TYPE_VALUE = 3;

	/**
	 * The '<em><b>MOVE COMBINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_COMBINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_COMBINED_VALUE = 4;

	/**
	 * An array of all the '<em><b>Graph Not Automatically Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GraphNotAutomaticallyResolvableOperatorType[] VALUES_ARRAY =
		new GraphNotAutomaticallyResolvableOperatorType[] {
			MOVE_PROPERTY,
			MOVE_LABEL,
			MOVE_NODE_TYPE,
			MOVE_EDGE_TYPE,
			MOVE_COMBINED,
		};

	/**
	 * A public read-only list of all the '<em><b>Graph Not Automatically Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GraphNotAutomaticallyResolvableOperatorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Graph Not Automatically Resolvable Operator Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphNotAutomaticallyResolvableOperatorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GraphNotAutomaticallyResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Graph Not Automatically Resolvable Operator Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphNotAutomaticallyResolvableOperatorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GraphNotAutomaticallyResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Graph Not Automatically Resolvable Operator Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphNotAutomaticallyResolvableOperatorType get(int value) {
		switch (value) {
			case MOVE_PROPERTY_VALUE: return MOVE_PROPERTY;
			case MOVE_LABEL_VALUE: return MOVE_LABEL;
			case MOVE_NODE_TYPE_VALUE: return MOVE_NODE_TYPE;
			case MOVE_EDGE_TYPE_VALUE: return MOVE_EDGE_TYPE;
			case MOVE_COMBINED_VALUE: return MOVE_COMBINED;
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
	private GraphNotAutomaticallyResolvableOperatorType(int value, String name, String literal) {
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
	
} //GraphNotAutomaticallyResolvableOperatorType
