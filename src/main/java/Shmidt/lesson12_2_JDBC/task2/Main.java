package Shmidt.lesson12_2_JDBC.task2;


import Shmidt.lesson12_2_JDBC.task2.Connection.ConnectToDB;
import Shmidt.lesson12_2_JDBC.task2.Movies.Movie;
import Shmidt.lesson12_2_JDBC.task2.Movies.MovieRepositoryImpl;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        String dbName = "testprojectjdbc";
        String dbUser = "postgres";
        String dbPassword = "123456";

        try  {
            Connection connection = ConnectToDB.InitDBConnection(dbName, dbUser, dbPassword);
            System.out.println("May the force be with you.\n");
            MovieRepositoryImpl mri = new MovieRepositoryImpl(connection);
            Movie g = mri.get(3);
            System.out.println(g);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
