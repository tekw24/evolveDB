/**
 */
package de.thm.evolvedb.migration.util;

import de.thm.evolvedb.migration.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationPackage
 * @generated
 */
public class MigrationValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MigrationValidator INSTANCE = new MigrationValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.thm.evolvedb.migration";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate SMO' of 'Schema Modification Operator'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SCHEMA_MODIFICATION_OPERATOR__VALIDATE_SMO = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return MigrationPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR:
				return validateSchemaModificationOperator((SchemaModificationOperator)value, diagnostics, context);
			case MigrationPackage.MIGRATION:
				return validateMigration((Migration)value, diagnostics, context);
			case MigrationPackage.RESOLVABLE_OPERATOR:
				return validateResolvableOperator((ResolvableOperator)value, diagnostics, context);
			case MigrationPackage.PARTIALLY_RESOLVABLE:
				return validatePartiallyResolvable((PartiallyResolvable)value, diagnostics, context);
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE:
				return validateNotAutomaticallyResolvable((NotAutomaticallyResolvable)value, diagnostics, context);
			case MigrationPackage.PROCESS_STATUS:
				return validateProcessStatus((ProcessStatus)value, diagnostics, context);
			case MigrationPackage.RESOLVABLE_OPERATOR_TYPE:
				return validateResolvableOperatorType((ResolvableOperatorType)value, diagnostics, context);
			case MigrationPackage.PARTIALLY_RESOLVABLE_OPERATOR_TYPE:
				return validatePartiallyResolvableOperatorType((PartiallyResolvableOperatorType)value, diagnostics, context);
			case MigrationPackage.NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR_TYPE:
				return validateNotAutomaticallyResolvableOperatorType((NotAutomaticallyResolvableOperatorType)value, diagnostics, context);
			case MigrationPackage.COLUMN_OPTIONS:
				return validateColumnOptions((ColumnOptions)value, diagnostics, context);
			case MigrationPackage.COMPLEX_RESOLVE_OPTIONS:
				return validateComplexResolveOptions((ComplexResolveOptions)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSchemaModificationOperator(SchemaModificationOperator schemaModificationOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(schemaModificationOperator, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(schemaModificationOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(schemaModificationOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(schemaModificationOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(schemaModificationOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(schemaModificationOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(schemaModificationOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(schemaModificationOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(schemaModificationOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validateSchemaModificationOperator_validateSMO(schemaModificationOperator, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSMO constraint of '<em>Schema Modification Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSchemaModificationOperator_validateSMO(SchemaModificationOperator schemaModificationOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return schemaModificationOperator.validateSMO(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMigration(Migration migration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(migration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResolvableOperator(ResolvableOperator resolvableOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(resolvableOperator, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(resolvableOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resolvableOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resolvableOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(resolvableOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resolvableOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resolvableOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resolvableOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resolvableOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validateSchemaModificationOperator_validateSMO(resolvableOperator, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartiallyResolvable(PartiallyResolvable partiallyResolvable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(partiallyResolvable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(partiallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(partiallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(partiallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(partiallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(partiallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(partiallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(partiallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(partiallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validateSchemaModificationOperator_validateSMO(partiallyResolvable, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNotAutomaticallyResolvable(NotAutomaticallyResolvable notAutomaticallyResolvable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(notAutomaticallyResolvable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(notAutomaticallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(notAutomaticallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(notAutomaticallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(notAutomaticallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(notAutomaticallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(notAutomaticallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(notAutomaticallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(notAutomaticallyResolvable, diagnostics, context);
		if (result || diagnostics != null) result &= validateSchemaModificationOperator_validateSMO(notAutomaticallyResolvable, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessStatus(ProcessStatus processStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResolvableOperatorType(ResolvableOperatorType resolvableOperatorType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartiallyResolvableOperatorType(PartiallyResolvableOperatorType partiallyResolvableOperatorType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNotAutomaticallyResolvableOperatorType(NotAutomaticallyResolvableOperatorType notAutomaticallyResolvableOperatorType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateColumnOptions(ColumnOptions columnOptions, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComplexResolveOptions(ComplexResolveOptions complexResolveOptions, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MigrationValidator
