/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.EdgeLabel#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getEdgeLabel()
 * @model
 * @generated
 */
public interface EdgeLabel extends Label {
	/**
	 * Returns the value of the '<em><b>Edges</b></em>' reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.EdgeType}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.EdgeType#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getEdgeLabel_Edges()
	 * @see de.thm.evolvedb.graph.EdgeType#getLabels
	 * @model opposite="labels"
	 * @generated
	 */
	EList<EdgeType> getEdges();

} // EdgeLabel
