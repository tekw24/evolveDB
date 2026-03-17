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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.thm.evolvedb.graph.annotation.AnnotationAdapter;
import de.thm.evolvedb.graph.annotation.AnnotationEntry;

public class AnnotationCustomControl extends ECPAbstractCustomControlSWT {

	private Composite root;
	private Composite lastParent;

	@Override
	public SWTGridDescription getGridDescription() {
		return createSimpleGrid(1, 1);
	}

	@Override
	public Control renderControl(SWTGridCell cell, Composite parent) {
		
		System.out.println(
				"renderControl this=" + System.identityHashCode(this) + " parent=" + System.identityHashCode(parent)
						+ " domain=" + System.identityHashCode(getViewModelContext().getDomainModel()));

		// Schon für denselben Parent aufgebaut -> nicht noch einmal erzeugen
		if (root != null && !root.isDisposed() && parent == lastParent) {
			return root;
		}

		// Falls EMF Forms doch mit anderem Parent neu rendert
		if (root != null && !root.isDisposed()) {
			root.dispose();
		}

		lastParent = parent;
		root = new Composite(parent, SWT.NONE);
		root.setLayout(new GridLayout(2, false));
		root.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,3,1));

		final EObject domainObject = getViewModelContext().getDomainModel();
		final AnnotationAdapter adapter = (AnnotationAdapter) EcoreUtil.getAdapter(domainObject.eAdapters(),
				AnnotationAdapter.class);

		if (adapter == null || adapter.getAnnotations() == null || adapter.getAnnotations().isEmpty()) {
			final Label none = new Label(root, SWT.NONE);
			none.setText("No annotations");
			none.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			return root;
		}

		final Label header = new Label(root, SWT.NONE);
		header.setText("Heterogeneous structures");
		header.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Table table = new Table(root, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));

		final TableColumn keyColumn = new TableColumn(table, SWT.NONE);
		keyColumn.setText("Key");

		final TableColumn valueColumn = new TableColumn(table, SWT.NONE);
		valueColumn.setText("Value");

		final TableColumn sourceColumn = new TableColumn(table, SWT.NONE);
		sourceColumn.setText("Count");

		for (AnnotationEntry entry : adapter.getAnnotations()) {
			final TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] {
				entry.getKey() == null ? "" : entry.getKey(),
				entry.getValue() == null ? "" : entry.getValue(),
				entry.getSource() == null ? "" : entry.getSource()
			});
		}

		keyColumn.pack();
		valueColumn.pack();
		sourceColumn.pack();

		keyColumn.setWidth(Math.max(keyColumn.getWidth(), 120));
		valueColumn.setWidth(Math.max(valueColumn.getWidth(), 220));
		sourceColumn.setWidth(Math.max(sourceColumn.getWidth(), 140));

		return root;

	}

	@Override
	protected void disposeCustomControl() {
		System.out.println("disposeCustomControl this=" + System.identityHashCode(this));
		if (root != null && !root.isDisposed()) {
			root.dispose();
		}
		root = null;
		lastParent = null;
	}

	@Override
	protected void handleContentValidation() {
		// erstmal leer
	}

}
