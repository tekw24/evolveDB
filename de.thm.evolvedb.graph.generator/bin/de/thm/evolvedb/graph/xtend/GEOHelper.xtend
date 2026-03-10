package de.thm.evolvedb.graph.xtend

import de.thm.evolvedb.graph.NodeLabel
import de.thm.evolvedb.graph.Property
import de.thm.evolvedb.graph.EdgeLabel
import de.thm.evolvedb.graph.NodeType
import de.thm.evolvedb.graph.EdgeType

class GEOHelper {
	
	/** 
	 * Returns the parent name for the given property 
	 */
	def static String getPropertyParent(Property property){
		var parent = property.eContainer
		
		switch parent {
			EdgeLabel: {
				return (parent as EdgeLabel).name;
			}
			NodeLabel: {
				return (parent as NodeLabel).name;
			}
			NodeType: {
				return (parent as NodeType).name;
			}
			EdgeType: {
				return (parent as EdgeType).name;
			}
			default: {
				return 'Parent invalid'
			}
		}
		
		
		
	}
	
}