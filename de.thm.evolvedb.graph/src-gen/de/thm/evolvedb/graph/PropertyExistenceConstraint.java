/**
 */
package de.thm.evolvedb.graph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Existence Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.PropertyExistenceConstraint#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyExistenceConstraint()
 * @model
 * @generated
 */
public interface PropertyExistenceConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference.
	 * @see #setProperties(Property)
	 * @see de.thm.evolvedb.graph.GraphPackage#getPropertyExistenceConstraint_Properties()
	 * @model
	 * @generated
	 */
	Property getProperties();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.PropertyExistenceConstraint#getProperties <em>Properties</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(Property value);

} // PropertyExistenceConstraint
