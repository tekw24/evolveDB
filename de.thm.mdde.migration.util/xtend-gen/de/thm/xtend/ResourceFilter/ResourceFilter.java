/**
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
package de.thm.xtend.ResourceFilter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.sidiff.difference.symmetric.SymmetricDifference;

@SuppressWarnings("all")
public class ResourceFilter {
  public String filterForSymmetricDifference(final Resource resModelFile) {
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf((it instanceof SymmetricDifference));
    };
    EObject _findFirst = IteratorExtensions.<EObject>findFirst(resModelFile.getAllContents(), _function);
    SymmetricDifference difference = ((SymmetricDifference) _findFirst);
    String modelA = difference.getUriModelA();
    String modelB = difference.getUriModelB();
    return modelB;
  }
}
