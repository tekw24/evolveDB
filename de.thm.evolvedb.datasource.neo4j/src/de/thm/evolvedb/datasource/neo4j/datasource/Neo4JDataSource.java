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

/**
 * 
 */
package de.thm.evolvedb.datasource.neo4j.datasource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Driver;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import de.thm.evolvedb.datasource.neo4j.connection.Neo4JDatabaseConnectionController;
import de.thm.evolvedb.graph.presentation.GraphEditorPlugin;
import de.thm.mdde.connection.model.DBPDriver;
import de.thm.mdde.connection.model.DBPDriverDependencies;
import de.thm.mdde.connection.model.DBPDriverLibrary;
import de.thm.mdde.datasource.EDBDataSource;

/**
 * @author Torben
 *
 */
public class Neo4JDataSource implements EDBDataSource {

	private Neo4JDriverDB driver;
	private Neo4jDriverDependencies dependencies;
	private Neo4JDatabaseConnectionController connectionController;

	public Neo4JDataSource() {
		driver = new Neo4JDriverDB();
		dependencies = new Neo4jDriverDependencies(driver);
	}

	@Override
	public String getName() {
		return "MySQL Neo4J DataSource";
	}

	@Override
	public Image getImage() {

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
			connectionController = new Neo4JDatabaseConnectionController(driver);
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

				Class<?> classToLoad = Class.forName(getDriver().getDriverClassName(), true, child);
			
				Constructor<?> constructor = classToLoad.getDeclaredConstructor();  // <- statt getConstructor()
				constructor.setAccessible(true);  // <- wichtig bei nicht-öffentlichen Konstruktoren

				Driver driver = (Driver) constructor.newInstance();
				return driver;
				
				
				//URLClassLoader cl = new URLClassLoader(new URL[] { localFile.toUri().toURL() });
				
				
//				Class<?> clazz = Class.forName(getDriver().getDriverClassName(), true, child);
//				System.out.println("Lade Klasse: " + clazz.getName());
//
//				Constructor<?>[] allConstructors = clazz.getDeclaredConstructors();
//				for (Constructor<?> c : allConstructors) {
//				    System.out.println("Gefundener Konstruktor: " + c);
//				}
				
				
				
				
//				ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class, child);
//				Driver driver = null;
//				for (Driver d : loader) {
//				    System.out.println("Gefundener JDBC-Treiber: " + d.getClass().getName());
//				    if(d.getClass().getName().equals(getDriver().getDriverClassName()))
//				    	driver = d;
//				}
				
			
			

			} catch (MalformedURLException | SecurityException | IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
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

	@Override
	public List<String> getFileExtensions() {
		return Collections.unmodifiableList(
				Arrays.asList(GraphEditorPlugin.INSTANCE.getString("_UI_GraphEditorFilenameExtensions").split("\\s*,\\s*")));
	}


}
