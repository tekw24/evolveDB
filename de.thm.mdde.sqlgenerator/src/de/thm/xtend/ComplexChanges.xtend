package de.thm.xtend

import de.thm.evolvedb.migration.PartiallyResolvable
import de.thm.evolvedb.migration.ProcessStatus
import org.sidiff.difference.symmetric.SemanticChangeSet
import org.sidiff.difference.symmetric.AddObject
import java.util.List
import org.sidiff.difference.symmetric.Change
import de.thm.evolvedb.mdde.Table
import de.thm.evolvedb.migration.ColumnOptions
import de.thm.evolvedb.mdde.Column
import de.thm.evolvedb.mdde.ForeignKey
import org.sidiff.difference.symmetric.RemoveObject
import de.thm.evolvedb.mdde.PrimaryKey
import java.util.ArrayList
import de.thm.evolvedb.migration.NotAutomaticallyResolvable
import de.thm.evolvedb.migration.ComplexResolveOptions
import org.sidiff.difference.symmetric.AddReference
import org.sidiff.difference.symmetric.RemoveReference

class ComplexChanges {

	def static String _CHANGE_1N_INTO_NM(PartiallyResolvable set) {
		if (set.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet change = set.semanticChangeSets.findFirst [
				editRName.equals('CHANGE_1N_INTO_NM')
			]
			return _CHANGE_1N_INTO_NM(change, set.resolveOptions);
		}

		return ""
	}

	def static String _CHANGE_1N_INTO_NM(SemanticChangeSet set, ColumnOptions options) {
		var List<Change> addObjects = set.changes.filter[it instanceof AddObject].toList
		var List<Change> removeObject = set.changes.filter[it instanceof RemoveObject].toList

		var AddObject addObject;
		// Es kann nur ein add Table enthalten sein.
		for (Change change : addObjects) {
			var AddObject temp = change as AddObject
			if (temp.obj instanceof Table) {
				addObject = temp;
			}

		}

		var RemoveObject removeForeign;
		for (Change change : removeObject) {
			var RemoveObject temp = change as RemoveObject
			if (temp.obj instanceof ForeignKey) {
				removeForeign = temp;
			}

		}

		var content = '''
		''';

		if (addObject === null || removeForeign === null)
			return content;

		content += CREATE_ELEMENT._CREATE_Table_IN_Database_Schema_entites2(addObject);

		if (addObject.obj instanceof Table) {
			var entity = addObject.obj as Table
			var List<ForeignKey> foreignKeys = entity.columns.filter[it instanceof ForeignKey].map[it as ForeignKey].
				toList
			var List<ForeignKey> primaryForeignKeys = foreignKeys.filter[it.primaryForeignKey].toList
			var removeForeignKey = removeForeign.obj as ForeignKey;
			var PrimaryKey sourceKey;
			var ForeignKey sourceForeign;
			var ForeignKey targetForeign;

			for (ForeignKey foreignKey : primaryForeignKeys) {
				if (foreignKey.referencedTable.name.equals(removeForeignKey.table.name)) {
					sourceKey = foreignKey.referencedKeyColumn
					sourceForeign = foreignKey
				} else {
					targetForeign = foreignKey
				}
			}

			if (options.equals(ColumnOptions.MIGRATE_DATA)) {
				content += '''
					BEGIN;
					SET @safe_mode = @@SQL_SAFE_UPDATES;
					SET SQL_SAFE_UPDATES = 0;
					
					-- Migrate data to the new table
					INSERT INTO `«entity.name»` («sourceForeign.name» , «targetForeign.name»)
					SELECT «sourceKey.name», «removeForeignKey.name» FROM «removeForeignKey.table.name» WHERE «removeForeignKey.name» IS NOT NULL;
					
					SET SQL_SAFE_UPDATES = @safe_mode;
					COMMIT;
					-- If executing the script fails, we suggest a rollback.
					
				'''

			}

			content += DELETE_ELEMENT._DELETE_ForeignKey_IN_Table_columns2(removeForeign);

		}

		return content;

	}

	def static String _CHANGE_1N_INTO_NM_MOVE(PartiallyResolvable set) {
		if (set.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet change = set.semanticChangeSets.findFirst [
				editRName.equals('CHANGE_1N_INTO_NM_MOVE')
			]
			return _CHANGE_1N_INTO_NM_MOVE(change, set.resolveOptions);
		}

		return ""
	}

