/**
 */
package de.thm.evolvedb.graph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Union Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.UnionType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getUnionType()
 * @model
 * @generated
 */
public interface UnionType extends PropertyValueType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.graph.DynamicUnionTypes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.graph.DynamicUnionTypes
	 * @see #setType(DynamicUnionTypes)
	 * @see de.thm.evolvedb.graph.GraphPackage#getUnionType_Type()
	 * @model required="true"
	 * @generated
	 */
	DynamicUnionTypes getType();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.UnionType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.graph.DynamicUnionTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(DynamicUnionTypes value);

} // UnionType
