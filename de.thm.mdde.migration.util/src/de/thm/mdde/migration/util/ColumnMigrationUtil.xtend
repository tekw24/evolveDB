package de.thm.mdde.migration.util;

import de.thm.evolvedb.mdde.Column
import java.util.Arrays
import java.util.List
import de.thm.evolvedb.mdde.DataType
import de.thm.evolvedb.migration.ColumnOptions
import java.util.ArrayList

class ColumnMigrationUtil {

	public static List<DataType> textTypes = Arrays.asList(DataType.CHAR, DataType.VARCHAR, DataType.TEXT,
		DataType.MEDIUMTEXT, DataType.LONGTEXT, DataType.TINYTEXT);
	public static List<DataType> dateTypesWithFraction = Arrays.asList(DataType.DATETIME, DataType.TIMESTAMP,
		DataType.TIME);
	public static List<DataType> dateTypes = Arrays.asList(DataType.DATE, DataType.YEAR);
	public static List<DataType> decimalTypes = Arrays.asList(DataType.DEC, DataType.DECIMAL, DataType.FLOAT,
		DataType.DOUBLE);
	public static List<DataType> displayWitdhTypes = Arrays.asList(DataType.BIGINT, DataType.INT, DataType.INTEGER,
		DataType.SMALLINT, DataType.MEDIUMINT);
	public static List<DataType> binaryTypes = Arrays.asList(DataType.BINARY, DataType.VARBINARY, DataType.BLOB,
		DataType.TINYBLOB, DataType.BIT, DataType.MEDIUMBLOB, DataType.LONGBLOB);

	/**
	 * @generated NOT
	 */
	public static List<DataType> typesWithoutSize = Arrays.asList(DataType.TINYBLOB, DataType.TINYTEXT,
		DataType.MEDIUMBLOB, DataType.MEDIUMTEXT, DataType.LONGBLOB, DataType.LONGTEXT, DataType.BOOL, DataType.BOOLEAN,
		DataType.DATE, DataType.YEAR, DataType.TINYTEXT, DataType.BIGINT, DataType.SMALLINT, DataType.MEDIUMINT);

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

	/**
	 * Checks whether the old and the new column types are compatible.
	 */
	def static List<ColumnOptions> checkColumnTypeCompatibility(Column objA, Column objB) {

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

		return new ArrayList<ColumnOptions>();
	}

