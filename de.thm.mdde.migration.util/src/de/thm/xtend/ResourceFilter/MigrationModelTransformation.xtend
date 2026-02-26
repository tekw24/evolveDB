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
package de.thm.xtend.ResourceFilter

import org.eclipse.emf.ecore.resource.Resource
import de.thm.evolvedb.migration.Migration
import org.eclipse.emf.common.util.EList
import de.thm.evolvedb.migration.ResolvableOperator
import de.thm.evolvedb.migration.ResolvableOperatorType
import java.util.List
import org.sidiff.difference.symmetric.AddObject
import org.sidiff.difference.symmetric.SemanticChangeSet
import de.thm.evolvedb.mdde.Column
import de.thm.evolvedb.mdde.Table
import de.thm.evolvedb.mdde.ForeignKey
import de.thm.evolvedb.migration.PartiallyResolvable
import de.thm.evolvedb.migration.PartiallyResolvableOperatorType
import org.sidiff.difference.symmetric.AddReference
import org.sidiff.difference.symmetric.SymmetricDifference
import org.sidiff.difference.symmetric.AttributeValueChange
import de.thm.evolvedb.migration.ColumnOptions
import de.thm.evolvedb.mdde.Constraint
import de.thm.evolvedb.mdde.UniqueConstraint
import de.thm.evolvedb.mdde.Index
import de.thm.evolvedb.migration.MigrationFactory
import de.thm.evolvedb.migration.MigrationPackage
import de.thm.evolvedb.mdde.MddeFactory
import de.thm.evolvedb.mdde.MddePackage
import de.thm.evolvedb.migration.SchemaModificationOperator
import de.thm.evolvedb.mdde.Database_Schema
import org.sidiff.difference.symmetric.RemoveObject
import de.thm.evolvedb.mdde.ColumnConstraint
import org.sidiff.difference.symmetric.RemoveReference
import org.sidiff.difference.symmetric.Change
import java.util.ArrayList
import java.util.TreeMap
import java.util.Map
import java.util.Comparator
import de.thm.evolvedb.mdde.PrimaryKey
import de.thm.evolvedb.migration.GraphResolvableOperator
import de.thm.evolvedb.migration.GraphResolvableOperatorType
import de.thm.evolvedb.graph.Label
import de.thm.evolvedb.graph.Property
import de.thm.evolvedb.graph.PropertyValueType
import de.thm.evolvedb.graph.EdgeType
import de.thm.evolvedb.graph.NodeType
import de.thm.evolvedb.migration.GraphPartiallyResolvableOperator
import de.thm.evolvedb.migration.GraphPartiallyResolvableOperatorType
import de.thm.evolvedb.graph.KeyConstraint

class MigrationModelTransformation {

	protected MigrationPackage migrationPackage = MigrationPackage.eINSTANCE;
	protected MigrationFactory migrationFactory = migrationPackage.migrationFactory;

	def runMigrtaionTransformation(Resource resXtendModelFile, Resource resSymmetricModel) {

		var Migration migration = resXtendModelFile.allContents.findFirst[it instanceof Migration] as Migration

		// Relational Model
		migration.transformNewTableOperator
		migration.transformRenameOperator
		migration.transformDeleteTableOperator
		migration.setMigrationOptionFor1N_NM_Rule
		migration.removeDatabaseSchemaChange
		migration.transformConstraints
		migration.transformIndexConstraints
		migration.transformUniqueConstraints
		migration.transformNewIndexOperator
		migration.transformDeleteIndexOperator
		// graphModel
		migration.transformNewPropertyValueType
		migration.transformNewLabelOperator
		migration.transformNewEdgeType
		migration.transformAddNodeType
		migration.transformDeleteEdgeType
		migration.transformDeleteNodeType
		migration.transformDeleteConstraint
		migration.transformNewConstraints

		var SymmetricDifference symmetricDifference = resSymmetricModel.allContents.findFirst [
			it instanceof SymmetricDifference
		] as SymmetricDifference
		migration.symmetricDifference = symmetricDifference
		migration.uriSymetricDifferenceModel = resSymmetricModel.URI.toString;
// migration.symetricDifferenceModel = resSymmetricModel
	}

	/**
	 * Database schema name changes are currently not in the scope.
	 */
	def void removeDatabaseSchemaChange(Migration migration) {
		var EList<ResolvableOperator> resolvableOperators = migration.resolvableSMO;
		var List<ResolvableOperator> rename = resolvableOperators.filter [
			it.displayName.equals(ResolvableOperatorType.RENAME_TABLE)
		].toList

		for (ResolvableOperator rO : rename) {
			var AttributeValueChange ad = rO.semanticChangeSets.get(0).changes.findFirst [
				it instanceof AttributeValueChange
			] as AttributeValueChange;
			if (ad.objB instanceof Database_Schema) {
				migration.schemaModificationOperators.remove(rO);
			}
		}
	}

