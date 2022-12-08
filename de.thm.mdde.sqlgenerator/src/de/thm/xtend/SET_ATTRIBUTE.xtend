package de.thm.xtend

import org.sidiff.difference.symmetric.SemanticChangeSet
import org.sidiff.difference.symmetric.AttributeValueChange
import java.util.List
import de.thm.evolvedb.mdde.Table
import de.thm.evolvedb.mdde.Column
import de.thm.evolvedb.mdde.ForeignKey
import java.util.ArrayList
import de.thm.evolvedb.migration.ResolvableOperator
import de.thm.evolvedb.mdde.PrimaryKey
import de.thm.evolvedb.migration.ProcessStatus
import de.thm.evolvedb.migration.PartiallyResolvable
import org.eclipse.emf.common.util.UniqueEList.FastCompare
import de.thm.evolvedb.migration.ColumnOptions
import de.thm.mdde.migration.util.ColumnMigrationUtil

class SET_ATTRIBUTE {

	def static String _SET_ATTRIBUTE_PrimaryKey_PrimaryKey(SemanticChangeSet set) {
	}

	def static String _SET_ATTRIBUTE_NamedElement_Name(ResolvableOperator resolvableOperator) {
		if (resolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			resolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet rename = resolvableOperator.semanticChangeSets.get(0)
			return _SET_ATTRIBUTE_NamedElement_Name2(rename);
		}
		return ""
	}

	/**
	 * SMO Change Name
	 */
	def static String _SET_ATTRIBUTE_NamedElement_Name2(SemanticChangeSet set) {

		var AttributeValueChange ad = set.changes.findFirst[it instanceof AttributeValueChange] as AttributeValueChange;
		if (ad === null)
			return "";

		var content = "";

		if (ad.objB instanceof Column) {

			if (ad.objA instanceof ForeignKey && ad.objB instanceof ForeignKey) {

				var objA = ad.objA as ForeignKey
				var objB = ad.objB as ForeignKey

				content += '''
					-- Change name of foriegn key «objA.name.toLowerCase» 
					ALTER TABLE `«objA.table.name.toLowerCase»` 
					DROP FOREIGN KEY `«objA.constraintName»`;
					ALTER TABLE `«objA.table.name.toLowerCase»` 
					CHANGE COLUMN `«objA.name.toUpperCase»` `«objB.name.toUpperCase»` «objA.type.getName»«ColumnUtil.getSizeString(objA)» «objA.notNull !== null && objA.notNull ? "NOT NULL" : "NULL"» ;
					ALTER TABLE `«objA.table.name.toLowerCase»` 
					ADD CONSTRAINT `«objA.constraintName»`
					FOREIGN KEY (`«objB.name.toUpperCase»`)
					REFERENCES `«objB.referencedTable.name.toLowerCase»` (`«objB.referencedKeyColumn.name»`);
				'''

			} else if (ad.objA instanceof PrimaryKey && ad.objB instanceof PrimaryKey) {

				var objA = ad.objA as PrimaryKey
				var objB = ad.objB as PrimaryKey

				if (objA.referencedBy.size == 0) {

					content += '''
						-- Change name of primaryKey «objA.name.toLowerCase» 				
						ALTER TABLE «objB.table.name.toLowerCase» 
						CHANGE COLUMN `«objA.name.toUpperCase»` `«objB.name.toUpperCase»` «objA.type.getName»«ColumnUtil.getSizeString(objA)» «objA.notNull !== null && objA.notNull ? "NOT NULL" : "NULL"» ;
					'''

				} else {
					// If the primaryKey is referenced by foreign keys, we have to delete and recreate the foreign key constraints
					content += '''
						-- Change name of primaryKey «objA.name.toLowerCase»
						-- Delete existing foreign key constraints
						«FOR ForeignKey foreignKey : objA.referencedBy»
							ALTER TABLE `«foreignKey.table.name.toLowerCase»` 
							DROP FOREIGN KEY `«foreignKey.constraintName»`;
						«ENDFOR»
						ALTER TABLE «objB.table.name.toLowerCase» 
						CHANGE COLUMN `«objA.name.toUpperCase»` `«objB.name.toUpperCase»` «objA.type.getName»«ColumnUtil.getSizeString(objA)» «objA.notNull !== null && objA.notNull ? "NOT NULL" : "NULL"» ;
						-- Recreate foreign key constraints
						«FOR ForeignKey foreignKey : objA.referencedBy»
							ALTER TABLE `«foreignKey.table.name.toLowerCase»` 
							ADD CONSTRAINT `«foreignKey.constraintName»`
							FOREIGN KEY (`«foreignKey.name.toUpperCase»`)
							REFERENCES `«objB.table.name.toLowerCase»` (`«objB.name.toUpperCase»`);
						«ENDFOR»
					'''
				}

			} else if (ad.objA instanceof Column && ad.objB instanceof Column) {

				var objA = ad.objA as Column
				var objB = ad.objB as Column

				content += '''
					-- Change name of «objA.name.toLowerCase» 
					ALTER TABLE `«objA.table.name.toLowerCase»` 
					CHANGE COLUMN `«objA.name.toUpperCase»` `«objB.name.toUpperCase»` «objA.type.getName»«ColumnUtil.getSizeString(objA)» 
					«objA.notNull !== null && objA.notNull ? "NULL" : "NOT NULL"» «objA.autoIncrement !== null && objA.autoIncrement ? "AUTO_INCREMENT" : ""»
					«ColumnUtil.getDefaultValueString(objA)» ;
				'''

			}

		} else if (ad.objB instanceof Table) {

			if (ad.objA instanceof Table && ad.objB instanceof Table) {

				var objA = ad.objA as Table
				var objB = ad.objB as Table

				content += '''
					-- Change name of «objA.name.toLowerCase» 
					ALTER TABLE «objA.name.toLowerCase» RENAME TO «objB.name.toLowerCase»;
				'''

			}

		}
		return content;

	}

