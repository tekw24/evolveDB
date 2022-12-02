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
package de.thm.mdde.datasource.mysql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import de.thm.connection.ui.DBIcon;
import de.thm.mdde.connection.model.DBPAuthInfo;
import de.thm.mdde.connection.model.DBPDriverLibrary;
import de.thm.mdde.connection.utils.Nullable;
import de.thm.mdde.driver.runtime.WebUtils;
import de.thm.mdde.driver.runtime.model.DBRProgressMonitor;
import de.thm.mdde.preferences.PreferencesUtil;

public class MySQLDriverLibrary implements DBPDriverLibrary {

	private String version = "8.0.29";

	@Override
	public String getDisplayName() {
		return "mysql:mysql-connector-java:RELEASE";
	}

	@Override
	public String getId() {
		return "mysql:mysql-connector-java:RELEASE";
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public DBIcon getIcon() {
		return null;
	}

	@Override
	public FileType getType() {
		return FileType.jar;
	}

	@Override
	public String getPath() {
		return "maven:/mysql:mysql-connector-java:RELEASE";
	}

	@Override
	public String getDescription() {
		return "No description";
	}

	@Override
	public boolean isOptional() {
		return false;
	}

	@Override
	public boolean isCustom() {
		return false;
	}

	@Override
	public boolean isDisabled() {
		return false;
	}

	@Override
	public void setDisabled(boolean disabled) {
		
	}

	@Override
	public boolean isDownloadable() {
		return true;
	}

	@Override
	public String getExternalURL(DBRProgressMonitor monitor) {
		return "https://repo1.maven.org/maven2/mysql/mysql-connector-java/" + version + "/mysql-connector-java-"
				+ version + ".jar";
	}

	@Override
	public String getLocalFile() {
		String path = PreferencesUtil.getDriverPath();
//		if (path.lastIndexOf("/") == path.length() - 1)
//			return path + "mysql/mysql-connector-java-" + version + ".jar";
//		else
//			return path + "/mysql/mysql-connector-java-" + version + ".jar";
		if (path.lastIndexOf("/") == path.length() - 1)
			return path + "mysql/mysql-connector-java-%s.jar";
		else
			return path + "/mysql/mysql-connector-java-%s.jar";
	}

	@Override
	public boolean matchesCurrentPlatform() {
		return false;
	}

	@Override
	public Collection<? extends DBPDriverLibrary> getDependencies(DBRProgressMonitor monitor) throws IOException {
		return null;
	}

	@Override
	public void downloadLibraryFile(DBRProgressMonitor monitor, boolean forceUpdate, String taskName)
			throws IOException, InterruptedException {
		String path = getLocalFile();
		path = String.format(path, getPreferredVersion());
		final Path localFile = Path.of(path);
		if (localFile == null) {
			throw new IOException("No target file for '" + getPath() + "'");
		}
		if (!forceUpdate && Files.exists(localFile) && Files.size(localFile) > 0) {
			return;
		}
		final Path localDir = localFile.getParent();
		if (!Files.exists(localDir)) {
			Files.createDirectories(localDir);
		}

		String externalURL = getExternalURL(monitor);
		if (externalURL == null) {
			throw new IOException("Unresolved file reference: " + getPath());
		}

		WebUtils.downloadRemoteFile(monitor, taskName, externalURL, localFile, getAuthInfo(monitor));

	}

	@Nullable
	protected DBPAuthInfo getAuthInfo(DBRProgressMonitor monitor) {
		return new DBPAuthInfo(null, null, false);
	}

	@Override
	public Collection<String> getAvailableVersions(DBRProgressMonitor monitor) {
		return List.of("8.0.31", "8.0.30", "8.0.29", "8.0.28");

	}

	@Override
	public String getPreferredVersion() {
		return version;
	}

	@Override
	public void setPreferredVersion(String version) {
		this.version = version;

	}

	@Override
	public void resetVersion() {
		this.version = "8.0.29";

	}

	@Override
	public boolean isSecureDownload(DBRProgressMonitor monitor) {
		return true;
	}

}
