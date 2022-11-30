package de.thm.mdde.preferences;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class PreferencesUtil {
	
	
	public static String getDriverPath() {
		ScopedPreferenceStore scopedPreferenceStore = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"de.thm.mdde.preferences");
		String location = scopedPreferenceStore.getString(EDBPreferenceInitializer.DRIVER_DEFAULT_LOCATION);

		return location;
		
	}

}
