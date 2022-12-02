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
package de.thm.mdde.datasource.mysql;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Driver;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;

import de.thm.mdde.connection.model.DBPDriver;
import de.thm.mdde.connection.model.DBPDriverDependencies;
import de.thm.mdde.connection.model.DBPDriverLibrary;
import de.thm.mdde.datasource.EDBDataSource;
import de.thm.mdde.wizard.MddeDatabaseConnectionController;

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
		DBPDriverLibrary library = getDriver().getDriverLibraries().get(0);
		
		String path = library.getLocalFile();
		path = String.format(path, library.getPreferredVersion());

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
