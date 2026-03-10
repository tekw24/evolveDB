package de.thm.evolvedb.graph.xtend

import de.thm.evolvedb.migration.GraphResolvableOperator
import de.thm.evolvedb.migration.ProcessStatus
import org.sidiff.difference.symmetric.SemanticChangeSet
import org.sidiff.difference.symmetric.AddObject
import java.util.List
import de.thm.evolvedb.graph.NodeLabel
import de.thm.evolvedb.graph.EdgeLabel
import de.thm.evolvedb.migration.GraphPartiallyResolvableOperator
import org.sidiff.difference.symmetric.RemoveObject
import de.thm.evolvedb.graph.Label
import de.thm.evolvedb.graph.EdgeType
import de.thm.evolvedb.graph.NodeType
import de.thm.evolvedb.graph.Property
import de.thm.evolvedb.graph.KeyConstraint
import de.thm.evolvedb.graph.UniqueConstraint
import de.thm.evolvedb.graph.PropertyExistenceConstraint
import de.thm.evolvedb.graph.PropertyTypeConstraint
import de.thm.evolvedb.graph.Constraint

class GraphDeleteOperator {

	def static String deleteEdgeType(GraphPartiallyResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
			var List<SemanticChangeSet> addProperties = operator.semanticChangeSets.filter [
				editRName.equals('DELETE_EdgeType_IN_PropertyGraph_(items)')
			].toList
			var List<RemoveObject> properties = newArrayList
			var content = '''''';

			for (SemanticChangeSet scs : addProperties) {

				for (RemoveObject ad : scs.changes.filter[it instanceof RemoveObject].map[it as RemoveObject].toList) {

					if (ad.obj instanceof Property) {
						properties.add(ad)
					}

				}
			}

			for (RemoveObject a : properties) {
				var edgeType = a.obj as EdgeType
				
				// String relType, String startNodeLabel, String endNodeLabel
				content+= GEOTemplates.deleteRelationship(edgeType.name, edgeType.src.name, edgeType.tgt.name);
				
			}

			return content;
		} else
			return '';
	}

	def static String deleteLabel(de.thm.evolvedb.migration.GraphPartiallyResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
			var List<SemanticChangeSet> addProperties = operator.semanticChangeSets.filter [
				editRName.equals('DELETE_EdgeLabel_IN_PropertyGraph_(items)') || editRName.equals('DELETE_NodeLabel_IN_PropertyGraph_(items)')
			].toList
			var List<RemoveObject> properties = newArrayList
			var content = '''''';

			for (SemanticChangeSet scs : addProperties) {

				for (RemoveObject ad : scs.changes.filter[it instanceof RemoveObject].map[it as RemoveObject].toList) {

					if (ad.obj instanceof Property) {
						properties.add(ad)
					}

				}
			}

			for (RemoveObject a : properties) {
				var label = a.obj as Label
				// TODO Wie läuft das hier mit Relationships?
				// String relType, String startNodeLabel, String endNodeLabel
				switch label {
					EdgeLabel: {
						//TODO impl
						return 'not implemented: ' + label.toString;
					}
					NodeLabel: {
						//TODO impl
						return 'not implemented: ' + label.toString;
					}
					default: {
						return 'not implemented: ' + label.toString;
					}
				}
				
			}

			return content;
		} else
			return '';
	}

	def static String deleteNodeType(de.thm.evolvedb.migration.GraphPartiallyResolvableOperator operator) {
			if (operator.processStatus === ProcessStatus.RESOLVED) {
			var List<SemanticChangeSet> addProperties = operator.semanticChangeSets.filter [
				editRName.equals('DELETE_NodeType_IN_PropertyGraph_(items)')].toList
			var List<RemoveObject> properties = newArrayList
			var content = '''''';

			for (SemanticChangeSet scs : addProperties) {

				for (RemoveObject ad : scs.changes.filter[it instanceof RemoveObject].map[it as RemoveObject].toList) {

					if (ad.obj instanceof Property) {
						properties.add(ad)
					}

				}
			}

			for (RemoveObject a : properties) {
				var nodeType = a.obj as NodeType
				// TODO Wie läuft das hier mit Relationships?
				// String relType, String startNodeLabel, String endNodeLabel
				content += GEOTemplates.deleteNode(nodeType.name, false)
				
				
			}

			return content;
		} else
			return '';
	}

	def static String deletePropertyLabel(de.thm.evolvedb.migration.GraphPartiallyResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
			var List<SemanticChangeSet> addProperties = operator.semanticChangeSets.filter [
				editRName.equals('DELETE_Property_IN_LABEL_(properties)')
			].toList
			var List<RemoveObject> properties = newArrayList
			var content = '''''';

			for (SemanticChangeSet scs : addProperties) {

				for (RemoveObject ad : scs.changes.filter[it instanceof RemoveObject].map[it as RemoveObject].toList) {

					if (ad.obj instanceof Property) {
						properties.add(ad)
					}

				}
			}

			for (RemoveObject a : properties) {
				var property = a.obj as Property
				// TODO Wie läuft das hier mit Relationships?
				// String propertyName, String nodeLabel, String startRelType, String endRelType
				content += GEOTemplates.deleteNodeProperty(property.name, GEOHelper.getPropertyParent(property));
			}

			return content;
		} else
			return '';
	}

	def static String deletePropertyEdgeType(de.thm.evolvedb.migration.GraphPartiallyResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
			var List<SemanticChangeSet> addProperties = operator.semanticChangeSets.filter [
				editRName.equals('DELETE_Property_IN_LABEL_(properties)')
			].toList
			var List<RemoveObject> properties = newArrayList
			var content = '''''';

			for (SemanticChangeSet scs : addProperties) {

				for (RemoveObject ad : scs.changes.filter[it instanceof RemoveObject].map[it as RemoveObject].toList) {

					if (ad.obj instanceof Property) {
						properties.add(ad)
					}

				}
			}

			for (RemoveObject a : properties) {
				var property = a.obj as Property
				// TODO Wie läuft das hier?
				// String propertyName, String nodeLabel, String startRelType, String endRelType
				content +=
					GEOTemplates.deletePropertyFromNodeOnPath(property.name, GEOHelper.getPropertyParent(property),
						GeoTypeMapper.toGeoType(property.value), '');
			}

			return content;
		} else
			return '';
	}

	def static String deletePropertyNodeType(de.thm.evolvedb.migration.GraphPartiallyResolvableOperator operator) {
		if (operator.processStatus === ProcessStatus.RESOLVED) {
			var List<SemanticChangeSet> addProperties = operator.semanticChangeSets.filter [
				editRName.equals('DELETE_Property_IN_LABEL_(properties)')
			].toList
			var List<RemoveObject> properties = newArrayList
			var content = '''''';

			for (SemanticChangeSet scs : addProperties) {

				for (RemoveObject ad : scs.changes.filter[it instanceof RemoveObject].map[it as RemoveObject].toList) {

					if (ad.obj instanceof Property) {
						properties.add(ad)
					}

				}
			}

			for (RemoveObject a : properties) {
				var property = a.obj as Property
				// TODO Wie läuft das hier mit der Label Kombination?
				// String propertyName, String nodeLabel, String startRelType, String endRelType
				content += GEOTemplates.deleteNodeProperty(property.name, GEOHelper.getPropertyParent(property));
			}

			return content;
		} else
			return '';
	}
	
	def static String deleteConstraintInLabel(GraphPartiallyResolvableOperator operator) {
	
		if (operator.processStatus === ProcessStatus.RESOLVED) {
			var content = '''''';

			for (SemanticChangeSet scs : operator.semanticChangeSets) {

				var List<RemoveObject> removeConstraints = newArrayList

				for (RemoveObject ad : scs.changes.filter[it instanceof RemoveObject].map[it as RemoveObject].toList) {

					if (ad.obj instanceof Constraint) {
						removeConstraints.add(ad)
					}

				}

				for (RemoveObject a : removeConstraints) {
					if (a.obj instanceof KeyConstraint) {
						var constraint = a.obj as KeyConstraint

						content +=
							GEOTemplates.deleteKeyConstraint(constraint.name, constraint.label, constraint.properties);

					} else if (a.obj instanceof UniqueConstraint) {
						var constraint = a.obj as UniqueConstraint
						content +=
							GEOTemplates.deleteUniqueConstraint(constraint.name, constraint.label, constraint.properties);

					} else if (a.obj instanceof PropertyExistenceConstraint) {
						var constraint = a.obj as PropertyExistenceConstraint
						content +=
							GEOTemplates.deletePropertyExistenceConstraint(constraint.name, constraint.label, constraint.properties);

					} else if (a.obj instanceof PropertyTypeConstraint) {
						var constraint = a.obj as PropertyTypeConstraint
						content +=
							GEOTemplates.deletePropertyTypeConstraint(constraint.name, constraint.label, constraint.properties);

					}

				}

			}

			return content;

		}

	}

}
