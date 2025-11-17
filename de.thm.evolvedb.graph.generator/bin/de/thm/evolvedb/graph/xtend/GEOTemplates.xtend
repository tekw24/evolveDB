package de.thm.evolvedb.graph.xtend

import java.util.List
import java.util.Map
import java.util.Set

/**
 * GeoTemplates
 * - Static Xtend template helpers that return textual GEO specifications (as CharSequence)
 * - Each method corresponds to one GEO operator flavor
 * - Parameters supply all needed data; no global state required
 * 
 * Notes
 * - These are *text* templates (Xtend template expressions) for the GEO-DSL.
 */
class GEOTemplates {

	/** Utility: quote a string for inclusion into the GEO text */
	def static String q(String s) {
		if(s === null) return "null"
		'"' + s.replace("\"", "\\\"") + '"'
	}

	/** Utility: join a list with a separator */
	def static String join(Iterable<String> parts, String sep) {
		parts.join(sep)
	}

	// =====================
	// SINGLE-TYPE OPERATORS
	// =====================

	// ---- 1) Add node with label label_name ----

	/** GEO: Add node with label <label_name> */
	def static CharSequence addNodeLabel(String label) {
		'''
		Add node with label «q(label)»
		'''
	}

	// ---- 2) (Add | Delete | Rename) label/property to node with label ... [optional Pfad-Variante] ----

	/**
	 * GEO:
	 * Add label <label_name_to_add> to node with label <node_label>
	 */
	def static CharSequence addLabelToNode(String labelToAdd, String nodeLabel) {
		'''
		Add label «q(labelToAdd)» to node with label «q(nodeLabel)»
		'''
	}

	/**
	 * GEO:
	 * Delete label <label_name_to_delete> of node with label <node_label>
	 */
	def static CharSequence deleteLabelFromNode(String labelToDelete, String nodeLabel) {
		'''
		Delete label «q(labelToDelete)» of node with label «q(nodeLabel)»
		'''
	}

	/**
	 * GEO:
	 * Rename label <old_label> of node with label <node_label>
	 *     to label <new_label>
	 */
	def static CharSequence renameLabelOfNode(String oldLabel, String nodeLabel, String newLabel) {
		'''
		Rename label «q(oldLabel)» of node with label «q(nodeLabel)» to label «q(newLabel)»
		'''
	}

	/**
	 * GEO:
	 * Add property <property_name> to node with label <node_label>
	 */
	def static CharSequence addSimpleNodeProperty(String nodeLabel, String propertyName) {
		'''
		Add property «q(propertyName)» to node with label «q(nodeLabel)»
		'''
	}

	/**
	 * GEO:
	 * Delete property <property_name> of node with label <node_label>
	 */
	def static CharSequence deleteNodeProperty(String nodeLabel, String propertyName) {
		'''
		Delete property «q(propertyName)» of node with label «q(nodeLabel)»
		'''
	}

	/**
	 * GEO:
	 * Rename property <fromProp> of node with label <node_label>
	 *     to property <toProp>
	 */
	def static CharSequence renameSimpleNodeProperty(String nodeLabel, String fromProp, String toProp) {
		'''
		Rename property «q(fromProp)» of node with label «q(nodeLabel)» to property «q(toProp)»
		'''
	}

	/**
	 * Pfad-Variante aus deiner Definition:
	 * (Add | Delete | Rename) (label | property) ... starting at relationship with type ..., ending at relationship with type ...
	 *
	 * Add label:
	 * Add label <labelToAdd> to node with label <nodeLabel>
	 *     starting at relationship with type <startRelType>, ending at relationship with type <endRelType>
	 */
	def static CharSequence addLabelToNodeOnPath(String labelToAdd, String nodeLabel, String startRelType, String endRelType) {
		'''
		Add label «q(labelToAdd)» to node with label «q(nodeLabel)» 
		    starting at relationship with type «q(startRelType)», ending at relationship with type «q(endRelType)»
		'''
	}

	/** Delete label ... on path */
	def static CharSequence deleteLabelFromNodeOnPath(String labelToDelete, String nodeLabel, String startRelType, String endRelType) {
		'''
		Delete label «q(labelToDelete)» of node with label «q(nodeLabel)» 
		    starting at relationship with type «q(startRelType)», ending at relationship with type «q(endRelType)»
		'''
	}

	/** Rename label ... on path */
	def static CharSequence renameLabelOfNodeOnPath(String oldLabel, String newLabel, String nodeLabel, String startRelType, String endRelType) {
		'''
		Rename label «q(oldLabel)» of node with label «q(nodeLabel)» to label «q(newLabel)» 
		    starting at relationship with type «q(startRelType)», ending at relationship with type «q(endRelType)»
		'''
	}

