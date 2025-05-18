/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.EdgeType#getName <em>Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.EdgeType#getLabels <em>Labels</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.EdgeType#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.EdgeType#getSrc <em>Src</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.EdgeType#getTgt <em>Tgt</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getEdgeType()
 * @model
 * @generated
 */
public interface EdgeType extends GraphItem {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see de.thm.evolvedb.graph.GraphPackage#getEdgeType_Name()
	 * @model changeable="false" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Labels</b></em>' reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.EdgeLabel}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.EdgeLabel#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labels</em>' reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getEdgeType_Labels()
	 * @see de.thm.evolvedb.graph.EdgeLabel#getEdges
	 * @model opposite="edges"
	 * @generated
	 */
	EList<EdgeLabel> getLabels();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getEdgeType_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Src</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.NodeType#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src</em>' reference.
	 * @see #setSrc(NodeType)
	 * @see de.thm.evolvedb.graph.GraphPackage#getEdgeType_Src()
	 * @see de.thm.evolvedb.graph.NodeType#getOutgoing
	 * @model opposite="outgoing"
	 * @generated
	 */
	NodeType getSrc();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.EdgeType#getSrc <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src</em>' reference.
	 * @see #getSrc()
	 * @generated
	 */
	void setSrc(NodeType value);

	/**
	 * Returns the value of the '<em><b>Tgt</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.NodeType#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tgt</em>' reference.
	 * @see #setTgt(NodeType)
	 * @see de.thm.evolvedb.graph.GraphPackage#getEdgeType_Tgt()
	 * @see de.thm.evolvedb.graph.NodeType#getIncoming
	 * @model opposite="incoming"
	 * @generated
	 */
	NodeType getTgt();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.EdgeType#getTgt <em>Tgt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tgt</em>' reference.
	 * @see #getTgt()
	 * @generated
	 */
	void setTgt(NodeType value);

} // EdgeType
