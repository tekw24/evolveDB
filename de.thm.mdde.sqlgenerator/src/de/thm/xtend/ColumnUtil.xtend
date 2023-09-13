package de.thm.xtend

import de.thm.evolvedb.mdde.Column
import java.util.Arrays
import java.util.List
import de.thm.evolvedb.mdde.DataType
import java.util.Map
import de.thm.evolvedb.mdde.Database_Schema
import de.thm.evolvedb.mdde.PrimaryKey
import de.thm.evolvedb.mdde.Table

class ColumnUtil {

	public static List<DataType> textTypes = Arrays.asList(DataType.CHAR, DataType.VARCHAR, DataType.TEXT,
		DataType.MEDIUMTEXT, DataType.LONGTEXT, DataType.TINYTEXT);
	public static List<DataType> dateTypesWithFraction = Arrays.asList(DataType.DATETIME, DataType.TIMESTAMP,
		DataType.TIME);
	public static List<DataType> dateTypes = Arrays.asList(DataType.DATE, DataType.YEAR);
	public static List<DataType> decimalTypes = Arrays.asList(DataType.DEC, DataType.DECIMAL, DataType.FLOAT,
		DataType.DOUBLE);
	public static List<DataType> displayWitdhTypes = Arrays.asList(DataType.BIGINT, DataType.INT, DataType.INTEGER,
		DataType.SMALLINT, DataType.MEDIUMINT, DataType.TINYINT);
	public static List<DataType> binaryTypes = Arrays.asList(DataType.BINARY, DataType.VARBINARY, DataType.BLOB,
		DataType.TINYBLOB, DataType.BIT, DataType.MEDIUMBLOB, DataType.LONGBLOB);

	public static List<DataType> typesWithoutSize = Arrays.asList(DataType.TINYBLOB, DataType.TINYTEXT,
		DataType.MEDIUMBLOB, DataType.MEDIUMTEXT, DataType.LONGBLOB, DataType.LONGTEXT, DataType.BOOL, DataType.BOOLEAN,
		DataType.DATE, DataType.YEAR, DataType.TINYTEXT, DataType.BIGINT, DataType.SMALLINT, DataType.MEDIUMINT);