	/** Add property ... on path */
	def static CharSequence addPropertyToNodeOnPath(String propertyName, String nodeLabel, String startRelType, String endRelType) {
		'''
		Add property «q(propertyName)» to node with label «q(nodeLabel)» 
		    starting at relationship with type «q(startRelType)», ending at relationship with type «q(endRelType)»
		'''
	}

	/** Delete property ... on path */
	def static CharSequence deletePropertyFromNodeOnPath(String propertyName, String nodeLabel, String startRelType, String endRelType) {
		'''
		Delete property «q(propertyName)» of node with label «q(nodeLabel)» 
		    starting at relationship with type «q(startRelType)», ending at relationship with type «q(endRelType)»
		'''
	}

	/** Rename property ... on path */
	def static CharSequence renamePropertyOfNodeOnPath(String fromProp, String toProp, String nodeLabel, String startRelType, String endRelType) {
		'''
		Rename property «q(fromProp)» of node with label «q(nodeLabel)» to property «q(toProp)» 
		    starting at relationship with type «q(startRelType)», ending at relationship with type «q(endRelType)»
		'''
	}

	// ---- 3) Rename label / type ----

	/**
	 * GEO:
	 * Rename label <old_label> of node with label <old_label> to label <new_label>
	 */
	def static CharSequence renameNodeLabel(String oldLabel, String newLabel) {
		'''
		Rename label «q(oldLabel)» of node with label «q(oldLabel)» to label «q(newLabel)»
		'''
	}

	/**
	 * GEO:
	 * Rename type <old_type> of relationship with type <old_type> to type <new_type>
	 */
	def static CharSequence renameRelationshipType(String oldType, String newType) {
		'''
		Rename type «q(oldType)» of relationship with type «q(oldType)» to type «q(newType)»
		'''
	}

	// ---- 4) Delete node with label ... (with | without) connecting relationships ----

	/**
	 * GEO:
	 * Delete node with label <label_name> with/without connecting relationships
	 */
	def static CharSequence deleteNode(String label, boolean withConnectingRelationships) {
		'''
		Delete node with label «q(label)» «IF withConnectingRelationships»with«ELSE»without«ENDIF» connecting relationships
		'''
	}

	// ---- 5) Relationship-Typ + Properties ----

	/**
	 * Einfache Variante:
	 * Add relationship with type <type_name>
	 */
	def static CharSequence addRelationshipType(String relType) {
		'''
		Add relationship with type «q(relType)»
		'''
	}

	/**
	 * Vollständiger laut Definition:
	 * Add relationship with type <type_name> starting at node with label <startLabel>, ending at node with label <endLabel>
	 */
	def static CharSequence addRelationship(String relType, String startNodeLabel, String endNodeLabel) {
		'''
		Add relationship with type «q(relType)» starting at node with label «q(startNodeLabel)», ending at node with label «q(endNodeLabel)»
		'''
	}

	/**
	 * GEO:
	 * Delete relationship with type <type_name> starting at node with label <startLabel>, ending at node with label <endLabel>
	 */
	def static CharSequence deleteRelationship(String relType, String startNodeLabel, String endNodeLabel) {
		'''
		Delete relationship with type «q(relType)» starting at node with label «q(startNodeLabel)», ending at node with label «q(endNodeLabel)»
		'''
	}

	/**
	 * GEO:
	 * Rename relationship with type <old_type> starting at node with label <startLabel>, ending at node with label <endLabel>
	 *     to relationship with type <new_type>
	 */
	def static CharSequence renameRelationshipBetween(String oldType, String newType, String startNodeLabel, String endNodeLabel) {
		'''
		Rename relationship with type «q(oldType)» starting at node with label «q(startNodeLabel)», ending at node with label «q(endNodeLabel)» 
		    to relationship with type «q(newType)»
		'''
	}

	// ---- Properties auf Beziehungen ----

	/**
	 * GEO:
	 * Add property <property> of type <type> with default <default> to relationship with type <relType>
	 */
	def static CharSequence addRelationshipProperty(String relType, String property, String type, String defaultValue) {
		'''
		Add property «q(property)» of type «q(type)» with default «q(defaultValue)» to relationship with type «q(relType)»
		'''
	}

	/**
	 * GEO:
	 * Delete property <property> of relationship with type <relType>
	 */
	def static CharSequence deleteRelationshipProperty(String relType, String property) {
		'''
		Delete property «q(property)» of relationship with type «q(relType)»
		'''
	}