	def static String _SET_ATTRIBUTE_ForeignKey_PrimaryForeignKey(SemanticChangeSet set) {

		var List<AttributeValueChange> makeColumnUniqe = set.changes.filter(AttributeValueChange).toList
		var content = ""

		for (AttributeValueChange a : makeColumnUniqe) {
			if (a.objA instanceof ForeignKey && a.objB instanceof ForeignKey) {

				var objA = a.objA as ForeignKey
				var objB = a.objB as ForeignKey

				if (objB.primaryForeignKey) {

					content += '''
						-- Change primary foreign key attribute of «objB.name.toLowerCase» 
						ALTER TABLE «objB.table.name.toLowerCase» ADD PRIMARY KEY (`«objB.name»`) ;
						
					'''

				} else {
					// Remove primary foreign key
					var parent = objB.table
					var List<Column> columns = parent.columns.filter[it instanceof ForeignKey].toList;
					var ArrayList<ForeignKey> foreignKeys = new ArrayList();
					for (element : columns) {
						var foreignKey = element as ForeignKey;
						if (foreignKey.primaryForeignKey)
							foreignKeys.add(foreignKey);

					}

					content += '''
						-- Change primary foreign key attribute of «objB.name.toLowerCase» 
						ALTER TABLE «objA.table.name.toLowerCase» DROP PRIMARY KEY «IF foreignKeys.size > 0»,
												ADD PRIMARY KEY (`«FOR e : foreignKeys SEPARATOR "`,`"»« e.name»«ENDFOR»`
						«ELSE»;
						«ENDIF»
					'''

				}

			} else {
// TODO database or attribute name value change
			}

		}
		return content;

	}

	/**
	 * Change the column size for text data types. If the data type is not a text type, the columns display value is changed. 
	 * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
	 */
	def static String _SET_ATTRIBUTE_Column_Unique(PartiallyResolvable partiallyResolvableOperator) {
		if (partiallyResolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			partiallyResolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet setColumnSize = partiallyResolvableOperator.semanticChangeSets.get(0)
			return _SET_ATTRIBUTE_Column_Unique2(setColumnSize, partiallyResolvableOperator.resolveOptions);
		}
		return ""
	}

