package Shmidt.lesson12_2_JDBC.task2;


import Shmidt.lesson12_2_JDBC.task2.Connection.ConnectToDB;
import Shmidt.lesson12_2_JDBC.task2.Director.Director;
import Shmidt.lesson12_2_JDBC.task2.Movies.Movie;
import Shmidt.lesson12_2_JDBC.task2.Movies.MovieRepositoryImpl;

import java.sql.Connection;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String dbName = "testprojectjdbc";
        String dbUser = "postgres";
        String dbPassword = "123456";

        try {
            Connection connection = ConnectToDB.InitDBConnection(dbName, dbUser, dbPassword);
            System.out.println("May the force be with you.\n");
            MovieRepositoryImpl mri = new MovieRepositoryImpl(connection);

            Movie g = mri.get(3);

            mri.save(new Movie(34, "maintest", "testMain", LocalDate.now(), new Director(1, "Anakin", "Skywalker", LocalDate.parse("2023-07-27"), "Tatooine")));



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
