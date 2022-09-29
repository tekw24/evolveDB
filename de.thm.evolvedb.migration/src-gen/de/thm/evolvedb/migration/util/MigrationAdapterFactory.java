/**
 */
package de.thm.evolvedb.migration.util;

import de.thm.evolvedb.migration.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage
 * @generated
 */
public class MigrationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MigrationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MigrationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MigrationSwitch<Adapter> modelSwitch =
		new MigrationSwitch<Adapter>() {
			@Override
			public Adapter caseSchemaModificationOperator(SchemaModificationOperator object) {
				return createSchemaModificationOperatorAdapter();
			}
			@Override
			public Adapter caseMigration(Migration object) {
				return createMigrationAdapter();
			}
			@Override
			public Adapter caseResolvableOperator(ResolvableOperator object) {
				return createResolvableOperatorAdapter();
			}
			@Override
			public Adapter casePartiallyResolvable(PartiallyResolvable object) {
				return createPartiallyResolvableAdapter();
			}
			@Override
			public Adapter caseNotAutomaticallyResolvable(NotAutomaticallyResolvable object) {
				return createNotAutomaticallyResolvableAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.thm.evolvedb.migration.SchemaModificationOperator <em>Schema Modification Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.thm.evolvedb.migration.SchemaModificationOperator
	 * @generated
	 */
	public Adapter createSchemaModificationOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.thm.evolvedb.migration.Migration <em>Migration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.thm.evolvedb.migration.Migration
	 * @generated
	 */
	public Adapter createMigrationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.thm.evolvedb.migration.ResolvableOperator <em>Resolvable Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.thm.evolvedb.migration.ResolvableOperator
	 * @generated
	 */
	public Adapter createResolvableOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.thm.evolvedb.migration.PartiallyResolvable <em>Partially Resolvable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.thm.evolvedb.migration.PartiallyResolvable
	 * @generated
	 */
	public Adapter createPartiallyResolvableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.thm.evolvedb.migration.NotAutomaticallyResolvable <em>Not Automatically Resolvable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.thm.evolvedb.migration.NotAutomaticallyResolvable
	 * @generated
	 */
	public Adapter createNotAutomaticallyResolvableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MigrationAdapterFactory
