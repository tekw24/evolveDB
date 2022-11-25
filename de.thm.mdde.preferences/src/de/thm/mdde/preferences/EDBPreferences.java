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
	


