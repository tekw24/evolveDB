package de.thm.de.util;

import java.util.Arrays;
import java.util.List;

import de.thm.evolvedb.mdde.DataType;

public class DataTypeUtil {
	
	public static List<DataType> textTypes = Arrays.asList(DataType.CHAR, DataType.VARCHAR, DataType.TINYTEXT);
	public static List<DataType> binaryTypes = Arrays.asList(DataType.BINARY, DataType.VARBINARY, DataType.BLOB,
			DataType.BIT);
	public static List<DataType> dateTypesWithFraction = Arrays.asList(DataType.DATETIME, DataType.TIMESTAMP,
			DataType.TIME);

	public static List<DataType> decimalTypes = Arrays.asList(DataType.DEC, DataType.DECIMAL, DataType.FLOAT);

	public static List<DataType> typesWithoutSize = Arrays.asList(DataType.TINYBLOB, DataType.TINYTEXT,
			DataType.MEDIUMBLOB, DataType.MEDIUMTEXT, DataType.LONGBLOB, DataType.LONGTEXT, DataType.BINARY,
			DataType.VARBINARY, DataType.BOOL, DataType.BOOLEAN, DataType.DATE, DataType.YEAR);
	
	public static DataType findDataTypeByLiteral(String literal) {
		DataType type = DataType.valueOf(literal);
		if(type != null)
			return type;
		else
			return null; //TODO Exception handling
	}
	
	

}
