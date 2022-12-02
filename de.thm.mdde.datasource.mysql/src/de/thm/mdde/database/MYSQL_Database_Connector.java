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
package de.thm.mdde.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import de.thm.mdde.exception.NoSchemaFoundException;
import de.thm.mdde.language.Language;
import de.thm.mdde.model.User;

public class MYSQL_Database_Connector {

	private Exception exception = null;
	private ArrayList<String> schemas;
	private Driver driver;

	public MYSQL_Database_Connector(Driver driver) {
		this.driver = driver;
	}

	public boolean testConnection(User user, String host, String port, String schema) {

		Connection con = null;

		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionString = "";
			if (schema.equals("")) {
				connectionString = "jdbc:mysql://" + host + ":" + port
						+ "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			} else
				connectionString = "jdbc:mysql://" + host + ":" + port + "/" + schema
						+ "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
			
			Properties props = new Properties();
			props.put("user", user.getUsername());
			props.put("password", user.getPassword());
			
			con = driver.connect(connectionString, props);

			//con = DriverManager.getConnection(connectionString, user.getUsername(), user.getPassword());

			ResultSet rs = con.getMetaData().getCatalogs();

			schemas = new ArrayList<>();

			while (rs.next()) {
				schemas.add(rs.getString("TABLE_CAT"));
				System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT"));
			}

			if (schemas.size() == 0)
				throw new NoSchemaFoundException(Language.WIZARD_TEST_NOSCHEMA);
			con.close();
			return true;
		} catch (Exception e) {
			exception = e;
			System.out.println(e);
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public DatabaseMetaData getDatabaseMetaData(User user, String host, String port, String schema) {

		try {
			Connection con = createConnection(user, host, port, schema);

			DatabaseMetaData dbmd = con.getMetaData();

			return dbmd;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Connection createConnection(User user, String host, String port, String schema) {

		Connection con = null;

		try {
			String connectionString = "";
			connectionString = "jdbc:mysql://" + host + ":" + port + "/" + schema
					+ "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			Properties props = new Properties();
			props.put("user", user.getUsername());
			props.put("password", user.getPassword());
			
			con = driver.connect(connectionString, props);

			return con;

		} catch (Exception e) {
			exception = e;
			System.out.println(e);

		}
		return null;
	}

	public List<String> getAvailableSchemas(User user, String host, String port, String schema) {

		Connection con = null;

		try {
			String connectionString = "";
			connectionString = "jdbc:mysql://" + host + ":" + port + "/" + schema
					+ "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			Properties props = new Properties();
			props.put("user", user.getUsername());
			props.put("password", user.getPassword());
			
			con = driver.connect(connectionString, props);

			ResultSet rs = con.getMetaData().getCatalogs();

			schemas = new ArrayList<>();

			while (rs.next()) {
				schemas.add(rs.getString("TABLE_CAT"));
				System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT"));
			}

			if (schemas.size() == 0)
				throw new NoSchemaFoundException(Language.WIZARD_TEST_NOSCHEMA);
			con.close();
			return schemas;
		} catch (Exception e) {
			exception = e;
			System.out.println(e);

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return new ArrayList<String>();

	}

	public Exception getException() {
		return exception;
	}

}
