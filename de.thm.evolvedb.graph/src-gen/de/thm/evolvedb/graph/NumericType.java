/**
 */
package de.thm.evolvedb.graph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.NumericType#getType <em>Type</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.NumericType#getIntegralPart <em>Integral Part</em>}</li>
 *   <li>{@link de.thm.evolvedb.graph.NumericType#getFractionalPart <em>Fractional Part</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getNumericType()
 * @model
 * @generated
 */
public interface NumericType extends PropertyValueType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.graph.NumericDataTypes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.graph.NumericDataTypes
	 * @see #setType(NumericDataTypes)
	 * @see de.thm.evolvedb.graph.GraphPackage#getNumericType_Type()
	 * @model required="true"
	 * @generated
	 */
	NumericDataTypes getType();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.NumericType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.graph.NumericDataTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(NumericDataTypes value);

	/**
	 * Returns the value of the '<em><b>Integral Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integral Part</em>' attribute.
	 * @see #setIntegralPart(int)
	 * @see de.thm.evolvedb.graph.GraphPackage#getNumericType_IntegralPart()
	 * @model
	 * @generated
	 */
	int getIntegralPart();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.NumericType#getIntegralPart <em>Integral Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integral Part</em>' attribute.
	 * @see #getIntegralPart()
	 * @generated
	 */
	void setIntegralPart(int value);

	/**
	 * Returns the value of the '<em><b>Fractional Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fractional Part</em>' attribute.
	 * @see #setFractionalPart(int)
	 * @see de.thm.evolvedb.graph.GraphPackage#getNumericType_FractionalPart()
	 * @model
	 * @generated
	 */
	int getFractionalPart();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.NumericType#getFractionalPart <em>Fractional Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fractional Part</em>' attribute.
	 * @see #getFractionalPart()
	 * @generated
	 */
	void setFractionalPart(int value);

} // NumericType
