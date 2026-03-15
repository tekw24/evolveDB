package de.thm.emf.ecp.graph.annotation;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.view.spi.custom.model.ECPHardcodedReferences;
import org.eclipse.emf.ecp.view.spi.custom.swt.ECPAbstractCustomControlSWT;
import org.eclipse.emf.ecp.view.spi.model.VDomainModelReference;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridDescription;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import de.thm.evolvedb.graph.annotation.AnnotationAdapter;
import de.thm.evolvedb.graph.annotation.AnnotationEntry;

public class AnnotationCustomControl extends ECPAbstractCustomControlSWT implements ECPHardcodedReferences {

	@Override
	public SWTGridDescription getGridDescription() {
		return createSimpleGrid(1, 2);
	}

	@Override
	public Control renderControl(SWTGridCell cell, Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		final EObject domainObject = getViewModelContext().getDomainModel();

		final AnnotationAdapter adapter = (AnnotationAdapter) EcoreUtil.getAdapter(domainObject.eAdapters(),
				AnnotationAdapter.class);

		if (adapter == null || adapter.getAnnotations() == null || adapter.getAnnotations().isEmpty()) {
			Label none = new Label(composite, SWT.NONE);
			none.setText("No annotations");
			none.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			return composite;
		}

		for (AnnotationEntry entry : adapter.getAnnotations()) {
			Label keyLabel = new Label(composite, SWT.NONE);
			keyLabel.setText(entry.getKey() + ":");

			Label valueLabel = new Label(composite, SWT.WRAP);
			valueLabel.setText(entry.getValue() == null ? "" : entry.getValue());
			valueLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		}

		return composite;
	}

	@Override
	protected void handleContentValidation() {
		// erstmal leer
	}

	@Override
	protected void disposeCustomControl() {
		// erstmal leer
	}

	@Override
	public Set<VDomainModelReference> getNeededDomainModelReferences() {
		Set<VDomainModelReference> refs = new LinkedHashSet<>();

		// Dummy-Referenz, damit EMF Forms etwas zum Auflösen hat
		refs.add(VViewFactory.eINSTANCE.createFeaturePathDomainModelReference());

		return refs;
	}
}
