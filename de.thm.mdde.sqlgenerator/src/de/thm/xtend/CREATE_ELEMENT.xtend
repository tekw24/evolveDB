package de.thm.xtend

import org.sidiff.difference.symmetric.SemanticChangeSet
import org.sidiff.difference.symmetric.AddObject
import de.thm.evolvedb.mdde.Table
import de.thm.evolvedb.mdde.PrimaryKey
import de.thm.evolvedb.mdde.ForeignKey
import java.util.List
import de.thm.evolvedb.mdde.Column
import de.thm.evolvedb.migration.ResolvableOperator
import de.thm.evolvedb.migration.ProcessStatus
import de.thm.evolvedb.mdde.Constraint
import de.thm.evolvedb.mdde.UniqueConstraint
import de.thm.evolvedb.mdde.Index
import de.thm.evolvedb.migration.PartiallyResolvable
import de.thm.evolvedb.migration.ColumnOptions
import de.thm.evolvedb.mdde.ColumnConstraint

class CREATE_ELEMENT {

	def static String _CREATE_Table_IN_Database_Schema_entites(ResolvableOperator set) {
		if (set.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet addTable = set.semanticChangeSets.findFirst [
				editRName.equals('CREATE_Table_IN_Database_Schema_(entites)')
			]
			return _CREATE_Table_IN_Database_Schema_entites2(addTable);
		}

		return ""
	}

	def static String _CREATE_Table_IN_Database_Schema_entites2(SemanticChangeSet set) {
		var AddObject a = set.changes.findFirst[it instanceof AddObject] as AddObject
		return _CREATE_Table_IN_Database_Schema_entites2(a)
	}

