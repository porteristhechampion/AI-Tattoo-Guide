package edu.matc.entjava.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;

public class Database implements PropertiesLoader {

    private static final Logger logger = LogManager.getLogger(Database.class);

    private static Database instance = new Database();

    private Properties properties;
    private Connection connection;

    private Database() {
        loadProperties();
    }

    private void loadProperties() {
        properties = loadProperties("/database.properties");
    }

    public static Database getInstance() {return instance;}

    public Connection getConnection() {return connection;}

    public void connect() throws Exception{
        if (connection != null)
            return;

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException classNotFoundException) {
            throw new Exception("Error: MySQL Driver not found:" + classNotFoundException);
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("user"), properties.getProperty("password"));
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                logger.error("Connection can't be closed: " + sqlException);
            }
        }

        connection = null;
    }

}
