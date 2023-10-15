package databaseconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
    String database;
    String user;
    String password;
    String url;

    public MysqlConnection(String database, String user, String password, String url) {
        this.database = database;
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public Connection connectToDatabase() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(getUrl() + getDatabase(), getUser(), getPassword());
        return con;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
