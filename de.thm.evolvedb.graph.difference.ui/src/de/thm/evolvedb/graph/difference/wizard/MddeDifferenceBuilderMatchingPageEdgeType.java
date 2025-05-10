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

import de.thm.evolvedb.graph.EdgeLabel;
import de.thm.evolvedb.graph.EdgeType;
import de.thm.evolvedb.graph.PropertyGraph;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.window.Window.IExceptionHandler;
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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;

public class MddeDifferenceBuilderMatchingPageEdgeType extends WizardPage {

	private MddeDifferenceBuilderController controller;
	private org.eclipse.swt.widgets.Table table;

	private Button delCorrespondence;
	private Button addCorrespondence;

	private Matching matching;
	private Text txtFilter;
	private ModifyListener listener;
	private org.eclipse.swt.widgets.Table tableUnmatched;

	private SashForm sashFormA;

	private ProgressMonitorDialog dialog;

	protected MddeDifferenceBuilderMatchingPageEdgeType(String pageName, MddeDifferenceBuilderController controller) {
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

		// Header Label
		Label headerTable = new Label(composite, SWT.NONE);
		headerTable.setText("Node Label correspondences");
		headerTable.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		txtFilter = new Text(composite, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
		txtFilter.setTextLimit(200);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gridData.minimumWidth = 150; // make enough space for both symbols within the field
		txtFilter.setLayoutData(gridData);

		listener = new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {

				Display display = PlatformUI.getWorkbench().getDisplay();
				Color blue = display.getSystemColor(SWT.COLOR_BLUE);
				table.removeAll();

				String match = txtFilter.getText().toLowerCase();

				EList<Correspondence> elist = matching.getCorrespondences();
				List<Correspondence> tableCorrespondence = elist.stream()
						.filter(e -> e.getMatchedA() instanceof EdgeType).collect(Collectors.toList());

				for (Correspondence correspondence : tableCorrespondence) {

					EObject objectA = correspondence.getMatchedA();
					EObject objectB = correspondence.getMatchedB();
					String nameA = objectA.toString();
					String nameB = objectB.toString();

					if (objectA instanceof EdgeType) {
						nameA = getEdgeTypeName((EdgeType) objectA);
						nameB = getEdgeTypeName((EdgeType) objectB);
					} else if (objectA instanceof PropertyGraph) {
						continue;
					}

					String d_text = nameA + nameB;

					if (d_text.toLowerCase().matches(".*" + match + ".*")) {
						TableItem item = new TableItem(table, SWT.BORDER);
						item.setText(new String[] { nameA, nameB });

						if (!nameA.equals(nameB))
							item.setForeground(blue);

						item.setData(item.getText(), correspondence);

					}
				}

			}
		};
		txtFilter.addModifyListener(listener);

		// Buttons

		// Optionally set layout fields.
		addCorrespondence = createAddCorrespondenceButton(composite);
		addCorrespondence.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		addCorrespondence.setText("Add Correspondence");
		addCorrespondence.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				List<EObject> matchingA = matching.getUnmatchedA().stream().filter(e1 -> e1 instanceof EdgeType)
						.collect(Collectors.toList());
				List<EObject> matchingB = matching.getUnmatchedB().stream().filter(e1 -> e1 instanceof EdgeType)
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
		delCorrespondence = createdelCorrespondenceButton(composite);
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

		delCorrespondence.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));

		// SashForm
		sashFormA = new SashForm(composite, SWT.HORIZONTAL);
		sashFormA.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		sashFormA.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent e) {
				// sashFormA.setBounds(0, 0, (int)(composite.getBounds().width* 0.4), (int)(
				// composite.getBounds().height* 0.9));
				System.out.println(sashFormA.getBounds().height);
				System.out.println(sashFormA.getParent().getBounds().height);
			}

			@Override
			public void controlMoved(ControlEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// Table
		table = new org.eclipse.swt.widgets.Table(sashFormA, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		table.setToolTipText("Eine Tabelle");
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
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

			}
		});

		// Table unmatched
		tableUnmatched = new org.eclipse.swt.widgets.Table(sashFormA, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		tableUnmatched.setToolTipText("Eine Tabelle");
		tableUnmatched.setLinesVisible(true);
		tableUnmatched.setHeaderVisible(true);
		tableUnmatched.setLayoutData(new GridData(SWT.LEFT, GridData.FILL, true, true, 1, 1));
		tableUnmatched.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent arg0) {
				resizeColumns(tableUnmatched);
			}

			@Override
			public void controlMoved(ControlEvent arg0) {

			}
		});

		TableColumn tcUnmatched = new TableColumn(tableUnmatched, SWT.BORDER);
		tcUnmatched.setText("Unmatched EdgeType");
		tcUnmatched.pack();
		tcUnmatched.setMoveable(true);

		setControl(composite);

	}

	protected void fillCorrespondence() {
		table.removeAll();
		tableUnmatched.removeAll();

		Display display = PlatformUI.getWorkbench().getDisplay();
		Color blue = display.getSystemColor(SWT.COLOR_BLUE);

		Job job = Job.create("Create Matching...", (ICoreRunnable) monitor -> {
			// do something long running
			// ...

			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					dialog = new ProgressMonitorDialog(getShell());
//					dialog.setCancelable(true);
//					dialog.setExceptionHandler(new IExceptionHandler() {
//						
//						@Override
//						public void handleException(Throwable t) {
//							dialog.close();
//							
//						}
//					});
					dialog.open();
				}
			});

			try {
				matching = controller.createMatching();

				EList<Correspondence> elist = matching.getCorrespondences();
				List<Correspondence> tableCorrespondence = elist.stream()
						.filter(e -> e.getMatchedA() instanceof EdgeType).collect(Collectors.toList());

//				MessageBox dialog =
//					    new MessageBox(getShell(), SWT.ICON_QUESTION | SWT.CANCEL);
//					dialog.setText("My info");
//					dialog.setMessage("Do you really want to do this?");

				// If you want to update the UI
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						for (Correspondence correspondence : tableCorrespondence) {

							EObject objectA = correspondence.getMatchedA();
							EObject objectB = correspondence.getMatchedB();
							String nameA = objectA.toString();
							String nameB = objectB.toString();

							if (objectA instanceof EdgeType) {
								nameA = getEdgeTypeName((EdgeType) objectA);
								nameB = getEdgeTypeName((EdgeType) objectB);
							} else if (objectA instanceof PropertyGraph) {
								continue;
							}

							TableItem item = new TableItem(table, SWT.BORDER);
							item.setText(new String[] { nameA, nameB });

							if (!nameA.equals(nameB))
								item.setForeground(blue);

							item.setData(item.getText(), correspondence);
						}

						addUnmatchedElements(matching.getUnmatchedA());
						addUnmatchedElements(matching.getUnmatchedB());

						resizeColumns(table);
						resizeColumns(tableUnmatched);

						if (dialog != null)
							dialog.close();
					}
				});

			} catch (NoCorrespondencesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		job.schedule();

	}

	private void addUnmatchedElements(EList<EObject> elistUnmatched) {
		Display display = PlatformUI.getWorkbench().getDisplay();
		Color red = display.getSystemColor(SWT.COLOR_RED);
		Color green = display.getSystemColor(SWT.COLOR_DARK_GREEN);
		for (EObject e : elistUnmatched) {
			String name = e.toString();
			if (e instanceof EdgeType) {
				name = getEdgeTypeName((EdgeType) e);

				TableItem item = new TableItem(tableUnmatched, SWT.BORDER);
				item.setText(new String[] { name });
				item.setData(item.getText(), e);

				if (matching.getUnmatchedA().contains(e))
					item.setForeground(red);
				else
					item.setForeground(green);

			}

		}
	}

	private String getEdgeTypeName(EdgeType edgeType) {

		String name = "";
		for (EdgeLabel label : edgeType.getLabels()) {
			name += label.getName() != null ? ":" + label.getName() : "";
		}

		return name;
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