	def static String _CHANGE_1N_INTO_NM_MOVE(SemanticChangeSet set, ColumnOptions options) {
		var List<Change> addObjects = set.changes.filter[it instanceof AddObject].toList
		var List<Change> removeReference = set.changes.filter[it instanceof RemoveReference].toList

		var AddObject addObject;
		// Es kann nur ein add Table enthalten sein.
		for (Change change : addObjects) {
			var AddObject temp = change as AddObject
			if (temp.obj instanceof Table) {
				addObject = temp;
			}

		}

		var RemoveReference removeForeign;
		for (Change change : removeReference) {
			var RemoveReference temp = change as RemoveReference
			if (temp.src instanceof ForeignKey) {
				removeForeign = temp;
			}

		}

		var content = '''''';
		
		//Delete the constraint before creating the new table because the constraint name has to be unique.
		content += DELETE_ELEMENT._DELETE_ForeignKey_Constraint(removeForeign.src as ForeignKey);

		if (addObject === null || removeForeign === null)
			return content;

		content += CREATE_ELEMENT._CREATE_Table_IN_Database_Schema_entites2(addObject);

		if (addObject.obj instanceof Table) {
			var entity = addObject.obj as Table
			var List<ForeignKey> foreignKeys = entity.columns.filter[it instanceof ForeignKey].map[it as ForeignKey].
				toList
			var List<ForeignKey> primaryForeignKeys = foreignKeys.filter[it.primaryForeignKey].toList
			var removeForeignKey = removeForeign.src as ForeignKey;
			var PrimaryKey sourceKey;
			var ForeignKey sourceForeign;
			var ForeignKey targetForeign;

			for (ForeignKey foreignKey : primaryForeignKeys) {
				if (foreignKey.referencedTable.name.equals(removeForeignKey.table.name)) {
					sourceKey = foreignKey.referencedKeyColumn
					sourceForeign = foreignKey
				} else {
					targetForeign = foreignKey
				}
			}

			if (options.equals(ColumnOptions.MIGRATE_DATA)) {
				content += '''
					BEGIN;
					SET @safe_mode = @@SQL_SAFE_UPDATES;
					SET SQL_SAFE_UPDATES = 0;
					
					-- Migrate data to the new table
					INSERT INTO `«entity.name»` («sourceForeign.name» , «targetForeign.name»)
					SELECT «sourceKey.name», «removeForeignKey.name» FROM «removeForeignKey.table.name» WHERE «removeForeignKey.name» IS NOT NULL;
					
					SET SQL_SAFE_UPDATES = @safe_mode;
					COMMIT;
					
				'''

			}

			content += DELETE_ELEMENT._DELETE_Column_IN_Table_columns2(removeForeignKey);

		}

		return content;

	}

	def static String _CHANGE_1N_INTO_NM_PRESERVE(PartiallyResolvable set) {
		if (set.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet change = set.semanticChangeSets.findFirst [
				editRName.equals('CHANGE_1N_INTO_NM_PRESERVE')
			]
			return _CHANGE_1N_INTO_NM_PRESERVE(change, set.resolveOptions);
		}

		return ""
	}

