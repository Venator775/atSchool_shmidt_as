package lesson12_2_JDBC.task1.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    public static Connection InitDBConnection(String dbName, String dbUser, String dbPassword){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection != null ? "InitDBConnection success" : "InitDBConnection fail");
        return connection;
    }
}
