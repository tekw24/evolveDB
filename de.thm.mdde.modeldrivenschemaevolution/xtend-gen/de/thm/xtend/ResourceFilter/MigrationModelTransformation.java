package de.thm.xtend.ResourceFilter;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.migration.ColumnOptions;
import de.thm.evolvedb.migration.Migration;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.evolvedb.migration.PartiallyResolvableOperatorType;
import de.thm.evolvedb.migration.ResolvableOperator;
import de.thm.evolvedb.migration.ResolvableOperatorType;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;

@SuppressWarnings("all")
public class MigrationModelTransformation {
  public void runMigrtaionTransformation(final Resource resXtendModelFile, final Resource resSymmetricModel) {
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf((it instanceof Migration));
    };
    EObject _findFirst = IteratorExtensions.<EObject>findFirst(resXtendModelFile.getAllContents(), _function);
    Migration migration = ((Migration) _findFirst);
    this.transformNewTableOperator(migration);
    this.transformRenameOperator(migration);
    this.setMigrationOptionFor1N_NM_Rule(migration);
    this.removeUniqueConstraintName(migration);
    final Function1<EObject, Boolean> _function_1 = (EObject it) -> {
      return Boolean.valueOf((it instanceof SymmetricDifference));
    };
    EObject _findFirst_1 = IteratorExtensions.<EObject>findFirst(resSymmetricModel.getAllContents(), _function_1);
    SymmetricDifference symmetricDifference = ((SymmetricDifference) _findFirst_1);
    migration.setSymmetricDifference(symmetricDifference);
    migration.setUriSymetricDifferenceModel(resSymmetricModel.getURI().toString());
  }

  public void removeUniqueConstraintName(final Migration migration) {
    EList<ResolvableOperator> resolvableOperators = migration.getResolvableSMO();
    final Function1<ResolvableOperator, Boolean> _function = (ResolvableOperator it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME));
    };
    List<ResolvableOperator> uniqueConstraintName = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function));
    for (final ResolvableOperator rO : uniqueConstraintName) {
      {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof AttributeValueChange));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(rO.getSemanticChangeSets().get(0).getChanges(), _function_1);
        AttributeValueChange ad = ((AttributeValueChange) _findFirst);
        EObject _objA = ad.getObjA();
        if ((_objA instanceof Column)) {
          EObject _objA_1 = ad.getObjA();
          Column objA = ((Column) _objA_1);
          if (((objA.getUniqueConstraintName() == null) || (objA.getUniqueConstraintName() == ""))) {
            migration.getSchemaModificationOperators().remove(rO);
          }
        }
      }
    }
  }

  public void transformRenameOperator(final Migration migration) {
    EList<ResolvableOperator> resolvableOperators = migration.getResolvableSMO();
    final Function1<ResolvableOperator, Boolean> _function = (ResolvableOperator it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.RENAME_TABLE));
    };
    List<ResolvableOperator> createTable = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function));
    for (final ResolvableOperator rO : createTable) {
      {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof AttributeValueChange));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(rO.getSemanticChangeSets().get(0).getChanges(), _function_1);
        AttributeValueChange ad = ((AttributeValueChange) _findFirst);
        EObject _objB = ad.getObjB();
        if ((_objB instanceof Column)) {
          rO.setDisplayName(ResolvableOperatorType.RENAME_COLUMN);
        }
      }
    }
  }

  public void transformNewTableOperator(final Migration migration) {
    EList<ResolvableOperator> resolvableOperators = migration.getResolvableSMO();
    final Function1<ResolvableOperator, Boolean> _function = (ResolvableOperator it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.CREATE_TABLE));
    };
    List<ResolvableOperator> createTable = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function));
    resolvableOperators.removeAll(createTable);
    for (final ResolvableOperator rO : createTable) {
      {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof AddObject));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(rO.getSemanticChangeSets().get(0).getChanges(), _function_1);
        AddObject ad = ((AddObject) _findFirst);
        EObject _obj = ad.getObj();
        Table table = ((Table) _obj);
        for (final ResolvableOperator resolvable : resolvableOperators) {
          final Function1<SemanticChangeSet, Boolean> _function_2 = (SemanticChangeSet it) -> {
            final Function1<Change, Boolean> _function_3 = (Change it_1) -> {
              return Boolean.valueOf((it_1 instanceof AddObject));
            };
            return Boolean.valueOf(IterableExtensions.<Change>exists(it.getChanges(), _function_3));
          };
          Iterable<SemanticChangeSet> _filter = IterableExtensions.<SemanticChangeSet>filter(resolvable.getSemanticChangeSets(), _function_2);
          for (final SemanticChangeSet s : _filter) {
            {
              final Function1<Change, Boolean> _function_3 = (Change it) -> {
                return Boolean.valueOf((it instanceof AddObject));
              };
              Change _findFirst_1 = IterableExtensions.<Change>findFirst(s.getChanges(), _function_3);
              AddObject a = ((AddObject) _findFirst_1);
              EObject _obj_1 = a.getObj();
              if ((_obj_1 instanceof Column)) {
                EObject _obj_2 = a.getObj();
                Column c = ((Column) _obj_2);
                boolean _equals = c.getTable().equals(table);
                if (_equals) {
                  rO.getSemanticChangeSets().addAll(resolvable.getSemanticChangeSets());
                  migration.getSchemaModificationOperators().remove(resolvable);
                  if ((c instanceof ForeignKey)) {
                    PartiallyResolvable partiallyResolvable = this.findSetReferenceOperatorForForeignKey(migration, ((ForeignKey) c));
                    if ((partiallyResolvable != null)) {
                      rO.getSemanticChangeSets().addAll(partiallyResolvable.getSemanticChangeSets());
                      migration.getSchemaModificationOperators().remove(partiallyResolvable);
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

  public PartiallyResolvable findSetReferenceOperatorForForeignKey(final Migration migration, final ForeignKey foreignKey) {
    EList<PartiallyResolvable> partiallyResolvable = migration.getPartiallyResovableSMO();
    final Function1<PartiallyResolvable, Boolean> _function = (PartiallyResolvable it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(PartiallyResolvableOperatorType.SET_FOREIGNKEYS_TARGET_TABLE));
    };
    List<PartiallyResolvable> setReferenceForeignKeys = IterableExtensions.<PartiallyResolvable>toList(IterableExtensions.<PartiallyResolvable>filter(partiallyResolvable, _function));
    for (final PartiallyResolvable setReferenceForeignKey : setReferenceForeignKeys) {
      {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof AddReference));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(setReferenceForeignKey.getSemanticChangeSets().get(0).getChanges(), _function_1);
        AddReference ad = ((AddReference) _findFirst);
        boolean _equals = ad.getSrc().equals(foreignKey);
        if (_equals) {
          return setReferenceForeignKey;
        }
      }
    }
    return null;
  }

  public void setMigrationOptionFor1N_NM_Rule(final Migration migration) {
    EList<PartiallyResolvable> partiallyResolvable = migration.getPartiallyResovableSMO();
    final Function1<PartiallyResolvable, Boolean> _function = (PartiallyResolvable it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(PartiallyResolvableOperatorType.CHANGE_1N_INTO_NM));
    };
    List<PartiallyResolvable> setMigrationOptionsList = IterableExtensions.<PartiallyResolvable>toList(IterableExtensions.<PartiallyResolvable>filter(partiallyResolvable, _function));
    for (final PartiallyResolvable setMigrationOptions : setMigrationOptionsList) {
      setMigrationOptions.setResolveOptions(ColumnOptions.MIGRATE_DATA);
    }
  }
}
