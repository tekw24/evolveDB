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

package de.thm.mdde.connection.model;


import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import de.thm.connection.ui.DBIcon;
import de.thm.mdde.connection.utils.NotNull;
import de.thm.mdde.connection.utils.Nullable;
import de.thm.mdde.driver.runtime.model.DBRProgressMonitor;

/**
 * Driver library
 */
public interface DBPDriverLibrary {

    /**
     * Driver file type
     */
    enum FileType {
        jar,
        lib,
        executable,
        license
    }

    @NotNull
    String getDisplayName();

    /**
     * Library native id.
     * Id doesn't include version information so the same libraries with different versions have the same id.
     */
    String getId();

    /**
     * Library version. If library doesn't support versions returns null.
     */
    @Nullable
    String getVersion();

    @NotNull
    DBIcon getIcon();

    @NotNull
    FileType getType();

    /**
     * Native library URI.
     * Could be a file path or maven artifact references or anything else.
     */
    @NotNull
    String getPath();

    @Nullable
    String getDescription();

    boolean isOptional();

    boolean isCustom();

    boolean isDisabled();

    void setDisabled(boolean disabled);

    boolean isDownloadable();

    @Nullable
    String getExternalURL(DBRProgressMonitor monitor);

    @Nullable
    String getLocalFile();

    boolean matchesCurrentPlatform();

    @Nullable
    Collection<? extends DBPDriverLibrary> getDependencies(@NotNull DBRProgressMonitor monitor) throws IOException;

    void downloadLibraryFile(@NotNull DBRProgressMonitor monitor, boolean forceUpdate, String taskName)
        throws IOException, InterruptedException;

    @NotNull
    Collection<String> getAvailableVersions(DBRProgressMonitor monitor);

    String getPreferredVersion();

    void setPreferredVersion(String version);

    void resetVersion();

    boolean isSecureDownload(DBRProgressMonitor monitor);

}
