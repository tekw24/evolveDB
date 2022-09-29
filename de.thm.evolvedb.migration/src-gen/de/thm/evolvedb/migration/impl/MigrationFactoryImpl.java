/**
 */
package de.thm.evolvedb.migration.impl;

import de.thm.evolvedb.migration.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MigrationFactoryImpl extends EFactoryImpl implements MigrationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MigrationFactory init() {
		try {
			MigrationFactory theMigrationFactory = (MigrationFactory)EPackage.Registry.INSTANCE.getEFactory(MigrationPackage.eNS_URI);
			if (theMigrationFactory != null) {
				return theMigrationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MigrationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MigrationPackage.MIGRATION: return createMigration();
			case MigrationPackage.RESOLVABLE_OPERATOR: return createResolvableOperator();
			case MigrationPackage.PARTIALLY_RESOLVABLE: return createPartiallyResolvable();
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE: return createNotAutomaticallyResolvable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MigrationPackage.PROCESS_STATUS:
				return createProcessStatusFromString(eDataType, initialValue);
			case MigrationPackage.RESOLVABLE_OPERATOR_TYPE:
				return createResolvableOperatorTypeFromString(eDataType, initialValue);
			case MigrationPackage.PARTIALLY_RESOLVABLE_OPERATOR_TYPE:
				return createPartiallyResolvableOperatorTypeFromString(eDataType, initialValue);
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR_TYPE:
				return createNotAutomaticallyResolvableOperatorTypeFromString(eDataType, initialValue);
			case MigrationPackage.COLUMN_OPTIONS:
				return createColumnOptionsFromString(eDataType, initialValue);
			case MigrationPackage.COMPLEX_RESOLVE_OPTIONS:
				return createComplexResolveOptionsFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MigrationPackage.PROCESS_STATUS:
				return convertProcessStatusToString(eDataType, instanceValue);
			case MigrationPackage.RESOLVABLE_OPERATOR_TYPE:
				return convertResolvableOperatorTypeToString(eDataType, instanceValue);
			case MigrationPackage.PARTIALLY_RESOLVABLE_OPERATOR_TYPE:
				return convertPartiallyResolvableOperatorTypeToString(eDataType, instanceValue);
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR_TYPE:
				return convertNotAutomaticallyResolvableOperatorTypeToString(eDataType, instanceValue);
			case MigrationPackage.COLUMN_OPTIONS:
				return convertColumnOptionsToString(eDataType, instanceValue);
			case MigrationPackage.COMPLEX_RESOLVE_OPTIONS:
				return convertComplexResolveOptionsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Migration createMigration() {
		MigrationImpl migration = new MigrationImpl();
		return migration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolvableOperator createResolvableOperator() {
		ResolvableOperatorImpl resolvableOperator = new ResolvableOperatorImpl();
		return resolvableOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartiallyResolvable createPartiallyResolvable() {
		PartiallyResolvableImpl partiallyResolvable = new PartiallyResolvableImpl();
		return partiallyResolvable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotAutomaticallyResolvable createNotAutomaticallyResolvable() {
		NotAutomaticallyResolvableImpl notAutomaticallyResolvable = new NotAutomaticallyResolvableImpl();
		return notAutomaticallyResolvable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessStatus createProcessStatusFromString(EDataType eDataType, String initialValue) {
		ProcessStatus result = ProcessStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProcessStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolvableOperatorType createResolvableOperatorTypeFromString(EDataType eDataType, String initialValue) {
		ResolvableOperatorType result = ResolvableOperatorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResolvableOperatorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartiallyResolvableOperatorType createPartiallyResolvableOperatorTypeFromString(EDataType eDataType, String initialValue) {
		PartiallyResolvableOperatorType result = PartiallyResolvableOperatorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPartiallyResolvableOperatorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotAutomaticallyResolvableOperatorType createNotAutomaticallyResolvableOperatorTypeFromString(EDataType eDataType, String initialValue) {
		NotAutomaticallyResolvableOperatorType result = NotAutomaticallyResolvableOperatorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotAutomaticallyResolvableOperatorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnOptions createColumnOptionsFromString(EDataType eDataType, String initialValue) {
		ColumnOptions result = ColumnOptions.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColumnOptionsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexResolveOptions createComplexResolveOptionsFromString(EDataType eDataType, String initialValue) {
		ComplexResolveOptions result = ComplexResolveOptions.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComplexResolveOptionsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationPackage getMigrationPackage() {
		return (MigrationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MigrationPackage getPackage() {
		return MigrationPackage.eINSTANCE;
	}

} //MigrationFactoryImpl
