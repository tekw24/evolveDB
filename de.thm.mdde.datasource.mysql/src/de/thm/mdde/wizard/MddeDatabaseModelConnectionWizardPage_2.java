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
package de.thm.mdde.wizard;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class MddeDatabaseModelConnectionWizardPage_2 extends WizardPage {

	private MddeDatabaseConnectionController controller;
	private Table table;

	protected MddeDatabaseModelConnectionWizardPage_2(String pageName, IStructuredSelection selection,
			MddeDatabaseConnectionController controller) {
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

		table = new Table(composite, SWT.BORDER | SWT.SINGLE);
		table.setToolTipText("Eine Tabelle");
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 2, 1));
		table.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				TableItem[] items = table.getSelection();
				if (items.length == 1) {
					controller.setSchema(items[0].getText());
					setPageComplete(true);
				}else
					setPageComplete(false);

			}

		});

		TableColumn tc = new TableColumn(table, SWT.BORDER);
		tc.setText("Schema name");
		tc.pack();
		tc.setMoveable(true);

		table.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent arg0) {
				resizeColumns();
			}

			@Override
			public void controlMoved(ControlEvent arg0) {
				

			}
		});

		setControl(composite);

	}

	protected void fillSchemas(List<String> schemas) {
		table.removeAll();
		for (int k = 0; k < schemas.size(); k++) {
			TableItem item = new TableItem(table, SWT.BORDER);
			item.setText(schemas.get(k));

		}

		resizeColumns();

	}
	
	private void resizeColumns() {
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
			controller.getAvaillableSchemes();
		}
	}

}
