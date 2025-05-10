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
import de.thm.evolvedb.graph.NodeLabel;
import de.thm.evolvedb.graph.NodeType;
import de.thm.evolvedb.graph.Property;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;


public class CorrespondenceDialog extends TitleAreaDialog {

	private Table table;
	private List<EObject> matchingA;
	private List<EObject> matchingB;
	private Table tableA;
	private Table tableB;
	private Button okButton;

	private EObject eObjectA;
	private EObject eObjectB;

	protected CorrespondenceDialog(Shell parentShell, List<EObject> matchingA, List<EObject> matchingB) {
		super(parentShell);
		this.matchingA = matchingA;
		this.matchingB = matchingB;

	}

	@Override
	public void create() {
		super.create();
		setTitle("Add Matching");
		setMessage("In this dialog model elements can be matched.", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(container, SWT.None);
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

		tableA = createTabel(composite, matchingA, "Unmatched ResourceA");
		tableB = createTabel(composite, matchingB, "Unmatched ResourceB");

		return container;
	}

	private Table createTabel(Composite parent, List<EObject> matching, String label) {
		Table table = new org.eclipse.swt.widgets.Table(parent, SWT.BORDER | SWT.SINGLE);
		table.setToolTipText("Eine Tabelle");
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 1, 1));
		table.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				okButton.setEnabled(canFinish());
			}

		});

		TableColumn tc = new TableColumn(table, SWT.BORDER);
		tc.setText(label);
		tc.pack();
		tc.setMoveable(true);

		for (EObject e : matching) {
			String name = e.toString();
			if (e instanceof NodeLabel) {
				name = ((NodeLabel) e).getName();
			} else if (e instanceof EdgeLabel) {
				EdgeLabel column = (EdgeLabel) e;
				name = column.getName();
			} else if (e instanceof Property) {
				Property constraint = (Property) e;
				name = constraint.getName() + " (" + constraint.eContainingFeature() != null ? constraint.eContainingFeature().getName() +")": ")";
			} else if (e instanceof EdgeType) {
				EdgeType column = (EdgeType) e;
				name = getEdgeTypeName(column);
			}else if (e instanceof NodeType) {
				NodeType column = (NodeType) e;
				name = getNodeTypeName(column);
			}

			TableItem item = new TableItem(table, SWT.BORDER);
			item.setText(new String[] { name });
			item.setData(item.getText(), e);

		}

		resizeColumns(table);

		return table;
	}
	
	private String getEdgeTypeName(EdgeType edgeType) {

		String name = "";
		for (EdgeLabel label : edgeType.getLabels()) {
			name += label.getName() != null ? ":" + label.getName() : "";
		}

		return name;
	}
	
	private String getNodeTypeName(NodeType edgeType) {

		String name = "";
		for (NodeLabel label : edgeType.getLabel()) {
			name += label.getName() != null ? ":" + label.getName() : "";
		}

		return name;
	}

	private boolean canFinish() {
		return tableA.getSelectionCount() == 1 && tableB.getSelectionCount() == 1;
	}

	// override method to use "Login" as label for the OK button
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, "Create", true);
		okButton.setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();

	}

	@Override
	protected void okPressed() {
		TableItem a = tableA.getSelection()[0];
		TableItem b = tableB.getSelection()[0];
		this.eObjectA = (EObject) a.getData(a.getText());
		this.eObjectB = (EObject) b.getData(b.getText());
		super.okPressed();

	}

	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Add correspondence dialog");
	}

	private void resizeColumns(Table table) {
		Rectangle rect = table.getClientArea();
		if (rect.width > 0) {
			int extraSpace = rect.width / table.getColumns().length;
			// Resize the columns of the table
			for (TableColumn tc : table.getColumns())
				tc.setWidth(extraSpace);
		}
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(1000, 600);
	}

	public EObject geteObjectA() {
		return eObjectA;
	}

	public void seteObjectA(EObject eObjectA) {
		this.eObjectA = eObjectA;
	}

	public EObject geteObjectB() {
		return eObjectB;
	}

	public void seteObjectB(EObject eObjectB) {
		this.eObjectB = eObjectB;
	}

}