	/**
	 * Creates a new Table with all attributes and foriegn keys
	 */
	def static String _CREATE_Table_IN_Database_Schema_entites2(AddObject a) {
		var Table entity;
		var content = '''''';

		if (a.obj instanceof Table) {
			entity = a.obj as Table

			var List<PrimaryKey> primaryKeys = entity.columns.filter[it instanceof PrimaryKey].map[it as PrimaryKey].
				toList
			var List<ForeignKey> foreignKeys = entity.columns.filter[it instanceof ForeignKey].map[it as ForeignKey].
				toList
			var List<ForeignKey> primaryForeignKeys = foreignKeys.filter[it.primaryForeignKey].toList

			var List<Column> columns = entity.columns.filter[it instanceof Column].toList
			columns.removeAll(primaryKeys)
			columns.removeAll(foreignKeys)

			if (primaryKeys.size > 0) {

				content += '''
					-- Create Table `«entity.name»`
					CREATE TABLE IF NOT EXISTS `«entity.name»`(
					«FOR PrimaryKey primaryKey : primaryKeys SEPARATOR ','»
						`«primaryKey.name»` «primaryKey.type.getLiteral()»«ColumnUtil.getSizeString(primaryKey)» «primaryKey.notNull !== null && primaryKey.notNull ? "NOT NULL" : ""» «primaryKey.autoIncrement !== null && primaryKey.autoIncrement ? "AUTO_INCREMENT" : ""»
					«ENDFOR»
					«FOR ForeignKey e : foreignKeys SEPARATOR ','»
						«e.name» «e.type»«ColumnUtil.getSizeString(e)» «e.notNull !== null && e.notNull ? "NOT NULL" : ""»,
						FOREIGN KEY (`«e.name»`) REFERENCES `«e.referencedTable.name»`(`«e.referencedKeyColumn.name»`)
						ON DELETE «e.onDelete.name()»
						ON UPDATE «e.onUpdate.name()»
					«ENDFOR»
					«FOR Column e : columns BEFORE ',' SEPARATOR ',' AFTER ','»
						`«e.name»` «e.type» «ColumnUtil.getSizeString(e)» «e.notNull !== null && e.notNull ? "NOT NULL" : ""» «e.autoIncrement !== null && e.autoIncrement ? "AUTO_INCREMENT" : ""» 
						«ColumnUtil.getDefaultValueString(e)»
					«ENDFOR»
					
					PRIMARY KEY («FOR PrimaryKey primaryKey : primaryKeys SEPARATOR ','»`«primaryKey.name»` «ENDFOR»)
					
					«IF entity.constraints.size > 0»«createConstraintString(entity, true)»«ENDIF»
					);
				'''

			} else if (primaryForeignKeys.size > 0) {

				content += '''
					-- Create Table «entity.name»
					CREATE TABLE IF NOT EXISTS `«entity.name»`  (
					«FOR ForeignKey e : foreignKeys SEPARATOR ',' AFTER ','»
						`«e.name»` «e.type»«ColumnUtil.getSizeString(e)» «e.notNull !== null && e.notNull ? "NOT NULL" : ""»
					«ENDFOR»
					«FOR Column e : columns BEFORE ',' SEPARATOR ',' AFTER ','»
						`«e.name»` «e.type» «ColumnUtil.getSizeString(e)» «e.notNull !== null && e.notNull ? "NOT NULL" : ""» «e.autoIncrement !== null && e.autoIncrement ? "AUTO_INCREMENT" : ""» 
						«ColumnUtil.getDefaultValueString(e)»
					«ENDFOR»
					«IF primaryForeignKeys.size > 0»
						PRIMARY KEY(«FOR ForeignKey e : primaryForeignKeys SEPARATOR ','»`«e.name»` «ENDFOR»),
					«ENDIF»
					«FOR ForeignKey e : foreignKeys SEPARATOR ','»
						CONSTRAINT `«e.constraintName»`
						FOREIGN KEY (`«e.name»`) 
						REFERENCES `«e.referencedTable.name»`(`«e.referencedKeyColumn.name»`)
						ON DELETE «e.onDelete.name()»
						ON UPDATE «e.onUpdate.name()»
					«ENDFOR»
					«IF entity.constraints.size > 0»«createConstraintString(entity, true)»«ENDIF»
					);
				'''

			} else {

//				var List<UniqueConstraint> uniqueIndexes = entity.constraints.filter(UniqueConstraint).toList
//				entity.constraints.removeAll(uniqueIndexes);
//				«FOR UniqueConstraint u : uniqueIndexes»
//						UNIQUE KEY `«u.name»` («FOR ColumnConstraint c : u.columns SEPARATOR ', '»`«c.column.name»`«ENDFOR»)
//					«ENDFOR»
				content += '''
					-- Create Table «entity.name»
					CREATE TABLE IF NOT EXISTS `«entity.name»`  (
					«FOR ForeignKey e : foreignKeys SEPARATOR ','»
						`«e.name»` «e.type»«ColumnUtil.getSizeString(e)» «e.notNull !== null && e.notNull ? "NOT NULL" : ""»,
						FOREIGN KEY (`«e.name»`) REFERENCES `«e.referencedTable.name»`(`«e.referencedKeyColumn.name»`)
						ON DELETE «e.onDelete.name()»
						ON UPDATE «e.onUpdate.name()»
					«ENDFOR»
					«FOR Column e : columns SEPARATOR ','»
						«IF foreignKeys.size > 0»,«ENDIF»`«e.name»` «e.type» «ColumnUtil.getSizeString(e)» «e.notNull !== null && e.notNull ? "NOT NULL" : ""» «e.autoIncrement !== null && e.autoIncrement ? "AUTO_INCREMENT" : ""» 
						«ColumnUtil.getDefaultValueString(e)»
					«ENDFOR»
					«IF entity.constraints.size > 0»«createConstraintString(entity, true)»«ENDIF»
					);
				'''
			}

		}
		return content;
	}

	def static String createConstraintString(Table table, boolean commaBefore) {

		'''
			«IF commaBefore»,«ENDIF»«FOR Constraint e : table.constraints SEPARATOR ','»
				«IF e instanceof UniqueConstraint»UNIQUE KEY «ELSE»«(e as Index).type» «ENDIF»«e.name» ( «FOR ColumnConstraint c : e.columns SEPARATOR ', '»«c.column.name»«IF c.length > 0»(«c.length»)«ENDIF»«IF c.constraint.sortSequence.literal.equals('D')» DESC«ENDIF»«ENDFOR»)
			«ENDFOR»
		'''
	}

	def static String createConstraintString(Constraint constraint, boolean commaBefore) {

		'''
			«IF commaBefore»,«ENDIF»
			ADD «IF constraint instanceof UniqueConstraint»UNIQUE KEY «ELSE»«(constraint as Index).type» «ENDIF»«constraint.name» ( «FOR ColumnConstraint c : constraint.columns SEPARATOR ', '»«c.column.name»«IF c.length > 0»(«c.length»)«ENDIF»«IF c.constraint.sortSequence.literal.equals('D')» DESC«ENDIF»«ENDFOR»)
		'''
	}

	/**
	 * Helper method for loops
	 */
	def static String extraKomma(int size) {
		if (size > 0)
			''','''
		else
			''''''
	}

