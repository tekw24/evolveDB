/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
			DataType.MEDIUMBLOB, DataType.MEDIUMTEXT, DataType.LONGBLOB, DataType.LONGTEXT, 
			DataType.BOOL, DataType.BOOLEAN, DataType.DATE, DataType.YEAR, DataType.BIGINT_UNSIGNED,
			DataType.INT_UNSIGNED, DataType.INT_UNSIGNED, DataType.MEDIUMINT_UNSIGNED, DataType.SMALLINT_UNSIGNED,
			DataType.TINYINT_UNSIGNED);

	public static DataType findDataTypeByLiteral(String literal) {
		DataType type = DataType.get(literal);
		if (type != null)
			return type;
		else {
			type = DataType.valueOf(literal);
			if (type != null) {
				return type;
			} else
				return null; // TODO Exception handling
		}
	}

}
