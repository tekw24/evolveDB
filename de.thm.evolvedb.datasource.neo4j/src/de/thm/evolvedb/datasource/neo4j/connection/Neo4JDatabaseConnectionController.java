package de.thm.evolvedb.datasource.neo4j.connection;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import de.thm.evolvedb.datasource.neo4j.model.Neo4jModelCreator;
import de.thm.evolvedb.datasource.neo4j.ui.Neo4jDatabaseConnectionWizard;
import de.thm.evolvedb.datasource.neo4j.ui.Neo4jDatabaseConnectionWizardPage_1;


public class Neo4JDatabaseConnectionController {
	
	private Driver driver;
	private Neo4JDatabaseConnector connector;
	private boolean canceled = false;
	
	private Neo4jDatabaseConnectionWizardPage_1 connectionWizardPage_1;
	
	private User user;
	private String host;
	private String port;

	public Neo4JDatabaseConnectionController(Driver driver) {

		this.driver = driver;
		this.connector = new Neo4JDatabaseConnector(driver);
	}

	public EObject createModel() {
		Connection con = connector.createConnection(user, host, port);
		Neo4jModelCreator modelCreator = new Neo4jModelCreator();

		EObject root = modelCreator.create(con);

		return root;
	}

	public void openConnectionUi() {
		Shell activeShell = Display.getCurrent().getActiveShell();
		Neo4jDatabaseConnectionWizard wizard = new Neo4jDatabaseConnectionWizard(this);
		WizardDialog dialog = new WizardDialog(activeShell, wizard);
		dialog.setBlockOnOpen(true);
		dialog.open();
		
	}
	
	public void saveConfigFile(String filename) {
		// TODO Auto-generated method stub
		
	}
	
	public void selectConfigFile(File file) {
		// TODO Auto-generated method stub
		
	}
	
	public void selectConfigFile(String selected) {
		// TODO Auto-generated method stub
		
	}
	
	public void testConnection(User user, String host, String port) {
		this.user = user;
		this.host = host;
		this.port = port;
		//this.schema = schema;

		Job job = new Job("Test Connection") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Test Connection", monitor.UNKNOWN);

				if (connector.testConnection(user, host, port))
					return new Status(Status.OK, "unknown", 1, "Connection Successful", null);
				else {

					return new Status(Status.ERROR, "unknown", 1, "Verbindung konnte nicht hergetsellt werden.",
							connector.getException());

				}
			}
		};

		job.addJobChangeListener(new de.thm.evolvedb.datasource.util.CustomJobChangedListener() {

			@Override
			public void scheduled(IJobChangeEvent event) {
			

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

	

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

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

	public Neo4jDatabaseConnectionWizardPage_1 getConnectionWizardPage_1() {
		return connectionWizardPage_1;
	}

	public void setConnectionWizardPage_1(Neo4jDatabaseConnectionWizardPage_1 connectionWizardPage_1) {
		this.connectionWizardPage_1 = connectionWizardPage_1;
	}

	






	
	
	

}
