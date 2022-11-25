/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2022 DBeaver Corp and others
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

package de.thm.mdde.driver.runtime;




import de.thm.mdde.connection.model.Log;
import de.thm.mdde.connection.utils.GeneralUtils;
import de.thm.mdde.connection.utils.NotNull;
import de.thm.mdde.connection.utils.Nullable;
import de.thm.mdde.runtime.ui.DBPPlatformUI;

/**
 * Workbench
 */
public class DBWorkbench {

    private static final Log log = Log.getLog(DBWorkbench.class);

    private static final DBWorkbench instance = new DBWorkbench();

    private static volatile DBPPlatform platformInstance = null;
    private static volatile DBPPlatformUI platformUIInstance = null;

    public static DBPPlatform getPlatform() {
        if (platformInstance == null) {
        	//TODO
//            synchronized (DBWorkbench.class) {
//                if (platformInstance == null) {
//                    platformInstance = GeneralUtils.adapt(instance, DBPPlatform.class);
//                    if (platformInstance == null) {
//                        throw new IllegalStateException("Internal configuration error. Platform not instantiated.");
//                    }
//                }
//            }
        }
        return platformInstance;
    }

    public static <T extends DBPPlatform> T getPlatform(Class<T> pc) {
        return pc.cast(getPlatform());
    }

    public static DBPPlatformUI getPlatformUI() {
    	//TODO
//        if (platformUIInstance == null) {
//            synchronized (DBWorkbench.class) {
//                if (platformUIInstance == null) {
//                    if (getPlatform().getApplication().isHeadlessMode()) {
//                        return CONSOLE_USER_INTERFACE;
//                    }
//                    platformUIInstance = GeneralUtils.adapt(instance, DBPPlatformUI.class);
//                    if (platformUIInstance == null) {
//                        // Use console UI
//                        log.debug("No platform UI installed. Use console interface.");
//                        platformUIInstance = CONSOLE_USER_INTERFACE;
//                    }
//                }
//            }
//        }
        return platformUIInstance;
    }


    /**
     * Distributed platform.
     * All configurations and resources are stored on remote servers.
     */
    public static boolean isDistributed() {
        return getPlatform().getApplication().isDistributed();
    }

    public static boolean hasFeature(@NotNull String feature) {
        return getPlatform().getApplication().hasProductFeature(feature);
    }

}
