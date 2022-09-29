/**
 */
package de.thm.evolvedb.migration.util;

import de.thm.evolvedb.migration.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage
 * @generated
 */
public class MigrationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MigrationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationSwitch() {
		if (modelPackage == null) {
			modelPackage = MigrationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR: {
				SchemaModificationOperator schemaModificationOperator = (SchemaModificationOperator)theEObject;
				T result = caseSchemaModificationOperator(schemaModificationOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MigrationPackage.MIGRATION: {
				Migration migration = (Migration)theEObject;
				T result = caseMigration(migration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MigrationPackage.RESOLVABLE_OPERATOR: {
				ResolvableOperator resolvableOperator = (ResolvableOperator)theEObject;
				T result = caseResolvableOperator(resolvableOperator);
				if (result == null) result = caseSchemaModificationOperator(resolvableOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MigrationPackage.PARTIALLY_RESOLVABLE: {
				PartiallyResolvable partiallyResolvable = (PartiallyResolvable)theEObject;
				T result = casePartiallyResolvable(partiallyResolvable);
				if (result == null) result = caseSchemaModificationOperator(partiallyResolvable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE: {
				NotAutomaticallyResolvable notAutomaticallyResolvable = (NotAutomaticallyResolvable)theEObject;
				T result = caseNotAutomaticallyResolvable(notAutomaticallyResolvable);
				if (result == null) result = caseSchemaModificationOperator(notAutomaticallyResolvable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schema Modification Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schema Modification Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchemaModificationOperator(SchemaModificationOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Migration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Migration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMigration(Migration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolvable Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolvable Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolvableOperator(ResolvableOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partially Resolvable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partially Resolvable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartiallyResolvable(PartiallyResolvable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Automatically Resolvable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Automatically Resolvable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotAutomaticallyResolvable(NotAutomaticallyResolvable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MigrationSwitch