	def static String _CHANGE_1N_INTO_NM_PRESERVE(SemanticChangeSet set, ColumnOptions options) {
		var List<Change> addObjects = set.changes.filter[it instanceof AddObject].toList

		var AddObject addObject;
		// Es kann nur ein add Table enthalten sein.
		for (Change change : addObjects) {
			var AddObject temp = change as AddObject
			if (temp.obj instanceof Table) {
				addObject = temp;
			}

		}

		var content = '''
		''';

		if (addObject === null)
			return content;

		content += CREATE_ELEMENT._CREATE_Table_IN_Database_Schema_entites2(addObject);

		if (options.equals(ColumnOptions.MIGRATE_DATA)) {

			if (addObject.obj instanceof Table) {
				var entity = addObject.obj as Table
				var List<ForeignKey> foreignKeys = entity.columns.filter[it instanceof ForeignKey].
					map[it as ForeignKey].toList
				var List<ForeignKey> primaryForeignKeys = foreignKeys.filter[it.primaryForeignKey].toList
				val List<PrimaryKey> referencedKeys = primaryForeignKeys.map[it.referencedKeyColumn].toList

				var List<ForeignKey> oldForeignKeys = new ArrayList

				for (ForeignKey foreignKey : primaryForeignKeys) {
					oldForeignKeys.addAll(foreignKey.referencedTable.foreignKeys.filter [
						referencedKeys.contains(it.referencedKeyColumn) && !it.table.equals(it.referencedTable)
					].toList)
				}

				for (ForeignKey oldForeign : oldForeignKeys) {

					var PrimaryKey sourceKey;
					var ForeignKey sourceForeign;
					var ForeignKey targetForeign;
					val sourceTable = oldForeign.table;

					sourceForeign = primaryForeignKeys.findFirst[it.referencedTable.equals(sourceTable)]
					targetForeign = primaryForeignKeys.findFirst[!it.referencedTable.equals(sourceTable)]
					sourceKey = sourceForeign.referencedKeyColumn

					content += '''
						BEGIN;
						SET @safe_mode = @@SQL_SAFE_UPDATES;
						SET SQL_SAFE_UPDATES = 0;
						
						-- Migrate data to the new table
						INSERT INTO `«entity.name» («sourceForeign.name» , «targetForeign.name»)
						SELECT «sourceKey.name», «oldForeign.name» FROM «oldForeign.table.name» WHERE «oldForeign.name» IS NOT NULL;
						
						SET SQL_SAFE_UPDATES = @safe_mode;
						COMMIT;
						-- If executing the script fails, we suggest a rollback.
						
					'''
				// «FOR ForeignKey f : primaryForeignKeys BEFORE '(' SEPARATOR ', ' AFTER ')'»»f.name»»ENDFOR»
				}

			}

		}

		return content;

	}

	def static String _CHANGE_NM_INTO_1N(PartiallyResolvable set) {
		if (set.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet change = set.semanticChangeSets.findFirst [
				editRName.equals('CHANGE_NM_INTO_1N')
			]
			return _CHANGE_NM_INTO_1N(change, set.resolveOptions);
		}

		return ""
	}

	def static String _CHANGE_NM_INTO_1N(SemanticChangeSet set, ColumnOptions options) {
		var List<Change> addObjects = set.changes.filter[it instanceof AddObject].toList
		var List<Change> removeObject = set.changes.filter[it instanceof RemoveObject].toList

		var AddObject addForeign;
		// Es kann nur ein add foreignkey enthalten sein.
		for (Change change : addObjects) {
			var AddObject temp = change as AddObject
			if (temp.obj instanceof ForeignKey) {
				addForeign = temp;
			}

		}

		var RemoveObject removeTable;
		// Es kann nur ein remove Table enthalten sein.
		for (Change change : removeObject) {
			var RemoveObject temp = change as RemoveObject
			if (temp.obj instanceof Table) {
				removeTable = temp;
			}

		}

		var content = '''
		''';

		if (addForeign === null || removeTable === null)
			return content;

		content += CREATE_ELEMENT._CREATE_ForeignKey_IN_Table_columns2(addForeign);

		if (options.equals(ColumnOptions.MIGRATE_DATA) || options.equals(ColumnOptions.DELETE_DUBLICATES) ||
			options.equals(ColumnOptions.IGNORE_DUBLICATES)) {
			if (addForeign.obj instanceof ForeignKey) {
				val newForeignKey = addForeign.obj as ForeignKey
				var oldTable = removeTable.obj as Table

				var List<ForeignKey> foreignKeys = oldTable.columns.filter[it instanceof ForeignKey].map [
					it as ForeignKey
				].toList
				var List<ForeignKey> primaryForeignKeys = foreignKeys.filter[it.primaryForeignKey].toList

				var ForeignKey sourceForeign = primaryForeignKeys.findFirst [
					it.referencedTable.name.equals(newForeignKey.table.name)
				]
				var ForeignKey targetForeign = primaryForeignKeys.findFirst [
					it.referencedKeyColumn.name.equals(newForeignKey.referencedKeyColumn.name)
				]

				if (sourceForeign !== null && targetForeign !== null) {

					content += '''
						BEGIN;
						SET @safe_mode = @@SQL_SAFE_UPDATES;
						SET SQL_SAFE_UPDATES = 0;
						
						-- Migrate data from the old table
						UPDATE «newForeignKey.table.name» t SET«newForeignKey.name» = 
						(SELECT«targetForeign.name» FROM«targetForeign.table.name» n WHERE n.»sourceForeign.name» = t.»sourceForeign.referencedKeyColumn.name» );
						
						SET SQL_SAFE_UPDATES = @safe_mode;
						COMMIT;
						-- If executing the script fails, we suggest a rollback.
						
					'''

				}

			}
		}

		content += DELETE_ELEMENT._DELETE_Table_IN_Database_Schema_entites2(removeTable);

		return content;

	}

