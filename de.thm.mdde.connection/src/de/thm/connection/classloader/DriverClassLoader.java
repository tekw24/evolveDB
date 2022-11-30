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

package de.thm.connection.classloader;


import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import de.thm.mdde.connection.model.DBPDriverLibrary;
import de.thm.mdde.connection.utils.CommonUtils;

/**
 * DriverClassLoader
 */
public class DriverClassLoader extends URLClassLoader
{
    private List<? extends DBPDriverLibrary> libraries;

    public DriverClassLoader(List<? extends DBPDriverLibrary> libraries, URL[] urls, ClassLoader parent)
    {
        super(urls, parent);
        this.libraries = libraries;
    }

    @Override
    protected String findLibrary(String libname)
    {
        String nativeName = System.mapLibraryName(libname);
        for (DBPDriverLibrary driverFile : libraries) {
            if (driverFile.getType() == DBPDriverLibrary.FileType.lib && driverFile.matchesCurrentPlatform()) {
            	String path = driverFile.getLocalFile();
        		path = String.format(path, driverFile.getPreferredVersion());
                Path localFile = Path.of(path);
//                if (localFile == null) {
//                    // Check library files cache
//                    List<DriverDescriptor.DriverFileInfo> cachedFiles = driver.getCachedFiles(driverFile);
//                    if (!CommonUtils.isEmpty(cachedFiles)) {
//                        for (DriverDescriptor.DriverFileInfo fileInfo : cachedFiles) {
//                            if (fileInfo.getFile() != null && fileInfo.getFile().getFileName().toString().equalsIgnoreCase(nativeName)) {
//                                return fileInfo.getFile().toAbsolutePath().toString();
//                            }
//                        }
//                    }
//                }
                if (localFile != null && Files.exists(localFile)) {
                    if (Files.isDirectory(localFile)) {
                        localFile = localFile.resolve(nativeName);
                    }
                    if (localFile.getFileName().toString().equalsIgnoreCase(nativeName)) {
                        return localFile.toAbsolutePath().toString();
                    }
                }
            }
        }
        return super.findLibrary(libname);
    }
}