	def static String _SET_ATTRIBUTE_Column_Unique2(SemanticChangeSet set, ColumnOptions columnOptions) {
		var List<AttributeValueChange> makeColumnUniqe = set.changes.filter(AttributeValueChange).toList
		var content = ""

		for (AttributeValueChange a : makeColumnUniqe) {
			if (a.objA instanceof Column && a.objB instanceof Column) {

				var objA = a.objA as Column
				var objB = a.objB as Column

				if (objB.unique) {

					switch columnOptions {
						case ColumnOptions.IGNORE: {
						}
						case ColumnOptions.SPECIFY_CONDITION_MANUALLY: {
							content +=
								'''-- TODO change all values of column «objB.name» that violate the new unique constraint'''
						}
						case ColumnOptions.DELETE_ROW: {

							var key = objB.table.mainPrimaryKey;

							var historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
								objB.table.schema, objB.table, key, SQLGenerator.TEMPORY_TABLE_NAME)

							content += '''
								-- Set all values to null that violate the unique constraint
								BEGIN;
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								DROP TEMPORARY TABLE IF EXISTS my_temp_table;
								CREATE TEMPORARY TABLE my_temp_table
								(SELECT «objB.name» FROM «objB.table.name.toLowerCase» 
								GROUP BY «objB.name»
								HAVING COUNT(«objB.name») > 1);
								
								DROP TEMPORARY TABLE IF EXISTS «SQLGenerator.TEMPORY_TABLE_NAME»;
								CREATE TEMPORARY TABLE «SQLGenerator.TEMPORY_TABLE_NAME»
								(SELECT «key.name» FROM «objB.table.name.toLowerCase» 
								GROUP BY «objB.name»
								HAVING COUNT(«objB.name») > 1);
								«historyInsert»
								DELETE FROM «objB.table.name.toLowerCase» where «objB.name» IN (SELECT * from my_temp_table);
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
								
							'''
							content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
							content += ColumnUtil.deleteTemporaryTable("my_temp_table");

						}
						case ColumnOptions.UPDATE_COLUMN_SET_TO_NULL: {

							var whereClause = '''«objB.name» is not null;''';
							var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
								SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, objB.table.mainPrimaryKey,
								whereClause)

							content += '''
								-- Set «objB.name.toLowerCase» values to null 
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								«historyInsert»
								UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = null;
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
								-- If executing the script fails, we suggest a rollback.
								
							'''

						}
						case ColumnOptions.UPDATE_ROW_SET_TO_NULL: {

							var key = objB.table.mainPrimaryKey;
							var historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
								objB.table.schema, objB.table, key, SQLGenerator.TEMPORY_TABLE_NAME)

							content += '''
								-- Set all values to null that violate the unique constraint
								BEGIN;
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								DROP TEMPORARY TABLE IF EXISTS my_temp_table;
								CREATE TEMPORARY TABLE my_temp_table
								(SELECT «objA.name» FROM «objA.table.name.toLowerCase» 
								GROUP BY «objA.name»
								HAVING COUNT(«objA.name») > 1);
								
								DROP TEMPORARY TABLE IF EXISTS «SQLGenerator.TEMPORY_TABLE_NAME»;
								CREATE TEMPORARY TABLE «SQLGenerator.TEMPORY_TABLE_NAME»
								(SELECT «key.name» FROM «objB.table.name.toLowerCase» 
								GROUP BY «objB.name»
								HAVING COUNT(«objB.name») > 1);
								«historyInsert»
								UPDATE «objA.table.name.toLowerCase» SET «objA.name» = null where «objA.name» IN (SELECT * from my_temp_table);
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
								
							'''
							content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
							content += ColumnUtil.deleteTemporaryTable("my_temp_table");

						}
					}

					var constraintName = objB.table.name.toUpperCase + "_UNIQUE";

					if (objB.uniqueConstraintName !== null && !objB.uniqueConstraintName.equals(""))
						constraintName = objB.uniqueConstraintName;
					content += '''
						-- Change uniqe attribute of «objA.name.toLowerCase» 
						ALTER TABLE «objA.table.name.toLowerCase» ADD UNIQUE INDEX `«constraintName»` (`«objB.name»` ASC);
					'''

				} else {
					content += '''
						-- Change uniqe attribute of «objA.name.toLowerCase» 
						ALTER TABLE «objA.table.name.toLowerCase» DROP INDEX `«objB.uniqueConstraintName»`;
					'''

				}

			}

		}
		return content;

	}

	/**
	 * Change the column type. 
	 * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
	 */
	def static String _SET_ATTRIBUTE_Column_Type(PartiallyResolvable partiallyResolvableOperator) {
		if (partiallyResolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			partiallyResolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet setColumnType = partiallyResolvableOperator.semanticChangeSets.get(0)
			return _SET_ATTRIBUTE_Column_Type_2(setColumnType, partiallyResolvableOperator.resolveOptions);
		}
		return ""
	}

	def static String _SET_ATTRIBUTE_Column_Type_2(SemanticChangeSet set, ColumnOptions resolveOption) {

		var List<AttributeValueChange> changeColumnType = set.changes.filter(AttributeValueChange).toList
		var content = ""

		for (AttributeValueChange a : changeColumnType) {
			if (a.objA instanceof Column && a.objB instanceof Column) {

				var objA = a.objA as Column
				var objB = a.objB as Column

				switch resolveOption {
					case IGNORE: {
					}
					case ColumnOptions.SPECIFY_CONDITION_MANUALLY: {
						content +=
							'''
							-- TODO change all values of column «objB.name» that are incompatible with the new type «objB.type.getName»
							'''
					}
					case DELETE_ROW: {

						var key = objB.table.mainPrimaryKey;
						var whereClause = ColumnUtil.getRegexStringForWhereClause(objA, objB, key);
						var historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
							objB.table.schema, objB.table, key, SQLGenerator.TEMPORY_TABLE_NAME)

						content +=
							ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.table.schema,
								objB.table, objB.table.mainPrimaryKey, whereClause);

						content += '''
							-- Set «objB.name.toLowerCase» values to null
							BEGIN; 
							SET @safe_mode = @@SQL_SAFE_UPDATES;
							SET SQL_SAFE_UPDATES = 0;
							«historyInsert»
							DELETE FROM `«objB.table.name»` where «key.name» in (Select «key.name» from «SQLGenerator.TEMPORY_TABLE_NAME»);
							SET SQL_SAFE_UPDATES = @safe_mode;
							COMMIT;
							-- If executing the script fails, we suggest a rollback.
						'''
						content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);

					}
					case UPDATE_ROW_SET_TO_DEFAULT: {

						var key = objB.table.mainPrimaryKey;
						var whereClause = ColumnUtil.getRegexStringForWhereClause(objA, objB, key);
						var historyInsert = ColumnUtil.createInsertColumnHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
							objB.table.schema, objB, objB.table.mainPrimaryKey, whereClause)

						content +=
							ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.table.schema,
								objB.table, objB.table.mainPrimaryKey, whereClause);

						// Aktuell nur von string zu number
						content += '''
							-- Set «objB.name.toLowerCase» values to null
							BEGIN; 
							SET @safe_mode = @@SQL_SAFE_UPDATES;
							SET SQL_SAFE_UPDATES = 0;
							«historyInsert»
							UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = «ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)» where «key.name» in (Select «key.name» from «SQLGenerator.TEMPORY_TABLE_NAME»);
							SET SQL_SAFE_UPDATES = @safe_mode;
							COMMIT;
							-- If executing the script fails, we suggest a rollback.
						'''
						content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);

					}
					case UPDATE_ROW_SET_TO_NULL: {

						var key = objB.table.mainPrimaryKey;
						var whereClause = ColumnUtil.getRegexStringForWhereClause(objA, objB, key);
						var historyInsert = ColumnUtil.createInsertColumnHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
							objB.table.schema, objB, objB.table.mainPrimaryKey, whereClause)

						content +=
							ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.table.schema,
								objB.table, objB.table.mainPrimaryKey, whereClause);

						// Aktuell nur von string zu number
						content += '''
							-- Set «objB.name.toLowerCase» values to null
							BEGIN; 
							SET @safe_mode = @@SQL_SAFE_UPDATES;
							SET SQL_SAFE_UPDATES = 0;
							«historyInsert»
							UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = null where «key.name» in (Select «key.name» from «SQLGenerator.TEMPORY_TABLE_NAME»);
							SET SQL_SAFE_UPDATES = @safe_mode;
							COMMIT;
							-- If executing the script fails, we suggest a rollback.
						'''
						content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);

					}
					case UPDATE_COLUMN_SET_TO_DEFAULT: {

						var whereClause = '''«objB.name» is not null;''';
						var historyInsert = ColumnUtil.createInsertColumnHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
							objB.table.schema, objB, objB.table.mainPrimaryKey, whereClause)

						content += '''
							-- Set «objB.name.toLowerCase» values to null
							BEGIN; 
							SET @safe_mode = @@SQL_SAFE_UPDATES;
							SET SQL_SAFE_UPDATES = 0;
							«historyInsert»
							UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = «ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)»;
							SET SQL_SAFE_UPDATES = @safe_mode;
							COMMIT;
							-- If executing the script fails, we suggest a rollback.
						'''
					}
					case UPDATE_COLUMN_SET_TO_NULL: {

						var whereClause = '''«objB.name» is not null;''';
						var historyInsert = ColumnUtil.createInsertColumnHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
							objB.table.schema, objB, objB.table.mainPrimaryKey, whereClause)

						content += '''
							-- Set «objB.name.toLowerCase» values to null 
							SET @safe_mode = @@SQL_SAFE_UPDATES;
							SET SQL_SAFE_UPDATES = 0;
							«historyInsert»
							UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = null;
							SET SQL_SAFE_UPDATES = @safe_mode;
							COMMIT;
							-- If executing the script fails, we suggest a rollback.
							
						'''
					}
				}

				// This operator is executed first. Therefore, not null depends on objA
				content += '''
					-- Change column type of «objB.name.toLowerCase» 
					ALTER TABLE `«objB.table.name.toLowerCase»` CHANGE COLUMN `«objB.name»` `«objB.name»` «objB.type»«ColumnUtil.getSizeString(objB)» «IF objA.notNull»NOT NULL«ELSE»NULL«ENDIF» «ColumnUtil.getDefaultValueString(objB)» ;
				'''

			}
			return content;
		}
	}

	/**
	 * Change the column size for text data types.
	 * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
	 */
	def static String _SET_ATTRIBUTE_Column_Size(PartiallyResolvable partiallyResolvableOperator) {
		if (partiallyResolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			partiallyResolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet setColumnSize = partiallyResolvableOperator.semanticChangeSets.get(0)
			return _SET_ATTRIBUTE_Column_Size2(setColumnSize, partiallyResolvableOperator.resolveOptions);
		}
		return ""
	}

	def static String _SET_ATTRIBUTE_Column_Size2(SemanticChangeSet set, ColumnOptions columnOptions) {

		var List<AttributeValueChange> changeColumnType = set.changes.filter(AttributeValueChange).toList
		var content = ""

		for (AttributeValueChange a : changeColumnType) {
			if (a.objA instanceof Column && a.objB instanceof Column) {

				var objA = a.objA as Column
				var objB = a.objB as Column

				var compatibility = ColumnMigrationUtil.checkColumnSizeCompatibility(objA, objB).size == 0;

				var sizeA = 0;
				var sizeB = 0;
				if (objA.size !== null)
					sizeA = ColumnUtil.decimalTypes.contains(objA.type) ? ColumnUtil.
						getDecimalSizeValue(objA.size) : ColumnUtil.getSizeValue(objA.size);

				if (objB.size !== null)
					sizeB = ColumnUtil.decimalTypes.contains(objB.type) ? ColumnUtil.
						getDecimalSizeValue(objB.size) : ColumnUtil.getSizeValue(objB.size);

				// if (sizeA > sizeB) {
				if (compatibility) {

					if (ColumnUtil.textTypes.contains(objB.type) || ColumnUtil.binaryTypes.contains(objB.type) ||
						ColumnUtil.decimalTypes.contains(objB.type)) {

						switch columnOptions {
							case IGNORE: {
								// IGNORE existing data.
							}
							case ColumnOptions.SPECIFY_CONDITION_MANUALLY: {
								content +=
									'''
									-- TODO change all values of column «objB.name» that are incompatible with the new size 
									'''
							}
							case DELETE_ROW: {

								var key = objB.table.mainPrimaryKey;
								var whereClause = '''LENGTH(«objB.name») > «sizeB»;'''
								var historyInsert = ColumnUtil.createInsertRowHistoryScript(
									SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB.table, key,
									SQLGenerator.TEMPORY_TABLE_NAME)

								content +=
									ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.table.schema,
										objB.table, objB.table.mainPrimaryKey, whereClause);

								content += '''
									-- delete «objB.name.toLowerCase» values which exceed the new column size
									BEGIN; 
									SET @safe_mode = @@SQL_SAFE_UPDATES;
									SET SQL_SAFE_UPDATES = 0;
									«historyInsert»
									DELETE FROM `«objB.table.name.toLowerCase»` WHERE «whereClause»
									SET SQL_SAFE_UPDATES = @safe_mode;
									COMMIT;
									-- If executing the script fails, we suggest a rollback.
								'''
								content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);

							}
							case UPDATE_COLUMN_SET_TO_DEFAULT: {

								var key = objB.table.mainPrimaryKey;
								var whereClause = '''«objB.name» is not null;'''
								var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
									SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, key, whereClause)

								content += '''
									-- Set «objB.name.toLowerCase» values to null
									BEGIN; 
									SET @safe_mode = @@SQL_SAFE_UPDATES;
									SET SQL_SAFE_UPDATES = 0;
									«historyInsert»
									UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = «ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)»;
									SET SQL_SAFE_UPDATES = @safe_mode;
									COMMIT;
									-- If executing the script fails, we suggest a rollback.
								'''

							}
							case UPDATE_COLUMN_SET_TO_NULL: {

								var key = objB.table.mainPrimaryKey;
								var whereClause = '''«objB.name» is not null;'''
								var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
									SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, key, whereClause)

								content += '''
									-- Set «objB.name.toLowerCase» values to null 
									SET @safe_mode = @@SQL_SAFE_UPDATES;
									SET SQL_SAFE_UPDATES = 0;
									«historyInsert»
									UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = null;
									SET SQL_SAFE_UPDATES = @safe_mode;
									COMMIT;
									-- If executing the script fails, we suggest a rollback.
									
								'''

							}
							case UPDATE_ROW_SET_TO_NULL: {

								var key = objB.table.mainPrimaryKey;
								var whereClause = '''WHERE LENGTH(«objB.name») > «sizeB»;''';
								var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
									SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, key, whereClause)

								// Aktuell nur von string zu number
								content += '''
									-- Set «objB.name.toLowerCase» values to null
									BEGIN; 
									SET @safe_mode = @@SQL_SAFE_UPDATES;
									SET SQL_SAFE_UPDATES = 0;
									«historyInsert»
									UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = null WHERE LENGTH(«objB.name») > «sizeB»;
									SET SQL_SAFE_UPDATES = @safe_mode;
									COMMIT;
									-- If executing the script fails, we suggest a rollback.
								'''

							}
							case UPDATE_ROW_SET_TO_DEFAULT: {
								var key = objB.table.mainPrimaryKey;
								var whereClause = '''WHERE LENGTH(«objB.name») > «sizeB»;''';
								var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
									SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, key, whereClause)
								// Aktuell nur von string zu number
								content += '''
									-- Set «objB.name.toLowerCase» values to null
									BEGIN; 
									SET @safe_mode = @@SQL_SAFE_UPDATES;
									SET SQL_SAFE_UPDATES = 0;
									«historyInsert»
									UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = «ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)» WHERE LENGTH(«objB.name») > «sizeB»;
									SET SQL_SAFE_UPDATES = @safe_mode;
									COMMIT;
									-- If executing the script fails, we suggest a rollback.
								'''
							}
						}
						content += '''
							-- Change column size of «objB.name.toLowerCase» 
							ALTER TABLE `«objB.table.name.toLowerCase»` CHANGE COLUMN `«objB.name»` `«objB.name»` «objB.type»«ColumnUtil.getSizeString(objB)» «IF objB.notNull»NOT NULL«ELSE»NULL«ENDIF» «ColumnUtil.getDefaultValueString(objB)» ;
						'''

					} else if (ColumnUtil.dateTypesWithFraction.contains(objB.type)) {
						// The default value is changed automatically.
						// Existing data is reduced automatically too.
						content += '''
							-- Change fraction digits of «objB.name.toLowerCase» 
							ALTER TABLE `«objB.table.name.toLowerCase»` CHANGE COLUMN `«objB.name»` `«objB.name»` «objB.type»«ColumnUtil.getSizeString(objB)» «IF objB.notNull»NOT NULL«ELSE»NULL«ENDIF» «ColumnUtil.getDefaultValueString(objB)» ;
						'''
					}

