package de.thm.xtend;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.migration.NotAutomaticallyResolvable;
import de.thm.evolvedb.migration.ProcessStatus;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SemanticChangeSet;

@SuppressWarnings("all")
public class MOVE_ELEMENT {
  /**
   * Move a primary key
   * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
   */
  public static String _MOVE_PrimaryKey_FROM_Table_columns_TO_Table_columns(final NotAutomaticallyResolvable notAutomaticallyResolvable) {
    if (((notAutomaticallyResolvable.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (notAutomaticallyResolvable.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet removeElement = notAutomaticallyResolvable.getSemanticChangeSets().get(0);
      return MOVE_ELEMENT._MOVE_PrimaryKey_FROM_Table_columns_TO_Table_columns2(removeElement);
    }
    return "";
  }

  public static String _MOVE_PrimaryKey_FROM_Table_columns_TO_Table_columns2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof RemoveReference));
    };
    final Function1<Change, RemoveReference> _function_1 = (Change it) -> {
      return ((RemoveReference) it);
    };
    List<RemoveReference> removeReference = IterableExtensions.<RemoveReference>toList(IterableExtensions.<Change, RemoveReference>map(IterableExtensions.<Change>filter(set.getChanges(), _function), _function_1));
    final Function1<Change, Boolean> _function_2 = (Change it) -> {
      return Boolean.valueOf((it instanceof AddReference));
    };
    final Function1<Change, AddReference> _function_3 = (Change it) -> {
      return ((AddReference) it);
    };
    List<AddReference> addReference = IterableExtensions.<AddReference>toList(IterableExtensions.<Change, AddReference>map(IterableExtensions.<Change>filter(set.getChanges(), _function_2), _function_3));
    if (((removeReference.size() > 0) && (addReference.size() > 0))) {
      final Function1<AddReference, Boolean> _function_4 = (AddReference it) -> {
        EObject _src = it.getSrc();
        return Boolean.valueOf((_src instanceof PrimaryKey));
      };
      AddReference addReferenceOptional = IterableExtensions.<AddReference>findFirst(addReference, _function_4);
      final Function1<RemoveReference, Boolean> _function_5 = (RemoveReference it) -> {
        EObject _src = it.getSrc();
        return Boolean.valueOf((_src instanceof PrimaryKey));
      };
      RemoveReference removeReferenceOptional = IterableExtensions.<RemoveReference>findFirst(removeReference, _function_5);
      if (((addReferenceOptional != null) && (removeReferenceOptional != null))) {
        EObject _src = addReferenceOptional.getSrc();
        PrimaryKey primaryKeyAdd = ((PrimaryKey) _src);
        EObject _src_1 = removeReferenceOptional.getSrc();
        PrimaryKey primaryKeyRemove = ((PrimaryKey) _src_1);
        Table parent = primaryKeyAdd.getTable();
        EList<PrimaryKey> primaryKeys = parent.getPrimaryKeys();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("-- Create primary key in �parent.name.toLowerCase� ");
        _builder.newLine();
        _builder.append("ALTER TABLE `�parent.name.toLowerCase�` ");
        _builder.newLine();
        _builder.append("ADD COLUMN `�primaryKeyAdd.name�` �primaryKeyAdd.type��ColumnUtil.getSizeString(primaryKeyAdd)� �primaryKeyAdd.notNull !== null && primaryKeyAdd.notNull ? \"NOT NULL\" : \"\"� �primaryKeyAdd.autoIncrement !== null && primaryKeyAdd.autoIncrement ? \"AUTO_INCREMENT\" : \"\"� �ColumnUtil.getDefaultValueString(primaryKeyAdd)�,");
        _builder.newLine();
        _builder.append("DROP PRIMARY KEY,");
        _builder.newLine();
        _builder.append("ADD PRIMARY KEY (�FOR p : primaryKeys SEPARATOR \', \'�`�p.name�`�ENDFOR�);");
        _builder.newLine();
        String content = _builder.toString();
        String _content = content;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("-- Drop primary key in �primaryKeyRemove.table.name.toLowerCase�\t\t\t");
        _builder_1.newLine();
        _builder_1.append("ALTER TABLE `�primaryKeyRemove.table.name.toLowerCase�` ");
        _builder_1.newLine();
        _builder_1.append("DROP COLUMN `�primaryKeyRemove.name�`,");
        _builder_1.newLine();
        _builder_1.append("DROP PRIMARY KEY;");
        _builder_1.newLine();
        _builder_1.append("ADD PRIMARY KEY (�FOR p : primaryKeyRemove.table.primaryKeys SEPARATOR \', \'�`�p.name�`�ENDFOR�);");
        _builder_1.newLine();
        content = (_content + _builder_1);
        return content;
      }
    }
    return null;
  }

  /**
   * Move a foreignKey
   * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
   */
  public static String _MOVE_ForeignKey_FROM_Table_columns_TO_Table_columns(final NotAutomaticallyResolvable notAutomaticallyResolvable) {
    if (((notAutomaticallyResolvable.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (notAutomaticallyResolvable.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet removeElement = notAutomaticallyResolvable.getSemanticChangeSets().get(0);
      return MOVE_ELEMENT._MOVE_ForeignKey_FROM_Table_columns_TO_Table_columns2(removeElement);
    }
    return "";
  }

  public static String _MOVE_ForeignKey_FROM_Table_columns_TO_Table_columns2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof RemoveReference));
    };
    final Function1<Change, RemoveReference> _function_1 = (Change it) -> {
      return ((RemoveReference) it);
    };
    List<RemoveReference> removeReference = IterableExtensions.<RemoveReference>toList(IterableExtensions.<Change, RemoveReference>map(IterableExtensions.<Change>filter(set.getChanges(), _function), _function_1));
    final Function1<Change, Boolean> _function_2 = (Change it) -> {
      return Boolean.valueOf((it instanceof AddReference));
    };
    final Function1<Change, AddReference> _function_3 = (Change it) -> {
      return ((AddReference) it);
    };
    List<AddReference> addReference = IterableExtensions.<AddReference>toList(IterableExtensions.<Change, AddReference>map(IterableExtensions.<Change>filter(set.getChanges(), _function_2), _function_3));
    if (((removeReference.size() > 0) && (addReference.size() > 0))) {
      final Function1<AddReference, Boolean> _function_4 = (AddReference it) -> {
        EObject _src = it.getSrc();
        return Boolean.valueOf((_src instanceof ForeignKey));
      };
      AddReference addReferenceOptional = IterableExtensions.<AddReference>findFirst(addReference, _function_4);
      final Function1<RemoveReference, Boolean> _function_5 = (RemoveReference it) -> {
        EObject _src = it.getSrc();
        return Boolean.valueOf((_src instanceof ForeignKey));
      };
      RemoveReference removeReferenceOptional = IterableExtensions.<RemoveReference>findFirst(removeReference, _function_5);
      if (((addReferenceOptional != null) && (removeReferenceOptional != null))) {
        EObject _src = addReferenceOptional.getSrc();
        ForeignKey foreignKeyAdd = ((ForeignKey) _src);
        EObject _src_1 = removeReferenceOptional.getSrc();
        ForeignKey foreignKeyRemove = ((ForeignKey) _src_1);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("-- add new column for foreign key");
        _builder.newLine();
        _builder.append("ALTER TABLE `�foreignKeyAdd.table.name.toLowerCase�` ");
        _builder.newLine();
        _builder.append("ADD COLUMN `�foreignKeyAdd.name.toUpperCase�` �foreignKeyAdd.type��ColumnUtil.getSizeString(foreignKeyAdd)� �foreignKeyAdd.notNull !== null && foreignKeyAdd.notNull ? \"NOT NULL\" : \"\"� �foreignKeyAdd.autoIncrement !== null && foreignKeyAdd.autoIncrement ? \"AUTO_INCREMENT\" : \"\"� �ColumnUtil.getDefaultValueString(foreignKeyAdd)�;");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.newLine();
        _builder.append("-- Create foreign key in �foreignKeyAdd.table.name.toLowerCase� ");
        _builder.newLine();
        _builder.append("ALTER TABLE `�foreignKeyAdd.table.name.toLowerCase�` ");
        _builder.newLine();
        _builder.append("ADD CONSTRAINT `�foreignKeyAdd.constraintName�`");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("FOREIGN KEY (`�foreignKeyAdd.name.toUpperCase�`)");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("REFERENCES `�foreignKeyAdd.referencedTable.name.toLowerCase�`(`�foreignKeyAdd.referencedKeyColumn.name.toUpperCase�`)");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("ON DELETE �foreignKeyAdd.onDelete.name()�");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("ON UPDATE �foreignKeyAdd.onUpdate.name()�;");
        _builder.newLine();
        String content = _builder.toString();
        String _content = content;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("-- Drop foreign key in �foreignKeyRemove.table.name.toLowerCase�");
        _builder_1.newLine();
        _builder_1.append("ALTER TABLE `�foreignKeyRemove.table.name.toLowerCase�`");
        _builder_1.newLine();
        _builder_1.append("DROP FOREIGN KEY `�foreignKeyRemove.constraintName�`;");
        _builder_1.newLine();
        _builder_1.append("ALTER TABLE `�foreignKeyRemove.table.name.toLowerCase�`");
        _builder_1.newLine();
        _builder_1.append("DROP COLUMN `�foreignKeyRemove.name�`;");
        _builder_1.newLine();
        _builder_1.newLine();
        content = (_content + _builder_1);
        return content;
      }
    }
    return null;
  }

  /**
   * Move a column
   * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
   */
  public static String _MOVE_Column_FROM_Table_columns_TO_Table_columns(final NotAutomaticallyResolvable notAutomaticallyResolvable) {
    if (((notAutomaticallyResolvable.getProcessStatus() == ProcessStatus.RESOLVED) && 
      (notAutomaticallyResolvable.getSemanticChangeSets().size() == 1))) {
      SemanticChangeSet removeElement = notAutomaticallyResolvable.getSemanticChangeSets().get(0);
      return MOVE_ELEMENT._MOVE_Column_FROM_Table_columns_TO_Table_columns2(removeElement);
    }
    return "";
  }

  public static String _MOVE_Column_FROM_Table_columns_TO_Table_columns2(final SemanticChangeSet set) {
    final Function1<Change, Boolean> _function = (Change it) -> {
      return Boolean.valueOf((it instanceof RemoveReference));
    };
    final Function1<Change, RemoveReference> _function_1 = (Change it) -> {
      return ((RemoveReference) it);
    };
    List<RemoveReference> removeReference = IterableExtensions.<RemoveReference>toList(IterableExtensions.<Change, RemoveReference>map(IterableExtensions.<Change>filter(set.getChanges(), _function), _function_1));
    final Function1<Change, Boolean> _function_2 = (Change it) -> {
      return Boolean.valueOf((it instanceof AddReference));
    };
    final Function1<Change, AddReference> _function_3 = (Change it) -> {
      return ((AddReference) it);
    };
    List<AddReference> addReference = IterableExtensions.<AddReference>toList(IterableExtensions.<Change, AddReference>map(IterableExtensions.<Change>filter(set.getChanges(), _function_2), _function_3));
    if (((removeReference.size() > 0) && (addReference.size() > 0))) {
      final Function1<AddReference, Boolean> _function_4 = (AddReference it) -> {
        EObject _src = it.getSrc();
        return Boolean.valueOf((_src instanceof Column));
      };
      AddReference addReferenceOptional = IterableExtensions.<AddReference>findFirst(addReference, _function_4);
      final Function1<RemoveReference, Boolean> _function_5 = (RemoveReference it) -> {
        EObject _src = it.getSrc();
        return Boolean.valueOf((_src instanceof Column));
      };
      RemoveReference removeReferenceOptional = IterableExtensions.<RemoveReference>findFirst(removeReference, _function_5);
      if (((addReferenceOptional != null) && (removeReferenceOptional != null))) {
        EObject _src = addReferenceOptional.getSrc();
        Column columnAdd = ((Column) _src);
        EObject _src_1 = removeReferenceOptional.getSrc();
        Column columnRemove = ((Column) _src_1);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("-- Add the new column �columnAdd.name.toUpperCase� in Table �columnAdd.table.name.toLowerCase�");
        _builder.newLine();
        _builder.append("ALTER TABLE `�columnAdd.table.name.toLowerCase�` ");
        _builder.newLine();
        _builder.append("ADD COLUMN `�columnAdd.name.toUpperCase�` �columnAdd.type��ColumnUtil.getSizeString(columnAdd)� �columnAdd.notNull !== null && columnAdd.notNull ? \"NOT NULL\" : \"\"� �columnAdd.autoIncrement !== null && columnAdd.autoIncrement ? \"AUTO_INCREMENT\" : \"\"� ");
        _builder.newLine();
        _builder.append("�ColumnUtil.getDefaultValueString(columnAdd)� ;");
        _builder.newLine();
        String content = _builder.toString();
        String _content = content;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("-- Drop column in �columnRemove.table.name.toLowerCase�");
        _builder_1.newLine();
        _builder_1.append("ALTER TABLE `�columnRemove.table.name.toLowerCase�` ");
        _builder_1.newLine();
        _builder_1.append("DROP COLUMN `�columnRemove.name�`;");
        _builder_1.newLine();
        content = (_content + _builder_1);
        return content;
      }
    }
    return null;
  }
}
