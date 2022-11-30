package de.thm.mdde.datasource.mysql;

import de.thm.mdde.connection.model.DBPDriver;
import de.thm.mdde.connection.model.DBPDriverDependencies;
import de.thm.mdde.datasource.EDBDataSource;
import de.thm.mdde.wizard.MddeDatabaseConnectionController;
import de.thm.mdde.wizard.MddeDatabaseConnectionModelWizard;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;

public class EDBMySQLDataSource implements EDBDataSource {

	private MySQLDriver driver;
	private MySQLDriverDependencies dependencies;
	private INewWizard wizardDialog;
	private MddeDatabaseConnectionController connectionController;

	public EDBMySQLDataSource() {
		driver = new MySQLDriver();
		dependencies = new MySQLDriverDependencies(driver);
	}

	@Override
	public String getName() {
		return "MySQL JDBC DataSource";
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBPDriver getDriver() {
		return driver;
	}

	@Override
	public DBPDriverDependencies getDriverDependencies() {
		return dependencies;
	}

	@Override
	public void openConnectionUi() {
		
		Driver driver = loadDriverClass();
		if (driver != null) {
			connectionController = new MddeDatabaseConnectionController(driver);
			connectionController.openConnectionUi();
		} else {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "The driver class could not be loaded", "EvolveDB was not able to load the driver class from the file system. ");
		}

	}

	@Override
	public EObject getRootObject() {
		return connectionController.createModel();
	}

	private Driver loadDriverClass() {

		String path = getDriver().getDriverLibraries().get(0).getLocalFile();
		Path localFile = Paths.get(path);

		if (Files.exists(localFile)) {

			URLClassLoader child;
			try {
				child = new URLClassLoader(new URL[] { localFile.toUri().toURL() }, this.getClass().getClassLoader());

				Class classToLoad = Class.forName(getDriver().getDriverClassName(), true, child);

				Driver driver = (Driver) classToLoad.newInstance();

				return driver;

			} catch (MalformedURLException | ClassNotFoundException | SecurityException | IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;

	}

	@Override
	public boolean isCanceled() {
		return connectionController.isCanceled();
	}

}
