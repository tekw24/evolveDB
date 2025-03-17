/**
 */
package de.thm.evolvedb.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.graph.GraphPackage#getGraphType()
 * @model
 * @generated
 */
public enum GraphType implements Enumerator {
	/**
	 * The '<em><b>Multigraph</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTIGRAPH_VALUE
	 * @generated
	 * @ordered
	 */
	MULTIGRAPH(0, "multigraph", "multigraph"),

	/**
	 * The '<em><b>Directed graph</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTED_GRAPH_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTED_GRAPH(1, "directed_graph", "directed_graph"),

	/**
	 * The '<em><b>Undirected graph</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDIRECTED_GRAPH_VALUE
	 * @generated
	 * @ordered
	 */
	UNDIRECTED_GRAPH(2, "undirected_graph", "undirected_graph"),

	/**
	 * The '<em><b>Mixed graph</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIXED_GRAPH_VALUE
	 * @generated
	 * @ordered
	 */
	MIXED_GRAPH(3, "mixed_graph", "mixed_graph"),

	/**
	 * The '<em><b>Empty graph</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMPTY_GRAPH_VALUE
	 * @generated
	 * @ordered
	 */
	EMPTY_GRAPH(4, "empty_graph", "empty_graph");

	/**
	 * The '<em><b>Multigraph</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTIGRAPH
	 * @model name="multigraph"
	 * @generated
	 * @ordered
	 */
	public static final int MULTIGRAPH_VALUE = 0;

	/**
	 * The '<em><b>Directed graph</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTED_GRAPH
	 * @model name="directed_graph"
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTED_GRAPH_VALUE = 1;

	/**
	 * The '<em><b>Undirected graph</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDIRECTED_GRAPH
	 * @model name="undirected_graph"
	 * @generated
	 * @ordered
	 */
	public static final int UNDIRECTED_GRAPH_VALUE = 2;

	/**
	 * The '<em><b>Mixed graph</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIXED_GRAPH
	 * @model name="mixed_graph"
	 * @generated
	 * @ordered
	 */
	public static final int MIXED_GRAPH_VALUE = 3;

	/**
	 * The '<em><b>Empty graph</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMPTY_GRAPH
	 * @model name="empty_graph"
	 * @generated
	 * @ordered
	 */
	public static final int EMPTY_GRAPH_VALUE = 4;

	/**
	 * An array of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GraphType[] VALUES_ARRAY = new GraphType[] { MULTIGRAPH, DIRECTED_GRAPH, UNDIRECTED_GRAPH,
			MIXED_GRAPH, EMPTY_GRAPH, };

	/**
	 * A public read-only list of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GraphType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GraphType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GraphType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GraphType get(int value) {
		switch (value) {
		case MULTIGRAPH_VALUE:
			return MULTIGRAPH;
		case DIRECTED_GRAPH_VALUE:
			return DIRECTED_GRAPH;
		case UNDIRECTED_GRAPH_VALUE:
			return UNDIRECTED_GRAPH;
		case MIXED_GRAPH_VALUE:
			return MIXED_GRAPH;
		case EMPTY_GRAPH_VALUE:
			return EMPTY_GRAPH;
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
	private GraphType(int value, String name, String literal) {
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

} //GraphType
