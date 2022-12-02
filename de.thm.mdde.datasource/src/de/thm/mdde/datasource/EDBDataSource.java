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
package de.thm.mdde.datasource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

import de.thm.mdde.connection.model.DBPDriver;
import de.thm.mdde.connection.model.DBPDriverDependencies;

public interface EDBDataSource {
	
	/**
	 * Datasource name
	 * @return the name of the datasource
	 */
	String getName();
	
	
	/**
	 * Connection icon
	 * @return Database Icon
	 */
	Image getImage();
	
	
	/**
	 * DBPDriver class
	 * @return Driver class
	 */
	DBPDriver getDriver();
	
	
	
	/**
	 * DBPDriverDependencies 
	 * @return the corresponding driver dependencies
	 */
	DBPDriverDependencies getDriverDependencies();
	
	
	/**
	 * The UI for entering the connection details.
	 * @return
	 */
	void openConnectionUi();
	
	
	/**
	 * Returns the root element of the newly created model;
	 * @return
	 */
	EObject getRootObject();
	
	
	/**
	 * Returns true if the user left the wizard via the cancel button.
	 * @return
	 */
	boolean isCanceled();
	
	

}
