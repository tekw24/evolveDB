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

class MigrationModelTransformation {

	protected MigrationPackage migrationPackage = MigrationPackage.eINSTANCE;
	protected MigrationFactory migrationFactory = migrationPackage.migrationFactory;

	def runMigrtaionTransformation(Resource resXtendModelFile, Resource resSymmetricModel) {

		var Migration migration = resXtendModelFile.allContents.findFirst[it instanceof Migration] as Migration
		migration.transformNewTableOperator
		migration.transformRenameOperator
		migration.setMigrationOptionFor1N_NM_Rule
		migration.removeDatabaseSchemaChange
		migration.transformConstraints
		migration.transformIndexConstraints
		migration.transformUniqueConstraints
		migration.transformNewIndexOperator

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

			}else if (ad.objB instanceof ColumnConstraint){
				migration.schemaModificationOperators.remove(rO);
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

					}
				}

			// filter[it instanceof AddObject]
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

}
