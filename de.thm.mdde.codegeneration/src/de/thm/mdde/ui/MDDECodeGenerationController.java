package de.thm.mdde.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.emf.ecore.resource.Resource;

import de.thm.extensionpoint.interfaces.ISQLGenerator;
import de.thm.jobs.GeneratorJob;
import de.thm.mdde.exception.GenerationCanceledException;
import de.thm.mdde.extensionpoint.evaluation.ExtensionPointHelper;

public class MDDECodeGenerationController {

	private List<ISQLGenerator> generators;
	private ISQLGenerator generator;
	private Resource resModelFile;

	public MDDECodeGenerationController(Resource resModelFile) {
		this.resModelFile = resModelFile;
	}

	protected void generateMigrations(IFile ifile, IFolder folder) {

		if (generator != null) {
			// start generation
			System.out.println("Generating migration code now.");
			GeneratorJob job = new GeneratorJob("Generating migrations", resModelFile, generator, ifile, folder);
			job.setUser(true);
			job.schedule();

		}

	}

	protected String[] loadGenerators() {

		generators = ExtensionPointHelper.loadRegisteredSQLGenerators();

		List<String> displayNames = generators.stream().map(e -> e.getDisplayName()).collect(Collectors.toList());

		// Convert the list into an array
		String[] array = new String[displayNames.size()];
		displayNames.toArray(array);
		return array;
	}

	public List<ISQLGenerator> getGenerators() {
		return generators;
	}

	public void setGenerators(List<ISQLGenerator> generators) {
		this.generators = generators;
	}

	public ISQLGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(ISQLGenerator generator) {
		this.generator = generator;
	}
	
	/**
	 * Method is called from the first Page, if the user choose a generator.
	 * If the value is present in the generators list, the method returns true and otherwise false.
	 * @param name
	 * @return
	 */
	protected boolean setGenerator(String name) {
		Optional<ISQLGenerator> o = generators.stream().filter(p -> p.getDisplayName().equals(name)).findFirst();
		if(o.isPresent()) {
			generator = o.get();
			return true;
		}
		return false;
	}

	protected void setResModelFile(Resource resModelFile) {
		this.resModelFile = resModelFile;
	}
	
	

}
