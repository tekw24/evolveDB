/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.NodeType#getLabel <em>Label</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.NodeType#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.NodeType#getIncoming <em>Incoming</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getNodeType()
 * @model
 * @generated
 */
public interface NodeType extends GraphItem {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.NodeLabel}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.NodeLabel#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getNodeType_Label()
	 * @see de.thm.evolvedb.graph.NodeLabel#getNodes
	 * @model opposite="nodes"
	 * @generated
	 */
	EList<NodeLabel> getLabel();

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.EdgeType}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.EdgeType#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getNodeType_Outgoing()
	 * @see de.thm.evolvedb.graph.EdgeType#getSrc
	 * @model opposite="src"
	 * @generated
	 */
	EList<EdgeType> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.EdgeType}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.EdgeType#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getNodeType_Incoming()
	 * @see de.thm.evolvedb.graph.EdgeType#getTgt
	 * @model opposite="tgt"
	 * @generated
	 */
	EList<EdgeType> getIncoming();

} // NodeType
