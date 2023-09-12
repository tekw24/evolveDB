package de.thm.xtend

import org.sidiff.difference.symmetric.SemanticChangeSet
import org.sidiff.difference.symmetric.RemoveObject
import de.thm.evolvedb.mdde.Column
import de.thm.evolvedb.mdde.PrimaryKey
import de.thm.evolvedb.mdde.ForeignKey
import de.thm.evolvedb.mdde.Table
import de.thm.evolvedb.migration.PartiallyResolvable
import de.thm.evolvedb.migration.ProcessStatus
import de.thm.evolvedb.migration.ResolvableOperator
import java.util.List
import de.thm.evolvedb.mdde.Constraint
import org.sidiff.difference.symmetric.RemoveReference
import org.eclipse.emf.ecore.EObject
import de.thm.evolvedb.mdde.Index
import de.thm.evolvedb.mdde.UniqueConstraint
import de.thm.evolvedb.mdde.ColumnConstraint

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
				-- Drop table «table.name»			
				DROP TABLE `«table.name»`;
				
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
				-- Drop primary key in «parent.name»			
				ALTER TABLE `«parent.name»` 
				DROP COLUMN `«key.name»`,
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
				-- Drop foreign key in «parent.name»
				ALTER TABLE `«parent.name»`
				DROP FOREIGN KEY `«foreignKey.constraintName»`;
				ALTER TABLE `«parent.name»`
				DROP COLUMN `«foreignKey.name»`;
				
			'''

		}

		return content;

	}

	def static String _DELETE_ForeignKey_IN_Table_columns2(ForeignKey foreignKey) {

		var content = ""

		var parent = foreignKey.table

		content += '''
			-- Drop foreign key in «parent.name»
			ALTER TABLE `«parent.name»`
			DROP FOREIGN KEY `«foreignKey.constraintName»`;
			ALTER TABLE `«parent.name»`
			DROP COLUMN `«foreignKey.name»`;
			
		'''

		return content;

	}

	def static String _DELETE_ForeignKey_Constraint(ForeignKey foreignKey) {

		var content = ""

		var parent = foreignKey.table

		content += '''
			-- Drop foreign key in «parent.name»
			ALTER TABLE `«parent.name»`
			DROP FOREIGN KEY `«foreignKey.constraintName»`;
			
		'''

		return content;

	}

	def static String _DELETE_Column_IN_Table_columns2(Column column) {
		var content = ""

		var parent = column.table

		content += '''
			-- Drop foreign key in «parent.name»
			ALTER TABLE `«parent.name»`
			DROP COLUMN `«column.name»`;
			
		'''

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
				-- Drop column in «parent.name»			
				ALTER TABLE `«parent.name»` 
				DROP COLUMN `«column.name»`;
			'''

		}

		return content;

	}

	def static String DELETE_CONSTRAINT_IN_Table(ResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED && operator.semanticChangeSets.size == 1) {
			var SemanticChangeSet defaultValue = operator.semanticChangeSets.get(0)
			return DELETE_CONSTRAINT_IN_Table2(defaultValue);
		}
		return ""
	}

	def static String DELETE_CONSTRAINT_IN_Table2(SemanticChangeSet set) {
		var List<RemoveObject> changeColumnType = set.changes.filter(RemoveObject).toList
		var content = ""

		if (changeColumnType.size > 0) {

			for (RemoveObject a : changeColumnType) {
				if (a.obj instanceof ColumnConstraint) {

					var objA = a.obj as ColumnConstraint
					var constraint = objA.constraint
					constraint.columns.remove(objA);
									
					content += '''
						-- Remove constraint «objA.column.name» from «constraint.name» 
						ALTER TABLE «constraint.table.name» DROP INDEX `«constraint.name»`,
						«CREATE_ELEMENT.createConstraintString(constraint, false)»;
						
						
					'''

					return content;
				}
				else if(a.obj instanceof Constraint){
					
					var objA = a.obj as Constraint
					content += '''
						-- Remove constraint «objA.name» 
						ALTER TABLE «objA.table.name» DROP INDEX `«objA.name»`;
						
					'''

					return content;
					
				}
			}

		} else {
			var List<RemoveReference> removeReference = set.changes.filter(RemoveReference).toList

			if (removeReference.size > 0) {
				var RemoveReference removeObject = removeReference.get(0);

				var EObject eObject = removeObject.src

				var ColumnConstraint constraint;
				var Column column;

				if (eObject instanceof ColumnConstraint) {
					constraint = eObject as ColumnConstraint;
					column = removeObject.getTgt() as Column
				} else {
					constraint = removeObject.getTgt() as ColumnConstraint;
					column = removeObject.getSrc() as Column;
				}

				content += '''
					-- Remove column «column.name» from Index «constraint.name» 
					ALTER TABLE «constraint.column.table.name» DROP INDEX `«constraint.name»`;
					
				'''
				if (constraint.constraint instanceof Index) {
					var index = constraint.constraint  as Index
					index.columns.remove(column);
					var Table owner = index.table
					content += '''
						ALTER TABLE `«index.table.name»` 
						«CREATE_ELEMENT.createConstraintString(index, false)»
						 ;
					'''
					return content;

				} else if (constraint.constraint instanceof UniqueConstraint) {

					var index = constraint.constraint as UniqueConstraint
					var Table owner = index.table
					index.columns.remove(column);
					content += '''
						ALTER TABLE `«index.table.name»` 
						«CREATE_ELEMENT.createConstraintString(index, false)»
						 ;
					'''
					return content;
				}

			}

		}
		return content;
	}

}