	/**
	 * Create a new primary key in a table. The resolvable operator has to contain an Add_Object element.
	 */
	def static String _CREATE_PrimaryKey_IN_Table_columns(ResolvableOperator set) {
		if (set.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet addObject = set.semanticChangeSets.findFirst [
				editRName.equals('CREATE_PrimaryKey_IN_Table_(columns)')
			]
			return _CREATE_PrimaryKey_IN_Table_columns2(addObject);
		}

		return ""
	}

	/**
	 * Creates the sql string for adding am additional primary key in a table
	 */
	def static String _CREATE_PrimaryKey_IN_Table_columns2(SemanticChangeSet set) {

		var AddObject a = set.changes.findFirst[it instanceof AddObject] as AddObject
		var content = ""
		var PrimaryKey key;

		if (a.obj instanceof PrimaryKey) {
			key = a.obj as PrimaryKey;
			var parent = key.table
			// A table can have more than one primary key.
			var primaryKeys = parent.primaryKeys

			content += '''
				-- Create primary key in «parent.name.toLowerCase» 
				ALTER TABLE `«parent.name.toLowerCase»` 
				ADD COLUMN `«key.name»` «key.type»«ColumnUtil.getSizeString(key)» «key.notNull !== null && key.notNull ? "NOT NULL" : ""» «key.autoIncrement !== null && key.autoIncrement ? "AUTO_INCREMENT" : ""» «key.defaultValue !== null ? "DEFAULT "+key.defaultValue : ""»,
				DROP PRIMARY KEY,
				ADD PRIMARY KEY («FOR p : primaryKeys SEPARATOR ', '»`«p.name»`«ENDFOR»);
			'''

		}

		return content;

	}

	/**
	 * Create a new primary key in a table. The resolvable operator has to contain an Add_Object element.
	 */
	def static String _CREATE_ForeignKey_IN_Table_columns(ResolvableOperator set) {
		if (set.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet addObject = set.semanticChangeSets.findFirst [
				editRName.equals('CREATE_ForeignKey_IN_Table_(columns)')
			]
			return _CREATE_ForeignKey_IN_Table_columns2(addObject);
		}

		return ""
	}

	def static String _CREATE_ForeignKey_IN_Table_columns2(SemanticChangeSet set) {
		var AddObject a = set.changes.findFirst[it instanceof AddObject] as AddObject
		return _CREATE_Table_IN_Database_Schema_entites2(a)
	}

	/**
	 * Creates the sql string for adding a new foreign key
	 */
	def static String _CREATE_ForeignKey_IN_Table_columns2(AddObject a) {
		var content = ""
		var ForeignKey key;

		if (a.obj instanceof ForeignKey) {
			key = a.obj as ForeignKey;
			var parent = key.table

			content += '''
				-- add new column for foreign key
				ALTER TABLE `«parent.name.toLowerCase»` 
				ADD COLUMN `«key.name»` «key.type»«ColumnUtil.getSizeString(key)» «key.notNull !== null && key.notNull ? "NOT NULL" : ""» «key.autoIncrement !== null && key.autoIncrement ? "AUTO_INCREMENT" : ""» «key.defaultValue !== null ? "DEFAULT "+key.defaultValue : ""»;
								
				-- Create foreign key in «parent.name.toLowerCase»
				ALTER TABLE `«parent.name.toLowerCase»` 
				ADD CONSTRAINT `«key.constraintName»`
				  FOREIGN KEY (`«key.name»`)
				  REFERENCES `«key.referencedTable.name.toLowerCase»`(`«key.referencedKeyColumn.name»`)
				  ON DELETE «key.onDelete.name()»
				  ON UPDATE «key.onUpdate.name()»;
			'''
		}

		return content;

	}

	def static String _CREATE_Database_Schema(SemanticChangeSet set) {
	}

	/**
	 * Create a new column in a table. The resolvable operator has to contain an Add_Object element.
	 */
	def static String _CREATE_Column_IN_Table_columns(ResolvableOperator set) {
		if (set.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet addObject = set.semanticChangeSets.findFirst [
				editRName.equals('CREATE_Column_IN_Table_(columns)')
			]
			return _CREATE_Column_IN_Table_columns2(addObject);
		}

		return ""

	}

