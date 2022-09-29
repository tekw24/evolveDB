/**
 */
package de.thm.evolvedb.mdde;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.Table#getSchema <em>Schema</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Table#getColumns <em>Columns</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.mdde.MddePackage#getTable()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TableRequiresAtLeastOneColumn'"
 * @generated
 */
public interface Table extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Schema</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.mdde.Database_Schema#getEntites <em>Entites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' container reference.
	 * @see #setSchema(Database_Schema)
	 * @see de.thm.evolvedb.mdde.MddePackage#getTable_Schema()
	 * @see de.thm.evolvedb.mdde.Database_Schema#getEntites
	 * @model opposite="entites" transient="false"
	 * @generated
	 */
	Database_Schema getSchema();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Table#getSchema <em>Schema</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' container reference.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(Database_Schema value);

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.evolvedb.mdde.Column}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.mdde.Column#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see de.thm.evolvedb.mdde.MddePackage#getTable_Columns()
	 * @see de.thm.evolvedb.mdde.Column#getTable
	 * @model opposite="table" containment="true"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<PrimaryKey> getPrimaryKeys();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	PrimaryKey getPrimaryKeyByName(String primaryKeyName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ForeignKey> getForeignKeys();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	PrimaryKey getMainPrimaryKey();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = \'Incorrect table definition; The table \' + Table.name + \'  can only have one auto column and it must be defined as a key!\',\n\tstatus : Boolean = self.columns-&gt; notEmpty() and\n\t\t((columns-&gt;one(c1 | c1.autoIncrement)) or (columns-&gt; select(c1 | c1.autoIncrement) -&gt; isEmpty()) or ((columns-&gt; select(c1 | c1.oclIsTypeOf(PrimaryKey)) -&gt; isEmpty()) and columns-&gt;exists(c1 | c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)))\n}.status'"
	 * @generated
	 */
	boolean OnlyOneAutoIncrementColumn(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = \'Incorrect table definition; The table \' + Table.name + \'  can only have one auto column and it must be defined as a key!\',\n\tstatus : Boolean = self.columns-&gt; notEmpty() and\n\t\t((columns-&gt;one(c1 | c1.oclIsTypeOf(PrimaryKey) and c1.autoIncrement)) or ((columns-&gt; select(c1 | c1.oclIsTypeOf(PrimaryKey)) -&gt; isEmpty()) and columns-&gt;exists(c1 | c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)) or (columns-&gt; select(c1 | c1.autoIncrement) -&gt; isEmpty()))\n}.status'"
	 * @generated
	 */
	boolean NonKeyAutoIncrementColumn(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = \'The Table \' + Table.name + \' requires a primary key or a set of primary foreign keys!\',\n\tstatus : Boolean = self.columns-&gt; notEmpty() and\n\t\t(columns-&gt;exists(oclIsTypeOf(PrimaryKey)) or columns -&gt; exists(c1 | (c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)))\n}.status'"
	 * @generated
	 */
	boolean TableRequiresAKeyColumn(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple {\n\tmessage : String = \'The Table \' + Table.name + \' requires at least one column!\',\n\tstatus : Boolean = self.columns-&gt;notEmpty()\n}.status'"
	 * @generated
	 */
	boolean TableRequiresAtLeastOneColumn(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Table