	public static Map<DataType, Long> dataTypeMaxSize = #{
		DataType.CHAR -> 255l,
		DataType.VARCHAR -> 65535l,
		DataType.TEXT -> 65535l,
		DataType.MEDIUMTEXT -> 16777215l,
		DataType.LONGTEXT -> 4294967295l,
		DataType.TINYTEXT -> 255l,
		DataType.DATETIME -> 2l,
		DataType.TIMESTAMP -> 2l,
		DataType.YEAR -> 4l,
		DataType.DEC -> 65l,
		DataType.DECIMAL -> 65l,
		DataType.FLOAT -> 2l,
		DataType.DOUBLE -> 2l,
		DataType.BIGINT -> 1844674407370955161l,
		DataType.INT -> 4294967295l,
		DataType.INTEGER -> 4294967295l,
		DataType.SMALLINT -> 65535l,
		DataType.MEDIUMINT -> 816777215l,
		DataType.BINARY -> 255l,
		DataType.VARBINARY -> 65535l,
		DataType.TINYBLOB -> 255l,
		DataType.BLOB -> 65535l,
		DataType.BIT -> 64l,
		DataType.MEDIUMBLOB -> 16777215l,
		DataType.LONGBLOB -> 4294967295l,
		DataType.BOOL -> 1l,
		DataType.BOOLEAN -> 1l,
		DataType.TINYINT -> 255l,
		DataType.DATE -> 10l
	}

	def static String getSizeString(Column column) {

		var DataType type = column.type
		if (column.size === null || typesWithoutSize.contains(type)) {
			return '';
		}

		if (column.size.matches("[0-9]+")) {
			var size = Integer.valueOf(column.size)

			if (displayWitdhTypes.contains(type) || textTypes.contains(type) || dateTypesWithFraction.contains(type) ||
				decimalTypes.contains(type) || binaryTypes.contains(type)) {
				return '''(«size»)'''

			}
		} else if (column.size.matches("[0-9]+\\.[0-9]+") && decimalTypes.contains(type)) {
			var size = column.size.replace('.', ',');
			return '''(«size»)'''
		}

		return '';

	}

	def static int getSizeValue(String size) {
		var sizeA = 0;
		if (size !== null && size.matches("[0-9]+")) {
			sizeA = Integer.valueOf(size);
		}
		return sizeA;
	}

	def static int getDecimalSizeValue(String size) {
		var sizeA = 0;
		if (size.matches("[0-9]+\\.[0-9]+")) {
			var split = size.split("\\.")
			if (split.length == 2) {
				sizeA = Integer.valueOf(split.get(0));
				var sizeB = Integer.valueOf(split.get(1));
				sizeA -= sizeB;
			}

		} else if (size.matches("[0-9]+")) {
			sizeA = Integer.valueOf(size);
		}
		return sizeA;
	}

	def static String getDefaultValueString(Column column) {

		//Default Value can be an empty string
		
		if(column.defaultValue !== null && column.defaultValue.equals("''") && (ColumnUtil.textTypes.contains(column.type) || ColumnUtil.binaryTypes.contains(column.type)))
			return "DEFAULT ''"
		
		if (column.defaultValue === null || column.defaultValue.equals("")) {
			return '';
		} else {

			var content = '''«IF SQLGenerator.textTypes.contains(column.type)»DEFAULT '«column.defaultValue»'«ELSE»DEFAULT «column.defaultValue»«ENDIF»'''
			return content;
		}

	}
	
	def static String getDefaultValueStringWithoutDEFAULT(Column column) {

		if (column.defaultValue === null || column.defaultValue.equals("")) {
			return '';
		} else {

			var content = '''«IF SQLGenerator.textTypes.contains(column.type)»'«column.defaultValue»'«ELSE»«column.defaultValue»«ENDIF»'''
			return content;
		}

	}

	def static String getRegexStringForWhereClause(Column objA, Column objB, PrimaryKey key) {
		if (textTypes.contains(objA.type)) {

			if (decimalTypes.contains(objB.type)) {
				return '''not REGEXP ^-?[0-9]+\.[0-9]+$;'''
			} else if (displayWitdhTypes.contains(objB.type)) {
				return '''not REGEXP '^-?[0-9]+$';'''
			} else if (dateTypesWithFraction.contains(objB.type) || dateTypes.contains(objB.type)) {
				var substring = objB.table.name.substring(0, 1);
				var dateString = '';
				if (objB.type === DataType.DATE)
					dateString = 'DATE';
				if (objB.type === DataType.DATETIME)
					dateString = 'DATETIME';
				if (objB.type === DataType.TIME)
					dateString = 'TIME';

				return '''«key.name» in (SELECT «key.name» FROM «objB.table.name» «substring»1 where STR_TO_DATE(«substring»1.«objB.name», GET_FORMAT(«dateString»,'ISO')) is null) and «objB.name» is not null ; '''

			// return ''' (SELECT DATE(«objB.name») FROM «objB.table.name» «substring»1 where «substring».DB_ID = «substring»1.DB_ID ) is not null ;'''
			} else if (textTypes.contains(objB.type) || binaryTypes.contains(objB.type)) {

				if (objB.type === DataType.VARCHAR || objB.type === DataType.CHAR || objB.type === DataType.VARBINARY ||
					objB.type === DataType.BIT)
					return '''LENGTH(`«objB.name»`) > «getSizeValue(objB.size)»;'''
				return '''LENGTH(`«objB.name»`) > «dataTypeMaxSize.get(objB.type)»;'''

			}

		} else if (dateTypesWithFraction.contains(objA.type) || dateTypes.contains(objA.type)) {

			if (textTypes.contains(objB.type) || binaryTypes.contains(objB.type)) {
				return '''LENGTH(`«objB.name»`) > «getSizeValue(objB.size)»;'''
			} else if (decimalTypes.contains(objB.type)) {
				return '''LENGTH(`«objB.name»`) > «dataTypeMaxSize.get(objB.type)»;'''
			} else if (displayWitdhTypes.contains(objB.type)) {
				return '''LENGTH(`«objB.name»`) > «dataTypeMaxSize.get(objB.type)»;'''
			} else if (dateTypesWithFraction.contains(objB.type) || dateTypes.contains(objB.type)) {
				if (objA.type === DataType.YEAR || objB.type === DataType.YEAR)
					return '''«objB.name» != null'''
			}

		} else if (decimalTypes.contains(objA.type)) {

			if (textTypes.contains(objB.type) || binaryTypes.contains(objB.type)) {
				return '''LENGTH(`«objB.name»`) > «dataTypeMaxSize.get(objB.type)»;'''
			} else if (decimalTypes.contains(objB.type)) {
				return '''LENGTH(`«objB.name»`) > «dataTypeMaxSize.get(objB.type)»;'''
			} else if (displayWitdhTypes.contains(objB.type)) {
				return '''«objB.name» > «dataTypeMaxSize.get(objB.type)»;'''
			} else if (dateTypesWithFraction.contains(objB.type) || dateTypes.contains(objB.type)) {
				//Possible but currently unchecked
				'''«objB.name» is not null;'''
			}

		} else if (displayWitdhTypes.contains(objA.type)) {
			if (textTypes.contains(objB.type) || binaryTypes.contains(objB.type)) {
				return '''LENGTH(`«objB.name»`) > «getSizeValue(objB.size)»;'''
			} else if (decimalTypes.contains(objB.type)) {
				if (objB.type === DataType.DEC || objB.type === DataType.DECIMAL)
					return '''LENGTH(`«objB.name»`) > «getDecimalSizeValue(objB.size)»;'''
			} else if (displayWitdhTypes.contains(objB.type)) {
				return '''LENGTH(`«objB.name»`) > «dataTypeMaxSize.get(objB.type)»;'''
			} else if (dateTypesWithFraction.contains(objB.type) || dateTypes.contains(objB.type)) {
				//Possible but currently unchecked
				'''«objB.name» is not null;'''
			}

		} else if (binaryTypes.contains(objA.type)) {
			if (textTypes.contains(objB.type) || binaryTypes.contains(objB.type)) {

				if (objB.type === DataType.VARCHAR || objB.type === DataType.CHAR || objB.type === DataType.VARBINARY ||
					objB.type === DataType.BIT)
					return '''LENGTH(`«objB.name»`) > «getSizeValue(objB.size)»;'''
				return '''LENGTH(`«objB.name»`) > «dataTypeMaxSize.get(objB.type)»;'''

			} else if (decimalTypes.contains(objB.type)) {
				if (objB.type === DataType.DEC || objB.type === DataType.DECIMAL)
					return '''LENGTH(`«objB.name»`) > «getDecimalSizeValue(objB.size)» and not REGEXP ^-?[0-9]+\.[0-9]+$;'''
				return '''not REGEXP ^-?[0-9]+\.[0-9]+$;'''
			} else if (displayWitdhTypes.contains(objB.type)) {
				return '''LENGTH(`«objB.name»`) > «dataTypeMaxSize.get(objB.type)» and not REGEXP '^-?[0-9]+$';'''
			} else if (dateTypesWithFraction.contains(objB.type) || dateTypes.contains(objB.type)) {
				var substring = objB.table.name.substring(0, 1);
				return '''«objB.name» in (SELECT «key.name» FROM «objB.table.name» «substring»1 where STR_TO_DATE(«substring»1.«objB.name», GET_FORMAT(DATE,'ISO')) is null) and «objB.name» is not null ; '''
			}

		}

	}

	/**
	 * Creates a table for Data Cleansing
	 */
	def static String createDataCleansingTable(String tableName, Database_Schema databaseSchema) {

		'''
		CREATE TABLE IF NOT EXISTS `«databaseSchema.name»`.`«tableName»` (
		  `DB_ID` BIGINT NOT NULL AUTO_INCREMENT,
		  `TABLENAME` VARCHAR(255) NOT NULL,
		  `COLUMN_DB_ID` BIGINT NOT NULL,
		  `COLUMN_NAME` VARCHAR(255) NOT NULL,
		  `VALUE` BLOB NULL,
		  `CHANGEDATE` DATETIME NOT NULL,
		  PRIMARY KEY (`DB_ID`));'''

	}

	/** 
	 * Creates the statement for inserting column values into the history table
	 * */
	def static String createInsertColumnHistoryScript(String tableName, Database_Schema databaseSchema, Column obj,
		PrimaryKey primaryKey, String whereClause) {
		var substring = obj.table.name.substring(0, 1);
		// The where clause adds the missing semicolon
		'''
			INSERT INTO `«databaseSchema.name»`.`«tableName»`
			(`TABLENAME`,
			`COLUMN_DB_ID`,
			`COLUMN_NAME`,
			`VALUE`,
			`CHANGEDATE`)
			SELECT '«obj.table.name»', «primaryKey.name», '«obj.name»', «obj.name», now() from «obj.table.name» «substring» where «whereClause»
		'''

	}

	/** 
	 * Creates the statement for inserting column values into the history table
	 * */
	def static String createInsertColumnHistoryScriptWithTempTable(String tableName, Database_Schema databaseSchema,
		Column obj, PrimaryKey primaryKey, String temp_table_name) {

		'''
			INSERT INTO `«databaseSchema.name»`.`«tableName»`
			(`TABLENAME`,
			`COLUMN_DB_ID`,
			`COLUMN_NAME`,
			`VALUE`,
			`CHANGEDATE`)
			SELECT '«obj.table.name»', «primaryKey.name», '«obj.name»', «obj.name», now() from «obj.table.name» where «primaryKey.name» in (Select «primaryKey.name» from «temp_table_name»);
		'''

	}

	def static String createTemporaryTable(String temp_table_name, Database_Schema schema, Table table, PrimaryKey key,
		String whereClause) {
		var content = '''
			SET @sql_mode = @@SESSION.sql_mode;
			set @@SESSION.sql_mode = '';
			DROP TEMPORARY TABLE IF EXISTS «temp_table_name»;
			CREATE TEMPORARY TABLE «temp_table_name»
			   SELECT «key.name» from «table.name» v where «whereClause»  
			set @@SESSION.sql_mode = @sql_mode;
		''';
		return content;
	}

	def static String deleteTemporaryTable(String temp_table_name) {
		'''
			DROP TEMPORARY TABLE IF EXISTS «temp_table_name»;
		'''
	}

	/**
	 * Creates the statement for inserting a row into the history table
	 */
	def static String createInsertRowHistoryScript(String tableName, Database_Schema schema, Table table,
		PrimaryKey key, String temp_table_name) {
		// The where clause adds the missing semicolon
		var content = '''''';

		for (Column column : table.columns) {
			if (!column.name.equals(key.name)) {
				content += createInsertColumnHistoryScriptWithTempTable(tableName, schema, column, key, temp_table_name)
			}
		}

		return content;
	}

	/**
	 * Checks whether the old and the new column types are compatible.
	 */
	def static boolean checkColumnTypeCompatibility(Column objA, Column objB) {

		if (textTypes.contains(objA.type)) {

			if (textTypes.contains(objB.type)) {
				return checkTextToText(objA, objB);
			} else if (dateTypesWithFraction.contains(objB.type) || dateTypes.contains(objB.type)) {
				return checkTextToDate(objA, objB);
			} else if (decimalTypes.contains(objB.type)) {
				return checkTextToDecimal(objA, objB);
			} else if (displayWitdhTypes.contains(objB.type)) {
				return checkTextToNumeric(objA, objB);
			} else if (binaryTypes.contains(objB.type)) {
				return checkTextToBinary(objA, objB);
			}

		} else if (dateTypesWithFraction.contains(objA.type) || dateTypes.contains(objA.type)) {

			if (textTypes.contains(objB.type)) {
				return checkDateToText(objA, objB);
			} else if (dateTypesWithFraction.contains(objB.type) || dateTypes.contains(objB.type)) {
				return checkDateToDate(objA, objB);
			} else if (decimalTypes.contains(objB.type)) {
				return checkDateToDecimal(objA, objB);
			} else if (displayWitdhTypes.contains(objB.type)) {
				return checkDateToNumeric(objA, objB);
			} else if (binaryTypes.contains(objB.type)) {
				return checkDateToBinary(objA, objB);
			}

		} else if (decimalTypes.contains(objA.type)) {

			if (textTypes.contains(objB.type)) {
				return checkDecimalToText(objA, objB);
			} else if (dateTypesWithFraction.contains(objB.type) || dateTypes.contains(objB.type)) {
				return checkDecimalToDate(objA, objB);
			} else if (decimalTypes.contains(objB.type)) {
				return checkDecimalToDecimal(objA, objB);
			} else if (displayWitdhTypes.contains(objB.type)) {
				return checkDecimalToNumeric(objA, objB);
			} else if (binaryTypes.contains(objB.type)) {
				return checkDecimalToBinary(objA, objB);
			}

		} else if (displayWitdhTypes.contains(objA.type)) {

			if (textTypes.contains(objB.type)) {
				return checkNumericToText(objA, objB);
			} else if (dateTypesWithFraction.contains(objB.type) || dateTypes.contains(objB.type)) {
				return checkNumericToDate(objA, objB);
			} else if (decimalTypes.contains(objB.type)) {
				return checkNumericToDecimal(objA, objB);
			} else if (displayWitdhTypes.contains(objB.type)) {
				return checkNumericToNumeric(objA, objB);
			} else if (binaryTypes.contains(objB.type)) {
				return checkNumericToBinary(objA, objB);
			}

		} else if (binaryTypes.contains(objA.type)) {

			if (textTypes.contains(objB.type)) {
				return checkBinaryToText(objA, objB);
			} else if (dateTypesWithFraction.contains(objB.type) || dateTypes.contains(objB.type)) {
				return checkBinaryToDate(objA, objB);
			} else if (decimalTypes.contains(objB.type)) {
				return checkBinaryToDecimal(objA, objB);
			} else if (displayWitdhTypes.contains(objB.type)) {
				return checkBinaryToNumeric(objA, objB);
			} else if (binaryTypes.contains(objB.type)) {
				return checkBinaryToBinary(objA, objB);
			}

		}

		return false
	}

	// Check text type compatibility
	def static boolean checkTextToText(Column objA, Column objB) {

		switch objA.type {
			case VARCHAR: {

				switch objB.type {
					case CHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return true;
						} else
							return false;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden size ueberfuehrt
						return true;
					}
					case TINYTEXT: {
						if (getSizeValue(objA.size) <= 255) {
							return true;
						} else
							return false;
					}
					case MEDIUMTEXT: {
						// VARCHAR ist kleiner als MEDIUMTEXT
						return true;
					}
					case LONGTEXT: {
						// VARCHAR ist kleiner als LONGTEXT
						return true;
					}
				}

			}
			case CHAR: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return true;
						} else
							return false;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden size gesetzt
						return true;
					}
					case TINYTEXT: {
						return true;
					}
					case MEDIUMTEXT: {
						return true;
					}
					case LONGTEXT: {
						return true;
					}
				}

			}
			case TEXT: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return true;
						} else
							return false;
					}
					case CHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return true;
						} else
							return false;
					}
					case TINYTEXT: {
						if (getSizeValue(objA.size) <= 255) {
							return true;
						} else
							return false;
					}
					case MEDIUMTEXT: {
						if (getSizeValue(objA.size) <= 16777215) {
							return true;
						} else
							return false;
					}
					case LONGTEXT: {
						return true;
					}
				}

			}
			case TINYTEXT: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= 255) {
							return true;
						} else
							return false;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= 255) {
							return true;
						} else
							return false;

					}
					case TEXT: {
						return true;
					}
					case MEDIUMTEXT: {
						return true;
					}
					case LONGTEXT: {
						return true;
					}
				}

			}
			case MEDIUMTEXT: {

				switch objB.type {
					case VARCHAR: {
						return false;
					}
					case CHAR: {
						return false;
					}
					case TEXT: {
						// Die Daten koennten zu lang sein. Eventuell gegen die Size ueberpruefen. TODO
						return false;
					}
					case TINYTEXT: {
						return false;
					}
					case LONGTEXT: {
						return true;
					}
				}

			}
			case LONGTEXT: {

				return true;
			}
		}

		return false;
	}

	def static boolean checkTextToDate(Column objA, Column objB) {

		switch objA.type {
			case VARCHAR: {
				return false;
			}
			case CHAR: {
				return false;
			}
			case TINYTEXT: {
				return false;
			}
			case TEXT: {
				return false;
			}
			case MEDIUMTEXT: {
				return false;
			}
			case LONGTEXT: {
				return false;
			}
		}

		return false;
	}

	def static boolean checkTextToNumeric(Column objA, Column objB) {

		switch objA.type {
			case VARCHAR: {
				return false;
			}
			case CHAR: {
				return false;
			}
			case TINYTEXT: {
				return false;
			}
			case TEXT: {
				return false;
			}
			case MEDIUMTEXT: {
				return false;
			}
			case LONGTEXT: {
				return false;
			}
		}

		return false;
	}

	def static boolean checkTextToDecimal(Column objA, Column objB) {

		switch objA.type {
			case VARCHAR: {
				return false;
			}
			case CHAR: {
				return false;
			}
			case TINYTEXT: {
				return false;
			}
			case TEXT: {
				return false;
			}
			case MEDIUMTEXT: {
				return false;
			}
			case LONGTEXT: {
				return false;
			}
		}

		return false;
	}

	def static boolean checkTextToBinary(Column objA, Column objB) {

		switch objA.type {
			case VARCHAR: {
				switch objB.type {
					case BLOB: {
						return true;
					}
					case TINYBLOB: {
						if (getSizeValue(objA.size) <= 255) {
							return true;
						} else
							return false;

					}
					case MEDIUMBLOB: {
						return true;

					}
					case LONGBLOB: {
						return true;
					}
					case BINARY: {

						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return true;
						} else
							return false;

					}
					case BIT: {
						return false;
					}
				}
			}
			case CHAR: {

				switch objB.type {
					case BLOB: {
						return true;
					}
					case TINYBLOB: {
						return true;
					}
					case MEDIUMBLOB: {
						return true;
					}
					case LONGBLOB: {
						return true;
					}
					case BINARY: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return true;
						} else
							return false;
					}
					case BIT: {
						return true;
					}
				}

			}
			case TINYTEXT: {

				switch objB.type {
					case BLOB: {
						return true;
					}
					case TINYBLOB: {
						return true;
					}
					case MEDIUMBLOB: {
						return true;
					}
					case LONGBLOB: {
						return true;
					}
					case BINARY: {
						if (getSizeValue(objB.size) == 255) {
							return true;
						} else
							return false;
					}
					case BIT: {
						return false;
					}
				}

			}
			case TEXT: {

				switch objB.type {
					case BLOB: {
						return true;
					}
					case TINYBLOB: {
						if (getSizeValue(objA.size) <= 255) {
							return true;
						} else
							return false;
					}
					case MEDIUMBLOB: {
						if (getSizeValue(objA.size) <= 16777215) {
							return true;
						} else
							return false;
					}
					case LONGBLOB: {
						return true;
					}
					case BINARY: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return true;
						} else
							return false;
					}
					case BIT: {
						return false;
					}
				}

			}
			case MEDIUMTEXT: {

				switch objB.type {
					case BLOB: {
						return true;
					}
					case TINYBLOB: {
						return false
					}
					case MEDIUMBLOB: {
						return true;
					}
					case LONGBLOB: {
						return true;
					}
					case BINARY: {
						return false;
					}
					case BIT: {
						return false;
					}
				}

			}
			case LONGTEXT: {

				switch objB.type {
					case BLOB: {
						return false;
					}
					case TINYBLOB: {
						return false;
					}
					case MEDIUMBLOB: {
						return false;
					}
					case LONGBLOB: {
						return true;
					}
					case BINARY: {
						return false;
					}
					case BIT: {
						return false;
					}
				}

			}
		}

		return false;
	}

	// Check date type compatibility
	def static boolean checkDateToText(Column objA, Column objB) {

		switch objA.type {
			case DATE: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= 10) {
							return true;
						} else
							return false;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr»«e ueberfuehrt
						return true;
					}
					case TINYTEXT: {
						return true;
					}
					case MEDIUMTEXT: {
						return true;
					}
					case LONGTEXT: {
						return true;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= 10) {
							return true;
						} else
							return false;
					}
				}

			}
			case TIME: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= (10 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr»«e ueberfuehrt
						return true;
					}
					case TINYTEXT: {
						return true;
					}
					case MEDIUMTEXT: {
						return true;
					}
					case LONGTEXT: {
						return true;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= (10 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
				}

			}
			case TIMESTAMP: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= (19 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr»«e ueberfuehrt
						return true;
					}
					case TINYTEXT: {
						return true;
					}
					case MEDIUMTEXT: {
						return true;
					}
					case LONGTEXT: {
						return true;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= (19 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
				}

			}
			case DATETIME: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= (19 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr»«e ueberfuehrt
						return true;
					}
					case TINYTEXT: {
						return true;
					}
					case MEDIUMTEXT: {
						return true;
					}
					case LONGTEXT: {
						return true;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= (19 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
				}

			}
			case YEAR: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= 4) {
							return true;
						} else
							return false;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr»«e ueberfuehrt
						return true;
					}
					case TINYTEXT: {
						return true;
					}
					case MEDIUMTEXT: {
						return true;
					}
					case LONGTEXT: {
						return true;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= 4) {
							return true;
						} else
							return false;
					}
				}

			}
		}

		return false;
	}

	def static boolean checkDateToDate(Column objA, Column objB) {

		switch objA.type {
			case DATE: {

				switch objA.type {
					case TIME: {
						// Uhrzeit wird zu 0 Uhr
						return false;
					}
					case TIMESTAMP: {
						// Uhrzeit wird zu 0 Uhr
						return true;
					}
					case DATETIME: {
						// Uhrzeit wird zu 0 Uhr
						return true;
					}
					case YEAR: {
						// Geht nicht automatisch
						return false;
					}
				}

			}
			case TIME: {

				switch objA.type {
					case DATE: {
						// Wird auf das aktuelle Datum gesetzt.
						return true;
					}
					case TIMESTAMP: {
						// Wird auf das aktuelle Datum gesetzt.
						return true;
					}
					case DATETIME: {
						// Wird auf das aktuelle Datum gesetzt.
						return true;
					}
					case YEAR: {
						// YEAR wird zu 0
						return true;
					}
				}

			}
			case TIMESTAMP: {

				switch objA.type {
					case DATE: {
						return true;
					}
					case TIME: {
						return true;
					}
					case DATETIME: {
						return true;
					}
					case YEAR: {
						// YEAR wird zu 0
						return false;
					}
				}

			}
			case DATETIME: {

				switch objA.type {
					case DATE: {
						return true;
					}
					case TIME: {
						return true;
					}
					case TIMESTAMP: {
						return true;
					}
					case YEAR: {
						// YEAR wird zu 0
						return false;
					}
				}
			}
			case YEAR: {

				switch objA.type {
					case DATE: {
						return false;
					}
					case TIME: {
						return false;
					}
					case TIMESTAMP: {
						return false;
					}
					case DATETIME: {
						return false;
					}
				}
			}
		}

		return false;
	}

	def static boolean checkDateToNumeric(Column objA, Column objB) {

		switch objA.type {
			case DATE: {

				switch objB.type {
					case BIGINT: {
						return true;
					}
					case INT,
					case INTEGER: {
						return true;
					}
					case MEDIUMINT: {
						return false;
					}
					case TINYINT: {
						return false;
					}
					case SMALLINT: {
						return false;
					}
				}

			}
			case TIME: {
				switch objB.type {
					case BIGINT: {
						return true;
					}
					case INT,
					case INTEGER: {
						return true;
					}
					case MEDIUMINT: {
						return true;
					}
					case TINYINT: {
						return false;
					}
					case SMALLINT: {
						return false;
					}
				}
			}
			case TIMESTAMP: {
				switch objB.type {
					case BIGINT: {
						return true;
					}
					case INT,
					case INTEGER,
					case TINYINT,
					case SMALLINT,
					case MEDIUMINT: {
						return false;
					}
				}
			}
			case DATETIME: {
				switch objB.type {
					case BIGINT: {
						return true;
					}
					case INT,
					case INTEGER,
					case TINYINT,
					case SMALLINT,
					case MEDIUMINT: {
						return false;
					}
				}
			}
			case YEAR: {
				switch objB.type {
					case BIGINT,
					case SMALLINT,
					case MEDIUMINT,
					case INT,
					case INTEGER: {
						return true;
					}
					case TINYINT: {
						return false;
					}
				}
			}
		}

		return false;
	}

	def static boolean checkDateToDecimal(Column objA, Column objB) {

		switch objA.type {
			case DATE: {
				switch objB.type {
					case DEC,
					case DECIMAL: {
						if (getDecimalSizeValue(objB.size) >= 8) {
							return true;
						} else
							return false;
					}
					case FLOAT: {
						return true;
					}
					case DOUBLE: {
						return true;
					}
				}
			}
			case TIME: {
				switch objB.type {
					case DEC,
					case DECIMAL: {
						return true;
					}
					case FLOAT: {
						return true;

					}
					case DOUBLE: {
						return true;
					}
				}

			}
			case TIMESTAMP: {
				switch objB.type {
					case DEC,
					case DECIMAL: {
						if (getDecimalSizeValue(objB.size) >= (14 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
					case FLOAT: {
						return true;
					}
					case DOUBLE: {
						return true;
					}
				}
			}
			case DATETIME: {
				switch objB.type {
					case DEC,
					case DECIMAL: {
						if (getDecimalSizeValue(objB.size) >= (14 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
					case FLOAT: {
						return true;
					}
					case DOUBLE: {
						return true;
					}
				}
			}
			case YEAR: {
				switch objB.type {
					case DEC,
					case DECIMAL: {
						return true;
					}
					case FLOAT: {
						return true;
					}
					case DOUBLE: {
						return true;
					}
				}
			}
		}

		return false;
	}

	def static boolean checkDateToBinary(Column objA, Column objB) {

		switch objA.type {
			case DATE: {
				switch objB.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case TINYBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) > (10 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
					case BIT: {
						return false;
					}
				}
			}
			case TIME: {
				switch objB.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case TINYBLOB: {
						return true;

					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) > (8 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
					case BIT: {
						return false;
					}
				}
			}
			case TIMESTAMP: {
				switch objB.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case TINYBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) > (20 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
					case BIT: {
						return false;
					}
				}
			}
			case DATETIME: {
				switch objB.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case TINYBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) > (20 + getSizeValue(objA.size))) {
							return true;
						} else
							return false;
					}
					case BIT: {
						return false;
					}
				}
			}
			case YEAR: {
				switch objB.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case TINYBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) >= 4) {
							return true;
						} else
							return false;
					}
					case BIT: {
						return false;
					}
				}
			}
		}

		return false;
	}

	// Check Numeric type compatibility
	def static boolean checkNumericToText(Column objA, Column objB) {

		switch objB.type {
			case TINYTEXT,
			case TEXT,
			case MEDIUMTEXT,
			case LONGTEXT: {
				return true;
			}
		}

		switch objA.type {
			case BIGINT: {
				if (getSizeValue(objB.size) >= 20) {
					return true;
				} else
					return false;
			}
			case INT,
			case INTEGER: {
				if (getSizeValue(objB.size) >= 10) {
					return true;
				} else
					return false;
			}
			case MEDIUMINT: {
				if (getSizeValue(objB.size) >= 8) {
					return true;
				} else
					return false;
			}
			case TINYINT: {
				if (getSizeValue(objB.size) >= 3) {
					return true;
				} else
					return false;
			}
			case SMALLINT: {
				if (getSizeValue(objB.size) >= 5) {
					return true;
				} else
					return false;
			}
		}
		return false;
	}

