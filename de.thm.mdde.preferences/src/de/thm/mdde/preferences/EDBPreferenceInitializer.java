package de.thm.mdde.preferences;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.osgi.service.datalocation.Location;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class EDBPreferenceInitializer extends AbstractPreferenceInitializer {
	
	
	public final static String DRIVER_DEFAULT_LOCATION = "Driver_Default_Location";

    public EDBPreferenceInitializer() {
    }

    @Override
    public void initializeDefaultPreferences() {
    	
    	Location location = Platform.getInstanceLocation();    	
        ScopedPreferenceStore scopedPreferenceStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "de.thm.mdde.preferences");
        scopedPreferenceStore.setDefault(DRIVER_DEFAULT_LOCATION, location.getURL().getPath() + "driver/");
    
    }

}
