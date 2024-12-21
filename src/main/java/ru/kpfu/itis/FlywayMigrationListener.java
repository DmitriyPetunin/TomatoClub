package ru.kpfu.itis;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;

@Slf4j
@WebListener
public class FlywayMigrationListener implements ServletContextListener {
    //private static final String URL_KEY = "db.url";
    private static final String PROD_DB_HOST = System.getenv(  "PROD_DB_HOST");
    private static final String PROD_DB_PORT = System. getenv(  "PROD_DB_PORT");
    private static final String PROD_DB_NAME = System. getenv(  "PROD_DB_NAME");
    private static final String USERNAME_KEY = "PROD_DB_USERNAME";
    private static final String PASSWORD_KEY = "PROD_DB_PASSWORD";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            String url = "jdbc:postgresql://%s:%s/%s".formatted(PROD_DB_HOST,PROD_DB_PORT,PROD_DB_NAME);
            String username = USERNAME_KEY;
            String password  = PASSWORD_KEY;
            Flyway flyway = Flyway.configure()
                    .dataSource(url,username,password)
                    .load();
            flyway.migrate();
        } catch (Exception e){
            System.out.println("ошибочка при попытке миграции");
        }
    }
}