	/**
	 * Constraints can be either Indexes or Unique Constraints. Both have to be resolved seperately.
	 */
	def void transformConstraints(Migration migration) {
		var EList<ResolvableOperator> resolvableOperators = migration.resolvableSMO;
		var List<ResolvableOperator> createIndex = resolvableOperators.filter [
			it.displayName.equals(ResolvableOperatorType.CREATE_INDEX_IN_TABLE)
		].toList
		for (ResolvableOperator resolvable : createIndex) {

			var AddObject ad = resolvable.semanticChangeSets.get(0).changes.
				findFirst[it instanceof AddObject] as AddObject;

			var Constraint constraint;
			var SchemaModificationOperator smo;

			if (ad.obj instanceof UniqueConstraint) {
				var UniqueConstraint uniqueConstraint = ad.obj as UniqueConstraint;

				migration.schemaModificationOperators.remove(resolvable);

				var PartiallyResolvable partiallyResolvable = migrationFactory.create(
					migrationPackage.partiallyResolvable) as PartiallyResolvable;
				partiallyResolvable.displayName = PartiallyResolvableOperatorType.CREATE_UNIQUE_CONSTRAINT
				partiallyResolvable.semanticChangeSets.addAll(resolvable.semanticChangeSets);
				migration.schemaModificationOperators.add(partiallyResolvable)

				constraint = uniqueConstraint
				smo = partiallyResolvable

			} else if (ad.obj instanceof Index) {
				var Index index = ad.obj as Index;
				constraint = index
				smo = resolvable
			}

			if (constraint !== null) {
				var List<ResolvableOperator> addColumnToIndex = resolvableOperators.filter [
					it.displayName.equals(ResolvableOperatorType.ADD_COLUMN_TO_INDEX)
				].toList
				for (ResolvableOperator r0 : addColumnToIndex) {
					var List<SemanticChangeSet> sets = r0.semanticChangeSets

					for (SemanticChangeSet set : sets) {

						var AddReference ar = set.changes.findFirst[it instanceof AddReference] as AddReference;
						if (ar.src.equals(constraint) || ar.tgt.equals(constraint)) {

							migration.schemaModificationOperators.remove(r0);

							for (temp : r0.semanticChangeSets) {
								if (!smo.semanticChangeSets.contains(temp))
									smo.semanticChangeSets.add(temp);
							}

						} else if (constraint.columns.contains(ar.src) || constraint.columns.contains(ar.tgt)) {
							migration.schemaModificationOperators.remove(r0);

							for (temp : r0.semanticChangeSets) {
								if (!smo.semanticChangeSets.contains(temp))
									smo.semanticChangeSets.add(temp);
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
	def void transformUniqueConstraints(Migration migration) {
		var EList<PartiallyResolvable> partiallyResovableSMO = migration.partiallyResovableSMO;
		var List<PartiallyResolvable> createIndex = partiallyResovableSMO.filter [
			it.displayName.equals(PartiallyResolvableOperatorType.CREATE_UNIQUE_CONSTRAINT)
		].toList
		for (PartiallyResolvable resolvable : createIndex) {

			var AddObject ad = resolvable.semanticChangeSets.get(0).changes.
				findFirst[it instanceof AddObject] as AddObject;

			var Constraint constraint;
			var SchemaModificationOperator smo;

			if (ad.obj instanceof UniqueConstraint) {
				var UniqueConstraint uniqueConstraint = ad.obj as UniqueConstraint;

				constraint = uniqueConstraint
				smo = resolvable

			}
			if (constraint !== null) {
				var List<ResolvableOperator> addColumnToIndex = migration.resolvableSMO.filter [
					it.displayName.equals(ResolvableOperatorType.ADD_COLUMN_TO_INDEX)
				].toList
				for (ResolvableOperator r0 : addColumnToIndex) {
					var List<SemanticChangeSet> sets = r0.semanticChangeSets

					for (SemanticChangeSet set : sets) {

						var AddReference ar = set.changes.findFirst[it instanceof AddReference] as AddReference;
						if (ar.src.equals(constraint) || ar.tgt.equals(constraint)) {

							migration.schemaModificationOperators.remove(r0);

							for (temp : r0.semanticChangeSets) {
								if (!smo.semanticChangeSets.contains(temp))
									smo.semanticChangeSets.add(temp);
							}

						} else if (constraint.columns.contains(ar.src) || constraint.columns.contains(ar.tgt)) {
							migration.schemaModificationOperators.remove(r0);

							for (temp : r0.semanticChangeSets) {
								if (!smo.semanticChangeSets.contains(temp))
									smo.semanticChangeSets.add(temp);
							}
						}

					}

				}

			}

		}

	}

	def void transformIndexConstraints(Migration migration) {
		var EList<ResolvableOperator> resolvableOperators = migration.resolvableSMO;
		var List<ResolvableOperator> createIndex = resolvableOperators.filter [
			it.displayName.equals(ResolvableOperatorType.REMOVE_CONSTRAINT)
		].toList

		for (ResolvableOperator resolvable : createIndex) {

			var RemoveObject removeObject = resolvable.semanticChangeSets.get(0).changes.findFirst [
				it instanceof RemoveObject
			] as RemoveObject;

			if (removeObject !== null) {

				var ColumnConstraint columnConstraint;

				if (removeObject.obj instanceof ColumnConstraint) {

					columnConstraint = removeObject.obj as ColumnConstraint;
					for (ResolvableOperator reference : createIndex) {

						if (!reference.equals(resolvable)) {

							var List<Change> changes = reference.semanticChangeSets.get(0).changes.filter [
								it instanceof RemoveReference
							].toList

							for (Change change : changes) {
								var RemoveReference removeReference = change as RemoveReference;

								if (removeReference.src.equals(columnConstraint) ||
									removeReference.tgt.equals(columnConstraint)) {
									// TODO Operatoren werden vereinheitlicht	
									resolvable.semanticChangeSets.addAll(reference.semanticChangeSets)
									migration.schemaModificationOperators.remove(reference);

								}

							}

						}

					}

				}

			}
		}
	}

	def void removeUniqueConstraintName(Migration migration) {
//
//		var EList<ResolvableOperator> resolvableOperators = migration.resolvableSMO;
//		var List<ResolvableOperator> uniqueConstraintName = resolvableOperators.filter [
//			it.displayName.equals(ResolvableOperatorType.SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME)
//		].toList
//
//		for (ResolvableOperator rO : uniqueConstraintName) {
//			var AttributeValueChange ad = rO.semanticChangeSets.get(0).changes.findFirst [
//				it instanceof AttributeValueChange
//			] as AttributeValueChange;
//			if (ad.objA instanceof Column) {
//				var objA = ad.objA as Column
////				if(objA.uniqueConstraintName === null || objA.uniqueConstraintName === ''){
////					// Has to be removed becaus of the setUniqueConstraint Operator
////					migration.schemaModificationOperators.remove(rO) TODO
////				}
//			}
//
//		}
	}

	def transformRenameOperator(Migration migration) {
		var EList<ResolvableOperator> resolvableOperators = migration.resolvableSMO;
		var List<ResolvableOperator> createTable = resolvableOperators.filter [
			it.displayName.equals(ResolvableOperatorType.RENAME_TABLE)
		].toList

		for (ResolvableOperator rO : createTable) {
			var AttributeValueChange ad = rO.semanticChangeSets.get(0).changes.findFirst [
				it instanceof AttributeValueChange
			] as AttributeValueChange;
			if (ad.objB instanceof Column) {
				rO.displayName = ResolvableOperatorType.RENAME_COLUMN;

			} else if (ad.objB instanceof Constraint) {
				rO.displayName = ResolvableOperatorType.SET_ATTRIBUTE_CONSTRAINT_NAME;

			} else if (ad.objB instanceof ColumnConstraint) {
				migration.schemaModificationOperators.remove(rO);
			}

		}

	}

	/**
	 * 
	 */
	def transformDeleteTableOperator(Migration migration) {
		var EList<PartiallyResolvable> partiallyResolvable = migration.partiallyResovableSMO;
		var List<PartiallyResolvable> deleteTable = partiallyResolvable.filter [
			it.displayName.equals(PartiallyResolvableOperatorType.DELETE_TABLE)
		].toList
		partiallyResolvable.removeAll(deleteTable);

		var List<PartiallyResolvable> deleteColumns = migration.partiallyResovableSMO.filter [
			it.displayName.equals(PartiallyResolvableOperatorType.DELETE_COLUMN)
		].toList

		for (PartiallyResolvable rO : deleteTable) {

			var RemoveObject ad = rO.semanticChangeSets.get(0).changes.
				findFirst[it instanceof RemoveObject] as RemoveObject;
			var Table table = ad.obj as Table

			for (PartiallyResolvable resolvable : partiallyResolvable) {

				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof RemoveObject]
				]) {
					var RemoveObject a = s.changes.findFirst[it instanceof RemoveObject] as RemoveObject
					if (a.obj instanceof Column) {
						var Column c = a.obj as Column;
						if (c.table.equals(table)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						// If it is a foreignKey a setReferenceOperator should exist
//							if (c instanceof ForeignKey) {
//								var PartiallyResolvable partiallyResolvable = findSetReferenceOperatorForForeignKey(
//									migration, (c as ForeignKey))
//								if (partiallyResolvable !== null) {
//									rO.semanticChangeSets.addAll(partiallyResolvable.semanticChangeSets)
//									migration.schemaModificationOperators.remove(partiallyResolvable)
//								}
//							}
						}

					} else if (a.obj instanceof Constraint) {
						var Constraint c = a.obj as Constraint;
						if (c.table.equals(table)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						// If it is a foreignKey a setReferenceOperator should exist
						}

					} else if (a.obj instanceof ColumnConstraint) {
						var ColumnConstraint c = a.obj as ColumnConstraint;
						if (c.constraint.table.equals(table)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						// If it is a foreignKey a setReferenceOperator should exist
						}

					}

				}

			// filter[it instanceof AddObject]
			}

		}

	}

	/**
	 * 
	 */
	def transformNewTableOperator(Migration migration) {
		var EList<ResolvableOperator> resolvableOperators = migration.resolvableSMO;
		var List<ResolvableOperator> createTable = resolvableOperators.filter [
			it.displayName.equals(ResolvableOperatorType.CREATE_TABLE)
		].toList
		resolvableOperators.removeAll(createTable);

		var List<PartiallyResolvable> createUniqueIndex = migration.partiallyResovableSMO.filter [
			it.displayName.equals(PartiallyResolvableOperatorType.CREATE_UNIQUE_CONSTRAINT) ||
				it.displayName.equals(PartiallyResolvableOperatorType.CREATE_PRIMARY_KEY)
		].toList

		for (ResolvableOperator rO : createTable) {

			var AddObject ad = rO.semanticChangeSets.get(0).changes.findFirst[it instanceof AddObject] as AddObject;
			var Table table = ad.obj as Table

			for (ResolvableOperator resolvable : resolvableOperators) {

				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof AddObject]
				]) {
					var AddObject a = s.changes.findFirst[it instanceof AddObject] as AddObject
					if (a.obj instanceof Column) {
						var Column c = a.obj as Column;
						if (c.table.equals(table)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
							// If it is a foreignKey a setReferenceOperator should exist
							if (c instanceof ForeignKey) {
								var PartiallyResolvable partiallyResolvable = findSetReferenceOperatorForForeignKey(
									migration, (c as ForeignKey))
								if (partiallyResolvable !== null) {
									rO.semanticChangeSets.addAll(partiallyResolvable.semanticChangeSets)
									migration.schemaModificationOperators.remove(partiallyResolvable)
								}
							}
						}

					} else if (a.obj instanceof Constraint) {
						var Constraint c = a.obj as Constraint;
						if (c.table.equals(table)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						// If it is a foreignKey a setReferenceOperator should exist
						}

					} else if (a.obj instanceof ColumnConstraint) {
						var ColumnConstraint c = a.obj as ColumnConstraint;
						if (c.constraint.table.equals(table)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						// If it is a foreignKey a setReferenceOperator should exist
						}

					}

				}

			// filter[it instanceof AddObject]
			}

			for (PartiallyResolvable resolvable : createUniqueIndex) {

				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof AddObject]
				]) {
					var AddObject a = s.changes.findFirst[it instanceof AddObject] as AddObject
					if (a.obj instanceof Constraint) {
						var Constraint c = a.obj as Constraint;
						if (c.table.equals(table)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						// If it is a foreignKey a setReferenceOperator should exist
						}

					} else if (a.obj instanceof ColumnConstraint) {
						var ColumnConstraint c = a.obj as ColumnConstraint;
						if (c.constraint.table.equals(table)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						// If it is a foreignKey a setReferenceOperator should exist
						}

					} else if (a.obj instanceof PrimaryKey) {
						var PrimaryKey c = a.obj as PrimaryKey;
						if (c.table.equals(table)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}

					}
				}

			}

		}

	}

	/**
	 * 
	 */
	def transformNewIndexOperator(Migration migration) {
		var EList<ResolvableOperator> resolvableOperators = migration.resolvableSMO;
		var List<ResolvableOperator> createIndex = resolvableOperators.filter [
			it.displayName.equals(ResolvableOperatorType.CREATE_INDEX_IN_TABLE)
		].toList

		var List<ResolvableOperator> addColumnIndex = resolvableOperators.filter [
			it.displayName.equals(ResolvableOperatorType.ADD_COLUMN_TO_INDEX)
		].toList

		resolvableOperators.removeAll(createIndex);

		for (ResolvableOperator rO : createIndex) {

			var AddObject ad = rO.semanticChangeSets.get(0).changes.findFirst[it instanceof AddObject] as AddObject;
			var Constraint constraint = ad.obj as Constraint

			for (ResolvableOperator resolvable : addColumnIndex) {

				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof AddReference]
				]) {
					var AddReference a = s.changes.findFirst[it instanceof AddReference] as AddReference
					if (a.src instanceof ColumnConstraint) {

						var ColumnConstraint c = a.src as ColumnConstraint;
						if (c.constraint.equals(constraint)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}

					}
				}

			// filter[it instanceof AddObject]
			}

		}

	}

	/**
	 * 
	 */
	def transformDeleteIndexOperator(Migration migration) {
		var EList<ResolvableOperator> resolvableOperators = migration.resolvableSMO;
		var List<ResolvableOperator> removeIndex = resolvableOperators.filter [
			it.displayName.equals(ResolvableOperatorType.REMOVE_CONSTRAINT)
		].toList

		var List<ResolvableOperator> deleteIndex = new ArrayList
		var Map<Constraint, ResolvableOperator> map = new TreeMap(new Comparator() {

			override compare(Object o1, Object o2) {
				var Constraint constraint1 = o1 as Constraint
				var Constraint constraint2 = o2 as Constraint

				if (constraint1.equals(constraint2))
					return 0;

				return constraint1.toString.compareTo(constraint2.toString)

			}

		})
		for (ResolvableOperator rO : removeIndex) {
			var SemanticChangeSet defaultValue = rO.semanticChangeSets.get(0);
			if (defaultValue.editRName.equals('DELETE_Index_IN_Table_(constraints)') ||
				defaultValue.editRName.equals('DELETE_UniqueConstraint_IN_Table_(constraints)')) {
				deleteIndex.add(rO);
				var List<RemoveObject> changeColumnType = rO.semanticChangeSets.get(0).changes.filter(RemoveObject).
					toList

				if (changeColumnType.size > 0) {

					for (RemoveObject a : changeColumnType) {

						if (a.obj instanceof Constraint) {

							var objA = a.obj as Constraint
							map.put(objA, rO);

						}

					}
				}

			}
		}

		removeIndex.removeAll(deleteIndex);

		for (ResolvableOperator rO : removeIndex) {
			var List<RemoveObject> changeColumnType = rO.semanticChangeSets.get(0).changes.filter(RemoveObject).toList

			if (changeColumnType.size > 0) {

				for (RemoveObject a : changeColumnType) {
					if (a.obj instanceof ColumnConstraint) {

						var objA = a.obj as ColumnConstraint
						var constraint = objA.constraint

						if (map.keySet.contains(constraint)) {
							var ResolvableOperator delete = map.get(constraint);
							delete.semanticChangeSets.addAll(rO.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(rO);
						}

					}
				}
			}

//		resolvableOperators.removeAll(createIndex);
//
//		for (ResolvableOperator rO : createIndex) {
//
//			var AddObject ad = rO.semanticChangeSets.get(0).changes.findFirst[it instanceof AddObject] as AddObject;
//			var Constraint constraint = ad.obj as Constraint
//
//			for (ResolvableOperator resolvable : addColumnIndex) {
//
//				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
//					it.changes.exists[it instanceof AddReference]
//				]) {
//					var AddReference a = s.changes.findFirst[it instanceof AddReference] as AddReference
//					if (a.src instanceof ColumnConstraint) {
//
//						var ColumnConstraint c = a.src as ColumnConstraint;
//						if (c.constraint.equals(constraint)) {
//							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
//							// Remove the Operator
//							migration.schemaModificationOperators.remove(resolvable)
//						}
//
//					}
//				}
//
//			// filter[it instanceof AddObject]
//			}
//
//		}
		}

	}

	def PartiallyResolvable findSetReferenceOperatorForForeignKey(Migration migration, ForeignKey foreignKey) {
		var EList<PartiallyResolvable> partiallyResolvable = migration.partiallyResovableSMO;
		var List<PartiallyResolvable> setReferenceForeignKeys = partiallyResolvable.filter [
			it.displayName.equals(PartiallyResolvableOperatorType.SET_FOREIGNKEYS_TARGET_TABLE)
		].toList

		for (PartiallyResolvable setReferenceForeignKey : setReferenceForeignKeys) {
			var AddReference ad = setReferenceForeignKey.semanticChangeSets.get(0).changes.findFirst [
				it instanceof AddReference
			] as AddReference;
			if (ad.src.equals(foreignKey)) {
				return setReferenceForeignKey;
			}
		}

		return null
	}

	def setMigrationOptionFor1N_NM_Rule(Migration migration) {

		var EList<PartiallyResolvable> partiallyResolvable = migration.partiallyResovableSMO;
		var List<PartiallyResolvable> setMigrationOptionsList = partiallyResolvable.filter [
			it.displayName.equals(PartiallyResolvableOperatorType.CHANGE_1N_INTO_NM)
		].toList

		for (PartiallyResolvable setMigrationOptions : setMigrationOptionsList) {
			setMigrationOptions.resolveOptions = ColumnOptions.MIGRATE_DATA;
		}
	}

	/**
	 * Transforms new label operator. 
	 */
	def transformNewLabelOperator(Migration migration) {
		var EList<GraphResolvableOperator> resolvableOperators = migration.graphResolvableSMO;
		var List<GraphResolvableOperator> createTable = resolvableOperators.filter [
			it.displayName.equals(GraphResolvableOperatorType.CREATE_LABEL)
		].toList
		resolvableOperators.removeAll(createTable);

		var List<PartiallyResolvable> createUniqueIndex = migration.partiallyResovableSMO.filter [
			it.displayName.equals(PartiallyResolvableOperatorType.CREATE_UNIQUE_CONSTRAINT) ||
				it.displayName.equals(PartiallyResolvableOperatorType.CREATE_PRIMARY_KEY)
		].toList

		for (GraphResolvableOperator rO : createTable) {

			var AddObject ad = rO.semanticChangeSets.get(0).changes.findFirst[it instanceof AddObject] as AddObject;
			var Label label = ad.obj as Label

			for (GraphResolvableOperator resolvable : resolvableOperators) {

				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof AddObject]
				]) {
					var AddObject a = s.changes.findFirst[it instanceof AddObject] as AddObject
					if (a.obj instanceof Property) {
						var Property c = a.obj as Property;
						if (c.getContainerElement().equals(label)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}

					}
//					else if (a.obj instanceof Constraint) {
//						var Constraint c = a.obj as Constraint;
//						if (c.table.equals(table)) {
//							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
//							// Remove the Operator
//							migration.schemaModificationOperators.remove(resolvable)
//						// If it is a foreignKey a setReferenceOperator should exist
//						}
//
//					} else if (a.obj instanceof ColumnConstraint) {
//						var ColumnConstraint c = a.obj as ColumnConstraint;
//						if (c.constraint.table.equals(table)) {
//							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
//							// Remove the Operator
//							migration.schemaModificationOperators.remove(resolvable)
//						// If it is a foreignKey a setReferenceOperator should exist
//						}
//
//					}
				}

			// filter[it instanceof AddObject]
			}

