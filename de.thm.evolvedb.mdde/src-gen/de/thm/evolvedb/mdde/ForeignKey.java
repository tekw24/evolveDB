/**
 */
package de.thm.evolvedb.mdde;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.ForeignKey#getReferencedTable <em>Referenced Table</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.ForeignKey#getPrimaryForeignKey <em>Primary Foreign Key</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.ForeignKey#getOnUpdate <em>On Update</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.ForeignKey#getOnDelete <em>On Delete</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.ForeignKey#getConstraintName <em>Constraint Name</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.ForeignKey#getReferencedKeyColumn <em>Referenced Key Column</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.mdde.MddePackage#getForeignKey()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ForeignKeyHasToReferenceAKeyColumn'"
 * @generated
 */
public interface ForeignKey extends Column {
	/**
	 * Returns the value of the '<em><b>Referenced Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Table</em>' reference.
	 * @see #setReferencedTable(Table)
	 * @see de.thm.evolvedb.mdde.MddePackage#getForeignKey_ReferencedTable()
	 * @model required="true"
	 * @generated
	 */
	Table getReferencedTable();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.ForeignKey#getReferencedTable <em>Referenced Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Table</em>' reference.
	 * @see #getReferencedTable()
	 * @generated
	 */
	void setReferencedTable(Table value);

	/**
	 * Returns the value of the '<em><b>Primary Foreign Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Foreign Key</em>' attribute.
	 * @see #setPrimaryForeignKey(Boolean)
	 * @see de.thm.evolvedb.mdde.MddePackage#getForeignKey_PrimaryForeignKey()
	 * @model
	 * @generated
	 */
	Boolean getPrimaryForeignKey();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.ForeignKey#getPrimaryForeignKey <em>Primary Foreign Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Foreign Key</em>' attribute.
	 * @see #getPrimaryForeignKey()
	 * @generated
	 */
	void setPrimaryForeignKey(Boolean value);

	/**
	 * Returns the value of the '<em><b>On Update</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.mdde.Referential_Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Update</em>' attribute.
	 * @see de.thm.evolvedb.mdde.Referential_Action
	 * @see #setOnUpdate(Referential_Action)
	 * @see de.thm.evolvedb.mdde.MddePackage#getForeignKey_OnUpdate()
	 * @model required="true"
	 * @generated
	 */
	Referential_Action getOnUpdate();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.ForeignKey#getOnUpdate <em>On Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Update</em>' attribute.
	 * @see de.thm.evolvedb.mdde.Referential_Action
	 * @see #getOnUpdate()
	 * @generated
	 */
	void setOnUpdate(Referential_Action value);

	/**
	 * Returns the value of the '<em><b>On Delete</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.mdde.Referential_Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Delete</em>' attribute.
	 * @see de.thm.evolvedb.mdde.Referential_Action
	 * @see #setOnDelete(Referential_Action)
	 * @see de.thm.evolvedb.mdde.MddePackage#getForeignKey_OnDelete()
	 * @model required="true"
	 * @generated
	 */
	Referential_Action getOnDelete();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.ForeignKey#getOnDelete <em>On Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Delete</em>' attribute.
	 * @see de.thm.evolvedb.mdde.Referential_Action
	 * @see #getOnDelete()
	 * @generated
	 */
	void setOnDelete(Referential_Action value);

	/**
	 * Returns the value of the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Name</em>' attribute.
	 * @see #setConstraintName(String)
	 * @see de.thm.evolvedb.mdde.MddePackage#getForeignKey_ConstraintName()
	 * @model required="true"
	 * @generated
	 */
	String getConstraintName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.ForeignKey#getConstraintName <em>Constraint Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Name</em>' attribute.
	 * @see #getConstraintName()
	 * @generated
	 */
	void setConstraintName(String value);

	/**
	 * Returns the value of the '<em><b>Referenced Key Column</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.mdde.PrimaryKey#getReferencedBy <em>Referenced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Key Column</em>' reference.
	 * @see #setReferencedKeyColumn(PrimaryKey)
	 * @see de.thm.evolvedb.mdde.MddePackage#getForeignKey_ReferencedKeyColumn()
	 * @see de.thm.evolvedb.mdde.PrimaryKey#getReferencedBy
	 * @model opposite="referencedBy" required="true"
	 * @generated
	 */
	PrimaryKey getReferencedKeyColumn();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.ForeignKey#getReferencedKeyColumn <em>Referenced Key Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Key Column</em>' reference.
	 * @see #getReferencedKeyColumn()
	 * @generated
	 */
	void setReferencedKeyColumn(PrimaryKey value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validateConstraintName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = \'The referenced column should not be empty!\',\n\tstatus : Boolean = self.referencedTable-&gt; notEmpty()\n}.status'"
	 * @generated
	 */
	boolean ForeignKeyHasToReferenceAKeyColumn(DiagnosticChain diagnostics, Map<Object, Object> context);

	

} // ForeignKey
