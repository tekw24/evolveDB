package de.thm.evolvedb.graph.xtend

import java.util.List

/**
 * Optional: direct Cypher/APOC emission for the same ops.
 * Useful if your toolchain executes the migration immediately on Neo4j.
 */
class CypherTemplates {

	def static String esc(String s) {
		if(s === null) return ""
		s.replace("`", "``")
	}

// ---------- Add / Rename / Delete (nodes)
	def static CharSequence addNodeProperty(String label, String property, String defaultValue) '''
// Add property with default to existing nodes
MATCH (n:`«esc(label)»`)
WHERE n.`«esc(property)»` IS NULL
SET n.`«esc(property)»` = «IF defaultValue !== null»'«defaultValue»'«ELSE»null«ENDIF»;
'''

	def static CharSequence renameNodeProperty(String label, String fromProp, String toProp) '''
// APOC-based rename
CALL apoc.refactor.rename.nodeProperty('«esc(label)»','«esc(fromProp)»','«esc(toProp)»',{iterate:true,batchSize:5000});
'''

	def static CharSequence deleteNodeProperty(String label, String property) '''
MATCH (n:`«esc(label)»`)
REMOVE n.`«esc(property)»`;
'''

// ---------- Relationship helpers
	def static CharSequence addRelationshipProperty(String relType, String property, String defaultValue) '''
MATCH ()-[r:`«esc(relType)»`]-()
WHERE r.`«esc(property)»` IS NULL
SET r.`«esc(property)»` = «IF defaultValue !== null»'«defaultValue»'«ELSE»null«ENDIF»;
'''

	def static CharSequence renameRelationshipType(String fromType, String toType) '''
// APOC refactor type
MATCH ()-[r:`«esc(fromType)»`]-()
CALL apoc.refactor.setType(r,'«esc(toType)»') YIELD input, output RETURN count(output);
'''

	def static CharSequence transformPropertyToNode(String sourceLabel, String property, String newNodeLabel,
		String relType) '''
MATCH (n:`«esc(sourceLabel)»`) WHERE n.`«esc(property)»` IS NOT NULL
MERGE (m:`«esc(newNodeLabel)»` { name: n.`«esc(property)»` })
MERGE (n)-[:`«esc(relType)»`]->(m);
'''

	def static CharSequence mergeNodesByKeys(String label, List<String> keys) '''
// APOC dedup by composite key
CALL apoc.periodic.iterate(
'MATCH (n:`«esc(label)»`) RETURN n',
'WITH n, «FOR k : keys SEPARATOR ", "»n.`«esc(k)»` AS «esc(k)»«ENDFOR»
WITH collect(n) AS nodes
CALL apoc.refactor.mergeNodes(nodes,{properties:"combine", mergeRels:true}) YIELD node RETURN node',
{batchSize:1000, parallel:true}
);
'''
}
