/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/**
 * 
 */
package de.thm.evolvedb.datasource.neo4j.datasource;

import java.util.ArrayList;
import java.util.List;

import de.thm.mdde.connection.model.DBException;
import de.thm.mdde.connection.model.DBPDriverDependencies;
import de.thm.mdde.connection.model.DBPDriverLibrary;
import de.thm.mdde.driver.runtime.model.DBRProgressMonitor;

/**
 * @author Torben
 *
 */
public class Neo4jDriverDependencies implements DBPDriverDependencies{

	List<DependencyNode> library;

	public Neo4jDriverDependencies(Neo4JDriverDB driver) {
		
		library = new ArrayList<>();
		for(DBPDriverLibrary lib : driver.getDriverLibraries()) {
			DependencyNode node = new DependencyNode(null, lib);
			library.add(node);
		}
		
		
	}
	
	@Override
	public List<DependencyNode> getLibraryList() {
		return library;
	}

	@Override
	public List<DependencyNode> getLibraryMap() {
		return library;
	}

	@Override
	public void resolveDependencies(DBRProgressMonitor monitor) throws DBException {
				
	}

}
