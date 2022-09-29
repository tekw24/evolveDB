/**
 */
package de.thm.evolvedb.migration;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.difference.symmetric.SemanticChangeSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schema Modification Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.SchemaModificationOperator#getSemanticChangeSets <em>Semantic Change Sets</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.SchemaModificationOperator#getProcessStatus <em>Process Status</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.SchemaModificationOperator#getMigration <em>Migration</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.SchemaModificationOperator#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.migration.MigrationPackage#getSchemaModificationOperator()
 * @model abstract="true"
 * @generated
 */
public interface SchemaModificationOperator extends EObject {
	/**
	 * Returns the value of the '<em><b>Semantic Change Sets</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.difference.symmetric.SemanticChangeSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantic Change Sets</em>' reference list.
	 * @see de.thm.evolvedb.migration.MigrationPackage#getSchemaModificationOperator_SemanticChangeSets()
	 * @model
	 * @generated
	 */
	EList<SemanticChangeSet> getSemanticChangeSets();

	/**
	 * Returns the value of the '<em><b>Process Status</b></em>' attribute.
	 * The literals are from the enumeration {@link de.thm.evolvedb.migration.ProcessStatus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Status</em>' attribute.
	 * @see de.thm.evolvedb.migration.ProcessStatus
	 * @see #setProcessStatus(ProcessStatus)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getSchemaModificationOperator_ProcessStatus()
	 * @model required="true"
	 * @generated
	 */
	ProcessStatus getProcessStatus();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.SchemaModificationOperator#getProcessStatus <em>Process Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Status</em>' attribute.
	 * @see de.thm.evolvedb.migration.ProcessStatus
	 * @see #getProcessStatus()
	 * @generated
	 */
	void setProcessStatus(ProcessStatus value);

	/**
	 * Returns the value of the '<em><b>Migration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.migration.Migration#getSchemaModificationOperators <em>Schema Modification Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Migration</em>' container reference.
	 * @see #setMigration(Migration)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getSchemaModificationOperator_Migration()
	 * @see de.thm.evolvedb.migration.Migration#getSchemaModificationOperators
	 * @model opposite="schemaModificationOperators" transient="false"
	 * @generated
	 */
	Migration getMigration();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.SchemaModificationOperator#getMigration <em>Migration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Migration</em>' container reference.
	 * @see #getMigration()
	 * @generated
	 */
	void setMigration(Migration value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getSchemaModificationOperator_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.SchemaModificationOperator#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validateSMO(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SchemaModificationOperator
