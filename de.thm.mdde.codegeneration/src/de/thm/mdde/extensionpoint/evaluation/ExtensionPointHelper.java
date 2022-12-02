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
package de.thm.mdde.extensionpoint.evaluation;

import java.util.List;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import de.thm.extensionpoint.interfaces.ISQLGenerator;


public class ExtensionPointHelper {

	public static List<ISQLGenerator> loadRegisteredSQLGenerators() {
		// Find registered generators
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		EvalutaionContributionHandler handler = new EvalutaionContributionHandler();
		List<ISQLGenerator>generator = handler.execute(registry);
		return generator;

	}

}
