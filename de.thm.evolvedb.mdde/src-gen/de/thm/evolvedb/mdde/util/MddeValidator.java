/**
 */
package de.thm.evolvedb.mdde.util;

import de.thm.evolvedb.mdde.*;

import java.util.Map;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Constraint Name' of 'Foreign Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FOREIGN_KEY__VALIDATE_CONSTRAINT_NAME = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Default Value' of 'Column'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLUMN__VALIDATE_DEFAULT_VALUE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Size Value' of 'Column'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLUMN__VALIDATE_SIZE_VALUE = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Constraint Name' of 'Column'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLUMN__VALIDATE_UNIQUE_CONSTRAINT_NAME = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Constraint Name' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__VALIDATE_UNIQUE_CONSTRAINT_NAME = 5;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 5;

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
			case MddePackage.CONSTRAINT:
				return validateConstraint((Constraint)value, diagnostics, context);
			case MddePackage.UNIQUE_CONSTRAINT:
				return validateUniqueConstraint((UniqueConstraint)value, diagnostics, context);
			case MddePackage.INDEX:
				return validateIndex((Index)value, diagnostics, context);
			case MddePackage.COLUMN_CONSTRAINT:
				return validateColumnConstraint((ColumnConstraint)value, diagnostics, context);
			case MddePackage.DATA_TYPE:
				return validateDataType((DataType)value, diagnostics, context);
			case MddePackage.REFERENTIAL_ACTION:
				return validateReferential_Action((Referential_Action)value, diagnostics, context);
			case MddePackage.SORT_SEQUENCE:
				return validateSortSequence((SortSequence)value, diagnostics, context);
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
		return result;
	}

	/**
	 * The cached validation expression for the TableRequiresAtLeastOneColumn constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TABLE__TABLE_REQUIRES_AT_LEAST_ONE_COLUMN__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'The Table ' + Table.name + ' requires at least one column!',\n" +
		"\tstatus : Boolean = self.columns->notEmpty()\n" +
		"}.status";

	/**
	 * Validates the TableRequiresAtLeastOneColumn constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTable_TableRequiresAtLeastOneColumn(Table table, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MddePackage.Literals.TABLE,
				 table,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "TableRequiresAtLeastOneColumn",
				 TABLE__TABLE_REQUIRES_AT_LEAST_ONE_COLUMN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * Validates the OnlyOneAutoIncrementColumn constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTable_OnlyOneAutoIncrementColumn(Table table, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MddePackage.Literals.TABLE,
				 table,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "OnlyOneAutoIncrementColumn",
				 TABLE__ONLY_ONE_AUTO_INCREMENT_COLUMN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the NonKeyAutoIncrementColumn constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TABLE__NON_KEY_AUTO_INCREMENT_COLUMN__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'Incorrect table definition; The table ' + Table.name + '  can only have one auto column and it must be defined as a key!',\n" +
		"\tstatus : Boolean = self.columns-> notEmpty() and\n" +
		"\t\t((columns->one(c1 | c1.oclIsTypeOf(PrimaryKey) and c1.autoIncrement)) or ((columns-> select(c1 | c1.oclIsTypeOf(PrimaryKey)) -> isEmpty()) and columns->exists(c1 | c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)) or (columns-> select(c1 | c1.autoIncrement) -> isEmpty()))\n" +
		"}.status";

	/**
	 * Validates the NonKeyAutoIncrementColumn constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTable_NonKeyAutoIncrementColumn(Table table, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MddePackage.Literals.TABLE,
				 table,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "NonKeyAutoIncrementColumn",
				 TABLE__NON_KEY_AUTO_INCREMENT_COLUMN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the OnlyOneAutoIncrementColumn constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TABLE__ONLY_ONE_AUTO_INCREMENT_COLUMN__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'Incorrect table definition; The table ' + Table.name + '  can only have one auto column and it must be defined as a key!',\n" +
		"\tstatus : Boolean = self.columns-> notEmpty() and\n" +
		"\t\t((columns->one(c1 | c1.autoIncrement)) or (columns-> select(c1 | c1.autoIncrement) -> isEmpty()) or ((columns-> select(c1 | c1.oclIsTypeOf(PrimaryKey)) -> isEmpty()) and columns->exists(c1 | c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)))\n" +
		"}.status";

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
		if (result || diagnostics != null) result &= validateColumn_validateUniqueConstraintName(primaryKey, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
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
		if (result || diagnostics != null) result &= validateColumn_validateUniqueConstraintName(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validateForeignKey_ForeignKeyHasToReferenceAKeyColumn(foreignKey, diagnostics, context);
		if (result || diagnostics != null) result &= validateForeignKey_validateConstraintName(foreignKey, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the ForeignKeyHasToReferenceAKeyColumn constraint of '<em>Foreign Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FOREIGN_KEY__FOREIGN_KEY_HAS_TO_REFERENCE_AKEY_COLUMN__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'The referenced column should not be empty!',\n" +
		"\tstatus : Boolean = self.referencedTable-> notEmpty()\n" +
		"}.status";

	/**
	 * Validates the ForeignKeyHasToReferenceAKeyColumn constraint of '<em>Foreign Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForeignKey_ForeignKeyHasToReferenceAKeyColumn(ForeignKey foreignKey, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MddePackage.Literals.FOREIGN_KEY,
				 foreignKey,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "ForeignKeyHasToReferenceAKeyColumn",
				 FOREIGN_KEY__FOREIGN_KEY_HAS_TO_REFERENCE_AKEY_COLUMN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * Validates the validateConstraintName constraint of '<em>Foreign Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateForeignKey_validateConstraintName(ForeignKey foreignKey, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
	 * The cached validation expression for the NameNotNull constraint of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NAMED_ELEMENT__NAME_NOT_NULL__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'Name should not be empty!',\n" +
		"\tstatus : Boolean = self.name->size() > 0\n" +
		"}.status";

	/**
	 * Validates the NameNotNull constraint of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement_NameNotNull(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MddePackage.Literals.NAMED_ELEMENT,
				 namedElement,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "NameNotNull",
				 NAMED_ELEMENT__NAME_NOT_NULL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
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
		if (result || diagnostics != null) result &= validateColumn_validateUniqueConstraintName(column, diagnostics, context);
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
	 * Validates the validateUniqueConstraintName constraint of '<em>Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateColumn_validateUniqueConstraintName(Column column, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return column.validateUniqueConstraintName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(constraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedElement_NameNotNull(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_ConstraintWithoutColumn(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_validateUniqueConstraintName(constraint, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the ConstraintWithoutColumn constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CONSTRAINT__CONSTRAINT_WITHOUT_COLUMN__EEXPRESSION = "Tuple {\n" +
		"\tmessage : String = 'The Constraint ' + Constraint.name + ' has to reference at least one column!',\n" +
		"\tstatus : Boolean = self.columns->notEmpty()\n" +
		"}.status";

	/**
	 * Validates the ConstraintWithoutColumn constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_ConstraintWithoutColumn(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MddePackage.Literals.CONSTRAINT,
				 constraint,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "ConstraintWithoutColumn",
				 CONSTRAINT__CONSTRAINT_WITHOUT_COLUMN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * Validates the validateUniqueConstraintName constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateUniqueConstraintName(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return constraint.validateUniqueConstraintName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUniqueConstraint(UniqueConstraint uniqueConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(uniqueConstraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(uniqueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(uniqueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(uniqueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(uniqueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(uniqueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(uniqueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(uniqueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(uniqueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedElement_NameNotNull(uniqueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_ConstraintWithoutColumn(uniqueConstraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_validateUniqueConstraintName(uniqueConstraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIndex(Index index, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(index, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(index, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(index, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(index, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(index, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(index, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(index, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(index, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(index, diagnostics, context);
		if (result || diagnostics != null) result &= validateNamedElement_NameNotNull(index, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_ConstraintWithoutColumn(index, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_validateUniqueConstraintName(index, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateColumnConstraint(ColumnConstraint columnConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(columnConstraint, diagnostics, context);
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
	public boolean validateSortSequence(SortSequence sortSequence, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
