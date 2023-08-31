/**
 */
package de.thm.evolvedb.migration.impl;

import de.thm.evolvedb.migration.ColumnOptions;
import de.thm.evolvedb.migration.ComplexResolveOptions;
import de.thm.evolvedb.migration.Migration;
import de.thm.evolvedb.migration.MigrationFactory;
import de.thm.evolvedb.migration.MigrationPackage;
import de.thm.evolvedb.migration.NotAutomaticallyResolvable;
import de.thm.evolvedb.migration.NotAutomaticallyResolvableOperatorType;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.evolvedb.migration.PartiallyResolvableOperatorType;
import de.thm.evolvedb.migration.ProcessStatus;
import de.thm.evolvedb.migration.ResolvableOperator;
import de.thm.evolvedb.migration.ResolvableOperatorType;
import de.thm.evolvedb.migration.SchemaModificationOperator;

import de.thm.evolvedb.migration.util.MigrationValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sidiff.difference.symmetric.SymmetricPackage;

import org.sidiff.matching.model.MatchingModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MigrationPackageImpl extends EPackageImpl implements MigrationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schemaModificationOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass migrationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolvableOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partiallyResolvableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notAutomaticallyResolvableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum processStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resolvableOperatorTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum partiallyResolvableOperatorTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum notAutomaticallyResolvableOperatorTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum columnOptionsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum complexResolveOptionsEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.thm.evolvedb.migration.MigrationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MigrationPackageImpl() {
		super(eNS_URI, MigrationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link MigrationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MigrationPackage init() {
		if (isInited) return (MigrationPackage)EPackage.Registry.INSTANCE.getEPackage(MigrationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMigrationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MigrationPackageImpl theMigrationPackage = registeredMigrationPackage instanceof MigrationPackageImpl ? (MigrationPackageImpl)registeredMigrationPackage : new MigrationPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		MatchingModelPackage.eINSTANCE.eClass();
		SymmetricPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMigrationPackage.createPackageContents();

		// Initialize created meta-data
		theMigrationPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMigrationPackage,
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MigrationValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMigrationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MigrationPackage.eNS_URI, theMigrationPackage);
		return theMigrationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchemaModificationOperator() {
		return schemaModificationOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchemaModificationOperator_SemanticChangeSets() {
		return (EReference)schemaModificationOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchemaModificationOperator_ProcessStatus() {
		return (EAttribute)schemaModificationOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchemaModificationOperator_Migration() {
		return (EReference)schemaModificationOperatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchemaModificationOperator_Description() {
		return (EAttribute)schemaModificationOperatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSchemaModificationOperator__ValidateSMO__DiagnosticChain_Map() {
		return schemaModificationOperatorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMigration() {
		return migrationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMigration_SymmetricDifference() {
		return (EReference)migrationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMigration_SchemaModificationOperators() {
		return (EReference)migrationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMigration_SymetricDifferenceModel() {
		return (EAttribute)migrationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMigration_UriSymetricDifferenceModel() {
		return (EAttribute)migrationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMigration__GetResolvableSMO() {
		return migrationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMigration__GetPartiallyResovableSMO() {
		return migrationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMigration__GetNotAutimaticallyResolvable() {
		return migrationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolvableOperator() {
		return resolvableOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolvableOperator_DisplayName() {
		return (EAttribute)resolvableOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartiallyResolvable() {
		return partiallyResolvableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartiallyResolvable_DisplayName() {
		return (EAttribute)partiallyResolvableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartiallyResolvable_ResolveOptions() {
		return (EAttribute)partiallyResolvableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotAutomaticallyResolvable() {
		return notAutomaticallyResolvableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotAutomaticallyResolvable_DisplayName() {
		return (EAttribute)notAutomaticallyResolvableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotAutomaticallyResolvable_ResolveOptions() {
		return (EAttribute)notAutomaticallyResolvableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProcessStatus() {
		return processStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResolvableOperatorType() {
		return resolvableOperatorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPartiallyResolvableOperatorType() {
		return partiallyResolvableOperatorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNotAutomaticallyResolvableOperatorType() {
		return notAutomaticallyResolvableOperatorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getColumnOptions() {
		return columnOptionsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getComplexResolveOptions() {
		return complexResolveOptionsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationFactory getMigrationFactory() {
		return (MigrationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		schemaModificationOperatorEClass = createEClass(SCHEMA_MODIFICATION_OPERATOR);
		createEReference(schemaModificationOperatorEClass, SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS);
		createEAttribute(schemaModificationOperatorEClass, SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS);
		createEReference(schemaModificationOperatorEClass, SCHEMA_MODIFICATION_OPERATOR__MIGRATION);
		createEAttribute(schemaModificationOperatorEClass, SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION);
		createEOperation(schemaModificationOperatorEClass, SCHEMA_MODIFICATION_OPERATOR___VALIDATE_SMO__DIAGNOSTICCHAIN_MAP);

		migrationEClass = createEClass(MIGRATION);
		createEReference(migrationEClass, MIGRATION__SYMMETRIC_DIFFERENCE);
		createEReference(migrationEClass, MIGRATION__SCHEMA_MODIFICATION_OPERATORS);
		createEAttribute(migrationEClass, MIGRATION__SYMETRIC_DIFFERENCE_MODEL);
		createEAttribute(migrationEClass, MIGRATION__URI_SYMETRIC_DIFFERENCE_MODEL);
		createEOperation(migrationEClass, MIGRATION___GET_RESOLVABLE_SMO);
		createEOperation(migrationEClass, MIGRATION___GET_PARTIALLY_RESOVABLE_SMO);
		createEOperation(migrationEClass, MIGRATION___GET_NOT_AUTIMATICALLY_RESOLVABLE);

		resolvableOperatorEClass = createEClass(RESOLVABLE_OPERATOR);
		createEAttribute(resolvableOperatorEClass, RESOLVABLE_OPERATOR__DISPLAY_NAME);

		partiallyResolvableEClass = createEClass(PARTIALLY_RESOLVABLE);
		createEAttribute(partiallyResolvableEClass, PARTIALLY_RESOLVABLE__DISPLAY_NAME);
		createEAttribute(partiallyResolvableEClass, PARTIALLY_RESOLVABLE__RESOLVE_OPTIONS);

		notAutomaticallyResolvableEClass = createEClass(NOT_AUTOMATICALLY_RESOLVABLE);
		createEAttribute(notAutomaticallyResolvableEClass, NOT_AUTOMATICALLY_RESOLVABLE__DISPLAY_NAME);
		createEAttribute(notAutomaticallyResolvableEClass, NOT_AUTOMATICALLY_RESOLVABLE__RESOLVE_OPTIONS);

		// Create enums
		processStatusEEnum = createEEnum(PROCESS_STATUS);
		resolvableOperatorTypeEEnum = createEEnum(RESOLVABLE_OPERATOR_TYPE);
		partiallyResolvableOperatorTypeEEnum = createEEnum(PARTIALLY_RESOLVABLE_OPERATOR_TYPE);
		notAutomaticallyResolvableOperatorTypeEEnum = createEEnum(NOT_AUTOMATICALLY_RESOLVABLE_OPERATOR_TYPE);
		columnOptionsEEnum = createEEnum(COLUMN_OPTIONS);
		complexResolveOptionsEEnum = createEEnum(COMPLEX_RESOLVE_OPTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SymmetricPackage theSymmetricPackage = (SymmetricPackage)EPackage.Registry.INSTANCE.getEPackage(SymmetricPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		resolvableOperatorEClass.getESuperTypes().add(this.getSchemaModificationOperator());
		partiallyResolvableEClass.getESuperTypes().add(this.getSchemaModificationOperator());
		notAutomaticallyResolvableEClass.getESuperTypes().add(this.getSchemaModificationOperator());

		// Initialize classes, features, and operations; add parameters
		initEClass(schemaModificationOperatorEClass, SchemaModificationOperator.class, "SchemaModificationOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchemaModificationOperator_SemanticChangeSets(), theSymmetricPackage.getSemanticChangeSet(), null, "semanticChangeSets", null, 0, -1, SchemaModificationOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchemaModificationOperator_ProcessStatus(), this.getProcessStatus(), "processStatus", null, 1, 1, SchemaModificationOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchemaModificationOperator_Migration(), this.getMigration(), this.getMigration_SchemaModificationOperators(), "migration", null, 0, 1, SchemaModificationOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchemaModificationOperator_Description(), ecorePackage.getEString(), "description", null, 0, 1, SchemaModificationOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getSchemaModificationOperator__ValidateSMO__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSMO", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(migrationEClass, Migration.class, "Migration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMigration_SymmetricDifference(), theSymmetricPackage.getSymmetricDifference(), null, "SymmetricDifference", null, 0, 1, Migration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMigration_SchemaModificationOperators(), this.getSchemaModificationOperator(), this.getSchemaModificationOperator_Migration(), "schemaModificationOperators", null, 0, -1, Migration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMigration_SymetricDifferenceModel(), ecorePackage.getEResource(), "symetricDifferenceModel", null, 0, 1, Migration.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getMigration_UriSymetricDifferenceModel(), ecorePackage.getEString(), "uriSymetricDifferenceModel", null, 0, 1, Migration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMigration__GetResolvableSMO(), this.getResolvableOperator(), "getResolvableSMO", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMigration__GetPartiallyResovableSMO(), this.getPartiallyResolvable(), "getPartiallyResovableSMO", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMigration__GetNotAutimaticallyResolvable(), this.getNotAutomaticallyResolvable(), "getNotAutimaticallyResolvable", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(resolvableOperatorEClass, ResolvableOperator.class, "ResolvableOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResolvableOperator_DisplayName(), this.getResolvableOperatorType(), "displayName", null, 0, 1, ResolvableOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partiallyResolvableEClass, PartiallyResolvable.class, "PartiallyResolvable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPartiallyResolvable_DisplayName(), this.getPartiallyResolvableOperatorType(), "displayName", null, 0, 1, PartiallyResolvable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPartiallyResolvable_ResolveOptions(), this.getColumnOptions(), "resolveOptions", null, 0, 1, PartiallyResolvable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notAutomaticallyResolvableEClass, NotAutomaticallyResolvable.class, "NotAutomaticallyResolvable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNotAutomaticallyResolvable_DisplayName(), this.getNotAutomaticallyResolvableOperatorType(), "displayName", null, 0, 1, NotAutomaticallyResolvable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotAutomaticallyResolvable_ResolveOptions(), this.getComplexResolveOptions(), "resolveOptions", null, 0, 1, NotAutomaticallyResolvable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(processStatusEEnum, ProcessStatus.class, "ProcessStatus");
		addEEnumLiteral(processStatusEEnum, ProcessStatus.RESOLVED);
		addEEnumLiteral(processStatusEEnum, ProcessStatus.IGNORE);
		addEEnumLiteral(processStatusEEnum, ProcessStatus.UNRESOLVED);

		initEEnum(resolvableOperatorTypeEEnum, ResolvableOperatorType.class, "ResolvableOperatorType");
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.CREATE_TABLE);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.RENAME_TABLE);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.CREATE_COLUMN);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.CREATE_PRIMARY_KEY);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.CREATE_FOREIGN_KEY);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.SET_COLUMN_DEFAULT_VALUE);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.SET_COLUMN_AUTO_INCREMENT);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.RENAME_COLUMN);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.CHANGE_REFERENTIAL_ACTION);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.SET_ATTRIBUTE_CONSTRAINT_NAME);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.SET_ATTRIBUTE_FOREIGNKEY_CONSTRAINT_NAME);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.CREATE_INDEX_IN_TABLE);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.ADD_COLUMN_TO_INDEX);
		addEEnumLiteral(resolvableOperatorTypeEEnum, ResolvableOperatorType.REMOVE_CONSTRAINT);

		initEEnum(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.class, "PartiallyResolvableOperatorType");
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.DELETE_COLUMN);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.DELETE_FOREIGN_KEY);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.DELETE_PRIMARY_KEY);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.DELETE_TABLE);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.SET_COLUMN_NOT_NULL);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.SET_COLUMN_SIZE);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.SET_FOREIGNKEYS_TARGET_TABLE);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.CREATE_UNIQUE_CONSTRAINT);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.SET_COLUMN_TYPE);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.CHANGE_1N_INTO_NM);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.CHANGE_1N_INTO_NM_PRESERVE);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.CHANGE_NM_INTO_1N);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.CHANGE_NM_INTO_1N_PRESERVE);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.SET_COLUMN_TYPE_AND_SIZE);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.CHANGE_1N_INTO_NM_MOVE);
		addEEnumLiteral(partiallyResolvableOperatorTypeEEnum, PartiallyResolvableOperatorType.ADD_COLUMN_UNIQUE_INDEX);

		initEEnum(notAutomaticallyResolvableOperatorTypeEEnum, NotAutomaticallyResolvableOperatorType.class, "NotAutomaticallyResolvableOperatorType");
		addEEnumLiteral(notAutomaticallyResolvableOperatorTypeEEnum, NotAutomaticallyResolvableOperatorType.MOVE_PRIMARY_KEY);
		addEEnumLiteral(notAutomaticallyResolvableOperatorTypeEEnum, NotAutomaticallyResolvableOperatorType.MOVE_FOREIGN_KEY);
		addEEnumLiteral(notAutomaticallyResolvableOperatorTypeEEnum, NotAutomaticallyResolvableOperatorType.MOVE_COLUMN);
		addEEnumLiteral(notAutomaticallyResolvableOperatorTypeEEnum, NotAutomaticallyResolvableOperatorType.JOIN_TABLE);

		initEEnum(columnOptionsEEnum, ColumnOptions.class, "ColumnOptions");
		addEEnumLiteral(columnOptionsEEnum, ColumnOptions.IGNORE);
		addEEnumLiteral(columnOptionsEEnum, ColumnOptions.UPDATE_ROW_SET_TO_NULL);
		addEEnumLiteral(columnOptionsEEnum, ColumnOptions.UPDATE_ROW_SET_TO_DEFAULT);
		addEEnumLiteral(columnOptionsEEnum, ColumnOptions.DELETE_ROW);
		addEEnumLiteral(columnOptionsEEnum, ColumnOptions.UPDATE_COLUMN_SET_TO_NULL);
		addEEnumLiteral(columnOptionsEEnum, ColumnOptions.UPDATE_COLUMN_SET_TO_DEFAULT);
		addEEnumLiteral(columnOptionsEEnum, ColumnOptions.MIGRATE_DATA);
		addEEnumLiteral(columnOptionsEEnum, ColumnOptions.DELETE_DUBLICATES);
		addEEnumLiteral(columnOptionsEEnum, ColumnOptions.IGNORE_DUBLICATES);
		addEEnumLiteral(columnOptionsEEnum, ColumnOptions.SPECIFY_CONDITION_MANUALLY);

		initEEnum(complexResolveOptionsEEnum, ComplexResolveOptions.class, "ComplexResolveOptions");
		addEEnumLiteral(complexResolveOptionsEEnum, ComplexResolveOptions.IGNORE);
		addEEnumLiteral(complexResolveOptionsEEnum, ComplexResolveOptions.RESOLVE_BY_DB_ID);
		addEEnumLiteral(complexResolveOptionsEEnum, ComplexResolveOptions.CARTESIAN_PRODUCT);
		addEEnumLiteral(complexResolveOptionsEEnum, ComplexResolveOptions.SPECIFY_CONDITION_MANUALLY);

		// Create resource
		createResource(eNS_URI);
	}

} //MigrationPackageImpl