	// Check text type compatibility
	def static List<ColumnOptions> checkTextToText(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case VARCHAR: {

				switch objB.type {
					case CHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr��e �berf�hrt
						return migrationOptions;
					}
					case TINYTEXT: {
						if (getSizeValue(objA.size) <= 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case MEDIUMTEXT: {
						// VARCHAR ist kleiner als MEDIUMTEXT
						return migrationOptions;
					}
					case LONGTEXT: {
						// VARCHAR ist kleiner als LONGTEXT
						return migrationOptions;
					}
				}

			}
			case CHAR: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr��e �berf�hrt
						return migrationOptions;
					}
					case TINYTEXT: {
						return migrationOptions;
					}
					case MEDIUMTEXT: {
						return migrationOptions;
					}
					case LONGTEXT: {
						return migrationOptions;
					}
				}

			}
			case TEXT: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case CHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case TINYTEXT: {
						if (getSizeValue(objA.size) <= 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case MEDIUMTEXT: {
						if (getSizeValue(objA.size) <= 16777215) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case LONGTEXT: {
						return migrationOptions;
					}
				}

			}
			case TINYTEXT: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;

					}
					case TEXT: {
						return migrationOptions;
					}
					case MEDIUMTEXT: {
						return migrationOptions;
					}
					case LONGTEXT: {
						return migrationOptions;
					}
				}

			}
			case MEDIUMTEXT: {

				switch objB.type {
					case VARCHAR: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case CHAR: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case TEXT: {
						// Die Daten k�nnten zu lang sein. Eventuell gegen die Size �berpr�fen. TODO
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case TINYTEXT: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case LONGTEXT: {
						return migrationOptions;
					}
				}

			}
			case LONGTEXT: {

				return migrationOptions;
			}
		}

		return migrationOptions;
	}

	def static List<ColumnOptions> checkTextToDate(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case VARCHAR: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case CHAR: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case TINYTEXT: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case TEXT: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case MEDIUMTEXT: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case LONGTEXT: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
		}

		return migrationOptions;
	}

	def static List<ColumnOptions> checkTextToNumeric(Column objA, Column objB) {

		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		switch objA.type {
			case VARCHAR: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case CHAR: {
				migrationOptions.addAll(ColumnOptions.values)
			}
			case TINYTEXT: {
				migrationOptions.addAll(ColumnOptions.values)
			}
			case TEXT: {
				migrationOptions.addAll(ColumnOptions.values)
			}
			case MEDIUMTEXT: {
				migrationOptions.addAll(ColumnOptions.values)
			}
			case LONGTEXT: {
				migrationOptions.addAll(ColumnOptions.values)
			}
		}

		return migrationOptions;
	}

	def static List<ColumnOptions> checkTextToDecimal(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case VARCHAR: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case CHAR: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case TINYTEXT: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case TEXT: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case MEDIUMTEXT: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
			case LONGTEXT: {
				migrationOptions.addAll(ColumnOptions.values)
				return migrationOptions;
			}
		}

		return migrationOptions;
	}

	def static List<ColumnOptions> checkTextToBinary(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case VARCHAR: {
				switch objB.type {
					case BLOB: {
						return migrationOptions;
					}
					case TINYBLOB: {
						if (getSizeValue(objA.size) <= 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;

					}
					case MEDIUMBLOB: {
						return migrationOptions;

					}
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY: {

						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;

					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
				}
			}
			case CHAR: {

				switch objB.type {
					case BLOB: {
						return migrationOptions;
					}
					case TINYBLOB: {
						return migrationOptions;
					}
					case MEDIUMBLOB: {
						return migrationOptions;
					}
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case BIT: {
						return migrationOptions;
					}
				}

			}
			case TINYTEXT: {

				switch objB.type {
					case BLOB: {
						return migrationOptions;
					}
					case TINYBLOB: {
						return migrationOptions;
					}
					case MEDIUMBLOB: {
						return migrationOptions;
					}
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY: {
						if (getSizeValue(objB.size) == 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
				}

			}
			case TEXT: {

				switch objB.type {
					case BLOB: {
						return migrationOptions;
					}
					case TINYBLOB: {
						if (getSizeValue(objA.size) <= 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case MEDIUMBLOB: {
						if (getSizeValue(objA.size) <= 16777215) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
				}

			}
			case MEDIUMTEXT: {

				switch objB.type {
					case BLOB: {
						return migrationOptions;
					}
					case TINYBLOB: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case MEDIUMBLOB: {
						return migrationOptions;
					}
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
				}

			}
			case LONGTEXT: {

				switch objB.type {
					case BLOB: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case TINYBLOB: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case MEDIUMBLOB: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
				}

			}
		}

		return migrationOptions;
	}

	// Check date type compatibility
	def static List<ColumnOptions> checkDateToText(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case DATE: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= 10) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr��e �berf�hrt
						return migrationOptions;
					}
					case TINYTEXT: {
						return migrationOptions;
					}
					case MEDIUMTEXT: {
						return migrationOptions;
					}
					case LONGTEXT: {
						return migrationOptions;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= 10) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
				}

			}
			case TIME: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= (10 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr��e �berf�hrt
						return migrationOptions;
					}
					case TINYTEXT: {
						return migrationOptions;
					}
					case MEDIUMTEXT: {
						return migrationOptions;
					}
					case LONGTEXT: {
						return migrationOptions;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= (10 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
				}

			}
			case TIMESTAMP: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= (19 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values)
						return migrationOptions;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr��e �berf�hrt
						return migrationOptions;
					}
					case TINYTEXT: {
						return migrationOptions;
					}
					case MEDIUMTEXT: {
						return migrationOptions;
					}
					case LONGTEXT: {
						return migrationOptions;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= (19 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
			case DATETIME: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= (19 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr��e �berf�hrt
						return migrationOptions;
					}
					case TINYTEXT: {
						return migrationOptions;
					}
					case MEDIUMTEXT: {
						return migrationOptions;
					}
					case LONGTEXT: {
						return migrationOptions;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= (19 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
			case YEAR: {

				switch objB.type {
					case VARCHAR: {
						if (getSizeValue(objB.size) >= 4) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TEXT: {
						// TEXT wird in den Datentyp mit der entsprechenden Gr��e �berf�hrt
						return migrationOptions;
					}
					case TINYTEXT: {
						return migrationOptions;
					}
					case MEDIUMTEXT: {
						return migrationOptions;
					}
					case LONGTEXT: {
						return migrationOptions;
					}
					case CHAR: {
						if (getSizeValue(objB.size) >= 4) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
		}

		return migrationOptions;
	}

	def static List<ColumnOptions> checkDateToDate(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case DATE: {

				switch objA.type {
					case TIME: {
						// Uhrzeit wird zu 0 Uhr
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TIMESTAMP: {
						// Uhrzeit wird zu 0 Uhr
						return migrationOptions;
					}
					case DATETIME: {
						// Uhrzeit wird zu 0 Uhr
						return migrationOptions;
					}
					case YEAR: {
						// Geht nicht automatisch
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
			case TIME: {

				switch objA.type {
					case DATE: {
						// Wird auf das aktuelle Datum gesetzt.
						return migrationOptions;
					}
					case TIMESTAMP: {
						// Wird auf das aktuelle Datum gesetzt.
						return migrationOptions;
					}
					case DATETIME: {
						// Wird auf das aktuelle Datum gesetzt.
						return migrationOptions;
					}
					case YEAR: {
						// YEAR wird zu 0
						return migrationOptions;
					}
				}

			}
			case TIMESTAMP: {

				switch objA.type {
					case DATE: {
						return migrationOptions;
					}
					case TIME: {
						return migrationOptions;
					}
					case DATETIME: {
						return migrationOptions;
					}
					case YEAR: {
						// YEAR wird zu 0
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
			case DATETIME: {

				switch objA.type {
					case DATE: {
						return migrationOptions;
					}
					case TIME: {
						return migrationOptions;
					}
					case TIMESTAMP: {
						return migrationOptions;
					}
					case YEAR: {
						// YEAR wird zu 0
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case YEAR: {

				switch objA.type {
					case DATE: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TIME: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TIMESTAMP: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case DATETIME: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
		}

		return migrationOptions;
	}

	def static List<ColumnOptions> checkDateToNumeric(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case DATE: {

				switch objB.type {
					case BIGINT: {
						return migrationOptions;
					}
					case INT,
					case INTEGER: {
						return migrationOptions;
					}
					case MEDIUMINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TINYINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case SMALLINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
			case TIME: {
				switch objB.type {
					case BIGINT: {
						return migrationOptions;
					}
					case INT,
					case INTEGER: {
						return migrationOptions;
					}
					case MEDIUMINT: {
						return migrationOptions;
					}
					case TINYINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case SMALLINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case TIMESTAMP: {
				switch objB.type {
					case BIGINT: {
						return migrationOptions;
					}
					case INT,
					case INTEGER,
					case TINYINT,
					case SMALLINT,
					case MEDIUMINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case DATETIME: {
				switch objB.type {
					case BIGINT: {
						return migrationOptions;
					}
					case INT,
					case INTEGER,
					case TINYINT,
					case SMALLINT,
					case MEDIUMINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
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
						return migrationOptions;
					}
					case TINYINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
		}

		return migrationOptions;
	}

	def static List<ColumnOptions> checkDateToDecimal(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case DATE: {
				switch objB.type {
					case DEC,
					case DECIMAL: {
						if (getDecimalSizeValue(objB.size) >= 8) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case FLOAT: {
						return migrationOptions;
					}
					case DOUBLE: {
						return migrationOptions;
					}
				}
			}
			case TIME: {
				switch objB.type {
					case DEC,
					case DECIMAL: {
						return migrationOptions;
					}
					case FLOAT: {
						return migrationOptions;

					}
					case DOUBLE: {
						return migrationOptions;
					}
				}

			}
			case TIMESTAMP: {
				switch objB.type {
					case DEC,
					case DECIMAL: {
						if (getDecimalSizeValue(objB.size) >= (14 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case FLOAT: {
						return migrationOptions;
					}
					case DOUBLE: {
						return migrationOptions;
					}
				}
			}
			case DATETIME: {
				switch objB.type {
					case DEC,
					case DECIMAL: {
						if (getDecimalSizeValue(objB.size) >= (14 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case FLOAT: {
						return migrationOptions;
					}
					case DOUBLE: {
						return migrationOptions;
					}
				}
			}
			case YEAR: {
				switch objB.type {
					case DEC,
					case DECIMAL: {
						return migrationOptions;
					}
					case FLOAT: {
						return migrationOptions;
					}
					case DOUBLE: {
						return migrationOptions;
					}
				}
			}
		}

		return migrationOptions;
	}

	def static List<ColumnOptions> checkDateToBinary(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case DATE: {
				switch objB.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case TINYBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) > (10 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case TIME: {
				switch objB.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case TINYBLOB: {
						return migrationOptions;

					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) > (8 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case TIMESTAMP: {
				switch objB.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case TINYBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) > (20 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case DATETIME: {
				switch objB.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case TINYBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) > (20 + getSizeValue(objA.size))) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case YEAR: {
				switch objB.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB,
					case TINYBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) >= 4) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
		}

		return migrationOptions;
	}

	// Check Numeric type compatibility
	def static List<ColumnOptions> checkNumericToText(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objB.type {
			case TINYTEXT,
			case TEXT,
			case MEDIUMTEXT,
			case LONGTEXT: {
				return migrationOptions;
			}
		}

		switch objA.type {
			case BIGINT: {
				if (getSizeValue(objB.size) >= 20) {
					return migrationOptions;
				} else
					migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case INT,
			case INTEGER: {
				if (getSizeValue(objB.size) >= 10) {
					return migrationOptions;
				} else
					migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case MEDIUMINT: {
				if (getSizeValue(objB.size) >= 8) {
					return migrationOptions;
				} else
					migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case TINYINT: {
				if (getSizeValue(objB.size) >= 3) {
					return migrationOptions;
				} else
					migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case SMALLINT: {
				if (getSizeValue(objB.size) >= 5) {
					return migrationOptions;
				} else
					migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
		}
		return migrationOptions;
	}

	def static List<ColumnOptions> checkNumericToDate(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		// Column is set to 0 if the value cant be transformed TODO Check 
		switch objA.type {
			case BIGINT: {
				switch objB.type {
					case DATE: {
						return migrationOptions;
					}
					case TIME: {
						return migrationOptions;
					}
					case TIMESTAMP: {
						return migrationOptions;
					}
					case DATETIME: {
						return migrationOptions;
					}
					case YEAR: {
						return migrationOptions;
					}
				}
			}
			case INT,
			case INTEGER: {
				switch objB.type {
					case DATE: {
						return migrationOptions;
					}
					case TIME: {
						return migrationOptions;
					}
					case TIMESTAMP: {
						return migrationOptions;
					}
					case DATETIME: {
						return migrationOptions;
					}
					case YEAR: {
						return migrationOptions;
					}
				}
			}
			case MEDIUMINT: {
				switch objB.type {
					case DATE: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TIME: {
					}
					case TIMESTAMP: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case DATETIME: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case YEAR: {
					}
				}
			}
			case TINYINT: {
				switch objB.type {
					case DATE: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TIME: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TIMESTAMP: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case DATETIME: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case YEAR: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case SMALLINT: {
				switch objB.type {
					case DATE: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TIME: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TIMESTAMP: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case DATETIME: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case YEAR: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
		}
		return migrationOptions;
	}

	def static List<ColumnOptions> checkNumericToNumeric(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		switch objA.type {
			case BIGINT: {
				switch objA.type {
					case INT,
					case INTEGER,
					case MEDIUMINT,
					case TINYINT,
					case SMALLINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case INT,
			case INTEGER: {
				switch objA.type {
					case BIGINT: {
						return migrationOptions;
					}
					case MEDIUMINT,
					case SMALLINT,
					case TINYINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case MEDIUMINT: {
				switch objA.type {
					case BIGINT,
					case INT,
					case INTEGER: {
						return migrationOptions;
					}
					case TINYINT,
					case SMALLINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
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
						return migrationOptions;
					}
				}
			}
			case SMALLINT: {
				switch objA.type {
					case BIGINT,
					case INT,
					case INTEGER,
					case MEDIUMINT: {
						return migrationOptions;
					}
					case TINYINT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
		}
		return migrationOptions;
	}

	def static List<ColumnOptions> checkNumericToDecimal(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objB.type {
			case FLOAT,
			case DOUBLE: {
				return migrationOptions;
			}
		}

		switch objA.type {
			case BIGINT: {
				if (getDecimalSizeValue(objA.size) >= 20) {
					return migrationOptions;
				} else
					migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case INT,
			case INTEGER: {
				if (getDecimalSizeValue(objA.size) >= 10) {
					return migrationOptions;
				} else
					migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case MEDIUMINT: {
				if (getDecimalSizeValue(objA.size) >= 8) {
					return migrationOptions;
				} else
					migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case TINYINT: {
				if (getDecimalSizeValue(objA.size) >= 3) {
					return migrationOptions;
				} else
					migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case SMALLINT: {
				if (getDecimalSizeValue(objA.size) >= 5) {
					return migrationOptions;
				} else
					migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
		}
		return migrationOptions;
	}

	def static List<ColumnOptions> checkNumericToBinary(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		switch objA.type {
			case BIGINT: {
				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						// Check Size 
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
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
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						// Check number of digits.
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
			case MEDIUMINT: {
				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						// Check number of digits.
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case TINYINT: {
				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						// Check number of digits.
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case SMALLINT: {
				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						// Check number of digits.
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
		}

		return migrationOptions;
	}

	// Check decimal type compatibility
	def static List<ColumnOptions> checkDecimalToText(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		switch objA.type {
			case DEC,
			case DECIMAL: {
				switch objB.type {
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return migrationOptions;
					}
					case CHAR,
					case VARCHAR: {
						if (getDecimalSizeValue(objA.size) >= getSizeValue(objB.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
			case FLOAT: {
				switch objB.type {
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return migrationOptions;
					}
					case CHAR,
					case VARCHAR: {
						// Check number of digits.
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
			case DOUBLE: {
				switch objB.type {
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return migrationOptions;
					}
					case CHAR,
					case VARCHAR: {
						// Check number of digits.
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
		}
		return migrationOptions;
	}

	def static List<ColumnOptions> checkDecimalToDate(Column objA, Column objB) {
		// Possible but data that can not be transformed is set to null
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		migrationOptions.addAll(ColumnOptions.IGNORE, ColumnOptions.DELETE_ROW)

		if (!objB.notNull)
			migrationOptions.addAll(ColumnOptions.UPDATE_COLUMN_SET_TO_NULL)
		
		if(migrationOptions.size != 0)
			migrationOptions.add(ColumnOptions.SPECIFY_CONDITION_MANUALLY)
		return migrationOptions;
	}


	def static List<ColumnOptions> checkDecimalToNumeric(Column objA, Column objB) {

		// Possible but data that can not be transformed is set to the max value
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		migrationOptions.addAll(ColumnOptions.IGNORE, ColumnOptions.DELETE_ROW)

		if (objB.defaultValue !== null && !objB.unique)
			migrationOptions.addAll(
				ColumnOptions.UPDATE_COLUMN_SET_TO_DEFAULT,
				ColumnOptions.UPDATE_ROW_SET_TO_DEFAULT
			)
		if (!objB.notNull)
			migrationOptions.addAll(
				ColumnOptions.UPDATE_COLUMN_SET_TO_NULL,
				ColumnOptions.UPDATE_ROW_SET_TO_NULL
			)

		if(migrationOptions.size != 0)
			migrationOptions.add(ColumnOptions.SPECIFY_CONDITION_MANUALLY)
		return migrationOptions;

	}

	def static List<ColumnOptions> checkDecimalToDecimal(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case DEC,
			case DECIMAL: {

				switch objB.type {
					case FLOAT: {
						if (getDecimalSizeValue(objA.size) <= 39) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;

					}
					case DOUBLE: {
						return migrationOptions;
					}
				}

			}
			case FLOAT: {

				switch objB.type {
					case DEC,
					case DECIMAL: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case DOUBLE: {
						return migrationOptions;
					}
				}
			}
			case DOUBLE: {

				switch objB.type {
					case DEC,
					case DECIMAL: {
						// Geht zwar wenn der Decimal die richtige Gr��e hat aber geht einher mit Datenverlust
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case FLOAT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
		}

		return migrationOptions;

	}

	def static List<ColumnOptions> checkDecimalToBinary(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		switch objA.type {
			case DEC,
			case DECIMAL: {

				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {

						if (getSizeValue(objB.size) >= getDecimalSizeValue(objA.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;

					}
					case BIT: {

						if (getSizeValue(objB.size) >= getDecimalSizeValue(objA.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
			case FLOAT: {

				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) >= 65) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
			case DOUBLE: {

				switch objB.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY,
					case VARBINARY: {
						if (getSizeValue(objB.size) >= 65) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}

			}
		}

		return migrationOptions;
	}

	// Check binary type compatibility
	def static List<ColumnOptions> checkBinaryToText(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		switch objA.type {
			case BLOB: {

				switch objB.type {
					case CHAR: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case VARCHAR: {
						return migrationOptions;
					}
					case TINYTEXT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return migrationOptions;
					}
				}
			}
			case TINYBLOB: {
				switch objB.type {
					case CHAR: {
						if (getSizeValue(objB.size) == 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case VARCHAR,
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return migrationOptions;
					}
				}
			}
			case MEDIUMBLOB: {
				switch objB.type {
					case CHAR,
					case VARCHAR,
					case TINYTEXT,
					case TEXT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case MEDIUMTEXT,
					case LONGTEXT: {
						return migrationOptions;
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
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case LONGTEXT: {
						return migrationOptions;
					}
				}
			}
			case BINARY: {
				switch objB.type {
					case CHAR: {
						if (getSizeValue(objB.size) == 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case VARCHAR: {
						if (getSizeValue(objB.size) >= 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TINYTEXT,
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return migrationOptions;
					}
				}
			}
			case VARBINARY: {
				switch objB.type {
					case CHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case VARCHAR: {
						if (getSizeValue(objA.size) <= getSizeValue(objB.size)) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TINYTEXT: {
						if (getSizeValue(objA.size) <= 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TEXT,
					case MEDIUMTEXT,
					case LONGTEXT: {
						return migrationOptions;
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
						return migrationOptions;
					}
				}
			}
		}
		return migrationOptions;
	}

	def static List<ColumnOptions> checkBinaryToDate(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		// Format �berpr�fen und Gr��e
		switch objA.type {
			case BLOB: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case TINYBLOB: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case MEDIUMBLOB: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case LONGBLOB: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case BINARY: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case VARBINARY: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case BIT: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
		}
		return migrationOptions;
	}

	def static List<ColumnOptions> checkBinaryToNumeric(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		// Format �berpr�fen und Gr��e
		switch objA.type {
			case BLOB: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case TINYBLOB: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case MEDIUMBLOB: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case LONGBLOB: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case BINARY: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case VARBINARY: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
			case BIT: {
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
		}

		return migrationOptions;
	}

	def static List<ColumnOptions> checkBinaryToDecimal(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		switch objA.type {
			case BLOB,
			case TINYBLOB,
			case MEDIUMBLOB,
			case LONGBLOB,
			case BINARY,
			case VARBINARY,
			case BIT: {
				// Format �berpr�fen
				migrationOptions.addAll(ColumnOptions.values);
				return migrationOptions;
			}
		}
		return migrationOptions;
	}

	def static List<ColumnOptions> checkBinaryToBinary(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
		switch objA.type {
			case BLOB: {
				switch objA.type {
					case TINYBLOB: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case VARBINARY: {
						if (getSizeValue(objB.size) == 65535) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;

					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case TINYBLOB: {
				switch objA.type {
					case BLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY: {
						if (getSizeValue(objB.size) == 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case VARBINARY: {
						return migrationOptions;
					}
					case BIT: {
						if (getSizeValue(objA.size) <= 1) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case MEDIUMBLOB: {
				switch objA.type {
					case BLOB: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case TINYBLOB: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case VARBINARY: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case BIT: {
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
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
						migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case BINARY: {
				switch objA.type {
					case BLOB,
					case TINYBLOB,
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case VARBINARY: {
						return migrationOptions;
					}
					case BIT: {
						if (getSizeValue(objA.size) <= 1) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
				}
			}
			case VARBINARY: {
				switch objA.type {
					case BLOB: {
						return migrationOptions;
					}
					case TINYBLOB: {
						if (getSizeValue(objA.size) <= 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case MEDIUMBLOB,
					case LONGBLOB: {
						return migrationOptions;
					}
					case BINARY: {
						if (getSizeValue(objA.size) <= 255) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
					}
					case BIT: {
						if (getSizeValue(objA.size) <= 1) {
							return migrationOptions;
						} else
							migrationOptions.addAll(ColumnOptions.values);
						return migrationOptions;
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
						return migrationOptions;
					}
				}
			}
		}
		return migrationOptions;
	}

	/**
	 * Check whether the new column size is compatible. If the size is compatible, the method returns an empty list.
	 */
	def static List<ColumnOptions> checkColumnSizeCompatibility(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		if (typesWithoutSize.contains(objB.type))
			return migrationOptions;

		var sizeA = 0;
		var sizeB = 0;

		if (decimalTypes.contains(objA.type)) {
			sizeA = getDecimalSizeValue(objA.size)
			sizeB = getDecimalSizeValue(objB.size)
		} else {
			sizeA = getSizeValue(objA.size)
			sizeB = getSizeValue(objB.size)
		}

		// The new size is bigger than the old size.
		if (sizeB > sizeA)
			return migrationOptions;

		switch objA.type {
			case VARCHAR,
			case CHAR,
			case BINARY,
			case VARBINARY,
			case BLOB,
			case TEXT,
			case BIT: {

				migrationOptions.addAll(
					ColumnOptions.IGNORE
				)
				if (objB.defaultValue !== null && !objB.unique)
					migrationOptions.addAll(
						ColumnOptions.UPDATE_COLUMN_SET_TO_DEFAULT,
						ColumnOptions.UPDATE_ROW_SET_TO_DEFAULT
					)
				if (!objB.notNull)
					migrationOptions.addAll(
						ColumnOptions.DELETE_ROW,
						ColumnOptions.UPDATE_COLUMN_SET_TO_NULL,
						ColumnOptions.UPDATE_ROW_SET_TO_NULL
					)

			}
			case DATETIME,
			case TIME,
			case TIMESTAMP: {
				// Should migrate automatically
			}
			case DEC,
			case DECIMAL: {
				migrationOptions.addAll(
					ColumnOptions.IGNORE
				)
				if (objB.defaultValue !== null && !objB.unique)
					migrationOptions.addAll(
						ColumnOptions.UPDATE_COLUMN_SET_TO_DEFAULT,
						ColumnOptions.UPDATE_ROW_SET_TO_DEFAULT
					)
				if (!objB.notNull)
					migrationOptions.addAll(
						ColumnOptions.DELETE_ROW,
						ColumnOptions.UPDATE_COLUMN_SET_TO_NULL,
						ColumnOptions.UPDATE_ROW_SET_TO_NULL
					)
			}
		}

		if(migrationOptions.size != 0)
			migrationOptions.add(ColumnOptions.SPECIFY_CONDITION_MANUALLY)
		return migrationOptions

	}

	/**
	 * Check whether the column has only unique values. If the size is compatible, the method returns an empty list.
	 */
	def static List<ColumnOptions> checkColumnUniqueCompatibility(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		if (!objB.unique) {
			return migrationOptions;
		} else {

			migrationOptions.addAll(
				ColumnOptions.IGNORE
			)
			if (!objB.notNull)
				migrationOptions.addAll(
					ColumnOptions.DELETE_ROW,
					ColumnOptions.UPDATE_COLUMN_SET_TO_NULL,
					ColumnOptions.UPDATE_ROW_SET_TO_NULL
				)
				
			migrationOptions.add(ColumnOptions.SPECIFY_CONDITION_MANUALLY)

		}

		return migrationOptions
	}

	/**
	 * Check whether the column has only unique values. If the size is compatible, the method returns an empty list.
	 */
	def static List<ColumnOptions> checkColumnNotNullCompatibility(Column objA, Column objB) {
		var List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();

		if (!objB.notNull) {
			return migrationOptions;
		} else {

			migrationOptions.addAll(
				ColumnOptions.IGNORE,
				ColumnOptions.DELETE_ROW
			)

			if (objB.defaultValue !== null) {
				migrationOptions.addAll(
					ColumnOptions.UPDATE_COLUMN_SET_TO_DEFAULT,
					ColumnOptions.UPDATE_ROW_SET_TO_DEFAULT
				)
			}
			migrationOptions.add(ColumnOptions.SPECIFY_CONDITION_MANUALLY)

		}

		return migrationOptions
	}

}
