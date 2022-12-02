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
package de.thm.mdde.handler;

import java.util.Set;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.common.emf.modelstorage.SiDiffResourceSet;


public class MddePropertyTester extends PropertyTester {

	private static final String MODEL_FILE = "modelFile";

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(property.equals(MODEL_FILE)){
			if(receiver instanceof IFile) {
				Resource resource = SiDiffResourceSet.create().getResource(EMFStorage.toPlatformURI((IFile)receiver), true);
				Set<String> documentType = EMFModelAccess.getDocumentTypes(resource, Scope.RESOURCE_SET);
				if(documentType.size() == 1 && documentType.contains("http://www.thm.de/mdde"))
					return true;				
			}
		}
		return false;
	}

}
