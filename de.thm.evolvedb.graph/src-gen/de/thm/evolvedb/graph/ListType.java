/**
 */
package de.thm.evolvedb.graph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.ListType#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.ListType#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.ListType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getListType()
 * @model
 * @generated
 */
public interface ListType extends PropertyValueType {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see de.thm.evolvedb.graph.GraphPackage#getListType_LowerBound()
	 * @model required="true"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.ListType#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(int)
	 * @see de.thm.evolvedb.graph.GraphPackage#getListType_UpperBound()
	 * @model required="true"
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.ListType#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(PropertyValueType)
	 * @see de.thm.evolvedb.graph.GraphPackage#getListType_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PropertyValueType getType();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.ListType#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(PropertyValueType value);

} // ListType
