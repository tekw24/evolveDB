package de.thm.extensionpoint.interfaces;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;

public interface ISQLGenerator {
	
	/**
	 * Returns the display name of the extension.
	 * @return
	 */
	String getDisplayName();


	/**
	 * Generate the migrations. 
	 * @param resEcoreFile --> The matching model.
	 * @param project --> The currently selected project.
	 * @param generator --> The generator chosen by the user.
	 * @param monitor 
	 */
	void generate(Resource resEcoreFile, IProgressMonitor monitor);
	
	
	
	String getContent();

}
