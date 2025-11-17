package de.thm.evolvedb.graph.xtend

import de.thm.evolvedb.migration.GraphResolvableOperator
import de.thm.evolvedb.migration.ProcessStatus
import org.sidiff.difference.symmetric.SemanticChangeSet
import org.sidiff.difference.symmetric.AddObject
import java.util.List
import de.thm.evolvedb.graph.NodeLabel
import de.thm.evolvedb.graph.EdgeLabel
import de.thm.evolvedb.graph.Property
import de.thm.evolvedb.migration.GraphNotAutomaticallyResolvableOperator
import org.sidiff.difference.symmetric.AttributeValueChange
import de.thm.evolvedb.graph.Label
import de.thm.evolvedb.graph.impl.PropertyImpl
import de.thm.evolvedb.graph.impl.EdgeLabelImpl
import de.thm.evolvedb.graph.impl.NodeLabelImpl

class GraphChangeOperator {

	def static String changeName(GraphResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
			var List<SemanticChangeSet> addProperties = operator.semanticChangeSets.filter [
				editRName.equals('SET_ATTRIBUTE_Property_Name') || editRName.equals('SET_ATTRIBUTE_Label_Name')
			].toList
			var List<AttributeValueChange> properties = newArrayList
			var content = '''''';

			for (SemanticChangeSet scs : addProperties) {

				for (AttributeValueChange ad : scs.changes.filter[it instanceof AttributeValueChange].map [
					it as AttributeValueChange
				].toList) {

					properties.add(ad)

				}
			}

			for (AttributeValueChange a : properties) {

				switch a.objA {
					EdgeLabel: {
						var edgeLabelA = a.objA as EdgeLabel;
						var edgeLabelB = a.objB as EdgeLabel;
						content +=
							GEOTemplates.renameRelationshipType(edgeLabelA.name, edgeLabelB.name);
					}
					NodeLabel: {
						var nodeLabelA = a.objA as NodeLabel;
						var nodeLabelB = a.objB as NodeLabel;
						content +=
							GEOTemplates.renameNodeLabel(nodeLabelA.name, nodeLabelB.name);
					}
					Property: {
						var propertyA = a.objA as Property;
						var propertyB = a.objB as Property;
						content +=
							GEOTemplates.renameSimpleNodeProperty(GEOHelper.getPropertyParent(propertyA), propertyA.name, propertyB.name)
					}
					default: {
						return 'Error'
					}
				}
			}

			return content;
		} else
			return '';
	}

	def static String addLabelToNodeType(GraphResolvableOperator operator) {
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

	def static String moveCombined(GraphNotAutomaticallyResolvableOperator operator) {
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

	def static String moveEdgeType(GraphNotAutomaticallyResolvableOperator operator) {
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

	def static String moveLabel(GraphNotAutomaticallyResolvableOperator operator) {
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

	def static String moveNodeType(GraphNotAutomaticallyResolvableOperator operator) {
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

	def static String moveProperty(GraphNotAutomaticallyResolvableOperator operator) {
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
