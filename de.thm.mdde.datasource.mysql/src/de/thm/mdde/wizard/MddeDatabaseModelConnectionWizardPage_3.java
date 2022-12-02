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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.thm.mdde.language.Language;
import de.thm.model.JPAProvider;

public class MddeDatabaseModelConnectionWizardPage_3 extends WizardPage {

	private MddeDatabaseConnectionController controller;
	private Table table;
	private Composite compositeORM;
	private Button buttonYes;
	private Button buttonNo;

	public MddeDatabaseModelConnectionWizardPage_3(String pageName, IStructuredSelection selection,
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

		// Check whether an ORM Tool has been used
		Label labelORM = new Label(composite, SWT.NONE);
		labelORM.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		labelORM.setText(Language.WIZARD_ORM_TOOL);

		buttonYes = new Button(composite, SWT.RADIO);
		buttonYes.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		buttonYes.setText(Language.YES);
		buttonYes.setSelection(false);
		buttonYes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (buttonYes.getSelection()) {
					table.setEnabled(true);
					setPageComplete(false);
					checkSelection();
				}
			}
		});

		buttonNo = new Button(composite, SWT.RADIO);
		buttonNo.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		buttonNo.setText(Language.No);
		buttonNo.setSelection(false);
		buttonNo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (buttonNo.getSelection()) {
					table.setEnabled(false);
					setPageComplete(true);
					controller.setJPAProvider(null);
				}
			}
		});

		compositeORM = new Composite(composite, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			layout.verticalSpacing = 12;
			compositeORM.setLayout(layout);

			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
			compositeORM.setLayoutData(data);
		}

		// Table for tools and version

		table = new Table(compositeORM, SWT.BORDER | SWT.SINGLE);
		// table.setToolTipText("Eine Tabelle");
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 2, 1));
		table.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				checkSelection();
			}

		});

		TableColumn tc = new TableColumn(table, SWT.BORDER);
		tc.setText("Name");
		tc.pack();
		tc.setMoveable(true);

		TableColumn tc2 = new TableColumn(table, SWT.BORDER);
		tc2.setText("Version");
		tc2.pack();
		tc2.setMoveable(true);

		table.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent arg0) {
				resizeColumns();
			}

			@Override
			public void controlMoved(ControlEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		fillTable();
		table.setEnabled(false);

//		// Single Table Inheritance
//
//		Button button = new Button(composite, SWT.RADIO);
//		button.setLayoutData(new GridData(SWT.TOP, SWT.CENTER, false, false));
//		button.setText("Single Table Inheritance");
//		button.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//
//			}
//		});
//
//		Text text = new Text(composite, SWT.MULTI | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
//		text.setText(Language.WIZARD_SINGLE_TABLE_INHERITANCE);
//
//		GridData gdTextFields = new GridData(SWT.FILL, SWT.FILL, true, true);
//		gdTextFields.widthHint = 300;
//		text.setLayoutData(gdTextFields);
//
//		// Multi Table Inheritance
//
//		Button button2 = new Button(composite, SWT.RADIO);
//		button2.setLayoutData(new GridData(SWT.TOP, SWT.CENTER, false, false));
//		button2.setText("Single Table Inheritance");
//		button2.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//
//			}
//		});
//
//		Text text2 = new Text(composite, SWT.MULTI | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
//		text2.setText(Language.WIZARD_SINGLE_TABLE_INHERITANCE);
//		text2.setLayoutData(gdTextFields);
//
//		// Single Table Inheritance
//
//		Button button3 = new Button(composite, SWT.RADIO);
//		button3.setLayoutData(new GridData(SWT.TOP, SWT.CENTER, false, false));
//		button3.setText("Single Table Inheritance");
//		button3.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//
//			}
//		});
//
//		Text text3 = new Text(composite, SWT.MULTI | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
//		text3.setText(Language.WIZARD_SINGLE_TABLE_INHERITANCE);
//		text3.setLayoutData(gdTextFields);

		setControl(composite);

		setPageComplete(true);
	}
	
	/**
	 * Select the JPAProvider in the table. 
	 * Method is called by the controller when the user imports a configuration file.
	 * @param jpaProvider
	 */
	protected void setJPAProvider(JPAProvider jpaProvider) {
		buttonYes.setSelection(true);
		for(TableItem item : table.getItems()) {
			JPAProvider j = (JPAProvider) item.getData();
			if(j.equals(jpaProvider)) {
				table.deselectAll();
				table.setSelection(item);
				table.setEnabled(true);
				break;
			}
		}
		
	}
	
	private void checkSelection() {
		TableItem[] items = table.getSelection();
		if (items.length == 1) {
			controller.setJPAProvider((JPAProvider)items[0].getData());
			setPageComplete(true);
		}else {
			controller.setJPAProvider(null);
			setPageComplete(false);
		}
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);

	}

	private void fillTable() {
		for (JPAProvider provider : JPAProvider.values()) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[] { provider.getName(),provider.getVersion() });
			tableItem.setData(provider);
		}

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

	

}
