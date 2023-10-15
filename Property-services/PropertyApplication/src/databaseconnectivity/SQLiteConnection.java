// /home/dylan/Desktop/SQLite
package databaseconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    private String database;
    private Connection connection;

    public SQLiteConnection(String database) {
        this.database = database;
    }

    public Connection connectToDatabase() throws SQLException {
        if (connection != null) {
            return connection; // Utiliser la connexion existante si elle existe.
        }

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + database+".db";
            connection = DriverManager.getConnection(url);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new SQLException("Le pilote JDBC SQLite n'a pas pu être chargé.");
        }
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}

