/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.PropertyGraph#isClosed <em>Closed</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.PropertyGraph#getGraphtype <em>Graphtype</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.PropertyGraph#getItems <em>Items</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.PropertyGraph#getName <em>Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.PropertyGraph#getLocation <em>Location</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyGraph()
 * @model
 * @generated
 */
public interface PropertyGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Closed</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closed</em>' attribute.
	 * @see #setClosed(boolean)
	 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyGraph_Closed()
	 * @model default="true"
	 * @generated
	 */
	boolean isClosed();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.PropertyGraph#isClosed <em>Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closed</em>' attribute.
	 * @see #isClosed()
	 * @generated
	 */
	void setClosed(boolean value);

	/**
	 * Returns the value of the '<em><b>Graphtype</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.graph.GraphType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphtype</em>' attribute.
	 * @see de.thm.evolvedb.graph.GraphType
	 * @see #setGraphtype(GraphType)
	 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyGraph_Graphtype()
	 * @model
	 * @generated
	 */
	GraphType getGraphtype();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.PropertyGraph#getGraphtype <em>Graphtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphtype</em>' attribute.
	 * @see de.thm.evolvedb.graph.GraphType
	 * @see #getGraphtype()
	 * @generated
	 */
	void setGraphtype(GraphType value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.GraphItem}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.GraphItem#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyGraph_Items()
	 * @see de.thm.evolvedb.graph.GraphItem#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<GraphItem> getItems();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyGraph_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.PropertyGraph#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyGraph_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.PropertyGraph#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

} // PropertyGraph
