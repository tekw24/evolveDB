package de.thm.mdde.datasource.mysql;

import de.thm.mdde.connection.model.DBPDriver;
import de.thm.mdde.connection.model.DBPDriverDependencies;
import de.thm.mdde.datasource.EDBDataSource;
import org.eclipse.swt.graphics.Image;

public class EDBMySQLDataSource implements EDBDataSource{
	
	
	private MySQLDriver driver;
	private MySQLDriverDependencies dependencies;
	
	
	public EDBMySQLDataSource() {
		driver = new MySQLDriver();
		dependencies = new MySQLDriverDependencies(driver);
	}

	@Override
	public String getName() {
		return "MySQL JDBC DataSource";
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBPDriver getDriver() {
		return driver;
	}

	@Override
	public DBPDriverDependencies getDriverDependencies() {
		return dependencies;
	}

}
