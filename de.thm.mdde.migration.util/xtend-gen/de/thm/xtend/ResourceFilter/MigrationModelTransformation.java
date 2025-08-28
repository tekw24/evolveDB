/**
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
package de.thm.xtend.ResourceFilter;

import com.google.common.collect.Iterables;
import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.ColumnConstraint;
import de.thm.evolvedb.mdde.Constraint;
import de.thm.evolvedb.mdde.Database_Schema;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.Index;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.mdde.UniqueConstraint;
import de.thm.evolvedb.migration.ColumnOptions;
import de.thm.evolvedb.migration.Migration;
import de.thm.evolvedb.migration.MigrationFactory;
import de.thm.evolvedb.migration.MigrationPackage;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.evolvedb.migration.PartiallyResolvableOperatorType;
import de.thm.evolvedb.migration.ResolvableOperator;
import de.thm.evolvedb.migration.ResolvableOperatorType;
import de.thm.evolvedb.migration.SchemaModificationOperator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;

@SuppressWarnings("all")
public class MigrationModelTransformation {
  protected MigrationPackage migrationPackage = MigrationPackage.eINSTANCE;

  protected MigrationFactory migrationFactory = this.migrationPackage.getMigrationFactory();

  public void runMigrtaionTransformation(final Resource resXtendModelFile, final Resource resSymmetricModel) {
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf((it instanceof Migration));
    };
    EObject _findFirst = IteratorExtensions.<EObject>findFirst(resXtendModelFile.getAllContents(), _function);
    Migration migration = ((Migration) _findFirst);
    this.transformNewTableOperator(migration);
    this.transformRenameOperator(migration);
    this.transformDeleteTableOperator(migration);
    this.setMigrationOptionFor1N_NM_Rule(migration);
    this.removeDatabaseSchemaChange(migration);
    this.transformConstraints(migration);
    this.transformIndexConstraints(migration);
    this.transformUniqueConstraints(migration);
    this.transformNewIndexOperator(migration);
    this.transformDeleteIndexOperator(migration);
    final Function1<EObject, Boolean> _function_1 = (EObject it) -> {
      return Boolean.valueOf((it instanceof SymmetricDifference));
    };
    EObject _findFirst_1 = IteratorExtensions.<EObject>findFirst(resSymmetricModel.getAllContents(), _function_1);
    SymmetricDifference symmetricDifference = ((SymmetricDifference) _findFirst_1);
    migration.setSymmetricDifference(symmetricDifference);
    migration.setUriSymetricDifferenceModel(resSymmetricModel.getURI().toString());
  }

  /**
   * Database schema name changes are currently not in the scope.
   */
  public void removeDatabaseSchemaChange(final Migration migration) {
    EList<ResolvableOperator> resolvableOperators = migration.getResolvableSMO();
    final Function1<ResolvableOperator, Boolean> _function = (ResolvableOperator it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.RENAME_TABLE));
    };
    List<ResolvableOperator> rename = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function));
    for (final ResolvableOperator rO : rename) {
      {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof AttributeValueChange));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(rO.getSemanticChangeSets().get(0).getChanges(), _function_1);
        AttributeValueChange ad = ((AttributeValueChange) _findFirst);
        EObject _objB = ad.getObjB();
        if ((_objB instanceof Database_Schema)) {
          migration.getSchemaModificationOperators().remove(rO);
        }
      }
    }
  }

  /**
   * Constraints can be either Indexes or Unique Constraints. Both have to be resolved seperately.
   */
  public void transformConstraints(final Migration migration) {
    EList<ResolvableOperator> resolvableOperators = migration.getResolvableSMO();
    final Function1<ResolvableOperator, Boolean> _function = (ResolvableOperator it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.CREATE_INDEX_IN_TABLE));
    };
    List<ResolvableOperator> createIndex = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function));
    for (final ResolvableOperator resolvable : createIndex) {
      {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof AddObject));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(resolvable.getSemanticChangeSets().get(0).getChanges(), _function_1);
        AddObject ad = ((AddObject) _findFirst);
        Constraint constraint = null;
        SchemaModificationOperator smo = null;
        EObject _obj = ad.getObj();
        if ((_obj instanceof UniqueConstraint)) {
          EObject _obj_1 = ad.getObj();
          UniqueConstraint uniqueConstraint = ((UniqueConstraint) _obj_1);
          migration.getSchemaModificationOperators().remove(resolvable);
          EObject _create = this.migrationFactory.create(
            this.migrationPackage.getPartiallyResolvable());
          PartiallyResolvable partiallyResolvable = ((PartiallyResolvable) _create);
          partiallyResolvable.setDisplayName(PartiallyResolvableOperatorType.CREATE_UNIQUE_CONSTRAINT);
          partiallyResolvable.getSemanticChangeSets().addAll(resolvable.getSemanticChangeSets());
          migration.getSchemaModificationOperators().add(partiallyResolvable);
          constraint = uniqueConstraint;
          smo = partiallyResolvable;
        } else {
          EObject _obj_2 = ad.getObj();
          if ((_obj_2 instanceof Index)) {
            EObject _obj_3 = ad.getObj();
            Index index = ((Index) _obj_3);
            constraint = index;
            smo = resolvable;
          }
        }
        if ((constraint != null)) {
          final Function1<ResolvableOperator, Boolean> _function_2 = (ResolvableOperator it) -> {
            return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.ADD_COLUMN_TO_INDEX));
          };
          List<ResolvableOperator> addColumnToIndex = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function_2));
          for (final ResolvableOperator r0 : addColumnToIndex) {
            {
              List<SemanticChangeSet> sets = r0.getSemanticChangeSets();
              for (final SemanticChangeSet set : sets) {
                {
                  final Function1<Change, Boolean> _function_3 = (Change it) -> {
                    return Boolean.valueOf((it instanceof AddReference));
                  };
                  Change _findFirst_1 = IterableExtensions.<Change>findFirst(set.getChanges(), _function_3);
                  AddReference ar = ((AddReference) _findFirst_1);
                  if ((ar.getSrc().equals(constraint) || ar.getTgt().equals(constraint))) {
                    migration.getSchemaModificationOperators().remove(r0);
                    EList<SemanticChangeSet> _semanticChangeSets = r0.getSemanticChangeSets();
                    for (final SemanticChangeSet temp : _semanticChangeSets) {
                      boolean _contains = smo.getSemanticChangeSets().contains(temp);
                      boolean _not = (!_contains);
                      if (_not) {
                        smo.getSemanticChangeSets().add(temp);
                      }
                    }
                  } else {
                    if ((constraint.getColumns().contains(ar.getSrc()) || constraint.getColumns().contains(ar.getTgt()))) {
                      migration.getSchemaModificationOperators().remove(r0);
                      EList<SemanticChangeSet> _semanticChangeSets_1 = r0.getSemanticChangeSets();
                      for (final SemanticChangeSet temp_1 : _semanticChangeSets_1) {
                        boolean _contains_1 = smo.getSemanticChangeSets().contains(temp_1);
                        boolean _not_1 = (!_contains_1);
                        if (_not_1) {
                          smo.getSemanticChangeSets().add(temp_1);
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
    }
  }

  /**
   * Constraints can be either Indexes or Unique Constraints. Both have to be resolved seperately.
   */
  public void transformUniqueConstraints(final Migration migration) {
    EList<PartiallyResolvable> partiallyResovableSMO = migration.getPartiallyResovableSMO();
    final Function1<PartiallyResolvable, Boolean> _function = (PartiallyResolvable it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(PartiallyResolvableOperatorType.CREATE_UNIQUE_CONSTRAINT));
    };
    List<PartiallyResolvable> createIndex = IterableExtensions.<PartiallyResolvable>toList(IterableExtensions.<PartiallyResolvable>filter(partiallyResovableSMO, _function));
    for (final PartiallyResolvable resolvable : createIndex) {
      {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof AddObject));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(resolvable.getSemanticChangeSets().get(0).getChanges(), _function_1);
        AddObject ad = ((AddObject) _findFirst);
        Constraint constraint = null;
        SchemaModificationOperator smo = null;
        EObject _obj = ad.getObj();
        if ((_obj instanceof UniqueConstraint)) {
          EObject _obj_1 = ad.getObj();
          UniqueConstraint uniqueConstraint = ((UniqueConstraint) _obj_1);
          constraint = uniqueConstraint;
          smo = resolvable;
        }
        if ((constraint != null)) {
          final Function1<ResolvableOperator, Boolean> _function_2 = (ResolvableOperator it) -> {
            return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.ADD_COLUMN_TO_INDEX));
          };
          List<ResolvableOperator> addColumnToIndex = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(migration.getResolvableSMO(), _function_2));
          for (final ResolvableOperator r0 : addColumnToIndex) {
            {
              List<SemanticChangeSet> sets = r0.getSemanticChangeSets();
              for (final SemanticChangeSet set : sets) {
                {
                  final Function1<Change, Boolean> _function_3 = (Change it) -> {
                    return Boolean.valueOf((it instanceof AddReference));
                  };
                  Change _findFirst_1 = IterableExtensions.<Change>findFirst(set.getChanges(), _function_3);
                  AddReference ar = ((AddReference) _findFirst_1);
                  if ((ar.getSrc().equals(constraint) || ar.getTgt().equals(constraint))) {
                    migration.getSchemaModificationOperators().remove(r0);
                    EList<SemanticChangeSet> _semanticChangeSets = r0.getSemanticChangeSets();
                    for (final SemanticChangeSet temp : _semanticChangeSets) {
                      boolean _contains = smo.getSemanticChangeSets().contains(temp);
                      boolean _not = (!_contains);
                      if (_not) {
                        smo.getSemanticChangeSets().add(temp);
                      }
                    }
                  } else {
                    if ((constraint.getColumns().contains(ar.getSrc()) || constraint.getColumns().contains(ar.getTgt()))) {
                      migration.getSchemaModificationOperators().remove(r0);
                      EList<SemanticChangeSet> _semanticChangeSets_1 = r0.getSemanticChangeSets();
                      for (final SemanticChangeSet temp_1 : _semanticChangeSets_1) {
                        boolean _contains_1 = smo.getSemanticChangeSets().contains(temp_1);
                        boolean _not_1 = (!_contains_1);
                        if (_not_1) {
                          smo.getSemanticChangeSets().add(temp_1);
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
    }
  }

  public void transformIndexConstraints(final Migration migration) {
    EList<ResolvableOperator> resolvableOperators = migration.getResolvableSMO();
    final Function1<ResolvableOperator, Boolean> _function = (ResolvableOperator it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.REMOVE_CONSTRAINT));
    };
    List<ResolvableOperator> createIndex = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function));
    for (final ResolvableOperator resolvable : createIndex) {
      {
        final Function1<Change, Boolean> _function_1 = (Change it) -> {
          return Boolean.valueOf((it instanceof RemoveObject));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(resolvable.getSemanticChangeSets().get(0).getChanges(), _function_1);
        RemoveObject removeObject = ((RemoveObject) _findFirst);
        if ((removeObject != null)) {
          ColumnConstraint columnConstraint = null;
          EObject _obj = removeObject.getObj();
          if ((_obj instanceof ColumnConstraint)) {
            EObject _obj_1 = removeObject.getObj();
            columnConstraint = ((ColumnConstraint) _obj_1);
            for (final ResolvableOperator reference : createIndex) {
              boolean _equals = reference.equals(resolvable);
              boolean _not = (!_equals);
              if (_not) {
                final Function1<Change, Boolean> _function_2 = (Change it) -> {
                  return Boolean.valueOf((it instanceof RemoveReference));
                };
                List<Change> changes = IterableExtensions.<Change>toList(IterableExtensions.<Change>filter(reference.getSemanticChangeSets().get(0).getChanges(), _function_2));
                for (final Change change : changes) {
                  {
                    RemoveReference removeReference = ((RemoveReference) change);
                    if ((removeReference.getSrc().equals(columnConstraint) || 
                      removeReference.getTgt().equals(columnConstraint))) {
                      resolvable.getSemanticChangeSets().addAll(reference.getSemanticChangeSets());
                      migration.getSchemaModificationOperators().remove(reference);
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

  public void removeUniqueConstraintName(final Migration migration) {
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
        } else {
          EObject _objB_1 = ad.getObjB();
          if ((_objB_1 instanceof Constraint)) {
            rO.setDisplayName(ResolvableOperatorType.SET_ATTRIBUTE_CONSTRAINT_NAME);
          } else {
            EObject _objB_2 = ad.getObjB();
            if ((_objB_2 instanceof ColumnConstraint)) {
              migration.getSchemaModificationOperators().remove(rO);
            }
          }
        }
      }
    }
  }

  public void transformDeleteTableOperator(final Migration migration) {
    EList<PartiallyResolvable> partiallyResolvable = migration.getPartiallyResovableSMO();
    final Function1<PartiallyResolvable, Boolean> _function = (PartiallyResolvable it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(PartiallyResolvableOperatorType.DELETE_TABLE));
    };
    List<PartiallyResolvable> deleteTable = IterableExtensions.<PartiallyResolvable>toList(IterableExtensions.<PartiallyResolvable>filter(partiallyResolvable, _function));
    partiallyResolvable.removeAll(deleteTable);
    final Function1<PartiallyResolvable, Boolean> _function_1 = (PartiallyResolvable it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(PartiallyResolvableOperatorType.DELETE_COLUMN));
    };
    List<PartiallyResolvable> deleteColumns = IterableExtensions.<PartiallyResolvable>toList(IterableExtensions.<PartiallyResolvable>filter(migration.getPartiallyResovableSMO(), _function_1));
    for (final PartiallyResolvable rO : deleteTable) {
      {
        final Function1<Change, Boolean> _function_2 = (Change it) -> {
          return Boolean.valueOf((it instanceof RemoveObject));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(rO.getSemanticChangeSets().get(0).getChanges(), _function_2);
        RemoveObject ad = ((RemoveObject) _findFirst);
        EObject _obj = ad.getObj();
        Table table = ((Table) _obj);
        for (final PartiallyResolvable resolvable : partiallyResolvable) {
          final Function1<SemanticChangeSet, Boolean> _function_3 = (SemanticChangeSet it) -> {
            final Function1<Change, Boolean> _function_4 = (Change it_1) -> {
              return Boolean.valueOf((it_1 instanceof RemoveObject));
            };
            return Boolean.valueOf(IterableExtensions.<Change>exists(it.getChanges(), _function_4));
          };
          Iterable<SemanticChangeSet> _filter = IterableExtensions.<SemanticChangeSet>filter(resolvable.getSemanticChangeSets(), _function_3);
          for (final SemanticChangeSet s : _filter) {
            {
              final Function1<Change, Boolean> _function_4 = (Change it) -> {
                return Boolean.valueOf((it instanceof RemoveObject));
              };
              Change _findFirst_1 = IterableExtensions.<Change>findFirst(s.getChanges(), _function_4);
              RemoveObject a = ((RemoveObject) _findFirst_1);
              EObject _obj_1 = a.getObj();
              if ((_obj_1 instanceof Column)) {
                EObject _obj_2 = a.getObj();
                Column c = ((Column) _obj_2);
                boolean _equals = c.getTable().equals(table);
                if (_equals) {
                  rO.getSemanticChangeSets().addAll(resolvable.getSemanticChangeSets());
                  migration.getSchemaModificationOperators().remove(resolvable);
                }
              } else {
                EObject _obj_3 = a.getObj();
                if ((_obj_3 instanceof Constraint)) {
                  EObject _obj_4 = a.getObj();
                  Constraint c_1 = ((Constraint) _obj_4);
                  boolean _equals_1 = c_1.getTable().equals(table);
                  if (_equals_1) {
                    rO.getSemanticChangeSets().addAll(resolvable.getSemanticChangeSets());
                    migration.getSchemaModificationOperators().remove(resolvable);
                  }
                } else {
                  EObject _obj_5 = a.getObj();
                  if ((_obj_5 instanceof ColumnConstraint)) {
                    EObject _obj_6 = a.getObj();
                    ColumnConstraint c_2 = ((ColumnConstraint) _obj_6);
                    boolean _equals_2 = c_2.getConstraint().getTable().equals(table);
                    if (_equals_2) {
                      rO.getSemanticChangeSets().addAll(resolvable.getSemanticChangeSets());
                      migration.getSchemaModificationOperators().remove(resolvable);
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

  public void transformNewTableOperator(final Migration migration) {
    EList<ResolvableOperator> resolvableOperators = migration.getResolvableSMO();
    final Function1<ResolvableOperator, Boolean> _function = (ResolvableOperator it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.CREATE_TABLE));
    };
    List<ResolvableOperator> createTable = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function));
    resolvableOperators.removeAll(createTable);
    final Function1<PartiallyResolvable, Boolean> _function_1 = (PartiallyResolvable it) -> {
      return Boolean.valueOf((it.getDisplayName().equals(PartiallyResolvableOperatorType.CREATE_UNIQUE_CONSTRAINT) || 
        it.getDisplayName().equals(PartiallyResolvableOperatorType.CREATE_PRIMARY_KEY)));
    };
    List<PartiallyResolvable> createUniqueIndex = IterableExtensions.<PartiallyResolvable>toList(IterableExtensions.<PartiallyResolvable>filter(migration.getPartiallyResovableSMO(), _function_1));
    for (final ResolvableOperator rO : createTable) {
      {
        final Function1<Change, Boolean> _function_2 = (Change it) -> {
          return Boolean.valueOf((it instanceof AddObject));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(rO.getSemanticChangeSets().get(0).getChanges(), _function_2);
        AddObject ad = ((AddObject) _findFirst);
        EObject _obj = ad.getObj();
        Table table = ((Table) _obj);
        for (final ResolvableOperator resolvable : resolvableOperators) {
          final Function1<SemanticChangeSet, Boolean> _function_3 = (SemanticChangeSet it) -> {
            final Function1<Change, Boolean> _function_4 = (Change it_1) -> {
              return Boolean.valueOf((it_1 instanceof AddObject));
            };
            return Boolean.valueOf(IterableExtensions.<Change>exists(it.getChanges(), _function_4));
          };
          Iterable<SemanticChangeSet> _filter = IterableExtensions.<SemanticChangeSet>filter(resolvable.getSemanticChangeSets(), _function_3);
          for (final SemanticChangeSet s : _filter) {
            {
              final Function1<Change, Boolean> _function_4 = (Change it) -> {
                return Boolean.valueOf((it instanceof AddObject));
              };
              Change _findFirst_1 = IterableExtensions.<Change>findFirst(s.getChanges(), _function_4);
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
              } else {
                EObject _obj_3 = a.getObj();
                if ((_obj_3 instanceof Constraint)) {
                  EObject _obj_4 = a.getObj();
                  Constraint c_1 = ((Constraint) _obj_4);
                  boolean _equals_1 = c_1.getTable().equals(table);
                  if (_equals_1) {
                    rO.getSemanticChangeSets().addAll(resolvable.getSemanticChangeSets());
                    migration.getSchemaModificationOperators().remove(resolvable);
                  }
                } else {
                  EObject _obj_5 = a.getObj();
                  if ((_obj_5 instanceof ColumnConstraint)) {
                    EObject _obj_6 = a.getObj();
                    ColumnConstraint c_2 = ((ColumnConstraint) _obj_6);
                    boolean _equals_2 = c_2.getConstraint().getTable().equals(table);
                    if (_equals_2) {
                      rO.getSemanticChangeSets().addAll(resolvable.getSemanticChangeSets());
                      migration.getSchemaModificationOperators().remove(resolvable);
                    }
                  }
                }
              }
            }
          }
        }
        for (final PartiallyResolvable resolvable_1 : createUniqueIndex) {
          final Function1<SemanticChangeSet, Boolean> _function_4 = (SemanticChangeSet it) -> {
            final Function1<Change, Boolean> _function_5 = (Change it_1) -> {
              return Boolean.valueOf((it_1 instanceof AddObject));
            };
            return Boolean.valueOf(IterableExtensions.<Change>exists(it.getChanges(), _function_5));
          };
          Iterable<SemanticChangeSet> _filter_1 = IterableExtensions.<SemanticChangeSet>filter(resolvable_1.getSemanticChangeSets(), _function_4);
          for (final SemanticChangeSet s_1 : _filter_1) {
            {
              final Function1<Change, Boolean> _function_5 = (Change it) -> {
                return Boolean.valueOf((it instanceof AddObject));
              };
              Change _findFirst_1 = IterableExtensions.<Change>findFirst(s_1.getChanges(), _function_5);
              AddObject a = ((AddObject) _findFirst_1);
              EObject _obj_1 = a.getObj();
              if ((_obj_1 instanceof Constraint)) {
                EObject _obj_2 = a.getObj();
                Constraint c = ((Constraint) _obj_2);
                boolean _equals = c.getTable().equals(table);
                if (_equals) {
                  rO.getSemanticChangeSets().addAll(resolvable_1.getSemanticChangeSets());
                  migration.getSchemaModificationOperators().remove(resolvable_1);
                }
              } else {
                EObject _obj_3 = a.getObj();
                if ((_obj_3 instanceof ColumnConstraint)) {
                  EObject _obj_4 = a.getObj();
                  ColumnConstraint c_1 = ((ColumnConstraint) _obj_4);
                  boolean _equals_1 = c_1.getConstraint().getTable().equals(table);
                  if (_equals_1) {
                    rO.getSemanticChangeSets().addAll(resolvable_1.getSemanticChangeSets());
                    migration.getSchemaModificationOperators().remove(resolvable_1);
                  }
                } else {
                  EObject _obj_5 = a.getObj();
                  if ((_obj_5 instanceof PrimaryKey)) {
                    EObject _obj_6 = a.getObj();
                    PrimaryKey c_2 = ((PrimaryKey) _obj_6);
                    boolean _equals_2 = c_2.getTable().equals(table);
                    if (_equals_2) {
                      rO.getSemanticChangeSets().addAll(resolvable_1.getSemanticChangeSets());
                      migration.getSchemaModificationOperators().remove(resolvable_1);
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

  public void transformNewIndexOperator(final Migration migration) {
    EList<ResolvableOperator> resolvableOperators = migration.getResolvableSMO();
    final Function1<ResolvableOperator, Boolean> _function = (ResolvableOperator it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.CREATE_INDEX_IN_TABLE));
    };
    List<ResolvableOperator> createIndex = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function));
    final Function1<ResolvableOperator, Boolean> _function_1 = (ResolvableOperator it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.ADD_COLUMN_TO_INDEX));
    };
    List<ResolvableOperator> addColumnIndex = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function_1));
    resolvableOperators.removeAll(createIndex);
    for (final ResolvableOperator rO : createIndex) {
      {
        final Function1<Change, Boolean> _function_2 = (Change it) -> {
          return Boolean.valueOf((it instanceof AddObject));
        };
        Change _findFirst = IterableExtensions.<Change>findFirst(rO.getSemanticChangeSets().get(0).getChanges(), _function_2);
        AddObject ad = ((AddObject) _findFirst);
        EObject _obj = ad.getObj();
        Constraint constraint = ((Constraint) _obj);
        for (final ResolvableOperator resolvable : addColumnIndex) {
          final Function1<SemanticChangeSet, Boolean> _function_3 = (SemanticChangeSet it) -> {
            final Function1<Change, Boolean> _function_4 = (Change it_1) -> {
              return Boolean.valueOf((it_1 instanceof AddReference));
            };
            return Boolean.valueOf(IterableExtensions.<Change>exists(it.getChanges(), _function_4));
          };
          Iterable<SemanticChangeSet> _filter = IterableExtensions.<SemanticChangeSet>filter(resolvable.getSemanticChangeSets(), _function_3);
          for (final SemanticChangeSet s : _filter) {
            {
              final Function1<Change, Boolean> _function_4 = (Change it) -> {
                return Boolean.valueOf((it instanceof AddReference));
              };
              Change _findFirst_1 = IterableExtensions.<Change>findFirst(s.getChanges(), _function_4);
              AddReference a = ((AddReference) _findFirst_1);
              EObject _src = a.getSrc();
              if ((_src instanceof ColumnConstraint)) {
                EObject _src_1 = a.getSrc();
                ColumnConstraint c = ((ColumnConstraint) _src_1);
                boolean _equals = c.getConstraint().equals(constraint);
                if (_equals) {
                  rO.getSemanticChangeSets().addAll(resolvable.getSemanticChangeSets());
                  migration.getSchemaModificationOperators().remove(resolvable);
                }
              }
            }
          }
        }
      }
    }
  }

  public void transformDeleteIndexOperator(final Migration migration) {
    EList<ResolvableOperator> resolvableOperators = migration.getResolvableSMO();
    final Function1<ResolvableOperator, Boolean> _function = (ResolvableOperator it) -> {
      return Boolean.valueOf(it.getDisplayName().equals(ResolvableOperatorType.REMOVE_CONSTRAINT));
    };
    List<ResolvableOperator> removeIndex = IterableExtensions.<ResolvableOperator>toList(IterableExtensions.<ResolvableOperator>filter(resolvableOperators, _function));
    List<ResolvableOperator> deleteIndex = new ArrayList<ResolvableOperator>();
    Map<Constraint, ResolvableOperator> map = new TreeMap<Constraint, ResolvableOperator>(new Comparator() {
      @Override
      public int compare(final Object o1, final Object o2) {
        Constraint constraint1 = ((Constraint) o1);
        Constraint constraint2 = ((Constraint) o2);
        boolean _equals = constraint1.equals(constraint2);
        if (_equals) {
          return 0;
        }
        return constraint1.toString().compareTo(constraint2.toString());
      }
    });
    for (final ResolvableOperator rO : removeIndex) {
      {
        SemanticChangeSet defaultValue = rO.getSemanticChangeSets().get(0);
        if ((defaultValue.getEditRName().equals("DELETE_Index_IN_Table_(constraints)") || 
          defaultValue.getEditRName().equals("DELETE_UniqueConstraint_IN_Table_(constraints)"))) {
          deleteIndex.add(rO);
          List<RemoveObject> changeColumnType = IterableExtensions.<RemoveObject>toList(Iterables.<RemoveObject>filter(rO.getSemanticChangeSets().get(0).getChanges(), RemoveObject.class));
          int _size = changeColumnType.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            for (final RemoveObject a : changeColumnType) {
              EObject _obj = a.getObj();
              if ((_obj instanceof Constraint)) {
                EObject _obj_1 = a.getObj();
                Constraint objA = ((Constraint) _obj_1);
                map.put(objA, rO);
              }
            }
          }
        }
      }
    }
    removeIndex.removeAll(deleteIndex);
    for (final ResolvableOperator rO_1 : removeIndex) {
      {
        List<RemoveObject> changeColumnType = IterableExtensions.<RemoveObject>toList(Iterables.<RemoveObject>filter(rO_1.getSemanticChangeSets().get(0).getChanges(), RemoveObject.class));
        int _size = changeColumnType.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          for (final RemoveObject a : changeColumnType) {
            EObject _obj = a.getObj();
            if ((_obj instanceof ColumnConstraint)) {
              EObject _obj_1 = a.getObj();
              ColumnConstraint objA = ((ColumnConstraint) _obj_1);
              Constraint constraint = objA.getConstraint();
              boolean _contains = map.keySet().contains(constraint);
              if (_contains) {
                ResolvableOperator delete = map.get(constraint);
                delete.getSemanticChangeSets().addAll(rO_1.getSemanticChangeSets());
                migration.getSchemaModificationOperators().remove(rO_1);
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
