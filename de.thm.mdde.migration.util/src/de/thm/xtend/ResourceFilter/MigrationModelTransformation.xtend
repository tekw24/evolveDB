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

class MigrationModelTransformation {

	def runMigrtaionTransformation(Resource resXtendModelFile, Resource resSymmetricModel) {

		var Migration migration = resXtendModelFile.allContents.findFirst[it instanceof Migration] as Migration
		migration.transformNewTableOperator
		migration.transformRenameOperator
		migration.setMigrationOptionFor1N_NM_Rule
		migration.removeUniqueConstraintName
		var SymmetricDifference symmetricDifference = resSymmetricModel.allContents.findFirst [
			it instanceof SymmetricDifference
		] as SymmetricDifference
		migration.symmetricDifference = symmetricDifference
		migration.uriSymetricDifferenceModel = resSymmetricModel.URI.toString;
	// migration.symetricDifferenceModel = resSymmetricModel
	}
	
	def void removeUniqueConstraintName(Migration migration){
		
		var EList<ResolvableOperator> resolvableOperators = migration.resolvableSMO;
		var List<ResolvableOperator> uniqueConstraintName = resolvableOperators.filter [
			it.displayName.equals(ResolvableOperatorType.SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME)
		].toList

		for (ResolvableOperator rO : uniqueConstraintName) {
			var AttributeValueChange ad = rO.semanticChangeSets.get(0).changes.findFirst [
				it instanceof AttributeValueChange
			] as AttributeValueChange;
			if (ad.objA instanceof Column){
				var objA = ad.objA as Column
				if(objA.uniqueConstraintName === null || objA.uniqueConstraintName === ''){
					// Has to be removed becaus of the setUniqueConstraint Operator
					migration.schemaModificationOperators.remove(rO)
				}
			}
				
		}
		
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
			if (ad.objB instanceof Column)
				rO.displayName = ResolvableOperatorType.RENAME_COLUMN;
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
