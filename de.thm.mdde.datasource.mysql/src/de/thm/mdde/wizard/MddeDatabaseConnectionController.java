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

import java.io.File;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.xml.sax.SAXException;

import de.thm.de.util.CustomJobChangedListener;
import de.thm.mdde.controller.MDDEModelCreator;
import de.thm.mdde.database.MYSQL_Database_Connector;
import de.thm.mdde.language.Language;
import de.thm.mdde.model.User;
import de.thm.model.JPAProvider;
import de.thm.model.ReverseDatabaseModel;
import de.thm.readConfigurationFile.XMLFileCreator;
import de.thm.readConfigurationFile.XMLFileReader;

public class MddeDatabaseConnectionController {

	private MddeDatabaseConnectionWizardPage_1 connectionWizardPage_1;
	private MddeDatabaseModelConnectionWizardPage_2 mddeDatabaseModelConnectionWizardPage_2;
	private MddeDatabaseModelConnectionWizardPage_3 mddeDatabaseModelConnectionWizardPage_3;

	private User user;
	private String host;
	private String port;
	private String schema;
	private List<String> schemas;
	private JPAProvider jpaProvider = null;
	private Driver driver;
	private MYSQL_Database_Connector connector;
	
	private boolean canceled = false;

	public MddeDatabaseConnectionController(Driver driver) {
		
		this.driver = driver;
		this.connector = new MYSQL_Database_Connector(driver);
	}

	public MddeDatabaseConnectionController(User user, String host, String port, String schema) {
		super();
		this.user = user;
		this.host = host;
		this.port = port;
		this.schema = schema;
	}

