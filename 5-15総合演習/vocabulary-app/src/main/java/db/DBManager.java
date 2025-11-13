package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

    private static final String HOST = "localhost";          
    private static final String PORT = "5432";               
    private static final String DB_NAME = "vocabulary_db";   
    private static final String USER = "postgres";           
    private static final String PASS = "CYV94XpcfV";         

    public Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DB_NAME;
        return DriverManager.getConnection(url, USER, PASS);
    }
}
