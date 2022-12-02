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
package de.thm.contribution;

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
