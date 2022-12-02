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

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import de.thm.connection.ui.DBPImage;
import de.thm.mdde.connection.model.DBException;
import de.thm.mdde.connection.model.DBPDriver;
import de.thm.mdde.connection.model.DBPDriverFileSource;
import de.thm.mdde.connection.model.DBPDriverLibrary;
import de.thm.mdde.driver.runtime.model.DBRProgressMonitor;

public class MySQLDriver implements DBPDriver{
	
	private List<DBPDriverLibrary> driverLibraries;

	@Override
	public String getName() {
		return "MySQL test driver";
	}

	@Override
	public String getId() {
		return "mysql8";
	}

	@Override
	public String getProviderId() {
		return null;
	}

	@Override
	public String getCategory() {
		return null;
	}

	@Override
	public List<String> getCategories() {
		return List.of("sql");
	}

	@Override
	public String getFullName() {
		return "MySQL";
	}

	@Override
	public String getDescription() {
		return "Driver for MySQL 8 and later";
	}

	@Override
	public DBPImage getIcon() {
		return null;
	}

	@Override
	public DBPImage getPlainIcon() {
		return null;
	}

	@Override
	public DBPImage getIconBig() {
		return null;
	}

	@Override
	public String getDriverClassName() {
		return "com.mysql.cj.jdbc.Driver";
	}

	@Override
	public String getDefaultHost() {
		return null;
	}

	@Override
	public String getDefaultPort() {
		return "3306";
	}

	@Override
	public String getDefaultDatabase() {
		return null;
	}

	@Override
	public String getDefaultServer() {
		return null;
	}

	@Override
	public String getDefaultUser() {
		return "root";
	}

	@Override
	public String getSampleURL() {
		return "jdbc:mysql://{host}[:{port}]/[{database}]";
	}

	@Override
	public String getWebURL() {
		return "https://www.mysql.com/products/connector/";
	}

	@Override
	public String getPropertiesWebURL() {
		return "https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-configuration-properties.html";
	}

	@Override
	public boolean isClientRequired() {
		return false;
	}

	@Override
	public boolean supportsDriverProperties() {
		return true;
	}

	@Override
	public boolean isEmbedded() {
		return false;
	}

	@Override
	public boolean isAnonymousAccess() {		
		return false;
	}

	@Override
	public boolean isAllowsEmptyPassword() {
		return false;
	}

	@Override
	public boolean isLicenseRequired() {
		return false;
	}

	@Override
	public boolean isCustomDriverLoader() {
		return false;
	}

	@Override
	public boolean isSampleURLApplicable() {
		return true;
	}

	@Override
	public boolean isCustomEndpointInformation() {
		return false;
	}

	@Override
	public boolean isSingleConnection() {
		return false;
	}

	@Override
	public boolean isInstantiable() {
		return true;
	}

	@Override
	public boolean isInternalDriver() {
		return false;
	}

	@Override
	public boolean isCustom() {
		return false;
	}

	@Override
	public boolean isTemporary() {
		return false;
	}

	@Override
	public boolean isDisabled() {
		return false;
	}

	@Override
	public DBPDriver getReplacedBy() {
		return null;
	}

	@Override
	public int getPromotedScore() {
		return 1;
	}

	@Override
	public Map<String, Object> getDefaultConnectionProperties() {
		// {@dbeaver-default-resultset.maxrows.sql=true, @dbeaver-default-resultset.format.datetime.native=true, rewriteBatchedStatements=true, enabledTLSProtocols=TLSv1,TLSv1.1,TLSv1.2, connectTimeout=20000, @dbeaver-default-dataformat.type.timestamp.pattern=yyyy-MM-dd HH:mm:ss}
		return new TreeMap<>();
	}

	@Override
	public Map<String, Object> getConnectionProperties() {
		return new TreeMap<>();
	}

	@Override
	public Map<String, Object> getDriverParameters() {
		return new TreeMap<>();
	}

	@Override
	public Object getDriverParameter(String name) {
		return null;
	}

	@Override
	public boolean isSupportedByLocalSystem() {
		return true;
	}

	@Override
	public String getLicense() {
		return null;
	}

	@Override
	public ClassLoader getClassLoader() {
		return null;
	}

	@Override
	public List<? extends DBPDriverLibrary> getDriverLibraries() {
		if(driverLibraries == null) {
			driverLibraries = List.of(new MySQLDriverLibrary());
		}
		return driverLibraries;
	}

	@Override
	public List<? extends DBPDriverFileSource> getDriverFileSources() {
		return List.of();
	}

	@Override
	public boolean needsExternalDependencies() {
		return false;
	}

	@Override
	public <T> T getDriverInstance(DBRProgressMonitor monitor) throws DBException {
		return null;
	}

	@Override
	public void loadDriver(DBRProgressMonitor monitor) throws DBException {
				
	}

	@Override
	public DBPDriver createOriginalCopy() {
		return null;
	}

}
