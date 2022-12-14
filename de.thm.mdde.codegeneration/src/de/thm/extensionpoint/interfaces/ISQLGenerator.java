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
package de.thm.extensionpoint.interfaces;

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
	 * @param monitor --> ProgressMonitor
	 */
	void generate(Resource resEcoreFile, IProgressMonitor monitor);
	
	
	
	/**
	 * Returns the content for the migration script.
	 * @return
	 */
	String getContent();

}
