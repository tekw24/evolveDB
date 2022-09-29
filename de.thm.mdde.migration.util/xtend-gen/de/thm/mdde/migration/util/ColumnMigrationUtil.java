package de.thm.mdde.migration.util;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.DataType;
import de.thm.evolvedb.migration.ColumnOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;

@SuppressWarnings("all")
public class ColumnMigrationUtil {
  public static List<DataType> textTypes = Arrays.<DataType>asList(DataType.CHAR, DataType.VARCHAR, DataType.TEXT, 
    DataType.MEDIUMTEXT, DataType.LONGTEXT, DataType.TINYTEXT);

  public static List<DataType> dateTypesWithFraction = Arrays.<DataType>asList(DataType.DATETIME, DataType.TIMESTAMP, 
    DataType.TIME);

  public static List<DataType> dateTypes = Arrays.<DataType>asList(DataType.DATE, DataType.YEAR);

  public static List<DataType> decimalTypes = Arrays.<DataType>asList(DataType.DEC, DataType.DECIMAL, DataType.FLOAT, 
    DataType.DOUBLE);

  public static List<DataType> displayWitdhTypes = Arrays.<DataType>asList(DataType.BIGINT, DataType.INT, DataType.INTEGER, 
    DataType.SMALLINT, DataType.MEDIUMINT);

  public static List<DataType> binaryTypes = Arrays.<DataType>asList(DataType.BINARY, DataType.VARBINARY, DataType.BLOB, 
    DataType.TINYBLOB, DataType.BIT, DataType.MEDIUMBLOB, DataType.LONGBLOB);

  /**
   * @generated NOT
   */
  public static List<DataType> typesWithoutSize = Arrays.<DataType>asList(DataType.TINYBLOB, DataType.TINYTEXT, 
    DataType.MEDIUMBLOB, DataType.MEDIUMTEXT, DataType.LONGBLOB, DataType.LONGTEXT, DataType.BOOL, DataType.BOOLEAN, 
    DataType.DATE, DataType.YEAR, DataType.TINYTEXT, DataType.BIGINT, DataType.SMALLINT, DataType.MEDIUMINT);

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

