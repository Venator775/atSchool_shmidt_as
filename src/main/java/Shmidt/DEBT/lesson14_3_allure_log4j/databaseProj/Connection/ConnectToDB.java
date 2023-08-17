package Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    private static final Logger logger = LogManager.getLogger(ConnectToDB.class);

    public static Connection InitDBConnection(String dbName, String dbUser, String dbPassword) {
        Connection connection = null;
        System.out.println(ConnectToDB.class);
        try {
            Class.forName("org.postgresql.Driver");
            logger.debug("Connection InitDBConnection() - Получили драйвер org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, dbUser, dbPassword);
            logger.debug("Connection InitDBConnection() - Удалось установить соединение с БД  \" + dbName");
        } catch (ClassNotFoundException e) {
            logger.error("Connection InitDBConnection() - Не удалось получить драйвер org.postgresql.Driver");
        } catch (SQLException e) {
            logger.error("Connection InitDBConnection() - Не удалось установить соединение с БД ");
        }

        logger.info(connection != null ? "InitDBConnection success" : "InitDBConnection fail");
        return connection;
    }

    public static Connection InitDBConnection() {
        Connection connection = null;
        String dbName = "testprojectjdbc";
        String dbUser = "postgres";
        String dbPassword = "123456";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, dbUser, dbPassword);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(connection != null ? "InitDBConnection success" : "InitDBConnection fail");
        return connection;
    }
}
