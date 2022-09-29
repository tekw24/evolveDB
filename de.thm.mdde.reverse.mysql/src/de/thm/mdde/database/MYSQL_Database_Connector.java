package de.thm.mdde.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import de.thm.mdde.exception.NoSchemaFoundException;
import de.thm.mdde.language.Language;
import de.thm.mdde.model.User;

public class MYSQL_Database_Connector {

	private Exception exception = null;
	private ArrayList<String> schemas;

	public boolean testConnection(User user, String host, String port, String schema) {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionString = "";
			if (schema.equals("")) {
				connectionString = "jdbc:mysql://" + host + ":" + port
						+ "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			} else
				connectionString = "jdbc:mysql://" + host + ":" + port + "/" + schema
						+ "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			con = DriverManager.getConnection(connectionString, user.getUsername(), user.getPassword());

			ResultSet rs = con.getMetaData().getCatalogs();

			schemas = new ArrayList<>();

			while (rs.next()) {
				schemas.add(rs.getString("TABLE_CAT"));
				System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT"));
			}

			if (schemas.size() == 0)
				throw new NoSchemaFoundException(Language.WIZARD_TEST_NOSCHEMA);
			// here sonoo is database name, root is username and password
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from emp");
//			while (rs.next())
//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
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
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionString = "";
			connectionString = "jdbc:mysql://" + host + ":" + port + "/" + schema
					+ "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			con = DriverManager.getConnection(connectionString, user.getUsername(), user.getPassword());

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
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionString = "";
			connectionString = "jdbc:mysql://" + host + ":" + port + "/" + schema
					+ "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			con = DriverManager.getConnection(connectionString, user.getUsername(), user.getPassword());

			ResultSet rs = con.getMetaData().getCatalogs();

			schemas = new ArrayList<>();

			while (rs.next()) {
				schemas.add(rs.getString("TABLE_CAT"));
				System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT"));
			}

			if (schemas.size() == 0)
				throw new NoSchemaFoundException(Language.WIZARD_TEST_NOSCHEMA);
			// here sonoo is database name, root is username and password
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from emp");
//			while (rs.next())
//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
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