//TODO
	def static boolean checkNumericToDate(Column objA, Column objB) {
		switch objA.type {
			case BIGINT: {
				switch objB.type {
					case DATE: {
						return true;
					}
					case TIME: {
					}
					case TIMESTAMP: {
					}
					case DATETIME: {
					}
					case YEAR: {
					}
				}
			}
			case INT,
			case INTEGER: {
				switch objB.type {
					case DATE: {
						return true;
					}
					case TIME: {
					}
					case TIMESTAMP: {
					}
					case DATETIME: {
					}
					case YEAR: {
					}
				}
			}
			case MEDIUMINT: {
				switch objB.type {
					case DATE: {
						return false;
					}
					case TIME: {
					}
					case TIMESTAMP: {
						return false;
					}
					case DATETIME: {
						return false;
					}
					case YEAR: {
					}
				}
			}
			case TINYINT: {
				switch objB.type {
					case DATE: {
						return false;
					}
					case TIME: {
						return false;
					}
					case TIMESTAMP: {
						return false;
					}
					case DATETIME: {
						return false;
					}
					case YEAR: {
						return false;
					}
				}
			}
			case SMALLINT: {
				switch objB.type {
					case DATE: {
						return false;
					}
					case TIME: {
						return false;
					}
					case TIMESTAMP: {
						return false;
					}
					case DATETIME: {
						return false;
					}
					case YEAR: {
						return false;
					}
				}
			}
		}
		return false;
	}

	def static boolean checkNumericToNumeric(Column objA, Column objB) {
		switch objA.type {
			case BIGINT: {
				switch objA.type {
					case INT,
					case INTEGER,
					case MEDIUMINT,
					case TINYINT,
					case SMALLINT: {
						return false;
					}
				}
			}
			case INT,
			case INTEGER: {
				switch objA.type {
					case BIGINT: {
						return true;
					}
					case MEDIUMINT,
					case SMALLINT,
					case TINYINT: {
						return false;
					}
				}
			}
			case MEDIUMINT: {
				switch objA.type {
					case BIGINT,
					case INT,
					case INTEGER: {
						return true;
					}
					case TINYINT,
					case SMALLINT: {
						return false;
					}
				}
			}
			case TINYINT: {
				switch objA.type {
					case BIGINT,
					case INT,
					case INTEGER,
					case MEDIUMINT,
					case SMALLINT: {
						return true;
					}
				}
			}
			case SMALLINT: {
				switch objA.type {
					case BIGINT,
					case INT,
					case INTEGER,
					case MEDIUMINT: {
						return true;
					}
					case TINYINT: {
						return false;
					}
				}
			}
		}
		return false;
	}

	def static boolean checkNumericToDecimal(Column objA, Column objB) {

		switch objB.type {
			case FLOAT,
			case DOUBLE: {
				return true;
			}
		}

		switch objA.type {
			case BIGINT: {
				if (getDecimalSizeValue(objA.size) >= 20) {
					return true;
				} else
					return false;
			}
			case INT,
			case INTEGER: {
				if (getDecimalSizeValue(objA.size) >= 10) {
					return true;
				} else
					return false;
			}
			case MEDIUMINT: {
				if (getDecimalSizeValue(objA.size) >= 8) {
					return true;
				} else
					return false;
			}
			case TINYINT: {
				if (getDecimalSizeValue(objA.size) >= 3) {
					return true;
				} else
					return false;
			}
			case SMALLINT: {
				if (getDecimalSizeValue(objA.size) >= 5) {
					return true;
				} else
					return false;
			}
		}
		return false;
	}

	def static boolean checkNumericToBinary(Column objA, Column objB) {
		switch objA.type {
			case BIGINT: {
				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						// Check Size 
						return false;
					}
				}
			}
			case INT,
			case INTEGER: {
				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						// Check number of digits.
						return false;
					}
				}

			}
			case MEDIUMINT: {
				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						// Check number of digits.
						return false;
					}
				}
			}
			case TINYINT: {
				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						// Check number of digits.
						return false;
					}
				}
			}
			case SMALLINT: {
				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						// Check number of digits.
						return false;
					}
				}
			}
		}
		return false;
	}

	// Check decimal type compatibility
	def static boolean checkDecimalToText(Column objA, Column objB) {
		switch objA.type {
			case DEC,
			case DECIMAL: {
				switch objB.type {
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return true;
					}
					case CHAR,
					case VARCHAR: {
						if (getDecimalSizeValue(objA.size) >= getSizeValue(objB.size)) {
							return true;
						} else
							return false;
					}
				}

			}
			case FLOAT: {
				switch objB.type {
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return true;
					}
					case CHAR,
					case VARCHAR: {
						// Check number of digits.
						return false;
					}
				}

			}
			case DOUBLE: {
				switch objB.type {
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return true;
					}
					case CHAR,
					case VARCHAR: {
						// Check number of digits.
						return false;
					}
				}

			}
		}
		return false;
	}

	def static boolean checkDecimalToDate(Column objA, Column objB) {
		return false;
	}

	// TODO
	def static boolean checkDecimalToNumeric(Column objA, Column objB) {

		switch objA.type {
			case DEC,
			case DECIMAL: {
			}
			case FLOAT: {
			}
			case DOUBLE: {
			}
		}

		switch objB.type {
			case BIGINT: {
			}
			case INT,
			case INTEGER: {
			}
			case MEDIUMINT: {
			}
			case TINYINT: {
			}
			case SMALLINT: {
			}
		}
		return false;
	}

	def static boolean checkDecimalToDecimal(Column objA, Column objB) {

		switch objA.type {
			case DEC,
			case DECIMAL: {

				switch objB.type {
					case FLOAT: {
						if (getDecimalSizeValue(objA.size) <= 39) {
							return true;
						} else
							return false;

					}
					case DOUBLE: {
						return true;
					}
				}

			}
			case FLOAT: {

				switch objB.type {
					case DEC,
					case DECIMAL: {
						return false;
					}
					case DOUBLE: {
						return true;
					}
				}
			}
			case DOUBLE: {

				switch objB.type {
					case DEC,
					case DECIMAL: {
						// Geht zwar wenn der Decimal die richtige Gr»«e hat aber geht einher mit Datenverlust
						return false;
					}
					case FLOAT: {
						return false;
					}
				}
			}
		}

		return false;

	}

	def static boolean checkDecimalToBinary(Column objA, Column objB) {

		switch objA.type {
			case DEC,
			case DECIMAL: {

				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {

						if (getSizeValue(objB.size) >= getDecimalSizeValue(objA.size)) {
							return true;
						} else
							return false;

					}
					case BIT: {

						if (getSizeValue(objB.size) >= getDecimalSizeValue(objA.size)) {
							return true;
						} else
							return false;
					}
				}

			}
			case FLOAT: {

				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) >= 65) {
							return true;
						} else
							return false;
					}
					case BIT: {
						return false;
					}
				}

			}
			case DOUBLE: {

				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) >= 65) {
							return true;
						} else
							return false;
					}
					case BIT: {
						return false;
					}
				}

			}
		}

		return false;
	}

	// Check binary type compatibility
	def static boolean checkBinaryToText(Column objA, Column objB) {
		switch objA.type {
			case BLOB: {

				switch objB.type {
					case CHAR: {
						return false;
					}
					case VARCHAR: {
						return true;
					}
					case TINYTEXT: {
						return false;
					}
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return true;
					}
				}
			}
			case TINYBLOB: {
				switch objB.type {
					case CHAR: {
						if (getSizeValue(objB.size) == 255) {
							return true;
						} else
							return false;
					}
					case VARCHAR,
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return true;
					}
				}
			}
			case MEDIUMBLOB: {
				switch objB.type {
					case CHAR,
					case VARCHAR,
					case TINYTEXT,
					case TEXT: {
						return false;
					}
					case MEDIUMTEXT,
					case LONGTEXT: {
						return true;
					}
				}
			}
			case LONGBLOB: {
				switch objB.type {
					case CHAR,
					case VARCHAR,
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT: {
						return false;
					}
					case LONGTEXT: {
						return true;
					}
				}
			}
			case BINARY: {
				switch objB.type {
					case CHAR: {
						if (getSizeValue(objB.size) == 255) {
							return true;
						} else
							return false;
					}
					case VARCHAR: {
						if (getSizeValue(objB.size) >= 255) {
							return true;
						} else
							return false;
					}
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return true;
					}
				}
			}
			case VARBINARY: {
				switch objB.type {
					case CHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return true;
						} else
							return false;
					}
					case VARCHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return true;
						} else
							return false;
					}
					case TINYTEXT: {
						if (getSizeValue(objA.size) <= 255) {
							return true;
						} else
							return false;
					}
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return true;
					}
				}
			}
			case BIT: {
				switch objB.type {
					case CHAR,
					case VARCHAR,
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return true;
					}
				}
			}
		}
		return false;
	}

	def static boolean checkBinaryToDate(Column objA, Column objB) {
		// Format ueberpruefen und Gr»«e
		switch objA.type {
			case BLOB: {
				return false;
			}
			case TINYBLOB: {
				return false;
			}
			case MEDIUMBLOB: {
				return false;
			}
			case LONGBLOB: {
				return false;
			}
			case BINARY: {
				return false;
			}
			case VARBINARY: {
				return false;
			}
			case BIT: {
				return false;
			}
		}
		return false;
	}

	def static boolean checkBinaryToNumeric(Column objA, Column objB) {

		// check format and size
		switch objA.type {
			case BLOB: {
				return false;
			}
			case TINYBLOB: {
				return false;
			}
			case MEDIUMBLOB: {
				return false;
			}
			case LONGBLOB: {
				return false;
			}
			case BINARY: {
				return false;
			}
			case VARBINARY: {
				return false;
			}
			case BIT: {
				return false;
			}
		}

		return false;
	}

	def static boolean checkBinaryToDecimal(Column objA, Column objB) {
		switch objA.type {
			case BLOB,
			case TINYBLOB,
			case MEDIUMBLOB,
			case LONGBLOB,
			case BINARY,
			case VARBINARY,
			case BIT: {
				// check format
				return false;
			}
		}
		return false;
	}

	def static boolean checkBinaryToBinary(Column objA, Column objB) {
		switch objA.type {
			case BLOB: {
				switch objA.type {
					case TINYBLOB: {
						return false;
					}
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY: {
						return false;
					}
					case VARBINARY: {
						if (getSizeValue(objB.size) == 65535) {
							return true;
						} else
							return false;

					}
					case BIT: {
						return false;
					}
				}
			}
			case TINYBLOB: {
				switch objA.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY: {
						if (getSizeValue(objB.size) == 255) {
							return true;
						} else
							return false;
					}
					case VARBINARY: {
						return true;
					}
					case BIT: {
						if (getSizeValue(objA.size) <= 1) {
							return true;
						} else
							return false;
					}
				}
			}
			case MEDIUMBLOB: {
				switch objA.type {
					case BLOB: {
						return false;
					}
					case TINYBLOB: {
						return false;
					}
					case LONGBLOB: {
						return true;
					}
					case BINARY: {
						return false;
					}
					case VARBINARY: {
						return false;
					}
					case BIT: {
						return false;
					}
				}
			}
			case LONGBLOB: {
				switch objA.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case BINARY,
					case VARBINARY,
					case BIT: {
						return false;
					}
				}
			}
			case BINARY: {
				switch objA.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case VARBINARY: {
						return true;
					}
					case BIT: {
						if (getSizeValue(objA.size) <= 1) {
							return true;
						} else
							return false;
					}
				}
			}
			case VARBINARY: {
				switch objA.type {
					case BLOB: {
						return true;
					}
					case TINYBLOB: {
						if (getSizeValue(objA.size) <= 255) {
							return true;
						} else
							return false;
					}
					case MEDIUMBLOB,
					case LONGBLOB: {
						return true;
					}
					case BINARY: {
						if (getSizeValue(objA.size) <= 255) {
							return true;
						} else
							return false;
					}
					case BIT: {
						if (getSizeValue(objA.size) <= 1) {
							return true;
						} else
							return false;
					}
				}
			}
			case BIT: {
				switch objA.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case BINARY,
					case VARBINARY: {
						return true;
					}
				}
			}
		}
		return false;
	}

}
