/**
 */
package de.thm.evolvedb.migration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Graph Partially Resolvable Operator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage#getGraphPartiallyResolvableOperatorType()
 * @model
 * @generated
 */
public enum GraphPartiallyResolvableOperatorType implements Enumerator {
	/**
	 * The '<em><b>DELETE NODE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_NODE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_NODE_TYPE(0, "DELETE_NODE_TYPE", "DELETE_NODE_TYPE"),

	/**
	 * The '<em><b>DELETE EDGE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_EDGE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_EDGE_TYPE(1, "DELETE_EDGE_TYPE", "DELETE_EDGE_TYPE"),

	/**
	 * The '<em><b>DELETE LABEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_LABEL_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_LABEL(2, "DELETE_LABEL", "DELETE_LABEL"),

	/**
	 * The '<em><b>REMOVE REFERENCE OR CONSTRAINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVE_REFERENCE_OR_CONSTRAINT_VALUE
	 * @generated
	 * @ordered
	 */
	REMOVE_REFERENCE_OR_CONSTRAINT(3, "REMOVE_REFERENCE_OR_CONSTRAINT", "REMOVE_REFERENCE_OR_CONSTRAINT"),

	/**
	 * The '<em><b>DELETE PROPERTY GRAPH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_PROPERTY_GRAPH_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE_PROPERTY_GRAPH(4, "DELETE_PROPERTY_GRAPH", "DELETE_PROPERTY_GRAPH"),

	/**
	 * The '<em><b>NARROW NUMERIC TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NARROW_NUMERIC_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	NARROW_NUMERIC_TYPE(5, "NARROW_NUMERIC_TYPE", "NARROW_NUMERIC_TYPE"),

	/**
	 * The '<em><b>NARROW TEMPORAL TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NARROW_TEMPORAL_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	NARROW_TEMPORAL_TYPE(6, "NARROW_TEMPORAL_TYPE", "NARROW_TEMPORAL_TYPE"), /**
	 * The '<em><b>REMOVE PROPERTY LABEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVE_PROPERTY_LABEL_VALUE
	 * @generated
	 * @ordered
	 */
	REMOVE_PROPERTY_LABEL(7, "REMOVE_PROPERTY_LABEL", "REMOVE_PROPERTY_LABEL"), /**
	 * The '<em><b>REMOVE PROPERTY EDGE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVE_PROPERTY_EDGE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	REMOVE_PROPERTY_EDGE_TYPE(8, "REMOVE_PROPERTY_EDGE_TYPE", "REMOVE_PROPERTY_EDGE_TYPE"), /**
	 * The '<em><b>REMOVE PROPERTY NODE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVE_PROPERTY_NODE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	REMOVE_PROPERTY_NODE_TYPE(9, "REMOVE_PROPERTY_NODE_TYPE", "REMOVE_PROPERTY_NODE_TYPE"), /**
	 * The '<em><b>BINARY ENCODING CHANGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY_ENCODING_CHANGE_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_ENCODING_CHANGE(10, "BINARY_ENCODING_CHANGE", "BINARY_ENCODING_CHANGE");

	/**
	 * The '<em><b>DELETE NODE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_NODE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_NODE_TYPE_VALUE = 0;

	/**
	 * The '<em><b>DELETE EDGE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_EDGE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_EDGE_TYPE_VALUE = 1;

	/**
	 * The '<em><b>DELETE LABEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_LABEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_LABEL_VALUE = 2;

	/**
	 * The '<em><b>REMOVE REFERENCE OR CONSTRAINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVE_REFERENCE_OR_CONSTRAINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REMOVE_REFERENCE_OR_CONSTRAINT_VALUE = 3;

	/**
	 * The '<em><b>DELETE PROPERTY GRAPH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_PROPERTY_GRAPH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_PROPERTY_GRAPH_VALUE = 4;

	/**
	 * The '<em><b>NARROW NUMERIC TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NARROW_NUMERIC_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NARROW_NUMERIC_TYPE_VALUE = 5;

	/**
	 * The '<em><b>NARROW TEMPORAL TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NARROW_TEMPORAL_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NARROW_TEMPORAL_TYPE_VALUE = 6;

	/**
	 * The '<em><b>REMOVE PROPERTY LABEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVE_PROPERTY_LABEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REMOVE_PROPERTY_LABEL_VALUE = 7;

	/**
	 * The '<em><b>REMOVE PROPERTY EDGE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVE_PROPERTY_EDGE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REMOVE_PROPERTY_EDGE_TYPE_VALUE = 8;

	/**
	 * The '<em><b>REMOVE PROPERTY NODE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVE_PROPERTY_NODE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REMOVE_PROPERTY_NODE_TYPE_VALUE = 9;

	/**
	 * The '<em><b>BINARY ENCODING CHANGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY_ENCODING_CHANGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_ENCODING_CHANGE_VALUE = 10;

	/**
	 * An array of all the '<em><b>Graph Partially Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GraphPartiallyResolvableOperatorType[] VALUES_ARRAY =
		new GraphPartiallyResolvableOperatorType[] {
			DELETE_NODE_TYPE,
			DELETE_EDGE_TYPE,
			DELETE_LABEL,
			REMOVE_REFERENCE_OR_CONSTRAINT,
			DELETE_PROPERTY_GRAPH,
			NARROW_NUMERIC_TYPE,
			NARROW_TEMPORAL_TYPE,
			REMOVE_PROPERTY_LABEL,
			REMOVE_PROPERTY_EDGE_TYPE,
			REMOVE_PROPERTY_NODE_TYPE,
			BINARY_ENCODING_CHANGE,
		};

	/**
	 * A public read-only list of all the '<em><b>Graph Partially Resolvable Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GraphPartiallyResolvableOperatorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Graph Partially Resolvable Operator Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphPartiallyResolvableOperatorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GraphPartiallyResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Graph Partially Resolvable Operator Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphPartiallyResolvableOperatorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GraphPartiallyResolvableOperatorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Graph Partially Resolvable Operator Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphPartiallyResolvableOperatorType get(int value) {
		switch (value) {
			case DELETE_NODE_TYPE_VALUE: return DELETE_NODE_TYPE;
			case DELETE_EDGE_TYPE_VALUE: return DELETE_EDGE_TYPE;
			case DELETE_LABEL_VALUE: return DELETE_LABEL;
			case REMOVE_REFERENCE_OR_CONSTRAINT_VALUE: return REMOVE_REFERENCE_OR_CONSTRAINT;
			case DELETE_PROPERTY_GRAPH_VALUE: return DELETE_PROPERTY_GRAPH;
			case NARROW_NUMERIC_TYPE_VALUE: return NARROW_NUMERIC_TYPE;
			case NARROW_TEMPORAL_TYPE_VALUE: return NARROW_TEMPORAL_TYPE;
			case REMOVE_PROPERTY_LABEL_VALUE: return REMOVE_PROPERTY_LABEL;
			case REMOVE_PROPERTY_EDGE_TYPE_VALUE: return REMOVE_PROPERTY_EDGE_TYPE;
			case REMOVE_PROPERTY_NODE_TYPE_VALUE: return REMOVE_PROPERTY_NODE_TYPE;
			case BINARY_ENCODING_CHANGE_VALUE: return BINARY_ENCODING_CHANGE;
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
	private GraphPartiallyResolvableOperatorType(int value, String name, String literal) {
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
	
} //GraphPartiallyResolvableOperatorType
