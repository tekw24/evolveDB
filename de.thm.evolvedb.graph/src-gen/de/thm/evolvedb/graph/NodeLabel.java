/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.NodeLabel#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getNodeLabel()
 * @model
 * @generated
 */
public interface NodeLabel extends Label {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.NodeType}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.NodeType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getNodeLabel_Nodes()
	 * @see de.thm.evolvedb.graph.NodeType#getLabel
	 * @model opposite="label"
	 * @generated
	 */
	EList<NodeType> getNodes();

} // NodeLabel
