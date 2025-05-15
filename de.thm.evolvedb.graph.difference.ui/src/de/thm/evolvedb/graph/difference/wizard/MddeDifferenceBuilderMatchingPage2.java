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
package de.thm.evolvedb.graph.difference.wizard;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;

import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.Property;
import de.thm.evolvedb.graph.PropertyGraph;


public class MddeDifferenceBuilderMatchingPage2 extends WizardPage {

	private MddeDifferenceBuilderController controller;
	private org.eclipse.swt.widgets.Table tableColumns;

	private Button delCorrespondence;

	private Button delCorrespondenceColumns;
	private Button addCorrespondenceColumns;

	private Matching matching;

	private Text txtFilterColumn;
	private ModifyListener listenerFilter;
	private org.eclipse.swt.widgets.Table tableUnmatchedColumns;

	protected MddeDifferenceBuilderMatchingPage2(String pageName, MddeDifferenceBuilderController controller) {
		super(pageName);
		this.controller = controller;
	}

	@Override
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}

		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gridData.minimumWidth = 150; // make enough space for both symbols within the field

		// Header Label
		Label headerColumn = new Label(composite, SWT.NONE);
		headerColumn.setText("Column correspondences");
		headerColumn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));

		// Filter
		txtFilterColumn = new Text(composite, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
		txtFilterColumn.setTextLimit(200);
		txtFilterColumn.setLayoutData(gridData);

		listenerFilter = new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				tableColumns.removeAll();
				String match = txtFilterColumn.getText().toLowerCase();

				Display display = PlatformUI.getWorkbench().getDisplay();
				Color blue = display.getSystemColor(SWT.COLOR_BLUE);

				EList<Correspondence> elist = matching.getCorrespondences();
				List<Correspondence> columnCorrespondence = elist.stream()
						.filter(e -> e.getMatchedA() instanceof Property).collect(Collectors.toList());

				for (Correspondence correspondence : columnCorrespondence) {

					EObject objectA = correspondence.getMatchedA();
					EObject objectB = correspondence.getMatchedB();
					String nameA = objectA.toString();
					String nameB = objectB.toString();

					if (objectA instanceof Property) {
						Property columnA = (Property) objectA;
						Property columnB = (Property) objectB;

						nameA = columnA.getName() + " ("+ getParentName(columnA)+ ")";
						nameB = columnB.getName() + " ("+ getParentName(columnA)+ ")";

						String d_text = nameA + nameB;

						if (d_text.toLowerCase().matches(".*" + match + ".*")) {
							TableItem item = new TableItem(tableColumns, SWT.BORDER);
							item.setText(new String[] { nameA, nameB });

							if (!nameA.equals(nameB))
								item.setForeground(blue);

							item.setData(item.getText(), correspondence);

						}

					} else if (objectA instanceof PropertyGraph) {
						continue;
					}

				}

			}
		};
		txtFilterColumn.addModifyListener(listenerFilter);

		// Buttons

		addCorrespondenceColumns = createAddCorrespondenceButton(composite);
		addCorrespondenceColumns.setText("Add Correspondence");
		addCorrespondenceColumns.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		addCorrespondenceColumns.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				List<EObject> matchingA = matching.getUnmatchedA().stream().filter(e1 -> e1 instanceof Property)
						.collect(Collectors.toList());
				List<EObject> matchingB = matching.getUnmatchedB().stream().filter(e1 -> e1 instanceof Property)
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
		delCorrespondenceColumns = createdelCorrespondenceButton(composite);
		delCorrespondenceColumns.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (tableColumns.getSelectionCount() == 1) {

					TableItem selection = tableColumns.getSelection()[0];

					Correspondence correspondence = (Correspondence) selection.getData(selection.getText());
					controller.removeCorrespondence(correspondence);
					fillCorrespondence();
					delCorrespondence.setEnabled(false);
				}

			}

		});

		delCorrespondenceColumns.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));

		// SashForm
		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		// Table
		tableColumns = new org.eclipse.swt.widgets.Table(sashForm, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
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
				

			}
		});

		// Table unmatched
		tableUnmatchedColumns = new org.eclipse.swt.widgets.Table(sashForm, SWT.BORDER | SWT.SINGLE |SWT.FULL_SELECTION );
		tableUnmatchedColumns.setToolTipText("Eine Tabelle");
		tableUnmatchedColumns.setLinesVisible(true);
		tableUnmatchedColumns.setHeaderVisible(true);
		tableUnmatchedColumns.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, true, 1, 1));
		tableUnmatchedColumns.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent arg0) {
				resizeColumns(tableUnmatchedColumns);
			}

			@Override
			public void controlMoved(ControlEvent arg0) {
				

			}
		});

		TableColumn tcUnmatchedColumns = new TableColumn(tableUnmatchedColumns, SWT.BORDER);
		tcUnmatchedColumns.setText("Unmatched Property");
		tcUnmatchedColumns.pack();
		tcUnmatchedColumns.setMoveable(true);

		setControl(composite);

	}

	protected void fillCorrespondence() {
		tableColumns.removeAll();
		tableUnmatchedColumns.removeAll();

		Display display = PlatformUI.getWorkbench().getDisplay();
		Color blue = display.getSystemColor(SWT.COLOR_BLUE);

		try {
			matching = controller.createMatching();

			EList<Correspondence> elist = matching.getCorrespondences();
			List<Correspondence> columnCorrespondence = elist.stream().filter(e -> e.getMatchedA() instanceof Property)
					.collect(Collectors.toList());

			

			for (Correspondence correspondence : columnCorrespondence) {

				EObject objectA = correspondence.getMatchedA();
				EObject objectB = correspondence.getMatchedB();
				String nameA = objectA.toString();
				String nameB = objectB.toString();

				if (objectA instanceof Property) {
					Property columnA = (Property) objectA;
					Property columnB = (Property) objectB;
					

					nameA = columnA.getName() + " ("+ getParentName(columnA)+ ")";
					nameB = columnB.getName() + " ("+ getParentName(columnA)+ ")";
					
					
					
					
					TableItem item = new TableItem(tableColumns, SWT.BORDER);
					item.setText(new String[] { nameA, nameB });

					if (!nameA.equals(nameB))
						item.setForeground(blue);

					item.setData(item.getText(), correspondence);

				} else if (objectA instanceof PropertyGraph) {
					continue;
				}

			}

			addUnmatchedElements(matching.getUnmatchedA());
			addUnmatchedElements(matching.getUnmatchedB());

			
			resizeColumns(tableColumns);
			resizeColumns(tableUnmatchedColumns);

		} catch (NoCorrespondencesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addUnmatchedElements(EList<EObject> elistUnmatched) {
		Display display = PlatformUI.getWorkbench().getDisplay();
		Color red = display.getSystemColor(SWT.COLOR_RED);
		Color green = display.getSystemColor(SWT.COLOR_DARK_GREEN);
		for (EObject e : elistUnmatched) {
			String name = e.toString();
			if (e instanceof Property) {

				Property column = (Property) e;
				name = column.getName() + " ("+ getParentName(column)+ ")";
				TableItem item = new TableItem(tableUnmatchedColumns, SWT.BORDER);
				item.setText(new String[] { name });
				item.setData(item.getText(), e);

				if (matching.getUnmatchedA().contains(e))
					item.setForeground(red);
				else
					item.setForeground(green);

			}

		}
	}
	
	private String getParentName(Property property) {
		String nameParent = "";
		if(property.eContainingFeature() != null) {
			EObject eObject = property.eContainer();
			if(eObject instanceof de.thm.evolvedb.graph.Label)
				nameParent = ((de.thm.evolvedb.graph.Label) eObject).getName();
		}
		return nameParent;
	}

	private Button createAddCorrespondenceButton(Composite parent) {

		Button addCorrespondence = new Button(parent, SWT.PUSH);
		addCorrespondence.setText("Add Correspondence");

		return addCorrespondence;

	}

	private Button createdelCorrespondenceButton(Composite parent) {

		Button delCorrespondence = new Button(parent, SWT.PUSH | SWT.CANCEL);
		delCorrespondence.setText("Delete Correspondence");
		delCorrespondence.setEnabled(false);
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
		
		table.getParent().layout(true, true);
		
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			fillCorrespondence();
		}
	}

}
