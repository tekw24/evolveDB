package de.thm.mdde.datasource;

import de.thm.mdde.connection.model.DBPDriver;
import de.thm.mdde.connection.model.DBPDriverDependencies;

import org.eclipse.swt.graphics.Image;

public interface EDBDataSource {
	
	/**
	 * Datasource name
	 * @return the name of the datasource
	 */
	String getName();
	
	
	/**
	 * Connection icon
	 * @return Database Icon
	 */
	Image getImage();
	
	
	/**
	 * DBPDriver class
	 * @return Driver class
	 */
	DBPDriver getDriver();
	
	
	
	/**
	 * DBPDriverDependencies 
	 * @return the corresponding driver dependencies
	 */
	DBPDriverDependencies getDriverDependencies();
	
	
	
	
	

}
