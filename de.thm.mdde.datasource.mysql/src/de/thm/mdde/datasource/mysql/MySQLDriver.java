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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBPImage getPlainIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBPImage getIconBig() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return new TreeMap<>();
	}

	@Override
	public Map<String, Object> getDriverParameters() {
		// TODO Auto-generated method stub
		return new TreeMap<>();
	}

	@Override
	public Object getDriverParameter(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSupportedByLocalSystem() {
		return true;
	}

	@Override
	public String getLicense() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassLoader getClassLoader() {
		return null;
	}

	@Override
	public List<? extends DBPDriverLibrary> getDriverLibraries() {
		// TODO Auto-generated method stub
		return List.of(new MySQLDriverLibrary());
	}

	@Override
	public List<? extends DBPDriverFileSource> getDriverFileSources() {
		return List.of();
	}

	@Override
	public boolean needsExternalDependencies() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T getDriverInstance(DBRProgressMonitor monitor) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadDriver(DBRProgressMonitor monitor) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DBPDriver createOriginalCopy() {
		// TODO Auto-generated method stub
		return null;
	}

}
