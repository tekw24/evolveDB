/**
 */
package de.thm.evolvedb.mdde;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.Index#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.mdde.MddePackage#getIndex()
 * @model
 * @generated
 */
public interface Index extends Constraint {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.mdde.IndexType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.mdde.IndexType
	 * @see #setType(IndexType)
	 * @see de.thm.evolvedb.mdde.MddePackage#getIndex_Type()
	 * @model
	 * @generated
	 */
	IndexType getType();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Index#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.mdde.IndexType
	 * @see #getType()
	 * @generated
	 */
	void setType(IndexType value);
} // Index
