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
package de.thm.mdde.preferences;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

public class EDBPreferences {
	
	
	public static void initPreferences() {
		
		// We access the instanceScope
		Preferences preferences = InstanceScope.INSTANCE.getNode("de.thm.mdde.preferences");

		Preferences sub1 = preferences.node("node1");
		Preferences sub2 = preferences.node("node2");
		sub1.put("h1", "Hello");
		sub1.put("h2", "Hello again");
		sub2.put("h1", "Moin");
		try {
		    // forces the application to save the preferences
		    preferences.flush();
		    } catch (BackingStoreException e) {
		        e.printStackTrace();
		    }
		}
	
	
	
	
	}
	


