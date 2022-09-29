package de.thm.xtend

import org.sidiff.difference.symmetric.SemanticChangeSet
import de.thm.evolvedb.migration.NotAutomaticallyResolvable
import de.thm.evolvedb.migration.ProcessStatus
import org.sidiff.difference.symmetric.AddReference
import java.util.List
import org.sidiff.difference.symmetric.RemoveReference
import de.thm.evolvedb.mdde.Column
import de.thm.evolvedb.mdde.ForeignKey
import de.thm.evolvedb.mdde.PrimaryKey

class MOVE_ELEMENT {

	/**
	 * Move a primary key 
	 * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
	 */
	def static String _MOVE_PrimaryKey_FROM_Table_columns_TO_Table_columns(
		NotAutomaticallyResolvable notAutomaticallyResolvable) {
		if (notAutomaticallyResolvable.processStatus === ProcessStatus.RESOLVED &&
			notAutomaticallyResolvable.semanticChangeSets.size == 1) {
			var SemanticChangeSet removeElement = notAutomaticallyResolvable.semanticChangeSets.get(0)
			return _MOVE_PrimaryKey_FROM_Table_columns_TO_Table_columns2(removeElement);
		}
		return ""
	}

	def static String _MOVE_PrimaryKey_FROM_Table_columns_TO_Table_columns2(SemanticChangeSet set) {

		var List<RemoveReference> removeReference = set.getChanges().filter[it instanceof RemoveReference].map [
			it as RemoveReference
		].toList
		var List<AddReference> addReference = set.getChanges().filter[it instanceof AddReference].map [
			it as AddReference
		].toList

		if (removeReference.size() > 0 && addReference.size() > 0) {

			var AddReference addReferenceOptional = addReference.findFirst[it.src instanceof PrimaryKey]
			var RemoveReference removeReferenceOptional = removeReference.findFirst[it.src instanceof PrimaryKey]

			if (addReferenceOptional !== null && removeReferenceOptional !== null) {
				var PrimaryKey primaryKeyAdd = addReferenceOptional.src as PrimaryKey;
				var PrimaryKey primaryKeyRemove = removeReferenceOptional.src as PrimaryKey;

				var parent = primaryKeyAdd.table
				// A table can have more than one primary key.
				var primaryKeys = parent.primaryKeys

				var content = '''
					-- Create primary key in �parent.name.toLowerCase� 
					ALTER TABLE `�parent.name.toLowerCase�` 
					ADD COLUMN `�primaryKeyAdd.name�` �primaryKeyAdd.type��ColumnUtil.getSizeString(primaryKeyAdd)� �primaryKeyAdd.notNull !== null && primaryKeyAdd.notNull ? "NOT NULL" : ""� �primaryKeyAdd.autoIncrement !== null && primaryKeyAdd.autoIncrement ? "AUTO_INCREMENT" : ""� �ColumnUtil.getDefaultValueString(primaryKeyAdd)�,
					DROP PRIMARY KEY,
					ADD PRIMARY KEY (�FOR p : primaryKeys SEPARATOR ', '�`�p.name�`�ENDFOR�);
				'''

				content += '''
					-- Drop primary key in �primaryKeyRemove.table.name.toLowerCase�			
					ALTER TABLE `�primaryKeyRemove.table.name.toLowerCase�` 
					DROP COLUMN `�primaryKeyRemove.name�`,
					DROP PRIMARY KEY;
					ADD PRIMARY KEY (�FOR p : primaryKeyRemove.table.primaryKeys SEPARATOR ', '�`�p.name�`�ENDFOR�);
				'''

				return content;

			}
		}

	}

	/**
	 * Move a foreignKey 
	 * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
	 */
	def static String _MOVE_ForeignKey_FROM_Table_columns_TO_Table_columns(NotAutomaticallyResolvable notAutomaticallyResolvable) {
		if (notAutomaticallyResolvable.processStatus === ProcessStatus.RESOLVED &&
			notAutomaticallyResolvable.semanticChangeSets.size == 1) {
			var SemanticChangeSet removeElement = notAutomaticallyResolvable.semanticChangeSets.get(0)
			return _MOVE_ForeignKey_FROM_Table_columns_TO_Table_columns2(removeElement);
		}
		return ""
	}

