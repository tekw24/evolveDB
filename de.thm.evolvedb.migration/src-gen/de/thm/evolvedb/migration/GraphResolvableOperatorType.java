/**
 */
package de.thm.evolvedb.migration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Graph Resolvable Operator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage#getGraphResolvableOperatorType()
 * @model
 * @generated
 */
public enum GraphResolvableOperatorType implements Enumerator {
	/**
	 * The '<em><b>SET ATTRIBUTE OR REF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_ATTRIBUTE_OR_REF_VALUE
	 * @generated
	 * @ordered
	 */
	SET_ATTRIBUTE_OR_REF(0, "SET_ATTRIBUTE_OR_REF", "SET_ATTRIBUTE_OR_REF"),

	/**
	 * The '<em><b>CREATE NODE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_NODE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE_NODE_TYPE(1, "CREATE_NODE_TYPE", "CREATE_NODE_TYPE"),

	/**
	 * The '<em><b>CREATE EDGE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_EDGE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE_EDGE_TYPE(2, "CREATE_EDGE_TYPE", "CREATE_EDGE_TYPE"),

	/**
	 * The '<em><b>CREATE LABEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_LABEL_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE_LABEL(3, "CREATE_LABEL", "CREATE_LABEL"),

	/**
	 * The '<em><b>CREATE CONSTRAINT IN LABEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_CONSTRAINT_IN_LABEL_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE_CONSTRAINT_IN_LABEL(4, "CREATE_CONSTRAINT_IN_LABEL", "CREATE_CONSTRAINT_IN_LABEL"),

	/**
	 * The '<em><b>ADD REFERENCE OR MEMBER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_REFERENCE_OR_MEMBER_VALUE
	 * @generated
	 * @ordered
	 */
	ADD_REFERENCE_OR_MEMBER(5, "ADD_REFERENCE_OR_MEMBER", "ADD_REFERENCE_OR_MEMBER"),

	/**
	 * The '<em><b>WIDEN NUMERIC TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIDEN_NUMERIC_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	WIDEN_NUMERIC_TYPE(6, "WIDEN_NUMERIC_TYPE", "WIDEN_NUMERIC_TYPE"),

	/**
	 * The '<em><b>WIDEN TEMPORAL TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIDEN_TEMPORAL_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	WIDEN_TEMPORAL_TYPE(7, "WIDEN_TEMPORAL_TYPE", "WIDEN_TEMPORAL_TYPE"),

	/**
	 * The '<em><b>CREATE PROPERTY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_PROPERTY_VALUE
	 * @generated
	 * @ordered
	 */
	CREATE_PROPERTY(9, "CREATE_PROPERTY", "CREATE_PROPERTY"), /**
	 * The '<em><b>ADD LABEL TO NODE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_LABEL_TO_NODE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	ADD_LABEL_TO_NODE_TYPE(10, "ADD_LABEL_TO_NODE_TYPE", "ADD_LABEL_TO_NODE_TYPE"), /**
	 * The '<em><b>CHANGE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_TYPE(11, "CHANGE_TYPE", "CHANGE_TYPE"), /**
	 * The '<em><b>CHANGE NAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_NAME(12, "CHANGE_NAME", "CHANGE_NAME");

	/**
	 * The '<em><b>SET ATTRIBUTE OR REF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_ATTRIBUTE_OR_REF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_ATTRIBUTE_OR_REF_VALUE = 0;

	/**
	 * The '<em><b>CREATE NODE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_NODE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_NODE_TYPE_VALUE = 1;

	/**
	 * The '<em><b>CREATE EDGE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_EDGE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_EDGE_TYPE_VALUE = 2;

	/**
	 * The '<em><b>CREATE LABEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_LABEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_LABEL_VALUE = 3;

	/**
	 * The '<em><b>CREATE CONSTRAINT IN LABEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_CONSTRAINT_IN_LABEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_CONSTRAINT_IN_LABEL_VALUE = 4;

	/**
	 * The '<em><b>ADD REFERENCE OR MEMBER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_REFERENCE_OR_MEMBER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADD_REFERENCE_OR_MEMBER_VALUE = 5;

	/**
	 * The '<em><b>WIDEN NUMERIC TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIDEN_NUMERIC_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WIDEN_NUMERIC_TYPE_VALUE = 6;

	/**
	 * The '<em><b>WIDEN TEMPORAL TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIDEN_TEMPORAL_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WIDEN_TEMPORAL_TYPE_VALUE = 7;

	/**
	 * The '<em><b>CREATE PROPERTY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE_PROPERTY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE_PROPERTY_VALUE = 9;

	/**
	 * The '<em><b>ADD LABEL TO NODE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_LABEL_TO_NODE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADD_LABEL_TO_NODE_TYPE_VALUE = 10;

	/**
	 * The '<em><b>CHANGE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_TYPE_VALUE = 11;

	/**
	 * The '<em><b>CHANGE NAME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_NAME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_NAME_VALUE = 12;

	/**
	 * An array of all the '<em><b>Graph Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GraphResolvableOperatorType[] VALUES_ARRAY =
		new GraphResolvableOperatorType[] {
			SET_ATTRIBUTE_OR_REF,
			CREATE_NODE_TYPE,
			CREATE_EDGE_TYPE,
			CREATE_LABEL,
			CREATE_CONSTRAINT_IN_LABEL,
			ADD_REFERENCE_OR_MEMBER,
			WIDEN_NUMERIC_TYPE,
			WIDEN_TEMPORAL_TYPE,
			CREATE_PROPERTY,
			ADD_LABEL_TO_NODE_TYPE,
			CHANGE_TYPE,
			CHANGE_NAME,
		};

	/**
	 * A public read-only list of all the '<em><b>Graph Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GraphResolvableOperatorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Graph Resolvable Operator Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphResolvableOperatorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GraphResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Graph Resolvable Operator Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphResolvableOperatorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GraphResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Graph Resolvable Operator Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphResolvableOperatorType get(int value) {
		switch (value) {
			case SET_ATTRIBUTE_OR_REF_VALUE: return SET_ATTRIBUTE_OR_REF;
			case CREATE_NODE_TYPE_VALUE: return CREATE_NODE_TYPE;
			case CREATE_EDGE_TYPE_VALUE: return CREATE_EDGE_TYPE;
			case CREATE_LABEL_VALUE: return CREATE_LABEL;
			case CREATE_CONSTRAINT_IN_LABEL_VALUE: return CREATE_CONSTRAINT_IN_LABEL;
			case ADD_REFERENCE_OR_MEMBER_VALUE: return ADD_REFERENCE_OR_MEMBER;
			case WIDEN_NUMERIC_TYPE_VALUE: return WIDEN_NUMERIC_TYPE;
			case WIDEN_TEMPORAL_TYPE_VALUE: return WIDEN_TEMPORAL_TYPE;
			case CREATE_PROPERTY_VALUE: return CREATE_PROPERTY;
			case ADD_LABEL_TO_NODE_TYPE_VALUE: return ADD_LABEL_TO_NODE_TYPE;
			case CHANGE_TYPE_VALUE: return CHANGE_TYPE;
			case CHANGE_NAME_VALUE: return CHANGE_NAME;
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
	private GraphResolvableOperatorType(int value, String name, String literal) {
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
	
} //GraphResolvableOperatorType
