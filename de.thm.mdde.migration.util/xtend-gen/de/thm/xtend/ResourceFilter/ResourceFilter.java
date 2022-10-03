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
