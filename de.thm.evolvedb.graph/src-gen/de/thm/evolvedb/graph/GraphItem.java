/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.GraphItem#getGraph <em>Graph</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getGraphItem()
 * @model abstract="true"
 * @generated
 */
public interface GraphItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.PropertyGraph#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(PropertyGraph)
	 * @see de.thm.evolvedb.graph.GraphPackage#getGraphItem_Graph()
	 * @see de.thm.evolvedb.graph.PropertyGraph#getItems
	 * @model opposite="items" transient="false"
	 * @generated
	 */
	PropertyGraph getGraph();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.GraphItem#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(PropertyGraph value);

} // GraphItem
