/**
 */
package de.thm.evolvedb.graph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.BooleanType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getBooleanType()
 * @model
 * @generated
 */
public interface BooleanType extends PropertyValueType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.graph.BooleanDataTypes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.graph.BooleanDataTypes
	 * @see #setType(BooleanDataTypes)
	 * @see de.thm.evolvedb.graph.GraphPackage#getBooleanType_Type()
	 * @model required="true"
	 * @generated
	 */
	BooleanDataTypes getType();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.BooleanType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.graph.BooleanDataTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(BooleanDataTypes value);

} // BooleanType