	/**
	 * Creates the sql string for adding a column in a table
	 */
	def static String _CREATE_Column_IN_Table_columns2(SemanticChangeSet set) {
		var AddObject a = set.changes.findFirst[it instanceof AddObject] as AddObject
		var Column attribute;

		if (a.obj instanceof Column) {
			attribute = a.obj as Column

			var Table owner = attribute.table
			var content = '''
				-- Add the new column «attribute.name» in Table «attribute.table.name.toLowerCase»
				ALTER TABLE `«attribute.table.name.toLowerCase»` 
				ADD COLUMN `«attribute.name»` «attribute.type»«ColumnUtil.getSizeString(attribute)» «attribute.notNull !== null && attribute.notNull ? "NOT NULL" : ""» «attribute.autoIncrement !== null && attribute.autoIncrement ? "AUTO_INCREMENT" : ""» 
				«ColumnUtil.getDefaultValueString(attribute)» ;
			'''
			return content;

		}

	}

	def static _CREATE_INDEX_IN_Table_constraints(de.thm.evolvedb.migration.ResolvableOperator set) {
		if (set.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet addObject = set.semanticChangeSets.findFirst [
				editRName.equals('CREATE_Index_IN_Table_(constraints)')
			]
			return _CREATE_INDEX_IN_Table_constraints2(addObject);
		}

		return ""
	}

	def static _CREATE_INDEX_IN_Table_constraints2(SemanticChangeSet set, ColumnOptions option) {
		var AddObject a = set.changes.findFirst[it instanceof AddObject] as AddObject

		if (a.obj instanceof Index) {
			var index = a.obj as Index

			var Table owner = index.table
			var content = '''
				-- Add the new index «index.name» in Table «index.table.name.toLowerCase»
				ALTER TABLE `«index.table.name.toLowerCase»` 
				«createConstraintString(index, false)» ;
			'''
			return content;

		} else if (a.obj instanceof UniqueConstraint) {

			var index = a.obj as UniqueConstraint
			var Table owner = index.table
			var content = '''
				-- Add the new index «index.name» in Table «index.table.name.toLowerCase»
				ALTER TABLE `«index.table.name.toLowerCase»` 
				«createConstraintString(index, false)» ;
			'''
			return content;
		}
	}

	def static _CREATE_INDEX_IN_Table_constraints2(SemanticChangeSet set) {
		_CREATE_INDEX_IN_Table_constraints2(set, null);
	}

	def static String _CREATE_UNIQUE_INDEX_IN_Table_constraints(PartiallyResolvable resolvable) {
		if (resolvable.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet addObject = resolvable.semanticChangeSets.findFirst [
				editRName.equals('CREATE_UniqueConstraint_IN_Table_(constraints)')
			]
			return _CREATE_INDEX_IN_Table_constraints2(addObject, resolvable.resolveOptions);
		}

		return ""
	}

	def static _ADD_COLUMN_TO_INDEX(de.thm.evolvedb.migration.ResolvableOperator set) {
		if (set.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet addObject = set.semanticChangeSets.findFirst [
				editRName.equals('CREATE_UniqueConstraint_IN_Table_(constraints)')
			]
			return _ADD_COLUMN_TO_INDEX2(addObject, null);
		}

		return ""
	}

