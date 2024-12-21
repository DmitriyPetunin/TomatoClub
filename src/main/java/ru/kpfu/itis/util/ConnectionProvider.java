package ru.kpfu.itis.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.exception.DbException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConnectionProvider {
    private static ConnectionProvider _instance;
    private Connection con;
    public static ConnectionProvider getInstance() throws DbException {
        if (_instance == null){
            _instance = new ConnectionProvider();
        }
        return _instance;
    }

    public Connection getCon() {
        String PROD_DB_HOST = System.getenv(  "PROD_DB_HOST");
        String PROD_DB_PORT = System. getenv(  "PROD_DB_PORT");
        String PROD_DB_PASSWORD = System.getenv (  "PROD_DB_PASSWORD");
        String PROD_DB_NAME = System. getenv(  "PROD_DB_NAME");
        String PROD_DB_USERNAME = System.getenv(  "PROD_DB_USERNAME");
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:postgresql://%s:%s/%s".formatted(PROD_DB_HOST,PROD_DB_PORT,PROD_DB_NAME),
                    PROD_DB_USERNAME,
                    PROD_DB_PASSWORD
            );

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
