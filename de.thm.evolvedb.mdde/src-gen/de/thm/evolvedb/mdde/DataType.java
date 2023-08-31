/**
 */
package de.thm.evolvedb.mdde;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Data Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.mdde.MddePackage#getDataType()
 * @model
 * @generated
 */
public enum DataType implements Enumerator {
	/**
	 * The '<em><b>CHAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHAR_VALUE
	 * @generated
	 * @ordered
	 */
	CHAR(0, "CHAR", "CHAR"),

	/**
	 * The '<em><b>VARCHAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARCHAR_VALUE
	 * @generated
	 * @ordered
	 */
	VARCHAR(1, "VARCHAR", "VARCHAR"),

	/**
	 * The '<em><b>BINARY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY(2, "BINARY", "BINARY"),

	/**
	 * The '<em><b>VARBINARY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARBINARY_VALUE
	 * @generated
	 * @ordered
	 */
	VARBINARY(3, "VARBINARY", "VARBINARY"),

	/**
	 * The '<em><b>TINYBLOB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TINYBLOB_VALUE
	 * @generated
	 * @ordered
	 */
	TINYBLOB(4, "TINYBLOB", "TINYBLOB"),

	/**
	 * The '<em><b>TINYTEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TINYTEXT_VALUE
	 * @generated
	 * @ordered
	 */
	TINYTEXT(5, "TINYTEXT", "TINYTEXT"),

	/**
	 * The '<em><b>TEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT_VALUE
	 * @generated
	 * @ordered
	 */
	TEXT(6, "TEXT", "TEXT"),

	/**
	 * The '<em><b>BLOB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOB_VALUE
	 * @generated
	 * @ordered
	 */
	BLOB(7, "BLOB", "BLOB"),

	/**
	 * The '<em><b>MEDIUMTEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIUMTEXT_VALUE
	 * @generated
	 * @ordered
	 */
	MEDIUMTEXT(8, "MEDIUMTEXT", "MEDIUMTEXT"),

	/**
	 * The '<em><b>MEDIUMBLOB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIUMBLOB_VALUE
	 * @generated
	 * @ordered
	 */
	MEDIUMBLOB(9, "MEDIUMBLOB", "MEDIUMBLOB"),

	/**
	 * The '<em><b>LONGTEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LONGTEXT_VALUE
	 * @generated
	 * @ordered
	 */
	LONGTEXT(10, "LONGTEXT", "LONGTEXT"),

	/**
	 * The '<em><b>LONGBLOB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LONGBLOB_VALUE
	 * @generated
	 * @ordered
	 */
	LONGBLOB(11, "LONGBLOB", "LONGBLOB"),

	/**
	 * The '<em><b>ENUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENUM_VALUE
	 * @generated
	 * @ordered
	 */
	ENUM(12, "ENUM", "ENUM"),

	/**
	 * The '<em><b>SET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_VALUE
	 * @generated
	 * @ordered
	 */
	SET(13, "SET", "SET"),

	/**
	 * The '<em><b>BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIT_VALUE
	 * @generated
	 * @ordered
	 */
	BIT(14, "BIT", "BIT"),

	/**
	 * The '<em><b>TINYINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TINYINT_VALUE
	 * @generated
	 * @ordered
	 */
	TINYINT(15, "TINYINT", "TINYINT"),

	/**
	 * The '<em><b>BOOL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOL_VALUE
	 * @generated
	 * @ordered
	 */
	BOOL(16, "BOOL", "BOOL"),

	/**
	 * The '<em><b>BOOLEAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_VALUE
	 * @generated
	 * @ordered
	 */
	BOOLEAN(17, "BOOLEAN", "BOOLEAN"),

	/**
	 * The '<em><b>SMALLINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMALLINT_VALUE
	 * @generated
	 * @ordered
	 */
	SMALLINT(18, "SMALLINT", "SMALLINT"),

	/**
	 * The '<em><b>MEDIUMINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIUMINT_VALUE
	 * @generated
	 * @ordered
	 */
	MEDIUMINT(19, "MEDIUMINT", "MEDIUMINT"),

	/**
	 * The '<em><b>INT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_VALUE
	 * @generated
	 * @ordered
	 */
	INT(20, "INT", "INT"),

	/**
	 * The '<em><b>INTEGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGER_VALUE
	 * @generated
	 * @ordered
	 */
	INTEGER(21, "INTEGER", "INTEGER"),

