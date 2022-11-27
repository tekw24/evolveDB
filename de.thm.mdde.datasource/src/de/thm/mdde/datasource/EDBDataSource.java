package de.thm.mdde.datasource;

import de.thm.mdde.connection.model.DBPDriver;
import de.thm.mdde.connection.model.DBPDriverDependencies;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.INewWizard;

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
	
	
	/**
	 * The UI for entering the connection details.
	 * @return
	 */
	void openConnectionUi();
	
	
	/**
	 * Returns the root element of the newly created model;
	 * @return
	 */
	EObject getRootObject();
	
	

}
