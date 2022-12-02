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
        String path = location.getURL().getPath() + "driver/";
        path = path != null ? path.substring(1) : null;
        
        scopedPreferenceStore.setDefault(DRIVER_DEFAULT_LOCATION,path );
    
    }

}
