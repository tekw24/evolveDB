/**
 */
package de.thm.evolvedb.mdde;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.PrimaryKey#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.PrimaryKey#getReferencedBy <em>Referenced By</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.mdde.MddePackage#getPrimaryKey()
 * @model
 * @generated
 */
public interface PrimaryKey extends Column {
	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' attribute.
	 * @see #setPrimaryKey(Boolean)
	 * @see de.thm.evolvedb.mdde.MddePackage#getPrimaryKey_PrimaryKey()
	 * @model
	 * @generated
	 */
	Boolean getPrimaryKey();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.PrimaryKey#getPrimaryKey <em>Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' attribute.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(Boolean value);

	/**
	 * Returns the value of the '<em><b>Referenced By</b></em>' reference list.
	 * The list contents are of type {@link de.thm.evolvedb.mdde.ForeignKey}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.mdde.ForeignKey#getReferencedKeyColumn <em>Referenced Key Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced By</em>' reference list.
	 * @see de.thm.evolvedb.mdde.MddePackage#getPrimaryKey_ReferencedBy()
	 * @see de.thm.evolvedb.mdde.ForeignKey#getReferencedKeyColumn
	 * @model opposite="referencedKeyColumn"
	 * @generated
	 */
	EList<ForeignKey> getReferencedBy();

} // PrimaryKey