	/**
	 * The '<em><b>BIGINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIGINT_VALUE
	 * @generated
	 * @ordered
	 */
	BIGINT(22, "BIGINT", "BIGINT"),

	/**
	 * The '<em><b>FLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	FLOAT(23, "FLOAT", "FLOAT"),

	/**
	 * The '<em><b>DOUBLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE(24, "DOUBLE", "DOUBLE"),

	/**
	 * The '<em><b>DECIMAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECIMAL_VALUE
	 * @generated
	 * @ordered
	 */
	DECIMAL(25, "DECIMAL", "DECIMAL"),

	/**
	 * The '<em><b>DEC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEC_VALUE
	 * @generated
	 * @ordered
	 */
	DEC(26, "DEC", "DEC"),

	/**
	 * The '<em><b>DATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATE_VALUE
	 * @generated
	 * @ordered
	 */
	DATE(27, "DATE", "DATE"),

	/**
	 * The '<em><b>DATETIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATETIME_VALUE
	 * @generated
	 * @ordered
	 */
	DATETIME(28, "DATETIME", "DATETIME"),

	/**
	 * The '<em><b>TIMESTAMP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMESTAMP_VALUE
	 * @generated
	 * @ordered
	 */
	TIMESTAMP(29, "TIMESTAMP", "TIMESTAMP"),

	/**
	 * The '<em><b>TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIME_VALUE
	 * @generated
	 * @ordered
	 */
	TIME(30, "TIME", "TIME"),

	/**
	 * The '<em><b>YEAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YEAR_VALUE
	 * @generated
	 * @ordered
	 */
	YEAR(31, "YEAR", "YEAR"), /**
	 * The '<em><b>BIGINT UNSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIGINT_UNSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	BIGINT_UNSIGNED(32, "BIGINT_UNSIGNED", "BIGINT UNSIGNED"), /**
	 * The '<em><b>INT UNSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_UNSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	INT_UNSIGNED(33, "INT_UNSIGNED", "INT UNSIGNED"), /**
	 * The '<em><b>INTEGER UNSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGER_UNSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	INTEGER_UNSIGNED(34, "INTEGER_UNSIGNED", "INTEGER UNSIGNED"), /**
	 * The '<em><b>TINYINT UNSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TINYINT_UNSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	TINYINT_UNSIGNED(35, "TINYINT_UNSIGNED", "TINYINT UNSIGNED"), /**
	 * The '<em><b>SMALLINT UNSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMALLINT_UNSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	SMALLINT_UNSIGNED(36, "SMALLINT_UNSIGNED", "SMALLINT UNSIGNED"), /**
	 * The '<em><b>MEDIUMINT UNSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIUMINT_UNSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	MEDIUMINT_UNSIGNED(37, "MEDIUMINT_UNSIGNED", "MEDIUMINT UNSIGNED"), /**
	 * The '<em><b>FLOAT UNSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_UNSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	FLOAT_UNSIGNED(38, "FLOAT_UNSIGNED", "FLOAT UNSIGNED"), /**
	 * The '<em><b>DOUBLE UNSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_UNSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_UNSIGNED(39, "DOUBLE_UNSIGNED", "DOUBLE UNSIGNED"), /**
	 * The '<em><b>DECIMAL UNSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECIMAL_UNSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	DECIMAL_UNSIGNED(40, "DECIMAL_UNSIGNED", "DECIMAL UNSIGNED"), /**
	 * The '<em><b>DEC UNSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEC_UNSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	DEC_UNSIGNED(41, "DEC_UNSIGNED", "DEC UNSIGNED");

	/**
	 * The '<em><b>CHAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHAR_VALUE = 0;

	/**
	 * The '<em><b>VARCHAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARCHAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VARCHAR_VALUE = 1;

	/**
	 * The '<em><b>BINARY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_VALUE = 2;

	/**
	 * The '<em><b>VARBINARY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARBINARY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VARBINARY_VALUE = 3;

	/**
	 * The '<em><b>TINYBLOB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TINYBLOB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TINYBLOB_VALUE = 4;

	/**
	 * The '<em><b>TINYTEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TINYTEXT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TINYTEXT_VALUE = 5;

	/**
	 * The '<em><b>TEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEXT_VALUE = 6;

	/**
	 * The '<em><b>BLOB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BLOB_VALUE = 7;

	/**
	 * The '<em><b>MEDIUMTEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIUMTEXT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEDIUMTEXT_VALUE = 8;

	/**
	 * The '<em><b>MEDIUMBLOB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIUMBLOB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEDIUMBLOB_VALUE = 9;

	/**
	 * The '<em><b>LONGTEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LONGTEXT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LONGTEXT_VALUE = 10;

	/**
	 * The '<em><b>LONGBLOB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LONGBLOB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LONGBLOB_VALUE = 11;

	/**
	 * The '<em><b>ENUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENUM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENUM_VALUE = 12;

	/**
	 * The '<em><b>SET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_VALUE = 13;

	/**
	 * The '<em><b>BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BIT_VALUE = 14;

	/**
	 * The '<em><b>TINYINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TINYINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TINYINT_VALUE = 15;

	/**
	 * The '<em><b>BOOL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOOL_VALUE = 16;

	/**
	 * The '<em><b>BOOLEAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_VALUE = 17;

	/**
	 * The '<em><b>SMALLINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMALLINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SMALLINT_VALUE = 18;

	/**
	 * The '<em><b>MEDIUMINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIUMINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEDIUMINT_VALUE = 19;

	/**
	 * The '<em><b>INT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INT_VALUE = 20;

	/**
	 * The '<em><b>INTEGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INTEGER_VALUE = 21;

	/**
	 * The '<em><b>BIGINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIGINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BIGINT_VALUE = 22;

	/**
	 * The '<em><b>FLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOAT_VALUE = 23;

	/**
	 * The '<em><b>DOUBLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_VALUE = 24;

	/**
	 * The '<em><b>DECIMAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECIMAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DECIMAL_VALUE = 25;

	/**
	 * The '<em><b>DEC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEC_VALUE = 26;

	/**
	 * The '<em><b>DATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATE_VALUE = 27;

	/**
	 * The '<em><b>DATETIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATETIME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATETIME_VALUE = 28;

	/**
	 * The '<em><b>TIMESTAMP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMESTAMP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIMESTAMP_VALUE = 29;

	/**
	 * The '<em><b>TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIME_VALUE = 30;

	/**
	 * The '<em><b>YEAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YEAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int YEAR_VALUE = 31;

	/**
	 * The '<em><b>BIGINT UNSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIGINT_UNSIGNED
	 * @model literal="BIGINT UNSIGNED"
	 * @generated
	 * @ordered
	 */
	public static final int BIGINT_UNSIGNED_VALUE = 32;