//			for (PartiallyResolvable resolvable : createUniqueIndex) {
//
//				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
//					it.changes.exists[it instanceof AddObject]
//				]) {
//					var AddObject a = s.changes.findFirst[it instanceof AddObject] as AddObject
//					if (a.obj instanceof Constraint) {
//						var Constraint c = a.obj as Constraint;
//						if (c.table.equals(table)) {
//							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
//							// Remove the Operator
//							migration.schemaModificationOperators.remove(resolvable)
//						// If it is a foreignKey a setReferenceOperator should exist
//						}
//
//					} else if (a.obj instanceof ColumnConstraint) {
//						var ColumnConstraint c = a.obj as ColumnConstraint;
//						if (c.constraint.table.equals(table)) {
//							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
//							// Remove the Operator
//							migration.schemaModificationOperators.remove(resolvable)
//						// If it is a foreignKey a setReferenceOperator should exist
//						}
//
//					}
//					else if (a.obj instanceof PrimaryKey) {
//						var PrimaryKey c = a.obj as PrimaryKey;
//						if (c.table.equals(table)) {
//							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
//							// Remove the Operator
//							migration.schemaModificationOperators.remove(resolvable)
//						}
//
//					}
//				}
//
//			}
		}

	}

	def transformNewPropertyValueType(Migration migration) {
		var EList<GraphResolvableOperator> resolvableOperators = migration.graphResolvableSMO;
		var List<GraphResolvableOperator> createProperty = resolvableOperators.filter [
			it.displayName.equals(GraphResolvableOperatorType.CREATE_PROPERTY)
		].toList
		resolvableOperators.removeAll(createProperty);

		for (GraphResolvableOperator rO : createProperty) {
			var AddObject ad = rO.semanticChangeSets.get(0).changes.findFirst[it instanceof AddObject] as AddObject;
			var Property property = ad.obj as Property

			for (GraphResolvableOperator resolvable : resolvableOperators) {
				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof AddObject]
				]) {
					var AddObject a = s.changes.findFirst[it instanceof AddObject] as AddObject
					if (a.obj instanceof PropertyValueType) {
						var PropertyValueType c = a.obj as PropertyValueType;
						if (c.property.equals(property)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}

					}

				}
			}
		}
	}

	def transformNewEdgeType(Migration migration) {
		var EList<GraphResolvableOperator> resolvableOperators = migration.graphResolvableSMO;
		var List<GraphResolvableOperator> createEdgeType = resolvableOperators.filter [
			it.displayName.equals(GraphResolvableOperatorType.CREATE_EDGE_TYPE)
		].toList
		resolvableOperators.removeAll(createEdgeType);

		for (GraphResolvableOperator rO : createEdgeType) {
			var AddObject ad = rO.semanticChangeSets.get(0).changes.findFirst[it instanceof AddObject] as AddObject;
			var EdgeType newEdgeType = ad.obj as EdgeType

			for (GraphResolvableOperator resolvable : resolvableOperators) {
				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof AddReference] &&
						(it.name.equals("ADD_EdgeType_(labels)_TGT_EdgeLabel") ||
							it.name.equals("ADD_NodeType_(incoming)_TGT_EdgeType") ||
							it.name.equals("ADD_NodeType_(outgoing)_TGT_EdgeType") ||
							it.name.equals("SET_REFERENCE_EdgeType_(tgt)_TGT_NodeType") ||
							it.name.equals("SET_REFERENCE_EdgeType_(src)_TGT_NodeType") ||
							it.name.equals("ADD_EdgeLabel_(edges)_TGT_EdgeType")
							)

				]) {
					var AddReference a = s.changes.findFirst[it instanceof AddReference] as AddReference
					if (a.src instanceof EdgeType) {
						var EdgeType c = a.src as EdgeType;
						if (c.equals(newEdgeType)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}

					} else if (a.tgt instanceof EdgeType) {
						var EdgeType c = a.tgt as EdgeType;
						if (c.equals(newEdgeType)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}
					}

				}
			}
		}
	}

	def transformDeleteEdgeType(Migration migration) {
		var EList<GraphPartiallyResolvableOperator> partiallayResolvableOperators = migration.
			graphPartiallyResovableSMO;
		var List<GraphPartiallyResolvableOperator> deleteEdgeType = partiallayResolvableOperators.filter [
			it.displayName.equals(GraphPartiallyResolvableOperatorType.DELETE_EDGE_TYPE)
		].toList
		partiallayResolvableOperators.removeAll(deleteEdgeType);

		for (GraphPartiallyResolvableOperator rO : deleteEdgeType) {
			var RemoveObject ad = rO.semanticChangeSets.get(0).changes.
				findFirst[it instanceof RemoveObject] as RemoveObject;
			var EdgeType removeEdgeType = ad.obj as EdgeType

			for (GraphPartiallyResolvableOperator resolvable : partiallayResolvableOperators) {
				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof RemoveReference] &&
						(it.name.equals("REMOVE_NodeType_(incoming)_TGT_EdgeType") ||
							it.name.equals("REMOVE_NodeType_(outgoing)_TGT_EdgeType") ||
							it.name.equals("REMOVE_EdgeType_(labels)_TGT_EdgeLabel"))

				]) {
					var RemoveReference a = s.changes.findFirst[it instanceof RemoveReference] as RemoveReference
					if (a.src instanceof EdgeType) {
						var EdgeType c = a.src as EdgeType;
						if (c.equals(removeEdgeType)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}

					} else if (a.tgt instanceof EdgeType) {
						var EdgeType c = a.tgt as EdgeType;
						if (c.equals(removeEdgeType)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}
					}

				}
			}
		}
	}

	def transformDeleteNodeType(Migration migration) {
		var EList<GraphPartiallyResolvableOperator> partiallayResolvableOperators = migration.
			graphPartiallyResovableSMO;
		var List<GraphPartiallyResolvableOperator> deleteNodeType = partiallayResolvableOperators.filter [
			it.displayName.equals(GraphPartiallyResolvableOperatorType.DELETE_NODE_TYPE)
		].toList
		partiallayResolvableOperators.removeAll(deleteNodeType);

		for (GraphPartiallyResolvableOperator rO : deleteNodeType) {
			var RemoveObject ad = rO.semanticChangeSets.get(0).changes.
				findFirst[it instanceof RemoveObject] as RemoveObject;
			var NodeType removeNodeType = ad.obj as NodeType

			for (GraphPartiallyResolvableOperator resolvable : partiallayResolvableOperators) {
				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof RemoveReference] &&
						(it.name.equals("REMOVE_NodeType_(incoming)_TGT_EdgeType") ||
							it.name.equals("REMOVE_NodeType_(outgoing)_TGT_EdgeType") ||
							it.name.equals("REMOVE_EdgeType_(labels)_TGT_EdgeLabel"))

				]) {
					var RemoveReference a = s.changes.findFirst[it instanceof RemoveReference] as RemoveReference
					if (a.src instanceof NodeType) {
						var NodeType c = a.src as NodeType;
						if (c.equals(removeNodeType)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}

					} else if (a.tgt instanceof NodeType) {
						var NodeType c = a.tgt as NodeType;
						if (c.equals(removeNodeType)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}
					}

				}
			}
		}
	}

	def transformDeleteConstraint(Migration migration) {
		var EList<GraphPartiallyResolvableOperator> partiallayResolvableOperators = migration.
			graphPartiallyResovableSMO;
		var List<GraphPartiallyResolvableOperator> deleteConstraint = partiallayResolvableOperators.filter [
			it.displayName.equals(GraphPartiallyResolvableOperatorType.REMOVE_CONSTRAINT)
		].toList
		partiallayResolvableOperators.removeAll(deleteConstraint);

		for (GraphPartiallyResolvableOperator rO : deleteConstraint) {
			var RemoveObject ad = rO.semanticChangeSets.get(0).changes.
				findFirst[it instanceof RemoveObject] as RemoveObject;
			var de.thm.evolvedb.graph.Constraint removeConstraint = ad.obj as de.thm.evolvedb.graph.Constraint

			for (GraphPartiallyResolvableOperator resolvable : partiallayResolvableOperators) {
				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof RemoveReference] &&
						(it.name.equals("REMOVE_UniqueConstraint_(properties)_TGT_Property") ||
							it.name.equals("REMOVE_KeyConstraint_(properties)_TGT_Property") )

				]) {
					var RemoveReference a = s.changes.findFirst[it instanceof RemoveReference] as RemoveReference
					if (a.src instanceof de.thm.evolvedb.graph.Constraint) {
						var de.thm.evolvedb.graph.Constraint c = a.src as de.thm.evolvedb.graph.Constraint;
						if (c.equals(removeConstraint)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}

					} else if (a.tgt instanceof de.thm.evolvedb.graph.Constraint) {
						var de.thm.evolvedb.graph.Constraint c = a.tgt as de.thm.evolvedb.graph.Constraint;
						if (c.equals(removeConstraint)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}
					}

				}
			}
		}
	}

	def transformAddNodeType(Migration migration) {
		var EList<GraphResolvableOperator> resolvableOperators = migration.graphResolvableSMO;
		var List<GraphResolvableOperator> createNodeType = resolvableOperators.filter [
			it.displayName.equals(GraphResolvableOperatorType.CREATE_NODE_TYPE)
		].toList
		resolvableOperators.removeAll(createNodeType);

		for (GraphResolvableOperator rO : createNodeType) {

			var AddObject ad = rO.semanticChangeSets.get(0).changes.findFirst[it instanceof AddObject] as AddObject;
			var NodeType newNodeType = ad.obj as NodeType

			for (GraphResolvableOperator resolvable : resolvableOperators) {
				for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
					it.changes.exists[it instanceof AddReference] && 
						 it.name.equals("ADD_NodeType_(label)_TGT_NodeLabel")
				]) {
					var AddReference a = s.changes.findFirst[it instanceof AddReference] as AddReference
					if (a.src instanceof NodeType) {
						var NodeType c = a.src as NodeType;
						if (c.equals(newNodeType)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}

					} else if (a.tgt instanceof NodeType) {
						var NodeType c = a.tgt as NodeType;
						if (c.equals(newNodeType)) {
							rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
							// Remove the Operator
							migration.schemaModificationOperators.remove(resolvable)
						}
					}

				}
			}
		}
	}

	def transformNewConstraints(Migration migration) {
		var EList<GraphResolvableOperator> resolvableOperators = migration.graphResolvableSMO;
		var List<GraphResolvableOperator> createConstraint = resolvableOperators.filter [
			it.displayName.equals(GraphResolvableOperatorType.CREATE_CONSTRAINT_IN_LABEL)
		].toList
		resolvableOperators.removeAll(createConstraint);

		for (GraphResolvableOperator rO : createConstraint) {

			var AddObject ad = rO.semanticChangeSets.get(0).changes.findFirst[it instanceof AddObject] as AddObject;
			var de.thm.evolvedb.graph.Constraint newConstraint = ad.obj as de.thm.evolvedb.graph.Constraint

			if (newConstraint instanceof KeyConstraint) {

				var KeyConstraint keyConstraint = newConstraint

				for (GraphResolvableOperator resolvable : resolvableOperators) {
					for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
						it.changes.exists[it instanceof AddReference] &&
							it.name.equals("ADD_KeyConstraint_(properties)_TGT_Property")
					]) {
						var AddReference a = s.changes.findFirst[it instanceof AddReference] as AddReference
						if (a.src instanceof KeyConstraint) {
							var KeyConstraint c = a.src as KeyConstraint;
							if (c.equals(keyConstraint)) {
								rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
								// Remove the Operator
								migration.schemaModificationOperators.remove(resolvable)
							}

						} else if (a.tgt instanceof KeyConstraint) {
							var KeyConstraint c = a.tgt as KeyConstraint;
							if (c.equals(keyConstraint)) {
								rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
								// Remove the Operator
								migration.schemaModificationOperators.remove(resolvable)
							}
						}

					}
				}
			} else if (newConstraint instanceof de.thm.evolvedb.graph.UniqueConstraint) {

				var de.thm.evolvedb.graph.UniqueConstraint keyConstraint = newConstraint

				for (GraphResolvableOperator resolvable : resolvableOperators) {
					for (SemanticChangeSet s : resolvable.semanticChangeSets.filter [
						it.changes.exists[it instanceof AddReference] &&
							it.name.equals("ADD_UniqueConstraint_(properties)_TGT_Property")
					]) {
						var AddReference a = s.changes.findFirst[it instanceof AddReference] as AddReference
						if (a.src instanceof de.thm.evolvedb.graph.UniqueConstraint) {
							var de.thm.evolvedb.graph.UniqueConstraint c = a.src as de.thm.evolvedb.graph.UniqueConstraint;
							if (c.equals(keyConstraint)) {
								rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
								// Remove the Operator
								migration.schemaModificationOperators.remove(resolvable)
							}

						} else if (a.tgt instanceof de.thm.evolvedb.graph.UniqueConstraint) {
							var de.thm.evolvedb.graph.UniqueConstraint c = a.tgt as de.thm.evolvedb.graph.UniqueConstraint;
							if (c.equals(keyConstraint)) {
								rO.semanticChangeSets.addAll(resolvable.semanticChangeSets)
								// Remove the Operator
								migration.schemaModificationOperators.remove(resolvable)
							}
						}

					}
				}

			}
		}
	}
}
