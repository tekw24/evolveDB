package de.thm.xtend.ResourceFilter

import org.sidiff.difference.symmetric.SymmetricDifference
import org.eclipse.emf.ecore.resource.Resource

class ResourceFilter {

	def String filterForSymmetricDifference(Resource resModelFile) {
		var SymmetricDifference difference = resModelFile.allContents.
			findFirst[it instanceof SymmetricDifference] as SymmetricDifference
		var String modelA = difference.uriModelA
		var String modelB = difference.uriModelB
		return modelB
	}

}
