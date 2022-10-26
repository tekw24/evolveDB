package de.thm.contribution;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;

import de.thm.extensionpoint.interfaces.ISQLGenerator;
import de.thm.xtend.SQLGenerator;


public class NativeSQLGenerator implements ISQLGenerator {

	private String content;

	@Override
	public String getDisplayName() {
		return "MySQL script generator";
	}

	@Override
	public void generate(Resource resEcoreFile, IProgressMonitor monitor) {
		SQLGenerator sqlGenerator = new SQLGenerator();
		content = sqlGenerator.doGenerate(resEcoreFile, monitor);
		
	}

	@Override
	public String getContent() {
		return content;
	}

}
