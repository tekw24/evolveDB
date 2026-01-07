package de.thm.evolvedb.graph.xtend

import de.thm.evolvedb.migration.GraphResolvableOperator
import de.thm.evolvedb.migration.ProcessStatus
import org.sidiff.difference.symmetric.SemanticChangeSet
import org.sidiff.difference.symmetric.AddObject
import java.util.List
import de.thm.evolvedb.graph.NodeLabel
import de.thm.evolvedb.graph.Property
import de.thm.evolvedb.graph.EdgeLabel
import de.thm.evolvedb.graph.EdgeType
import de.thm.evolvedb.graph.KeyConstraint
import de.thm.evolvedb.graph.UniqueConstraint
import de.thm.evolvedb.graph.PropertyExistenceConstraint
import de.thm.evolvedb.graph.PropertyTypeConstraint
import de.thm.evolvedb.graph.Constraint

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
//			for (AddObject a : properties) {
//				var property = a.obj as Property
//				content +=
//					GEOTemplates.addPropertyToNodeOnPath(nodelabel.name, property.name,
//						GeoTypeMapper.toGeoType(property.value), ''); // TODO
//			}
			for (Property property : nodelabel.properties) {
				content +=
					GEOTemplates.addPropertyToNode(property.name, nodelabel.name,
						GeoTypeMapper.toGeoType(property.value)); // TODO
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

		var content = ''''''

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

	/**
	 * Creates the GEO for a new Edge Label with Properties
	 */
	def static String createEdgeType(GraphResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
		} else
			return '';
		var SemanticChangeSet addEdgeType = operator.semanticChangeSets.findFirst [
			editRName.equals('CREATE_EdgeType_IN_PropertyGraph_(items)')
		]

		var List<AddObject> addObjects = addEdgeType.changes.filter[it instanceof AddObject].map[it as AddObject].toList
		var EdgeType edgetype = null;

		for (AddObject a : addObjects) {
			if (a.obj instanceof EdgeType) {
				edgetype = a.obj as EdgeType
			}
		}

		var content = ''''''

		var List<String> labelNames = newArrayList;
		if (edgetype !== null) {
			for (EdgeLabel edgeLabel : edgetype.labels) {
				labelNames.add(edgeLabel.name)
			}

			content += GEOTemplates.addEdgeType(edgetype.name, labelNames, edgetype.src.name, edgetype.tgt.name);

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

	def static String createConstraintInLabel(GraphResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
			var content = '''''';

			for (SemanticChangeSet scs : operator.semanticChangeSets) {

				var List<AddObject> newConstraints = newArrayList

				for (AddObject ad : scs.changes.filter[it instanceof AddObject].map[it as AddObject].toList) {

					if (ad.obj instanceof Constraint) {
						newConstraints.add(ad)
					}

				}

				for (AddObject a : newConstraints) {
					if (a.obj instanceof KeyConstraint) {
						var constraint = a.obj as KeyConstraint

						content +=
							GEOTemplates.createKeyConstraint(constraint.name, constraint.label, constraint.properties);

					} else if (a.obj instanceof UniqueConstraint) {
						var constraint = a.obj as UniqueConstraint
						content +=
							GEOTemplates.createUniqueConstraint(constraint.name, constraint.label, constraint.properties);

					} else if (a.obj instanceof PropertyExistenceConstraint) {
						var constraint = a.obj as PropertyExistenceConstraint
						content +=
							GEOTemplates.createPropertyExistenceConstraint(constraint.name, constraint.label, constraint.properties);

					} else if (a.obj instanceof PropertyTypeConstraint) {
						var constraint = a.obj as PropertyTypeConstraint
						content +=
							GEOTemplates.createPropertyTypeConstraint(constraint.name, constraint.label, constraint.properties);

					}

				}

			}

			return content;

		}

	}

}
