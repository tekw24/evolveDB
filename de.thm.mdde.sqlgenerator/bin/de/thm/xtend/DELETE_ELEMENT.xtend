package de.thm.xtend

import org.sidiff.difference.symmetric.SemanticChangeSet
import org.sidiff.difference.symmetric.RemoveObject
import de.thm.evolvedb.mdde.Column
import de.thm.evolvedb.mdde.PrimaryKey
import de.thm.evolvedb.mdde.ForeignKey
import de.thm.evolvedb.mdde.Table
import de.thm.evolvedb.migration.PartiallyResolvable
import de.thm.evolvedb.migration.ProcessStatus

class DELETE_ELEMENT {
	
	/**
	 * Delete a primaryKey 
	 * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
	 */
	def static String _DELETE_Table_IN_Database_Schema_entites(PartiallyResolvable partiallyResolvableOperator) {
		if (partiallyResolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			partiallyResolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet removeElement = partiallyResolvableOperator.semanticChangeSets.get(0)
			return _DELETE_Table_IN_Database_Schema_entites2(removeElement);
		}
		return ""
	}
	
	def static String _DELETE_Table_IN_Database_Schema_entites2(SemanticChangeSet set) {
		var RemoveObject a = set.changes.findFirst[it instanceof RemoveObject] as RemoveObject
		return _DELETE_Table_IN_Database_Schema_entites2(a)
	}

	def static String _DELETE_Table_IN_Database_Schema_entites2(RemoveObject a) {
		
		var content = ""
		var Table table;

		if (a.obj instanceof Table) {
			table = a.obj as Table;

			content += '''
				-- Drop table �table.name.toLowerCase�			
				DROP TABLE `�table.name.toLowerCase�`;
				
			'''

		}

		return content;
	}

	/**
	 * Delete a primaryKey 
	 * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
	 */
	def static String _DELETE_PrimaryKey_IN_Table_columns(PartiallyResolvable partiallyResolvableOperator) {
		if (partiallyResolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			partiallyResolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet removeElement = partiallyResolvableOperator.semanticChangeSets.get(0)
			return _DELETE_PrimaryKey_IN_Table_columns2(removeElement);
		}
		return ""
	}

	def static String _DELETE_PrimaryKey_IN_Table_columns2(SemanticChangeSet set) {

		var RemoveObject a = set.changes.findFirst[it instanceof RemoveObject] as RemoveObject
		var content = ""
		var PrimaryKey key;

		if (a.obj instanceof PrimaryKey) {
			key = a.obj as PrimaryKey;
			var parent = key.table

			content += '''
				-- Drop primary key in �parent.name.toLowerCase�			
				ALTER TABLE `�parent.name.toLowerCase�` 
				DROP COLUMN `�key.name�`,
				DROP PRIMARY KEY;
				
			'''

		}

		return content;

	}

	/**
	 * Delete a foreignKey 
	 * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
	 */
	def static String _DELETE_ForeignKey_IN_Table_columns(PartiallyResolvable partiallyResolvableOperator) {
		if (partiallyResolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			partiallyResolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet removeElement = partiallyResolvableOperator.semanticChangeSets.get(0)
			return _DELETE_ForeignKey_IN_Table_columns2(removeElement);
		}
		return ""
	}

	def static String _DELETE_ForeignKey_IN_Table_columns2(SemanticChangeSet set) {
		var RemoveObject a = set.changes.findFirst[it instanceof RemoveObject] as RemoveObject
		return _DELETE_ForeignKey_IN_Table_columns2(a)
	}

	def static String _DELETE_ForeignKey_IN_Table_columns2(RemoveObject a) {

		var content = ""
		var ForeignKey foreignKey;

		if (a.obj instanceof ForeignKey) {
			foreignKey = a.obj as ForeignKey;
			var parent = foreignKey.table

			content += '''
				-- Drop foreign key in �parent.name.toLowerCase�
				ALTER TABLE `�parent.name.toLowerCase�`
				DROP FOREIGN KEY `�foreignKey.constraintName�`;
				ALTER TABLE `�parent.name.toLowerCase�`
				DROP COLUMN `�foreignKey.name�`;
				
			'''

		}

		return content;

	}

	/**
	 * Delete a foreignKey 
	 * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
	 */
	def static String _DELETE_Column_IN_Table_columns(PartiallyResolvable partiallyResolvableOperator) {
		if (partiallyResolvableOperator.processStatus === ProcessStatus.RESOLVED &&
			partiallyResolvableOperator.semanticChangeSets.size == 1) {
			var SemanticChangeSet removeElement = partiallyResolvableOperator.semanticChangeSets.get(0)
			return _DELETE_Column_IN_Table_columns2(removeElement);
		}
		return ""
	}

	def static String _DELETE_Column_IN_Table_columns2(SemanticChangeSet set) {

		var RemoveObject a = set.changes.findFirst[it instanceof RemoveObject] as RemoveObject
		var content = ""
		var Column column;

		if (a.obj instanceof Column) {
			column = a.obj as Column;
			var parent = column.table

			content += '''
				-- Drop column in �parent.name.toLowerCase�			
				ALTER TABLE `�parent.name.toLowerCase�` 
				DROP COLUMN `�column.name�`;
			'''

		}

		return content;

	}
}
