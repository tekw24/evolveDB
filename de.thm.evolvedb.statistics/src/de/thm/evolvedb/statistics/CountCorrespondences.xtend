package de.thm.evolvedb.statistics

import org.eclipse.emf.ecore.resource.Resource
import org.sidiff.matching.model.Correspondence
import java.util.List
import de.thm.evolvedb.mdde.Table
import de.thm.evolvedb.mdde.Column
import de.thm.evolvedb.mdde.Constraint
import org.eclipse.emf.ecore.EObject
import de.thm.evolvedb.mdde.ColumnConstraint
import de.thm.evolvedb.mdde.Database_Schema

class CountCorrespondences {

	def String countCorrespondences(Resource resourceDifference) {

		for (Correspondence e : resourceDifference.allContents.toIterable.filter(typeof(Correspondence))) {
		}

		var number = resourceDifference.allContents.toIterable.filter(typeof(Correspondence))

		var result = '''The Resource contained «number.size» correspondences
		
		''';
		return result

	}
	
	
	def String countStructuralElements(Resource resourceDifference){
		
		for (Correspondence e : resourceDifference.allContents.toIterable.filter(typeof(Correspondence))) {
		}

		var number = resourceDifference.allContents.toIterable.filter(typeof(EObject))

		var result = '''The Resource contained «number.size» structuralElements
		
		''';
		return result
		
	}

	/**
	 * resourceA is the ground truth resourceB is the automatical matching without corrections
	 */
	def String returnTruepositives(Resource resourceA, Resource resourceB) {

		var List<Correspondence> corespondencesA = resourceA.allContents.toIterable.filter(typeof(Correspondence)).
			toList;
		var List<Correspondence> corespondencesB = resourceB.allContents.toIterable.filter(typeof(Correspondence)).
			toList;

		var List<Correspondence> intersection = intersection(corespondencesA, corespondencesB);

		var List<Correspondence> tables = intersection.filter[it.matchedA instanceof Table].toList
		var List<Correspondence> columns = intersection.filter[it.matchedA instanceof Column].toList
		var List<Correspondence> constraints = intersection.filter[it.matchedA instanceof Constraint].toList
		var List<Correspondence> columnConstraint = intersection.filter[it.matchedA instanceof ColumnConstraint].toList
		var List<Correspondence> databaseSchema = intersection.filter[it.matchedA instanceof Database_Schema].toList

		var content = '''
			Die Anzahl der True Positives beträgt insgesamt: «intersection.size»
			Table True Positives: «tables.size»
			Column True Positives: «columns.size»
			Constraint True Positives: «constraints.size»
			Column Constraint True Positives: «columnConstraint.size»
			Database Schema True Positives: «databaseSchema.size»
			
		'''

		return content;
	}

	def List<Correspondence> intersection(List<Correspondence> list1, List<Correspondence> list2) {
		list1.filter [ c1 |
			list2.exists [ c2 |
				c1.matchedA.castEobjectGetName == c2.matchedA.castEobjectGetName &&
					c1.matchedB.castEobjectGetName == c2.matchedB.castEobjectGetName
			]
		].toList
	}

	def String castEobjectGetName(EObject eObject) {

		if (eObject instanceof Table)
			return (eObject as Table).name
		else if (eObject instanceof Column)
			return (eObject as Column).name
		else if (eObject instanceof Constraint)
			return (eObject as Constraint).name
		else if (eObject instanceof ColumnConstraint)
			return (eObject as ColumnConstraint).name
		else if (eObject instanceof Database_Schema)
			return (eObject as Database_Schema).name	
		else {
			println("None")
			println("" + eObject.eClass)
		}

	}

}