  /**
   * Checks whether the old and the new column types are compatible.
   */
  public static List<ColumnOptions> checkColumnTypeCompatibility(final Column objA, final Column objB) {
    boolean _contains = ColumnMigrationUtil.textTypes.contains(objA.getType());
    if (_contains) {
      boolean _contains_1 = ColumnMigrationUtil.textTypes.contains(objB.getType());
      if (_contains_1) {
        return ColumnMigrationUtil.checkTextToText(objA, objB);
      } else {
        if ((ColumnMigrationUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnMigrationUtil.dateTypes.contains(objB.getType()))) {
          return ColumnMigrationUtil.checkTextToDate(objA, objB);
        } else {
          boolean _contains_2 = ColumnMigrationUtil.decimalTypes.contains(objB.getType());
          if (_contains_2) {
            return ColumnMigrationUtil.checkTextToDecimal(objA, objB);
          } else {
            boolean _contains_3 = ColumnMigrationUtil.displayWitdhTypes.contains(objB.getType());
            if (_contains_3) {
              return ColumnMigrationUtil.checkTextToNumeric(objA, objB);
            } else {
              boolean _contains_4 = ColumnMigrationUtil.binaryTypes.contains(objB.getType());
              if (_contains_4) {
                return ColumnMigrationUtil.checkTextToBinary(objA, objB);
              }
            }
          }
        }
      }
    } else {
      if ((ColumnMigrationUtil.dateTypesWithFraction.contains(objA.getType()) || ColumnMigrationUtil.dateTypes.contains(objA.getType()))) {
        boolean _contains_5 = ColumnMigrationUtil.textTypes.contains(objB.getType());
        if (_contains_5) {
          return ColumnMigrationUtil.checkDateToText(objA, objB);
        } else {
          if ((ColumnMigrationUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnMigrationUtil.dateTypes.contains(objB.getType()))) {
            return ColumnMigrationUtil.checkDateToDate(objA, objB);
          } else {
            boolean _contains_6 = ColumnMigrationUtil.decimalTypes.contains(objB.getType());
            if (_contains_6) {
              return ColumnMigrationUtil.checkDateToDecimal(objA, objB);
            } else {
              boolean _contains_7 = ColumnMigrationUtil.displayWitdhTypes.contains(objB.getType());
              if (_contains_7) {
                return ColumnMigrationUtil.checkDateToNumeric(objA, objB);
              } else {
                boolean _contains_8 = ColumnMigrationUtil.binaryTypes.contains(objB.getType());
                if (_contains_8) {
                  return ColumnMigrationUtil.checkDateToBinary(objA, objB);
                }
              }
            }
          }
        }
      } else {
        boolean _contains_9 = ColumnMigrationUtil.decimalTypes.contains(objA.getType());
        if (_contains_9) {
          boolean _contains_10 = ColumnMigrationUtil.textTypes.contains(objB.getType());
          if (_contains_10) {
            return ColumnMigrationUtil.checkDecimalToText(objA, objB);
          } else {
            if ((ColumnMigrationUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnMigrationUtil.dateTypes.contains(objB.getType()))) {
              return ColumnMigrationUtil.checkDecimalToDate(objA, objB);
            } else {
              boolean _contains_11 = ColumnMigrationUtil.decimalTypes.contains(objB.getType());
              if (_contains_11) {
                return ColumnMigrationUtil.checkDecimalToDecimal(objA, objB);
              } else {
                boolean _contains_12 = ColumnMigrationUtil.displayWitdhTypes.contains(objB.getType());
                if (_contains_12) {
                  return ColumnMigrationUtil.checkDecimalToNumeric(objA, objB);
                } else {
                  boolean _contains_13 = ColumnMigrationUtil.binaryTypes.contains(objB.getType());
                  if (_contains_13) {
                    return ColumnMigrationUtil.checkDecimalToBinary(objA, objB);
                  }
                }
              }
            }
          }
        } else {
          boolean _contains_14 = ColumnMigrationUtil.displayWitdhTypes.contains(objA.getType());
          if (_contains_14) {
            boolean _contains_15 = ColumnMigrationUtil.textTypes.contains(objB.getType());
            if (_contains_15) {
              return ColumnMigrationUtil.checkNumericToText(objA, objB);
            } else {
              if ((ColumnMigrationUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnMigrationUtil.dateTypes.contains(objB.getType()))) {
                return ColumnMigrationUtil.checkNumericToDate(objA, objB);
              } else {
                boolean _contains_16 = ColumnMigrationUtil.decimalTypes.contains(objB.getType());
                if (_contains_16) {
                  return ColumnMigrationUtil.checkNumericToDecimal(objA, objB);
                } else {
                  boolean _contains_17 = ColumnMigrationUtil.displayWitdhTypes.contains(objB.getType());
                  if (_contains_17) {
                    return ColumnMigrationUtil.checkNumericToNumeric(objA, objB);
                  } else {
                    boolean _contains_18 = ColumnMigrationUtil.binaryTypes.contains(objB.getType());
                    if (_contains_18) {
                      return ColumnMigrationUtil.checkNumericToBinary(objA, objB);
                    }
                  }
                }
              }
            }
          } else {
            boolean _contains_19 = ColumnMigrationUtil.binaryTypes.contains(objA.getType());
            if (_contains_19) {
              boolean _contains_20 = ColumnMigrationUtil.textTypes.contains(objB.getType());
              if (_contains_20) {
                return ColumnMigrationUtil.checkBinaryToText(objA, objB);
              } else {
                if ((ColumnMigrationUtil.dateTypesWithFraction.contains(objB.getType()) || ColumnMigrationUtil.dateTypes.contains(objB.getType()))) {
                  return ColumnMigrationUtil.checkBinaryToDate(objA, objB);
                } else {
                  boolean _contains_21 = ColumnMigrationUtil.decimalTypes.contains(objB.getType());
                  if (_contains_21) {
                    return ColumnMigrationUtil.checkBinaryToDecimal(objA, objB);
                  } else {
                    boolean _contains_22 = ColumnMigrationUtil.displayWitdhTypes.contains(objB.getType());
                    if (_contains_22) {
                      return ColumnMigrationUtil.checkBinaryToNumeric(objA, objB);
                    } else {
                      boolean _contains_23 = ColumnMigrationUtil.binaryTypes.contains(objB.getType());
                      if (_contains_23) {
                        return ColumnMigrationUtil.checkBinaryToBinary(objA, objB);
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
    return new ArrayList<ColumnOptions>();
  }

  public static List<ColumnOptions> checkTextToText(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case CHAR:
                int _sizeValue = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _sizeValue_1 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan = (_sizeValue <= _sizeValue_1);
                if (_lessEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TEXT:
                return migrationOptions;
              case TINYTEXT:
                int _sizeValue_2 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_1 = (_sizeValue_2 <= 255);
                if (_lessEqualsThan_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case MEDIUMTEXT:
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
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
                int _sizeValue_3 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _sizeValue_4 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_2 = (_sizeValue_3 <= _sizeValue_4);
                if (_lessEqualsThan_2) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TEXT:
                return migrationOptions;
              case TINYTEXT:
                return migrationOptions;
              case MEDIUMTEXT:
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
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
                int _sizeValue_5 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _sizeValue_6 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_3 = (_sizeValue_5 <= _sizeValue_6);
                if (_lessEqualsThan_3) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case CHAR:
                int _sizeValue_7 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _sizeValue_8 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_4 = (_sizeValue_7 <= _sizeValue_8);
                if (_lessEqualsThan_4) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TINYTEXT:
                int _sizeValue_9 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_5 = (_sizeValue_9 <= 255);
                if (_lessEqualsThan_5) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case MEDIUMTEXT:
                int _sizeValue_10 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_6 = (_sizeValue_10 <= 16777215);
                if (_lessEqualsThan_6) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
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
                int _sizeValue_11 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_sizeValue_11 >= 255);
                if (_greaterEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case CHAR:
                int _sizeValue_12 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_1 = (_sizeValue_12 >= 255);
                if (_greaterEqualsThan_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TEXT:
                return migrationOptions;
              case MEDIUMTEXT:
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case CHAR:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TEXT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TINYTEXT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        case LONGTEXT:
          return migrationOptions;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkTextToDate(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case CHAR:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case TINYTEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case TEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case MEDIUMTEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case LONGTEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkTextToNumeric(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case CHAR:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          break;
        case TINYTEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          break;
        case TEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          break;
        case MEDIUMTEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          break;
        case LONGTEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkTextToDecimal(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case CHAR:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case TINYTEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case TEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case MEDIUMTEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case LONGTEXT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkTextToBinary(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case BLOB:
                return migrationOptions;
              case TINYBLOB:
                int _sizeValue = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan = (_sizeValue <= 255);
                if (_lessEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case MEDIUMBLOB:
                return migrationOptions;
              case LONGBLOB:
                return migrationOptions;
              case BINARY:
                int _sizeValue_1 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _sizeValue_2 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_1 = (_sizeValue_1 <= _sizeValue_2);
                if (_lessEqualsThan_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case TINYBLOB:
                return migrationOptions;
              case MEDIUMBLOB:
                return migrationOptions;
              case LONGBLOB:
                return migrationOptions;
              case BINARY:
                int _sizeValue_3 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _sizeValue_4 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_2 = (_sizeValue_3 <= _sizeValue_4);
                if (_lessEqualsThan_2) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                return migrationOptions;
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
                return migrationOptions;
              case TINYBLOB:
                return migrationOptions;
              case MEDIUMBLOB:
                return migrationOptions;
              case LONGBLOB:
                return migrationOptions;
              case BINARY:
                int _sizeValue_5 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _equals = (_sizeValue_5 == 255);
                if (_equals) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case TINYBLOB:
                int _sizeValue_6 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_3 = (_sizeValue_6 <= 255);
                if (_lessEqualsThan_3) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case MEDIUMBLOB:
                int _sizeValue_7 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_4 = (_sizeValue_7 <= 16777215);
                if (_lessEqualsThan_4) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case LONGBLOB:
                return migrationOptions;
              case BINARY:
                int _sizeValue_8 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _sizeValue_9 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_5 = (_sizeValue_8 <= _sizeValue_9);
                if (_lessEqualsThan_5) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case TINYBLOB:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case MEDIUMBLOB:
                return migrationOptions;
              case LONGBLOB:
                return migrationOptions;
              case BINARY:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TINYBLOB:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case MEDIUMBLOB:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case LONGBLOB:
                return migrationOptions;
              case BINARY:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkDateToText(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DATE:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case VARCHAR:
                int _sizeValue = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_sizeValue >= 10);
                if (_greaterEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TEXT:
                return migrationOptions;
              case TINYTEXT:
                return migrationOptions;
              case MEDIUMTEXT:
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
              case CHAR:
                int _sizeValue_1 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_1 = (_sizeValue_1 >= 10);
                if (_greaterEqualsThan_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
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
                int _sizeValue_2 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _sizeValue_3 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus = (10 + _sizeValue_3);
                boolean _greaterEqualsThan_2 = (_sizeValue_2 >= _plus);
                if (_greaterEqualsThan_2) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TEXT:
                return migrationOptions;
              case TINYTEXT:
                return migrationOptions;
              case MEDIUMTEXT:
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
              case CHAR:
                int _sizeValue_4 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _sizeValue_5 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus_1 = (10 + _sizeValue_5);
                boolean _greaterEqualsThan_3 = (_sizeValue_4 >= _plus_1);
                if (_greaterEqualsThan_3) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
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
                int _sizeValue_6 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _sizeValue_7 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus_2 = (19 + _sizeValue_7);
                boolean _greaterEqualsThan_4 = (_sizeValue_6 >= _plus_2);
                if (_greaterEqualsThan_4) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TEXT:
                return migrationOptions;
              case TINYTEXT:
                return migrationOptions;
              case MEDIUMTEXT:
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
              case CHAR:
                int _sizeValue_8 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _sizeValue_9 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus_3 = (19 + _sizeValue_9);
                boolean _greaterEqualsThan_5 = (_sizeValue_8 >= _plus_3);
                if (_greaterEqualsThan_5) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
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
                int _sizeValue_10 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _sizeValue_11 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus_4 = (19 + _sizeValue_11);
                boolean _greaterEqualsThan_6 = (_sizeValue_10 >= _plus_4);
                if (_greaterEqualsThan_6) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TEXT:
                return migrationOptions;
              case TINYTEXT:
                return migrationOptions;
              case MEDIUMTEXT:
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
              case CHAR:
                int _sizeValue_12 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _sizeValue_13 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus_5 = (19 + _sizeValue_13);
                boolean _greaterEqualsThan_7 = (_sizeValue_12 >= _plus_5);
                if (_greaterEqualsThan_7) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
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
                int _sizeValue_14 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_8 = (_sizeValue_14 >= 4);
                if (_greaterEqualsThan_8) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TEXT:
                return migrationOptions;
              case TINYTEXT:
                return migrationOptions;
              case MEDIUMTEXT:
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
              case CHAR:
                int _sizeValue_15 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_9 = (_sizeValue_15 >= 4);
                if (_greaterEqualsThan_9) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkDateToDate(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DATE:
          DataType _type_1 = objA.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case TIME:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TIMESTAMP:
                return migrationOptions;
              case DATETIME:
                return migrationOptions;
              case YEAR:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case TIMESTAMP:
                return migrationOptions;
              case DATETIME:
                return migrationOptions;
              case YEAR:
                return migrationOptions;
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
                return migrationOptions;
              case TIME:
                return migrationOptions;
              case DATETIME:
                return migrationOptions;
              case YEAR:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case TIME:
                return migrationOptions;
              case TIMESTAMP:
                return migrationOptions;
              case YEAR:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TIME:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TIMESTAMP:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case DATETIME:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkDateToNumeric(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DATE:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case BIGINT:
                return migrationOptions;
              case INT:
              case INTEGER:
                return migrationOptions;
              case MEDIUMINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TINYINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case SMALLINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case INT:
              case INTEGER:
                return migrationOptions;
              case MEDIUMINT:
                return migrationOptions;
              case TINYINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case SMALLINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case INT:
              case INTEGER:
              case TINYINT:
              case SMALLINT:
              case MEDIUMINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case INT:
              case INTEGER:
              case TINYINT:
              case SMALLINT:
              case MEDIUMINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case TINYINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkDateToDecimal(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DATE:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case DEC:
              case DECIMAL:
                int _decimalSizeValue = ColumnMigrationUtil.getDecimalSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_decimalSizeValue >= 8);
                if (_greaterEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case FLOAT:
                return migrationOptions;
              case DOUBLE:
                return migrationOptions;
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
                return migrationOptions;
              case FLOAT:
                return migrationOptions;
              case DOUBLE:
                return migrationOptions;
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
                int _decimalSizeValue_1 = ColumnMigrationUtil.getDecimalSizeValue(objB.getSize());
                int _sizeValue = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus = (14 + _sizeValue);
                boolean _greaterEqualsThan_1 = (_decimalSizeValue_1 >= _plus);
                if (_greaterEqualsThan_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case FLOAT:
                return migrationOptions;
              case DOUBLE:
                return migrationOptions;
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
                int _decimalSizeValue_2 = ColumnMigrationUtil.getDecimalSizeValue(objB.getSize());
                int _sizeValue_1 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus_1 = (14 + _sizeValue_1);
                boolean _greaterEqualsThan_2 = (_decimalSizeValue_2 >= _plus_1);
                if (_greaterEqualsThan_2) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case FLOAT:
                return migrationOptions;
              case DOUBLE:
                return migrationOptions;
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
                return migrationOptions;
              case FLOAT:
                return migrationOptions;
              case DOUBLE:
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkDateToBinary(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                int _sizeValue = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _sizeValue_1 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus = (10 + _sizeValue_1);
                boolean _greaterThan = (_sizeValue > _plus);
                if (_greaterThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                int _sizeValue_2 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _sizeValue_3 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus_1 = (8 + _sizeValue_3);
                boolean _greaterThan_1 = (_sizeValue_2 > _plus_1);
                if (_greaterThan_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                int _sizeValue_4 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _sizeValue_5 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus_2 = (20 + _sizeValue_5);
                boolean _greaterThan_2 = (_sizeValue_4 > _plus_2);
                if (_greaterThan_2) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                int _sizeValue_6 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _sizeValue_7 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _plus_3 = (20 + _sizeValue_7);
                boolean _greaterThan_3 = (_sizeValue_6 > _plus_3);
                if (_greaterThan_3) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                int _sizeValue_8 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_sizeValue_8 >= 4);
                if (_greaterEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkNumericToText(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objB.getType();
    if (_type != null) {
      switch (_type) {
        case TINYTEXT:
        case TEXT:
        case MEDIUMTEXT:
        case LONGTEXT:
          return migrationOptions;
        default:
          break;
      }
    }
    DataType _type_1 = objA.getType();
    if (_type_1 != null) {
      switch (_type_1) {
        case BIGINT:
          int _sizeValue = ColumnMigrationUtil.getSizeValue(objB.getSize());
          boolean _greaterEqualsThan = (_sizeValue >= 20);
          if (_greaterEqualsThan) {
            return migrationOptions;
          } else {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          }
          return migrationOptions;
        case INT:
        case INTEGER:
          int _sizeValue_1 = ColumnMigrationUtil.getSizeValue(objB.getSize());
          boolean _greaterEqualsThan_1 = (_sizeValue_1 >= 10);
          if (_greaterEqualsThan_1) {
            return migrationOptions;
          } else {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          }
          return migrationOptions;
        case MEDIUMINT:
          int _sizeValue_2 = ColumnMigrationUtil.getSizeValue(objB.getSize());
          boolean _greaterEqualsThan_2 = (_sizeValue_2 >= 8);
          if (_greaterEqualsThan_2) {
            return migrationOptions;
          } else {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          }
          return migrationOptions;
        case TINYINT:
          int _sizeValue_3 = ColumnMigrationUtil.getSizeValue(objB.getSize());
          boolean _greaterEqualsThan_3 = (_sizeValue_3 >= 3);
          if (_greaterEqualsThan_3) {
            return migrationOptions;
          } else {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          }
          return migrationOptions;
        case SMALLINT:
          int _sizeValue_4 = ColumnMigrationUtil.getSizeValue(objB.getSize());
          boolean _greaterEqualsThan_4 = (_sizeValue_4 >= 5);
          if (_greaterEqualsThan_4) {
            return migrationOptions;
          } else {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          }
          return migrationOptions;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkNumericToDate(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BIGINT:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case DATE:
                return migrationOptions;
              case TIME:
                return migrationOptions;
              case TIMESTAMP:
                return migrationOptions;
              case DATETIME:
                return migrationOptions;
              case YEAR:
                return migrationOptions;
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
                return migrationOptions;
              case TIME:
                return migrationOptions;
              case TIMESTAMP:
                return migrationOptions;
              case DATETIME:
                return migrationOptions;
              case YEAR:
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TIME:
                break;
              case TIMESTAMP:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case DATETIME:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TIME:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TIMESTAMP:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case DATETIME:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case YEAR:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TIME:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TIMESTAMP:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case DATETIME:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case YEAR:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkNumericToNumeric(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case MEDIUMINT:
              case SMALLINT:
              case TINYINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case TINYINT:
              case SMALLINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
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
                return migrationOptions;
              case TINYINT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkNumericToDecimal(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objB.getType();
    if (_type != null) {
      switch (_type) {
        case FLOAT:
        case DOUBLE:
          return migrationOptions;
        default:
          break;
      }
    }
    DataType _type_1 = objA.getType();
    if (_type_1 != null) {
      switch (_type_1) {
        case BIGINT:
          int _decimalSizeValue = ColumnMigrationUtil.getDecimalSizeValue(objA.getSize());
          boolean _greaterEqualsThan = (_decimalSizeValue >= 20);
          if (_greaterEqualsThan) {
            return migrationOptions;
          } else {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          }
          return migrationOptions;
        case INT:
        case INTEGER:
          int _decimalSizeValue_1 = ColumnMigrationUtil.getDecimalSizeValue(objA.getSize());
          boolean _greaterEqualsThan_1 = (_decimalSizeValue_1 >= 10);
          if (_greaterEqualsThan_1) {
            return migrationOptions;
          } else {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          }
          return migrationOptions;
        case MEDIUMINT:
          int _decimalSizeValue_2 = ColumnMigrationUtil.getDecimalSizeValue(objA.getSize());
          boolean _greaterEqualsThan_2 = (_decimalSizeValue_2 >= 8);
          if (_greaterEqualsThan_2) {
            return migrationOptions;
          } else {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          }
          return migrationOptions;
        case TINYINT:
          int _decimalSizeValue_3 = ColumnMigrationUtil.getDecimalSizeValue(objA.getSize());
          boolean _greaterEqualsThan_3 = (_decimalSizeValue_3 >= 3);
          if (_greaterEqualsThan_3) {
            return migrationOptions;
          } else {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          }
          return migrationOptions;
        case SMALLINT:
          int _decimalSizeValue_4 = ColumnMigrationUtil.getDecimalSizeValue(objA.getSize());
          boolean _greaterEqualsThan_4 = (_decimalSizeValue_4 >= 5);
          if (_greaterEqualsThan_4) {
            return migrationOptions;
          } else {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          }
          return migrationOptions;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkNumericToBinary(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkDecimalToText(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
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
                return migrationOptions;
              case CHAR:
              case VARCHAR:
                int _decimalSizeValue = ColumnMigrationUtil.getDecimalSizeValue(objA.getSize());
                int _sizeValue = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_decimalSizeValue >= _sizeValue);
                if (_greaterEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
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
                return migrationOptions;
              case CHAR:
              case VARCHAR:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case CHAR:
              case VARCHAR:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkDecimalToDate(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.IGNORE, ColumnOptions.DELETE_ROW);
    Boolean _notNull = objB.getNotNull();
    boolean _not = (!(_notNull).booleanValue());
    if (_not) {
      CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.UPDATE_COLUMN_SET_TO_NULL);
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkDecimalToNumeric(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.IGNORE, ColumnOptions.DELETE_ROW);
    if (((objB.getDefaultValue() != null) && (!(objB.getUnique()).booleanValue()))) {
      CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
        ColumnOptions.UPDATE_COLUMN_SET_TO_DEFAULT, 
        ColumnOptions.UPDATE_ROW_SET_TO_DEFAULT);
    }
    Boolean _notNull = objB.getNotNull();
    boolean _not = (!(_notNull).booleanValue());
    if (_not) {
      CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
        ColumnOptions.UPDATE_COLUMN_SET_TO_NULL, 
        ColumnOptions.UPDATE_ROW_SET_TO_NULL);
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkDecimalToDecimal(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case DEC:
        case DECIMAL:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case FLOAT:
                int _decimalSizeValue = ColumnMigrationUtil.getDecimalSizeValue(objA.getSize());
                boolean _lessEqualsThan = (_decimalSizeValue <= 39);
                if (_lessEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case DOUBLE:
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case DOUBLE:
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case FLOAT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkDecimalToBinary(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                int _sizeValue = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _decimalSizeValue = ColumnMigrationUtil.getDecimalSizeValue(objA.getSize());
                boolean _greaterEqualsThan = (_sizeValue >= _decimalSizeValue);
                if (_greaterEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                int _sizeValue_1 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                int _decimalSizeValue_1 = ColumnMigrationUtil.getDecimalSizeValue(objA.getSize());
                boolean _greaterEqualsThan_1 = (_sizeValue_1 >= _decimalSizeValue_1);
                if (_greaterEqualsThan_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                int _sizeValue_2 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_2 = (_sizeValue_2 >= 65);
                if (_greaterEqualsThan_2) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
              case VARBINARY:
                int _sizeValue_3 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan_3 = (_sizeValue_3 >= 65);
                if (_greaterEqualsThan_3) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkBinaryToText(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BLOB:
          DataType _type_1 = objB.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case CHAR:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case VARCHAR:
                return migrationOptions;
              case TINYTEXT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return migrationOptions;
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
                int _sizeValue = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _equals = (_sizeValue == 255);
                if (_equals) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case VARCHAR:
              case TINYTEXT:
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case MEDIUMTEXT:
              case LONGTEXT:
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case LONGTEXT:
                return migrationOptions;
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
                int _sizeValue_1 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _equals_1 = (_sizeValue_1 == 255);
                if (_equals_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case VARCHAR:
                int _sizeValue_2 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _greaterEqualsThan = (_sizeValue_2 >= 255);
                if (_greaterEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TINYTEXT:
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return migrationOptions;
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
                int _sizeValue_3 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _sizeValue_4 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan = (_sizeValue_3 <= _sizeValue_4);
                if (_lessEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case VARCHAR:
                int _sizeValue_5 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                int _sizeValue_6 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _lessEqualsThan_1 = (_sizeValue_5 <= _sizeValue_6);
                if (_lessEqualsThan_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TINYTEXT:
                int _sizeValue_7 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_2 = (_sizeValue_7 <= 255);
                if (_lessEqualsThan_2) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case TEXT:
              case MEDIUMTEXT:
              case LONGTEXT:
                return migrationOptions;
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
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkBinaryToDate(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BLOB:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case TINYBLOB:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case MEDIUMBLOB:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case LONGBLOB:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case BINARY:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case VARBINARY:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case BIT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkBinaryToNumeric(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BLOB:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case TINYBLOB:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case MEDIUMBLOB:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case LONGBLOB:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case BINARY:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case VARBINARY:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        case BIT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkBinaryToDecimal(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
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
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
          return migrationOptions;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  public static List<ColumnOptions> checkBinaryToBinary(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case BLOB:
          DataType _type_1 = objA.getType();
          if (_type_1 != null) {
            switch (_type_1) {
              case TINYBLOB:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case MEDIUMBLOB:
              case LONGBLOB:
                return migrationOptions;
              case BINARY:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case VARBINARY:
                int _sizeValue = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _equals = (_sizeValue == 65535);
                if (_equals) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case BINARY:
                int _sizeValue_1 = ColumnMigrationUtil.getSizeValue(objB.getSize());
                boolean _equals_1 = (_sizeValue_1 == 255);
                if (_equals_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case VARBINARY:
                return migrationOptions;
              case BIT:
                int _sizeValue_2 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan = (_sizeValue_2 <= 1);
                if (_lessEqualsThan) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case TINYBLOB:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case LONGBLOB:
                return migrationOptions;
              case BINARY:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case VARBINARY:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
              case BIT:
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                return migrationOptions;
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
                return migrationOptions;
              case VARBINARY:
                return migrationOptions;
              case BIT:
                int _sizeValue_3 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_1 = (_sizeValue_3 <= 1);
                if (_lessEqualsThan_1) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
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
                return migrationOptions;
              case TINYBLOB:
                int _sizeValue_4 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_2 = (_sizeValue_4 <= 255);
                if (_lessEqualsThan_2) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case MEDIUMBLOB:
              case LONGBLOB:
                return migrationOptions;
              case BINARY:
                int _sizeValue_5 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_3 = (_sizeValue_5 <= 255);
                if (_lessEqualsThan_3) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
              case BIT:
                int _sizeValue_6 = ColumnMigrationUtil.getSizeValue(objA.getSize());
                boolean _lessEqualsThan_4 = (_sizeValue_6 <= 1);
                if (_lessEqualsThan_4) {
                  return migrationOptions;
                } else {
                  CollectionExtensions.<ColumnOptions>addAll(migrationOptions, ColumnOptions.values());
                }
                return migrationOptions;
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
                return migrationOptions;
              default:
                break;
            }
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  /**
   * Check whether the new column size is compatible. If the size is compatible, the method returns an empty list.
   */
  public static List<ColumnOptions> checkColumnSizeCompatibility(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    boolean _contains = ColumnMigrationUtil.typesWithoutSize.contains(objB.getType());
    if (_contains) {
      return migrationOptions;
    }
    int sizeA = 0;
    int sizeB = 0;
    boolean _contains_1 = ColumnMigrationUtil.decimalTypes.contains(objA.getType());
    if (_contains_1) {
      sizeA = ColumnMigrationUtil.getDecimalSizeValue(objA.getSize());
      sizeB = ColumnMigrationUtil.getDecimalSizeValue(objB.getSize());
    } else {
      sizeA = ColumnMigrationUtil.getSizeValue(objA.getSize());
      sizeB = ColumnMigrationUtil.getSizeValue(objB.getSize());
    }
    if ((sizeB > sizeA)) {
      return migrationOptions;
    }
    DataType _type = objA.getType();
    if (_type != null) {
      switch (_type) {
        case VARCHAR:
        case CHAR:
        case BINARY:
        case VARBINARY:
        case BLOB:
        case TEXT:
        case BIT:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
            ColumnOptions.IGNORE);
          if (((objB.getDefaultValue() != null) && (!(objB.getUnique()).booleanValue()))) {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
              ColumnOptions.UPDATE_COLUMN_SET_TO_DEFAULT, 
              ColumnOptions.UPDATE_ROW_SET_TO_DEFAULT);
          }
          Boolean _notNull = objB.getNotNull();
          boolean _not = (!(_notNull).booleanValue());
          if (_not) {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
              ColumnOptions.DELETE_ROW, 
              ColumnOptions.UPDATE_COLUMN_SET_TO_NULL, 
              ColumnOptions.UPDATE_ROW_SET_TO_NULL);
          }
          break;
        case DATETIME:
        case TIME:
        case TIMESTAMP:
          break;
        case DEC:
        case DECIMAL:
          CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
            ColumnOptions.IGNORE);
          if (((objB.getDefaultValue() != null) && (!(objB.getUnique()).booleanValue()))) {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
              ColumnOptions.UPDATE_COLUMN_SET_TO_DEFAULT, 
              ColumnOptions.UPDATE_ROW_SET_TO_DEFAULT);
          }
          Boolean _notNull_1 = objB.getNotNull();
          boolean _not_1 = (!(_notNull_1).booleanValue());
          if (_not_1) {
            CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
              ColumnOptions.DELETE_ROW, 
              ColumnOptions.UPDATE_COLUMN_SET_TO_NULL, 
              ColumnOptions.UPDATE_ROW_SET_TO_NULL);
          }
          break;
        default:
          break;
      }
    }
    return migrationOptions;
  }

  /**
   * Check whether the column has only unique values. If the size is compatible, the method returns an empty list.
   */
  public static List<ColumnOptions> checkColumnUniqueCompatibility(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    Boolean _unique = objB.getUnique();
    boolean _not = (!(_unique).booleanValue());
    if (_not) {
      return migrationOptions;
    } else {
      CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
        ColumnOptions.IGNORE);
      Boolean _notNull = objB.getNotNull();
      boolean _not_1 = (!(_notNull).booleanValue());
      if (_not_1) {
        CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
          ColumnOptions.DELETE_ROW, 
          ColumnOptions.UPDATE_COLUMN_SET_TO_NULL, 
          ColumnOptions.UPDATE_ROW_SET_TO_NULL);
      }
    }
    return migrationOptions;
  }

  /**
   * Check whether the column has only unique values. If the size is compatible, the method returns an empty list.
   */
  public static List<ColumnOptions> checkColumnNotNullCompatibility(final Column objA, final Column objB) {
    List<ColumnOptions> migrationOptions = new ArrayList<ColumnOptions>();
    Boolean _notNull = objB.getNotNull();
    boolean _not = (!(_notNull).booleanValue());
    if (_not) {
      return migrationOptions;
    } else {
      CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
        ColumnOptions.IGNORE, 
        ColumnOptions.DELETE_ROW);
      String _defaultValue = objB.getDefaultValue();
      boolean _tripleNotEquals = (_defaultValue != null);
      if (_tripleNotEquals) {
        CollectionExtensions.<ColumnOptions>addAll(migrationOptions, 
          ColumnOptions.UPDATE_COLUMN_SET_TO_DEFAULT, 
          ColumnOptions.UPDATE_ROW_SET_TO_DEFAULT);
      }
    }
    return migrationOptions;
  }
}
