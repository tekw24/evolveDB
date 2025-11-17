package de.thm.evolvedb.graph.xtend

import de.thm.evolvedb.migration.GraphResolvableOperator
import de.thm.evolvedb.migration.ProcessStatus
import org.sidiff.difference.symmetric.SemanticChangeSet
import org.sidiff.difference.symmetric.AddObject
import java.util.List
import de.thm.evolvedb.graph.NodeLabel
import de.thm.evolvedb.graph.Property
import de.thm.evolvedb.graph.EdgeLabel

class GraphCreateOperator {

	def static String createLabel(GraphResolvableOperator smo) {

		if (smo.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet addNodeLabel = smo.semanticChangeSets.findFirst [
				editRName.equals('CREATE_NodeLabel_IN_PropertyGraph_(items)')
			]

			var List<SemanticChangeSet> addProperties = smo.semanticChangeSets.filter [
				editRName.equals('CREATE_Property_IN_LABEL_(properties)')
			].toList

			if (addNodeLabel !== null) {
				return createNodeLabel(addNodeLabel, addProperties);

			} else {
				addNodeLabel = smo.semanticChangeSets.findFirst [
					editRName.equals('CREATE_EdgeLabel_IN_PropertyGraph_(items)')
				]
				if (addNodeLabel !== null) {
					return createEdgeLabel(addNodeLabel, addProperties)
				}
			}
		}

		return ""

	}

	/**
	 * Creates the GEO for a new Node Label with Properties
	 */
	def static String createNodeLabel(SemanticChangeSet addNodeLabel, List<SemanticChangeSet> addProperties) {

		var List<AddObject> addObjects = addNodeLabel.changes.filter[it instanceof AddObject].map[it as AddObject].
			toList
		var List<AddObject> properties = newArrayList
		var NodeLabel nodelabel = null;

		for (AddObject a : addObjects) {
			if (a.obj instanceof NodeLabel) {
				nodelabel = a.obj as NodeLabel
			}
		}

		for (SemanticChangeSet scs : addProperties) {

			for (AddObject ad : scs.changes.filter[it instanceof AddObject].map[it as AddObject].toList) {

				if (ad.obj instanceof Property) {
					properties.add(ad)
				}

			}
		}

		var content = '''
		'''

		if (nodelabel !== null) {
			content += GEOTemplates.addNodeLabel(nodelabel.name)
			for (AddObject a : properties) {
				var property = a.obj as Property
				content +=
					GEOTemplates.addPropertyToNodeOnPath(nodelabel.name, property.name,
						GeoTypeMapper.toGeoType(property.value), ''); // TODO
			}
			return content;

		}

		return '';

	}

	/**
	 * Creates the GEO for a new Edge Label with Properties
	 */
	def static String createEdgeLabel(SemanticChangeSet addEdgeLabel, List<SemanticChangeSet> addProperties) {

		var List<AddObject> addObjects = addEdgeLabel.changes.filter[it instanceof AddObject].map[it as AddObject].
			toList
		var List<AddObject> properties = newArrayList
		var EdgeLabel edgelabel = null;

		for (AddObject a : addObjects) {
			if (a.obj instanceof EdgeLabel) {
				edgelabel = a.obj as EdgeLabel
			}
		}

		for (SemanticChangeSet scs : addProperties) {

			for (AddObject ad : scs.changes.filter[it instanceof AddObject].map[it as AddObject].toList) {

				if (ad.obj instanceof Property) {
					properties.add(ad)
				}

			}
		}

		var content = '''
		'''

		if (edgelabel !== null) {
			content += GEOTemplates.addRelationshipType(edgelabel.name)
			for (AddObject a : properties) {
				var property = a.obj as Property
				content +=
					GEOTemplates.addRelationshipProperty(edgelabel.name, property.name,
						GeoTypeMapper.toGeoType(property.value), '');
			}
			return content;

		}

		return '';

	}

	def static String createNodeType(GraphResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
		} else
			return '';

	}

	def static String createProperty(GraphResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
			var List<SemanticChangeSet> addProperties = operator.semanticChangeSets.filter [
				editRName.equals('CREATE_Property_IN_LABEL_(properties)')
			].toList
			var List<AddObject> properties = newArrayList
			var content = '''''';
			
			for (SemanticChangeSet scs : addProperties) {

				for (AddObject ad : scs.changes.filter[it instanceof AddObject].map[it as AddObject].toList) {

					if (ad.obj instanceof Property) {
						properties.add(ad)
					}

				}
			}

			for (AddObject a : properties) {
				var property = a.obj as Property
				
				// String propertyName, String nodeLabel, String startRelType, String endRelType
				content +=
					GEOTemplates.addPropertyToNodeOnPath(property.name, GEOHelper.getPropertyParent(property),
						GeoTypeMapper.toGeoType(property.value), '');
			}

		

			return content;
		} else
			return '';
	}

}
