package de.thm.xtend;

import com.google.common.base.Objects;
import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.migration.ProcessStatus;
import de.thm.evolvedb.migration.ResolvableOperator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;

@SuppressWarnings("all")
public class CREATE_ELEMENT {
  public static String _CREATE_Table_IN_Database_Schema_entites(final ResolvableOperator set) {
    ProcessStatus _processStatus = set.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("CREATE_Table_IN_Database_Schema_(entites)"));
      };
      SemanticChangeSet addTable = IterableExtensions.<SemanticChangeSet>findFirst(set.getSemanticChangeSets(), _function);
      return CREATE_ELEMENT._CREATE_Table_IN_Database_Schema_entites2(addTable);
    }
    return "";
  }

  public static String _CREATE_Table_IN_Database_Schema_entites2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    Change _findFirst = IterableExtensions.<Change>findFirst(set.getChanges(), _function);
    AddObject a = ((AddObject) _findFirst);
    return CREATE_ELEMENT._CREATE_Table_IN_Database_Schema_entites2(a);
  }

  /**
   * Creates a new Table with all attributes and foriegn keys
   */
  public static String _CREATE_Table_IN_Database_Schema_entites2(final AddObject a) {
    Table entity = null;
    StringConcatenation _builder = new StringConcatenation();
    String content = _builder.toString();
    EObject _obj = a.getObj();
    if ((_obj instanceof Table)) {
      EObject _obj_1 = a.getObj();
      entity = ((Table) _obj_1);
      final Function1<Column, Boolean> _function = (Column it) -> {
        return Boolean.valueOf((it instanceof PrimaryKey));
      };
      Column _findFirst = IterableExtensions.<Column>findFirst(entity.getColumns(), _function);
      PrimaryKey primaryKey = ((PrimaryKey) _findFirst);
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
      final Function1<Column, Boolean> _function_4 = (Column it) -> {
        return Boolean.valueOf((it instanceof Column));
      };
      List<Column> columns = IterableExtensions.<Column>toList(IterableExtensions.<Column>filter(entity.getColumns(), _function_4));
      columns.remove(primaryKey);
      columns.removeAll(foreignKeys);
      boolean _notEquals = (!Objects.equal(primaryKey, null));
      if (_notEquals) {
        String _content = content;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("-- Create Table �entity.name�");
        _builder_1.newLine();
        _builder_1.append("CREATE TABLE IF NOT EXISTS �entity.name�  (");
        _builder_1.newLine();
        _builder_1.append("�IF primaryKey !== null� ");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("�primaryKey.name.toUpperCase� �primaryKey.type.getName()��ColumnUtil.getSizeString(primaryKey)� �primaryKey.notNull !== null && primaryKey.notNull ? \"NOT NULL\" : \"\"� �primaryKey.autoIncrement !== null && primaryKey.autoIncrement ? \"AUTO_INCREMENT\" : \"\"�, PRIMARY KEY (�primaryKey.name�));");
        _builder_1.newLine();
        _builder_1.append("�ENDIF�");
        _builder_1.newLine();
        _builder_1.append("�FOR ForeignKey e : foreignKeys SEPARATOR \',\'�");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("�e.name.toUpperCase� �e.type��ColumnUtil.getSizeString(e)� �e.notNull !== null && e.notNull ? \"NOT NULL\" : \"\"�,");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("FOREIGN KEY (�e.name.toUpperCase�) REFERENCES �e.referencedTable.name�(DB_ID)");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("ON DELETE �e.onDelete.name()�");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("ON UPDATE �e.onUpdate.name()�");
        _builder_1.newLine();
        _builder_1.append("�ENDFOR�");
        _builder_1.newLine();
        _builder_1.append("�FOR Column e : columns BEFORE \',\' SEPARATOR \',\' AFTER extraKomma(primaryForeignKeys.size)�");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("�e.name� �e.type� �ColumnUtil.getSizeString(e)� �e.notNull !== null && e.notNull ? \"NOT NULL\" : \"\"� �e.autoIncrement !== null && e.autoIncrement ? \"AUTO_INCREMENT\" : \"\"� ");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("�ColumnUtil.getDefaultValueString(e)�");
        _builder_1.newLine();
        _builder_1.append("�ENDFOR�");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append(");");
        _builder_1.newLine();
        content = (_content + _builder_1);
      } else {
        int _size = primaryForeignKeys.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          String _content_1 = content;
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("-- Create Table �entity.name�");
          _builder_2.newLine();
          _builder_2.append("CREATE TABLE IF NOT EXISTS �entity.name�  (");
          _builder_2.newLine();
          _builder_2.append("�FOR ForeignKey e : foreignKeys SEPARATOR \',\' AFTER \',\' �");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("`�e.name�` �e.type��ColumnUtil.getSizeString(e)� �e.notNull !== null && e.notNull ? \"NOT NULL\" : \"\"�");
          _builder_2.newLine();
          _builder_2.append("�ENDFOR�");
          _builder_2.newLine();
          _builder_2.append("�FOR Column e : columns BEFORE \',\' SEPARATOR \',\' AFTER \',\'�");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("`�e.name�` �e.type� �ColumnUtil.getSizeString(e)� �e.notNull !== null && e.notNull ? \"NOT NULL\" : \"\"� �e.autoIncrement !== null && e.autoIncrement ? \"AUTO_INCREMENT\" : \"\"� ");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("�ColumnUtil.getDefaultValueString(e)�");
          _builder_2.newLine();
          _builder_2.append("�ENDFOR�");
          _builder_2.newLine();
          _builder_2.append("�IF primaryForeignKeys.size > 0�");
          _builder_2.newLine();
          _builder_2.append("PRIMARY KEY(�FOR ForeignKey e : primaryForeignKeys SEPARATOR \',\'�`�e.name�` �ENDFOR�),");
          _builder_2.newLine();
          _builder_2.append("�ENDIF�");
          _builder_2.newLine();
          _builder_2.append("�FOR ForeignKey e : foreignKeys SEPARATOR \',\'�");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("CONSTRAINT `�e.constraintName�`");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("FOREIGN KEY (`�e.name.toUpperCase�`) ");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("REFERENCES `�e.referencedTable.name�`(`�e.referencedKeyColumn.name�`)");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("ON DELETE �e.onDelete.name()�");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("ON UPDATE �e.onUpdate.name()�");
          _builder_2.newLine();
          _builder_2.append("�ENDFOR�");
          _builder_2.newLine();
          _builder_2.append(");");
          _builder_2.newLine();
          content = (_content_1 + _builder_2);
        }
      }
    }
    return content;
  }

  /**
   * Helper method for loops
   */
  public static String extraKomma(final int size) {
    String _xifexpression = null;
    if ((size > 0)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(",");
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }

  /**
   * Create a new primary key in a table. The resolvable operator has to contain an Add_Object element.
   */
  public static String _CREATE_PrimaryKey_IN_Table_columns(final ResolvableOperator set) {
    ProcessStatus _processStatus = set.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("CREATE_PrimaryKey_IN_Table_(columns)"));
      };
      SemanticChangeSet addObject = IterableExtensions.<SemanticChangeSet>findFirst(set.getSemanticChangeSets(), _function);
      return CREATE_ELEMENT._CREATE_PrimaryKey_IN_Table_columns2(addObject);
    }
    return "";
  }

  /**
   * Creates the sql string for adding am additional primary key in a table
   */
  public static String _CREATE_PrimaryKey_IN_Table_columns2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    Change _findFirst = IterableExtensions.<Change>findFirst(set.getChanges(), _function);
    AddObject a = ((AddObject) _findFirst);
    String content = "";
    PrimaryKey key = null;
    EObject _obj = a.getObj();
    if ((_obj instanceof PrimaryKey)) {
      EObject _obj_1 = a.getObj();
      key = ((PrimaryKey) _obj_1);
      Table parent = key.getTable();
      EList<PrimaryKey> primaryKeys = parent.getPrimaryKeys();
      String _content = content;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-- Create primary key in �parent.name.toLowerCase� ");
      _builder.newLine();
      _builder.append("ALTER TABLE `�parent.name.toLowerCase�` ");
      _builder.newLine();
      _builder.append("ADD COLUMN `�key.name�` �key.type��ColumnUtil.getSizeString(key)� �key.notNull !== null && key.notNull ? \"NOT NULL\" : \"\"� �key.autoIncrement !== null && key.autoIncrement ? \"AUTO_INCREMENT\" : \"\"� �key.defaultValue !== null ? \"DEFAULT \"+key.defaultValue : \"\"�,");
      _builder.newLine();
      _builder.append("DROP PRIMARY KEY,");
      _builder.newLine();
      _builder.append("ADD PRIMARY KEY (�FOR p : primaryKeys SEPARATOR \', \'�`�p.name�`�ENDFOR�);");
      _builder.newLine();
      content = (_content + _builder);
    }
    return content;
  }

  /**
   * Create a new primary key in a table. The resolvable operator has to contain an Add_Object element.
   */
  public static String _CREATE_ForeignKey_IN_Table_columns(final ResolvableOperator set) {
    ProcessStatus _processStatus = set.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("CREATE_ForeignKey_IN_Table_(columns)"));
      };
      SemanticChangeSet addObject = IterableExtensions.<SemanticChangeSet>findFirst(set.getSemanticChangeSets(), _function);
      return CREATE_ELEMENT._CREATE_ForeignKey_IN_Table_columns2(addObject);
    }
    return "";
  }

  public static String _CREATE_ForeignKey_IN_Table_columns2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    Change _findFirst = IterableExtensions.<Change>findFirst(set.getChanges(), _function);
    AddObject a = ((AddObject) _findFirst);
    return CREATE_ELEMENT._CREATE_Table_IN_Database_Schema_entites2(a);
  }

  /**
   * Creates the sql string for adding a new foreign key
   */
  public static String _CREATE_ForeignKey_IN_Table_columns2(final AddObject a) {
    String content = "";
    ForeignKey key = null;
    EObject _obj = a.getObj();
    if ((_obj instanceof ForeignKey)) {
      EObject _obj_1 = a.getObj();
      key = ((ForeignKey) _obj_1);
      Table parent = key.getTable();
      String _content = content;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-- add new column for foreign key");
      _builder.newLine();
      _builder.append("ALTER TABLE `�parent.name.toLowerCase�` ");
      _builder.newLine();
      _builder.append("ADD COLUMN `�key.name.toUpperCase�` �key.type��ColumnUtil.getSizeString(key)� �key.notNull !== null && key.notNull ? \"NOT NULL\" : \"\"� �key.autoIncrement !== null && key.autoIncrement ? \"AUTO_INCREMENT\" : \"\"� �key.defaultValue !== null ? \"DEFAULT \"+key.defaultValue : \"\"�;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("-- Create foreign key in �parent.name.toLowerCase� ");
      _builder.newLine();
      _builder.append("ALTER TABLE `�parent.name.toLowerCase�` ");
      _builder.newLine();
      _builder.append("ADD CONSTRAINT `�key.constraintName�`");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("FOREIGN KEY (`�key.name.toUpperCase�`)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("REFERENCES `�key.referencedTable.name.toLowerCase�`(`�key.referencedKeyColumn.name.toUpperCase�`)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("ON DELETE �key.onDelete.name()�");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("ON UPDATE �key.onUpdate.name()�;");
      _builder.newLine();
      content = (_content + _builder);
    }
    return content;
  }

  public static String _CREATE_Database_Schema(final SemanticChangeSet set) {
    return null;
  }

  /**
   * Create a new column in a table. The resolvable operator has to contain an Add_Object element.
   */
  public static String _CREATE_Column_IN_Table_columns(final ResolvableOperator set) {
    ProcessStatus _processStatus = set.getProcessStatus();
    boolean _tripleEquals = (_processStatus == ProcessStatus.RESOLVED);
    if (_tripleEquals) {
      final Function1<SemanticChangeSet, Boolean> _function = (SemanticChangeSet it) -> {
        return Boolean.valueOf(it.getEditRName().equals("CREATE_Column_IN_Table_(columns)"));
      };
      SemanticChangeSet addObject = IterableExtensions.<SemanticChangeSet>findFirst(set.getSemanticChangeSets(), _function);
      return CREATE_ELEMENT._CREATE_Column_IN_Table_columns2(addObject);
    }
    return "";
  }

  /**
   * Creates the sql string for adding a column in a table
   */
  public static String _CREATE_Column_IN_Table_columns2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof AddObject));
    };
    Change _findFirst = IterableExtensions.<Change>findFirst(set.getChanges(), _function);
    AddObject a = ((AddObject) _findFirst);
    Column attribute = null;
    EObject _obj = a.getObj();
    if ((_obj instanceof Column)) {
      EObject _obj_1 = a.getObj();
      attribute = ((Column) _obj_1);
      Table owner = attribute.getTable();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-- Add the new column �attribute.name.toUpperCase� in Table �attribute.table.name.toLowerCase�");
      _builder.newLine();
      _builder.append("ALTER TABLE `�attribute.table.name.toLowerCase�` ");
      _builder.newLine();
      _builder.append("ADD COLUMN `�attribute.name.toUpperCase�` �attribute.type��ColumnUtil.getSizeString(attribute)� �attribute.notNull !== null && attribute.notNull ? \"NOT NULL\" : \"\"� �attribute.autoIncrement !== null && attribute.autoIncrement ? \"AUTO_INCREMENT\" : \"\"� ");
      _builder.newLine();
      _builder.append("�ColumnUtil.getDefaultValueString(attribute)� ;");
      _builder.newLine();
      String content = _builder.toString();
      return content;
    }
    return null;
  }
}
