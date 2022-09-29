package de.thm.xtend;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.migration.ColumnOptions;
import de.thm.evolvedb.migration.ComplexResolveOptions;
import de.thm.evolvedb.migration.NotAutomaticallyResolvable;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.evolvedb.migration.ProcessStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SemanticChangeSet;

@SuppressWarnings("all")
public class ComplexChanges {
  public static String _CHANGE_1N_INTO_NM(final PartiallyResolvable set) {
    ProcessStatus _processStatus = set.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("CHANGE_1N_INTO_NM"));
      };
      SemanticChangeSet change = IterableExtensions.<SemanticChangeSet>findFirst(set.getSemanticChangeSets(), _function);
      return ComplexChanges._CHANGE_1N_INTO_NM(change, set.getResolveOptions());
    }
    return "";
  }

  public static String _CHANGE_1N_INTO_NM(final SemanticChangeSet set, final ColumnOptions options) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    List<Change> addObjects = IterableExtensions.<Change>toList(IterableExtensions.<Change>filter(set.getChanges(), _function));
    final Function1<Change, Boolean> _function_1 = (Change it) -> {
      return Boolean.valueOf((it instanceof RemoveObject));
    };
    List<Change> removeObject = IterableExtensions.<Change>toList(IterableExtensions.<Change>filter(set.getChanges(), _function_1));
    AddObject addObject = null;
    for (final Change change : addObjects) {
      {
        AddObject temp = ((AddObject) change);
        EObject _obj = temp.getObj();
        if ((_obj instanceof Table)) {
          addObject = temp;
        }
      }
    }
    RemoveObject removeForeign = null;
    for (final Change change_1 : removeObject) {
      {
        RemoveObject temp = ((RemoveObject) change_1);
        EObject _obj = temp.getObj();
        if ((_obj instanceof ForeignKey)) {
          removeForeign = temp;
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    String content = _builder.toString();
    if (((addObject == null) || (removeForeign == null))) {
      return content;
    }
    String _content = content;
    String __CREATE_Table_IN_Database_Schema_entites2 = CREATE_ELEMENT._CREATE_Table_IN_Database_Schema_entites2(addObject);
    content = (_content + __CREATE_Table_IN_Database_Schema_entites2);
    EObject _obj = addObject.getObj();
    if ((_obj instanceof Table)) {
      EObject _obj_1 = addObject.getObj();
      Table entity = ((Table) _obj_1);
      final Function1<Column, Boolean> _function_2 = (Column it) -> {
        return Boolean.valueOf((it instanceof ForeignKey));
      };
      final Function1<Column, ForeignKey> _function_3 = (Column it) -> {
        return ((ForeignKey) it);
      };
      List<ForeignKey> foreignKeys = IterableExtensions.<ForeignKey>toList(IterableExtensions.<Column, ForeignKey>map(IterableExtensions.<Column>filter(entity.getColumns(), _function_2), _function_3));
      final Function1<ForeignKey, Boolean> _function_4 = (ForeignKey it) -> {
        return it.getPrimaryForeignKey();
      };
      List<ForeignKey> primaryForeignKeys = IterableExtensions.<ForeignKey>toList(IterableExtensions.<ForeignKey>filter(foreignKeys, _function_4));
      EObject _obj_2 = removeForeign.getObj();
      ForeignKey removeForeignKey = ((ForeignKey) _obj_2);
      PrimaryKey sourceKey = null;
      ForeignKey sourceForeign = null;
      ForeignKey targetForeign = null;
      for (final ForeignKey foreignKey : primaryForeignKeys) {
        boolean _equals = foreignKey.getReferencedTable().getName().equals(removeForeignKey.getTable().getName());
        if (_equals) {
          sourceKey = foreignKey.getReferencedKeyColumn();
          sourceForeign = foreignKey;
        } else {
          targetForeign = foreignKey;
        }
      }
      boolean _equals_1 = options.equals(ColumnOptions.MIGRATE_DATA);
      if (_equals_1) {
        String _content_1 = content;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("BEGIN;");
        _builder_1.newLine();
        _builder_1.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
        _builder_1.newLine();
        _builder_1.append("SET SQL_SAFE_UPDATES = 0;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("-- Migrate data to the new table");
        _builder_1.newLine();
        _builder_1.append("INSERT INTO `�entity.name�` (�sourceForeign.name� , �targetForeign.name�)");
        _builder_1.newLine();
        _builder_1.append("SELECT �sourceKey.name�, �removeForeignKey.name� FROM �removeForeignKey.table.name� WHERE �removeForeignKey.name� IS NOT NULL;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("SET SQL_SAFE_UPDATES = @safe_mode;");
        _builder_1.newLine();
        _builder_1.append("COMMIT;");
        _builder_1.newLine();
        _builder_1.append("-- If executing the script fails, we suggest a rollback.");
        _builder_1.newLine();
        _builder_1.newLine();
        content = (_content_1 + _builder_1);
      }
      String _content_2 = content;
      String __DELETE_ForeignKey_IN_Table_columns2 = DELETE_ELEMENT._DELETE_ForeignKey_IN_Table_columns2(removeForeign);
      content = (_content_2 + __DELETE_ForeignKey_IN_Table_columns2);
    }
    return content;
  }

  public static String _CHANGE_1N_INTO_NM_PRESERVE(final PartiallyResolvable set) {
    ProcessStatus _processStatus = set.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("CHANGE_1N_INTO_NM_PRESERVE"));
      };
      SemanticChangeSet change = IterableExtensions.<SemanticChangeSet>findFirst(set.getSemanticChangeSets(), _function);
      return ComplexChanges._CHANGE_1N_INTO_NM_PRESERVE(change, set.getResolveOptions());
    }
    return "";
  }

  public static String _CHANGE_1N_INTO_NM_PRESERVE(final SemanticChangeSet set, final ColumnOptions options) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    List<Change> addObjects = IterableExtensions.<Change>toList(IterableExtensions.<Change>filter(set.getChanges(), _function));
    AddObject addObject = null;
    for (final Change change : addObjects) {
      {
        AddObject temp = ((AddObject) change);
        EObject _obj = temp.getObj();
        if ((_obj instanceof Table)) {
          addObject = temp;
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    String content = _builder.toString();
    if ((addObject == null)) {
      return content;
    }
    String _content = content;
    String __CREATE_Table_IN_Database_Schema_entites2 = CREATE_ELEMENT._CREATE_Table_IN_Database_Schema_entites2(addObject);
    content = (_content + __CREATE_Table_IN_Database_Schema_entites2);
    boolean _equals = options.equals(ColumnOptions.MIGRATE_DATA);
    if (_equals) {
      EObject _obj = addObject.getObj();
      if ((_obj instanceof Table)) {
        EObject _obj_1 = addObject.getObj();
        Table entity = ((Table) _obj_1);
        final Function1<Column, Boolean> _function_1 = (Column it) -> {
          return Boolean.valueOf((it instanceof ForeignKey));
        };
        final Function1<Column, ForeignKey> _function_2 = (Column it) -> {
          return ((ForeignKey) it);
        };
        List<ForeignKey> foreignKeys = IterableExtensions.<ForeignKey>toList(IterableExtensions.<Column, ForeignKey>map(IterableExtensions.<Column>filter(entity.getColumns(), _function_1), _function_2));
        final Function1<ForeignKey, Boolean> _function_3 = (ForeignKey it) -> {
          return it.getPrimaryForeignKey();
        };
        List<ForeignKey> primaryForeignKeys = IterableExtensions.<ForeignKey>toList(IterableExtensions.<ForeignKey>filter(foreignKeys, _function_3));
        final Function1<ForeignKey, PrimaryKey> _function_4 = (ForeignKey it) -> {
          return it.getReferencedKeyColumn();
        };
        final List<PrimaryKey> referencedKeys = IterableExtensions.<PrimaryKey>toList(ListExtensions.<ForeignKey, PrimaryKey>map(primaryForeignKeys, _function_4));
        List<ForeignKey> oldForeignKeys = new ArrayList<ForeignKey>();
        for (final ForeignKey foreignKey : primaryForeignKeys) {
          final Function1<ForeignKey, Boolean> _function_5 = (ForeignKey it) -> {
            return Boolean.valueOf((referencedKeys.contains(it.getReferencedKeyColumn()) && (!it.getTable().equals(it.getReferencedTable()))));
          };
          oldForeignKeys.addAll(IterableExtensions.<ForeignKey>toList(IterableExtensions.<ForeignKey>filter(foreignKey.getReferencedTable().getForeignKeys(), _function_5)));
        }
        for (final ForeignKey oldForeign : oldForeignKeys) {
          {
            PrimaryKey sourceKey = null;
            ForeignKey sourceForeign = null;
            ForeignKey targetForeign = null;
            final Table sourceTable = oldForeign.getTable();
            final Function1<ForeignKey, Boolean> _function_6 = (ForeignKey it) -> {
              return Boolean.valueOf(it.getReferencedTable().equals(sourceTable));
            };
            sourceForeign = IterableExtensions.<ForeignKey>findFirst(primaryForeignKeys, _function_6);
            final Function1<ForeignKey, Boolean> _function_7 = (ForeignKey it) -> {
              boolean _equals_1 = it.getReferencedTable().equals(sourceTable);
              return Boolean.valueOf((!_equals_1));
            };
            targetForeign = IterableExtensions.<ForeignKey>findFirst(primaryForeignKeys, _function_7);
            sourceKey = sourceForeign.getReferencedKeyColumn();
            String _content_1 = content;
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("BEGIN;");
            _builder_1.newLine();
            _builder_1.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
            _builder_1.newLine();
            _builder_1.append("SET SQL_SAFE_UPDATES = 0;");
            _builder_1.newLine();
            _builder_1.newLine();
            _builder_1.append("-- Migrate data to the new table");
            _builder_1.newLine();
            _builder_1.append("INSERT INTO `�entity.name�` (�sourceForeign.name� , �targetForeign.name�)");
            _builder_1.newLine();
            _builder_1.append("SELECT �sourceKey.name�, �oldForeign.name� FROM �oldForeign.table.name� WHERE �oldForeign.name� IS NOT NULL;");
            _builder_1.newLine();
            _builder_1.newLine();
            _builder_1.append("SET SQL_SAFE_UPDATES = @safe_mode;");
            _builder_1.newLine();
            _builder_1.append("COMMIT;");
            _builder_1.newLine();
            _builder_1.append("-- If executing the script fails, we suggest a rollback.");
            _builder_1.newLine();
            _builder_1.newLine();
            content = (_content_1 + _builder_1);
          }
        }
      }
    }
    return content;
  }

  public static String _CHANGE_NM_INTO_1N(final PartiallyResolvable set) {
    ProcessStatus _processStatus = set.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("CHANGE_NM_INTO_1N"));
      };
      SemanticChangeSet change = IterableExtensions.<SemanticChangeSet>findFirst(set.getSemanticChangeSets(), _function);
      return ComplexChanges._CHANGE_NM_INTO_1N(change, set.getResolveOptions());
    }
    return "";
  }

  public static String _CHANGE_NM_INTO_1N(final SemanticChangeSet set, final ColumnOptions options) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    List<Change> addObjects = IterableExtensions.<Change>toList(IterableExtensions.<Change>filter(set.getChanges(), _function));
    final Function1<Change, Boolean> _function_1 = (Change it) -> {
      return Boolean.valueOf((it instanceof RemoveObject));
    };
    List<Change> removeObject = IterableExtensions.<Change>toList(IterableExtensions.<Change>filter(set.getChanges(), _function_1));
    AddObject addForeign = null;
    for (final Change change : addObjects) {
      {
        AddObject temp = ((AddObject) change);
        EObject _obj = temp.getObj();
        if ((_obj instanceof ForeignKey)) {
          addForeign = temp;
        }
      }
    }
    RemoveObject removeTable = null;
    for (final Change change_1 : removeObject) {
      {
        RemoveObject temp = ((RemoveObject) change_1);
        EObject _obj = temp.getObj();
        if ((_obj instanceof Table)) {
          removeTable = temp;
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    String content = _builder.toString();
    if (((addForeign == null) || (removeTable == null))) {
      return content;
    }
    String _content = content;
    String __CREATE_ForeignKey_IN_Table_columns2 = CREATE_ELEMENT._CREATE_ForeignKey_IN_Table_columns2(addForeign);
    content = (_content + __CREATE_ForeignKey_IN_Table_columns2);
    if (((options.equals(ColumnOptions.MIGRATE_DATA) || options.equals(ColumnOptions.DELETE_DUBLICATES)) || 
      options.equals(ColumnOptions.IGNORE_DUBLICATES))) {
      EObject _obj = addForeign.getObj();
      if ((_obj instanceof ForeignKey)) {
        EObject _obj_1 = addForeign.getObj();
        final ForeignKey newForeignKey = ((ForeignKey) _obj_1);
        EObject _obj_2 = removeTable.getObj();
        Table oldTable = ((Table) _obj_2);
        final Function1<Column, Boolean> _function_2 = (Column it) -> {
          return Boolean.valueOf((it instanceof ForeignKey));
        };
        final Function1<Column, ForeignKey> _function_3 = (Column it) -> {
          return ((ForeignKey) it);
        };
        List<ForeignKey> foreignKeys = IterableExtensions.<ForeignKey>toList(IterableExtensions.<Column, ForeignKey>map(IterableExtensions.<Column>filter(oldTable.getColumns(), _function_2), _function_3));
        final Function1<ForeignKey, Boolean> _function_4 = (ForeignKey it) -> {
          return it.getPrimaryForeignKey();
        };
        List<ForeignKey> primaryForeignKeys = IterableExtensions.<ForeignKey>toList(IterableExtensions.<ForeignKey>filter(foreignKeys, _function_4));
        final Function1<ForeignKey, Boolean> _function_5 = (ForeignKey it) -> {
          return Boolean.valueOf(it.getReferencedTable().getName().equals(newForeignKey.getTable().getName()));
        };
        ForeignKey sourceForeign = IterableExtensions.<ForeignKey>findFirst(primaryForeignKeys, _function_5);
        final Function1<ForeignKey, Boolean> _function_6 = (ForeignKey it) -> {
          return Boolean.valueOf(it.getReferencedKeyColumn().getName().equals(newForeignKey.getReferencedKeyColumn().getName()));
        };
        ForeignKey targetForeign = IterableExtensions.<ForeignKey>findFirst(primaryForeignKeys, _function_6);
        if (((sourceForeign != null) && (targetForeign != null))) {
          String _content_1 = content;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("BEGIN;");
          _builder_1.newLine();
          _builder_1.append("SET @safe_mode = @@SQL_SAFE_UPDATES;");
          _builder_1.newLine();
          _builder_1.append("SET SQL_SAFE_UPDATES = 0;");
          _builder_1.newLine();
          _builder_1.newLine();
          _builder_1.append("-- Migrate data from the old table");
          _builder_1.newLine();
          _builder_1.append("UPDATE `�newForeignKey.table.name�` t SET �newForeignKey.name� = ");
          _builder_1.newLine();
          _builder_1.append("(SELECT �targetForeign.name� FROM �targetForeign.table.name� n WHERE n.�sourceForeign.name� = t.�sourceForeign.referencedKeyColumn.name� );");
          _builder_1.newLine();
          _builder_1.newLine();
          _builder_1.append("SET SQL_SAFE_UPDATES = @safe_mode;");
          _builder_1.newLine();
          _builder_1.append("COMMIT;");
          _builder_1.newLine();
          _builder_1.append("-- If executing the script fails, we suggest a rollback.");
          _builder_1.newLine();
          _builder_1.newLine();
          content = (_content_1 + _builder_1);
        }
      }
    }
    String _content_2 = content;
    String __DELETE_Table_IN_Database_Schema_entites2 = DELETE_ELEMENT._DELETE_Table_IN_Database_Schema_entites2(removeTable);
    content = (_content_2 + __DELETE_Table_IN_Database_Schema_entites2);
    return content;
  }

  public static String _CHANGE_NM_INTO_1N_PRESERVE(final PartiallyResolvable resolvable) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }

  public static String _JOIN_TABLE(final NotAutomaticallyResolvable resolvable) {
    ProcessStatus _processStatus = resolvable.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("JOIN_tables"));
      };
      SemanticChangeSet change = IterableExtensions.<SemanticChangeSet>findFirst(resolvable.getSemanticChangeSets(), _function);
      return ComplexChanges._JOIN_TABLE(change, resolvable.getResolveOptions());
    }
    return "";
  }

  public static String _JOIN_TABLE(final SemanticChangeSet change, final ComplexResolveOptions option) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof RemoveObject));
    };
    final Function1<Change, RemoveObject> _function_1 = (Change it) -> {
      return ((RemoveObject) it);
    };
    final List<RemoveObject> removeObject = IterableExtensions.<RemoveObject>toList(IterableExtensions.<Change, RemoveObject>map(IterableExtensions.<Change>filter(change.getChanges(), _function), _function_1));
    final Function1<Change, Boolean> _function_2 = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    final Function1<Change, AddObject> _function_3 = (Change it) -> {
      return ((AddObject) it);
    };
    final List<AddObject> addObject = IterableExtensions.<AddObject>toList(IterableExtensions.<Change, AddObject>map(IterableExtensions.<Change>filter(change.getChanges(), _function_2), _function_3));
    StringConcatenation _builder = new StringConcatenation();
    String content = _builder.toString();
    if (((removeObject.size() > 0) && (addObject.size() > 0))) {
      final Function1<AddObject, Boolean> _function_4 = (AddObject it) -> {
        EObject _obj = it.getObj();
        return Boolean.valueOf((_obj instanceof Table));
      };
      final AddObject addTable = IterableExtensions.<AddObject>findFirst(addObject, _function_4);
      final Function1<RemoveObject, Boolean> _function_5 = (RemoveObject it) -> {
        EObject _obj = it.getObj();
        return Boolean.valueOf((_obj instanceof Table));
      };
      final List<RemoveObject> removeTables = IterableExtensions.<RemoveObject>toList(IterableExtensions.<RemoveObject>filter(removeObject, _function_5));
      final Function1<RemoveObject, Table> _function_6 = (RemoveObject it) -> {
        EObject _obj = it.getObj();
        return ((Table) _obj);
      };
      List<Table> removeTable = IterableExtensions.<Table>toList(ListExtensions.<RemoveObject, Table>map(removeTables, _function_6));
      final Function1<Change, Boolean> _function_7 = (Change it) -> {
        return Boolean.valueOf((it instanceof AddReference));
      };
      final Function1<Change, AddReference> _function_8 = (Change it) -> {
        return ((AddReference) it);
      };
      List<AddReference> addReference = IterableExtensions.<AddReference>toList(IterableExtensions.<Change, AddReference>map(IterableExtensions.<Change>filter(change.getChanges(), _function_7), _function_8));
      final Function1<AddReference, Boolean> _function_9 = (AddReference it) -> {
        EObject _src = it.getSrc();
        return Boolean.valueOf((_src instanceof Column));
      };
      List<AddReference> addReferenceOptional = IterableExtensions.<AddReference>toList(IterableExtensions.<AddReference>filter(addReference, _function_9));
      final Function1<Change, Boolean> _function_10 = (Change it) -> {
        return Boolean.valueOf((it instanceof RemoveReference));
      };
      final Function1<Change, RemoveReference> _function_11 = (Change it) -> {
        return ((RemoveReference) it);
      };
      List<RemoveReference> removeReference = IterableExtensions.<RemoveReference>toList(IterableExtensions.<Change, RemoveReference>map(IterableExtensions.<Change>filter(change.getChanges(), _function_10), _function_11));
      final Function1<RemoveReference, Boolean> _function_12 = (RemoveReference it) -> {
        EObject _src = it.getSrc();
        return Boolean.valueOf((_src instanceof Column));
      };
      final Function1<RemoveReference, Column> _function_13 = (RemoveReference it) -> {
        EObject _src = it.getSrc();
        return ((Column) _src);
      };
      List<Column> removeColumns = IterableExtensions.<Column>toList(IterableExtensions.<RemoveReference, Column>map(IterableExtensions.<RemoveReference>filter(removeReference, _function_12), _function_13));
      final Function1<Column, Table> _function_14 = (Column it) -> {
        return it.getTable();
      };
      Map<Table, List<Column>> map = IterableExtensions.<Table, Column>groupBy(removeColumns, _function_14);
      if (((addTable != null) && (removeTables.size() == 2))) {
        EObject _obj = addTable.getObj();
        Table newTable = ((Table) _obj);
        if (option != null) {
          switch (option) {
            case CARTESIAN_PRODUCT:
              String _content = content;
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("-- Join tables �removeTable.get(0).name� and �removeTable.get(0).name�");
              _builder_1.newLine();
              _builder_1.append("CREATE TABLE �newTable.name� ");
              _builder_1.newLine();
              _builder_1.append("(SELECT �FOR Column c : map.get(removeTable.get(0)) SEPARATOR \',\' AFTER \',\'� a.�c.name��ENDFOR� ");
              _builder_1.newLine();
              _builder_1.append("�FOR Column c : map.get(removeTable.get(1)) SEPARATOR \',\' AFTER \' \' � b.�c.name��ENDFOR�");
              _builder_1.newLine();
              _builder_1.append("FROM �removeTable.get(0).name� a ");
              _builder_1.newLine();
              _builder_1.append("CROSS JOIN �removeTable.get(1).name� b )");
              _builder_1.newLine();
              content = (_content + _builder_1);
              break;
            case IGNORE:
              String _content_1 = content;
              String __CREATE_Table_IN_Database_Schema_entites2 = CREATE_ELEMENT._CREATE_Table_IN_Database_Schema_entites2(addTable);
              content = (_content_1 + __CREATE_Table_IN_Database_Schema_entites2);
              break;
            case RESOLVE_BY_DB_ID:
              String _content_2 = content;
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("-- Join tables �removeTable.get(0).name� and �removeTable.get(0).name�");
              _builder_2.newLine();
              _builder_2.append("CREATE TABLE �newTable.name� ");
              _builder_2.newLine();
              _builder_2.append("(SELECT �FOR Column c : map.get(removeTable.get(0)) SEPARATOR \',\' AFTER \',\'� a.�c.name��ENDFOR� ");
              _builder_2.newLine();
              _builder_2.append("�FOR Column c : map.get(removeTable.get(1)) SEPARATOR \',\' AFTER \' \' � b.�c.name��ENDFOR�");
              _builder_2.newLine();
              _builder_2.append("FROM �removeTable.get(0).name� a ");
              _builder_2.newLine();
              _builder_2.append("JOIN �removeTable.get(1).name� b where a.�removeTable.get(0).mainPrimaryKey.name� = b.�removeTable.get(1).mainPrimaryKey.name�)");
              _builder_2.newLine();
              content = (_content_2 + _builder_2);
              break;
            default:
              break;
          }
        }
        for (final RemoveObject o : removeTables) {
          String _content_3 = content;
          String __DELETE_Table_IN_Database_Schema_entites2 = DELETE_ELEMENT._DELETE_Table_IN_Database_Schema_entites2(o);
          content = (_content_3 + __DELETE_Table_IN_Database_Schema_entites2);
        }
      }
    }
    return content;
  }
}