	protected void testConnection(User user, String host, String port, String schema) {
		this.user = user;
		this.host = host;
		this.port = port;
		this.schema = schema;

		Job job = new Job("Test Connection") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Test Connection", monitor.UNKNOWN);

				if (connector.testConnection(user, host, port, schema))
					return new Status(Status.OK, "unknown", 1, "Connection Successful", null);
				else {

					return new Status(Status.ERROR, "unknown", 1, "Verbindung konnte nicht hergetsellt werden.",
							connector.getException());

				}
			}
		};

		job.addJobChangeListener(new CustomJobChangedListener() {

			@Override
			public void scheduled(IJobChangeEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void done(IJobChangeEvent event) {
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						MessageBox messageBox = new MessageBox(Display.getCurrent().getActiveShell());
						if (event.getResult().getSeverity() == Status.OK) {
							connectionWizardPage_1.setPageComplete(true);
							messageBox.setMessage("Connection Successful");
							messageBox.open();

						}

					}
				});

			}
		});

		job.schedule();
	}

	protected void getAvaillableSchemes() {
		Job job = new Job("Test Connection") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Load Schema", monitor.UNKNOWN);
				loadSchemas();

				if (schemas.size() > 0) {
					return new Status(Status.OK, "unknown", 1, "Connection Successful", null);
				}

				else {
					return new Status(Status.ERROR, "unknown", 1,
							"Es konnten keine Datanbank Schemata abgerufen werden.", null); // TODO Exception
				}
			}
		};

		job.addJobChangeListener(new CustomJobChangedListener() {

			@Override
			public void scheduled(IJobChangeEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void done(IJobChangeEvent event) {
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {

						if (event.getResult().getSeverity() == Status.OK) {
							mddeDatabaseModelConnectionWizardPage_2.fillSchemas(schemas);

						}

					}
				});

			}
		});

		job.schedule();

	}

	public EObject createModel() {
		DatabaseMetaData dmd = connector.getDatabaseMetaData(user, host, port, schema);
		MDDEModelCreator modelCreator = new MDDEModelCreator();

		EObject root = modelCreator.create(dmd, schema);

		return root;

	}

	private void loadSchemas() {
		schemas = connector.getAvailableSchemas(user, host, port, schema);
	}

	private void validateConfig(File file) {

		StreamSource source = new StreamSource(file);
		
		boolean result = XMLFileReader.validateAgainstConfigurationSchema(source);

		if (result) {
			System.out.println("Validated successfully");
			try {
				ReverseDatabaseModel rdm = XMLFileReader.loadConfiguration(file);
				connectionWizardPage_1.setHost(rdm.getHost());
				connectionWizardPage_1.setPort( rdm.getPort());
				connectionWizardPage_1.setUser( rdm.getUser());
				connectionWizardPage_1.setSchema(rdm.getSchema());
				if(rdm.getJpaProvider() != null) {
					//NOT Used
					//mddeDatabaseModelConnectionWizardPage_3.setJPAProvider(rdm.getJpaProvider());
				}
				
				
				
				
			} catch (ParserConfigurationException e) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(), Language.WIZARD_IMPORT_ERROR_HEADER, Language.WIZARD_IMPORT_CONFIG_ERROR);
				e.printStackTrace();
			} catch (SAXException e) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(), Language.WIZARD_IMPORT_ERROR_HEADER, Language.WIZARD_IMPORT_PARSE_ERROR);
				e.printStackTrace();
			} catch (IOException e) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(), Language.WIZARD_IMPORT_ERROR_HEADER, Language.WIZARD_IMPORT_CONFIG_ERROR);
				e.printStackTrace();
			}
		} else {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), Language.WIZARD_IMPORT_ERROR_HEADER, Language.WIZARD_IMPORT_CONFIG_ERROR);
		}

	}

	protected void selectConfigFile(File file) {
		validateConfig(file);

	}

	protected void selectConfigFile(String path) {
		validateConfig(new File(path));

	}
	
	protected void saveConfigFile(String filename) {
		if (!filename.endsWith(".xml")) {
			filename = filename + ".xml";
		}
		System.out.println(filename);
		ReverseDatabaseModel model = new ReverseDatabaseModel(this.host, this.user.getUsername(), this.schema, this.port, this.jpaProvider);
		XMLFileCreator.saveConfigurationFile(model, filename);
		
	}

	
	public boolean isSchemaSelected() {
		return connectionWizardPage_1.isSchemaSelected();
	}
	
	public void openConnectionUi() {
		Shell activeShell = Display.getCurrent().getActiveShell();
		MddeDatabaseConnectionModelWizard wizard = new MddeDatabaseConnectionModelWizard(this);
		WizardDialog dialog = new WizardDialog(activeShell, wizard);
		dialog.setBlockOnOpen(true);
		dialog.open();
		
		
		
	}
	

	// Getter and Setter

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public MddeDatabaseConnectionWizardPage_1 getConnectionWizardPage_1() {
		return connectionWizardPage_1;
	}

	public void setConnectionWizardPage_1(MddeDatabaseConnectionWizardPage_1 connectionWizardPage_1) {
		this.connectionWizardPage_1 = connectionWizardPage_1;
	}

	public MddeDatabaseModelConnectionWizardPage_2 getMddeDatabaseModelConnectionWizardPage_2() {
		return mddeDatabaseModelConnectionWizardPage_2;
	}

	public void setMddeDatabaseModelConnectionWizardPage_2(
			MddeDatabaseModelConnectionWizardPage_2 mddeDatabaseModelConnectionWizardPage_2) {
		this.mddeDatabaseModelConnectionWizardPage_2 = mddeDatabaseModelConnectionWizardPage_2;
	}
	
	
	public MddeDatabaseModelConnectionWizardPage_3 getMddeDatabaseModelConnectionWizardPage_3() {
		return mddeDatabaseModelConnectionWizardPage_3;
	}

	public void setMddeDatabaseModelConnectionWizardPage_3(
			MddeDatabaseModelConnectionWizardPage_3 mddeDatabaseModelConnectionWizardPage_3) {
		this.mddeDatabaseModelConnectionWizardPage_3 = mddeDatabaseModelConnectionWizardPage_3;
	}

	public void setJPAProvider(JPAProvider jpaProvider) {
		this.jpaProvider = jpaProvider; 
		
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
	



	
	

}
