package de.thm.xtend;

import com.google.common.collect.Iterables;
import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.migration.ColumnOptions;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.evolvedb.migration.ProcessStatus;
import de.thm.evolvedb.migration.ResolvableOperator;
import de.thm.mdde.migration.util.ColumnMigrationUtil;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;

@SuppressWarnings("all")
public class SET_ATTRIBUTE {
  public static String _SET_ATTRIBUTE_PrimaryKey_PrimaryKey(final SemanticChangeSet set) {
    return null;
  }

  public static String _SET_ATTRIBUTE_NamedElement_Name(final ResolvableOperator resolvableOperator) {
    if (((resolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (resolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet rename = resolvableOperator.getSemanticChangeSets().get(0);
      return SET_ATTRIBUTE._SET_ATTRIBUTE_NamedElement_Name2(rename);
    }
    return "";
  }

  /**
   * SMO Change Name
   */
  public static String _SET_ATTRIBUTE_NamedElement_Name2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof AttributeValueChange));
    };
    Change _findFirst = IterableExtensions.<Change>findFirst(set.getChanges(), _function);
    AttributeValueChange ad = ((AttributeValueChange) _findFirst);
    if ((ad == null)) {
      return "";
    }
    String content = "";
    EObject _objB = ad.getObjB();
    if ((_objB instanceof Column)) {
      if (((ad.getObjA() instanceof ForeignKey) && (ad.getObjB() instanceof ForeignKey))) {
        EObject _objA = ad.getObjA();
        ForeignKey objA = ((ForeignKey) _objA);
        EObject _objB_1 = ad.getObjB();
        ForeignKey objB = ((ForeignKey) _objB_1);
        String _content = content;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("-- Change name of foriegn key �objA.name.toLowerCase� ");
        _builder.newLine();
        _builder.append("ALTER TABLE `�objA.table.name.toLowerCase�` ");
        _builder.newLine();
        _builder.append("DROP FOREIGN KEY `�objA.constraintName�`;");
        _builder.newLine();
        _builder.append("ALTER TABLE `�objA.table.name.toLowerCase�` ");
        _builder.newLine();
        _builder.append("CHANGE COLUMN `�objA.name.toUpperCase�` `�objB.name.toUpperCase�` �objA.type.getName��ColumnUtil.getSizeString(objA)� �objA.notNull !== null && objA.notNull ? \"NOT NULL\" : \"NULL\"� ;");
        _builder.newLine();
        _builder.append("ALTER TABLE `�objA.table.name.toLowerCase�` ");
        _builder.newLine();
        _builder.append("ADD CONSTRAINT `�objA.constraintName�`");
        _builder.newLine();
        _builder.append("FOREIGN KEY (`�objB.name.toUpperCase�`)");
        _builder.newLine();
        _builder.append("REFERENCES `�objB.referencedTable.name.toLowerCase�` (`�objB.referencedKeyColumn.name�`);");
        _builder.newLine();
        content = (_content + _builder);
      } else {
        if (((ad.getObjA() instanceof PrimaryKey) && (ad.getObjB() instanceof PrimaryKey))) {
          EObject _objA_1 = ad.getObjA();
          PrimaryKey objA_1 = ((PrimaryKey) _objA_1);
          EObject _objB_2 = ad.getObjB();
          PrimaryKey objB_1 = ((PrimaryKey) _objB_2);
          int _size = objA_1.getReferencedBy().size();
          boolean _equals = (_size == 0);
          if (_equals) {
            String _content_1 = content;
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("-- Change name of primaryKey �objA.name.toLowerCase� \t\t\t\t");
            _builder_1.newLine();
            _builder_1.append("ALTER TABLE �objB.table.name.toLowerCase� ");
            _builder_1.newLine();
            _builder_1.append("CHANGE COLUMN `�objA.name.toUpperCase�` `�objB.name.toUpperCase�` �objA.type.getName��ColumnUtil.getSizeString(objA)� �objA.notNull !== null && objA.notNull ? \"NOT NULL\" : \"NULL\"� ;");
            _builder_1.newLine();
            content = (_content_1 + _builder_1);
          } else {
            String _content_2 = content;
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("-- Change name of primaryKey �objA.name.toLowerCase�");
            _builder_2.newLine();
            _builder_2.append("-- Delete existing foreign key constraints");
            _builder_2.newLine();
            _builder_2.append("�FOR ForeignKey foreignKey : objA.referencedBy�");
            _builder_2.newLine();
            _builder_2.append("\t");
            _builder_2.append("ALTER TABLE `�foreignKey.table.name.toLowerCase�` ");
            _builder_2.newLine();
            _builder_2.append("\t");
            _builder_2.append("DROP FOREIGN KEY `�foreignKey.constraintName�`;");
            _builder_2.newLine();
            _builder_2.append("�ENDFOR�");
            _builder_2.newLine();
            _builder_2.append("ALTER TABLE �objB.table.name.toLowerCase� ");
            _builder_2.newLine();
            _builder_2.append("CHANGE COLUMN `�objA.name.toUpperCase�` `�objB.name.toUpperCase�` �objA.type.getName��ColumnUtil.getSizeString(objA)� �objA.notNull !== null && objA.notNull ? \"NOT NULL\" : \"NULL\"� ;");
            _builder_2.newLine();
            _builder_2.append("-- Recreate foreign key constraints");
            _builder_2.newLine();
            _builder_2.append("�FOR ForeignKey foreignKey : objA.referencedBy�");
            _builder_2.newLine();
            _builder_2.append("\t");
            _builder_2.append("ALTER TABLE `�foreignKey.table.name.toLowerCase�` ");
            _builder_2.newLine();
            _builder_2.append("\t");
            _builder_2.append("ADD CONSTRAINT `�foreignKey.constraintName�`");
            _builder_2.newLine();
            _builder_2.append("\t");
            _builder_2.append("FOREIGN KEY (`�foreignKey.name.toUpperCase�`)");
            _builder_2.newLine();
            _builder_2.append("\t");
            _builder_2.append("REFERENCES `�objB.table.name.toLowerCase�` (`�objB.name.toUpperCase�`);");
            _builder_2.newLine();
            _builder_2.append("�ENDFOR�");
            _builder_2.newLine();
            content = (_content_2 + _builder_2);
          }
        } else {
          if (((ad.getObjA() instanceof Column) && (ad.getObjB() instanceof Column))) {
            EObject _objA_2 = ad.getObjA();
            Column objA_2 = ((Column) _objA_2);
            EObject _objB_3 = ad.getObjB();
            Column objB_2 = ((Column) _objB_3);
            String _content_3 = content;
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("-- Change name of �objA.name.toLowerCase� ");
            _builder_3.newLine();
            _builder_3.append("ALTER TABLE `�objA.table.name.toLowerCase�` ");
            _builder_3.newLine();
            _builder_3.append("CHANGE COLUMN `�objA.name.toUpperCase�` `�objB.name.toUpperCase�` �objA.type.getName��ColumnUtil.getSizeString(objA)� ");
            _builder_3.newLine();
            _builder_3.append("�objA.notNull !== null && objA.notNull ? \"NULL\" : \"NOT NULL\"� �objA.autoIncrement !== null && objA.autoIncrement ? \"AUTO_INCREMENT\" : \"\"�");
            _builder_3.newLine();
            _builder_3.append("�ColumnUtil.getDefaultValueString(objA)� ;");
            _builder_3.newLine();
            content = (_content_3 + _builder_3);
          }
        }
      }
    } else {
      EObject _objB_4 = ad.getObjB();
      if ((_objB_4 instanceof Table)) {
        if (((ad.getObjA() instanceof Table) && (ad.getObjB() instanceof Table))) {
          EObject _objA_3 = ad.getObjA();
          Table objA_3 = ((Table) _objA_3);
          EObject _objB_5 = ad.getObjB();
          Table objB_3 = ((Table) _objB_5);
          String _content_4 = content;
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("-- Change name of �objA.name.toLowerCase� ");
          _builder_4.newLine();
          _builder_4.append("ALTER TABLE �objA.name.toLowerCase� RENAME TO �objB.name.toLowerCase�;");
          _builder_4.newLine();
          content = (_content_4 + _builder_4);
        }
      }
    }
    return content;
  }

  public static String _SET_ATTRIBUTE_ForeignKey_PrimaryForeignKey(final SemanticChangeSet set) {
    List<AttributeValueChange> makeColumnUniqe = IterableExtensions.<AttributeValueChange>toList(Iterables.<AttributeValueChange>filter(set.getChanges(), AttributeValueChange.class));
    String content = "";
    for (final AttributeValueChange a : makeColumnUniqe) {
      if (((a.getObjA() instanceof ForeignKey) && (a.getObjB() instanceof ForeignKey))) {
        EObject _objA = a.getObjA();
        ForeignKey objA = ((ForeignKey) _objA);
        EObject _objB = a.getObjB();
        ForeignKey objB = ((ForeignKey) _objB);
        Boolean _primaryForeignKey = objB.getPrimaryForeignKey();
        if ((_primaryForeignKey).booleanValue()) {
          String _content = content;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("-- Change primary foreign key attribute of �objB.name.toLowerCase� ");
          _builder.newLine();
          _builder.append("ALTER TABLE �objB.table.name.toLowerCase� ADD PRIMARY KEY (`�objB.name�`) ;");
          _builder.newLine();
          _builder.newLine();
          content = (_content + _builder);
        } else {
          Table parent = objB.getTable();
          final Function1<Column, Boolean> _function = (Column it) -> {
            return Boolean.valueOf((it instanceof ForeignKey));
          };
          List<Column> columns = IterableExtensions.<Column>toList(IterableExtensions.<Column>filter(parent.getColumns(), _function));
          ArrayList<ForeignKey> foreignKeys = new ArrayList<ForeignKey>();
          for (final Column element : columns) {
            {
              ForeignKey foreignKey = ((ForeignKey) element);
              Boolean _primaryForeignKey_1 = foreignKey.getPrimaryForeignKey();
              if ((_primaryForeignKey_1).booleanValue()) {
                foreignKeys.add(foreignKey);
              }
            }
          }
          String _content_1 = content;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("-- Change primary foreign key attribute of �objB.name.toLowerCase� ");
          _builder_1.newLine();
          _builder_1.append("ALTER TABLE �objA.table.name.toLowerCase� DROP PRIMARY KEY �IF foreignKeys.size > 0�,");
          _builder_1.newLine();
          _builder_1.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
          _builder_1.append("ADD PRIMARY KEY (`");
          _builder_1.newLine();
          _builder_1.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
          _builder_1.append("�FOR e : foreignKeys SEPARATOR \"`,`\"�");
          _builder_1.newLine();
          _builder_1.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
          _builder_1.append("�e.name�");
          _builder_1.newLine();
          _builder_1.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
          _builder_1.append("�ENDFOR�");
          _builder_1.newLine();
          _builder_1.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
          _builder_1.append("`");
          _builder_1.newLine();
          _builder_1.append("�ELSE�;�ENDIF�");
          _builder_1.newLine();
          content = (_content_1 + _builder_1);
        }
      } else {
      }
    }
    return content;
  }

  /**
   * Change the column size for text data types. If the data type is not a text type, the columns display value is changed.
   * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
   */
  public static String _SET_ATTRIBUTE_Column_Unique(final PartiallyResolvable partiallyResolvableOperator) {
    if (((partiallyResolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (partiallyResolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet setColumnSize = partiallyResolvableOperator.getSemanticChangeSets().get(0);
      return SET_ATTRIBUTE._SET_ATTRIBUTE_Column_Unique2(setColumnSize, partiallyResolvableOperator.getResolveOptions());
    }
    return "";
  }

  public static String _SET_ATTRIBUTE_Column_Unique2(final SemanticChangeSet set, final ColumnOptions columnOptions) {
    List<AttributeValueChange> makeColumnUniqe = IterableExtensions.<AttributeValueChange>toList(Iterables.<AttributeValueChange>filter(set.getChanges(), AttributeValueChange.class));
    String content = "";
    for (final AttributeValueChange a : makeColumnUniqe) {
      if (((a.getObjA() instanceof Table) && (a.getObjB() instanceof Table))) {
        EObject _objA = a.getObjA();
        Column objA = ((Column) _objA);
        EObject _objB = a.getObjB();
        Column objB = ((Column) _objB);
        Boolean _unique = objB.getUnique();
        if ((_unique).booleanValue()) {
          if (columnOptions != null) {
            switch (columnOptions) {
              case IGNORE:
                break;
              case DELETE_ROW:
                PrimaryKey key = objB.getTable().getMainPrimaryKey();
                String historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME, 
                  objB.getTable().getSchema(), objB.getTable(), key, SQLGenerator.TEMPORY_TABLE_NAME);
                String _content = content;
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("-- Set all values to null that violate the unique constraint");
                _builder.newLine();
                _builder.append("BEGIN;");
                _builder.newLine();
                _builder.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder.newLine();
                _builder.append("SET SQL_SAFE_UPDATES = 0;");
                _builder.newLine();
                _builder.append("DROP TEMPORARY TABLE IF EXISTS my_temp_table;");
                _builder.newLine();
                _builder.append("CREATE TEMPORARY TABLE my_temp_table");
                _builder.newLine();
                _builder.append("(SELECT �objB.name� FROM �objB.table.name.toLowerCase� ");
                _builder.newLine();
                _builder.append("GROUP BY �objB.name�");
                _builder.newLine();
                _builder.append("HAVING COUNT(�objB.name�) > 1);");
                _builder.newLine();
                _builder.newLine();
                _builder.append("DROP TEMPORARY TABLE IF EXISTS �SQLGenerator.TEMPORY_TABLE_NAME�;");
                _builder.newLine();
                _builder.append("CREATE TEMPORARY TABLE �SQLGenerator.TEMPORY_TABLE_NAME�");
                _builder.newLine();
                _builder.append("(SELECT �key.name� FROM �objB.table.name.toLowerCase� ");
                _builder.newLine();
                _builder.append("GROUP BY �objB.name�");
                _builder.newLine();
                _builder.append("HAVING COUNT(�objB.name�) > 1);");
                _builder.newLine();
                _builder.append("�historyInsert�");
                _builder.newLine();
                _builder.append("DELETE FROM �objB.table.name.toLowerCase� where �objB.name� IN (SELECT * from my_temp_table);");
                _builder.newLine();
                _builder.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder.newLine();
                _builder.append("COMMIT;");
                _builder.newLine();
                _builder.newLine();
                content = (_content + _builder);
                String _content_1 = content;
                String _deleteTemporaryTable = ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
                content = (_content_1 + _deleteTemporaryTable);
                String _content_2 = content;
                String _deleteTemporaryTable_1 = ColumnUtil.deleteTemporaryTable("my_temp_table");
                content = (_content_2 + _deleteTemporaryTable_1);
                break;
              case UPDATE_COLUMN_SET_TO_NULL:
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("�objB.name� is not null;");
                String whereClause = _builder_1.toString();
                String historyInsert_1 = ColumnUtil.createInsertColumnHistoryScript(
                  SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause);
                String _content_3 = content;
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("-- Set �objB.name.toLowerCase� values to null ");
                _builder_2.newLine();
                _builder_2.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder_2.newLine();
                _builder_2.append("SET SQL_SAFE_UPDATES = 0;");
                _builder_2.newLine();
                _builder_2.append("�historyInsert�");
                _builder_2.newLine();
                _builder_2.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = null;");
                _builder_2.newLine();
                _builder_2.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder_2.newLine();
                _builder_2.append("COMMIT;");
                _builder_2.newLine();
                _builder_2.append("-- If executing the script fails, we suggest a rollback.");
                _builder_2.newLine();
                _builder_2.newLine();
                content = (_content_3 + _builder_2);
                break;
              case UPDATE_ROW_SET_TO_NULL:
                PrimaryKey key_1 = objB.getTable().getMainPrimaryKey();
                String historyInsert_2 = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME, 
                  objB.getTable().getSchema(), objB.getTable(), key_1, SQLGenerator.TEMPORY_TABLE_NAME);
                String _content_4 = content;
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("-- Set all values to null that violate the unique constraint");
                _builder_3.newLine();
                _builder_3.append("BEGIN;");
                _builder_3.newLine();
                _builder_3.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder_3.newLine();
                _builder_3.append("SET SQL_SAFE_UPDATES = 0;");
                _builder_3.newLine();
                _builder_3.append("DROP TEMPORARY TABLE IF EXISTS my_temp_table;");
                _builder_3.newLine();
                _builder_3.append("CREATE TEMPORARY TABLE my_temp_table");
                _builder_3.newLine();
                _builder_3.append("(SELECT �objA.name� FROM �objA.table.name.toLowerCase� ");
                _builder_3.newLine();
                _builder_3.append("GROUP BY �objA.name�");
                _builder_3.newLine();
                _builder_3.append("HAVING COUNT(�objA.name�) > 1);");
                _builder_3.newLine();
                _builder_3.newLine();
                _builder_3.append("DROP TEMPORARY TABLE IF EXISTS �SQLGenerator.TEMPORY_TABLE_NAME�;");
                _builder_3.newLine();
                _builder_3.append("CREATE TEMPORARY TABLE �SQLGenerator.TEMPORY_TABLE_NAME�");
                _builder_3.newLine();
                _builder_3.append("(SELECT �key.name� FROM �objB.table.name.toLowerCase� ");
                _builder_3.newLine();
                _builder_3.append("GROUP BY �objB.name�");
                _builder_3.newLine();
                _builder_3.append("HAVING COUNT(�objB.name�) > 1);");
                _builder_3.newLine();
                _builder_3.append("�historyInsert�");
                _builder_3.newLine();
                _builder_3.newLine();
                _builder_3.newLine();
                _builder_3.append("UPDATE �objA.table.name.toLowerCase� SET �objA.name� = null where �objA.name� IN (SELECT * from my_temp_table);");
                _builder_3.newLine();
                _builder_3.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder_3.newLine();
                _builder_3.append("COMMIT;");
                _builder_3.newLine();
                _builder_3.newLine();
                content = (_content_4 + _builder_3);
                String _content_5 = content;
                String _deleteTemporaryTable_2 = ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
                content = (_content_5 + _deleteTemporaryTable_2);
                String _content_6 = content;
                String _deleteTemporaryTable_3 = ColumnUtil.deleteTemporaryTable("my_temp_table");
                content = (_content_6 + _deleteTemporaryTable_3);
                break;
              default:
                break;
            }
          }
          String _upperCase = objB.getTable().getName().toUpperCase();
          String constraintName = (_upperCase + "_UNIQUE");
          if (((objB.getUniqueConstraintName() != null) && (!objB.getUniqueConstraintName().equals("")))) {
            constraintName = objB.getUniqueConstraintName();
          }
          String _content_7 = content;
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("-- Change uniqe attribute of �objA.name.toLowerCase� ");
          _builder_4.newLine();
          _builder_4.append("ALTER TABLE �objA.table.name.toLowerCase� ADD UNIQUE INDEX `�constraintName�` (`�objB.name�` ASC) VISIBLE;");
          _builder_4.newLine();
          content = (_content_7 + _builder_4);
        } else {
          String _content_8 = content;
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("-- Change uniqe attribute of �objA.name.toLowerCase� ");
          _builder_5.newLine();
          _builder_5.append("ALTER TABLE �objA.table.name.toLowerCase� DROP INDEX `�objB.uniqueConstraintName�`;");
          _builder_5.newLine();
          content = (_content_8 + _builder_5);
        }
      }
    }
    return content;
  }

  /**
   * Change the column type.
   * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
   */
  public static String _SET_ATTRIBUTE_Column_Type(final PartiallyResolvable partiallyResolvableOperator) {
    if (((partiallyResolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (partiallyResolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet setColumnType = partiallyResolvableOperator.getSemanticChangeSets().get(0);
      return SET_ATTRIBUTE._SET_ATTRIBUTE_Column_Type_2(setColumnType, partiallyResolvableOperator.getResolveOptions());
    }
    return "";
  }

  public static String _SET_ATTRIBUTE_Column_Type_2(final SemanticChangeSet set, final ColumnOptions resolveOption) {
    List<AttributeValueChange> changeColumnType = IterableExtensions.<AttributeValueChange>toList(Iterables.<AttributeValueChange>filter(set.getChanges(), AttributeValueChange.class));
    String content = "";
    for (final AttributeValueChange a : changeColumnType) {
      {
        if (((a.getObjA() instanceof Column) && (a.getObjB() instanceof Column))) {
          EObject _objA = a.getObjA();
          Column objA = ((Column) _objA);
          EObject _objB = a.getObjB();
          Column objB = ((Column) _objB);
          if (resolveOption != null) {
            switch (resolveOption) {
              case IGNORE:
                break;
              case DELETE_ROW:
                PrimaryKey key = objB.getTable().getMainPrimaryKey();
                String whereClause = ColumnUtil.getRegexStringForWhereClause(objA, objB, key);
                String historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME, 
                  objB.getTable().getSchema(), objB.getTable(), key, SQLGenerator.TEMPORY_TABLE_NAME);
                String _content = content;
                String _createTemporaryTable = ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.getTable().getSchema(), 
                  objB.getTable(), objB.getTable().getMainPrimaryKey(), whereClause);
                content = (_content + _createTemporaryTable);
                String _content_1 = content;
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("-- Set �objB.name.toLowerCase� values to null");
                _builder.newLine();
                _builder.append("BEGIN; ");
                _builder.newLine();
                _builder.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder.newLine();
                _builder.append("SET SQL_SAFE_UPDATES = 0;");
                _builder.newLine();
                _builder.append("�historyInsert�");
                _builder.newLine();
                _builder.append("DELETE FROM `�objB.table.name�` where �key.name� in (Select �key.name� from �SQLGenerator.TEMPORY_TABLE_NAME�);");
                _builder.newLine();
                _builder.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder.newLine();
                _builder.append("COMMIT;");
                _builder.newLine();
                _builder.append("-- If executing the script fails, we suggest a rollback.");
                _builder.newLine();
                content = (_content_1 + _builder);
                String _content_2 = content;
                String _deleteTemporaryTable = ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
                content = (_content_2 + _deleteTemporaryTable);
                break;
              case UPDATE_ROW_SET_TO_DEFAULT:
                PrimaryKey key_1 = objB.getTable().getMainPrimaryKey();
                String whereClause_1 = ColumnUtil.getRegexStringForWhereClause(objA, objB, key_1);
                String historyInsert_1 = ColumnUtil.createInsertColumnHistoryScript(
                  SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause_1);
                String _content_3 = content;
                String _createTemporaryTable_1 = ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.getTable().getSchema(), 
                  objB.getTable(), objB.getTable().getMainPrimaryKey(), whereClause_1);
                content = (_content_3 + _createTemporaryTable_1);
                String _content_4 = content;
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("-- Set �objB.name.toLowerCase� values to null");
                _builder_1.newLine();
                _builder_1.append("BEGIN; ");
                _builder_1.newLine();
                _builder_1.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder_1.newLine();
                _builder_1.append("SET SQL_SAFE_UPDATES = 0;");
                _builder_1.newLine();
                _builder_1.append("�historyInsert�");
                _builder_1.newLine();
                _builder_1.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = �ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)� where �key.name� in (Select �key.name� from �SQLGenerator.TEMPORY_TABLE_NAME�);");
                _builder_1.newLine();
                _builder_1.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder_1.newLine();
                _builder_1.append("COMMIT;");
                _builder_1.newLine();
                _builder_1.append("-- If executing the script fails, we suggest a rollback.");
                _builder_1.newLine();
                content = (_content_4 + _builder_1);
                String _content_5 = content;
                String _deleteTemporaryTable_1 = ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
                content = (_content_5 + _deleteTemporaryTable_1);
                break;
              case UPDATE_ROW_SET_TO_NULL:
                PrimaryKey key_2 = objB.getTable().getMainPrimaryKey();
                String whereClause_2 = ColumnUtil.getRegexStringForWhereClause(objA, objB, key_2);
                String historyInsert_2 = ColumnUtil.createInsertColumnHistoryScript(
                  SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause_2);
                String _content_6 = content;
                String _createTemporaryTable_2 = ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.getTable().getSchema(), 
                  objB.getTable(), objB.getTable().getMainPrimaryKey(), whereClause_2);
                content = (_content_6 + _createTemporaryTable_2);
                String _content_7 = content;
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("-- Set �objB.name.toLowerCase� values to null");
                _builder_2.newLine();
                _builder_2.append("BEGIN; ");
                _builder_2.newLine();
                _builder_2.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder_2.newLine();
                _builder_2.append("SET SQL_SAFE_UPDATES = 0;");
                _builder_2.newLine();
                _builder_2.append("�historyInsert�");
                _builder_2.newLine();
                _builder_2.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = null where �key.name� in (Select �key.name� from �SQLGenerator.TEMPORY_TABLE_NAME�);");
                _builder_2.newLine();
                _builder_2.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder_2.newLine();
                _builder_2.append("COMMIT;");
                _builder_2.newLine();
                _builder_2.append("-- If executing the script fails, we suggest a rollback.");
                _builder_2.newLine();
                content = (_content_7 + _builder_2);
                String _content_8 = content;
                String _deleteTemporaryTable_2 = ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
                content = (_content_8 + _deleteTemporaryTable_2);
                break;
              case UPDATE_COLUMN_SET_TO_DEFAULT:
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("�objB.name� is not null;");
                String whereClause_3 = _builder_3.toString();
                String historyInsert_3 = ColumnUtil.createInsertColumnHistoryScript(SQLGenerator.HISTORY_TABLE_NAME, 
                  objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause_3);
                String _content_9 = content;
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("-- Set �objB.name.toLowerCase� values to null");
                _builder_4.newLine();
                _builder_4.append("BEGIN; ");
                _builder_4.newLine();
                _builder_4.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder_4.newLine();
                _builder_4.append("SET SQL_SAFE_UPDATES = 0;");
                _builder_4.newLine();
                _builder_4.append("�historyInsert�");
                _builder_4.newLine();
                _builder_4.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = �ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)�;");
                _builder_4.newLine();
                _builder_4.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder_4.newLine();
                _builder_4.append("COMMIT;");
                _builder_4.newLine();
                _builder_4.append("-- If executing the script fails, we suggest a rollback.");
                _builder_4.newLine();
                content = (_content_9 + _builder_4);
                break;
              case UPDATE_COLUMN_SET_TO_NULL:
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("�objB.name� is not null;");
                String whereClause_4 = _builder_5.toString();
                String historyInsert_4 = ColumnUtil.createInsertColumnHistoryScript(SQLGenerator.HISTORY_TABLE_NAME, 
                  objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause_4);
                String _content_10 = content;
                StringConcatenation _builder_6 = new StringConcatenation();
                _builder_6.append("-- Set �objB.name.toLowerCase� values to null ");
                _builder_6.newLine();
                _builder_6.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder_6.newLine();
                _builder_6.append("SET SQL_SAFE_UPDATES = 0;");
                _builder_6.newLine();
                _builder_6.append("�historyInsert�");
                _builder_6.newLine();
                _builder_6.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = null;");
                _builder_6.newLine();
                _builder_6.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder_6.newLine();
                _builder_6.append("COMMIT;");
                _builder_6.newLine();
                _builder_6.append("-- If executing the script fails, we suggest a rollback.");
                _builder_6.newLine();
                _builder_6.newLine();
                content = (_content_10 + _builder_6);
                break;
              default:
                break;
            }
          }
          String _content_11 = content;
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("-- Change column type of �objB.name.toLowerCase� ");
          _builder_7.newLine();
          _builder_7.append("ALTER TABLE `�objB.table.name.toLowerCase�` CHANGE COLUMN `�objB.name�` `�objB.name�` �objB.type��ColumnUtil.getSizeString(objB)� �IF objA.notNull�NOT NULL�ELSE�NULL�ENDIF� �ColumnUtil.getDefaultValueString(objB)� ;");
          _builder_7.newLine();
          content = (_content_11 + _builder_7);
        }
        return content;
      }
    }
    return null;
  }

  /**
   * Change the column size for text data types.
   * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
   */
  public static String _SET_ATTRIBUTE_Column_Size(final PartiallyResolvable partiallyResolvableOperator) {
    if (((partiallyResolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (partiallyResolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet setColumnSize = partiallyResolvableOperator.getSemanticChangeSets().get(0);
      return SET_ATTRIBUTE._SET_ATTRIBUTE_Column_Size2(setColumnSize, partiallyResolvableOperator.getResolveOptions());
    }
    return "";
  }

  public static String _SET_ATTRIBUTE_Column_Size2(final SemanticChangeSet set, final ColumnOptions columnOptions) {
    List<AttributeValueChange> changeColumnType = IterableExtensions.<AttributeValueChange>toList(Iterables.<AttributeValueChange>filter(set.getChanges(), AttributeValueChange.class));
    String content = "";
    for (final AttributeValueChange a : changeColumnType) {
      if (((a.getObjA() instanceof Column) && (a.getObjB() instanceof Column))) {
        EObject _objA = a.getObjA();
        Column objA = ((Column) _objA);
        EObject _objB = a.getObjB();
        Column objB = ((Column) _objB);
        int _size = ColumnMigrationUtil.checkColumnSizeCompatibility(objA, objB).size();
        boolean compatibility = (_size == 0);
        int sizeA = 0;
        int sizeB = 0;
        String _size_1 = objA.getSize();
        boolean _tripleNotEquals = (_size_1 != null);
        if (_tripleNotEquals) {
          int _xifexpression = (int) 0;
          boolean _contains = ColumnUtil.decimalTypes.contains(objA.getType());
          if (_contains) {
            _xifexpression = ColumnUtil.getDecimalSizeValue(objA.getSize());
          } else {
            _xifexpression = ColumnUtil.getSizeValue(objA.getSize());
          }
          sizeA = _xifexpression;
        }
        String _size_2 = objB.getSize();
        boolean _tripleNotEquals_1 = (_size_2 != null);
        if (_tripleNotEquals_1) {
          int _xifexpression_1 = (int) 0;
          boolean _contains_1 = ColumnUtil.decimalTypes.contains(objB.getType());
          if (_contains_1) {
            _xifexpression_1 = ColumnUtil.getDecimalSizeValue(objB.getSize());
          } else {
            _xifexpression_1 = ColumnUtil.getSizeValue(objB.getSize());
          }
          sizeB = _xifexpression_1;
        }
        if (compatibility) {
          if (((ColumnUtil.textTypes.contains(objB.getType()) || ColumnUtil.binaryTypes.contains(objB.getType())) || 
            ColumnUtil.decimalTypes.contains(objB.getType()))) {
            if (columnOptions != null) {
              switch (columnOptions) {
                case IGNORE:
                  break;
                case DELETE_ROW:
                  PrimaryKey key = objB.getTable().getMainPrimaryKey();
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("LENGTH(�objB.name�) > �sizeB�;");
                  String whereClause = _builder.toString();
                  String historyInsert = ColumnUtil.createInsertRowHistoryScript(
                    SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB.getTable(), key, 
                    SQLGenerator.TEMPORY_TABLE_NAME);
                  String _content = content;
                  String _createTemporaryTable = ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.getTable().getSchema(), 
                    objB.getTable(), objB.getTable().getMainPrimaryKey(), whereClause);
                  content = (_content + _createTemporaryTable);
                  String _content_1 = content;
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append("-- delete �objB.name.toLowerCase� values which exceed the new column size");
                  _builder_1.newLine();
                  _builder_1.append("BEGIN; ");
                  _builder_1.newLine();
                  _builder_1.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                  _builder_1.newLine();
                  _builder_1.append("SET SQL_SAFE_UPDATES = 0;");
                  _builder_1.newLine();
                  _builder_1.append("�historyInsert�");
                  _builder_1.newLine();
                  _builder_1.append("DELETE FROM `�objB.table.name.toLowerCase�` WHERE �whereClause�");
                  _builder_1.newLine();
                  _builder_1.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                  _builder_1.newLine();
                  _builder_1.append("COMMIT;");
                  _builder_1.newLine();
                  _builder_1.append("-- If executing the script fails, we suggest a rollback.");
                  _builder_1.newLine();
                  content = (_content_1 + _builder_1);
                  String _content_2 = content;
                  String _deleteTemporaryTable = ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
                  content = (_content_2 + _deleteTemporaryTable);
                  break;
                case UPDATE_COLUMN_SET_TO_DEFAULT:
                  PrimaryKey key_1 = objB.getTable().getMainPrimaryKey();
                  StringConcatenation _builder_2 = new StringConcatenation();
                  _builder_2.append("�objB.name� is not null;");
                  String whereClause_1 = _builder_2.toString();
                  String historyInsert_1 = ColumnUtil.createInsertColumnHistoryScript(
                    SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, key_1, whereClause_1);
                  String _content_3 = content;
                  StringConcatenation _builder_3 = new StringConcatenation();
                  _builder_3.append("-- Set �objB.name.toLowerCase� values to null");
                  _builder_3.newLine();
                  _builder_3.append("BEGIN; ");
                  _builder_3.newLine();
                  _builder_3.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                  _builder_3.newLine();
                  _builder_3.append("SET SQL_SAFE_UPDATES = 0;");
                  _builder_3.newLine();
                  _builder_3.append("�historyInsert�");
                  _builder_3.newLine();
                  _builder_3.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = �ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)�;");
                  _builder_3.newLine();
                  _builder_3.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                  _builder_3.newLine();
                  _builder_3.append("COMMIT;");
                  _builder_3.newLine();
                  _builder_3.append("-- If executing the script fails, we suggest a rollback.");
                  _builder_3.newLine();
                  content = (_content_3 + _builder_3);
                  break;
                case UPDATE_COLUMN_SET_TO_NULL:
                  PrimaryKey key_2 = objB.getTable().getMainPrimaryKey();
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append("�objB.name� is not null;");
                  String whereClause_2 = _builder_4.toString();
                  String historyInsert_2 = ColumnUtil.createInsertColumnHistoryScript(
                    SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, key_2, whereClause_2);
                  String _content_4 = content;
                  StringConcatenation _builder_5 = new StringConcatenation();
                  _builder_5.append("-- Set �objB.name.toLowerCase� values to null ");
                  _builder_5.newLine();
                  _builder_5.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                  _builder_5.newLine();
                  _builder_5.append("SET SQL_SAFE_UPDATES = 0;");
                  _builder_5.newLine();
                  _builder_5.append("�historyInsert�");
                  _builder_5.newLine();
                  _builder_5.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = null;");
                  _builder_5.newLine();
                  _builder_5.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                  _builder_5.newLine();
                  _builder_5.append("COMMIT;");
                  _builder_5.newLine();
                  _builder_5.append("-- If executing the script fails, we suggest a rollback.");
                  _builder_5.newLine();
                  _builder_5.newLine();
                  content = (_content_4 + _builder_5);
                  break;
                case UPDATE_ROW_SET_TO_NULL:
                  PrimaryKey key_3 = objB.getTable().getMainPrimaryKey();
                  StringConcatenation _builder_6 = new StringConcatenation();
                  _builder_6.append("WHERE LENGTH(�objB.name�) > �sizeB�;");
                  String whereClause_3 = _builder_6.toString();
                  String historyInsert_3 = ColumnUtil.createInsertColumnHistoryScript(
                    SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, key_3, whereClause_3);
                  String _content_5 = content;
                  StringConcatenation _builder_7 = new StringConcatenation();
                  _builder_7.append("-- Set �objB.name.toLowerCase� values to null");
                  _builder_7.newLine();
                  _builder_7.append("BEGIN; ");
                  _builder_7.newLine();
                  _builder_7.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                  _builder_7.newLine();
                  _builder_7.append("SET SQL_SAFE_UPDATES = 0;");
                  _builder_7.newLine();
                  _builder_7.append("�historyInsert�");
                  _builder_7.newLine();
                  _builder_7.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = null WHERE LENGTH(�objB.name�) > �sizeB�;");
                  _builder_7.newLine();
                  _builder_7.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                  _builder_7.newLine();
                  _builder_7.append("COMMIT;");
                  _builder_7.newLine();
                  _builder_7.append("-- If executing the script fails, we suggest a rollback.");
                  _builder_7.newLine();
                  content = (_content_5 + _builder_7);
                  break;
                case UPDATE_ROW_SET_TO_DEFAULT:
                  PrimaryKey key_4 = objB.getTable().getMainPrimaryKey();
                  StringConcatenation _builder_8 = new StringConcatenation();
                  _builder_8.append("WHERE LENGTH(�objB.name�) > �sizeB�;");
                  String whereClause_4 = _builder_8.toString();
                  String historyInsert_4 = ColumnUtil.createInsertColumnHistoryScript(
                    SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, key_4, whereClause_4);
                  String _content_6 = content;
                  StringConcatenation _builder_9 = new StringConcatenation();
                  _builder_9.append("-- Set �objB.name.toLowerCase� values to null");
                  _builder_9.newLine();
                  _builder_9.append("BEGIN; ");
                  _builder_9.newLine();
                  _builder_9.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                  _builder_9.newLine();
                  _builder_9.append("SET SQL_SAFE_UPDATES = 0;");
                  _builder_9.newLine();
                  _builder_9.append("�historyInsert�");
                  _builder_9.newLine();
                  _builder_9.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = �ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)� WHERE LENGTH(�objB.name�) > �sizeB�;");
                  _builder_9.newLine();
                  _builder_9.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                  _builder_9.newLine();
                  _builder_9.append("COMMIT;");
                  _builder_9.newLine();
                  _builder_9.append("-- If executing the script fails, we suggest a rollback.");
                  _builder_9.newLine();
                  content = (_content_6 + _builder_9);
                  break;
                default:
                  break;
              }
            }
            String _content_7 = content;
            StringConcatenation _builder_10 = new StringConcatenation();
            _builder_10.append("-- Change column size of �objB.name.toLowerCase� ");
            _builder_10.newLine();
            _builder_10.append("ALTER TABLE `�objB.table.name.toLowerCase�` CHANGE COLUMN `�objB.name�` `�objB.name�` �objB.type��ColumnUtil.getSizeString(objB)� �IF objB.notNull�NOT NULL�ELSE�NULL�ENDIF� �ColumnUtil.getDefaultValueString(objB)� ;");
            _builder_10.newLine();
            content = (_content_7 + _builder_10);
          } else {
            boolean _contains_2 = ColumnUtil.dateTypesWithFraction.contains(objB.getType());
            if (_contains_2) {
              String _content_8 = content;
              StringConcatenation _builder_11 = new StringConcatenation();
              _builder_11.append("-- Change fraction digits of �objB.name.toLowerCase� ");
              _builder_11.newLine();
              _builder_11.append("ALTER TABLE `�objB.table.name.toLowerCase�` CHANGE COLUMN `�objB.name�` `�objB.name�` �objB.type��ColumnUtil.getSizeString(objB)� �IF objB.notNull�NOT NULL�ELSE�NULL�ENDIF� �ColumnUtil.getDefaultValueString(objB)� ;");
              _builder_11.newLine();
              content = (_content_8 + _builder_11);
            }
          }
        } else {
          String _content_9 = content;
          StringConcatenation _builder_12 = new StringConcatenation();
          _builder_12.append("-- Change size of �objB.name.toLowerCase� ");
          _builder_12.newLine();
          _builder_12.append("ALTER TABLE `�objB.table.name.toLowerCase�` CHANGE COLUMN `�objB.name�` `�objB.name�` �objB.type��ColumnUtil.getSizeString(objB)� �IF objB.notNull�NOT NULL�ELSE�NULL�ENDIF� �ColumnUtil.getDefaultValueString(objB)� ;");
          _builder_12.newLine();
          content = (_content_9 + _builder_12);
        }
        return content;
      }
    }
    return null;
  }

  /**
   * Change the column notNull value.
   * @param resolvableOperator The resolvable operator containing the necessary information.
   */
  public static String _SET_ATTRIBUTE_Column_NotNull(final PartiallyResolvable partiallyResolvableOperator) {
    if (((partiallyResolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (partiallyResolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet columnNotNull = partiallyResolvableOperator.getSemanticChangeSets().get(0);
      return SET_ATTRIBUTE._SET_ATTRIBUTE_Column_NotNull2(columnNotNull, partiallyResolvableOperator.getResolveOptions());
    }
    return "";
  }

  /**
   * Change the column default value. The operator is resolvable because the model is validated before executing
   * the operation.
   * @param resolvableOperator The resolvable operator containing the necessary information.
   */
  public static String _SET_ATTRIBUTE_Column_NotNull2(final SemanticChangeSet set, final ColumnOptions columnOptions) {
    List<AttributeValueChange> changeColumnType = IterableExtensions.<AttributeValueChange>toList(Iterables.<AttributeValueChange>filter(set.getChanges(), AttributeValueChange.class));
    String content = "";
    for (final AttributeValueChange a : changeColumnType) {
      if (((a.getObjA() instanceof Column) && (a.getObjB() instanceof Column))) {
        EObject _objA = a.getObjA();
        Column objA = ((Column) _objA);
        EObject _objB = a.getObjB();
        Column objB = ((Column) _objB);
        Boolean _notNull = objB.getNotNull();
        if ((_notNull).booleanValue()) {
          if (columnOptions != null) {
            switch (columnOptions) {
              case IGNORE:
                break;
              case DELETE_ROW:
                PrimaryKey key = objB.getTable().getMainPrimaryKey();
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("`�objB.name�` is NULL;");
                String whereClause = _builder.toString();
                String historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME, 
                  objB.getTable().getSchema(), objB.getTable(), key, SQLGenerator.TEMPORY_TABLE_NAME);
                String _content = content;
                String _createTemporaryTable = ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.getTable().getSchema(), 
                  objB.getTable(), objB.getTable().getMainPrimaryKey(), whereClause);
                content = (_content + _createTemporaryTable);
                String _content_1 = content;
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("-- Delete all rows with null values in the column �objB.name.toLowerCase�.");
                _builder_1.newLine();
                _builder_1.append("BEGIN;");
                _builder_1.newLine();
                _builder_1.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder_1.newLine();
                _builder_1.append("SET SQL_SAFE_UPDATES = 0;");
                _builder_1.newLine();
                _builder_1.append("�historyInsert�");
                _builder_1.newLine();
                _builder_1.append("DELETE FROM `�objB.table.name.toLowerCase�` where `�objB.name�` is NULL;");
                _builder_1.newLine();
                _builder_1.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder_1.newLine();
                _builder_1.append("COMMIT;");
                _builder_1.newLine();
                content = (_content_1 + _builder_1);
                String _content_2 = content;
                String _deleteTemporaryTable = ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
                content = (_content_2 + _deleteTemporaryTable);
                break;
              case UPDATE_COLUMN_SET_TO_DEFAULT:
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("�objB.name� is not null;");
                String whereClause_1 = _builder_2.toString();
                String historyInsert_1 = ColumnUtil.createInsertColumnHistoryScript(
                  SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause_1);
                String _content_3 = content;
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("-- Set all values in the column �objB.name.toLowerCase� to the default value.");
                _builder_3.newLine();
                _builder_3.append("BEGIN;");
                _builder_3.newLine();
                _builder_3.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder_3.newLine();
                _builder_3.append("SET SQL_SAFE_UPDATES = 0;");
                _builder_3.newLine();
                _builder_3.append("�historyInsert�");
                _builder_3.newLine();
                _builder_3.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = �ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)� ;");
                _builder_3.newLine();
                _builder_3.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder_3.newLine();
                _builder_3.append("COMMIT;");
                _builder_3.newLine();
                content = (_content_3 + _builder_3);
                break;
              case UPDATE_ROW_SET_TO_DEFAULT:
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("�objB.name� is not null;");
                String whereClause_2 = _builder_4.toString();
                String historyInsert_2 = ColumnUtil.createInsertColumnHistoryScript(
                  SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause_2);
                String _content_4 = content;
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("-- Set all null values in the column �objB.name.toLowerCase� to the default value.");
                _builder_5.newLine();
                _builder_5.append("BEGIN;");
                _builder_5.newLine();
                _builder_5.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                _builder_5.newLine();
                _builder_5.append("SET SQL_SAFE_UPDATES = 0;");
                _builder_5.newLine();
                _builder_5.append("�historyInsert�");
                _builder_5.newLine();
                _builder_5.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = �ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)� where `�objB.name�` is NULL;");
                _builder_5.newLine();
                _builder_5.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                _builder_5.newLine();
                _builder_5.append("COMMIT;");
                _builder_5.newLine();
                content = (_content_4 + _builder_5);
                break;
              default:
                break;
            }
          }
        }
        String _content_5 = content;
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("-- Change column not null of �objB.name.toLowerCase� ");
        _builder_6.newLine();
        _builder_6.append("ALTER TABLE `�objB.table.name.toLowerCase�` CHANGE COLUMN `�objB.name�` `�objB.name�` �objB.type��ColumnUtil.getSizeString(objB)� �IF objB.notNull�NOT NULL�ELSE�NULL�ENDIF� �ColumnUtil.getDefaultValueString(objB)� ;");
        _builder_6.newLine();
        content = (_content_5 + _builder_6);
        return content;
      }
    }
    return null;
  }

  /**
   * Change the onDelete and onUpdate Literal for a foreignKey constraint
   * @param resolvableOperator The resolvable operator containing the necessary information.
   */
  public static String _CHANGE_Literal_ForeignKey(final ResolvableOperator resolvableOperator) {
    if (((resolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (resolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet rename = resolvableOperator.getSemanticChangeSets().get(0);
      return SET_ATTRIBUTE._CHANGE_Literal_ForeignKey2(rename);
    }
    return "";
  }

  /**
   * Change the onDelete and onUpdate Literal for a foreignKey constraint
   * @param resolvableOperator The resolvable operator containing the necessary information.
   */
  public static String _CHANGE_Literal_ForeignKey2(final SemanticChangeSet set) {
    List<AttributeValueChange> changeLiteral = IterableExtensions.<AttributeValueChange>toList(Iterables.<AttributeValueChange>filter(set.getChanges(), AttributeValueChange.class));
    String content = "";
    for (final AttributeValueChange a : changeLiteral) {
      if (((a.getObjA() instanceof ForeignKey) && (a.getObjB() instanceof ForeignKey))) {
        EObject _objA = a.getObjA();
        ForeignKey objA = ((ForeignKey) _objA);
        EObject _objB = a.getObjB();
        ForeignKey objB = ((ForeignKey) _objB);
        String _content = content;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("-- change foreign key constraint �objB.name.toLowerCase�");
        _builder.newLine();
        _builder.append("ALTER TABLE `�objB.table.name.toLowerCase�` ");
        _builder.newLine();
        _builder.append("DROP FOREIGN KEY `�objA.constraintName�`;");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.newLine();
        _builder.append("-- Create foreign key in �objB.table.name.toLowerCase� ");
        _builder.newLine();
        _builder.append("ALTER TABLE `�objB.table.name.toLowerCase�` ");
        _builder.newLine();
        _builder.append("ADD CONSTRAINT `�objB.constraintName�`");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("FOREIGN KEY (`�objB.name.toUpperCase�`)");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("REFERENCES `�objB.referencedTable.name.toLowerCase�`(`�objB.referencedKeyColumn.name.toUpperCase�`)");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("ON DELETE �objB.onDelete.name()�");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("ON UPDATE �objB.onUpdate.name()�;");
        _builder.newLine();
        content = (_content + _builder);
        return content;
      }
    }
    return null;
  }

  /**
   * Change the column default value. The operator is resolvable because the model is validated before executing
   * the operation.
   * @param resolvableOperator The resolvable operator containing the necessary information.
   */
  public static String _SET_ATTRIBUTE_Column_DefaultValue(final ResolvableOperator resolvableOperator) {
    if (((resolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (resolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet defaultValue = resolvableOperator.getSemanticChangeSets().get(0);
      return SET_ATTRIBUTE._SET_ATTRIBUTE_Column_DefaultValue2(defaultValue);
    }
    return "";
  }

  /**
   * Change the column default value. The operator is resolvable because the model is validated before executing
   * the operation.
   * @param resolvableOperator The resolvable operator containing the necessary information.
   */
  public static String _SET_ATTRIBUTE_Column_DefaultValue2(final SemanticChangeSet set) {
    List<AttributeValueChange> changeColumnType = IterableExtensions.<AttributeValueChange>toList(Iterables.<AttributeValueChange>filter(set.getChanges(), AttributeValueChange.class));
    String content = "";
    for (final AttributeValueChange a : changeColumnType) {
      if (((a.getObjA() instanceof Column) && (a.getObjB() instanceof Column))) {
        EObject _objA = a.getObjA();
        Column objA = ((Column) _objA);
        EObject _objB = a.getObjB();
        Column objB = ((Column) _objB);
        String _content = content;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("-- Change default value of �objB.name.toLowerCase� ");
        _builder.newLine();
        _builder.append("ALTER TABLE `�objB.table.name.toLowerCase�` CHANGE COLUMN `�objB.name�` `�objB.name�` �objB.type��ColumnUtil.getSizeString(objB)� �IF objA.notNull�NOT NULL�ELSE�NULL�ENDIF� �ColumnUtil.getDefaultValueString(objB)� ;");
        _builder.newLine();
        content = (_content + _builder);
        return content;
      }
    }
    return null;
  }

  public static String _SET_ATTRIBUTE_Column_AutoIncrement(final SemanticChangeSet set) {
    return null;
  }

  public static String _SET_COLUMN_TYPE_AND_SIZE(final PartiallyResolvable resolvable) {
    ProcessStatus _processStatus = resolvable.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("SET_ATTRIBUTE_Column_Size_and_Type"));
      };
      SemanticChangeSet change = IterableExtensions.<SemanticChangeSet>findFirst(resolvable.getSemanticChangeSets(), _function);
      return SET_ATTRIBUTE._SET_COLUMN_TYPE_AND_SIZE2(change, resolvable.getResolveOptions());
    }
    return "";
  }

  /**
   * Change the column tape and size types.
   * @param set The SemanticChangeSet containing the necessary information.
   * @param resolveOption The selected resolve option. If none has been selected the default value is ignore.
   */
  public static String _SET_COLUMN_TYPE_AND_SIZE2(final SemanticChangeSet set, final ColumnOptions resolveOption) {
    List<AttributeValueChange> changeColumnType = IterableExtensions.<AttributeValueChange>toList(Iterables.<AttributeValueChange>filter(set.getChanges(), AttributeValueChange.class));
    String content = "";
    for (final AttributeValueChange a : changeColumnType) {
      {
        if (((a.getObjA() instanceof Column) && (a.getObjB() instanceof Column))) {
          EObject _objA = a.getObjA();
          Column objA = ((Column) _objA);
          EObject _objB = a.getObjB();
          Column objB = ((Column) _objB);
          boolean typeCompatibility = ColumnUtil.checkColumnTypeCompatibility(objA, objB);
          int _size = ColumnMigrationUtil.checkColumnSizeCompatibility(objA, objB).size();
          boolean sizeCompatibility = (_size == 0);
          if ((!(typeCompatibility && sizeCompatibility))) {
            if (resolveOption != null) {
              switch (resolveOption) {
                case IGNORE:
                  break;
                case DELETE_ROW:
                  PrimaryKey key = objB.getTable().getMainPrimaryKey();
                  String whereClause = ColumnUtil.getRegexStringForWhereClause(objA, objB, key);
                  String historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME, 
                    objB.getTable().getSchema(), objB.getTable(), key, SQLGenerator.TEMPORY_TABLE_NAME);
                  String _content = content;
                  String _createTemporaryTable = ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.getTable().getSchema(), 
                    objB.getTable(), objB.getTable().getMainPrimaryKey(), whereClause);
                  content = (_content + _createTemporaryTable);
                  String _content_1 = content;
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("-- Set �objB.name.toLowerCase� values to null");
                  _builder.newLine();
                  _builder.append("BEGIN; ");
                  _builder.newLine();
                  _builder.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                  _builder.newLine();
                  _builder.append("SET SQL_SAFE_UPDATES = 0;");
                  _builder.newLine();
                  _builder.append("�historyInsert�");
                  _builder.newLine();
                  _builder.append("DELETE FROM `�objB.table.name.toLowerCase�` where �key.name� in (Select �key.name� from �SQLGenerator.TEMPORY_TABLE_NAME�);");
                  _builder.newLine();
                  _builder.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                  _builder.newLine();
                  _builder.append("COMMIT;");
                  _builder.newLine();
                  _builder.append("-- If executing the script fails, we suggest a rollback.");
                  _builder.newLine();
                  content = (_content_1 + _builder);
                  String _content_2 = content;
                  String _deleteTemporaryTable = ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
                  content = (_content_2 + _deleteTemporaryTable);
                  break;
                case UPDATE_ROW_SET_TO_DEFAULT:
                  PrimaryKey key_1 = objB.getTable().getMainPrimaryKey();
                  String whereClause_1 = ColumnUtil.getRegexStringForWhereClause(objA, objB, key_1);
                  String historyInsert_1 = ColumnUtil.createInsertColumnHistoryScript(
                    SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause_1);
                  String _content_3 = content;
                  String _createTemporaryTable_1 = ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.getTable().getSchema(), 
                    objB.getTable(), objB.getTable().getMainPrimaryKey(), whereClause_1);
                  content = (_content_3 + _createTemporaryTable_1);
                  String _content_4 = content;
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append("-- Set �objB.name.toLowerCase� values to null");
                  _builder_1.newLine();
                  _builder_1.append("BEGIN; ");
                  _builder_1.newLine();
                  _builder_1.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                  _builder_1.newLine();
                  _builder_1.append("SET SQL_SAFE_UPDATES = 0;");
                  _builder_1.newLine();
                  _builder_1.append("�historyInsert�");
                  _builder_1.newLine();
                  _builder_1.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = �ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)� where �key.name� in (Select �key.name� from �SQLGenerator.TEMPORY_TABLE_NAME�);");
                  _builder_1.newLine();
                  _builder_1.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                  _builder_1.newLine();
                  _builder_1.append("COMMIT;");
                  _builder_1.newLine();
                  _builder_1.append("-- If executing the script fails, we suggest a rollback.");
                  _builder_1.newLine();
                  content = (_content_4 + _builder_1);
                  String _content_5 = content;
                  String _deleteTemporaryTable_1 = ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
                  content = (_content_5 + _deleteTemporaryTable_1);
                  break;
                case UPDATE_ROW_SET_TO_NULL:
                  PrimaryKey key_2 = objB.getTable().getMainPrimaryKey();
                  String whereClause_2 = ColumnUtil.getRegexStringForWhereClause(objA, objB, key_2);
                  String historyInsert_2 = ColumnUtil.createInsertColumnHistoryScript(
                    SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause_2);
                  String _content_6 = content;
                  String _createTemporaryTable_2 = ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.getTable().getSchema(), 
                    objB.getTable(), objB.getTable().getMainPrimaryKey(), whereClause_2);
                  content = (_content_6 + _createTemporaryTable_2);
                  String _content_7 = content;
                  StringConcatenation _builder_2 = new StringConcatenation();
                  _builder_2.append("-- Set �objB.name.toLowerCase� values to null");
                  _builder_2.newLine();
                  _builder_2.append("BEGIN; ");
                  _builder_2.newLine();
                  _builder_2.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                  _builder_2.newLine();
                  _builder_2.append("SET SQL_SAFE_UPDATES = 0;");
                  _builder_2.newLine();
                  _builder_2.append("�historyInsert�");
                  _builder_2.newLine();
                  _builder_2.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = null where �key.name� in (Select �key.name� from �SQLGenerator.TEMPORY_TABLE_NAME�);");
                  _builder_2.newLine();
                  _builder_2.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                  _builder_2.newLine();
                  _builder_2.append("COMMIT;");
                  _builder_2.newLine();
                  _builder_2.append("-- If executing the script fails, we suggest a rollback.");
                  _builder_2.newLine();
                  content = (_content_7 + _builder_2);
                  String _content_8 = content;
                  String _deleteTemporaryTable_2 = ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
                  content = (_content_8 + _deleteTemporaryTable_2);
                  break;
                case UPDATE_COLUMN_SET_TO_DEFAULT:
                  StringConcatenation _builder_3 = new StringConcatenation();
                  _builder_3.append("�objB.name� is not null;");
                  String whereClause_3 = _builder_3.toString();
                  String historyInsert_3 = ColumnUtil.createInsertColumnHistoryScript(
                    SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause_3);
                  String _content_9 = content;
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append("-- Set �objB.name.toLowerCase� values to null");
                  _builder_4.newLine();
                  _builder_4.append("BEGIN; ");
                  _builder_4.newLine();
                  _builder_4.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                  _builder_4.newLine();
                  _builder_4.append("SET SQL_SAFE_UPDATES = 0;");
                  _builder_4.newLine();
                  _builder_4.append("�historyInsert�");
                  _builder_4.newLine();
                  _builder_4.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = �ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)�;");
                  _builder_4.newLine();
                  _builder_4.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                  _builder_4.newLine();
                  _builder_4.append("COMMIT;");
                  _builder_4.newLine();
                  _builder_4.append("-- If executing the script fails, we suggest a rollback.");
                  _builder_4.newLine();
                  content = (_content_9 + _builder_4);
                  break;
                case UPDATE_COLUMN_SET_TO_NULL:
                  StringConcatenation _builder_5 = new StringConcatenation();
                  _builder_5.append("�objB.name� is not null;");
                  String whereClause_4 = _builder_5.toString();
                  String historyInsert_4 = ColumnUtil.createInsertColumnHistoryScript(
                    SQLGenerator.HISTORY_TABLE_NAME, objB.getTable().getSchema(), objB, objB.getTable().getMainPrimaryKey(), whereClause_4);
                  String _content_10 = content;
                  StringConcatenation _builder_6 = new StringConcatenation();
                  _builder_6.append("-- Set �objB.name.toLowerCase� values to null ");
                  _builder_6.newLine();
                  _builder_6.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
                  _builder_6.newLine();
                  _builder_6.append("SET SQL_SAFE_UPDATES = 0;");
                  _builder_6.newLine();
                  _builder_6.append("�historyInsert�");
                  _builder_6.newLine();
                  _builder_6.append("UPDATE `�objB.table.name.toLowerCase�` SET `�objB.name�` = null;");
                  _builder_6.newLine();
                  _builder_6.append("SET SQL_SAFE_UPDATES = @safe_mode;");
                  _builder_6.newLine();
                  _builder_6.append("COMMIT;");
                  _builder_6.newLine();
                  _builder_6.append("-- If executing the script fails, we suggest a rollback.");
                  _builder_6.newLine();
                  _builder_6.newLine();
                  content = (_content_10 + _builder_6);
                  break;
                default:
                  break;
              }
            }
          }
          String _content_11 = content;
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("-- Change column type and size of �objB.name.toLowerCase� ");
          _builder_7.newLine();
          _builder_7.append("ALTER TABLE `�objB.table.name.toLowerCase�` CHANGE COLUMN `�objB.name�` `�objB.name�` �objB.type��ColumnUtil.getSizeString(objB)� �IF objB.notNull�NOT NULL�ELSE�NULL�ENDIF� �ColumnUtil.getDefaultValueString(objB)� ;");
          _builder_7.newLine();
          content = (_content_11 + _builder_7);
        }
        return content;
      }
    }
    return null;
  }
}
