package de.thm.mdde.datasource.mysql;

import java.util.ArrayList;
import java.util.List;

import de.thm.mdde.connection.model.DBException;
import de.thm.mdde.connection.model.DBPDriverDependencies;
import de.thm.mdde.connection.model.DBPDriverLibrary;
import de.thm.mdde.driver.runtime.model.DBRProgressMonitor;

public class MySQLDriverDependencies implements DBPDriverDependencies{
	
	List<DependencyNode> library;

	public MySQLDriverDependencies(MySQLDriver driver) {
		
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
		// TODO Auto-generated method stub
		
	}

}
