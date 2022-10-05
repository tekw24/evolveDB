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

			var PrimaryKey primaryKey = entity.columns.findFirst[it instanceof PrimaryKey] as PrimaryKey
			var List<ForeignKey> foreignKeys = entity.columns.filter[it instanceof ForeignKey].map[it as ForeignKey].
				toList
			var List<ForeignKey> primaryForeignKeys = foreignKeys.filter[it.primaryForeignKey].toList

			var List<Column> columns = entity.columns.filter[it instanceof Column].toList
			columns.remove(primaryKey)
			columns.removeAll(foreignKeys)

			if (primaryKey != null) {

				content+='''
					-- Create Table «entity.name»
					CREATE TABLE IF NOT EXISTS «entity.name»  (
					«IF primaryKey !== null» 
						«primaryKey.name.toUpperCase» «primaryKey.type.getName()»«ColumnUtil.getSizeString(primaryKey)» «primaryKey.notNull !== null && primaryKey.notNull ? "NOT NULL" : ""» «primaryKey.autoIncrement !== null && primaryKey.autoIncrement ? "AUTO_INCREMENT" : ""», PRIMARY KEY («primaryKey.name»));
					«ENDIF»
					«FOR ForeignKey e : foreignKeys SEPARATOR ','»
						«e.name.toUpperCase» «e.type»«ColumnUtil.getSizeString(e)» «e.notNull !== null && e.notNull ? "NOT NULL" : ""»,
						FOREIGN KEY («e.name.toUpperCase») REFERENCES «e.referencedTable.name»(DB_ID)
						ON DELETE «e.onDelete.name()»
						ON UPDATE «e.onUpdate.name()»
					«ENDFOR»
					«FOR Column e : columns BEFORE ',' SEPARATOR ',' AFTER extraKomma(primaryForeignKeys.size)»
						«e.name» «e.type» «ColumnUtil.getSizeString(e)» «e.notNull !== null && e.notNull ? "NOT NULL" : ""» «e.autoIncrement !== null && e.autoIncrement ? "AUTO_INCREMENT" : ""» 
						«ColumnUtil.getDefaultValueString(e)»
					«ENDFOR»
					
					);
				'''

			} else if (primaryForeignKeys.size > 0) {

				content+='''
					-- Create Table «entity.name»
					CREATE TABLE IF NOT EXISTS «entity.name»  (
					«FOR ForeignKey e : foreignKeys SEPARATOR ',' AFTER ',' »
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
						FOREIGN KEY (`«e.name.toUpperCase»`) 
						REFERENCES `«e.referencedTable.name»`(`«e.referencedKeyColumn.name»`)
						ON DELETE «e.onDelete.name()»
						ON UPDATE «e.onUpdate.name()»
					«ENDFOR»
					);
				'''

			}

		}
		return content;
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
				ADD COLUMN `«key.name.toUpperCase»` «key.type»«ColumnUtil.getSizeString(key)» «key.notNull !== null && key.notNull ? "NOT NULL" : ""» «key.autoIncrement !== null && key.autoIncrement ? "AUTO_INCREMENT" : ""» «key.defaultValue !== null ? "DEFAULT "+key.defaultValue : ""»;
								
				-- Create foreign key in «parent.name.toLowerCase»
				ALTER TABLE `«parent.name.toLowerCase»` 
				ADD CONSTRAINT `«key.constraintName»`
				  FOREIGN KEY (`«key.name.toUpperCase»`)
				  REFERENCES `«key.referencedTable.name.toLowerCase»`(`«key.referencedKeyColumn.name.toUpperCase»`)
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
				-- Add the new column «attribute.name.toUpperCase» in Table «attribute.table.name.toLowerCase»
				ALTER TABLE `«attribute.table.name.toLowerCase»` 
				ADD COLUMN `«attribute.name.toUpperCase»` «attribute.type»«ColumnUtil.getSizeString(attribute)» «attribute.notNull !== null && attribute.notNull ? "NOT NULL" : ""» «attribute.autoIncrement !== null && attribute.autoIncrement ? "AUTO_INCREMENT" : ""» 
				«ColumnUtil.getDefaultValueString(attribute)» ;
			'''
			return content;

		}

	}

}
