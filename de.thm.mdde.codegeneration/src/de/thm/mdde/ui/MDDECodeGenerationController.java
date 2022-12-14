/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.thm.mdde.ui;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.ecore.resource.Resource;

import de.thm.extensionpoint.interfaces.ISQLGenerator;
import de.thm.jobs.GeneratorJob;
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
