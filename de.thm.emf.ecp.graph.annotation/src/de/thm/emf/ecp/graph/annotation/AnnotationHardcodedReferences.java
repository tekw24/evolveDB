package de.thm.emf.ecp.graph.annotation;


import de.thm.evolvedb.graph.GraphPackage;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecp.view.spi.custom.model.ECPHardcodedReferences;
import org.eclipse.emf.ecp.view.spi.model.VDomainModelReference;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;

public class AnnotationHardcodedReferences implements ECPHardcodedReferences {

	@Override
	public Set<VDomainModelReference> getNeededDomainModelReferences() {
		final VFeaturePathDomainModelReference dmr =
				VViewFactory.eINSTANCE.createFeaturePathDomainModelReference();

			dmr.setDomainModelEFeature(GraphPackage.eINSTANCE.getProperty_Name());

			return Collections.singleton(dmr);
	}
}