	/**
	 * GEO:
	 * Rename property <fromProp> of relationship with type <relType> to property <toProp>
	 */
	def static CharSequence renameRelationshipProperty(String relType, String fromProp, String toProp) {
		'''
		Rename property «q(fromProp)» of relationship with type «q(relType)» to property «q(toProp)»
		'''
	}

	// =====================
	// MULTI-TYPE OPERATIONS
	// =====================

	// ---- Copy (label | property) of (node | relationship) to (node | relationship) ----

	/**
	 * GEO:
	 * Copy label <featureName> of node with label <fromId> to node with label <toId>
	 * Copy property <featureName> of relationship with type <fromId> to node with label <toId>
	 *
	 * Parameter:
	 *  featureKind : "label" or "property"
	 *  fromKind    : "node" or "relationship"
	 *  toKind      : "node" or "relationship"
	 *  fromId      : Labelname (bei node) oder Typname (bei relationship)
	 *  toId        : Labelname (bei node) oder Typname (bei relationship)
	 */
	def static CharSequence copyFeature(String featureKind, String featureName,
		String fromKind, String fromId,
		String toKind, String toId) {

		'''
		Copy «featureKind» «q(featureName)» of «fromKind» with «IF fromKind == "node"»label«ELSE»type«ENDIF» «q(fromId)» 
		    to «toKind» with «IF toKind == "node"»label«ELSE»type«ENDIF» «q(toId)»
		'''
	}

	// ---- Move (label | property) ... ----

	/**
	 * GEO:
	 * Move <featureKind> <featureName> of <fromKind> with label/type <fromId>
	 *     to <toKind> with label/type <toId>
	 */
	def static CharSequence moveFeature(String featureKind, String featureName,
		String fromKind, String fromId,
		String toKind, String toId) {

		'''
		Move «featureKind» «q(featureName)» of «fromKind» with «IF fromKind == "node"»label«ELSE»type«ENDIF» «q(fromId)» 
		    to «toKind» with «IF toKind == "node"»label«ELSE»type«ENDIF» «q(toId)»
		'''
	}

	// ---- Split (node | relationship) at property ... (keep/delete relations) ----

	/**
	 * relationHandling:
	 *  - "keep"
	 *  - "delete"
	 *  - "keepOfPartA"
	 *  - "keepOfPartB"
	 *
	 * GEO (Beispiele):
	 * Split node with label "Person" at property "status" keep relations
	 * Split relationship with type "KNOWS" at property "since" delete relations
	 * Split node with label "Person" at property "status" keep relations "of" partA
	 */
	def static CharSequence splitElement(String kind, String id, String propertyName,
		String relationHandling, String partALabel, String partBLabel) {

		'''
		Split «kind» with «IF kind == "node"»label«ELSE»type«ENDIF» «q(id)» 
		    at property «q(propertyName)» «IF relationHandling == "keep"»keep relations«ELSEIF relationHandling == "delete"»delete relations«ELSEIF relationHandling == "keepOfPartA"»keep relations "of" «q(partALabel)»«ELSEIF relationHandling == "keepOfPartB"»keep relations "of" «q(partBLabel)»«ENDIF»
		    into «kind» with label/type «q(partALabel)» and «q(partBLabel)»
		'''
	}

	// ---- Transform (node -> relationship | relationship -> node) ----

	/**
	 * GEO:
	 * Transform node with label <label> to relationship with type <relType>
	 */
	def static CharSequence transformNodeToRelationship(String nodeLabel, String relType) {
		'''
		Transform node with label «q(nodeLabel)» to relationship with type «q(relType)»
		'''
	}

	/**
	 * GEO:
	 * Transform relationship with type <relType> to node with label <label>
	 */
	def static CharSequence transformRelationshipToNode(String relType, String nodeLabel) {
		'''
		Transform relationship with type «q(relType)» to node with label «q(nodeLabel)»
		'''
	}

	// ---- Merge (duplicate | different) properties ... ----

