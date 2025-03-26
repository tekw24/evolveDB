/**
 */
package de.thm.evolvedb.graph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Temporal Types</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.graph.TemporalTypes#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.graph.GraphPackage#getTemporalTypes()
 * @model
 * @generated
 */
public interface TemporalTypes extends PropertyValueType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.graph.TemporalDataTypes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.graph.TemporalDataTypes
	 * @see #setType(TemporalDataTypes)
	 * @see de.thm.evolvedb.graph.GraphPackage#getTemporalTypes_Type()
	 * @model required="true"
	 * @generated
	 */
	TemporalDataTypes getType();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.graph.TemporalTypes#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.graph.TemporalDataTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(TemporalDataTypes value);

} // TemporalTypes
