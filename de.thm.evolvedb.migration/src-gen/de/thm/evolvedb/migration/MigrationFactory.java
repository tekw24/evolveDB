/**
 */
package de.thm.evolvedb.migration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage
 * @generated
 */
public interface MigrationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MigrationFactory eINSTANCE = de.thm.evolvedb.migration.impl.MigrationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Migration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Migration</em>'.
	 * @generated
	 */
	Migration createMigration();

	/**
	 * Returns a new object of class '<em>Resolvable Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolvable Operator</em>'.
	 * @generated
	 */
	ResolvableOperator createResolvableOperator();

	/**
	 * Returns a new object of class '<em>Partially Resolvable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partially Resolvable</em>'.
	 * @generated
	 */
	PartiallyResolvable createPartiallyResolvable();

	/**
	 * Returns a new object of class '<em>Not Automatically Resolvable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Automatically Resolvable</em>'.
	 * @generated
	 */
	NotAutomaticallyResolvable createNotAutomaticallyResolvable();

	/**
	 * Returns a new object of class '<em>Graph Resolvable Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph Resolvable Operator</em>'.
	 * @generated
	 */
	GraphResolvableOperator createGraphResolvableOperator();

	/**
	 * Returns a new object of class '<em>Graph Partially Resolvable Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph Partially Resolvable Operator</em>'.
	 * @generated
	 */
	GraphPartiallyResolvableOperator createGraphPartiallyResolvableOperator();

	/**
	 * Returns a new object of class '<em>Graph Not Automatically Resolvable Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph Not Automatically Resolvable Operator</em>'.
	 * @generated
	 */
	GraphNotAutomaticallyResolvableOperator createGraphNotAutomaticallyResolvableOperator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MigrationPackage getMigrationPackage();

} //MigrationFactory
