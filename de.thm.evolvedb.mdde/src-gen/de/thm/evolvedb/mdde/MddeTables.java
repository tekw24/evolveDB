/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /de.thm.evolvedb.mdde/model/mdde.ecore
 * using:
 *   /de.thm.evolvedb.mdde/model/mdde.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package de.thm.evolvedb.mdde;

// import de.thm.evolvedb.mdde.MddeTables;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;

/**
 * MddeTables provides the dispatch tables for the mdde for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class MddeTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(MddePackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			MddeTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MddeTables::TypeParameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		static {
			Init.initStart();
			TypeParameters.init();
		}

		public static final EcoreExecutorType _Column = new EcoreExecutorType(MddePackage.Literals.COLUMN, PACKAGE, 0);
		public static final EcoreExecutorType _ColumnSize = new EcoreExecutorType("ColumnSize", PACKAGE, 0);
		public static final EcoreExecutorEnumeration _DataType = new EcoreExecutorEnumeration(MddePackage.Literals.DATA_TYPE, PACKAGE, 0);
		public static final EcoreExecutorType _Database_Schema = new EcoreExecutorType(MddePackage.Literals.DATABASE_SCHEMA, PACKAGE, 0);
		public static final EcoreExecutorType _ForeignKey = new EcoreExecutorType(MddePackage.Literals.FOREIGN_KEY, PACKAGE, 0);
		public static final EcoreExecutorType _NamedElement = new EcoreExecutorType(MddePackage.Literals.NAMED_ELEMENT, PACKAGE, 0);
		public static final EcoreExecutorType _PrimaryKey = new EcoreExecutorType(MddePackage.Literals.PRIMARY_KEY, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _Referential_Action = new EcoreExecutorEnumeration(MddePackage.Literals.REFERENTIAL_ACTION, PACKAGE, 0);
		public static final EcoreExecutorType _Table = new EcoreExecutorType(MddePackage.Literals.TABLE, PACKAGE, 0);

		private static final EcoreExecutorType /*@NonNull*/ [] types = {
			_Column,
			_ColumnSize,
			_DataType,
			_Database_Schema,
			_ForeignKey,
			_NamedElement,
			_PrimaryKey,
			_Referential_Action,
			_Table
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MddeTables::Types and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		static {
			Init.initStart();
			Types.init();
		}

		private static final ExecutorFragment _Column__Column = new ExecutorFragment(Types._Column, MddeTables.Types._Column);
		private static final ExecutorFragment _Column__NamedElement = new ExecutorFragment(Types._Column, MddeTables.Types._NamedElement);
		private static final ExecutorFragment _Column__OclAny = new ExecutorFragment(Types._Column, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Column__OclElement = new ExecutorFragment(Types._Column, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _ColumnSize__ColumnSize = new ExecutorFragment(Types._ColumnSize, MddeTables.Types._ColumnSize);
		private static final ExecutorFragment _ColumnSize__OclAny = new ExecutorFragment(Types._ColumnSize, OCLstdlibTables.Types._OclAny);

		private static final ExecutorFragment _DataType__DataType = new ExecutorFragment(Types._DataType, MddeTables.Types._DataType);
		private static final ExecutorFragment _DataType__OclAny = new ExecutorFragment(Types._DataType, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _DataType__OclElement = new ExecutorFragment(Types._DataType, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _DataType__OclEnumeration = new ExecutorFragment(Types._DataType, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _DataType__OclType = new ExecutorFragment(Types._DataType, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _Database_Schema__Database_Schema = new ExecutorFragment(Types._Database_Schema, MddeTables.Types._Database_Schema);
		private static final ExecutorFragment _Database_Schema__NamedElement = new ExecutorFragment(Types._Database_Schema, MddeTables.Types._NamedElement);
		private static final ExecutorFragment _Database_Schema__OclAny = new ExecutorFragment(Types._Database_Schema, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Database_Schema__OclElement = new ExecutorFragment(Types._Database_Schema, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _ForeignKey__Column = new ExecutorFragment(Types._ForeignKey, MddeTables.Types._Column);
		private static final ExecutorFragment _ForeignKey__ForeignKey = new ExecutorFragment(Types._ForeignKey, MddeTables.Types._ForeignKey);
		private static final ExecutorFragment _ForeignKey__NamedElement = new ExecutorFragment(Types._ForeignKey, MddeTables.Types._NamedElement);
		private static final ExecutorFragment _ForeignKey__OclAny = new ExecutorFragment(Types._ForeignKey, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _ForeignKey__OclElement = new ExecutorFragment(Types._ForeignKey, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _NamedElement__NamedElement = new ExecutorFragment(Types._NamedElement, MddeTables.Types._NamedElement);
		private static final ExecutorFragment _NamedElement__OclAny = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _NamedElement__OclElement = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _PrimaryKey__Column = new ExecutorFragment(Types._PrimaryKey, MddeTables.Types._Column);
		private static final ExecutorFragment _PrimaryKey__NamedElement = new ExecutorFragment(Types._PrimaryKey, MddeTables.Types._NamedElement);
		private static final ExecutorFragment _PrimaryKey__OclAny = new ExecutorFragment(Types._PrimaryKey, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PrimaryKey__OclElement = new ExecutorFragment(Types._PrimaryKey, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PrimaryKey__PrimaryKey = new ExecutorFragment(Types._PrimaryKey, MddeTables.Types._PrimaryKey);

		private static final ExecutorFragment _Referential_Action__OclAny = new ExecutorFragment(Types._Referential_Action, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Referential_Action__OclElement = new ExecutorFragment(Types._Referential_Action, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Referential_Action__OclEnumeration = new ExecutorFragment(Types._Referential_Action, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _Referential_Action__OclType = new ExecutorFragment(Types._Referential_Action, OCLstdlibTables.Types._OclType);
		private static final ExecutorFragment _Referential_Action__Referential_Action = new ExecutorFragment(Types._Referential_Action, MddeTables.Types._Referential_Action);

		private static final ExecutorFragment _Table__NamedElement = new ExecutorFragment(Types._Table, MddeTables.Types._NamedElement);
		private static final ExecutorFragment _Table__OclAny = new ExecutorFragment(Types._Table, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Table__OclElement = new ExecutorFragment(Types._Table, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Table__Table = new ExecutorFragment(Types._Table, MddeTables.Types._Table);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MddeTables::Fragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The parameter lists shared by operations.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Parameters {
		static {
			Init.initStart();
			Fragments.init();
		}

		public static final ParameterTypes _String = TypeUtil.createParameterTypes(OCLstdlibTables.Types._String);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MddeTables::Parameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Operations {
		static {
			Init.initStart();
			Parameters.init();
		}

		public static final ExecutorOperation _Table__getForeignKeys = new ExecutorOperation("getForeignKeys", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Table,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final ExecutorOperation _Table__getMainPrimaryKey = new ExecutorOperation("getMainPrimaryKey", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Table,
			1, TemplateParameters.EMPTY_LIST, null);
		public static final ExecutorOperation _Table__getPrimaryKeyByName = new ExecutorOperation("getPrimaryKeyByName", Parameters._String, Types._Table,
			2, TemplateParameters.EMPTY_LIST, null);
		public static final ExecutorOperation _Table__getPrimaryKeys = new ExecutorOperation("getPrimaryKeys", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Table,
			3, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MddeTables::Operations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The property descriptors for each property of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}

		public static final ExecutorProperty _Column__autoIncrement = new EcoreExecutorProperty(MddePackage.Literals.COLUMN__AUTO_INCREMENT, Types._Column, 0);
		public static final ExecutorProperty _Column__defaultValue = new EcoreExecutorProperty(MddePackage.Literals.COLUMN__DEFAULT_VALUE, Types._Column, 1);
		public static final ExecutorProperty _Column__notNull = new EcoreExecutorProperty(MddePackage.Literals.COLUMN__NOT_NULL, Types._Column, 2);
		public static final ExecutorProperty _Column__size = new EcoreExecutorProperty(MddePackage.Literals.COLUMN__SIZE, Types._Column, 3);
		public static final ExecutorProperty _Column__table = new EcoreExecutorProperty(MddePackage.Literals.COLUMN__TABLE, Types._Column, 4);
		public static final ExecutorProperty _Column__type = new EcoreExecutorProperty(MddePackage.Literals.COLUMN__TYPE, Types._Column, 5);
		public static final ExecutorProperty _Column__unique = new EcoreExecutorProperty(MddePackage.Literals.COLUMN__UNIQUE, Types._Column, 6);
		public static final ExecutorProperty _Column__uniqueConstraintName = new EcoreExecutorProperty(MddePackage.Literals.COLUMN__UNIQUE_CONSTRAINT_NAME, Types._Column, 7);

		public static final ExecutorProperty _Database_Schema__entites = new EcoreExecutorProperty(MddePackage.Literals.DATABASE_SCHEMA__ENTITES, Types._Database_Schema, 0);
		public static final ExecutorProperty _Database_Schema__location = new EcoreExecutorProperty(MddePackage.Literals.DATABASE_SCHEMA__LOCATION, Types._Database_Schema, 1);
		public static final ExecutorProperty _Database_Schema__version = new EcoreExecutorProperty(MddePackage.Literals.DATABASE_SCHEMA__VERSION, Types._Database_Schema, 2);

		public static final ExecutorProperty _ForeignKey__OnDelete = new EcoreExecutorProperty(MddePackage.Literals.FOREIGN_KEY__ON_DELETE, Types._ForeignKey, 0);
		public static final ExecutorProperty _ForeignKey__OnUpdate = new EcoreExecutorProperty(MddePackage.Literals.FOREIGN_KEY__ON_UPDATE, Types._ForeignKey, 1);
		public static final ExecutorProperty _ForeignKey__constraintName = new EcoreExecutorProperty(MddePackage.Literals.FOREIGN_KEY__CONSTRAINT_NAME, Types._ForeignKey, 2);
		public static final ExecutorProperty _ForeignKey__primaryForeignKey = new EcoreExecutorProperty(MddePackage.Literals.FOREIGN_KEY__PRIMARY_FOREIGN_KEY, Types._ForeignKey, 3);
		public static final ExecutorProperty _ForeignKey__referencedKeyColumn = new EcoreExecutorProperty(MddePackage.Literals.FOREIGN_KEY__REFERENCED_KEY_COLUMN, Types._ForeignKey, 4);
		public static final ExecutorProperty _ForeignKey__referencedTable = new EcoreExecutorProperty(MddePackage.Literals.FOREIGN_KEY__REFERENCED_TABLE, Types._ForeignKey, 5);

		public static final ExecutorProperty _NamedElement__name = new EcoreExecutorProperty(MddePackage.Literals.NAMED_ELEMENT__NAME, Types._NamedElement, 0);

		public static final ExecutorProperty _PrimaryKey__primaryKey = new EcoreExecutorProperty(MddePackage.Literals.PRIMARY_KEY__PRIMARY_KEY, Types._PrimaryKey, 0);
		public static final ExecutorProperty _PrimaryKey__referencedBy = new EcoreExecutorProperty(MddePackage.Literals.PRIMARY_KEY__REFERENCED_BY, Types._PrimaryKey, 1);

		public static final ExecutorProperty _Table__columns = new EcoreExecutorProperty(MddePackage.Literals.TABLE__COLUMNS, Types._Table, 0);
		public static final ExecutorProperty _Table__schema = new EcoreExecutorProperty(MddePackage.Literals.TABLE__SCHEMA, Types._Table, 1);
		public static final ExecutorProperty _Table__ForeignKey__referencedTable = new ExecutorPropertyWithImplementation("ForeignKey", Types._Table, 2, new EcoreLibraryOppositeProperty(MddePackage.Literals.FOREIGN_KEY__REFERENCED_TABLE));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MddeTables::Properties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		static {
			Init.initStart();
			Properties.init();
		}

		private static final ExecutorFragment /*@NonNull*/ [] _Column =
			{
				Fragments._Column__OclAny /* 0 */,
				Fragments._Column__OclElement /* 1 */,
				Fragments._Column__NamedElement /* 2 */,
				Fragments._Column__Column /* 3 */
			};
		private static final int /*@NonNull*/ [] __Column = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _ColumnSize =
			{
				Fragments._ColumnSize__OclAny /* 0 */,
				Fragments._ColumnSize__ColumnSize /* 1 */
			};
		private static final int /*@NonNull*/ [] __ColumnSize = { 1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _DataType =
			{
				Fragments._DataType__OclAny /* 0 */,
				Fragments._DataType__OclElement /* 1 */,
				Fragments._DataType__OclType /* 2 */,
				Fragments._DataType__OclEnumeration /* 3 */,
				Fragments._DataType__DataType /* 4 */
			};
		private static final int /*@NonNull*/ [] __DataType = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Database_Schema =
			{
				Fragments._Database_Schema__OclAny /* 0 */,
				Fragments._Database_Schema__OclElement /* 1 */,
				Fragments._Database_Schema__NamedElement /* 2 */,
				Fragments._Database_Schema__Database_Schema /* 3 */
			};
		private static final int /*@NonNull*/ [] __Database_Schema = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _ForeignKey =
			{
				Fragments._ForeignKey__OclAny /* 0 */,
				Fragments._ForeignKey__OclElement /* 1 */,
				Fragments._ForeignKey__NamedElement /* 2 */,
				Fragments._ForeignKey__Column /* 3 */,
				Fragments._ForeignKey__ForeignKey /* 4 */
			};
		private static final int /*@NonNull*/ [] __ForeignKey = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _NamedElement =
			{
				Fragments._NamedElement__OclAny /* 0 */,
				Fragments._NamedElement__OclElement /* 1 */,
				Fragments._NamedElement__NamedElement /* 2 */
			};
		private static final int /*@NonNull*/ [] __NamedElement = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PrimaryKey =
			{
				Fragments._PrimaryKey__OclAny /* 0 */,
				Fragments._PrimaryKey__OclElement /* 1 */,
				Fragments._PrimaryKey__NamedElement /* 2 */,
				Fragments._PrimaryKey__Column /* 3 */,
				Fragments._PrimaryKey__PrimaryKey /* 4 */
			};
		private static final int /*@NonNull*/ [] __PrimaryKey = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Referential_Action =
			{
				Fragments._Referential_Action__OclAny /* 0 */,
				Fragments._Referential_Action__OclElement /* 1 */,
				Fragments._Referential_Action__OclType /* 2 */,
				Fragments._Referential_Action__OclEnumeration /* 3 */,
				Fragments._Referential_Action__Referential_Action /* 4 */
			};
		private static final int /*@NonNull*/ [] __Referential_Action = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Table =
			{
				Fragments._Table__OclAny /* 0 */,
				Fragments._Table__OclElement /* 1 */,
				Fragments._Table__NamedElement /* 2 */,
				Fragments._Table__Table /* 3 */
			};
		private static final int /*@NonNull*/ [] __Table = { 1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Column.initFragments(_Column, __Column);
			Types._ColumnSize.initFragments(_ColumnSize, __ColumnSize);
			Types._DataType.initFragments(_DataType, __DataType);
			Types._Database_Schema.initFragments(_Database_Schema, __Database_Schema);
			Types._ForeignKey.initFragments(_ForeignKey, __ForeignKey);
			Types._NamedElement.initFragments(_NamedElement, __NamedElement);
			Types._PrimaryKey.initFragments(_PrimaryKey, __PrimaryKey);
			Types._Referential_Action.initFragments(_Referential_Action, __Referential_Action);
			Types._Table.initFragments(_Table, __Table);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MddeTables::TypeFragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		static {
			Init.initStart();
			TypeFragments.init();
		}

		private static final ExecutorOperation /*@NonNull*/ [] _Column__Column = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Column__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Column__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Column__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _ColumnSize__ColumnSize = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ColumnSize__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _DataType__DataType = {};
		private static final ExecutorOperation /*@NonNull*/ [] _DataType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _DataType__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _DataType__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _DataType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Database_Schema__Database_Schema = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Database_Schema__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Database_Schema__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Database_Schema__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _ForeignKey__ForeignKey = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ForeignKey__Column = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ForeignKey__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ForeignKey__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _ForeignKey__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _NamedElement__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _NamedElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _NamedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _PrimaryKey__PrimaryKey = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PrimaryKey__Column = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PrimaryKey__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PrimaryKey__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PrimaryKey__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Referential_Action__Referential_Action = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Referential_Action__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Referential_Action__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Referential_Action__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Referential_Action__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Table__Table = {
			MddeTables.Operations._Table__getForeignKeys /* getForeignKeys() */,
			MddeTables.Operations._Table__getMainPrimaryKey /* getMainPrimaryKey() */,
			MddeTables.Operations._Table__getPrimaryKeyByName /* getPrimaryKeyByName(String[?]) */,
			MddeTables.Operations._Table__getPrimaryKeys /* getPrimaryKeys() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Table__NamedElement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Table__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Table__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Column__Column.initOperations(_Column__Column);
			Fragments._Column__NamedElement.initOperations(_Column__NamedElement);
			Fragments._Column__OclAny.initOperations(_Column__OclAny);
			Fragments._Column__OclElement.initOperations(_Column__OclElement);

			Fragments._ColumnSize__ColumnSize.initOperations(_ColumnSize__ColumnSize);
			Fragments._ColumnSize__OclAny.initOperations(_ColumnSize__OclAny);

			Fragments._DataType__DataType.initOperations(_DataType__DataType);
			Fragments._DataType__OclAny.initOperations(_DataType__OclAny);
			Fragments._DataType__OclElement.initOperations(_DataType__OclElement);
			Fragments._DataType__OclEnumeration.initOperations(_DataType__OclEnumeration);
			Fragments._DataType__OclType.initOperations(_DataType__OclType);

			Fragments._Database_Schema__Database_Schema.initOperations(_Database_Schema__Database_Schema);
			Fragments._Database_Schema__NamedElement.initOperations(_Database_Schema__NamedElement);
			Fragments._Database_Schema__OclAny.initOperations(_Database_Schema__OclAny);
			Fragments._Database_Schema__OclElement.initOperations(_Database_Schema__OclElement);

			Fragments._ForeignKey__Column.initOperations(_ForeignKey__Column);
			Fragments._ForeignKey__ForeignKey.initOperations(_ForeignKey__ForeignKey);
			Fragments._ForeignKey__NamedElement.initOperations(_ForeignKey__NamedElement);
			Fragments._ForeignKey__OclAny.initOperations(_ForeignKey__OclAny);
			Fragments._ForeignKey__OclElement.initOperations(_ForeignKey__OclElement);

			Fragments._NamedElement__NamedElement.initOperations(_NamedElement__NamedElement);
			Fragments._NamedElement__OclAny.initOperations(_NamedElement__OclAny);
			Fragments._NamedElement__OclElement.initOperations(_NamedElement__OclElement);

			Fragments._PrimaryKey__Column.initOperations(_PrimaryKey__Column);
			Fragments._PrimaryKey__NamedElement.initOperations(_PrimaryKey__NamedElement);
			Fragments._PrimaryKey__OclAny.initOperations(_PrimaryKey__OclAny);
			Fragments._PrimaryKey__OclElement.initOperations(_PrimaryKey__OclElement);
			Fragments._PrimaryKey__PrimaryKey.initOperations(_PrimaryKey__PrimaryKey);

			Fragments._Referential_Action__OclAny.initOperations(_Referential_Action__OclAny);
			Fragments._Referential_Action__OclElement.initOperations(_Referential_Action__OclElement);
			Fragments._Referential_Action__OclEnumeration.initOperations(_Referential_Action__OclEnumeration);
			Fragments._Referential_Action__OclType.initOperations(_Referential_Action__OclType);
			Fragments._Referential_Action__Referential_Action.initOperations(_Referential_Action__Referential_Action);

			Fragments._Table__NamedElement.initOperations(_Table__NamedElement);
			Fragments._Table__OclAny.initOperations(_Table__OclAny);
			Fragments._Table__OclElement.initOperations(_Table__OclElement);
			Fragments._Table__Table.initOperations(_Table__Table);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MddeTables::FragmentOperations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		static {
			Init.initStart();
			FragmentOperations.init();
		}

		private static final ExecutorProperty /*@NonNull*/ [] _Column = {
			MddeTables.Properties._Column__autoIncrement,
			MddeTables.Properties._Column__defaultValue,
			MddeTables.Properties._NamedElement__name,
			MddeTables.Properties._Column__notNull,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			MddeTables.Properties._Column__size,
			MddeTables.Properties._Column__table,
			MddeTables.Properties._Column__type,
			MddeTables.Properties._Column__unique,
			MddeTables.Properties._Column__uniqueConstraintName
		};

		private static final ExecutorProperty /*@NonNull*/ [] _ColumnSize = {};

		private static final ExecutorProperty /*@NonNull*/ [] _DataType = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Database_Schema = {
			MddeTables.Properties._Database_Schema__entites,
			MddeTables.Properties._Database_Schema__location,
			MddeTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			MddeTables.Properties._Database_Schema__version
		};

		private static final ExecutorProperty /*@NonNull*/ [] _ForeignKey = {
			MddeTables.Properties._ForeignKey__OnDelete,
			MddeTables.Properties._ForeignKey__OnUpdate,
			MddeTables.Properties._Column__autoIncrement,
			MddeTables.Properties._ForeignKey__constraintName,
			MddeTables.Properties._Column__defaultValue,
			MddeTables.Properties._NamedElement__name,
			MddeTables.Properties._Column__notNull,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			MddeTables.Properties._ForeignKey__primaryForeignKey,
			MddeTables.Properties._ForeignKey__referencedKeyColumn,
			MddeTables.Properties._ForeignKey__referencedTable,
			MddeTables.Properties._Column__size,
			MddeTables.Properties._Column__table,
			MddeTables.Properties._Column__type,
			MddeTables.Properties._Column__unique,
			MddeTables.Properties._Column__uniqueConstraintName
		};

		private static final ExecutorProperty /*@NonNull*/ [] _NamedElement = {
			MddeTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PrimaryKey = {
			MddeTables.Properties._Column__autoIncrement,
			MddeTables.Properties._Column__defaultValue,
			MddeTables.Properties._NamedElement__name,
			MddeTables.Properties._Column__notNull,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			MddeTables.Properties._PrimaryKey__primaryKey,
			MddeTables.Properties._PrimaryKey__referencedBy,
			MddeTables.Properties._Column__size,
			MddeTables.Properties._Column__table,
			MddeTables.Properties._Column__type,
			MddeTables.Properties._Column__unique,
			MddeTables.Properties._Column__uniqueConstraintName
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Referential_Action = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Table = {
			MddeTables.Properties._Table__columns,
			MddeTables.Properties._NamedElement__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			MddeTables.Properties._Table__schema
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Column__Column.initProperties(_Column);
			Fragments._ColumnSize__ColumnSize.initProperties(_ColumnSize);
			Fragments._DataType__DataType.initProperties(_DataType);
			Fragments._Database_Schema__Database_Schema.initProperties(_Database_Schema);
			Fragments._ForeignKey__ForeignKey.initProperties(_ForeignKey);
			Fragments._NamedElement__NamedElement.initProperties(_NamedElement);
			Fragments._PrimaryKey__PrimaryKey.initProperties(_PrimaryKey);
			Fragments._Referential_Action__Referential_Action.initProperties(_Referential_Action);
			Fragments._Table__Table.initProperties(_Table);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MddeTables::FragmentProperties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		static {
			Init.initStart();
			FragmentProperties.init();
		}

		public static final EcoreExecutorEnumerationLiteral _DataType__CHAR = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("CHAR"), Types._DataType, 0);
		public static final EcoreExecutorEnumerationLiteral _DataType__VARCHAR = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("VARCHAR"), Types._DataType, 1);
		public static final EcoreExecutorEnumerationLiteral _DataType__BINARY = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("BINARY"), Types._DataType, 2);
		public static final EcoreExecutorEnumerationLiteral _DataType__VARBINARY = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("VARBINARY"), Types._DataType, 3);
		public static final EcoreExecutorEnumerationLiteral _DataType__TINYBLOB = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("TINYBLOB"), Types._DataType, 4);
		public static final EcoreExecutorEnumerationLiteral _DataType__TINYTEXT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("TINYTEXT"), Types._DataType, 5);
		public static final EcoreExecutorEnumerationLiteral _DataType__TEXT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("TEXT"), Types._DataType, 6);
		public static final EcoreExecutorEnumerationLiteral _DataType__BLOB = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("BLOB"), Types._DataType, 7);
		public static final EcoreExecutorEnumerationLiteral _DataType__MEDIUMTEXT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("MEDIUMTEXT"), Types._DataType, 8);
		public static final EcoreExecutorEnumerationLiteral _DataType__MEDIUMBLOB = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("MEDIUMBLOB"), Types._DataType, 9);
		public static final EcoreExecutorEnumerationLiteral _DataType__LONGTEXT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("LONGTEXT"), Types._DataType, 10);
		public static final EcoreExecutorEnumerationLiteral _DataType__LONGBLOB = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("LONGBLOB"), Types._DataType, 11);
		public static final EcoreExecutorEnumerationLiteral _DataType__ENUM = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("ENUM"), Types._DataType, 12);
		public static final EcoreExecutorEnumerationLiteral _DataType__SET = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("SET"), Types._DataType, 13);
		public static final EcoreExecutorEnumerationLiteral _DataType__BIT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("BIT"), Types._DataType, 14);
		public static final EcoreExecutorEnumerationLiteral _DataType__TINYINT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("TINYINT"), Types._DataType, 15);
		public static final EcoreExecutorEnumerationLiteral _DataType__BOOL = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("BOOL"), Types._DataType, 16);
		public static final EcoreExecutorEnumerationLiteral _DataType__BOOLEAN = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("BOOLEAN"), Types._DataType, 17);
		public static final EcoreExecutorEnumerationLiteral _DataType__SMALLINT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("SMALLINT"), Types._DataType, 18);
		public static final EcoreExecutorEnumerationLiteral _DataType__MEDIUMINT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("MEDIUMINT"), Types._DataType, 19);
		public static final EcoreExecutorEnumerationLiteral _DataType__INT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("INT"), Types._DataType, 20);
		public static final EcoreExecutorEnumerationLiteral _DataType__INTEGER = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("INTEGER"), Types._DataType, 21);
		public static final EcoreExecutorEnumerationLiteral _DataType__BIGINT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("BIGINT"), Types._DataType, 22);
		public static final EcoreExecutorEnumerationLiteral _DataType__FLOAT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("FLOAT"), Types._DataType, 23);
		public static final EcoreExecutorEnumerationLiteral _DataType__DOUBLE = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("DOUBLE"), Types._DataType, 24);
		public static final EcoreExecutorEnumerationLiteral _DataType__DECIMAL = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("DECIMAL"), Types._DataType, 25);
		public static final EcoreExecutorEnumerationLiteral _DataType__DEC = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("DEC"), Types._DataType, 26);
		public static final EcoreExecutorEnumerationLiteral _DataType__DATE = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("DATE"), Types._DataType, 27);
		public static final EcoreExecutorEnumerationLiteral _DataType__DATETIME = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("DATETIME"), Types._DataType, 28);
		public static final EcoreExecutorEnumerationLiteral _DataType__TIMESTAMP = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("TIMESTAMP"), Types._DataType, 29);
		public static final EcoreExecutorEnumerationLiteral _DataType__TIME = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("TIME"), Types._DataType, 30);
		public static final EcoreExecutorEnumerationLiteral _DataType__YEAR = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.DATA_TYPE.getEEnumLiteral("YEAR"), Types._DataType, 31);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _DataType = {
			_DataType__CHAR,
			_DataType__VARCHAR,
			_DataType__BINARY,
			_DataType__VARBINARY,
			_DataType__TINYBLOB,
			_DataType__TINYTEXT,
			_DataType__TEXT,
			_DataType__BLOB,
			_DataType__MEDIUMTEXT,
			_DataType__MEDIUMBLOB,
			_DataType__LONGTEXT,
			_DataType__LONGBLOB,
			_DataType__ENUM,
			_DataType__SET,
			_DataType__BIT,
			_DataType__TINYINT,
			_DataType__BOOL,
			_DataType__BOOLEAN,
			_DataType__SMALLINT,
			_DataType__MEDIUMINT,
			_DataType__INT,
			_DataType__INTEGER,
			_DataType__BIGINT,
			_DataType__FLOAT,
			_DataType__DOUBLE,
			_DataType__DECIMAL,
			_DataType__DEC,
			_DataType__DATE,
			_DataType__DATETIME,
			_DataType__TIMESTAMP,
			_DataType__TIME,
			_DataType__YEAR
		};

		public static final EcoreExecutorEnumerationLiteral _Referential_Action__RESTRICT = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.REFERENTIAL_ACTION.getEEnumLiteral("RESTRICT"), Types._Referential_Action, 0);
		public static final EcoreExecutorEnumerationLiteral _Referential_Action__CASCADE = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.REFERENTIAL_ACTION.getEEnumLiteral("CASCADE"), Types._Referential_Action, 1);
		public static final EcoreExecutorEnumerationLiteral _Referential_Action__SET_NULL = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.REFERENTIAL_ACTION.getEEnumLiteral("SET_NULL"), Types._Referential_Action, 2);
		public static final EcoreExecutorEnumerationLiteral _Referential_Action__NO_ACTION = new EcoreExecutorEnumerationLiteral(MddePackage.Literals.REFERENTIAL_ACTION.getEEnumLiteral("NO_ACTION"), Types._Referential_Action, 3);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _Referential_Action = {
			_Referential_Action__RESTRICT,
			_Referential_Action__CASCADE,
			_Referential_Action__SET_NULL,
			_Referential_Action__NO_ACTION
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._DataType.initLiterals(_DataType);
			Types._Referential_Action.initLiterals(_Referential_Action);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MddeTables::EnumerationLiterals and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 * The multiple packages above avoid problems with the Java 65536 byte limit but introduce a difficulty in ensuring that
	 * static construction occurs in the disciplined order of the packages when construction may start in any of the packages.
	 * The problem is resolved by ensuring that the static construction of each package first initializes its immediate predecessor.
	 * On completion of predecessor initialization, the residual packages are initialized by starting an initialization in the last package.
	 * This class maintains a count so that the various predecessors can distinguish whether they are the starting point and so
	 * ensure that residual construction occurs just once after all predecessors.
	 */
	private static class Init {
		/**
		 * Counter of nested static constructions. On return to zero residual construction starts. -ve once residual construction started.
		 */
		private static int initCount = 0;

		/**
		 * Invoked at the start of a static construction to defer residual construction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual construction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
				}
			}
		}
	}

	static {
		Init.initEnd();
	}

	/*
	 * Force initialization of outer fields. Inner fields are lazily initialized.
	 */
	public static void init() {
		new MddeTables();
	}

	private MddeTables() {
		super(MddePackage.eNS_URI);
	}
}
