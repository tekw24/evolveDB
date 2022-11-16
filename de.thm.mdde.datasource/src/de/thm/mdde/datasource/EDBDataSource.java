package de.thm.mdde.datasource;

import org.eclipse.swt.graphics.Image;

public interface EDBDataSource {
	
	/**
	 * Name of the datasource
	 */
	String getName();
	
	
	/**
	 * Connection icon
	 * @return Database Icon
	 */
	Image getImage();
	
	
	

}
