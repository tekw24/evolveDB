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


import de.thm.mdde.driver.runtime.model.DBRProgressMonitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver library dependencies
 */
public interface DBPDriverDependencies
{
    class DependencyNode {
        public final DependencyNode owner;
        public final DBPDriverLibrary library;
        public final List<DependencyNode> dependencies = new ArrayList<>();
        public final int depth;
        public boolean duplicate;

        public DependencyNode(DependencyNode owner, DBPDriverLibrary library) {
            this.owner = owner;
            this.library = library;
            this.depth = owner == null ? 0 : owner.depth + 1;
        }

        @Override
        public String toString() {
            return library.getPath();
        }
    }

    List<DependencyNode> getLibraryList();

    List<DependencyNode> getLibraryMap();

    void resolveDependencies(DBRProgressMonitor monitor) throws DBException;
}