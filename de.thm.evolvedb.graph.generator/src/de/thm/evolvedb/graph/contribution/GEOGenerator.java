package de.thm.evolvedb.graph.contribution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;

import de.thm.evolvedb.graph.xtend.GraphGEOGenerator;
import de.thm.extensionpoint.interfaces.ISQLGenerator;


public class GEOGenerator implements ISQLGenerator{
	
	private String content;

	@Override
	public String getDisplayName() {
		return "GEO generator";
	}

	@Override
	public void generate(Resource resEcoreFile, IProgressMonitor monitor) {
		GraphGEOGenerator graphGEOGenerator = new GraphGEOGenerator();
		content = graphGEOGenerator.doGenerate(resEcoreFile, monitor); 
		
	}

	@Override
	public String getContent() {
		return content;
	}

}
