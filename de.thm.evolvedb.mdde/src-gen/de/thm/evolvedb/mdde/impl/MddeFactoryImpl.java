/**
 */
package de.thm.evolvedb.mdde.impl;

import de.thm.evolvedb.mdde.*;

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
public class MddeFactoryImpl extends EFactoryImpl implements MddeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MddeFactory init() {
		try {
			MddeFactory theMddeFactory = (MddeFactory)EPackage.Registry.INSTANCE.getEFactory(MddePackage.eNS_URI);
			if (theMddeFactory != null) {
				return theMddeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MddeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MddeFactoryImpl() {
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
			case MddePackage.TABLE: return createTable();
			case MddePackage.PRIMARY_KEY: return createPrimaryKey();
			case MddePackage.FOREIGN_KEY: return createForeignKey();
			case MddePackage.DATABASE_SCHEMA: return createDatabase_Schema();
			case MddePackage.COLUMN: return createColumn();
			case MddePackage.UNIQUE_CONSTRAINT: return createUniqueConstraint();
			case MddePackage.INDEX: return createIndex();
			case MddePackage.COLUMN_CONSTRAINT: return createColumnConstraint();
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
			case MddePackage.DATA_TYPE:
				return createDataTypeFromString(eDataType, initialValue);
			case MddePackage.REFERENTIAL_ACTION:
				return createReferential_ActionFromString(eDataType, initialValue);
			case MddePackage.SORT_SEQUENCE:
				return createSortSequenceFromString(eDataType, initialValue);
			case MddePackage.INDEX_TYPE:
				return createIndexTypeFromString(eDataType, initialValue);
			case MddePackage.COLUMN_SIZE:
				return createColumnSizeFromString(eDataType, initialValue);
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
			case MddePackage.DATA_TYPE:
				return convertDataTypeToString(eDataType, instanceValue);
			case MddePackage.REFERENTIAL_ACTION:
				return convertReferential_ActionToString(eDataType, instanceValue);
			case MddePackage.SORT_SEQUENCE:
				return convertSortSequenceToString(eDataType, instanceValue);
			case MddePackage.INDEX_TYPE:
				return convertIndexTypeToString(eDataType, instanceValue);
			case MddePackage.COLUMN_SIZE:
				return convertColumnSizeToString(eDataType, instanceValue);
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
	public Table createTable() {
		TableImpl table = new TableImpl();
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimaryKey createPrimaryKey() {
		PrimaryKeyImpl primaryKey = new PrimaryKeyImpl();
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForeignKey createForeignKey() {
		ForeignKeyImpl foreignKey = new ForeignKeyImpl();
		return foreignKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Database_Schema createDatabase_Schema() {
		Database_SchemaImpl database_Schema = new Database_SchemaImpl();
		return database_Schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column createColumn() {
		ColumnImpl column = new ColumnImpl();
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniqueConstraint createUniqueConstraint() {
		UniqueConstraintImpl uniqueConstraint = new UniqueConstraintImpl();
		return uniqueConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Index createIndex() {
		IndexImpl index = new IndexImpl();
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnConstraint createColumnConstraint() {
		ColumnConstraintImpl columnConstraint = new ColumnConstraintImpl();
		return columnConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataTypeFromString(EDataType eDataType, String initialValue) {
		DataType result = DataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referential_Action createReferential_ActionFromString(EDataType eDataType, String initialValue) {
		Referential_Action result = Referential_Action.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReferential_ActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortSequence createSortSequenceFromString(EDataType eDataType, String initialValue) {
		SortSequence result = SortSequence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSortSequenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexType createIndexTypeFromString(EDataType eDataType, String initialValue) {
		IndexType result = IndexType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndexTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createColumnSizeFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertColumnSizeToString(EDataType eDataType, Object instanceValue) {
		//The size has to match one of the two following paterns. If none of the pattern matches, an Illegal Argument Exception is thrown.
		if (instanceValue == null)
			return null;
		String value = String.valueOf(instanceValue);
		if (value.equals(""))
			return value;
		if (value.matches("[0-9]+"))
			return value;
		if (value.matches("[0-9]{1,2}\\.[0-9]{1,2}"))
			return value;
		throw new IllegalArgumentException("Size/Display witdh may only contain digits or decimal values!");

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertDefaultValueToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MddePackage getMddePackage() {
		return (MddePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MddePackage getPackage() {
		return MddePackage.eINSTANCE;
	}

} //MddeFactoryImpl
