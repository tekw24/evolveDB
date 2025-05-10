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
package de.thm.evolvedb.datasource.neo4j.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import de.thm.evolvedb.datasource.messages.Messages;
import de.thm.evolvedb.datasource.neo4j.connection.Neo4JDatabaseConnectionController;
import de.thm.evolvedb.datasource.neo4j.connection.User;
import de.thm.evolvedb.datasource.util.ResourceFileSelectionDialog;
import de.thm.mdde.language.Language;

public class Neo4jDatabaseConnectionWizardPage_1 extends WizardPage {

	/**
	 * The controller for this wizard
	 */
	private Neo4JDatabaseConnectionController controller;
	private Text hostname;
	private Spinner portSpinner;
	private Text usernameText;
//	private Text textSchema;
//	private Button checkSchema;
	private Button btnSaveConfiguration;

	protected Neo4jDatabaseConnectionWizardPage_1(String pageName, IStructuredSelection selection,
			Neo4JDatabaseConnectionController controller) {
		super(pageName);
		this.controller = controller;
		setPageComplete(false);
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

		// Import Config
		Label labelConfig = new Label(composite, SWT.NONE);
		labelConfig.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 2, 1));
		labelConfig.setText(Language.WIZARD_CONFIG);

		Composite compConfig = new Composite(composite, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			layout.verticalSpacing = 12;
			compConfig.setLayout(layout);

			GridData data = new GridData();
			data.horizontalSpan = 2;
			data.verticalAlignment = GridData.BEGINNING;
			data.grabExcessVerticalSpace = false;
			data.horizontalAlignment = GridData.FILL;
			compConfig.setLayoutData(data);
		}

		Text config = new Text(compConfig, SWT.BORDER | SWT.SINGLE);
		config.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		config.setEditable(false);

		Button btnImportConfig = new Button(compConfig, SWT.PUSH);
		btnImportConfig.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnImportConfig.setText(Language.WIZARD_BUTTON_IMPORT);
		btnImportConfig.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(getShell());
				// Set the text
				//fileDialog.setText(Messages.MddeDatabaseConnectionWizardPage_1_Select_FILE);
				fileDialog.setText("This is a Text");
				// Set filter on .txt files
				fileDialog.setFilterExtensions(new String[] { Messages.Neo4jDatabaseConnectionWizardPage_1_1 });
				// Put in a readable name for the filter
				fileDialog.setFilterNames(new String[] { Messages.Neo4jDatabaseConnectionWizardPage_1_2 });
				// Open Dialog and save result of selection

				fileDialog.setFilterPath(Platform.getLocation().toOSString());

				String selected = fileDialog.open();
				if (selected != null) {
					config.setText(selected);
					controller.selectConfigFile(selected);
					enableExportConfigButton();
				}

				// System.out.println(selected);
			}
		});

		Button btnWorkspaceFile = new Button(compConfig, SWT.PUSH);
		btnWorkspaceFile.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnWorkspaceFile.setText(Messages.Neo4jDatabaseConnectionWizardPage_1_SELECT_WORKSPACE_FILE);
		btnWorkspaceFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ResourceFileSelectionDialog dialog = new ResourceFileSelectionDialog(Messages.Neo4jDatabaseConnectionWizardPage_1_SELECT_FILE, Messages.Neo4jDatabaseConnectionWizardPage_1_SELECT_CONFIGURATION_TEXT,
						new String[] { Messages.Neo4jDatabaseConnectionWizardPage_1_6 });
				if (dialog.open() == Window.OK) {
					Object[] result = dialog.getResult();
					if (result.length == 1 && result[0] instanceof IFile) {
						IFile iFile = (IFile) result[0];
						controller.selectConfigFile(iFile.getRawLocation().makeAbsolute().toFile());
						// controller.selectConfigFile(((IFile)result[0]).getFullPath().toOSString());
						config.setText(iFile.getFullPath().toOSString());
						enableExportConfigButton();
					}

				}

			}
		});

		// Label Host
		Label labelHost = new Label(composite, SWT.NONE);
		labelHost.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		labelHost.setText(Language.WIZARD_HOST);

		// Textfield for the hostname
		hostname = new Text(composite, SWT.BORDER | SWT.LEAD | SWT.SINGLE);
		hostname.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		hostname.addModifyListener(new ModifyListener() {
			  public void modifyText(ModifyEvent e) {
				  enableExportConfigButton();
			    }
			
		});

		// Label for the port spinner
		Label labelPort = new Label(composite, SWT.NONE);
		labelPort.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		labelPort.setText(Language.WIZARD_PORT);

		// Spinner for the port
		portSpinner = new Spinner(composite, SWT.BORDER);
		portSpinner.setDigits(0);
		portSpinner.setIncrement(1);
		portSpinner.setMaximum(100000);
		portSpinner.setMinimum(0);
		portSpinner.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enableExportConfigButton();
			}
		
		});
		
		// Default Value for testing
		// portSpinner.setSelection(3306);
		hostname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

		// Label for the username textfield
		Label labelUser = new Label(composite, SWT.NONE);
		labelUser.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		labelUser.setText(Language.WIZARD_USERNAME);

		// Textfield for the username
		usernameText = new Text(composite, SWT.BORDER | SWT.LEAD | SWT.SINGLE);
		usernameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		usernameText.addModifyListener(new ModifyListener() {
			  public void modifyText(ModifyEvent e) {
				  enableExportConfigButton();
			    }
			
		});
			

		// Label for the username textfield
		Label labelPassword = new Label(composite, SWT.NONE);
		labelPassword.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		labelPassword.setText(Language.WIZARD_PASSWORD);

		// Textfield for the hostname
		// Create a Password field.
		Text passwordField = new Text(composite, SWT.SINGLE | SWT.BORDER | SWT.LEAD | SWT.PASSWORD);
		passwordField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		// Set echo char.
		passwordField.setEchoChar('*');

