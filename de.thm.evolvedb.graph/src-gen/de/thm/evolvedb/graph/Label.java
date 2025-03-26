/**
 */
package de.thm.evolvedb.graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.Label#getName <em>Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.Label#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.Label#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.Label#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getLabel()
 * @model abstract="true"
 * @generated
 */
public interface Label extends GraphItem {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.thm.evolvedb.graph.GraphPackage#getLabel_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.Label#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getLabel_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Super Type</b></em>' reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.Label}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Type</em>' reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getLabel_SuperType()
	 * @model
	 * @generated
	 */
	EList<Label> getSuperType();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.evolvedb.graph.Constraint}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.graph.Constraint#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see de.thm.evolvedb.graph.GraphPackage#getLabel_Constraints()
	 * @see de.thm.evolvedb.graph.Constraint#getLabel
	 * @model opposite="Label" containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

} // Label
