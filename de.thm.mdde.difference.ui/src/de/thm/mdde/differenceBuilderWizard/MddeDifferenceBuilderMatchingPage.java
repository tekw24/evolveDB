package de.thm.mdde.differenceBuilderWizard;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.Database_Schema;
import de.thm.evolvedb.mdde.Table;
import de.thm.mdde.commonui.widgets.ModelDirectionWidget;

public class MddeDifferenceBuilderMatchingPage extends WizardPage {

	private MddeDifferenceBuilderController controller;
	private org.eclipse.swt.widgets.Table table;
	private org.eclipse.swt.widgets.Table tableColumns;

	private Button delCorrespondence;
	private Button addCorrespondence;

	private Button delCorrespondenceColumns;
	private Button addCorrespondenceColumns;

	private Matching matching;

	protected MddeDifferenceBuilderMatchingPage(String pageName, MddeDifferenceBuilderController controller) {
		super(pageName);
		this.controller = controller;
	}

	@Override
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}

		// Header Label
		Label headerTable = new Label(composite, SWT.NONE);
		headerTable.setText("Table correspondences");

		// Table
		table = new org.eclipse.swt.widgets.Table(composite, SWT.BORDER | SWT.SINGLE);
		table.setToolTipText("Eine Tabelle");
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 2, 1));
		table.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				TableItem[] items = table.getSelection();
				if (items.length == 1) {
					delCorrespondence.setEnabled(true);
				} else
					delCorrespondence.setEnabled(false);

			}

		});

		TableColumn tc = new TableColumn(table, SWT.BORDER);
		tc.setText("Object ResourceA");
		tc.pack();
		tc.setMoveable(true);

		TableColumn tc2 = new TableColumn(table, SWT.BORDER);
		tc2.setText("Object ResourceB");
		tc2.pack();
		tc2.setMoveable(true);

		table.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent arg0) {
				resizeColumns(table);
			}

			@Override
			public void controlMoved(ControlEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// Buttons
		Composite buttonBar = new Composite(composite, SWT.NONE);
		RowLayout layout = new RowLayout();

		// Optionally set layout fields.
		layout.wrap = false;
		buttonBar.setLayout(layout);
		buttonBar.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 2, 1));

		addCorrespondence = createAddCorrespondenceButton(buttonBar, Table.class);
		addCorrespondence.setText("Add Correspondence");
		addCorrespondence.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				

				List<EObject> matchingA = matching.getUnmatchedA().stream().filter(e1 -> e1 instanceof Table )
						.collect(Collectors.toList());
				List<EObject> matchingB = matching.getUnmatchedB().stream().filter(e1 -> e1 instanceof Table)
						.collect(Collectors.toList());

				CorrespondenceDialog dialog = new CorrespondenceDialog(Display.getCurrent().getActiveShell(), matchingA,
						matchingB);
				dialog.create();
				if (dialog.open() == Window.OK) {
					EObject eObjectA = dialog.geteObjectA();
					EObject eObjectB = dialog.geteObjectB();

					if (eObjectA != null && eObjectB != null)
						controller.addCorrespondence(eObjectA, eObjectB);

					fillCorrespondence();
				}

			}
		});
		delCorrespondence = createdelCorrespondenceButton(buttonBar, table);

		// Header Label
		Label headerColumn = new Label(composite, SWT.NONE);
		headerColumn.setText("Column correspondences");

		// Table
		tableColumns = new org.eclipse.swt.widgets.Table(composite, SWT.BORDER | SWT.SINGLE);
		tableColumns.setToolTipText("Eine Tabelle");
		tableColumns.setLinesVisible(true);
		tableColumns.setHeaderVisible(true);
		tableColumns.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 2, 1));
		tableColumns.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				TableItem[] items = tableColumns.getSelection();
				if (items.length == 1) {
					delCorrespondenceColumns.setEnabled(true);
				} else
					delCorrespondenceColumns.setEnabled(false);

			}

		});

		TableColumn tc3 = new TableColumn(tableColumns, SWT.BORDER);
		tc3.setText("Object ResourceA");
		tc3.pack();
		tc3.setMoveable(true);

		TableColumn tc4 = new TableColumn(tableColumns, SWT.BORDER);
		tc4.setText("Object ResourceB");
		tc4.pack();
		tc4.setMoveable(true);

		tableColumns.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent arg0) {
				resizeColumns(tableColumns);
			}

			@Override
			public void controlMoved(ControlEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		

		// Buttons
		Composite buttonBar2 = new Composite(composite, SWT.NONE);
		RowLayout layout2 = new RowLayout();

		// Optionally set layout fields.
		layout2.wrap = false;
		buttonBar2.setLayout(layout2);
		buttonBar2.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 2, 1));

		addCorrespondenceColumns = createAddCorrespondenceButton(buttonBar2, Column.class);
		addCorrespondenceColumns.setText("Add Correspondence");
		addCorrespondenceColumns.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				

				List<EObject> matchingA = matching.getUnmatchedA().stream().filter(e1 -> e1 instanceof Column )
						.collect(Collectors.toList());
				List<EObject> matchingB = matching.getUnmatchedB().stream().filter(e1 -> e1 instanceof Column)
						.collect(Collectors.toList());

				CorrespondenceDialog dialog = new CorrespondenceDialog(Display.getCurrent().getActiveShell(), matchingA,
						matchingB);
				dialog.create();
				if (dialog.open() == Window.OK) {
					EObject eObjectA = dialog.geteObjectA();
					EObject eObjectB = dialog.geteObjectB();

					if (eObjectA != null && eObjectB != null)
						controller.addCorrespondence(eObjectA, eObjectB);

					fillCorrespondence();
				}

			}
		});
		delCorrespondenceColumns = createdelCorrespondenceButton(buttonBar2, tableColumns);

		setControl(composite);

	}

	protected void fillCorrespondence() {
		table.removeAll();
		tableColumns.removeAll();

		try {
			matching = controller.createMatching();

			EList<Correspondence> elist = matching.getCorrespondences();
			List<Correspondence> tableCorrespondence = elist.stream().filter(e -> e.getMatchedA() instanceof Table)
					.collect(Collectors.toList());
			List<Correspondence> columnCorrespondence = elist.stream().filter(e -> e.getMatchedA() instanceof Column)
					.collect(Collectors.toList());

			for (Correspondence correspondence : tableCorrespondence) {

				EObject objectA = correspondence.getMatchedA();
				EObject objectB = correspondence.getMatchedB();
				String nameA = objectA.toString();
				String nameB = objectB.toString();

				if (objectA instanceof Table) {
					nameA = ((Table) objectA).getName();
					nameB = ((Table) objectB).getName();
				}else if (objectA instanceof Database_Schema) {
					continue;
				}

				TableItem item = new TableItem(table, SWT.BORDER);
				item.setText(new String[] { nameA, nameB });

				item.setData(item.getText(), correspondence);
			}
			
			for (Correspondence correspondence : columnCorrespondence) {

				EObject objectA = correspondence.getMatchedA();
				EObject objectB = correspondence.getMatchedB();
				String nameA = objectA.toString();
				String nameB = objectB.toString();

				if (objectA instanceof Column) {
					Column columnA = (Column) objectA;
					Column columnB = (Column) objectB;
					
					
					nameA = columnA.getName() + " ("+columnA.getTable().getName()+")";
					nameB = columnB.getName() + " ("+columnB.getTable().getName()+")";

				} else if (objectA instanceof Database_Schema) {
					continue;
				}

				TableItem item = new TableItem(tableColumns, SWT.BORDER);
				item.setText(new String[] { nameA, nameB });

				item.setData(item.getText(), correspondence);
			}

			resizeColumns(table);
			resizeColumns(tableColumns);

		} catch (NoCorrespondencesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Button createAddCorrespondenceButton(Composite parent, Class classArgument) {

		Button addCorrespondence = new Button(parent, SWT.PUSH);
		addCorrespondence.setText("Add Correspondence");
		

		return addCorrespondence;

	}

	private Button createdelCorrespondenceButton(Composite parent, org.eclipse.swt.widgets.Table table) {

		Button delCorrespondence = new Button(parent, SWT.PUSH | SWT.CANCEL);
		delCorrespondence.setText("Delete Correspondence");
		delCorrespondence.setEnabled(false);
		delCorrespondence.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (table.getSelectionCount() == 1) {

					TableItem selection = table.getSelection()[0];

					Correspondence correspondence = (Correspondence) selection.getData(selection.getText());
					controller.removeCorrespondence(correspondence);
					fillCorrespondence();
					delCorrespondence.setEnabled(false);
				}

			}

		});

		return delCorrespondence;
	}

	private void resizeColumns(org.eclipse.swt.widgets.Table table) {
		Rectangle rect = table.getClientArea();
		if (rect.width > 0) {
			int extraSpace = rect.width / table.getColumns().length;
			// Resize the columns of the table
			for (TableColumn tc : table.getColumns())
				tc.setWidth(extraSpace);
		}
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			fillCorrespondence();
		}
	}

}