	def static String _CHANGE_NM_INTO_1N_PRESERVE(de.thm.evolvedb.migration.PartiallyResolvable resolvable) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	def static String _JOIN_TABLE(NotAutomaticallyResolvable resolvable) {
		if (resolvable.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet change = resolvable.semanticChangeSets.findFirst [
				editRName.equals('JOIN_tables')
			]
			return _JOIN_TABLE(change, resolvable.resolveOptions);
		}

		return ""
	}

	def static String _JOIN_TABLE(SemanticChangeSet change, ComplexResolveOptions option) {

		val List<RemoveObject> removeObject = change.getChanges().filter[it instanceof RemoveObject].map [
			it as RemoveObject
		].toList;
		val List<AddObject> addObject = change.getChanges().filter[it instanceof AddObject].map[it as AddObject].toList;

		var content = '''''';
		if (removeObject.size() > 0 && addObject.size() > 0) {

			// New Table
			val AddObject addTable = addObject.findFirst[it.getObj() instanceof Table];

			// List old tables
			val List<RemoveObject> removeTables = removeObject.filter[it.getObj() instanceof Table].toList

			var List<Table> removeTable = removeTables.map[it.getObj() as Table].toList

			// Moved Columns
			var List<AddReference> addReference = change.getChanges().filter[it instanceof AddReference].map [
				it as AddReference
			].toList
			var List<AddReference> addReferenceOptional = addReference.filter[it.src instanceof Column].toList

			var List<RemoveReference> removeReference = change.getChanges().filter[it instanceof RemoveReference].map [
				it as RemoveReference
			].toList
			var List<Column> removeColumns = removeReference.filter[it.src instanceof Column].map[it.src as Column].
				toList

			var map = removeColumns.groupBy[table]

			if (addTable !== null && removeTables.size() == 2) {

				var Table newTable = addTable.obj as Table;

				switch (option) {
					case CARTESIAN_PRODUCT: {
						content += '''
							-- Join tables«removeTable.get(0).name» and«removeTable.get(0).name»
							CREATE TABLE«newTable.name» 
							(SELECT«FOR Column c : map.get(removeTable.get(0)) SEPARATOR ',' AFTER ','» a.«c.name»«ENDFOR» 
							«FOR Column c : map.get(removeTable.get(1)) SEPARATOR ',' AFTER ' '» b.«c.name»«ENDFOR»
							FROM«removeTable.get(0).name» a 
							CROSS JOIN«removeTable.get(1).name» b )
						'''

					}
					case IGNORE: {
						content += CREATE_ELEMENT._CREATE_Table_IN_Database_Schema_entites2(addTable)

					}
					case RESOLVE_BY_DB_ID: {

						content += '''
							-- Join tables«removeTable.get(0).name» and«removeTable.get(0).name»
							CREATE TABLE«newTable.name» 
							(SELECT«FOR Column c : map.get(removeTable.get(0)) SEPARATOR ',' AFTER ','» a.«c.name»«ENDFOR» 
							«FOR Column c : map.get(removeTable.get(1)) SEPARATOR ',' AFTER ' '» b.«c.name»«ENDFOR»
							FROM«removeTable.get(0).name» a 
							JOIN«removeTable.get(1).name» b where a.«removeTable.get(0).mainPrimaryKey.name» = b.«removeTable.get(1).mainPrimaryKey.name»)
						'''

					}
				}

				for (RemoveObject o : removeTables)
					content += DELETE_ELEMENT._DELETE_Table_IN_Database_Schema_entites2(o)

			}

		}

		return content;
	}
}
