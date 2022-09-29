/**
 */
package de.thm.evolvedb.migration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

import org.sidiff.difference.symmetric.SymmetricDifference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Migration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.migration.Migration#getSymmetricDifference <em>Symmetric Difference</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.Migration#getSchemaModificationOperators <em>Schema Modification Operators</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.Migration#getSymetricDifferenceModel <em>Symetric Difference Model</em>}</li>
 *   <li>{@link de.thm.evolvedb.migration.Migration#getUriSymetricDifferenceModel <em>Uri Symetric Difference Model</em>}</li>
 * </ul>
 *
 * @see de.thm.evolvedb.migration.MigrationPackage#getMigration()
 * @model
 * @generated
 */
public interface Migration extends EObject {
	/**
	 * Returns the value of the '<em><b>Symmetric Difference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symmetric Difference</em>' reference.
	 * @see #setSymmetricDifference(SymmetricDifference)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getMigration_SymmetricDifference()
	 * @model
	 * @generated
	 */
	SymmetricDifference getSymmetricDifference();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.Migration#getSymmetricDifference <em>Symmetric Difference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symmetric Difference</em>' reference.
	 * @see #getSymmetricDifference()
	 * @generated
	 */
	void setSymmetricDifference(SymmetricDifference value);

	/**
	 * Returns the value of the '<em><b>Schema Modification Operators</b></em>' containment reference list.
	 * The list contents are of type {@link de.thm.evolvedb.migration.SchemaModificationOperator}.
	 * It is bidirectional and its opposite is '{@link de.thm.evolvedb.migration.SchemaModificationOperator#getMigration <em>Migration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Modification Operators</em>' containment reference list.
	 * @see de.thm.evolvedb.migration.MigrationPackage#getMigration_SchemaModificationOperators()
	 * @see de.thm.evolvedb.migration.SchemaModificationOperator#getMigration
	 * @model opposite="migration" containment="true"
	 * @generated
	 */
	EList<SchemaModificationOperator> getSchemaModificationOperators();

	/**
	 * Returns the value of the '<em><b>Symetric Difference Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symetric Difference Model</em>' attribute.
	 * @see #setSymetricDifferenceModel(Resource)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getMigration_SymetricDifferenceModel()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	Resource getSymetricDifferenceModel();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.Migration#getSymetricDifferenceModel <em>Symetric Difference Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symetric Difference Model</em>' attribute.
	 * @see #getSymetricDifferenceModel()
	 * @generated
	 */
	void setSymetricDifferenceModel(Resource value);

	/**
	 * Returns the value of the '<em><b>Uri Symetric Difference Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri Symetric Difference Model</em>' attribute.
	 * @see #setUriSymetricDifferenceModel(String)
	 * @see de.thm.evolvedb.migration.MigrationPackage#getMigration_UriSymetricDifferenceModel()
	 * @model
	 * @generated
	 */
	String getUriSymetricDifferenceModel();

	/**
	 * Sets the value of the '{@link de.thm.evolvedb.migration.Migration#getUriSymetricDifferenceModel <em>Uri Symetric Difference Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri Symetric Difference Model</em>' attribute.
	 * @see #getUriSymetricDifferenceModel()
	 * @generated
	 */
	void setUriSymetricDifferenceModel(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ResolvableOperator> getResolvableSMO();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<PartiallyResolvable> getPartiallyResovableSMO();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<NotAutomaticallyResolvable> getNotAutimaticallyResolvable();

} // Migration
