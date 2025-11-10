package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    public Connection getConnection() throws Exception {
        String host = System.getenv("VOCAB_DB_HOST");
        String port = System.getenv("VOCAB_DB_PORT");
        String name = System.getenv("VOCAB_DB_NAME");
        String user = System.getenv("VOCAB_DB_USER");
        String pass = System.getenv("VOCAB_DB_PASS");
        String url  = "jdbc:postgresql://" + host + ":" + port + "/" + name;
        return DriverManager.getConnection(url, user, pass);
    }
}
