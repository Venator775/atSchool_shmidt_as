package lesson12_2_JDBC.task1;

import lesson12_2_JDBC.task1.Connection.ConnectToDB;
import lesson12_2_JDBC.task1.Director.Director;
import lesson12_2_JDBC.task1.Director.DirectorRepositoryImpl;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        String dbName = "testprojectjdbc";
        String dbUser = "postgres";
        String dbPassword = "123456";

        try  {
            Connection connection = ConnectToDB.InitDBConnection(dbName, dbUser, dbPassword);
            System.out.println("May the force be with you.");
            DirectorRepositoryImpl dri = new DirectorRepositoryImpl(connection);

            Director dir1 = dri.get(1);
            System.out.println(dir1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