//		checkSchema = new Button(composite, SWT.CHECK);
//		checkSchema.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 2, 1));
//		checkSchema.setText(
//				Messages.Neo4jDatabaseConnectionWizardPage_1_PRESELECT_SCHEMA);
//
//		// Label for the schema textfield
//		Label labelSchema = new Label(composite, SWT.NONE);
//		labelSchema.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
//		labelSchema.setText(Language.WIZARD_SCHEMA);
//
//		// Textfield for the Schema
//		textSchema = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
//		textSchema.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
//		textSchema.setEnabled(false);
//
//		checkSchema.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				textSchema.setEnabled(checkSchema.getSelection());
//				enableExportConfigButton();
//			}
//		});

		// Button testconnection
		Button button = new Button(composite, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		button.setText(Language.WIZARD_TEST_CONNECTION);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String host = hostname.getText();
				String port = "" + portSpinner.getSelection(); //$NON-NLS-1$
				String username = usernameText.getText();
				String password = passwordField.getText();
				//String schema = checkSchema.getSelection() ? textSchema.getText() : ""; //$NON-NLS-1$

				User user = new User(username, password);
				controller.testConnection(user, host, port);

			}
		});
		
		// Save Configuration file
		btnSaveConfiguration = new Button(composite, SWT.PUSH);
		btnSaveConfiguration.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 1,1));
		btnSaveConfiguration.setEnabled(false);
		//btnSaveConfiguration.setText(Language.WIZARD_SAVE_CONFIG);
		btnSaveConfiguration.setText(Messages.Neo4jDatabaseConnectionWizardPage_1_EXPORT_CONFIGURATION);
		btnSaveConfiguration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
				FileDialog fileDialog = new FileDialog(getShell(), SWT.SAVE);
				String[] extensions = { Messages.Neo4jDatabaseConnectionWizardPage_1_11 };
				fileDialog.setFilterExtensions(extensions);
				fileDialog.setOverwrite(true);
				fileDialog.setFilterPath(Platform.getLocation().toOSString());
				String filename = fileDialog.open();
				if (filename != null) {
					
					controller.saveConfigFile(filename);
					
				}
			}
		});

		setControl(composite);

	}

	public void setHost(String host) {
		hostname.setText(host);

	}

	public void setPort(String port) {
		portSpinner.setSelection(Integer.valueOf(port));

	}

	public void setUser(String user) {
		usernameText.setText(user);

	}

//	protected void setSchema(String schema) {
//		if (schema != null && !schema.equals("")) { //$NON-NLS-1$
//			checkSchema.setSelection(true);
//			textSchema.setEnabled(true);
//			textSchema.setText(schema);
//		}
//
//	}
	
	private void enableExportConfigButton() {
		boolean enable = !usernameText.getText().isEmpty() && !hostname.getText().isEmpty() && portSpinner.getSelection() != 0;
		if(enable) {
			controller.setHost(hostname.getText());
			controller.setUser(new User(usernameText.getText(), ""));
			controller.setPort(""+portSpinner.getSelection());
			//TODO 
//			if(isSchemaSelected())
//				controller.setSchema(textSchema.getText());
		}
		btnSaveConfiguration.setEnabled(enable);
			
	}
	
	
	
	
	
	

//	/**
//	 * Returns whether the user has preselected a schema.
//	 * 
//	 * @return
//	 */
//	public boolean isSchemaSelected() {
//		return checkSchema.getSelection();
//	}

}
