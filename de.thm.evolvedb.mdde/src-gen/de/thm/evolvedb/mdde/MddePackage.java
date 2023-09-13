/**
 */
package de.thm.evolvedb.mdde;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see de.thm.evolvedb.mdde.MddeFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface MddePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mdde";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.thm.de/mdde";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mdde";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MddePackage eINSTANCE = de.thm.evolvedb.mdde.impl.MddePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.impl.NamedElementImpl
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.impl.TableImpl
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__SCHEMA = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLUMNS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__CONSTRAINTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Primary Keys</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE___GET_PRIMARY_KEYS = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Primary Key By Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE___GET_PRIMARY_KEY_BY_NAME__STRING = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Foreign Keys</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE___GET_FOREIGN_KEYS = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Main Primary Key</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE___GET_MAIN_PRIMARY_KEY = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.impl.ColumnImpl <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.impl.ColumnImpl
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getColumn()
	 * @generated
	 */
	int COLUMN = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Table</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__TABLE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__DEFAULT_VALUE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Not Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__NOT_NULL = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Auto Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__AUTO_INCREMENT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__SIZE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__CONSTRAINTS = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Validate Default Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN___VALIDATE_DEFAULT_VALUE__DIAGNOSTICCHAIN_MAP = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Size Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN___VALIDATE_SIZE_VALUE__DIAGNOSTICCHAIN_MAP = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Unique Constraint Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.impl.PrimaryKeyImpl <em>Primary Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.impl.PrimaryKeyImpl
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getPrimaryKey()
	 * @generated
	 */
	int PRIMARY_KEY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY__NAME = COLUMN__NAME;

	/**
	 * The feature id for the '<em><b>Table</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY__TABLE = COLUMN__TABLE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY__DEFAULT_VALUE = COLUMN__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Not Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY__NOT_NULL = COLUMN__NOT_NULL;

	/**
	 * The feature id for the '<em><b>Auto Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY__AUTO_INCREMENT = COLUMN__AUTO_INCREMENT;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY__SIZE = COLUMN__SIZE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY__TYPE = COLUMN__TYPE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY__CONSTRAINTS = COLUMN__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY__PRIMARY_KEY = COLUMN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY__REFERENCED_BY = COLUMN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Primary Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_FEATURE_COUNT = COLUMN_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Default Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY___VALIDATE_DEFAULT_VALUE__DIAGNOSTICCHAIN_MAP = COLUMN___VALIDATE_DEFAULT_VALUE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Size Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY___VALIDATE_SIZE_VALUE__DIAGNOSTICCHAIN_MAP = COLUMN___VALIDATE_SIZE_VALUE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Unique Constraint Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP = COLUMN___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Primary Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_OPERATION_COUNT = COLUMN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.impl.ForeignKeyImpl <em>Foreign Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.impl.ForeignKeyImpl
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getForeignKey()
	 * @generated
	 */
	int FOREIGN_KEY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__NAME = COLUMN__NAME;

	/**
	 * The feature id for the '<em><b>Table</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__TABLE = COLUMN__TABLE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__DEFAULT_VALUE = COLUMN__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Not Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__NOT_NULL = COLUMN__NOT_NULL;

	/**
	 * The feature id for the '<em><b>Auto Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__AUTO_INCREMENT = COLUMN__AUTO_INCREMENT;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__SIZE = COLUMN__SIZE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__TYPE = COLUMN__TYPE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__CONSTRAINTS = COLUMN__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Referenced Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__REFERENCED_TABLE = COLUMN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Primary Foreign Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__PRIMARY_FOREIGN_KEY = COLUMN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>On Update</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__ON_UPDATE = COLUMN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>On Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__ON_DELETE = COLUMN_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__CONSTRAINT_NAME = COLUMN_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Referenced Key Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__REFERENCED_KEY_COLUMN = COLUMN_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Foreign Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_FEATURE_COUNT = COLUMN_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Validate Default Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY___VALIDATE_DEFAULT_VALUE__DIAGNOSTICCHAIN_MAP = COLUMN___VALIDATE_DEFAULT_VALUE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Size Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY___VALIDATE_SIZE_VALUE__DIAGNOSTICCHAIN_MAP = COLUMN___VALIDATE_SIZE_VALUE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Unique Constraint Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP = COLUMN___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Constraint Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int FOREIGN_KEY___VALIDATE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP = COLUMN_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Foreign Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_OPERATION_COUNT = COLUMN_OPERATION_COUNT + 1;
	
	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.impl.Database_SchemaImpl <em>Database Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.impl.Database_SchemaImpl
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getDatabase_Schema()
	 * @generated
	 */
	int DATABASE_SCHEMA = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_SCHEMA__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_SCHEMA__LOCATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_SCHEMA__VERSION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Entites</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_SCHEMA__ENTITES = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Database Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_SCHEMA_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Database Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_SCHEMA_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.impl.ConstraintImpl
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__COLUMNS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Table</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__TABLE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sort Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__SORT_SEQUENCE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Unique Constraint Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.impl.UniqueConstraintImpl <em>Unique Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.impl.UniqueConstraintImpl
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getUniqueConstraint()
	 * @generated
	 */
	int UNIQUE_CONSTRAINT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT__COLUMNS = CONSTRAINT__COLUMNS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT__TABLE = CONSTRAINT__TABLE;

	/**
	 * The feature id for the '<em><b>Sort Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT__SORT_SEQUENCE = CONSTRAINT__SORT_SEQUENCE;

	/**
	 * The number of structural features of the '<em>Unique Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Unique Constraint Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP = CONSTRAINT___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Unique Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.impl.IndexImpl <em>Index</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.impl.IndexImpl
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getIndex()
	 * @generated
	 */
	int INDEX = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__COLUMNS = CONSTRAINT__COLUMNS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__TABLE = CONSTRAINT__TABLE;

	/**
	 * The feature id for the '<em><b>Sort Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__SORT_SEQUENCE = CONSTRAINT__SORT_SEQUENCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__TYPE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Unique Constraint Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP = CONSTRAINT___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.impl.ColumnConstraintImpl <em>Column Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.impl.ColumnConstraintImpl
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getColumnConstraint()
	 * @generated
	 */
	int COLUMN_CONSTRAINT = 9;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CONSTRAINT__LENGTH = 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CONSTRAINT__CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CONSTRAINT__COLUMN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CONSTRAINT__NAME = 3;

	/**
	 * The number of structural features of the '<em>Column Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CONSTRAINT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Column Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.DataType
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 10;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.Referential_Action <em>Referential Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.Referential_Action
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getReferential_Action()
	 * @generated
	 */
	int REFERENTIAL_ACTION = 11;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.SortSequence <em>Sort Sequence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.SortSequence
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getSortSequence()
	 * @generated
	 */
	int SORT_SEQUENCE = 12;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.mdde.IndexType <em>Index Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.mdde.IndexType
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getIndexType()
	 * @generated
	 */
	int INDEX_TYPE = 13;

	/**
	 * The meta object id for the '<em>Column Size</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getColumnSize()
	 * @generated
	 */
	int COLUMN_SIZE = 14;



	


	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.mdde.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see de.thm.evolvedb.mdde.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the container reference '{@link de.thm.evolvedb.mdde.Table#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Schema</em>'.
	 * @see de.thm.evolvedb.mdde.Table#getSchema()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Schema();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.mdde.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see de.thm.evolvedb.mdde.Table#getColumns()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Columns();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.mdde.Table#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see de.thm.evolvedb.mdde.Table#getConstraints()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Constraints();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.mdde.Table#getPrimaryKeys() <em>Get Primary Keys</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Primary Keys</em>' operation.
	 * @see de.thm.evolvedb.mdde.Table#getPrimaryKeys()
	 * @generated
	 */
	EOperation getTable__GetPrimaryKeys();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.mdde.Table#getPrimaryKeyByName(java.lang.String) <em>Get Primary Key By Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Primary Key By Name</em>' operation.
	 * @see de.thm.evolvedb.mdde.Table#getPrimaryKeyByName(java.lang.String)
	 * @generated
	 */
	EOperation getTable__GetPrimaryKeyByName__String();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.mdde.Table#getForeignKeys() <em>Get Foreign Keys</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Foreign Keys</em>' operation.
	 * @see de.thm.evolvedb.mdde.Table#getForeignKeys()
	 * @generated
	 */
	EOperation getTable__GetForeignKeys();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.mdde.Table#getMainPrimaryKey() <em>Get Main Primary Key</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Main Primary Key</em>' operation.
	 * @see de.thm.evolvedb.mdde.Table#getMainPrimaryKey()
	 * @generated
	 */
	EOperation getTable__GetMainPrimaryKey();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.mdde.PrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primary Key</em>'.
	 * @see de.thm.evolvedb.mdde.PrimaryKey
	 * @generated
	 */
	EClass getPrimaryKey();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.PrimaryKey#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Key</em>'.
	 * @see de.thm.evolvedb.mdde.PrimaryKey#getPrimaryKey()
	 * @see #getPrimaryKey()
	 * @generated
	 */
	EAttribute getPrimaryKey_PrimaryKey();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.mdde.PrimaryKey#getReferencedBy <em>Referenced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced By</em>'.
	 * @see de.thm.evolvedb.mdde.PrimaryKey#getReferencedBy()
	 * @see #getPrimaryKey()
	 * @generated
	 */
	EReference getPrimaryKey_ReferencedBy();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.mdde.ForeignKey <em>Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Foreign Key</em>'.
	 * @see de.thm.evolvedb.mdde.ForeignKey
	 * @generated
	 */
	EClass getForeignKey();

	/**
	 * Returns the meta object for the reference '{@link de.thm.evolvedb.mdde.ForeignKey#getReferencedTable <em>Referenced Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Table</em>'.
	 * @see de.thm.evolvedb.mdde.ForeignKey#getReferencedTable()
	 * @see #getForeignKey()
	 * @generated
	 */
	EReference getForeignKey_ReferencedTable();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.ForeignKey#getPrimaryForeignKey <em>Primary Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Foreign Key</em>'.
	 * @see de.thm.evolvedb.mdde.ForeignKey#getPrimaryForeignKey()
	 * @see #getForeignKey()
	 * @generated
	 */
	EAttribute getForeignKey_PrimaryForeignKey();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.ForeignKey#getOnUpdate <em>On Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>On Update</em>'.
	 * @see de.thm.evolvedb.mdde.ForeignKey#getOnUpdate()
	 * @see #getForeignKey()
	 * @generated
	 */
	EAttribute getForeignKey_OnUpdate();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.ForeignKey#getOnDelete <em>On Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>On Delete</em>'.
	 * @see de.thm.evolvedb.mdde.ForeignKey#getOnDelete()
	 * @see #getForeignKey()
	 * @generated
	 */
	EAttribute getForeignKey_OnDelete();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.ForeignKey#getConstraintName <em>Constraint Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Name</em>'.
	 * @see de.thm.evolvedb.mdde.ForeignKey#getConstraintName()
	 * @see #getForeignKey()
	 * @generated
	 */
	EAttribute getForeignKey_ConstraintName();

	/**
	 * Returns the meta object for the reference '{@link de.thm.evolvedb.mdde.ForeignKey#getReferencedKeyColumn <em>Referenced Key Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Key Column</em>'.
	 * @see de.thm.evolvedb.mdde.ForeignKey#getReferencedKeyColumn()
	 * @see #getForeignKey()
	 * @generated
	 */
	EReference getForeignKey_ReferencedKeyColumn();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.mdde.ForeignKey#validateConstraintName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Constraint Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Constraint Name</em>' operation.
	 * @see de.thm.evolvedb.mdde.ForeignKey#validateConstraintName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getForeignKey__ValidateConstraintName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.mdde.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see de.thm.evolvedb.mdde.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.thm.evolvedb.mdde.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.mdde.Database_Schema <em>Database Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Schema</em>'.
	 * @see de.thm.evolvedb.mdde.Database_Schema
	 * @generated
	 */
	EClass getDatabase_Schema();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.Database_Schema#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see de.thm.evolvedb.mdde.Database_Schema#getLocation()
	 * @see #getDatabase_Schema()
	 * @generated
	 */
	EAttribute getDatabase_Schema_Location();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.Database_Schema#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.thm.evolvedb.mdde.Database_Schema#getVersion()
	 * @see #getDatabase_Schema()
	 * @generated
	 */
	EAttribute getDatabase_Schema_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.mdde.Database_Schema#getEntites <em>Entites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entites</em>'.
	 * @see de.thm.evolvedb.mdde.Database_Schema#getEntites()
	 * @see #getDatabase_Schema()
	 * @generated
	 */
	EReference getDatabase_Schema_Entites();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.mdde.Column <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column</em>'.
	 * @see de.thm.evolvedb.mdde.Column
	 * @generated
	 */
	EClass getColumn();

	/**
	 * Returns the meta object for the container reference '{@link de.thm.evolvedb.mdde.Column#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Table</em>'.
	 * @see de.thm.evolvedb.mdde.Column#getTable()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_Table();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.Column#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see de.thm.evolvedb.mdde.Column#getDefaultValue()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.Column#getNotNull <em>Not Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Null</em>'.
	 * @see de.thm.evolvedb.mdde.Column#getNotNull()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_NotNull();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.Column#getAutoIncrement <em>Auto Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Increment</em>'.
	 * @see de.thm.evolvedb.mdde.Column#getAutoIncrement()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_AutoIncrement();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.Column#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see de.thm.evolvedb.mdde.Column#getSize()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Size();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.Column#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.thm.evolvedb.mdde.Column#getType()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Type();

	/**
	 * Returns the meta object for the reference list '{@link de.thm.evolvedb.mdde.Column#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see de.thm.evolvedb.mdde.Column#getConstraints()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_Constraints();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.mdde.Column#validateDefaultValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Default Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Default Value</em>' operation.
	 * @see de.thm.evolvedb.mdde.Column#validateDefaultValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getColumn__ValidateDefaultValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.mdde.Column#validateSizeValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Size Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Size Value</em>' operation.
	 * @see de.thm.evolvedb.mdde.Column#validateSizeValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getColumn__ValidateSizeValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.mdde.Column#validateUniqueConstraintName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Constraint Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Constraint Name</em>' operation.
	 * @see de.thm.evolvedb.mdde.Column#validateUniqueConstraintName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getColumn__ValidateUniqueConstraintName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.mdde.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see de.thm.evolvedb.mdde.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.mdde.Constraint#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see de.thm.evolvedb.mdde.Constraint#getColumns()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Columns();

	/**
	 * Returns the meta object for the container reference '{@link de.thm.evolvedb.mdde.Constraint#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Table</em>'.
	 * @see de.thm.evolvedb.mdde.Constraint#getTable()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Table();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.Constraint#getSortSequence <em>Sort Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sort Sequence</em>'.
	 * @see de.thm.evolvedb.mdde.Constraint#getSortSequence()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_SortSequence();

	/**
	 * Returns the meta object for the '{@link de.thm.evolvedb.mdde.Constraint#validateUniqueConstraintName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Constraint Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Constraint Name</em>' operation.
	 * @see de.thm.evolvedb.mdde.Constraint#validateUniqueConstraintName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConstraint__ValidateUniqueConstraintName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.mdde.UniqueConstraint <em>Unique Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Constraint</em>'.
	 * @see de.thm.evolvedb.mdde.UniqueConstraint
	 * @generated
	 */
	EClass getUniqueConstraint();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.mdde.Index <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index</em>'.
	 * @see de.thm.evolvedb.mdde.Index
	 * @generated
	 */
	EClass getIndex();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.Index#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.thm.evolvedb.mdde.Index#getType()
	 * @see #getIndex()
	 * @generated
	 */
	EAttribute getIndex_Type();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.mdde.ColumnConstraint <em>Column Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column Constraint</em>'.
	 * @see de.thm.evolvedb.mdde.ColumnConstraint
	 * @generated
	 */
	EClass getColumnConstraint();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.ColumnConstraint#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see de.thm.evolvedb.mdde.ColumnConstraint#getLength()
	 * @see #getColumnConstraint()
	 * @generated
	 */
	EAttribute getColumnConstraint_Length();

	/**
	 * Returns the meta object for the container reference '{@link de.thm.evolvedb.mdde.ColumnConstraint#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Constraint</em>'.
	 * @see de.thm.evolvedb.mdde.ColumnConstraint#getConstraint()
	 * @see #getColumnConstraint()
	 * @generated
	 */
	EReference getColumnConstraint_Constraint();

	/**
	 * Returns the meta object for the reference '{@link de.thm.evolvedb.mdde.ColumnConstraint#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see de.thm.evolvedb.mdde.ColumnConstraint#getColumn()
	 * @see #getColumnConstraint()
	 * @generated
	 */
	EReference getColumnConstraint_Column();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.mdde.ColumnConstraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.thm.evolvedb.mdde.ColumnConstraint#getName()
	 * @see #getColumnConstraint()
	 * @generated
	 */
	EAttribute getColumnConstraint_Name();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.mdde.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see de.thm.evolvedb.mdde.DataType
	 * @generated
	 */
	EEnum getDataType();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.mdde.Referential_Action <em>Referential Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Referential Action</em>'.
	 * @see de.thm.evolvedb.mdde.Referential_Action
	 * @generated
	 */
	EEnum getReferential_Action();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.mdde.SortSequence <em>Sort Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sort Sequence</em>'.
	 * @see de.thm.evolvedb.mdde.SortSequence
	 * @generated
	 */
	EEnum getSortSequence();

	/**
	 * Returns the meta object for enum '{@link de.thm.evolvedb.mdde.IndexType <em>Index Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Index Type</em>'.
	 * @see de.thm.evolvedb.mdde.IndexType
	 * @generated
	 */
	EEnum getIndexType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Column Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Column Size</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getColumnSize();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MddeFactory getMddeFactory();

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
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.impl.TableImpl
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__SCHEMA = eINSTANCE.getTable_Schema();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLUMNS = eINSTANCE.getTable_Columns();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__CONSTRAINTS = eINSTANCE.getTable_Constraints();

		/**
		 * The meta object literal for the '<em><b>Get Primary Keys</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TABLE___GET_PRIMARY_KEYS = eINSTANCE.getTable__GetPrimaryKeys();

		/**
		 * The meta object literal for the '<em><b>Get Primary Key By Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TABLE___GET_PRIMARY_KEY_BY_NAME__STRING = eINSTANCE.getTable__GetPrimaryKeyByName__String();

		/**
		 * The meta object literal for the '<em><b>Get Foreign Keys</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TABLE___GET_FOREIGN_KEYS = eINSTANCE.getTable__GetForeignKeys();

		/**
		 * The meta object literal for the '<em><b>Get Main Primary Key</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TABLE___GET_MAIN_PRIMARY_KEY = eINSTANCE.getTable__GetMainPrimaryKey();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.impl.PrimaryKeyImpl <em>Primary Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.impl.PrimaryKeyImpl
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getPrimaryKey()
		 * @generated
		 */
		EClass PRIMARY_KEY = eINSTANCE.getPrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Primary Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_KEY__PRIMARY_KEY = eINSTANCE.getPrimaryKey_PrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Referenced By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_KEY__REFERENCED_BY = eINSTANCE.getPrimaryKey_ReferencedBy();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.impl.ForeignKeyImpl <em>Foreign Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.impl.ForeignKeyImpl
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getForeignKey()
		 * @generated
		 */
		EClass FOREIGN_KEY = eINSTANCE.getForeignKey();

		/**
		 * The meta object literal for the '<em><b>Referenced Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREIGN_KEY__REFERENCED_TABLE = eINSTANCE.getForeignKey_ReferencedTable();

		/**
		 * The meta object literal for the '<em><b>Primary Foreign Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOREIGN_KEY__PRIMARY_FOREIGN_KEY = eINSTANCE.getForeignKey_PrimaryForeignKey();

		/**
		 * The meta object literal for the '<em><b>On Update</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOREIGN_KEY__ON_UPDATE = eINSTANCE.getForeignKey_OnUpdate();

		/**
		 * The meta object literal for the '<em><b>On Delete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOREIGN_KEY__ON_DELETE = eINSTANCE.getForeignKey_OnDelete();

		/**
		 * The meta object literal for the '<em><b>Constraint Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOREIGN_KEY__CONSTRAINT_NAME = eINSTANCE.getForeignKey_ConstraintName();

		/**
		 * The meta object literal for the '<em><b>Referenced Key Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREIGN_KEY__REFERENCED_KEY_COLUMN = eINSTANCE.getForeignKey_ReferencedKeyColumn();

		/**
		 * The meta object literal for the '<em><b>Validate Constraint Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FOREIGN_KEY___VALIDATE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getForeignKey__ValidateConstraintName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.impl.NamedElementImpl
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.impl.Database_SchemaImpl <em>Database Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.impl.Database_SchemaImpl
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getDatabase_Schema()
		 * @generated
		 */
		EClass DATABASE_SCHEMA = eINSTANCE.getDatabase_Schema();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_SCHEMA__LOCATION = eINSTANCE.getDatabase_Schema_Location();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_SCHEMA__VERSION = eINSTANCE.getDatabase_Schema_Version();

		/**
		 * The meta object literal for the '<em><b>Entites</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_SCHEMA__ENTITES = eINSTANCE.getDatabase_Schema_Entites();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.impl.ColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.impl.ColumnImpl
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getColumn()
		 * @generated
		 */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN__TABLE = eINSTANCE.getColumn_Table();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__DEFAULT_VALUE = eINSTANCE.getColumn_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Not Null</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__NOT_NULL = eINSTANCE.getColumn_NotNull();

		/**
		 * The meta object literal for the '<em><b>Auto Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__AUTO_INCREMENT = eINSTANCE.getColumn_AutoIncrement();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__SIZE = eINSTANCE.getColumn_Size();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__TYPE = eINSTANCE.getColumn_Type();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN__CONSTRAINTS = eINSTANCE.getColumn_Constraints();

		/**
		 * The meta object literal for the '<em><b>Validate Default Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLUMN___VALIDATE_DEFAULT_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getColumn__ValidateDefaultValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Size Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLUMN___VALIDATE_SIZE_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getColumn__ValidateSizeValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Constraint Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLUMN___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getColumn__ValidateUniqueConstraintName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.impl.ConstraintImpl
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__COLUMNS = eINSTANCE.getConstraint_Columns();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__TABLE = eINSTANCE.getConstraint_Table();

		/**
		 * The meta object literal for the '<em><b>Sort Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__SORT_SEQUENCE = eINSTANCE.getConstraint_SortSequence();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Constraint Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONSTRAINT___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getConstraint__ValidateUniqueConstraintName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.impl.UniqueConstraintImpl <em>Unique Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.impl.UniqueConstraintImpl
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getUniqueConstraint()
		 * @generated
		 */
		EClass UNIQUE_CONSTRAINT = eINSTANCE.getUniqueConstraint();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.impl.IndexImpl <em>Index</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.impl.IndexImpl
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getIndex()
		 * @generated
		 */
		EClass INDEX = eINSTANCE.getIndex();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX__TYPE = eINSTANCE.getIndex_Type();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.impl.ColumnConstraintImpl <em>Column Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.impl.ColumnConstraintImpl
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getColumnConstraint()
		 * @generated
		 */
		EClass COLUMN_CONSTRAINT = eINSTANCE.getColumnConstraint();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN_CONSTRAINT__LENGTH = eINSTANCE.getColumnConstraint_Length();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN_CONSTRAINT__CONSTRAINT = eINSTANCE.getColumnConstraint_Constraint();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN_CONSTRAINT__COLUMN = eINSTANCE.getColumnConstraint_Column();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN_CONSTRAINT__NAME = eINSTANCE.getColumnConstraint_Name();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.DataType
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.Referential_Action <em>Referential Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.Referential_Action
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getReferential_Action()
		 * @generated
		 */
		EEnum REFERENTIAL_ACTION = eINSTANCE.getReferential_Action();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.SortSequence <em>Sort Sequence</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.SortSequence
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getSortSequence()
		 * @generated
		 */
		EEnum SORT_SEQUENCE = eINSTANCE.getSortSequence();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.mdde.IndexType <em>Index Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.mdde.IndexType
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getIndexType()
		 * @generated
		 */
		EEnum INDEX_TYPE = eINSTANCE.getIndexType();

		/**
		 * The meta object literal for the '<em>Column Size</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see de.thm.evolvedb.mdde.impl.MddePackageImpl#getColumnSize()
		 * @generated
		 */
		EDataType COLUMN_SIZE = eINSTANCE.getColumnSize();
		
		
		

	}

} //MddePackage
