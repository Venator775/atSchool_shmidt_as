package Shmidt.DEBT.lesson12_2_JDBC.task1.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    public static Connection InitDBConnection(String dbName, String dbUser, String dbPassword) {
        Connection connection = null;

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