	def static _ADD_COLUMN_TO_INDEX2(SemanticChangeSet set, ColumnOptions option) {
		var AddObject a = set.changes.findFirst[it instanceof AddObject] as AddObject

		if (a.obj instanceof ColumnConstraint) {
			var content = '''''';
			var objA = a.obj as ColumnConstraint
			var constraint = objA.constraint
			var column = objA.column

			content += '''
				-- Add column «column.name» to constraint «constraint.name»
				ALTER TABLE «constraint.table.name» DROP INDEX `«constraint.name»`,
				«CREATE_ELEMENT.createConstraintString(constraint, false)»;
			'''

			return content;

		}
	}

//def static String _resolveUniqueIndex(UniqueConstraint constraint, ColumnOptions columnOptions ) {
//	
//	
//	
//	var content = '''''';
//	switch columnOptions {
//		
//		case ColumnOptions.IGNORE: {
//			return '';
//		}
//		case ColumnOptions.SPECIFY_CONDITION_MANUALLY: {
//			content += '''-- TODO change all values of column «objB.name» that violate the new unique constraint'''
//		}
//		case ColumnOptions.DELETE_ROW: {
//
//			var key = objB.table.mainPrimaryKey;
//
//			var historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
//				objB.table.schema, objB.table, key, SQLGenerator.TEMPORY_TABLE_NAME)
//
//			content += '''
//				-- Set all values to null that violate the unique constraint
//				BEGIN;
//				SET @safe_mode = @@SQL_SAFE_UPDATES;
//				SET SQL_SAFE_UPDATES = 0;
//				DROP TEMPORARY TABLE IF EXISTS my_temp_table;
//				CREATE TEMPORARY TABLE my_temp_table
//				(SELECT «objB.name» FROM «objB.table.name.toLowerCase» 
//				GROUP BY «objB.name»
//				HAVING COUNT(«objB.name») > 1);
//				
//				DROP TEMPORARY TABLE IF EXISTS «SQLGenerator.TEMPORY_TABLE_NAME»;
//				CREATE TEMPORARY TABLE «SQLGenerator.TEMPORY_TABLE_NAME»
//				(SELECT «key.name» FROM «objB.table.name.toLowerCase» 
//				GROUP BY «objB.name»
//				HAVING COUNT(«objB.name») > 1);
//				«historyInsert»
//				DELETE FROM «objB.table.name.toLowerCase» where «objB.name» IN (SELECT * from my_temp_table);
//				SET SQL_SAFE_UPDATES = @safe_mode;
//				COMMIT;
//				
//			'''
//			content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
//			content += ColumnUtil.deleteTemporaryTable("my_temp_table");
//
//		}
//		case ColumnOptions.UPDATE_COLUMN_SET_TO_NULL: {
//
//			var whereClause = '''«objB.name» is not null;''';
//			var historyInsert = ColumnUtil.createInsertColumnHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
//				objB.table.schema, objB, objB.table.mainPrimaryKey, whereClause)
//
//			content += '''
//				-- Set «objB.name.toLowerCase» values to null 
//				SET @safe_mode = @@SQL_SAFE_UPDATES;
//				SET SQL_SAFE_UPDATES = 0;
//				«historyInsert»
//				UPDATE `«objB.table.name.toLowerCase»` SET `«objB.name»` = null;
//				SET SQL_SAFE_UPDATES = @safe_mode;
//				COMMIT;
//				-- If executing the script fails, we suggest a rollback.
//				
//			'''
//
//		}
//		case ColumnOptions.UPDATE_ROW_SET_TO_NULL: {
//
//			var key = objB.table.mainPrimaryKey;
//			var historyInsert = ColumnUtil.createInsertRowHistoryScript(SQLGenerator.HISTORY_TABLE_NAME,
//				objB.table.schema, objB.table, key, SQLGenerator.TEMPORY_TABLE_NAME)
//
//			content += '''
//				-- Set all values to null that violate the unique constraint
//				BEGIN;
//				SET @safe_mode = @@SQL_SAFE_UPDATES;
//				SET SQL_SAFE_UPDATES = 0;
//				DROP TEMPORARY TABLE IF EXISTS my_temp_table;
//				CREATE TEMPORARY TABLE my_temp_table
//				(SELECT «objA.name» FROM «objA.table.name.toLowerCase» 
//				GROUP BY «objA.name»
//				HAVING COUNT(«objA.name») > 1);
//				
//				DROP TEMPORARY TABLE IF EXISTS «SQLGenerator.TEMPORY_TABLE_NAME»;
//				CREATE TEMPORARY TABLE «SQLGenerator.TEMPORY_TABLE_NAME»
//				(SELECT «key.name» FROM «objB.table.name.toLowerCase» 
//				GROUP BY «objB.name»
//				HAVING COUNT(«objB.name») > 1);
//				«historyInsert»
//				UPDATE «objA.table.name.toLowerCase» SET «objA.name» = null where «objA.name» IN (SELECT * from my_temp_table);
//				SET SQL_SAFE_UPDATES = @safe_mode;
//				COMMIT;
//				
//			'''
//			content += ColumnUtil.deleteTemporaryTable(SQLGenerator.TEMPORY_TABLE_NAME);
//			content += ColumnUtil.deleteTemporaryTable("my_temp_table");
//
//		}
//	}
//
//	var constraintName = objB.table.name + "_UNIQUE";
//
//	if (objB.uniqueConstraintName !== null && !objB.uniqueConstraintName.equals(""))
//		constraintName = objB.uniqueConstraintName;
//	content += '''
//		-- Change uniqe attribute of «objA.name.toLowerCase» 
//		ALTER TABLE «objA.table.name.toLowerCase» ADD UNIQUE INDEX `«constraintName»` (`«objB.name»` ASC);
//	'''
//
//
//else {
//
//	content += '''
//						-- Change uniqe attribute of «
//	objA.name.toLowerCase» 
//						ALTER TABLE «
//	objA.table.name.toLowerCase» DROP INDEX `«
//	objB.uniqueConstraintName»`;
//					'''
//
//}
//	}
}