	/**
	 * The '<em><b>INT UNSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_UNSIGNED
	 * @model literal="INT UNSIGNED"
	 * @generated
	 * @ordered
	 */
	public static final int INT_UNSIGNED_VALUE = 33;

	/**
	 * The '<em><b>INTEGER UNSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGER_UNSIGNED
	 * @model literal="INTEGER UNSIGNED"
	 * @generated
	 * @ordered
	 */
	public static final int INTEGER_UNSIGNED_VALUE = 34;

	/**
	 * The '<em><b>TINYINT UNSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TINYINT_UNSIGNED
	 * @model literal="TINYINT UNSIGNED"
	 * @generated
	 * @ordered
	 */
	public static final int TINYINT_UNSIGNED_VALUE = 35;

	/**
	 * The '<em><b>SMALLINT UNSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMALLINT_UNSIGNED
	 * @model literal="SMALLINT UNSIGNED"
	 * @generated
	 * @ordered
	 */
	public static final int SMALLINT_UNSIGNED_VALUE = 36;

	/**
	 * The '<em><b>MEDIUMINT UNSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIUMINT_UNSIGNED
	 * @model literal="MEDIUMINT UNSIGNED"
	 * @generated
	 * @ordered
	 */
	public static final int MEDIUMINT_UNSIGNED_VALUE = 37;

	/**
	 * The '<em><b>FLOAT UNSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_UNSIGNED
	 * @model literal="FLOAT UNSIGNED"
	 * @generated
	 * @ordered
	 */
	public static final int FLOAT_UNSIGNED_VALUE = 38;

	/**
	 * The '<em><b>DOUBLE UNSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_UNSIGNED
	 * @model literal="DOUBLE UNSIGNED"
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_UNSIGNED_VALUE = 39;

	/**
	 * The '<em><b>DECIMAL UNSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECIMAL_UNSIGNED
	 * @model literal="DECIMAL UNSIGNED"
	 * @generated
	 * @ordered
	 */
	public static final int DECIMAL_UNSIGNED_VALUE = 40;