	def static String _MOVE_ForeignKey_FROM_Table_columns_TO_Table_columns2(SemanticChangeSet set) {

		var List<RemoveReference> removeReference = set.getChanges().filter[it instanceof RemoveReference].map [
			it as RemoveReference
		].toList
		var List<AddReference> addReference = set.getChanges().filter[it instanceof AddReference].map [
			it as AddReference
		].toList

		if (removeReference.size() > 0 && addReference.size() > 0) {

			var AddReference addReferenceOptional = addReference.findFirst[it.src instanceof ForeignKey]
			var RemoveReference removeReferenceOptional = removeReference.findFirst[it.src instanceof ForeignKey]

			if (addReferenceOptional !== null && removeReferenceOptional !== null) {
				var ForeignKey foreignKeyAdd = addReferenceOptional.src as ForeignKey;
				var ForeignKey foreignKeyRemove = removeReferenceOptional.src as ForeignKey;

				var content = '''
					-- add new column for foreign key
					ALTER TABLE `�foreignKeyAdd.table.name.toLowerCase�` 
					ADD COLUMN `�foreignKeyAdd.name.toUpperCase�` �foreignKeyAdd.type��ColumnUtil.getSizeString(foreignKeyAdd)� �foreignKeyAdd.notNull !== null && foreignKeyAdd.notNull ? "NOT NULL" : ""� �foreignKeyAdd.autoIncrement !== null && foreignKeyAdd.autoIncrement ? "AUTO_INCREMENT" : ""� �ColumnUtil.getDefaultValueString(foreignKeyAdd)�;
									
					-- Create foreign key in �foreignKeyAdd.table.name.toLowerCase� 
					ALTER TABLE `�foreignKeyAdd.table.name.toLowerCase�` 
					ADD CONSTRAINT `�foreignKeyAdd.constraintName�`
					  FOREIGN KEY (`�foreignKeyAdd.name.toUpperCase�`)
					  REFERENCES `�foreignKeyAdd.referencedTable.name.toLowerCase�`(`�foreignKeyAdd.referencedKeyColumn.name.toUpperCase�`)
					  ON DELETE �foreignKeyAdd.onDelete.name()�
					  ON UPDATE �foreignKeyAdd.onUpdate.name()�;
				'''

				// TODO Daten?
				content += '''
					-- Drop foreign key in �foreignKeyRemove.table.name.toLowerCase�
					ALTER TABLE `�foreignKeyRemove.table.name.toLowerCase�`
					DROP FOREIGN KEY `�foreignKeyRemove.constraintName�`;
					ALTER TABLE `�foreignKeyRemove.table.name.toLowerCase�`
					DROP COLUMN `�foreignKeyRemove.name�`;
					
				'''
				return content;

			}

		}
	}

	/**
	 * Move a column
	 * @param partiallyResolvableOperator The partially resolvable operator containing the necessary information.
	 */
	def static String _MOVE_Column_FROM_Table_columns_TO_Table_columns(
		NotAutomaticallyResolvable notAutomaticallyResolvable) {
		if (notAutomaticallyResolvable.processStatus === ProcessStatus.RESOLVED &&
			notAutomaticallyResolvable.semanticChangeSets.size == 1) {
			var SemanticChangeSet removeElement = notAutomaticallyResolvable.semanticChangeSets.get(0)
			return _MOVE_Column_FROM_Table_columns_TO_Table_columns2(removeElement);
		}
		return ""
	}

	def static String _MOVE_Column_FROM_Table_columns_TO_Table_columns2(SemanticChangeSet set) {

		var List<RemoveReference> removeReference = set.getChanges().filter[it instanceof RemoveReference].map [
			it as RemoveReference
		].toList
		var List<AddReference> addReference = set.getChanges().filter[it instanceof AddReference].map [
			it as AddReference
		].toList

		if (removeReference.size() > 0 && addReference.size() > 0) {

			var AddReference addReferenceOptional = addReference.findFirst[it.src instanceof Column]

			var RemoveReference removeReferenceOptional = removeReference.findFirst[it.src instanceof Column]
			
			if (addReferenceOptional !== null && removeReferenceOptional !== null) {
				var Column columnAdd = addReferenceOptional.src as Column;
				var Column columnRemove = removeReferenceOptional.src as Column;

				var content = '''
					-- Add the new column �columnAdd.name.toUpperCase� in Table �columnAdd.table.name.toLowerCase�
					ALTER TABLE `�columnAdd.table.name.toLowerCase�` 
					ADD COLUMN `�columnAdd.name.toUpperCase�` �columnAdd.type��ColumnUtil.getSizeString(columnAdd)� �columnAdd.notNull !== null && columnAdd.notNull ? "NOT NULL" : ""� �columnAdd.autoIncrement !== null && columnAdd.autoIncrement ? "AUTO_INCREMENT" : ""� 
					�ColumnUtil.getDefaultValueString(columnAdd)� ;
				'''

				// If possible load the existing data into the new Column
				content += '''
					-- Drop column in �columnRemove.table.name.toLowerCase�
					ALTER TABLE `�columnRemove.table.name.toLowerCase�` 
					DROP COLUMN `�columnRemove.name�`;
				'''

				return content;
			}
		}
	}

}
