/**
 */
package de.thm.evolvedb.graph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Type Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.PropertyTypeConstraint#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.PropertyTypeConstraint#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyTypeConstraint()
 * @model
 * @generated
 */
public interface PropertyTypeConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference.
	 * @see #setProperties(Property)
	 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyTypeConstraint_Properties()
	 * @model
	 * @generated
	 */
	Property getProperties();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.PropertyTypeConstraint#getProperties <em>Properties</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(Property value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(PropertyValueType)
	 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyTypeConstraint_Type()
	 * @model
	 * @generated
	 */
	PropertyValueType getType();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.PropertyTypeConstraint#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(PropertyValueType value);

} // PropertyTypeConstraint
