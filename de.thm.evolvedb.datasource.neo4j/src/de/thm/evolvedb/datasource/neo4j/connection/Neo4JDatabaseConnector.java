package de.thm.evolvedb.datasource.neo4j.connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Neo4JDatabaseConnector {

	private Exception exception = null;
	private Driver driver;

	public Neo4JDatabaseConnector(Driver driver) {
		this.driver = driver;
	}

	public boolean testConnection(User user, String host, String port) {
		String connectionString = "jdbc:neo4j://" + host + ":" + port; // Oder z. B. bolt://localhost:7687
		Connection connection = null;

		try {

			Properties props = new Properties();
			props.put("user", user.getUsername());
			props.put("password", user.getPassword());

			connection = driver.connect(connectionString, props);

			// Verbindung aufbauen

			System.out.println("Verbindung zu Neo4j erfolgreich hergestellt!");

			// Einfaches Statement ausführen
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("MATCH (n) RETURN n LIMIT 5");

			// Ergebnisse anzeigen
			while (resultSet.next()) {
				Object node = resultSet.getObject("n");
				System.out.println("Gefundener Knoten: " + node);
				return true;
			}

			// Ressourcen schließen
			resultSet.close();
			statement.close();
			connection.close();
			// If the result set is empty
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			exception = e;
			return false;
		}

	}

	public boolean testConnection(User user, String host, String port,
			String database /* z.B. "neo4j" oder "movies" */) {
		// 1) JDBC-URL bauen
		// - mit DB: jdbc:neo4j://host:port/database
		// - ohne DB: jdbc:neo4j://host:port (dann nimmt Neo4j die Default-DB, meist
		// "neo4j")
		String baseUrl = "jdbc:neo4j://" + host + ":" + port;
		String url = (database != null && !database.isBlank()) ? baseUrl + "/" + database : baseUrl;

		Properties props = new Properties();
		props.put("user", user.getUsername());
		props.put("password", user.getPassword());
		// Optional, je nach Setup (Aura/SSL/etc. – nur wenn dein Treiber/Cluster das
		// braucht):
		// props.put("encryption", "true");
		// props.put("trustStrategy", "TRUST_ALL_CERTIFICATES");

		try (Connection conn = driver.connect(url, props);
				PreparedStatement ps = conn.prepareStatement("RETURN 1 AS ok");
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				int ok = rs.getInt("ok");
				System.out.println("Verbindung ok, RETURN 1 -> " + ok);
				return ok == 1;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Throwable getException() {
		return exception;
	}

	public Connection createConnection(User user, String host, String port, String dbName) {

		Connection con = null;

		try {
//			String connectionString = "";
//			connectionString = "jdbc:neo4j://"+host+":"+port;

			String connectionString = "jdbc:neo4j://" + host + ":" + port;
			String url = (dbName != null && !dbName.isBlank()) ? connectionString + "/" + dbName : connectionString;

			Properties props = new Properties();
			props.put("user", user.getUsername());
			props.put("password", user.getPassword());

			con = driver.connect(url, props);

			return con;

		} catch (Exception e) {
			exception = e;
			System.out.println(e);

		}
		return null;
	}

}
