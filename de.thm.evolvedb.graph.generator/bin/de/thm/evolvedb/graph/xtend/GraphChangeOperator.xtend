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
import org.sidiff.difference.symmetric.RemoveObject
import de.thm.evolvedb.graph.PropertyValueType
import de.thm.evolvedb.graph.EdgeType
import de.thm.evolvedb.graph.NodeType
import org.sidiff.difference.symmetric.AddReference
import org.sidiff.difference.symmetric.RemoveReference
import org.sidiff.difference.symmetric.Change
import java.lang.foreign.AddressLayout

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
						content += GEOTemplates.renameRelationshipType(edgeLabelA.name, edgeLabelB.name);
					}
					NodeLabel: {
						var nodeLabelA = a.objA as NodeLabel;
						var nodeLabelB = a.objB as NodeLabel;
						content += GEOTemplates.renameNodeLabel(nodeLabelA.name, nodeLabelB.name);
					}
					Property: {
						var propertyA = a.objA as Property;
						var propertyB = a.objB as Property;
						content +=
							GEOTemplates.renameSimpleNodeProperty(GEOHelper.getPropertyParent(propertyA),
								propertyA.name, propertyB.name)
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
				editRName.equals('ADD_NodeLabel_(nodes)_TGT_NodeType')
			].toList

			var content = '''''';
			var NodeType nodeType;
			var NodeLabel nodeLabel;

			for (SemanticChangeSet scs : addProperties) {

				var AddReference ad = scs.changes.findFirst[it instanceof AddReference] as AddReference;

				if (ad.src instanceof NodeType && ad.tgt instanceof NodeLabel) {
					nodeType = ad.src as NodeType
					nodeLabel = ad.tgt as NodeLabel
				} else if (ad.src instanceof NodeLabel && ad.tgt instanceof NodeType) {
					nodeType = ad.tgt as NodeType
					nodeLabel = ad.src as NodeLabel
				}

			}

			var List<String> labelNames = newArrayList;

			for (NodeLabel label : nodeType.label) {
				if (!label.name.equals(nodeLabel.name))
					labelNames.add(label.name);
			}

			// String propertyName, String nodeLabel, String startRelType, String endRelType
			content += GEOTemplates.addNodeLabelToNodeType(labelNames, nodeLabel.name);

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
				editRName.equals('MOVE_REF_COMBI_Property_FROM_Label_(properties)_TO_Label_(properties)')
			].toList
			var List<AddObject> properties = newArrayList
			var content = '''''';

			for (SemanticChangeSet scs : addProperties) {
				
				var AddReference newReference;
				var RemoveReference removeReference;
				
				for(Change change: scs.changes){
					if(change instanceof AddReference)
						newReference = change as AddReference;
					if(change instanceof RemoveReference)
						removeReference = change as RemoveReference;
				}
				
				if(newReference !== null && removeReference !== null){
					
					var NodeLabel oldLabel = removeReference.src as NodeLabel;
					var NodeLabel newLabel = newReference.src as NodeLabel;
					
					var Property property = removeReference.tgt as Property;
					
					content+=GEOTemplates.moveProperty(property.name, oldLabel.name, newLabel.name);
				}
				
			}

			

			return content;
		} else
			return '';
	}

	def static String changeType(GraphResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
			var SemanticChangeSet changeType = operator.semanticChangeSets.findFirst [
				editRName.equals('CHANGE_NumericType') || editRName.equals('CHANGE_StringType') ||
					editRName.equals('CHANGE_PropertyValueType') || editRName.equals('CHANGE_TemporalType') ||
					editRName.equals('CREATE_BinaryTypes') || editRName.equals('CREATE_BooleanType')
			]

			var AddObject addObject = changeType.changes.findFirst[it instanceof AddObject] as AddObject
			var RemoveObject removeObject = changeType.changes.findFirst[it instanceof RemoveObject] as RemoveObject

			var PropertyValueType newtype = addObject.obj as PropertyValueType;
			var PropertyValueType oldtype = removeObject.obj as PropertyValueType;
			var Property property = oldtype.property;
			var labelName = "";
			switch property.containerElement {
				EdgeLabel: {
					var a = property.containerElement as EdgeLabel;
					labelName = "edgelabel " + a.name
				}
				NodeLabel: {
					var a = property.containerElement as NodeLabel;
					labelName = "nodelabel " + a.name
				}
				EdgeType: {
					var a = property.containerElement as Property;
					labelName = "edgetype " + a.name
				}
				NodeType: {
					var a = property.containerElement as NodeType;
					labelName = "nodetype " + a.name
				}
				default: {
					labelName = "No Value"
				}
			}

			var content = '''''';

			content +=
				GEOTemplates.changeType(property.name, GeoTypeMapper.toGeoType(oldtype),
					GeoTypeMapper.toGeoType(newtype), labelName);

			return content;
		} else
			return '';
	}

}
