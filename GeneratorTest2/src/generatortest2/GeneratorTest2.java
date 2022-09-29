package generatortest2;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;

import de.thm.extensionpoint.interfaces.ISQLGenerator;

public class GeneratorTest2 implements ISQLGenerator {

	public GeneratorTest2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return "Test2";
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