	/**
	 * The '<em><b>DEC UNSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEC_UNSIGNED
	 * @model literal="DEC UNSIGNED"
	 * @generated
	 * @ordered
	 */
	public static final int DEC_UNSIGNED_VALUE = 41;

	/**
	 * An array of all the '<em><b>Data Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DataType[] VALUES_ARRAY =
		new DataType[] {
			CHAR,
			VARCHAR,
			BINARY,
			VARBINARY,
			TINYBLOB,
			TINYTEXT,
			TEXT,
			BLOB,
			MEDIUMTEXT,
			MEDIUMBLOB,
			LONGTEXT,
			LONGBLOB,
			ENUM,
			SET,
			BIT,
			TINYINT,
			BOOL,
			BOOLEAN,
			SMALLINT,
			MEDIUMINT,
			INT,
			INTEGER,
			BIGINT,
			FLOAT,
			DOUBLE,
			DECIMAL,
			DEC,
			DATE,
			DATETIME,
			TIMESTAMP,
			TIME,
			YEAR,
			BIGINT_UNSIGNED,
			INT_UNSIGNED,
			INTEGER_UNSIGNED,
			TINYINT_UNSIGNED,
			SMALLINT_UNSIGNED,
			MEDIUMINT_UNSIGNED,
			FLOAT_UNSIGNED,
			DOUBLE_UNSIGNED,
			DECIMAL_UNSIGNED,
			DEC_UNSIGNED,
		};

	/**
	 * A public read-only list of all the '<em><b>Data Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DataType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Data Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DataType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Data Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DataType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Data Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DataType get(int value) {
		switch (value) {
			case CHAR_VALUE: return CHAR;
			case VARCHAR_VALUE: return VARCHAR;
			case BINARY_VALUE: return BINARY;
			case VARBINARY_VALUE: return VARBINARY;
			case TINYBLOB_VALUE: return TINYBLOB;
			case TINYTEXT_VALUE: return TINYTEXT;
			case TEXT_VALUE: return TEXT;
			case BLOB_VALUE: return BLOB;
			case MEDIUMTEXT_VALUE: return MEDIUMTEXT;
			case MEDIUMBLOB_VALUE: return MEDIUMBLOB;
			case LONGTEXT_VALUE: return LONGTEXT;
			case LONGBLOB_VALUE: return LONGBLOB;
			case ENUM_VALUE: return ENUM;
			case SET_VALUE: return SET;
			case BIT_VALUE: return BIT;
			case TINYINT_VALUE: return TINYINT;
			case BOOL_VALUE: return BOOL;
			case BOOLEAN_VALUE: return BOOLEAN;
			case SMALLINT_VALUE: return SMALLINT;
			case MEDIUMINT_VALUE: return MEDIUMINT;
			case INT_VALUE: return INT;
			case INTEGER_VALUE: return INTEGER;
			case BIGINT_VALUE: return BIGINT;
			case FLOAT_VALUE: return FLOAT;
			case DOUBLE_VALUE: return DOUBLE;
			case DECIMAL_VALUE: return DECIMAL;
			case DEC_VALUE: return DEC;
			case DATE_VALUE: return DATE;
			case DATETIME_VALUE: return DATETIME;
			case TIMESTAMP_VALUE: return TIMESTAMP;
			case TIME_VALUE: return TIME;
			case YEAR_VALUE: return YEAR;
			case BIGINT_UNSIGNED_VALUE: return BIGINT_UNSIGNED;
			case INT_UNSIGNED_VALUE: return INT_UNSIGNED;
			case INTEGER_UNSIGNED_VALUE: return INTEGER_UNSIGNED;
			case TINYINT_UNSIGNED_VALUE: return TINYINT_UNSIGNED;
			case SMALLINT_UNSIGNED_VALUE: return SMALLINT_UNSIGNED;
			case MEDIUMINT_UNSIGNED_VALUE: return MEDIUMINT_UNSIGNED;
			case FLOAT_UNSIGNED_VALUE: return FLOAT_UNSIGNED;
			case DOUBLE_UNSIGNED_VALUE: return DOUBLE_UNSIGNED;
			case DECIMAL_UNSIGNED_VALUE: return DECIMAL_UNSIGNED;
			case DEC_UNSIGNED_VALUE: return DEC_UNSIGNED;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DataType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //DataType
