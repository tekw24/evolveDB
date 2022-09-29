package generatortest;


import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;

import de.thm.extensionpoint.interfaces.ISQLGenerator;




public class SQLTestGenerator implements ISQLGenerator {

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return "TestGenerator";
	}

	@Override
	public void generate(Resource resEcoreFile, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}




}
