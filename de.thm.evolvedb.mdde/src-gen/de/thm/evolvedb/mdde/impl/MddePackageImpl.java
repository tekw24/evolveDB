/**
 */
package de.thm.evolvedb.mdde.impl;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.DataType;
import de.thm.evolvedb.mdde.Database_Schema;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.MddeFactory;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.NamedElement;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Referential_Action;
import de.thm.evolvedb.mdde.Table;

import de.thm.evolvedb.mdde.util.MddeValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MddePackageImpl extends EPackageImpl implements MddePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primaryKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass foreignKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass database_SchemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass columnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum referential_ActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType columnSizeEDataType = null;

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
	 * @see de.thm.evolvedb.mdde.MddePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MddePackageImpl() {
		super(eNS_URI, MddeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MddePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MddePackage init() {
		if (isInited) return (MddePackage)EPackage.Registry.INSTANCE.getEPackage(MddePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMddePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MddePackageImpl theMddePackage = registeredMddePackage instanceof MddePackageImpl ? (MddePackageImpl)registeredMddePackage : new MddePackageImpl();

		isInited = true;

		// Create package meta-data objects
		theMddePackage.createPackageContents();

		// Initialize created meta-data
		theMddePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMddePackage,
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MddeValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMddePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MddePackage.eNS_URI, theMddePackage);
		return theMddePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTable() {
		return tableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTable_Schema() {
		return (EReference)tableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTable_Columns() {
		return (EReference)tableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTable__GetPrimaryKeys() {
		return tableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTable__GetPrimaryKeyByName__String() {
		return tableEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTable__GetForeignKeys() {
		return tableEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTable__GetMainPrimaryKey() {
		return tableEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTable__OnlyOneAutoIncrementColumn__DiagnosticChain_Map() {
		return tableEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTable__NonKeyAutoIncrementColumn__DiagnosticChain_Map() {
		return tableEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTable__TableRequiresAKeyColumn__DiagnosticChain_Map() {
		return tableEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTable__TableRequiresAtLeastOneColumn__DiagnosticChain_Map() {
		return tableEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimaryKey() {
		return primaryKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimaryKey_PrimaryKey() {
		return (EAttribute)primaryKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimaryKey_ReferencedBy() {
		return (EReference)primaryKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForeignKey() {
		return foreignKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForeignKey_ReferencedTable() {
		return (EReference)foreignKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForeignKey_PrimaryForeignKey() {
		return (EAttribute)foreignKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForeignKey_OnUpdate() {
		return (EAttribute)foreignKeyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForeignKey_OnDelete() {
		return (EAttribute)foreignKeyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForeignKey_ConstraintName() {
		return (EAttribute)foreignKeyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForeignKey_ReferencedKeyColumn() {
		return (EReference)foreignKeyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForeignKey__ValidateConstraintName__DiagnosticChain_Map() {
		return foreignKeyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForeignKey__ForeignKeyHasToReferenceAKeyColumn__DiagnosticChain_Map() {
		return foreignKeyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNamedElement__NameNotNull__DiagnosticChain_Map() {
		return namedElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabase_Schema() {
		return database_SchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabase_Schema_Location() {
		return (EAttribute)database_SchemaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabase_Schema_Version() {
		return (EAttribute)database_SchemaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDatabase_Schema_Entites() {
		return (EReference)database_SchemaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColumn() {
		return columnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumn_Table() {
		return (EReference)columnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_DefaultValue() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_NotNull() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_Unique() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_AutoIncrement() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_Size() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_Type() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_UniqueConstraintName() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getColumn__ValidateDefaultValue__DiagnosticChain_Map() {
		return columnEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getColumn__ValidateSizeValue__DiagnosticChain_Map() {
		return columnEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataType() {
		return dataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReferential_Action() {
		return referential_ActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getColumnSize() {
		return columnSizeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MddeFactory getMddeFactory() {
		return (MddeFactory)getEFactoryInstance();
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
		tableEClass = createEClass(TABLE);
		createEReference(tableEClass, TABLE__SCHEMA);
		createEReference(tableEClass, TABLE__COLUMNS);
		createEOperation(tableEClass, TABLE___GET_PRIMARY_KEYS);
		createEOperation(tableEClass, TABLE___GET_PRIMARY_KEY_BY_NAME__STRING);
		createEOperation(tableEClass, TABLE___GET_FOREIGN_KEYS);
		createEOperation(tableEClass, TABLE___GET_MAIN_PRIMARY_KEY);
		createEOperation(tableEClass, TABLE___ONLY_ONE_AUTO_INCREMENT_COLUMN__DIAGNOSTICCHAIN_MAP);
		createEOperation(tableEClass, TABLE___NON_KEY_AUTO_INCREMENT_COLUMN__DIAGNOSTICCHAIN_MAP);
		createEOperation(tableEClass, TABLE___TABLE_REQUIRES_AKEY_COLUMN__DIAGNOSTICCHAIN_MAP);
		createEOperation(tableEClass, TABLE___TABLE_REQUIRES_AT_LEAST_ONE_COLUMN__DIAGNOSTICCHAIN_MAP);

		primaryKeyEClass = createEClass(PRIMARY_KEY);
		createEAttribute(primaryKeyEClass, PRIMARY_KEY__PRIMARY_KEY);
		createEReference(primaryKeyEClass, PRIMARY_KEY__REFERENCED_BY);

		foreignKeyEClass = createEClass(FOREIGN_KEY);
		createEReference(foreignKeyEClass, FOREIGN_KEY__REFERENCED_TABLE);
		createEAttribute(foreignKeyEClass, FOREIGN_KEY__PRIMARY_FOREIGN_KEY);
		createEAttribute(foreignKeyEClass, FOREIGN_KEY__ON_UPDATE);
		createEAttribute(foreignKeyEClass, FOREIGN_KEY__ON_DELETE);
		createEAttribute(foreignKeyEClass, FOREIGN_KEY__CONSTRAINT_NAME);
		createEReference(foreignKeyEClass, FOREIGN_KEY__REFERENCED_KEY_COLUMN);
		createEOperation(foreignKeyEClass, FOREIGN_KEY___VALIDATE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP);
		createEOperation(foreignKeyEClass, FOREIGN_KEY___FOREIGN_KEY_HAS_TO_REFERENCE_AKEY_COLUMN__DIAGNOSTICCHAIN_MAP);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
		createEOperation(namedElementEClass, NAMED_ELEMENT___NAME_NOT_NULL__DIAGNOSTICCHAIN_MAP);

		database_SchemaEClass = createEClass(DATABASE_SCHEMA);
		createEAttribute(database_SchemaEClass, DATABASE_SCHEMA__LOCATION);
		createEAttribute(database_SchemaEClass, DATABASE_SCHEMA__VERSION);
		createEReference(database_SchemaEClass, DATABASE_SCHEMA__ENTITES);

		columnEClass = createEClass(COLUMN);
		createEReference(columnEClass, COLUMN__TABLE);
		createEAttribute(columnEClass, COLUMN__DEFAULT_VALUE);
		createEAttribute(columnEClass, COLUMN__NOT_NULL);
		createEAttribute(columnEClass, COLUMN__UNIQUE);
		createEAttribute(columnEClass, COLUMN__AUTO_INCREMENT);
		createEAttribute(columnEClass, COLUMN__SIZE);
		createEAttribute(columnEClass, COLUMN__TYPE);
		createEAttribute(columnEClass, COLUMN__UNIQUE_CONSTRAINT_NAME);
		createEOperation(columnEClass, COLUMN___VALIDATE_DEFAULT_VALUE__DIAGNOSTICCHAIN_MAP);
		createEOperation(columnEClass, COLUMN___VALIDATE_SIZE_VALUE__DIAGNOSTICCHAIN_MAP);

		// Create enums
		dataTypeEEnum = createEEnum(DATA_TYPE);
		referential_ActionEEnum = createEEnum(REFERENTIAL_ACTION);

		// Create data types
		columnSizeEDataType = createEDataType(COLUMN_SIZE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tableEClass.getESuperTypes().add(this.getNamedElement());
		primaryKeyEClass.getESuperTypes().add(this.getColumn());
		foreignKeyEClass.getESuperTypes().add(this.getColumn());
		database_SchemaEClass.getESuperTypes().add(this.getNamedElement());
		columnEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(tableEClass, Table.class, "Table", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTable_Schema(), this.getDatabase_Schema(), this.getDatabase_Schema_Entites(), "schema", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTable_Columns(), this.getColumn(), this.getColumn_Table(), "columns", null, 0, -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTable__GetPrimaryKeys(), this.getPrimaryKey(), "getPrimaryKeys", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getTable__GetPrimaryKeyByName__String(), this.getPrimaryKey(), "getPrimaryKeyByName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "primaryKeyName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getTable__GetForeignKeys(), this.getForeignKey(), "getForeignKeys", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getTable__GetMainPrimaryKey(), this.getPrimaryKey(), "getMainPrimaryKey", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTable__OnlyOneAutoIncrementColumn__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "OnlyOneAutoIncrementColumn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTable__NonKeyAutoIncrementColumn__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "NonKeyAutoIncrementColumn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTable__TableRequiresAKeyColumn__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "TableRequiresAKeyColumn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTable__TableRequiresAtLeastOneColumn__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "TableRequiresAtLeastOneColumn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(primaryKeyEClass, PrimaryKey.class, "PrimaryKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimaryKey_PrimaryKey(), ecorePackage.getEBooleanObject(), "primaryKey", null, 0, 1, PrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryKey_ReferencedBy(), this.getForeignKey(), this.getForeignKey_ReferencedKeyColumn(), "referencedBy", null, 0, -1, PrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(foreignKeyEClass, ForeignKey.class, "ForeignKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForeignKey_ReferencedTable(), this.getTable(), null, "referencedTable", null, 1, 1, ForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForeignKey_PrimaryForeignKey(), ecorePackage.getEBooleanObject(), "primaryForeignKey", null, 0, 1, ForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForeignKey_OnUpdate(), this.getReferential_Action(), "OnUpdate", null, 1, 1, ForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForeignKey_OnDelete(), this.getReferential_Action(), "OnDelete", null, 1, 1, ForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForeignKey_ConstraintName(), ecorePackage.getEString(), "constraintName", null, 1, 1, ForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForeignKey_ReferencedKeyColumn(), this.getPrimaryKey(), this.getPrimaryKey_ReferencedBy(), "referencedKeyColumn", null, 1, 1, ForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getForeignKey__ValidateConstraintName__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateConstraintName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getForeignKey__ForeignKeyHasToReferenceAKeyColumn__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "ForeignKeyHasToReferenceAKeyColumn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getNamedElement__NameNotNull__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "NameNotNull", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(database_SchemaEClass, Database_Schema.class, "Database_Schema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDatabase_Schema_Location(), ecorePackage.getEString(), "location", null, 0, 1, Database_Schema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabase_Schema_Version(), ecorePackage.getEString(), "version", null, 0, 1, Database_Schema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDatabase_Schema_Entites(), this.getTable(), this.getTable_Schema(), "entites", null, 0, -1, Database_Schema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(columnEClass, Column.class, "Column", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getColumn_Table(), this.getTable(), this.getTable_Columns(), "table", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_NotNull(), ecorePackage.getEBooleanObject(), "notNull", "false", 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_Unique(), ecorePackage.getEBooleanObject(), "unique", "false", 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_AutoIncrement(), ecorePackage.getEBooleanObject(), "autoIncrement", "false", 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_Size(), this.getColumnSize(), "size", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_Type(), this.getDataType(), "type", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_UniqueConstraintName(), ecorePackage.getEString(), "uniqueConstraintName", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getColumn__ValidateDefaultValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateDefaultValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getColumn__ValidateSizeValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSizeValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(dataTypeEEnum, DataType.class, "DataType");
		addEEnumLiteral(dataTypeEEnum, DataType.CHAR);
		addEEnumLiteral(dataTypeEEnum, DataType.VARCHAR);
		addEEnumLiteral(dataTypeEEnum, DataType.BINARY);
		addEEnumLiteral(dataTypeEEnum, DataType.VARBINARY);
		addEEnumLiteral(dataTypeEEnum, DataType.TINYBLOB);
		addEEnumLiteral(dataTypeEEnum, DataType.TINYTEXT);
		addEEnumLiteral(dataTypeEEnum, DataType.TEXT);
		addEEnumLiteral(dataTypeEEnum, DataType.BLOB);
		addEEnumLiteral(dataTypeEEnum, DataType.MEDIUMTEXT);
		addEEnumLiteral(dataTypeEEnum, DataType.MEDIUMBLOB);
		addEEnumLiteral(dataTypeEEnum, DataType.LONGTEXT);
		addEEnumLiteral(dataTypeEEnum, DataType.LONGBLOB);
		addEEnumLiteral(dataTypeEEnum, DataType.ENUM);
		addEEnumLiteral(dataTypeEEnum, DataType.SET);
		addEEnumLiteral(dataTypeEEnum, DataType.BIT);
		addEEnumLiteral(dataTypeEEnum, DataType.TINYINT);
		addEEnumLiteral(dataTypeEEnum, DataType.BOOL);
		addEEnumLiteral(dataTypeEEnum, DataType.BOOLEAN);
		addEEnumLiteral(dataTypeEEnum, DataType.SMALLINT);
		addEEnumLiteral(dataTypeEEnum, DataType.MEDIUMINT);
		addEEnumLiteral(dataTypeEEnum, DataType.INT);
		addEEnumLiteral(dataTypeEEnum, DataType.INTEGER);
		addEEnumLiteral(dataTypeEEnum, DataType.BIGINT);
		addEEnumLiteral(dataTypeEEnum, DataType.FLOAT);
		addEEnumLiteral(dataTypeEEnum, DataType.DOUBLE);
		addEEnumLiteral(dataTypeEEnum, DataType.DECIMAL);
		addEEnumLiteral(dataTypeEEnum, DataType.DEC);
		addEEnumLiteral(dataTypeEEnum, DataType.DATE);
		addEEnumLiteral(dataTypeEEnum, DataType.DATETIME);
		addEEnumLiteral(dataTypeEEnum, DataType.TIMESTAMP);
		addEEnumLiteral(dataTypeEEnum, DataType.TIME);
		addEEnumLiteral(dataTypeEEnum, DataType.YEAR);

		initEEnum(referential_ActionEEnum, Referential_Action.class, "Referential_Action");
		addEEnumLiteral(referential_ActionEEnum, Referential_Action.RESTRICT);
		addEEnumLiteral(referential_ActionEEnum, Referential_Action.CASCADE);
		addEEnumLiteral(referential_ActionEEnum, Referential_Action.SET_NULL);
		addEEnumLiteral(referential_ActionEEnum, Referential_Action.NO_ACTION);

		// Initialize data types
		initEDataType(columnSizeEDataType, String.class, "ColumnSize", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });
		addAnnotation
		  (tableEClass,
		   source,
		   new String[] {
			   "constraints", "TableRequiresAtLeastOneColumn"
		   });
		addAnnotation
		  (foreignKeyEClass,
		   source,
		   new String[] {
			   "constraints", "ForeignKeyHasToReferenceAKeyColumn"
		   });
		addAnnotation
		  (namedElementEClass,
		   source,
		   new String[] {
			   "constraints", "NameNotNull"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (getTable__OnlyOneAutoIncrementColumn__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = \'Incorrect table definition; The table \' + Table.name + \'  can only have one auto column and it must be defined as a key!\',\n\tstatus : Boolean = self.columns-> notEmpty() and\n\t\t((columns->one(c1 | c1.autoIncrement)) or (columns-> select(c1 | c1.autoIncrement) -> isEmpty()) or ((columns-> select(c1 | c1.oclIsTypeOf(PrimaryKey)) -> isEmpty()) and columns->exists(c1 | c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)))\n}.status"
		   });
		addAnnotation
		  (getTable__NonKeyAutoIncrementColumn__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = \'Incorrect table definition; The table \' + Table.name + \'  can only have one auto column and it must be defined as a key!\',\n\tstatus : Boolean = self.columns-> notEmpty() and\n\t\t((columns->one(c1 | c1.oclIsTypeOf(PrimaryKey) and c1.autoIncrement)) or ((columns-> select(c1 | c1.oclIsTypeOf(PrimaryKey)) -> isEmpty()) and columns->exists(c1 | c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)) or (columns-> select(c1 | c1.autoIncrement) -> isEmpty()))\n}.status"
		   });
		addAnnotation
		  (getTable__TableRequiresAKeyColumn__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = \'The Table \' + Table.name + \' requires a primary key or a set of primary foreign keys!\',\n\tstatus : Boolean = self.columns-> notEmpty() and\n\t\t(columns->exists(oclIsTypeOf(PrimaryKey)) or columns -> exists(c1 | (c1.oclIsTypeOf(ForeignKey) and c1.oclAsType(ForeignKey).primaryForeignKey)))\n}.status"
		   });
		addAnnotation
		  (getTable__TableRequiresAtLeastOneColumn__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = \'The Table \' + Table.name + \' requires at least one column!\',\n\tstatus : Boolean = self.columns->notEmpty()\n}.status"
		   });
		addAnnotation
		  (getForeignKey__ForeignKeyHasToReferenceAKeyColumn__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = \'The referenced column should not be empty!\',\n\tstatus : Boolean = self.referencedTable-> notEmpty()\n}.status"
		   });
		addAnnotation
		  (getNamedElement__NameNotNull__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = \'Name should not be empty!\',\n\tstatus : Boolean = self.name->size() > 0\n}.status"
		   });
	}

} //MddePackageImpl
