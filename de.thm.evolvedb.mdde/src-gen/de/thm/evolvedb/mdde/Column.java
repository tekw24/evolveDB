/**
 */
package de.thm.evolvedb.mdde;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.Column#getTable <em>Table</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Column#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Column#getNotNull <em>Not Null</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Column#getUnique <em>Unique</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Column#getAutoIncrement <em>Auto Increment</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Column#getSize <em>Size</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Column#getType <em>Type</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Column#getUniqueConstraintName <em>Unique Constraint Name</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.mdde.MddePackage#getColumn()
 * @model
 * @generated
 */
public interface Column extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.mdde.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' container reference.
	 * @see #setTable(Table)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumn_Table()
	 * @see de.thm.evolvedb.mdde.Table#getColumns
	 * @model opposite="columns" transient="false"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Column#getTable <em>Table</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' container reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumn_DefaultValue()
	 * @model
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Column#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Not Null</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Null</em>' attribute.
	 * @see #setNotNull(Boolean)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumn_NotNull()
	 * @model default="false"
	 * @generated
	 */
	Boolean getNotNull();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Column#getNotNull <em>Not Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Null</em>' attribute.
	 * @see #getNotNull()
	 * @generated
	 */
	void setNotNull(Boolean value);

	/**
	 * Returns the value of the '<em><b>Unique</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique</em>' attribute.
	 * @see #setUnique(Boolean)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumn_Unique()
	 * @model default="false"
	 * @generated
	 */
	Boolean getUnique();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Column#getUnique <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique</em>' attribute.
	 * @see #getUnique()
	 * @generated
	 */
	void setUnique(Boolean value);

	/**
	 * Returns the value of the '<em><b>Auto Increment</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Increment</em>' attribute.
	 * @see #setAutoIncrement(Boolean)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumn_AutoIncrement()
	 * @model default="false"
	 * @generated
	 */
	Boolean getAutoIncrement();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Column#getAutoIncrement <em>Auto Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Increment</em>' attribute.
	 * @see #getAutoIncrement()
	 * @generated
	 */
	void setAutoIncrement(Boolean value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(String)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumn_Size()
	 * @model dataType="de.thm.evolvedb.mdde.ColumnSize"
	 * @generated
	 */
	String getSize();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Column#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.mdde.DataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.mdde.DataType
	 * @see #setType(DataType)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumn_Type()
	 * @model
	 * @generated
	 */
	DataType getType();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Column#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.thm.evolvedb.mdde.DataType
	 * @see #getType()
	 * @generated
	 */
	void setType(DataType value);

	/**
	 * Returns the value of the '<em><b>Unique Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Constraint Name</em>' attribute.
	 * @see #setUniqueConstraintName(String)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumn_UniqueConstraintName()
	 * @model
	 * @generated
	 */
	String getUniqueConstraintName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Column#getUniqueConstraintName <em>Unique Constraint Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique Constraint Name</em>' attribute.
	 * @see #getUniqueConstraintName()
	 * @generated
	 */
	void setUniqueConstraintName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validateDefaultValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validateSizeValue(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Column
