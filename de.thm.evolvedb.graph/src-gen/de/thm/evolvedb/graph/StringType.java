/**
 */
package de.thm.evolvedb.graph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.StringType#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.StringType#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.StringType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getStringType()
 * @model
 * @generated
 */
public interface StringType extends PropertyValueType {
	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #setMinLength(int)
	 * @see de.thm.evolvedb.graph.GraphPackage#getStringType_MinLength()
	 * @model
	 * @generated
	 */
	int getMinLength();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.StringType#getMinLength <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Length</em>' attribute.
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(int value);

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(int)
	 * @see de.thm.evolvedb.graph.GraphPackage#getStringType_MaxLength()
	 * @model
	 * @generated
	 */
	int getMaxLength();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.StringType#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.graph.StringDataTypes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.graph.StringDataTypes
	 * @see #setType(StringDataTypes)
	 * @see de.thm.evolvedb.graph.GraphPackage#getStringType_Type()
	 * @model required="true"
	 * @generated
	 */
	StringDataTypes getType();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.StringType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.graph.StringDataTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(StringDataTypes value);

} // StringType
