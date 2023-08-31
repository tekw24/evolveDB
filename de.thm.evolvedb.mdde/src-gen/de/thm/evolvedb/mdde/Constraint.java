/**
 */
package de.thm.evolvedb.mdde;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.Constraint#getColumns <em>Columns</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Constraint#getTable <em>Table</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.Constraint#getSortSequence <em>Sort Sequence</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.mdde.MddePackage#getConstraint()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ConstraintWithoutColumn'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot ConstraintWithoutColumn='Tuple {\n\tmessage : String = \'The Constraint \' + Constraint.name + \' has to reference at least one column!\',\n\tstatus : Boolean = self.columns-&gt;notEmpty()\n}.status'"
 * @generated
 */
public interface Constraint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.evolvedb.mdde.ColumnConstraint}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.mdde.ColumnConstraint#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see de.thm.evolvedb.mdde.MddePackage#getConstraint_Columns()
	 * @see de.thm.evolvedb.mdde.ColumnConstraint#getConstraint
	 * @model opposite="constraint" containment="true"
	 * @generated
	 */
	EList<ColumnConstraint> getColumns();

	/**
	 * Returns the value of the '<em><b>Table</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.mdde.Table#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' container reference.
	 * @see #setTable(Table)
	 * @see de.thm.evolvedb.mdde.MddePackage#getConstraint_Table()
	 * @see de.thm.evolvedb.mdde.Table#getConstraints
	 * @model opposite="constraints" transient="false"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Constraint#getTable <em>Table</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' container reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Sort Sequence</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.mdde.SortSequence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sort Sequence</em>' attribute.
	 * @see de.thm.evolvedb.mdde.SortSequence
	 * @see #setSortSequence(SortSequence)
	 * @see de.thm.evolvedb.mdde.MddePackage#getConstraint_SortSequence()
	 * @model
	 * @generated
	 */
	SortSequence getSortSequence();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.mdde.Constraint#getSortSequence <em>Sort Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sort Sequence</em>' attribute.
	 * @see de.thm.evolvedb.mdde.SortSequence
	 * @see #getSortSequence()
	 * @generated
	 */
	void setSortSequence(SortSequence value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validateUniqueConstraintName(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Constraint
