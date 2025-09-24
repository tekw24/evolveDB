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
 * - These are *text* templates (Xtend template expressions) that you can feed into your own GEO parser/executor.
 * - If you prefer emitting Cypher/APOC directly, see the CypherTemplates class below.
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
// SIMPLE-TYPE OPERATORS
// =====================
	/** Add a node label (entity type) */
	def static CharSequence addNodeLabel(String label) {
		'''
			GEO AddLabel {
				target: Node
				label: «q(label)»
			}
		'''

	}

	/** Add a relationship type (edge type) */
	def static CharSequence addRelationshipType(String relType) {
		'''
			GEO AddRelationshipType {
			type: «q(relType)»
			}
		'''
	}

	/** Add a property to all nodes of a label */
	def static CharSequence addNodeProperty(String label, String property, String type, String defaultValue) {
		'''
			GEO AddProperty {
			target: Node(label=«q(label)»)
			property { name: «q(property)», dtype: «q(type)», default: «q(defaultValue)» }
			}
		'''

	}

	/** Add a property to all relationships of a type */
	def static CharSequence addRelationshipProperty(String relType, String property, String type, String defaultValue) {
		'''
			GEO AddProperty {
			target: Relationship(type=«q(relType)»)
			property { name: «q(property)», dtype: «q(type)», default: «q(defaultValue)» }
			}
		'''
	}

	/** Rename a node label */
	def static CharSequence renameNodeLabel(String oldLabel, String newLabel) {
		'''
			GEO RenameLabel {
			target: Node
			from: «q(oldLabel)»
			to: «q(newLabel)»
			}
		'''

	}

	/** Rename a relationship type */
	def static CharSequence renameRelationshipType(String oldType, String newType) {
		'''
			GEO RenameRelationshipType {
			from: «q(oldType)»
			to: «q(newType)»
			}
		'''
	}

	/** Rename a property on nodes of a given label */
	def static CharSequence renameNodeProperty(String label, String fromProp, String toProp) {
		'''
			GEO RenameProperty {
			target: Node(label=«q(label)»)
			from: «q(fromProp)»
			to: «q(toProp)»
			}
		'''
	}

	/** Rename a property on relationships of a given type */
	def static CharSequence mergeNodes(String label, List<String> keyProperties, String conflictStrategy) {

		'''
			GEO MergeNodes {
			label: «q(label)»
			keys: [ «FOR k : keyProperties SEPARATOR ', '»«q(k)»«ENDFOR» ]
			conflict: «q(conflictStrategy)»
			}
			
		'''

	}

	/** Copy a subgraph outward from nodes with a label up to a depth, optionally filter relationship types. */
	def static CharSequence copySubgraph(String rootLabel, int depth, Set<String> includeRelTypes) {
		'''
			GEO CopySubgraph {
			roots: Node(label=«q(rootLabel)»)
			depth: «depth»
			«IF includeRelTypes !== null && !includeRelTypes.empty»
				includeRels: [ «FOR t : includeRelTypes SEPARATOR ', '»«q(t)»«ENDFOR» ]
			«ENDIF»
			}
		'''

	}

	/** Split a node set by a predicate into two labels; predicate is a DSL/Cypher-like expression you decide. */
	def static CharSequence splitNode(String label, String predicateExpr, String newLabelTrue, String newLabelFalse) {
		'''
			GEO SplitNode {
			source: Node(label=«q(label)»)
			when: «q(predicateExpr)»
			then: Node(label=«q(newLabelTrue)»)
			else: Node(label=«q(newLabelFalse)»)
			}
		'''

	}

	/** Move a subgraph selected by a path pattern under a new root/label (logical relocation) */
	def static CharSequence moveSubgraph(String startLabel, String pathPattern, String newRootLabel) {
		'''
			GEO MoveSubgraph {
			start: Node(label=«q(startLabel)»)
			path: «q(pathPattern)»
			targetRoot: Node(label=«q(newRootLabel)»)
			}
		'''
	}
}
