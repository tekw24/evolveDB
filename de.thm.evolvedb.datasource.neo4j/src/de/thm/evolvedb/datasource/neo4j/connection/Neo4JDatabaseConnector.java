package de.thm.evolvedb.datasource.neo4j.connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
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
		String connectionString = "jdbc:neo4j://"+host+":"+port; // Oder z. B. bolt://localhost:7687
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
        } catch (Exception e) {
            e.printStackTrace();
            exception = e;
            return false;
        }
		return false;
	}

	public Throwable getException() {
		return exception;
	}
	
	

	public Connection createConnection(User user, String host, String port) {

		Connection con = null;

		try {
			String connectionString = "";
			connectionString = "jdbc:neo4j://"+host+":"+port;

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



}
