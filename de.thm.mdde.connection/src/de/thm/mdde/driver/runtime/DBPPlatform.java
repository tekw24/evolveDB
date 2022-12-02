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

import java.io.IOException;
import java.nio.file.Path;

import de.thm.mdde.app.model.DBPApplication;
import de.thm.mdde.connection.model.preferences.DBPPreferenceStore;
import de.thm.mdde.connection.utils.NotNull;
import de.thm.mdde.driver.runtime.model.DBRProgressMonitor;

/**
 * DBPPlatform
 */
public interface DBPPlatform {

    @NotNull
    DBPApplication getApplication();

    @NotNull
    DBPPreferenceStore getPreferenceStore();

    @NotNull
    Path getTempFolder(DBRProgressMonitor monitor, String name) throws IOException;
    

    /**
     * Local config files are used to store some configuration specific to local machine only.
     */
    @NotNull
    Path getLocalConfigurationFile(String fileName);



    @Deprecated
    @NotNull
    Path getApplicationConfiguration();

    boolean isShuttingDown();

}