	/**
	 * propertyKind : "duplicate" or "different"
	 * elementKind  : "node" or "relationship"
	 * deleteStrategy : "cascadeDelete" or "restrictedDelete"
	 * joinType       : "inner" or "full outer exclusive"
	 *
	 * GEO:
	 * Merge <propertyKind> properties of <elementKind> with label/type <id>,
	 *     (add label <extraLabels>)* and <deleteStrategy> originals -> <joinType> join
	 */
	def static CharSequence mergeProperties(String propertyKind, String elementKind, String id,
		List<String> extraLabels, String deleteStrategy, String joinType) {

		'''
		Merge «propertyKind» properties of «elementKind» with «IF elementKind == "node"»label«ELSE»type«ENDIF» «q(id)»«IF extraLabels !== null && !extraLabels.empty»
		    , add label(s) [«FOR l : extraLabels SEPARATOR ', '»«q(l)»«ENDFOR»]«ENDIF» 
		    and «deleteStrategy» originals -> «joinType» join
		'''
	}

	// ---- Keep all features of (left | right) ... -> left/right join ----

	/**
	 * keepSide    : "left" or "right"
	 * elementKind : "node" or "relationship"
	 *
	 * GEO:
	 * Keep all features of <keepSide> <elementKind> with label/type <leftId/rightId>
	 *     add duplicates from <otherSide> <elementKind> with label/type <...> -> left/right join
	 */
	def static CharSequence keepAllFeaturesJoin(String keepSide, String elementKind,
		String leftId, String rightId) {

		'''
		Keep all features of «keepSide» «elementKind» with «IF elementKind == "node"»label«ELSE»type«ENDIF» «IF keepSide == "left"»«q(leftId)»«ELSE»«q(rightId)»«ENDIF» 
		    add duplicates from «IF keepSide == "left"»right«ELSE»left«ENDIF» «elementKind» with «IF elementKind == "node"»label«ELSE»type«ENDIF» «IF keepSide == "left"»«q(rightId)»«ELSE»«q(leftId)»«ENDIF» 
		    -> «IF keepSide == "left"»left«ELSE»right«ENDIF» join
		'''
	}

	// ---- copy properties ... and (cascadeDelete | restrictedDelete) originals -> full outer inclusive ----

	/**
	 * deleteStrategy : "cascadeDelete" or "restrictedDelete"
	 *
	 * GEO:
	 * copy properties of <fromKind> with label/type <fromId> to <toKind> with label/type <toId>
	 *     and <deleteStrategy> originals -> full outer inclusive
	 */
	def static CharSequence copyPropertiesAndDeleteOriginals(String fromKind, String fromId,
		String toKind, String toId, String deleteStrategy) {

		'''
		copy properties of «fromKind» with «IF fromKind == "node"»label«ELSE»type«ENDIF» «q(fromId)» 
		    to «toKind» with «IF toKind == "node"»label«ELSE»type«ENDIF» «q(toId)» 
		    and «deleteStrategy» originals -> full outer inclusive
		'''
	}

	// ====================================
	// BEREITS VORHANDENE SPEZIAL-OPERATIONEN
	// ====================================

	/**
	 * Spezielle Merge-Variante aus deiner ursprünglichen Klasse.
	 * Passt nicht 1:1 in die neue Kurzsyntax, bleibt aber als Komfort-Template bestehen.
	 */
	def static CharSequence mergeNodes(String label, List<String> keyProperties, String conflictStrategy) {
		'''
		Merge duplicate properties of node with label «q(label)» 
		    using keys [«FOR k : keyProperties SEPARATOR ', '»«q(k)»«ENDFOR»] 
		    and conflict strategy «q(conflictStrategy)»
		'''
	}

	/**
	 * Eigenständige Copy-Subgraph-Operation (nicht explizit in der Liste, aber hilfreich).
	 */
	def static CharSequence copySubgraph(String rootLabel, int depth, Set<String> includeRelTypes) {
		'''
		Copy subgraph of nodes with label «q(rootLabel)» up to depth «depth»«IF includeRelTypes !== null && !includeRelTypes.empty»
		    including relationships with types [«FOR t : includeRelTypes SEPARATOR ', '»«q(t)»«ENDFOR»]«ENDIF»
		'''
	}

	/**
	 * Split node – ursprüngliche Variante mit Prädikat und zwei Labels.
	 */
	def static CharSequence splitNode(String label, String predicateExpr, String newLabelTrue, String newLabelFalse) {
		'''
		Split node with label «q(label)» using predicate «q(predicateExpr)» 
		    into node with label «q(newLabelTrue)» and node with label «q(newLabelFalse)»
		'''
	}

	/**
	 * Move subgraph – ursprüngliche Variante mit Pfad.
	 */
	def static CharSequence moveSubgraph(String startLabel, String pathPattern, String newRootLabel) {
		'''
		Move subgraph starting at node with label «q(startLabel)» along path «q(pathPattern)» 
		    to node with label «q(newRootLabel)»
		'''
	}
}