//					else if (ColumnUtil.decimalTypes.contains(objB.type)) {
//						// The default value is changed automatically.
//						// It doesnt matter if the second value has been changed. The first value is essential.
//						var sizeAM = ColumnUtil.getDecimalSizeValue(objA.size);
//						var sizeBM = ColumnUtil.getDecimalSizeValue(objB.size);
//
//						if (sizeAM > sizeBM) {
////						//TODO options
////						var PrimaryKey primaryKey = objB.table.primaryKeys.findFirst[it.autoIncrement || it.notNull];
//							var value = sizeAM - sizeBM;
//							var longValue = Math.pow(10, value).longValue;
//							// if safe mode is enabled a key column has to be used in the where clause
//							content += '''
//								SET SQL_SAFE_UPDATES = 0;
//								-- Update values in «objB.name.toLowerCase» 
//								UPDATE `«objB.table.name.toLowerCase»`  SET `«objB.name»`= MOD(`«objB.name»`, «longValue»);
//								SET SQL_SAFE_UPDATES = 1;
//							'''
//
//						}
//						content += '''
//							-- Change size of «objB.name.toLowerCase» 
//							ALTER TABLE `«objB.table.name.toLowerCase»` CHANGE COLUMN `«objB.name»` `«objB.name»` «objB.type»«ColumnUtil.getSizeString(objB)» «IF objB.notNull»NOT NULL«ELSE»NULL«ENDIF» «ColumnUtil.getDefaultValueString(objB)» ;
//						'''
//					}
				} else {
					// A is smaller than B
					content += '''
						-- Change size of «objB.name.toLowerCase» 
						ALTER TABLE `«objB.table.name.toLowerCase»` CHANGE COLUMN `«objB.name»` `«objB.name»` «objB.type»«ColumnUtil.getSizeString(objB)» «IF objB.notNull»NOT NULL«ELSE»NULL«ENDIF» «ColumnUtil.getDefaultValueString(objB)» ;
					'''
				}
				return content
			}
		}
	}

	/**
	 * Change the column notNull value. 
	 * @param resolvableOperator The resolvable operator containing the necessary information.
	 */
	def static String _SET_ATTRIBUTE_Column_NotNull(PartiallyResolvable partiallyResolvableOperator) {
		if (partiallyResolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			partiallyResolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet columnNotNull = partiallyResolvableOperator.semanticChangeSets.get(0)
			return _SET_ATTRIBUTE_Column_NotNull2(columnNotNull, partiallyResolvableOperator.resolveOptions);
		}
		return ""
	}

	/**
	 * Change the column default value. The operator is resolvable because the model is validated before executing 
	 * the operation.
	 * @param resolvableOperator The resolvable operator containing the necessary information.
	 */
	def static String _SET_ATTRIBUTE_Column_NotNull2(SemanticChangeSet set, ColumnOptions columnOptions) {

		var List<AttributeValueChange> changeColumnType = set.changes.filter(AttributeValueChange).toList
		var content = ""

		for (AttributeValueChange a : changeColumnType) {
			if (a.objA instanceof Column && a.objB instanceof Column) {

				var objA = a.objA as Column
				var objB = a.objB as Column

				if (objB.notNull) {
					switch columnOptions {
						case IGNORE: {
						}
						case ColumnOptions.SPECIFY_CONDITION_MANUALLY: {
							content += '''-- TODO remove all null values of column «objB.name» '''
						}
						case ColumnOptions.DELETE_ROW: {

							var key = objB.table.mainPrimaryKey;
							var whereClause = '''`«objB.name»` is NULL;''';
							var historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
								objB.table.schema, objB.table, key, SQLGenerator.TEMPORY_TABLE_NAME)

							content +=
								ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.table.schema,
									objB.table, objB.table.mainPrimaryKey, whereClause);

							content += '''
								-- Delete all rows with null values in the column «objB.name.toLowerCase».
								BEGIN;
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								«historyInsert»
								DELETE FROM `«objB.table.name.toLowerCase»` where `«objB.name»` is NULL;
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
							'''
							content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);

						}
						case ColumnOptions.UPDATE_COLUMN_SET_TO_DEFAULT: {

							var whereClause = '''«objB.name» is not null;''';
							var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
								SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, objB.table.mainPrimaryKey,
								whereClause)

							content += '''
								-- Set all values in the column «objB.name.toLowerCase» to the default value.
								BEGIN;
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								«historyInsert»
								UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = «ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)» ;
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
							'''

						}
						case ColumnOptions.UPDATE_ROW_SET_TO_DEFAULT: {

							var whereClause = '''«objB.name» is null;''';
							var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
								SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, objB.table.mainPrimaryKey,
								whereClause)

							content += '''
								-- Set all null values in the column «objB.name.toLowerCase» to the default value.
								BEGIN;
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								«historyInsert»
								UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = «ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)» where `«objB.name»` is NULL;
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
							'''

						}
					}
				}

				content += '''
					-- Change column not null of «objB.name.toLowerCase» 
					ALTER TABLE `«objB.table.name.toLowerCase»` CHANGE COLUMN `«objB.name»` `«objB.name»` «objB.type»«ColumnUtil.getSizeString(objB)» «IF objB.notNull»NOT NULL«ELSE»NULL«ENDIF» «ColumnUtil.getDefaultValueString(objB)» ;
				'''
				return content;
			}
		}

	}

	/**
	 * Change the onDelete and onUpdate Literal for a foreignKey constraint
	 * @param resolvableOperator The resolvable operator containing the necessary information.
	 */
	def static String _CHANGE_Literal_ForeignKey(ResolvableOperator resolvableOperator) {
		if (resolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			resolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet rename = resolvableOperator.semanticChangeSets.get(0)
			return _CHANGE_Literal_ForeignKey2(rename);
		}
		return ""
	}

	/**
	 * Change the onDelete and onUpdate Literal for a foreignKey constraint
	 * @param resolvableOperator The resolvable operator containing the necessary information.
	 */
	def static String _CHANGE_Literal_ForeignKey2(SemanticChangeSet set) {

		var List<AttributeValueChange> changeLiteral = set.changes.filter(AttributeValueChange).toList
		var content = ""

		for (AttributeValueChange a : changeLiteral) {
			if (a.objA instanceof ForeignKey && a.objB instanceof ForeignKey) {

				var objA = a.objA as ForeignKey
				var objB = a.objB as ForeignKey

				content += '''
					-- change foreign key constraint «objB.name.toLowerCase»
					ALTER TABLE `«objB.table.name.toLowerCase»` 
					DROP FOREIGN KEY `«objA.constraintName»`;
									
					-- Create foreign key in «objB.table.name.toLowerCase» 
					ALTER TABLE `«objB.table.name.toLowerCase»` 
					ADD CONSTRAINT `«objB.constraintName»`
					  FOREIGN KEY (`«objB.name.toUpperCase»`)
					  REFERENCES `«objB.referencedTable.name.toLowerCase»`(`«objB.referencedKeyColumn.name.toUpperCase»`)
					  ON DELETE «objB.onDelete.name()»
					  ON UPDATE «objB.onUpdate.name()»;
				'''
				return content;
			}
		}

	}

	/**
	 * Change the onDelete and onUpdate Literal for a foreignKey constraint
	 * @param resolvableOperator The resolvable operator containing the necessary information.
	 */
	def static String _CHANGE_ForeignKey_constraint_name(ResolvableOperator resolvableOperator) {
		if (resolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			resolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet rename = resolvableOperator.semanticChangeSets.get(0)
			return _CHANGE_ForeignKey_constraint_name2(rename);
		}
		return ""
	}

	/**
	 * Change the onDelete and onUpdate Literal for a foreignKey constraint
	 * @param resolvableOperator The resolvable operator containing the necessary information.
	 */
	def static String _CHANGE_ForeignKey_constraint_name2(SemanticChangeSet set) {

		var List<AttributeValueChange> changeLiteral = set.changes.filter(AttributeValueChange).toList
		var content = ""

		for (AttributeValueChange a : changeLiteral) {
			if (a.objA instanceof ForeignKey && a.objB instanceof ForeignKey) {

				var objA = a.objA as ForeignKey
				var objB = a.objB as ForeignKey

				content += '''
					-- change foreign key constraint «objB.name.toLowerCase»
					ALTER TABLE `«objB.table.name.toLowerCase»` 
					DROP FOREIGN KEY `«objA.constraintName»`;
									
					-- Create foreign key in «objB.table.name.toLowerCase» 
					ALTER TABLE `«objB.table.name.toLowerCase»` 
					ADD CONSTRAINT `«objB.constraintName»`
					  FOREIGN KEY (`«objB.name.toUpperCase»`)
					  REFERENCES `«objB.referencedTable.name.toLowerCase»`(`«objB.referencedKeyColumn.name.toUpperCase»`)
					  ON DELETE «objB.onDelete.name()»
					  ON UPDATE «objB.onUpdate.name()»;
				'''
				return content;
			}
		}

	}

	/**
	 * Change the column default value. The operator is resolvable because the model is validated before executing 
	 * the operation.
	 * @param resolvableOperator The resolvable operator containing the necessary information.
	 */
	def static String _SET_ATTRIBUTE_Column_DefaultValue(ResolvableOperator resolvableOperator) {
		if (resolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			resolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet defaultValue = resolvableOperator.semanticChangeSets.get(0)
			return _SET_ATTRIBUTE_Column_DefaultValue2(defaultValue);
		}
		return ""
	}

	/**
	 * Change the column default value. The operator is resolvable because the model is validated before executing 
	 * the operation.
	 * @param resolvableOperator The resolvable operator containing the necessary information.
	 */
	def static String _SET_ATTRIBUTE_Column_DefaultValue2(SemanticChangeSet set) {

		var List<AttributeValueChange> changeColumnType = set.changes.filter(AttributeValueChange).toList
		var content = ""

		for (AttributeValueChange a : changeColumnType) {
			if (a.objA instanceof Column && a.objB instanceof Column) {

				var objA = a.objA as Column
				var objB = a.objB as Column

				content += '''
					-- Change default value of «objB.name.toLowerCase» 
					ALTER TABLE `«objB.table.name.toLowerCase»` CHANGE COLUMN `«objB.name»` `«objB.name»` «objB.type»«ColumnUtil.getSizeString(objB)» «IF objA.notNull»NOT NULL«ELSE»NULL«ENDIF» «ColumnUtil.getDefaultValueString(objB)» ;
				'''
				return content;
			}
		}

	}

	/**
	 * Change the unique constraint name. 
	 * @param resolvableOperator The resolvable operator containing the necessary information.
	 */
	def static String _SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME(ResolvableOperator resolvableOperator) {
		if (resolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			resolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet defaultValue = resolvableOperator.semanticChangeSets.get(0)
			return _SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME2(defaultValue);
		}
		return ""
	}

	/**
	 * Change the unique constraint name.
	 * @param resolvableOperator The resolvable operator containing the necessary information.
	 */
	def static String _SET_ATTRIBUTE_UNIQUE_CONSTRAINT_NAME2(SemanticChangeSet set) {

		var List<AttributeValueChange> changeColumnType = set.changes.filter(AttributeValueChange).toList
		var content = ""

		for (AttributeValueChange a : changeColumnType) {
			if (a.objA instanceof Column && a.objB instanceof Column) {

				var objA = a.objA as Column
				var objB = a.objB as Column

				content += '''
					-- Change uniqe constraint name of «objA.name.toLowerCase» 
					ALTER TABLE «objA.table.name.toLowerCase» DROP INDEX `«objA.uniqueConstraintName»`;
					ALTER TABLE «objB.table.name.toLowerCase» ADD UNIQUE INDEX `«objB.uniqueConstraintName»` (`«objB.name»` ASC) VISIBLE;
					
				'''

				return content;
			}
		}

	}

	def static String _SET_ATTRIBUTE_Column_AutoIncrement(ResolvableOperator resolvableOperator) {
		if (resolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			resolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet defaultValue = resolvableOperator.semanticChangeSets.get(0)
			return _SET_ATTRIBUTE_Column_AutoIncrement2(defaultValue);
		}
		return ""
	}

	// maybe only one column can have the auto increment flag
	def static String _SET_ATTRIBUTE_Column_AutoIncrement2(SemanticChangeSet set) {
		// TODO
	}

	def static _SET_COLUMN_TYPE_AND_SIZE(PartiallyResolvable resolvable) {

		if (resolvable.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet change = resolvable.semanticChangeSets.findFirst [
				editRName.equals('SET_ATTRIBUTE_Column_Size_and_Type')
			]
			return _SET_COLUMN_TYPE_AND_SIZE2(change, resolvable.resolveOptions);
		}

		return ""

	}

	/**
	 * Change the column tape and size types.
	 * @param set The SemanticChangeSet containing the necessary information.
	 * @param resolveOption The selected resolve option. If none has been selected the default value is ignore.
	 */
	def static String _SET_COLUMN_TYPE_AND_SIZE2(SemanticChangeSet set, ColumnOptions resolveOption) {

		var List<AttributeValueChange> changeColumnType = set.changes.filter(AttributeValueChange).toList
		var content = ""

		for (AttributeValueChange a : changeColumnType) {
			if (a.objA instanceof Column && a.objB instanceof Column) {

				var objA = a.objA as Column
				var objB = a.objB as Column

				var typeCompatibility = ColumnUtil.checkColumnTypeCompatibility(objA, objB);
				var sizeCompatibility = ColumnMigrationUtil.checkColumnSizeCompatibility(objA, objB).size == 0;

				if (!(typeCompatibility && sizeCompatibility)) {

					switch resolveOption {
						case IGNORE: {
						}
						case ColumnOptions.SPECIFY_CONDITION_MANUALLY: {
							content +=
								'''
								-- TODO change all values of column «objB.name» that are incompatible with the new type «objB.type.getName» or size
								'''
						}
						case DELETE_ROW: {

							var key = objB.table.mainPrimaryKey;
							var whereClause = ColumnUtil.getRegexStringForWhereClause(objA, objB, key);
							var historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
								objB.table.schema, objB.table, key, SQLGenerator.TEMPORY_TABLE_NAME)

							content +=
								ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.table.schema,
									objB.table, objB.table.mainPrimaryKey, whereClause);
							content += '''
								-- Set «objB.name.toLowerCase» values to null
								BEGIN; 
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								«historyInsert»
								DELETE FROM `«objB.table.name.toLowerCase»` where «key.name» in (Select «key.name» from «SQLGenerator.TEMPORY_TABLE_NAME»);
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
								-- If executing the script fails, we suggest a rollback.
							'''
							content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);

						}
						case UPDATE_ROW_SET_TO_DEFAULT: {
							var key = objB.table.mainPrimaryKey;
							var whereClause = ColumnUtil.getRegexStringForWhereClause(objA, objB, key);
							var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
								SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, objB.table.mainPrimaryKey,
								whereClause)

							content +=
								ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.table.schema,
									objB.table, objB.table.mainPrimaryKey, whereClause);
							content += '''
								-- Set «objB.name.toLowerCase» values to null
								BEGIN; 
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								«historyInsert»
								UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = «ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)» where «key.name» in (Select «key.name» from «SQLGenerator.TEMPORY_TABLE_NAME»);
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
								-- If executing the script fails, we suggest a rollback.
							'''
							content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);

						}
						case UPDATE_ROW_SET_TO_NULL: {
							var key = objB.table.mainPrimaryKey;
							var whereClause = ColumnUtil.getRegexStringForWhereClause(objA, objB, key);
							var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
								SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, objB.table.mainPrimaryKey,
								whereClause)

							content +=
								ColumnUtil.createTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME, objB.table.schema,
									objB.table, objB.table.mainPrimaryKey, whereClause);
							// Aktuell nur von string zu number
							content += '''
								-- Set «objB.name.toLowerCase» values to null
								BEGIN; 
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								«historyInsert»
								UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = null where «key.name» in (Select «key.name» from «SQLGenerator.TEMPORY_TABLE_NAME»);
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
								-- If executing the script fails, we suggest a rollback.
							'''
							content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);

						}
						case UPDATE_COLUMN_SET_TO_DEFAULT: {

							var whereClause = '''«objB.name» is not null;''';
							var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
								SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, objB.table.mainPrimaryKey,
								whereClause)

							content += '''
								-- Set «objB.name.toLowerCase» values to null
								BEGIN; 
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								«historyInsert»
								UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = «ColumnUtil.getDefaultValueStringWithoutDEFAULT(objB)»;
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
								-- If executing the script fails, we suggest a rollback.
							'''

						}
						case UPDATE_COLUMN_SET_TO_NULL: {

							var whereClause = '''«objB.name» is not null;''';
							var historyInsert = ColumnUtil.createInsertColumnHistoryScript(
								SQLGenerator.HISTORY_TABLE_NAME, objB.table.schema, objB, objB.table.mainPrimaryKey,
								whereClause)

							content += '''
								-- Set «objB.name.toLowerCase» values to null 
								SET @safe_mode = @@SQL_SAFE_UPDATES;
								SET SQL_SAFE_UPDATES = 0;
								«historyInsert»
								UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = null;
								SET SQL_SAFE_UPDATES = @safe_mode;
								COMMIT;
								-- If executing the script fails, we suggest a rollback.
								
							'''
						}
					}

				}
				content += '''
					-- Change column type and size of «objB.name.toLowerCase» 
					ALTER TABLE `«objB.table.name.toLowerCase»` CHANGE COLUMN `«objB.name»` `«objB.name»` «objB.type»«ColumnUtil.getSizeString(objB)» «IF objB.notNull»NOT NULL«ELSE»NULL«ENDIF» «ColumnUtil.getDefaultValueString(objB)» ;
				'''

			}
			return content;
		}

	}

}
