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

import org.eclipse.core.runtime.Plugin;

import de.thm.mdde.app.model.DBPApplication;
import de.thm.mdde.connection.model.preferences.DBPPreferenceStore;
import de.thm.mdde.connection.utils.NotNull;
import de.thm.mdde.driver.runtime.model.DBRProgressMonitor;

import java.io.IOException;
import java.nio.file.Path;

/**
 * DBPPlatform
 */
public interface DBPPlatform {

    @NotNull
    DBPApplication getApplication();

  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBPWorkspace getWorkspace();
    */
    
  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBNModel getNavigatorModel();
    /*
    
  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBPDataSourceProviderRegistry getDataSourceProviderRegistry();
    */

  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    OSDescriptor getLocalSystem();
    */

    /**
     * Returns global QM registry
     */
  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    QMRegistry getQueryManager();
    */

  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBDRegistry getValueHandlerRegistry();
    */

  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBERegistry getEditorsRegistry();
    */

  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBFRegistry getFileSystemRegistry();
    */

    @NotNull
    DBPPreferenceStore getPreferenceStore();

  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBACertificateStorage getCertificateStorage();
    */

    @NotNull
    Path getTempFolder(DBRProgressMonitor monitor, String name) throws IOException;

    /**
     * Returns platform configuration controller,
     * which keeps configuration which can be shared with other users.
     */
  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBConfigurationController getConfigurationController();
    */
    
    /**
     * Returns configuration controller,
     * which keeps product configuration which can be shared with other users.
     */
  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBConfigurationController getProductConfigurationController();
    */
    
    /**
     * Returns configuration controller,
     * which keeps plugin configuration which can be shared with other users.
     */
  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBConfigurationController getPluginConfigurationController(@NotNull String pluginId);
    */

    /**
     * Local config files are used to store some configuration specific to local machine only.
     */
    @NotNull
    Path getLocalConfigurationFile(String fileName);

    /**
     * File controller allows to read/write binary files (e.g. custom driver libraries)
     */
  //TODO NOTUsed
    /*
    @NotNull
    @NotNull
    DBFileController getFileController();
    */

    /**
     * Task controller can read and change tasks configuration file
     */
    //TODO NOTUsed
    /*
    @NotNull
    DBTTaskController getTaskController();
    */

    @Deprecated
    @NotNull
    Path getApplicationConfiguration();

    boolean isShuttingDown();

}
