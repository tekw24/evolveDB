/**
 */
package de.thm.evolvedb.mdde.util;

import de.thm.evolvedb.mdde.*;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.mdde.MddePackage
 * @generated
 */
public class MddeValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MddeValidator INSTANCE = new MddeValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.thm.evolvedb.mdde";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Only One Auto Increment Column' of 'Table'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TABLE__ONLY_ONE_AUTO_INCREMENT_COLUMN = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Non Key Auto Increment Column' of 'Table'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TABLE__NON_KEY_AUTO_INCREMENT_COLUMN = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Table Requires AKey Column' of 'Table'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TABLE__TABLE_REQUIRES_AKEY_COLUMN = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Table Requires At Least One Column' of 'Table'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TABLE__TABLE_REQUIRES_AT_LEAST_ONE_COLUMN = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Constraint Name' of 'Foreign Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOREIGN_KEY__VALIDATE_CONSTRAINT_NAME = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Foreign Key Has To Reference AKey Column' of 'Foreign Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOREIGN_KEY__FOREIGN_KEY_HAS_TO_REFERENCE_AKEY_COLUMN = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Not Null' of 'Named Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMED_ELEMENT__NAME_NOT_NULL = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Default Value' of 'Column'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLUMN__VALIDATE_DEFAULT_VALUE = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Size Value' of 'Column'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLUMN__VALIDATE_SIZE_VALUE = 9;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 9;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Delegates evaluation of the given invariant expression against the object in the given context.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context, String validationDelegate, EOperation invariant, String expression, int severity, String source, int code) {
		return EObjectValidator.validate(eClass, eObject, diagnostics, context, validationDelegate, invariant, expression, severity, source, code);
	}

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MddeValidator() {
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
	  return MddePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
			case MddePackage.TABLE:
				return validateTable((Table)value, diagnostics, context);
			case MddePackage.PRIMARY_KEY:
				return validatePrimaryKey((PrimaryKey)value, diagnostics, context);
			case MddePackage.FOREIGN_KEY:
				return validateForeignKey((ForeignKey)value, diagnostics, context);
			case MddePackage.NAMED_ELEMENT:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case MddePackage.DATABASE_SCHEMA:
				return validateDatabase_Schema((Database_Schema)value, diagnostics, context);
			case MddePackage.COLUMN:
				return validateColumn((Column)value, diagnostics, context);
			case MddePackage.DATA_TYPE:
				return validateDataType((DataType)value, diagnostics, context);
			case MddePackage.REFERENTIAL_ACTION:
				return validateReferential_Action((Referential_Action)value, diagnostics, context);
			case MddePackage.COLUMN_SIZE:
				return validateColumnSize((String)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTable(Table table, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(table, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(table, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(table, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(table, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(table, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(table, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(table, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(table, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(table, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedElement_NameNotNull(table, diagnostics, context);
		if (result || diagnostics != null) result &= validateTable_TableRequiresAtLeastOneColumn(table, diagnostics, context);
		if (result || diagnostics != null) result &= validateTable_OnlyOneAutoIncrementColumn(table, diagnostics, context);
		if (result || diagnostics != null) result &= validateTable_NonKeyAutoIncrementColumn(table, diagnostics, context);
		if (result || diagnostics != null) result &= validateTable_TableRequiresAKeyColumn(table, diagnostics, context);
		return result;
	}

	/**
	 * Validates the TableRequiresAtLeastOneColumn constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTable_TableRequiresAtLeastOneColumn(Table table, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return table.TableRequiresAtLeastOneColumn(diagnostics, context);
	}

	/**
	 * Validates the TableRequiresAKeyColumn constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTable_TableRequiresAKeyColumn(Table table, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return table.TableRequiresAKeyColumn(diagnostics, context);
	}

	/**
	 * Validates the OnlyOneAutoIncrementColumn constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTable_OnlyOneAutoIncrementColumn(Table table, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return table.OnlyOneAutoIncrementColumn(diagnostics, context);
	}

	/**
	 * Validates the NonKeyAutoIncrementColumn constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTable_NonKeyAutoIncrementColumn(Table table, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return table.NonKeyAutoIncrementColumn(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimaryKey(PrimaryKey primaryKey, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(primaryKey, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(primaryKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(primaryKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(primaryKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(primaryKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(primaryKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(primaryKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(primaryKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(primaryKey, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedElement_NameNotNull(primaryKey, diagnostics, context);
		if (result || diagnostics != null) result &= validateColumn_validateDefaultValue(primaryKey, diagnostics, context);
		if (result || diagnostics != null) result &= validateColumn_validateSizeValue(primaryKey, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForeignKey(ForeignKey foreignKey, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(foreignKey, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedElement_NameNotNull(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validateColumn_validateDefaultValue(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validateColumn_validateSizeValue(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validateForeignKey_ForeignKeyHasToReferenceAKeyColumn(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validateForeignKey_validateConstraintName(foreignKey, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ForeignKeyHasToReferenceAKeyColumn constraint of '<em>Foreign Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForeignKey_ForeignKeyHasToReferenceAKeyColumn(ForeignKey foreignKey,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return foreignKey.ForeignKeyHasToReferenceAKeyColumn(diagnostics, context);
	}

	/**
	 * Validates the validateConstraintName constraint of '<em>Foreign Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForeignKey_validateConstraintName(ForeignKey foreignKey, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return foreignKey.validateConstraintName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(namedElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedElement_NameNotNull(namedElement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NameNotNull constraint of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement_NameNotNull(NamedElement namedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return namedElement.NameNotNull(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDatabase_Schema(Database_Schema database_Schema, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(database_Schema, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(database_Schema, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(database_Schema, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(database_Schema, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(database_Schema, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(database_Schema, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(database_Schema, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(database_Schema, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(database_Schema, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedElement_NameNotNull(database_Schema, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateColumn(Column column, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(column, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(column, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(column, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(column, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(column, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(column, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(column, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(column, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(column, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedElement_NameNotNull(column, diagnostics, context);
		if (result || diagnostics != null) result &= validateColumn_validateDefaultValue(column, diagnostics, context);
		if (result || diagnostics != null) result &= validateColumn_validateSizeValue(column, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDefaultValue constraint of '<em>Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateColumn_validateDefaultValue(Column column, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return column.validateDefaultValue(diagnostics, context);
	}

	/**
	 * Validates the validateSizeValue constraint of '<em>Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateColumn_validateSizeValue(Column column, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return column.validateSizeValue(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferential_Action(Referential_Action referential_Action, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateColumnSize(String columnSize, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MddeValidator
