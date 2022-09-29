package de.thm.xtend;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.evolvedb.migration.ProcessStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.SemanticChangeSet;

@SuppressWarnings("all")
public class DELETE_ELEMENT {
  /**
   * Delete a primaryKey
   * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
   */
  public static String _DELETE_Table_IN_Database_Schema_entites(final PartiallyResolvable partiallyResolvableOperator) {
    if (((partiallyResolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (partiallyResolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet removeElement = partiallyResolvableOperator.getSemanticChangeSets().get(0);
      return DELETE_ELEMENT._DELETE_Table_IN_Database_Schema_entites2(removeElement);
    }
    return "";
  }

  public static String _DELETE_Table_IN_Database_Schema_entites2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof RemoveObject));
    };
    Change _findFirst = IterableExtensions.<Change>findFirst(set.getChanges(), _function);
    RemoveObject a = ((RemoveObject) _findFirst);
    return DELETE_ELEMENT._DELETE_Table_IN_Database_Schema_entites2(a);
  }

  public static String _DELETE_Table_IN_Database_Schema_entites2(final RemoveObject a) {
    String content = "";
    Table table = null;
    EObject _obj = a.getObj();
    if ((_obj instanceof Table)) {
      EObject _obj_1 = a.getObj();
      table = ((Table) _obj_1);
      String _content = content;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-- Drop table �table.name.toLowerCase�\t\t\t");
      _builder.newLine();
      _builder.append("DROP TABLE `�table.name.toLowerCase�`;");
      _builder.newLine();
      _builder.newLine();
      content = (_content + _builder);
    }
    return content;
  }

  /**
   * Delete a primaryKey
   * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
   */
  public static String _DELETE_PrimaryKey_IN_Table_columns(final PartiallyResolvable partiallyResolvableOperator) {
    if (((partiallyResolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (partiallyResolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet removeElement = partiallyResolvableOperator.getSemanticChangeSets().get(0);
      return DELETE_ELEMENT._DELETE_PrimaryKey_IN_Table_columns2(removeElement);
    }
    return "";
  }

  public static String _DELETE_PrimaryKey_IN_Table_columns2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof RemoveObject));
    };
    Change _findFirst = IterableExtensions.<Change>findFirst(set.getChanges(), _function);
    RemoveObject a = ((RemoveObject) _findFirst);
    String content = "";
    PrimaryKey key = null;
    EObject _obj = a.getObj();
    if ((_obj instanceof PrimaryKey)) {
      EObject _obj_1 = a.getObj();
      key = ((PrimaryKey) _obj_1);
      Table parent = key.getTable();
      String _content = content;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-- Drop primary key in �parent.name.toLowerCase�\t\t\t");
      _builder.newLine();
      _builder.append("ALTER TABLE `�parent.name.toLowerCase�` ");
      _builder.newLine();
      _builder.append("DROP COLUMN `�key.name�`,");
      _builder.newLine();
      _builder.append("DROP PRIMARY KEY;");
      _builder.newLine();
      _builder.newLine();
      content = (_content + _builder);
    }
    return content;
  }

  /**
   * Delete a foreignKey
   * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
   */
  public static String _DELETE_ForeignKey_IN_Table_columns(final PartiallyResolvable partiallyResolvableOperator) {
    if (((partiallyResolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (partiallyResolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet removeElement = partiallyResolvableOperator.getSemanticChangeSets().get(0);
      return DELETE_ELEMENT._DELETE_ForeignKey_IN_Table_columns2(removeElement);
    }
    return "";
  }

  public static String _DELETE_ForeignKey_IN_Table_columns2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof RemoveObject));
    };
    Change _findFirst = IterableExtensions.<Change>findFirst(set.getChanges(), _function);
    RemoveObject a = ((RemoveObject) _findFirst);
    return DELETE_ELEMENT._DELETE_ForeignKey_IN_Table_columns2(a);
  }

  public static String _DELETE_ForeignKey_IN_Table_columns2(final RemoveObject a) {
    String content = "";
    ForeignKey foreignKey = null;
    EObject _obj = a.getObj();
    if ((_obj instanceof ForeignKey)) {
      EObject _obj_1 = a.getObj();
      foreignKey = ((ForeignKey) _obj_1);
      Table parent = foreignKey.getTable();
      String _content = content;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-- Drop foreign key in �parent.name.toLowerCase�");
      _builder.newLine();
      _builder.append("ALTER TABLE `�parent.name.toLowerCase�`");
      _builder.newLine();
      _builder.append("DROP FOREIGN KEY `�foreignKey.constraintName�`;");
      _builder.newLine();
      _builder.append("ALTER TABLE `�parent.name.toLowerCase�`");
      _builder.newLine();
      _builder.append("DROP COLUMN `�foreignKey.name�`;");
      _builder.newLine();
      _builder.newLine();
      content = (_content + _builder);
    }
    return content;
  }

  /**
   * Delete a foreignKey
   * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
   */
  public static String _DELETE_Column_IN_Table_columns(final PartiallyResolvable partiallyResolvableOperator) {
    if (((partiallyResolvableOperator.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (partiallyResolvableOperator.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet removeElement = partiallyResolvableOperator.getSemanticChangeSets().get(0);
      return DELETE_ELEMENT._DELETE_Column_IN_Table_columns2(removeElement);
    }
    return "";
  }

  public static String _DELETE_Column_IN_Table_columns2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof RemoveObject));
    };
    Change _findFirst = IterableExtensions.<Change>findFirst(set.getChanges(), _function);
    RemoveObject a = ((RemoveObject) _findFirst);
    String content = "";
    Column column = null;
    EObject _obj = a.getObj();
    if ((_obj instanceof Column)) {
      EObject _obj_1 = a.getObj();
      column = ((Column) _obj_1);
      Table parent = column.getTable();
      String _content = content;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-- Drop column in �parent.name.toLowerCase�\t\t\t");
      _builder.newLine();
      _builder.append("ALTER TABLE `�parent.name.toLowerCase�` ");
      _builder.newLine();
      _builder.append("DROP COLUMN `�column.name�`;");
      _builder.newLine();
      content = (_content + _builder);
    }
    return content;
  }
}
