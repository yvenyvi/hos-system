package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class Database {

    private static final String CONFIG_RESOURCE = "/database.properties";
    private static final Properties PROPERTIES = loadProperties();

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("MySQL JDBC driver not found", ex);
        }

        return DriverManager.getConnection(
                PROPERTIES.getProperty("db.url"),
                PROPERTIES.getProperty("db.user"),
                PROPERTIES.getProperty("db.password")
        );
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        properties.setProperty("db.url", "jdbc:mysql://localhost:3306/hso_database");
        properties.setProperty("db.user", "root");
        properties.setProperty("db.password", "password");

        try (InputStream inputStream = Database.class.getResourceAsStream(CONFIG_RESOURCE)) {
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Unable to read database configuration", ex);
        }

        return properties;
    }
}
