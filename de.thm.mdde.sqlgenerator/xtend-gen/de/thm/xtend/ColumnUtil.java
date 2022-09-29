package de.thm.xtend;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.DataType;
import de.thm.evolvedb.mdde.Database_Schema;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class ColumnUtil {
  public static List<DataType> textTypes = Arrays.<DataType>asList(DataType.CHAR, DataType.VARCHAR, DataType.TEXT, 
    DataType.MEDIUMTEXT, DataType.LONGTEXT, DataType.TINYTEXT);

  public static List<DataType> dateTypesWithFraction = Arrays.<DataType>asList(DataType.DATETIME, DataType.TIMESTAMP, 
    DataType.TIME);

  public static List<DataType> dateTypes = Arrays.<DataType>asList(DataType.DATE, DataType.YEAR);

  public static List<DataType> decimalTypes = Arrays.<DataType>asList(DataType.DEC, DataType.DECIMAL, DataType.FLOAT, 
    DataType.DOUBLE);

  public static List<DataType> displayWitdhTypes = Arrays.<DataType>asList(DataType.BIGINT, DataType.INT, DataType.INTEGER, 
    DataType.SMALLINT, DataType.MEDIUMINT, DataType.TINYINT);

  public static List<DataType> binaryTypes = Arrays.<DataType>asList(DataType.BINARY, DataType.VARBINARY, DataType.BLOB, 
    DataType.TINYBLOB, DataType.BIT, DataType.MEDIUMBLOB, DataType.LONGBLOB);

  public static List<DataType> typesWithoutSize = Arrays.<DataType>asList(DataType.TINYBLOB, DataType.TINYTEXT, 
    DataType.MEDIUMBLOB, DataType.MEDIUMTEXT, DataType.LONGBLOB, DataType.LONGTEXT, DataType.BOOL, DataType.BOOLEAN, 
    DataType.DATE, DataType.YEAR, DataType.TINYTEXT, DataType.BIGINT, DataType.SMALLINT, DataType.MEDIUMINT);

  public static Map<DataType, Long> dataTypeMaxSize = Collections.<DataType, Long>unmodifiableMap(CollectionLiterals.<DataType, Long>newHashMap(Pair.<DataType, Long>of(DataType.CHAR, Long.valueOf(255l)), Pair.<DataType, Long>of(DataType.VARCHAR, Long.valueOf(65535l)), Pair.<DataType, Long>of(DataType.TEXT, Long.valueOf(65535l)), Pair.<DataType, Long>of(DataType.MEDIUMTEXT, Long.valueOf(16777215l)), Pair.<DataType, Long>of(DataType.LONGTEXT, Long.valueOf(4294967295l)), Pair.<DataType, Long>of(DataType.TINYTEXT, Long.valueOf(255l)), Pair.<DataType, Long>of(DataType.DATETIME, Long.valueOf(2l)), Pair.<DataType, Long>of(DataType.TIMESTAMP, Long.valueOf(2l)), Pair.<DataType, Long>of(DataType.YEAR, Long.valueOf(4l)), Pair.<DataType, Long>of(DataType.DEC, Long.valueOf(65l)), Pair.<DataType, Long>of(DataType.DECIMAL, Long.valueOf(65l)), Pair.<DataType, Long>of(DataType.FLOAT, Long.valueOf(2l)), Pair.<DataType, Long>of(DataType.DOUBLE, Long.valueOf(2l)), Pair.<DataType, Long>of(DataType.BIGINT, Long.valueOf(1844674407370955161l)), Pair.<DataType, Long>of(DataType.INT, Long.valueOf(4294967295l)), Pair.<DataType, Long>of(DataType.INTEGER, Long.valueOf(4294967295l)), Pair.<DataType, Long>of(DataType.SMALLINT, Long.valueOf(65535l)), Pair.<DataType, Long>of(DataType.MEDIUMINT, Long.valueOf(816777215l)), Pair.<DataType, Long>of(DataType.BINARY, Long.valueOf(255l)), Pair.<DataType, Long>of(DataType.VARBINARY, Long.valueOf(65535l)), Pair.<DataType, Long>of(DataType.TINYBLOB, Long.valueOf(255l)), Pair.<DataType, Long>of(DataType.BLOB, Long.valueOf(65535l)), Pair.<DataType, Long>of(DataType.BIT, Long.valueOf(64l)), Pair.<DataType, Long>of(DataType.MEDIUMBLOB, Long.valueOf(16777215l)), Pair.<DataType, Long>of(DataType.LONGBLOB, Long.valueOf(4294967295l)), Pair.<DataType, Long>of(DataType.BOOL, Long.valueOf(1l)), Pair.<DataType, Long>of(DataType.BOOLEAN, Long.valueOf(1l)), Pair.<DataType, Long>of(DataType.TINYINT, Long.valueOf(255l)), Pair.<DataType, Long>of(DataType.DATE, Long.valueOf(10l))));

  public static String getSizeString(final Column column) {
    DataType type = column.getType();
    if (((column.getSize() == null) || ColumnUtil.typesWithoutSize.contains(type))) {
      return "";
    }
    boolean _matches = column.getSize().matches("[0-9]+");
    if (_matches) {
      Integer size = Integer.valueOf(column.getSize());
      if ((((ColumnUtil.displayWitdhTypes.contains(type) || ColumnUtil.textTypes.contains(type)) || ColumnUtil.dateTypesWithFraction.contains(type)) || 
        ColumnUtil.decimalTypes.contains(type))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(�size�)");
        return _builder.toString();
      }
    } else {
      if ((column.getSize().matches("[0-9]+\\.[0-9]+") && ColumnUtil.decimalTypes.contains(type))) {
        String size_1 = column.getSize().replace(".", ",");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("(�size�)");
        return _builder_1.toString();
      }
    }
    return "";
  }

  public static int getSizeValue(final String size) {
    int sizeA = 0;
    if (((size != null) && size.matches("[0-9]+"))) {
      sizeA = (Integer.valueOf(size)).intValue();
    }
    return sizeA;
  }

  public static int getDecimalSizeValue(final String size) {
    int sizeA = 0;
    boolean _matches = size.matches("[0-9]+\\.[0-9]+");
    if (_matches) {
      String[] split = size.split("\\.");
      int _length = split.length;
      boolean _equals = (_length == 2);
      if (_equals) {
        sizeA = (Integer.valueOf(split[0])).intValue();
        Integer sizeB = Integer.valueOf(split[1]);
        int _sizeA = sizeA;
        sizeA = (_sizeA - (sizeB).intValue());
      }
    } else {
      boolean _matches_1 = size.matches("[0-9]+");
      if (_matches_1) {
        sizeA = (Integer.valueOf(size)).intValue();
      }
    }
    return sizeA;
  }

  public static String getDefaultValueString(final Column column) {
    if (((column.getDefaultValue() == null) || column.getDefaultValue().equals(""))) {
      return "";
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("�IF SQLGenerator.textTypes.contains(column.type)�DEFAULT \'�column.defaultValue�\'�ELSE�DEFAULT �column.defaultValue��ENDIF�");
      String content = _builder.toString();
      return content;
    }
  }

  public static String getDefaultValueStringWithoutDEFAULT(final Column column) {
    if (((column.getDefaultValue() == null) || column.getDefaultValue().equals(""))) {
      return "";
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("�IF SQLGenerator.textTypes.contains(column.type)�\'�column.defaultValue�\'�ELSE��column.defaultValue��ENDIF�");
      String content = _builder.toString();
      return content;
    }
  }

  public static String getRegexStringForWhereClause(final Column objA, final Column objB, final PrimaryKey key) {
    String _xifexpression = null;
    boolean _contains = ColumnUtil.textTypes.contains(objA.getType());
    if (_contains) {
      boolean _contains_1 = ColumnUtil.decimalTypes.contains(objB.getType());
      if (_contains_1) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("not REGEXP ^-?[0-9]+\\.[0-9]+$;");
        return _builder.toString();
      } else {
        boolean _contains_2 = ColumnUtil.displayWitdhTypes.contains(objB.getType());
        if (_contains_2) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("not REGEXP \'^-?[0-9]+$\';");
          return _builder_1.toString();
        } else {
          if ((ColumnUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnUtil.dateTypes.contains(objB.getType()))) {
            String substring = objB.getTable().getName().substring(0, 1);
            String dateString = "";
            DataType _type = objB.getType();
            boolean _tripleEquals = (_type == DataType.DATE);
            if (_tripleEquals) {
              dateString = "DATE";
            }
            DataType _type_1 = objB.getType();
            boolean _tripleEquals_1 = (_type_1 == DataType.DATETIME);
            if (_tripleEquals_1) {
              dateString = "DATETIME";
            }
            DataType _type_2 = objB.getType();
            boolean _tripleEquals_2 = (_type_2 == DataType.TIME);
            if (_tripleEquals_2) {
              dateString = "TIME";
            }
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("�key.name� in (SELECT �key.name� FROM �objB.table.name� �substring�1 where STR_TO_DATE(�substring�1.�objB.name�, GET_FORMAT(�dateString�,\'ISO\')) is null) and �objB.name� is not null ; ");
            return _builder_2.toString();
          } else {
            if ((ColumnUtil.textTypes.contains(objB.getType()) || ColumnUtil.binaryTypes.contains(objB.getType()))) {
              if (((((objB.getType() == DataType.VARCHAR) || (objB.getType() == DataType.CHAR)) || (objB.getType() == DataType.VARBINARY)) || 
                (objB.getType() == DataType.BIT))) {
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("LENGTH(`�objB.name�`) > �getSizeValue(objB.size)�;");
                return _builder_3.toString();
              }
              StringConcatenation _builder_4 = new StringConcatenation();
              _builder_4.append("LENGTH(`�objB.name�`) > �dataTypeMaxSize.get(objB.type)�;");
              return _builder_4.toString();
            }
          }
        }
      }
    } else {
      String _xifexpression_1 = null;
      if ((ColumnUtil.dateTypesWithFraction.contains(objA.getType()) || ColumnUtil.dateTypes.contains(objA.getType()))) {
        if ((ColumnUtil.textTypes.contains(objB.getType()) || ColumnUtil.binaryTypes.contains(objB.getType()))) {
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("LENGTH(`�objB.name�`) > �getSizeValue(objB.size)�;");
          return _builder_5.toString();
        } else {
          boolean _contains_3 = ColumnUtil.decimalTypes.contains(objB.getType());
          if (_contains_3) {
            StringConcatenation _builder_6 = new StringConcatenation();
            _builder_6.append("LENGTH(`�objB.name�`) > �dataTypeMaxSize.get(objB.type)�;");
            return _builder_6.toString();
          } else {
            boolean _contains_4 = ColumnUtil.displayWitdhTypes.contains(objB.getType());
            if (_contains_4) {
              StringConcatenation _builder_7 = new StringConcatenation();
              _builder_7.append("LENGTH(`�objB.name�`) > �dataTypeMaxSize.get(objB.type)�;");
              return _builder_7.toString();
            } else {
              if ((ColumnUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnUtil.dateTypes.contains(objB.getType()))) {
                if (((objA.getType() == DataType.YEAR) || (objB.getType() == DataType.YEAR))) {
                  StringConcatenation _builder_8 = new StringConcatenation();
                  _builder_8.append("�objB.name� != null");
                  return _builder_8.toString();
                }
              }
            }
          }
        }
      } else {
        String _xifexpression_2 = null;
        boolean _contains_5 = ColumnUtil.decimalTypes.contains(objA.getType());
        if (_contains_5) {
          String _xifexpression_3 = null;
          if ((ColumnUtil.textTypes.contains(objB.getType()) || ColumnUtil.binaryTypes.contains(objB.getType()))) {
            StringConcatenation _builder_9 = new StringConcatenation();
            _builder_9.append("LENGTH(`�objB.name�`) > �dataTypeMaxSize.get(objB.type)�;");
            return _builder_9.toString();
          } else {
            String _xifexpression_4 = null;
            boolean _contains_6 = ColumnUtil.decimalTypes.contains(objB.getType());
            if (_contains_6) {
              StringConcatenation _builder_10 = new StringConcatenation();
              _builder_10.append("LENGTH(`�objB.name�`) > �dataTypeMaxSize.get(objB.type)�;");
              return _builder_10.toString();
            } else {
              String _xifexpression_5 = null;
              boolean _contains_7 = ColumnUtil.displayWitdhTypes.contains(objB.getType());
              if (_contains_7) {
                StringConcatenation _builder_11 = new StringConcatenation();
                _builder_11.append("�objB.name� > �dataTypeMaxSize.get(objB.type)�;");
                return _builder_11.toString();
              } else {
                String _xifexpression_6 = null;
                if ((ColumnUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnUtil.dateTypes.contains(objB.getType()))) {
                  StringConcatenation _builder_12 = new StringConcatenation();
                  _builder_12.append("�objB.name� is not null;");
                  _xifexpression_6 = _builder_12.toString();
                }
                _xifexpression_5 = _xifexpression_6;
              }
              _xifexpression_4 = _xifexpression_5;
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        } else {
          String _xifexpression_7 = null;
          boolean _contains_8 = ColumnUtil.displayWitdhTypes.contains(objA.getType());
          if (_contains_8) {
            String _xifexpression_8 = null;
            if ((ColumnUtil.textTypes.contains(objB.getType()) || ColumnUtil.binaryTypes.contains(objB.getType()))) {
              StringConcatenation _builder_13 = new StringConcatenation();
              _builder_13.append("LENGTH(`�objB.name�`) > �getSizeValue(objB.size)�;");
              return _builder_13.toString();
            } else {
              String _xifexpression_9 = null;
              boolean _contains_9 = ColumnUtil.decimalTypes.contains(objB.getType());
              if (_contains_9) {
                if (((objB.getType() == DataType.DEC) || (objB.getType() == DataType.DECIMAL))) {
                  StringConcatenation _builder_14 = new StringConcatenation();
                  _builder_14.append("LENGTH(`�objB.name�`) > �getDecimalSizeValue(objB.size)�;");
                  return _builder_14.toString();
                }
              } else {
                String _xifexpression_10 = null;
                boolean _contains_10 = ColumnUtil.displayWitdhTypes.contains(objB.getType());
                if (_contains_10) {
                  StringConcatenation _builder_15 = new StringConcatenation();
                  _builder_15.append("LENGTH(`�objB.name�`) > �dataTypeMaxSize.get(objB.type)�;");
                  return _builder_15.toString();
                } else {
                  String _xifexpression_11 = null;
                  if ((ColumnUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnUtil.dateTypes.contains(objB.getType()))) {
                    StringConcatenation _builder_16 = new StringConcatenation();
                    _builder_16.append("�objB.name� is not null;");
                    _xifexpression_11 = _builder_16.toString();
                  }
                  _xifexpression_10 = _xifexpression_11;
                }
                _xifexpression_9 = _xifexpression_10;
              }
              _xifexpression_8 = _xifexpression_9;
            }
            _xifexpression_7 = _xifexpression_8;
          } else {
            boolean _contains_11 = ColumnUtil.binaryTypes.contains(objA.getType());
            if (_contains_11) {
              if ((ColumnUtil.textTypes.contains(objB.getType()) || ColumnUtil.binaryTypes.contains(objB.getType()))) {
                if (((((objB.getType() == DataType.VARCHAR) || (objB.getType() == DataType.CHAR)) || (objB.getType() == DataType.VARBINARY)) || 
                  (objB.getType() == DataType.BIT))) {
                  StringConcatenation _builder_17 = new StringConcatenation();
                  _builder_17.append("LENGTH(`�objB.name�`) > �getSizeValue(objB.size)�;");
                  return _builder_17.toString();
                }
                StringConcatenation _builder_18 = new StringConcatenation();
                _builder_18.append("LENGTH(`�objB.name�`) > �dataTypeMaxSize.get(objB.type)�;");
                return _builder_18.toString();
              } else {
                boolean _contains_12 = ColumnUtil.decimalTypes.contains(objB.getType());
                if (_contains_12) {
                  if (((objB.getType() == DataType.DEC) || (objB.getType() == DataType.DECIMAL))) {
                    StringConcatenation _builder_19 = new StringConcatenation();
                    _builder_19.append("LENGTH(`�objB.name�`) > �getDecimalSizeValue(objB.size)� and not REGEXP ^-?[0-9]+\\.[0-9]+$;");
                    return _builder_19.toString();
                  }
                  StringConcatenation _builder_20 = new StringConcatenation();
                  _builder_20.append("not REGEXP ^-?[0-9]+\\.[0-9]+$;");
                  return _builder_20.toString();
                } else {
                  boolean _contains_13 = ColumnUtil.displayWitdhTypes.contains(objB.getType());
                  if (_contains_13) {
                    StringConcatenation _builder_21 = new StringConcatenation();
                    _builder_21.append("LENGTH(`�objB.name�`) > �dataTypeMaxSize.get(objB.type)� and not REGEXP \'^-?[0-9]+$\';");
                    return _builder_21.toString();
                  } else {
                    if ((ColumnUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnUtil.dateTypes.contains(objB.getType()))) {
                      String substring_1 = objB.getTable().getName().substring(0, 1);
                      StringConcatenation _builder_22 = new StringConcatenation();
                      _builder_22.append("�objB.name� in (SELECT �key.name� FROM �objB.table.name� �substring�1 where STR_TO_DATE(�substring�1.�objB.name�, GET_FORMAT(DATE,\'ISO\')) is null) and �objB.name� is not null ; ");
                      return _builder_22.toString();
                    }
                  }
                }
              }
            }
          }
          _xifexpression_2 = _xifexpression_7;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  /**
   * Creates a table for Data Cleansing
   */
  public static String createDataCleansingTable(final String tableName, final Database_Schema databaseSchema) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CREATE TABLE IF NOT EXISTS `�databaseSchema.name�`.`�tableName�` (");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("`DB_ID` BIGINT NOT NULL AUTO_INCREMENT,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("`TABLENAME` VARCHAR(255) NOT NULL,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("`COLUMN_DB_ID` BIGINT NOT NULL,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("`COLUMN_NAME` VARCHAR(255) NOT NULL,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("`VALUE` BLOB NULL,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("`CHANGEDATE` DATETIME NOT NULL,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("PRIMARY KEY (`DB_ID`));");
    return _builder.toString();
  }

  /**
   * Creates the statement for inserting column values into the history table
   */
  public static String createInsertColumnHistoryScript(final String tableName, final Database_Schema databaseSchema, final Column obj, final PrimaryKey primaryKey, final String whereClause) {
    String _xblockexpression = null;
    {
      String substring = obj.getTable().getName().substring(0, 1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("INSERT INTO `�databaseSchema.name�`.`�tableName�`");
      _builder.newLine();
      _builder.append("(`TABLENAME`,");
      _builder.newLine();
      _builder.append("`COLUMN_DB_ID`,");
      _builder.newLine();
      _builder.append("`COLUMN_NAME`,");
      _builder.newLine();
      _builder.append("`VALUE`,");
      _builder.newLine();
      _builder.append("`CHANGEDATE`)");
      _builder.newLine();
      _builder.append("SELECT \'�obj.table.name�\', �primaryKey.name�, \'�obj.name�\', �obj.name�, now() from �obj.table.name� �substring� where �whereClause�");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }

  /**
   * Creates the statement for inserting column values into the history table
   */
  public static String createInsertColumnHistoryScriptWithTempTable(final String tableName, final Database_Schema databaseSchema, final Column obj, final PrimaryKey primaryKey, final String temp_table_name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("INSERT INTO `�databaseSchema.name�`.`�tableName�`");
    _builder.newLine();
    _builder.append("(`TABLENAME`,");
    _builder.newLine();
    _builder.append("`COLUMN_DB_ID`,");
    _builder.newLine();
    _builder.append("`COLUMN_NAME`,");
    _builder.newLine();
    _builder.append("`VALUE`,");
    _builder.newLine();
    _builder.append("`CHANGEDATE`)");
    _builder.newLine();
    _builder.append("SELECT \'�obj.table.name�\', �primaryKey.name�, \'�obj.name�\', �obj.name�, now() from �obj.table.name� where �primaryKey.name� in (Select �primaryKey.name� from �temp_table_name�);");
    _builder.newLine();
    return _builder.toString();
  }

  public static String createTemporaryTable(final String temp_table_name, final Database_Schema schema, final Table table, final PrimaryKey key, final String whereClause) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("SET @sql_mode = @@SESSION.sql_mode;");
    _builder.newLine();
    _builder.append("set @@SESSION.sql_mode = \'\';");
    _builder.newLine();
    _builder.append("DROP TEMPORARY TABLE IF EXISTS �temp_table_name�;");
    _builder.newLine();
    _builder.append("CREATE TEMPORARY TABLE �temp_table_name�");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("SELECT �key.name� from �table.name� v where �whereClause�  ");
    _builder.newLine();
    _builder.append("set @@SESSION.sql_mode = @sql_mode;");
    _builder.newLine();
    String content = _builder.toString();
    return content;
  }

  public static String deleteTemporaryTable(final String temp_table_name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("DROP TEMPORARY TABLE IF EXISTS �temp_table_name�;");
    _builder.newLine();
    return _builder.toString();
  }

  /**
   * Creates the statement for inserting a row into the history table
   */
  public static String createInsertRowHistoryScript(final String tableName, final Database_Schema schema, final Table table, final PrimaryKey key, final String temp_table_name) {
    StringConcatenation _builder = new StringConcatenation();
    String content = _builder.toString();
    EList<Column> _columns = table.getColumns();
    for (final Column column : _columns) {
      boolean _equals = column.getName().equals(key.getName());
      boolean _not = (!_equals);
      if (_not) {
        String _content = content;
        String _createInsertColumnHistoryScriptWithTempTable = ColumnUtil.createInsertColumnHistoryScriptWithTempTable(tableName, schema, column, key, temp_table_name);
        content = (_content + _createInsertColumnHistoryScriptWithTempTable);
      }
    }
    return content;
  }

  /**
   * Checks whether the old and the new column types are compatible.
   */
  public static boolean checkColumnTypeCompatibility(final Column objA, final Column objB) {
    boolean _contains = ColumnUtil.textTypes.contains(objA.getType());
    if (_contains) {
      boolean _contains_1 = ColumnUtil.textTypes.contains(objB.getType());
      if (_contains_1) {
        return ColumnUtil.checkTextToText(objA, objB);
      } else {
        if ((ColumnUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnUtil.dateTypes.contains(objB.getType()))) {
          return ColumnUtil.checkTextToDate(objA, objB);
        } else {
          boolean _contains_2 = ColumnUtil.decimalTypes.contains(objB.getType());
          if (_contains_2) {
            return ColumnUtil.checkTextToDecimal(objA, objB);
          } else {
            boolean _contains_3 = ColumnUtil.displayWitdhTypes.contains(objB.getType());
            if (_contains_3) {
              return ColumnUtil.checkTextToNumeric(objA, objB);
            } else {
              boolean _contains_4 = ColumnUtil.binaryTypes.contains(objB.getType());
              if (_contains_4) {
                return ColumnUtil.checkTextToBinary(objA, objB);
              }
            }
          }
        }
      }
    } else {
      if ((ColumnUtil.dateTypesWithFraction.contains(objA.getType()) || ColumnUtil.dateTypes.contains(objA.getType()))) {
        boolean _contains_5 = ColumnUtil.textTypes.contains(objB.getType());
        if (_contains_5) {
          return ColumnUtil.checkDateToText(objA, objB);
        } else {
          if ((ColumnUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnUtil.dateTypes.contains(objB.getType()))) {
            return ColumnUtil.checkDateToDate(objA, objB);
          } else {
            boolean _contains_6 = ColumnUtil.decimalTypes.contains(objB.getType());
            if (_contains_6) {
              return ColumnUtil.checkDateToDecimal(objA, objB);
            } else {
              boolean _contains_7 = ColumnUtil.displayWitdhTypes.contains(objB.getType());
              if (_contains_7) {
                return ColumnUtil.checkDateToNumeric(objA, objB);
              } else {
                boolean _contains_8 = ColumnUtil.binaryTypes.contains(objB.getType());
                if (_contains_8) {
                  return ColumnUtil.checkDateToBinary(objA, objB);
                }
              }
            }
          }
        }
      } else {
        boolean _contains_9 = ColumnUtil.decimalTypes.contains(objA.getType());
        if (_contains_9) {
          boolean _contains_10 = ColumnUtil.textTypes.contains(objB.getType());
          if (_contains_10) {
            return ColumnUtil.checkDecimalToText(objA, objB);
          } else {
            if ((ColumnUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnUtil.dateTypes.contains(objB.getType()))) {
              return ColumnUtil.checkDecimalToDate(objA, objB);
            } else {
              boolean _contains_11 = ColumnUtil.decimalTypes.contains(objB.getType());
              if (_contains_11) {
                return ColumnUtil.checkDecimalToDecimal(objA, objB);
              } else {
                boolean _contains_12 = ColumnUtil.displayWitdhTypes.contains(objB.getType());
                if (_contains_12) {
                  return ColumnUtil.checkDecimalToNumeric(objA, objB);
                } else {
                  boolean _contains_13 = ColumnUtil.binaryTypes.contains(objB.getType());
                  if (_contains_13) {
                    return ColumnUtil.checkDecimalToBinary(objA, objB);
                  }
                }
              }
            }
          }
        } else {
          boolean _contains_14 = ColumnUtil.displayWitdhTypes.contains(objA.getType());
          if (_contains_14) {
            boolean _contains_15 = ColumnUtil.textTypes.contains(objB.getType());
            if (_contains_15) {
              return ColumnUtil.checkNumericToText(objA, objB);
            } else {
              if ((ColumnUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnUtil.dateTypes.contains(objB.getType()))) {
                return ColumnUtil.checkNumericToDate(objA, objB);
              } else {
                boolean _contains_16 = ColumnUtil.decimalTypes.contains(objB.getType());
                if (_contains_16) {
                  return ColumnUtil.checkNumericToDecimal(objA, objB);
                } else {
                  boolean _contains_17 = ColumnUtil.displayWitdhTypes.contains(objB.getType());
                  if (_contains_17) {
                    return ColumnUtil.checkNumericToNumeric(objA, objB);
                  } else {
                    boolean _contains_18 = ColumnUtil.binaryTypes.contains(objB.getType());
                    if (_contains_18) {
                      return ColumnUtil.checkNumericToBinary(objA, objB);
                    }
                  }
                }
              }
            }
          } else {
            boolean _contains_19 = ColumnUtil.binaryTypes.contains(objA.getType());
            if (_contains_19) {
              boolean _contains_20 = ColumnUtil.textTypes.contains(objB.getType());
              if (_contains_20) {
                return ColumnUtil.checkBinaryToText(objA, objB);
              } else {
                if ((ColumnUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnUtil.dateTypes.contains(objB.getType()))) {
                  return ColumnUtil.checkBinaryToDate(objA, objB);
                } else {
                  boolean _contains_21 = ColumnUtil.decimalTypes.contains(objB.getType());
                  if (_contains_21) {
                    return ColumnUtil.checkBinaryToDecimal(objA, objB);
                  } else {
                    boolean _contains_22 = ColumnUtil.displayWitdhTypes.contains(objB.getType());
                    if (_contains_22) {
                      return ColumnUtil.checkBinaryToNumeric(objA, objB);
                    } else {
                      boolean _contains_23 = ColumnUtil.binaryTypes.contains(objB.getType());
                      if (_contains_23) {
                        return ColumnUtil.checkBinaryToBinary(objA, objB);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  public static boolean checkTextToText(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case CHAR:
                int _sizeValue = ColumnUtil.getSizeValue(objA.getSize());
                int _sizeValue_1 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan = (_sizeValue <= _sizeValue_1);
                if (_lessEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              case TEXT:
                return true;
              case TINYTEXT:
                int _sizeValue_2 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_1 = (_sizeValue_2 <= 255);
                if (_lessEqualsThan_1) {
                  return true;
                } else {
                  return false;
                }
              case MEDIUMTEXT:
                return true;
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case CHAR:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case VARCHAR:
                int _sizeValue_3 = ColumnUtil.getSizeValue(objA.getSize());
                int _sizeValue_4 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_2 = (_sizeValue_3 <= _sizeValue_4);
                if (_lessEqualsThan_2) {
                  return true;
                } else {
                  return false;
                }
              case TEXT:
                return true;
              case TINYTEXT:
                return true;
              case MEDIUMTEXT:
                return true;
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case TEXT:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case VARCHAR:
                int _sizeValue_5 = ColumnUtil.getSizeValue(objA.getSize());
                int _sizeValue_6 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_3 = (_sizeValue_5 <= _sizeValue_6);
                if (_lessEqualsThan_3) {
                  return true;
                } else {
                  return false;
                }
              case CHAR:
                int _sizeValue_7 = ColumnUtil.getSizeValue(objA.getSize());
                int _sizeValue_8 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_4 = (_sizeValue_7 <= _sizeValue_8);
                if (_lessEqualsThan_4) {
                  return true;
                } else {
                  return false;
                }
              case TINYTEXT:
                int _sizeValue_9 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_5 = (_sizeValue_9 <= 255);
                if (_lessEqualsThan_5) {
                  return true;
                } else {
                  return false;
                }
              case MEDIUMTEXT:
                int _sizeValue_10 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_6 = (_sizeValue_10 <= 16777215);
                if (_lessEqualsThan_6) {
                  return true;
                } else {
                  return false;
                }
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case TINYTEXT:
          DataType _type_4 = objB.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case VARCHAR:
                int _sizeValue_11 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_sizeValue_11 >= 255);
                if (_greaterEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              case CHAR:
                int _sizeValue_12 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_1 = (_sizeValue_12 >= 255);
                if (_greaterEqualsThan_1) {
                  return true;
                } else {
                  return false;
                }
              case TEXT:
                return true;
              case MEDIUMTEXT:
                return true;
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case MEDIUMTEXT:
          DataType _type_5 = objB.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case VARCHAR:
                return false;
              case CHAR:
                return false;
              case TEXT:
                return false;
              case TINYTEXT:
                return false;
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case LONGTEXT:
          return true;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkTextToDate(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
          return false;
        case CHAR:
          return false;
        case TINYTEXT:
          return false;
        case TEXT:
          return false;
        case MEDIUMTEXT:
          return false;
        case LONGTEXT:
          return false;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkTextToNumeric(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
          return false;
        case CHAR:
          return false;
        case TINYTEXT:
          return false;
        case TEXT:
          return false;
        case MEDIUMTEXT:
          return false;
        case LONGTEXT:
          return false;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkTextToDecimal(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
          return false;
        case CHAR:
          return false;
        case TINYTEXT:
          return false;
        case TEXT:
          return false;
        case MEDIUMTEXT:
          return false;
        case LONGTEXT:
          return false;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkTextToBinary(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case BLOB:
                return true;
              case TINYBLOB:
                int _sizeValue = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan = (_sizeValue <= 255);
                if (_lessEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              case MEDIUMBLOB:
                return true;
              case LONGBLOB:
                return true;
              case BINARY:
                int _sizeValue_1 = ColumnUtil.getSizeValue(objA.getSize());
                int _sizeValue_2 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_1 = (_sizeValue_1 <= _sizeValue_2);
                if (_lessEqualsThan_1) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case CHAR:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case BLOB:
                return true;
              case TINYBLOB:
                return true;
              case MEDIUMBLOB:
                return true;
              case LONGBLOB:
                return true;
              case BINARY:
                int _sizeValue_3 = ColumnUtil.getSizeValue(objA.getSize());
                int _sizeValue_4 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_2 = (_sizeValue_3 <= _sizeValue_4);
                if (_lessEqualsThan_2) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return true;
              default:
                break;
            }
          }
          break;
        case TINYTEXT:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case BLOB:
                return true;
              case TINYBLOB:
                return true;
              case MEDIUMBLOB:
                return true;
              case LONGBLOB:
                return true;
              case BINARY:
                int _sizeValue_5 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _equals = (_sizeValue_5 == 255);
                if (_equals) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case TEXT:
          DataType _type_4 = objB.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case BLOB:
                return true;
              case TINYBLOB:
                int _sizeValue_6 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_3 = (_sizeValue_6 <= 255);
                if (_lessEqualsThan_3) {
                  return true;
                } else {
                  return false;
                }
              case MEDIUMBLOB:
                int _sizeValue_7 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_4 = (_sizeValue_7 <= 16777215);
                if (_lessEqualsThan_4) {
                  return true;
                } else {
                  return false;
                }
              case LONGBLOB:
                return true;
              case BINARY:
                int _sizeValue_8 = ColumnUtil.getSizeValue(objA.getSize());
                int _sizeValue_9 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_5 = (_sizeValue_8 <= _sizeValue_9);
                if (_lessEqualsThan_5) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case MEDIUMTEXT:
          DataType _type_5 = objB.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case BLOB:
                return true;
              case TINYBLOB:
                return false;
              case MEDIUMBLOB:
                return true;
              case LONGBLOB:
                return true;
              case BINARY:
                return false;
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case LONGTEXT:
          DataType _type_6 = objB.getType();
          if (_type_6 != null) {
            switch (_type_6) {
              case BLOB:
                return false;
              case TINYBLOB:
                return false;
              case MEDIUMBLOB:
                return false;
              case LONGBLOB:
                return true;
              case BINARY:
                return false;
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkDateToText(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DATE:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case VARCHAR:
                int _sizeValue = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_sizeValue >= 10);
                if (_greaterEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              case TEXT:
                return true;
              case TINYTEXT:
                return true;
              case MEDIUMTEXT:
                return true;
              case LONGTEXT:
                return true;
              case CHAR:
                int _sizeValue_1 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_1 = (_sizeValue_1 >= 10);
                if (_greaterEqualsThan_1) {
                  return true;
                } else {
                  return false;
                }
              default:
                break;
            }
          }
          break;
        case TIME:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case VARCHAR:
                int _sizeValue_2 = ColumnUtil.getSizeValue(objB.getSize());
                int _sizeValue_3 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus = (10 + _sizeValue_3);
                boolean _greaterEqualsThan_2 = (_sizeValue_2 >= _plus);
                if (_greaterEqualsThan_2) {
                  return true;
                } else {
                  return false;
                }
              case TEXT:
                return true;
              case TINYTEXT:
                return true;
              case MEDIUMTEXT:
                return true;
              case LONGTEXT:
                return true;
              case CHAR:
                int _sizeValue_4 = ColumnUtil.getSizeValue(objB.getSize());
                int _sizeValue_5 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus_1 = (10 + _sizeValue_5);
                boolean _greaterEqualsThan_3 = (_sizeValue_4 >= _plus_1);
                if (_greaterEqualsThan_3) {
                  return true;
                } else {
                  return false;
                }
              default:
                break;
            }
          }
          break;
        case TIMESTAMP:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case VARCHAR:
                int _sizeValue_6 = ColumnUtil.getSizeValue(objB.getSize());
                int _sizeValue_7 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus_2 = (19 + _sizeValue_7);
                boolean _greaterEqualsThan_4 = (_sizeValue_6 >= _plus_2);
                if (_greaterEqualsThan_4) {
                  return true;
                } else {
                  return false;
                }
              case TEXT:
                return true;
              case TINYTEXT:
                return true;
              case MEDIUMTEXT:
                return true;
              case LONGTEXT:
                return true;
              case CHAR:
                int _sizeValue_8 = ColumnUtil.getSizeValue(objB.getSize());
                int _sizeValue_9 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus_3 = (19 + _sizeValue_9);
                boolean _greaterEqualsThan_5 = (_sizeValue_8 >= _plus_3);
                if (_greaterEqualsThan_5) {
                  return true;
                } else {
                  return false;
                }
              default:
                break;
            }
          }
          break;
        case DATETIME:
          DataType _type_4 = objB.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case VARCHAR:
                int _sizeValue_10 = ColumnUtil.getSizeValue(objB.getSize());
                int _sizeValue_11 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus_4 = (19 + _sizeValue_11);
                boolean _greaterEqualsThan_6 = (_sizeValue_10 >= _plus_4);
                if (_greaterEqualsThan_6) {
                  return true;
                } else {
                  return false;
                }
              case TEXT:
                return true;
              case TINYTEXT:
                return true;
              case MEDIUMTEXT:
                return true;
              case LONGTEXT:
                return true;
              case CHAR:
                int _sizeValue_12 = ColumnUtil.getSizeValue(objB.getSize());
                int _sizeValue_13 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus_5 = (19 + _sizeValue_13);
                boolean _greaterEqualsThan_7 = (_sizeValue_12 >= _plus_5);
                if (_greaterEqualsThan_7) {
                  return true;
                } else {
                  return false;
                }
              default:
                break;
            }
          }
          break;
        case YEAR:
          DataType _type_5 = objB.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case VARCHAR:
                int _sizeValue_14 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_8 = (_sizeValue_14 >= 4);
                if (_greaterEqualsThan_8) {
                  return true;
                } else {
                  return false;
                }
              case TEXT:
                return true;
              case TINYTEXT:
                return true;
              case MEDIUMTEXT:
                return true;
              case LONGTEXT:
                return true;
              case CHAR:
                int _sizeValue_15 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_9 = (_sizeValue_15 >= 4);
                if (_greaterEqualsThan_9) {
                  return true;
                } else {
                  return false;
                }
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkDateToDate(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DATE:
          DataType _type_1 = objA.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case TIME:
                return false;
              case TIMESTAMP:
                return true;
              case DATETIME:
                return true;
              case YEAR:
                return false;
              default:
                break;
            }
          }
          break;
        case TIME:
          DataType _type_2 = objA.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case DATE:
                return true;
              case TIMESTAMP:
                return true;
              case DATETIME:
                return true;
              case YEAR:
                return true;
              default:
                break;
            }
          }
          break;
        case TIMESTAMP:
          DataType _type_3 = objA.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case DATE:
                return true;
              case TIME:
                return true;
              case DATETIME:
                return true;
              case YEAR:
                return false;
              default:
                break;
            }
          }
          break;
        case DATETIME:
          DataType _type_4 = objA.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case DATE:
                return true;
              case TIME:
                return true;
              case TIMESTAMP:
                return true;
              case YEAR:
                return false;
              default:
                break;
            }
          }
          break;
        case YEAR:
          DataType _type_5 = objA.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case DATE:
                return false;
              case TIME:
                return false;
              case TIMESTAMP:
                return false;
              case DATETIME:
                return false;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkDateToNumeric(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DATE:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case BIGINT:
                return true;
              case INT:
              case INTEGER:
                return true;
              case MEDIUMINT:
                return false;
              case TINYINT:
                return false;
              case SMALLINT:
                return false;
              default:
                break;
            }
          }
          break;
        case TIME:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case BIGINT:
                return true;
              case INT:
              case INTEGER:
                return true;
              case MEDIUMINT:
                return true;
              case TINYINT:
                return false;
              case SMALLINT:
                return false;
              default:
                break;
            }
          }
          break;
        case TIMESTAMP:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case BIGINT:
                return true;
              case INT:
              case INTEGER:
              case TINYINT:
              case SMALLINT:
              case MEDIUMINT:
                return false;
              default:
                break;
            }
          }
          break;
        case DATETIME:
          DataType _type_4 = objB.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case BIGINT:
                return true;
              case INT:
              case INTEGER:
              case TINYINT:
              case SMALLINT:
              case MEDIUMINT:
                return false;
              default:
                break;
            }
          }
          break;
        case YEAR:
          DataType _type_5 = objB.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case BIGINT:
              case SMALLINT:
              case MEDIUMINT:
              case INT:
              case INTEGER:
                return true;
              case TINYINT:
                return false;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkDateToDecimal(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DATE:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case DEC:
              case DECIMAL:
                int _decimalSizeValue = ColumnUtil.getDecimalSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_decimalSizeValue >= 8);
                if (_greaterEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              case FLOAT:
                return true;
              case DOUBLE:
                return true;
              default:
                break;
            }
          }
          break;
        case TIME:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case DEC:
              case DECIMAL:
                return true;
              case FLOAT:
                return true;
              case DOUBLE:
                return true;
              default:
                break;
            }
          }
          break;
        case TIMESTAMP:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case DEC:
              case DECIMAL:
                int _decimalSizeValue_1 = ColumnUtil.getDecimalSizeValue(objB.getSize());
                int _sizeValue = ColumnUtil.getSizeValue(objA.getSize());
                int _plus = (14 + _sizeValue);
                boolean _greaterEqualsThan_1 = (_decimalSizeValue_1 >= _plus);
                if (_greaterEqualsThan_1) {
                  return true;
                } else {
                  return false;
                }
              case FLOAT:
                return true;
              case DOUBLE:
                return true;
              default:
                break;
            }
          }
          break;
        case DATETIME:
          DataType _type_4 = objB.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case DEC:
              case DECIMAL:
                int _decimalSizeValue_2 = ColumnUtil.getDecimalSizeValue(objB.getSize());
                int _sizeValue_1 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus_1 = (14 + _sizeValue_1);
                boolean _greaterEqualsThan_2 = (_decimalSizeValue_2 >= _plus_1);
                if (_greaterEqualsThan_2) {
                  return true;
                } else {
                  return false;
                }
              case FLOAT:
                return true;
              case DOUBLE:
                return true;
              default:
                break;
            }
          }
          break;
        case YEAR:
          DataType _type_5 = objB.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case DEC:
              case DECIMAL:
                return true;
              case FLOAT:
                return true;
              case DOUBLE:
                return true;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkDateToBinary(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DATE:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case BLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
              case TINYBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                int _sizeValue = ColumnUtil.getSizeValue(objB.getSize());
                int _sizeValue_1 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus = (10 + _sizeValue_1);
                boolean _greaterThan = (_sizeValue > _plus);
                if (_greaterThan) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case TIME:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case BLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
              case TINYBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                int _sizeValue_2 = ColumnUtil.getSizeValue(objB.getSize());
                int _sizeValue_3 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus_1 = (8 + _sizeValue_3);
                boolean _greaterThan_1 = (_sizeValue_2 > _plus_1);
                if (_greaterThan_1) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case TIMESTAMP:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case BLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
              case TINYBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                int _sizeValue_4 = ColumnUtil.getSizeValue(objB.getSize());
                int _sizeValue_5 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus_2 = (20 + _sizeValue_5);
                boolean _greaterThan_2 = (_sizeValue_4 > _plus_2);
                if (_greaterThan_2) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case DATETIME:
          DataType _type_4 = objB.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case BLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
              case TINYBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                int _sizeValue_6 = ColumnUtil.getSizeValue(objB.getSize());
                int _sizeValue_7 = ColumnUtil.getSizeValue(objA.getSize());
                int _plus_3 = (20 + _sizeValue_7);
                boolean _greaterThan_3 = (_sizeValue_6 > _plus_3);
                if (_greaterThan_3) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case YEAR:
          DataType _type_5 = objB.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case BLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
              case TINYBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                int _sizeValue_8 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_sizeValue_8 >= 4);
                if (_greaterEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkNumericToText(final Column objA, final Column objB) {
    DataType _type = objB.getType();
    if (_type != null) {
      switch (_type) {
        case TINYTEXT:
        case TEXT:
        case MEDIUMTEXT:
        case LONGTEXT:
          return true;
        default:
          break;
      }
    }
    DataType _type_1 = objA.getType();
    if (_type_1 != null) {
      switch (_type_1) {
        case BIGINT:
          int _sizeValue = ColumnUtil.getSizeValue(objB.getSize());
          boolean _greaterEqualsThan = (_sizeValue >= 20);
          if (_greaterEqualsThan) {
            return true;
          } else {
            return false;
          }
        case INT:
        case INTEGER:
          int _sizeValue_1 = ColumnUtil.getSizeValue(objB.getSize());
          boolean _greaterEqualsThan_1 = (_sizeValue_1 >= 10);
          if (_greaterEqualsThan_1) {
            return true;
          } else {
            return false;
          }
        case MEDIUMINT:
          int _sizeValue_2 = ColumnUtil.getSizeValue(objB.getSize());
          boolean _greaterEqualsThan_2 = (_sizeValue_2 >= 8);
          if (_greaterEqualsThan_2) {
            return true;
          } else {
            return false;
          }
        case TINYINT:
          int _sizeValue_3 = ColumnUtil.getSizeValue(objB.getSize());
          boolean _greaterEqualsThan_3 = (_sizeValue_3 >= 3);
          if (_greaterEqualsThan_3) {
            return true;
          } else {
            return false;
          }
        case SMALLINT:
          int _sizeValue_4 = ColumnUtil.getSizeValue(objB.getSize());
          boolean _greaterEqualsThan_4 = (_sizeValue_4 >= 5);
          if (_greaterEqualsThan_4) {
            return true;
          } else {
            return false;
          }
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkNumericToDate(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BIGINT:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case DATE:
                return true;
              case TIME:
                break;
              case TIMESTAMP:
                break;
              case DATETIME:
                break;
              case YEAR:
                break;
              default:
                break;
            }
          }
          break;
        case INT:
        case INTEGER:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case DATE:
                return true;
              case TIME:
                break;
              case TIMESTAMP:
                break;
              case DATETIME:
                break;
              case YEAR:
                break;
              default:
                break;
            }
          }
          break;
        case MEDIUMINT:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case DATE:
                return false;
              case TIME:
                break;
              case TIMESTAMP:
                return false;
              case DATETIME:
                return false;
              case YEAR:
                break;
              default:
                break;
            }
          }
          break;
        case TINYINT:
          DataType _type_4 = objB.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case DATE:
                return false;
              case TIME:
                return false;
              case TIMESTAMP:
                return false;
              case DATETIME:
                return false;
              case YEAR:
                return false;
              default:
                break;
            }
          }
          break;
        case SMALLINT:
          DataType _type_5 = objB.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case DATE:
                return false;
              case TIME:
                return false;
              case TIMESTAMP:
                return false;
              case DATETIME:
                return false;
              case YEAR:
                return false;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkNumericToNumeric(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BIGINT:
          DataType _type_1 = objA.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case INT:
              case INTEGER:
              case MEDIUMINT:
              case TINYINT:
              case SMALLINT:
                return false;
              default:
                break;
            }
          }
          break;
        case INT:
        case INTEGER:
          DataType _type_2 = objA.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case BIGINT:
                return true;
              case MEDIUMINT:
              case SMALLINT:
              case TINYINT:
                return false;
              default:
                break;
            }
          }
          break;
        case MEDIUMINT:
          DataType _type_3 = objA.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case BIGINT:
              case INT:
              case INTEGER:
                return true;
              case TINYINT:
              case SMALLINT:
                return false;
              default:
                break;
            }
          }
          break;
        case TINYINT:
          DataType _type_4 = objA.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case BIGINT:
              case INT:
              case INTEGER:
              case MEDIUMINT:
              case SMALLINT:
                return true;
              default:
                break;
            }
          }
          break;
        case SMALLINT:
          DataType _type_5 = objA.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case BIGINT:
              case INT:
              case INTEGER:
              case MEDIUMINT:
                return true;
              case TINYINT:
                return false;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkNumericToDecimal(final Column objA, final Column objB) {
    DataType _type = objB.getType();
    if (_type != null) {
      switch (_type) {
        case FLOAT:
        case DOUBLE:
          return true;
        default:
          break;
      }
    }
    DataType _type_1 = objA.getType();
    if (_type_1 != null) {
      switch (_type_1) {
        case BIGINT:
          int _decimalSizeValue = ColumnUtil.getDecimalSizeValue(objA.getSize());
          boolean _greaterEqualsThan = (_decimalSizeValue >= 20);
          if (_greaterEqualsThan) {
            return true;
          } else {
            return false;
          }
        case INT:
        case INTEGER:
          int _decimalSizeValue_1 = ColumnUtil.getDecimalSizeValue(objA.getSize());
          boolean _greaterEqualsThan_1 = (_decimalSizeValue_1 >= 10);
          if (_greaterEqualsThan_1) {
            return true;
          } else {
            return false;
          }
        case MEDIUMINT:
          int _decimalSizeValue_2 = ColumnUtil.getDecimalSizeValue(objA.getSize());
          boolean _greaterEqualsThan_2 = (_decimalSizeValue_2 >= 8);
          if (_greaterEqualsThan_2) {
            return true;
          } else {
            return false;
          }
        case TINYINT:
          int _decimalSizeValue_3 = ColumnUtil.getDecimalSizeValue(objA.getSize());
          boolean _greaterEqualsThan_3 = (_decimalSizeValue_3 >= 3);
          if (_greaterEqualsThan_3) {
            return true;
          } else {
            return false;
          }
        case SMALLINT:
          int _decimalSizeValue_4 = ColumnUtil.getDecimalSizeValue(objA.getSize());
          boolean _greaterEqualsThan_4 = (_decimalSizeValue_4 >= 5);
          if (_greaterEqualsThan_4) {
            return true;
          } else {
            return false;
          }
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkNumericToBinary(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BIGINT:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                return false;
              default:
                break;
            }
          }
          break;
        case INT:
        case INTEGER:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                return false;
              default:
                break;
            }
          }
          break;
        case MEDIUMINT:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                return false;
              default:
                break;
            }
          }
          break;
        case TINYINT:
          DataType _type_4 = objB.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                return false;
              default:
                break;
            }
          }
          break;
        case SMALLINT:
          DataType _type_5 = objB.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                return false;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkDecimalToText(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DEC:
        case DECIMAL:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case TINYTEXT:
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return true;
              case CHAR:
              case VARCHAR:
                int _decimalSizeValue = ColumnUtil.getDecimalSizeValue(objA.getSize());
                int _sizeValue = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_decimalSizeValue >= _sizeValue);
                if (_greaterEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              default:
                break;
            }
          }
          break;
        case FLOAT:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case TINYTEXT:
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return true;
              case CHAR:
              case VARCHAR:
                return false;
              default:
                break;
            }
          }
          break;
        case DOUBLE:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case TINYTEXT:
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return true;
              case CHAR:
              case VARCHAR:
                return false;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkDecimalToDate(final Column objA, final Column objB) {
    return false;
  }

  public static boolean checkDecimalToNumeric(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DEC:
        case DECIMAL:
          break;
        case FLOAT:
          break;
        case DOUBLE:
          break;
        default:
          break;
      }
    }
    DataType _type_1 = objB.getType();
    if (_type_1 != null) {
      switch (_type_1) {
        case BIGINT:
          break;
        case INT:
        case INTEGER:
          break;
        case MEDIUMINT:
          break;
        case TINYINT:
          break;
        case SMALLINT:
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkDecimalToDecimal(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DEC:
        case DECIMAL:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case FLOAT:
                int _decimalSizeValue = ColumnUtil.getDecimalSizeValue(objA.getSize());
                boolean _lessEqualsThan = (_decimalSizeValue <= 39);
                if (_lessEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              case DOUBLE:
                return true;
              default:
                break;
            }
          }
          break;
        case FLOAT:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case DEC:
              case DECIMAL:
                return false;
              case DOUBLE:
                return true;
              default:
                break;
            }
          }
          break;
        case DOUBLE:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case DEC:
              case DECIMAL:
                return false;
              case FLOAT:
                return false;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkDecimalToBinary(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DEC:
        case DECIMAL:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                int _sizeValue = ColumnUtil.getSizeValue(objB.getSize());
                int _decimalSizeValue = ColumnUtil.getDecimalSizeValue(objA.getSize());
                boolean _greaterEqualsThan = (_sizeValue >= _decimalSizeValue);
                if (_greaterEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                int _sizeValue_1 = ColumnUtil.getSizeValue(objB.getSize());
                int _decimalSizeValue_1 = ColumnUtil.getDecimalSizeValue(objA.getSize());
                boolean _greaterEqualsThan_1 = (_sizeValue_1 >= _decimalSizeValue_1);
                if (_greaterEqualsThan_1) {
                  return true;
                } else {
                  return false;
                }
              default:
                break;
            }
          }
          break;
        case FLOAT:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                int _sizeValue_2 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_2 = (_sizeValue_2 >= 65);
                if (_greaterEqualsThan_2) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case DOUBLE:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
              case VARBINARY:
                int _sizeValue_3 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_3 = (_sizeValue_3 >= 65);
                if (_greaterEqualsThan_3) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkBinaryToText(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BLOB:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case CHAR:
                return false;
              case VARCHAR:
                return true;
              case TINYTEXT:
                return false;
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case TINYBLOB:
          DataType _type_2 = objB.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case CHAR:
                int _sizeValue = ColumnUtil.getSizeValue(objB.getSize());
                boolean _equals = (_sizeValue == 255);
                if (_equals) {
                  return true;
                } else {
                  return false;
                }
              case VARCHAR:
              case TINYTEXT:
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case MEDIUMBLOB:
          DataType _type_3 = objB.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case CHAR:
              case VARCHAR:
              case TINYTEXT:
              case TEXT:
                return false;
              case MEDIUMTEXT:
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case LONGBLOB:
          DataType _type_4 = objB.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case CHAR:
              case VARCHAR:
              case TINYTEXT:
              case TEXT:
              case MEDIUMTEXT:
                return false;
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case BINARY:
          DataType _type_5 = objB.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case CHAR:
                int _sizeValue_1 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _equals_1 = (_sizeValue_1 == 255);
                if (_equals_1) {
                  return true;
                } else {
                  return false;
                }
              case VARCHAR:
                int _sizeValue_2 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_sizeValue_2 >= 255);
                if (_greaterEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              case TINYTEXT:
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case VARBINARY:
          DataType _type_6 = objB.getType();
          if (_type_6 != null) {
            switch (_type_6) {
              case CHAR:
                int _sizeValue_3 = ColumnUtil.getSizeValue(objA.getSize());
                int _sizeValue_4 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan = (_sizeValue_3 <= _sizeValue_4);
                if (_lessEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              case VARCHAR:
                int _sizeValue_5 = ColumnUtil.getSizeValue(objA.getSize());
                int _sizeValue_6 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_1 = (_sizeValue_5 <= _sizeValue_6);
                if (_lessEqualsThan_1) {
                  return true;
                } else {
                  return false;
                }
              case TINYTEXT:
                int _sizeValue_7 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_2 = (_sizeValue_7 <= 255);
                if (_lessEqualsThan_2) {
                  return true;
                } else {
                  return false;
                }
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        case BIT:
          DataType _type_7 = objB.getType();
          if (_type_7 != null) {
            switch (_type_7) {
              case CHAR:
              case VARCHAR:
              case TINYTEXT:
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return true;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkBinaryToDate(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BLOB:
          return false;
        case TINYBLOB:
          return false;
        case MEDIUMBLOB:
          return false;
        case LONGBLOB:
          return false;
        case BINARY:
          return false;
        case VARBINARY:
          return false;
        case BIT:
          return false;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkBinaryToNumeric(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BLOB:
          return false;
        case TINYBLOB:
          return false;
        case MEDIUMBLOB:
          return false;
        case LONGBLOB:
          return false;
        case BINARY:
          return false;
        case VARBINARY:
          return false;
        case BIT:
          return false;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkBinaryToDecimal(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BLOB:
        case TINYBLOB:
        case MEDIUMBLOB:
        case LONGBLOB:
        case BINARY:
        case VARBINARY:
        case BIT:
          return false;
        default:
          break;
      }
    }
    return false;
  }

  public static boolean checkBinaryToBinary(final Column objA, final Column objB) {
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BLOB:
          DataType _type_1 = objA.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case TINYBLOB:
                return false;
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
                return false;
              case VARBINARY:
                int _sizeValue = ColumnUtil.getSizeValue(objB.getSize());
                boolean _equals = (_sizeValue == 65535);
                if (_equals) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case TINYBLOB:
          DataType _type_2 = objA.getType();
          if (_type_2 != null) {
            switch (_type_2) {
              case BLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
                int _sizeValue_1 = ColumnUtil.getSizeValue(objB.getSize());
                boolean _equals_1 = (_sizeValue_1 == 255);
                if (_equals_1) {
                  return true;
                } else {
                  return false;
                }
              case VARBINARY:
                return true;
              case BIT:
                int _sizeValue_2 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan = (_sizeValue_2 <= 1);
                if (_lessEqualsThan) {
                  return true;
                } else {
                  return false;
                }
              default:
                break;
            }
          }
          break;
        case MEDIUMBLOB:
          DataType _type_3 = objA.getType();
          if (_type_3 != null) {
            switch (_type_3) {
              case BLOB:
                return false;
              case TINYBLOB:
                return false;
              case LONGBLOB:
                return true;
              case BINARY:
                return false;
              case VARBINARY:
                return false;
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case LONGBLOB:
          DataType _type_4 = objA.getType();
          if (_type_4 != null) {
            switch (_type_4) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
              case BINARY:
              case VARBINARY:
              case BIT:
                return false;
              default:
                break;
            }
          }
          break;
        case BINARY:
          DataType _type_5 = objA.getType();
          if (_type_5 != null) {
            switch (_type_5) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case VARBINARY:
                return true;
              case BIT:
                int _sizeValue_3 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_1 = (_sizeValue_3 <= 1);
                if (_lessEqualsThan_1) {
                  return true;
                } else {
                  return false;
                }
              default:
                break;
            }
          }
          break;
        case VARBINARY:
          DataType _type_6 = objA.getType();
          if (_type_6 != null) {
            switch (_type_6) {
              case BLOB:
                return true;
              case TINYBLOB:
                int _sizeValue_4 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_2 = (_sizeValue_4 <= 255);
                if (_lessEqualsThan_2) {
                  return true;
                } else {
                  return false;
                }
              case MEDIUMBLOB:
              case LONGBLOB:
                return true;
              case BINARY:
                int _sizeValue_5 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_3 = (_sizeValue_5 <= 255);
                if (_lessEqualsThan_3) {
                  return true;
                } else {
                  return false;
                }
              case BIT:
                int _sizeValue_6 = ColumnUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_4 = (_sizeValue_6 <= 1);
                if (_lessEqualsThan_4) {
                  return true;
                } else {
                  return false;
                }
              default:
                break;
            }
          }
          break;
        case BIT:
          DataType _type_7 = objA.getType();
          if (_type_7 != null) {
            switch (_type_7) {
              case BLOB:
              case TINYBLOB:
              case MEDIUMBLOB:
              case LONGBLOB:
              case BINARY:
              case VARBINARY:
                return true;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return false;
  }
}
