/**
 */
package de.thm.evolvedb.mdde;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.ColumnConstraint#getLength <em>Length</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.ColumnConstraint#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.ColumnConstraint#getColumn <em>Column</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.ColumnConstraint#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.mdde.MddePackage#getColumnConstraint()
 * @model
 * @generated
 */
public interface ColumnConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(long)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumnConstraint_Length()
	 * @model
	 * @generated
	 */
	long getLength();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.ColumnConstraint#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(long value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.mdde.Constraint#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' container reference.
	 * @see #setConstraint(Constraint)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumnConstraint_Constraint()
	 * @see de.thm.evolvedb.mdde.Constraint#getColumns
	 * @model opposite="columns" transient="false"
	 * @generated
	 */
	Constraint getConstraint();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.ColumnConstraint#getConstraint <em>Constraint</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' container reference.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(Constraint value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.mdde.Column#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference.
	 * @see #setColumn(Column)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumnConstraint_Column()
	 * @see de.thm.evolvedb.mdde.Column#getConstraints
	 * @model opposite="constraints"
	 * @generated
	 */
	Column getColumn();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.ColumnConstraint#getColumn <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' reference.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.thm.evolvedb.mdde.MddePackage#getColumnConstraint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.ColumnConstraint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ColumnConstraint
