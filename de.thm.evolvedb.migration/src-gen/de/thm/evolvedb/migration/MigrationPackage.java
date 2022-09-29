/**
 */
package de.thm.evolvedb.migration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.migration.MigrationFactory
 * @model kind="package"
 * @generated
 */
public interface MigrationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "migration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.thm.de/migration";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "de.thm.mdde";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MigrationPackage eINSTANCE = de.thm.evolvedb.migration.impl.MigrationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.impl.SchemaModificationOperatorImpl <em>Schema Modification Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.impl.SchemaModificationOperatorImpl
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getSchemaModificationOperator()
	 * @generated
	 */
	int SCHEMA_MODIFICATION_OPERATOR = 0;

	/**
	 * The feature id for the '<em><b>Semantic Change Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS = 0;

	/**
	 * The feature id for the '<em><b>Process Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS = 1;

	/**
	 * The feature id for the '<em><b>Migration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_MODIFICATION_OPERATOR__MIGRATION = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Schema Modification Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_MODIFICATION_OPERATOR_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Validate SMO</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_MODIFICATION_OPERATOR___VALIDATE_SMO__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Schema Modification Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_MODIFICATION_OPERATOR_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.impl.MigrationImpl <em>Migration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.impl.MigrationImpl
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getMigration()
	 * @generated
	 */
	int MIGRATION = 1;

	/**
	 * The feature id for the '<em><b>Symmetric Difference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__SYMMETRIC_DIFFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Schema Modification Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__SCHEMA_MODIFICATION_OPERATORS = 1;

	/**
	 * The feature id for the '<em><b>Symetric Difference Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__SYMETRIC_DIFFERENCE_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Uri Symetric Difference Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__URI_SYMETRIC_DIFFERENCE_MODEL = 3;

	/**
	 * The number of structural features of the '<em>Migration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Resolvable SMO</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION___GET_RESOLVABLE_SMO = 0;

	/**
	 * The operation id for the '<em>Get Partially Resovable SMO</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION___GET_PARTIALLY_RESOVABLE_SMO = 1;

	/**
	 * The operation id for the '<em>Get Not Autimatically Resolvable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION___GET_NOT_AUTIMATICALLY_RESOLVABLE = 2;

	/**
	 * The number of operations of the '<em>Migration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.impl.ResolvableOperatorImpl <em>Resolvable Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.impl.ResolvableOperatorImpl
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getResolvableOperator()
	 * @generated
	 */
	int RESOLVABLE_OPERATOR = 2;

	/**
	 * The feature id for the '<em><b>Semantic Change Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVABLE_OPERATOR__SEMANTIC_CHANGE_SETS = SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS;

	/**
	 * The feature id for the '<em><b>Process Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVABLE_OPERATOR__PROCESS_STATUS = SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS;

	/**
	 * The feature id for the '<em><b>Migration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVABLE_OPERATOR__MIGRATION = SCHEMA_MODIFICATION_OPERATOR__MIGRATION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVABLE_OPERATOR__DESCRIPTION = SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVABLE_OPERATOR__DISPLAY_NAME = SCHEMA_MODIFICATION_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resolvable Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVABLE_OPERATOR_FEATURE_COUNT = SCHEMA_MODIFICATION_OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate SMO</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVABLE_OPERATOR___VALIDATE_SMO__DIAGNOSTICCHAIN_MAP = SCHEMA_MODIFICATION_OPERATOR___VALIDATE_SMO__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Resolvable Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVABLE_OPERATOR_OPERATION_COUNT = SCHEMA_MODIFICATION_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.impl.PartiallyResolvableImpl <em>Partially Resolvable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.impl.PartiallyResolvableImpl
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getPartiallyResolvable()
	 * @generated
	 */
	int PARTIALLY_RESOLVABLE = 3;

	/**
	 * The feature id for the '<em><b>Semantic Change Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_RESOLVABLE__SEMANTIC_CHANGE_SETS = SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS;

	/**
	 * The feature id for the '<em><b>Process Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_RESOLVABLE__PROCESS_STATUS = SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS;

	/**
	 * The feature id for the '<em><b>Migration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_RESOLVABLE__MIGRATION = SCHEMA_MODIFICATION_OPERATOR__MIGRATION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_RESOLVABLE__DESCRIPTION = SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_RESOLVABLE__DISPLAY_NAME = SCHEMA_MODIFICATION_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolve Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_RESOLVABLE__RESOLVE_OPTIONS = SCHEMA_MODIFICATION_OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Partially Resolvable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_RESOLVABLE_FEATURE_COUNT = SCHEMA_MODIFICATION_OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate SMO</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_RESOLVABLE___VALIDATE_SMO__DIAGNOSTICCHAIN_MAP = SCHEMA_MODIFICATION_OPERATOR___VALIDATE_SMO__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Partially Resolvable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_RESOLVABLE_OPERATION_COUNT = SCHEMA_MODIFICATION_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.impl.NotAutomaticallyResolvableImpl <em>Not Automatically Resolvable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.impl.NotAutomaticallyResolvableImpl
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getNotAutomaticallyResolvable()
	 * @generated
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE = 4;

	/**
	 * The feature id for the '<em><b>Semantic Change Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE__SEMANTIC_CHANGE_SETS = SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS;

	/**
	 * The feature id for the '<em><b>Process Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE__PROCESS_STATUS = SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS;

	/**
	 * The feature id for the '<em><b>Migration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE__MIGRATION = SCHEMA_MODIFICATION_OPERATOR__MIGRATION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE__DESCRIPTION = SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE__DISPLAY_NAME = SCHEMA_MODIFICATION_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolve Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE__RESOLVE_OPTIONS = SCHEMA_MODIFICATION_OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Not Automatically Resolvable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE_FEATURE_COUNT = SCHEMA_MODIFICATION_OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate SMO</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE___VALIDATE_SMO__DIAGNOSTICCHAIN_MAP = SCHEMA_MODIFICATION_OPERATOR___VALIDATE_SMO__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Not Automatically Resolvable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE_OPERATION_COUNT = SCHEMA_MODIFICATION_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.ProcessStatus <em>Process Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.ProcessStatus
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getProcessStatus()
	 * @generated
	 */
	int PROCESS_STATUS = 5;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.ResolvableOperatorType <em>Resolvable Operator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.ResolvableOperatorType
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getResolvableOperatorType()
	 * @generated
	 */
	int RESOLVABLE_OPERATOR_TYPE = 6;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.PartiallyResolvableOperatorType <em>Partially Resolvable Operator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.PartiallyResolvableOperatorType
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getPartiallyResolvableOperatorType()
	 * @generated
	 */
	int PARTIALLY_RESOLVABLE_OPERATOR_TYPE = 7;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType <em>Not Automatically Resolvable Operator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getNotAutomaticallyResolvableOperatorType()
	 * @generated
	 */
	int NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR_TYPE = 8;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.ColumnOptions <em>Column Options</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.ColumnOptions
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getColumnOptions()
	 * @generated
	 */
	int COLUMN_OPTIONS = 9;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.migration.ComplexResolveOptions <em>Complex Resolve Options</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.migration.ComplexResolveOptions
	 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getComplexResolveOptions()
	 * @generated
	 */
	int COMPLEX_RESOLVE_OPTIONS = 10;


	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.migration.SchemaModificationOperator <em>Schema Modification Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema Modification Operator</em>'.
	 * @see de.thm.evolvedb.migration.SchemaModificationOperator
	 * @generated
	 */
	EClass getSchemaModificationOperator();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.migration.SchemaModificationOperator#getSemanticChangeSets <em>Semantic Change Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Semantic Change Sets</em>'.
	 * @see de.thm.evolvedb.migration.SchemaModificationOperator#getSemanticChangeSets()
	 * @see #getSchemaModificationOperator()
	 * @generated
	 */
	EReference getSchemaModificationOperator_SemanticChangeSets();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.migration.SchemaModificationOperator#getProcessStatus <em>Process Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Status</em>'.
	 * @see de.thm.evolvedb.migration.SchemaModificationOperator#getProcessStatus()
	 * @see #getSchemaModificationOperator()
	 * @generated
	 */
	EAttribute getSchemaModificationOperator_ProcessStatus();

	/**
	 * Returns the meta object for the container reference '{@link de.thm.evolvedb.migration.SchemaModificationOperator#getMigration <em>Migration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Migration</em>'.
	 * @see de.thm.evolvedb.migration.SchemaModificationOperator#getMigration()
	 * @see #getSchemaModificationOperator()
	 * @generated
	 */
	EReference getSchemaModificationOperator_Migration();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.migration.SchemaModificationOperator#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.thm.evolvedb.migration.SchemaModificationOperator#getDescription()
	 * @see #getSchemaModificationOperator()
	 * @generated
	 */
	EAttribute getSchemaModificationOperator_Description();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.migration.SchemaModificationOperator#validateSMO(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate SMO</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate SMO</em>' operation.
	 * @see de.thm.evolvedb.migration.SchemaModificationOperator#validateSMO(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSchemaModificationOperator__ValidateSMO__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.migration.Migration <em>Migration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Migration</em>'.
	 * @see de.thm.evolvedb.migration.Migration
	 * @generated
	 */
	EClass getMigration();

	/**
	 * Returns the meta object for the reference '{@link de.thm.evolvedb.migration.Migration#getSymmetricDifference <em>Symmetric Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Symmetric Difference</em>'.
	 * @see de.thm.evolvedb.migration.Migration#getSymmetricDifference()
	 * @see #getMigration()
	 * @generated
	 */
	EReference getMigration_SymmetricDifference();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.migration.Migration#getSchemaModificationOperators <em>Schema Modification Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Schema Modification Operators</em>'.
	 * @see de.thm.evolvedb.migration.Migration#getSchemaModificationOperators()
	 * @see #getMigration()
	 * @generated
	 */
	EReference getMigration_SchemaModificationOperators();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.migration.Migration#getSymetricDifferenceModel <em>Symetric Difference Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symetric Difference Model</em>'.
	 * @see de.thm.evolvedb.migration.Migration#getSymetricDifferenceModel()
	 * @see #getMigration()
	 * @generated
	 */
	EAttribute getMigration_SymetricDifferenceModel();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.migration.Migration#getUriSymetricDifferenceModel <em>Uri Symetric Difference Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri Symetric Difference Model</em>'.
	 * @see de.thm.evolvedb.migration.Migration#getUriSymetricDifferenceModel()
	 * @see #getMigration()
	 * @generated
	 */
	EAttribute getMigration_UriSymetricDifferenceModel();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.migration.Migration#getResolvableSMO() <em>Get Resolvable SMO</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Resolvable SMO</em>' operation.
	 * @see de.thm.evolvedb.migration.Migration#getResolvableSMO()
	 * @generated
	 */
	EOperation getMigration__GetResolvableSMO();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.migration.Migration#getPartiallyResovableSMO() <em>Get Partially Resovable SMO</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Partially Resovable SMO</em>' operation.
	 * @see de.thm.evolvedb.migration.Migration#getPartiallyResovableSMO()
	 * @generated
	 */
	EOperation getMigration__GetPartiallyResovableSMO();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.migration.Migration#getNotAutimaticallyResolvable() <em>Get Not Autimatically Resolvable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Not Autimatically Resolvable</em>' operation.
	 * @see de.thm.evolvedb.migration.Migration#getNotAutimaticallyResolvable()
	 * @generated
	 */
	EOperation getMigration__GetNotAutimaticallyResolvable();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.migration.ResolvableOperator <em>Resolvable Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolvable Operator</em>'.
	 * @see de.thm.evolvedb.migration.ResolvableOperator
	 * @generated
	 */
	EClass getResolvableOperator();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.migration.ResolvableOperator#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see de.thm.evolvedb.migration.ResolvableOperator#getDisplayName()
	 * @see #getResolvableOperator()
	 * @generated
	 */
	EAttribute getResolvableOperator_DisplayName();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.migration.PartiallyResolvable <em>Partially Resolvable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partially Resolvable</em>'.
	 * @see de.thm.evolvedb.migration.PartiallyResolvable
	 * @generated
	 */
	EClass getPartiallyResolvable();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.migration.PartiallyResolvable#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see de.thm.evolvedb.migration.PartiallyResolvable#getDisplayName()
	 * @see #getPartiallyResolvable()
	 * @generated
	 */
	EAttribute getPartiallyResolvable_DisplayName();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.migration.PartiallyResolvable#getResolveOptions <em>Resolve Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolve Options</em>'.
	 * @see de.thm.evolvedb.migration.PartiallyResolvable#getResolveOptions()
	 * @see #getPartiallyResolvable()
	 * @generated
	 */
	EAttribute getPartiallyResolvable_ResolveOptions();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.migration.NotAutomaticallyResolvable <em>Not Automatically Resolvable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Automatically Resolvable</em>'.
	 * @see de.thm.evolvedb.migration.NotAutomaticallyResolvable
	 * @generated
	 */
	EClass getNotAutomaticallyResolvable();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.migration.NotAutomaticallyResolvable#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see de.thm.evolvedb.migration.NotAutomaticallyResolvable#getDisplayName()
	 * @see #getNotAutomaticallyResolvable()
	 * @generated
	 */
	EAttribute getNotAutomaticallyResolvable_DisplayName();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.migration.NotAutomaticallyResolvable#getResolveOptions <em>Resolve Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolve Options</em>'.
	 * @see de.thm.evolvedb.migration.NotAutomaticallyResolvable#getResolveOptions()
	 * @see #getNotAutomaticallyResolvable()
	 * @generated
	 */
	EAttribute getNotAutomaticallyResolvable_ResolveOptions();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.migration.ProcessStatus <em>Process Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Process Status</em>'.
	 * @see de.thm.evolvedb.migration.ProcessStatus
	 * @generated
	 */
	EEnum getProcessStatus();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.migration.ResolvableOperatorType <em>Resolvable Operator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resolvable Operator Type</em>'.
	 * @see de.thm.evolvedb.migration.ResolvableOperatorType
	 * @generated
	 */
	EEnum getResolvableOperatorType();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.migration.PartiallyResolvableOperatorType <em>Partially Resolvable Operator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Partially Resolvable Operator Type</em>'.
	 * @see de.thm.evolvedb.migration.PartiallyResolvableOperatorType
	 * @generated
	 */
	EEnum getPartiallyResolvableOperatorType();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType <em>Not Automatically Resolvable Operator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Not Automatically Resolvable Operator Type</em>'.
	 * @see de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType
	 * @generated
	 */
	EEnum getNotAutomaticallyResolvableOperatorType();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.migration.ColumnOptions <em>Column Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Column Options</em>'.
	 * @see de.thm.evolvedb.migration.ColumnOptions
	 * @generated
	 */
	EEnum getColumnOptions();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.migration.ComplexResolveOptions <em>Complex Resolve Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Complex Resolve Options</em>'.
	 * @see de.thm.evolvedb.migration.ComplexResolveOptions
	 * @generated
	 */
	EEnum getComplexResolveOptions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MigrationFactory getMigrationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.impl.SchemaModificationOperatorImpl <em>Schema Modification Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.impl.SchemaModificationOperatorImpl
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getSchemaModificationOperator()
		 * @generated
		 */
		EClass SCHEMA_MODIFICATION_OPERATOR = eINSTANCE.getSchemaModificationOperator();

		/**
		 * The meta object literal for the '<em><b>Semantic Change Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS = eINSTANCE.getSchemaModificationOperator_SemanticChangeSets();

		/**
		 * The meta object literal for the '<em><b>Process Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS = eINSTANCE.getSchemaModificationOperator_ProcessStatus();

		/**
		 * The meta object literal for the '<em><b>Migration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEMA_MODIFICATION_OPERATOR__MIGRATION = eINSTANCE.getSchemaModificationOperator_Migration();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION = eINSTANCE.getSchemaModificationOperator_Description();

		/**
		 * The meta object literal for the '<em><b>Validate SMO</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEMA_MODIFICATION_OPERATOR___VALIDATE_SMO__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSchemaModificationOperator__ValidateSMO__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.impl.MigrationImpl <em>Migration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.impl.MigrationImpl
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getMigration()
		 * @generated
		 */
		EClass MIGRATION = eINSTANCE.getMigration();

		/**
		 * The meta object literal for the '<em><b>Symmetric Difference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIGRATION__SYMMETRIC_DIFFERENCE = eINSTANCE.getMigration_SymmetricDifference();

		/**
		 * The meta object literal for the '<em><b>Schema Modification Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIGRATION__SCHEMA_MODIFICATION_OPERATORS = eINSTANCE.getMigration_SchemaModificationOperators();

		/**
		 * The meta object literal for the '<em><b>Symetric Difference Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION__SYMETRIC_DIFFERENCE_MODEL = eINSTANCE.getMigration_SymetricDifferenceModel();

		/**
		 * The meta object literal for the '<em><b>Uri Symetric Difference Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION__URI_SYMETRIC_DIFFERENCE_MODEL = eINSTANCE.getMigration_UriSymetricDifferenceModel();

		/**
		 * The meta object literal for the '<em><b>Get Resolvable SMO</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MIGRATION___GET_RESOLVABLE_SMO = eINSTANCE.getMigration__GetResolvableSMO();

		/**
		 * The meta object literal for the '<em><b>Get Partially Resovable SMO</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MIGRATION___GET_PARTIALLY_RESOVABLE_SMO = eINSTANCE.getMigration__GetPartiallyResovableSMO();

		/**
		 * The meta object literal for the '<em><b>Get Not Autimatically Resolvable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MIGRATION___GET_NOT_AUTIMATICALLY_RESOLVABLE = eINSTANCE.getMigration__GetNotAutimaticallyResolvable();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.impl.ResolvableOperatorImpl <em>Resolvable Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.impl.ResolvableOperatorImpl
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getResolvableOperator()
		 * @generated
		 */
		EClass RESOLVABLE_OPERATOR = eINSTANCE.getResolvableOperator();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOLVABLE_OPERATOR__DISPLAY_NAME = eINSTANCE.getResolvableOperator_DisplayName();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.impl.PartiallyResolvableImpl <em>Partially Resolvable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.impl.PartiallyResolvableImpl
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getPartiallyResolvable()
		 * @generated
		 */
		EClass PARTIALLY_RESOLVABLE = eINSTANCE.getPartiallyResolvable();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTIALLY_RESOLVABLE__DISPLAY_NAME = eINSTANCE.getPartiallyResolvable_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Resolve Options</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTIALLY_RESOLVABLE__RESOLVE_OPTIONS = eINSTANCE.getPartiallyResolvable_ResolveOptions();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.impl.NotAutomaticallyResolvableImpl <em>Not Automatically Resolvable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.impl.NotAutomaticallyResolvableImpl
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getNotAutomaticallyResolvable()
		 * @generated
		 */
		EClass NOT_AUTOMATICALLY_RESOLVABLE = eINSTANCE.getNotAutomaticallyResolvable();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOT_AUTOMATICALLY_RESOLVABLE__DISPLAY_NAME = eINSTANCE.getNotAutomaticallyResolvable_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Resolve Options</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOT_AUTOMATICALLY_RESOLVABLE__RESOLVE_OPTIONS = eINSTANCE.getNotAutomaticallyResolvable_ResolveOptions();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.ProcessStatus <em>Process Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.ProcessStatus
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getProcessStatus()
		 * @generated
		 */
		EEnum PROCESS_STATUS = eINSTANCE.getProcessStatus();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.ResolvableOperatorType <em>Resolvable Operator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.ResolvableOperatorType
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getResolvableOperatorType()
		 * @generated
		 */
		EEnum RESOLVABLE_OPERATOR_TYPE = eINSTANCE.getResolvableOperatorType();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.PartiallyResolvableOperatorType <em>Partially Resolvable Operator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.PartiallyResolvableOperatorType
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getPartiallyResolvableOperatorType()
		 * @generated
		 */
		EEnum PARTIALLY_RESOLVABLE_OPERATOR_TYPE = eINSTANCE.getPartiallyResolvableOperatorType();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType <em>Not Automatically Resolvable Operator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getNotAutomaticallyResolvableOperatorType()
		 * @generated
		 */
		EEnum NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR_TYPE = eINSTANCE.getNotAutomaticallyResolvableOperatorType();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.ColumnOptions <em>Column Options</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.ColumnOptions
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getColumnOptions()
		 * @generated
		 */
		EEnum COLUMN_OPTIONS = eINSTANCE.getColumnOptions();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.migration.ComplexResolveOptions <em>Complex Resolve Options</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.migration.ComplexResolveOptions
		 * @see de.thm.evolvedb.migration.impl.MigrationPackageImpl#getComplexResolveOptions()
		 * @generated
		 */
		EEnum COMPLEX_RESOLVE_OPTIONS = eINSTANCE.getComplexResolveOptions();

	}

} //MigrationPackage
