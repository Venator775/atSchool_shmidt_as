package Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj;


import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Connection.ConnectToDB;
import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Director.Director;
import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Director.DirectorRepositoryImpl;
import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Movies.Movie;
import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Movies.MovieRepositoryImpl;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String dbName = "testprojectjdbc";
        String dbUser = "postgres";
        String dbPassword = "123456";

        try {
            Connection connection = ConnectToDB.InitDBConnection(dbName, dbUser, dbPassword);
            System.out.println("May the force be with you.\n");

            Movie testMovie = new Movie(34, "maintest", "testMain", LocalDate.now(), new Director(1, "Anakin", "Skywalker", LocalDate.parse("2023-07-27"), "Tatooine"));

            MovieRepositoryImpl mri = new MovieRepositoryImpl(connection);

            mri.get(3);

            mri.save(testMovie);

            mri.delete(testMovie);

            System.out.println("Режисёры жанров:");
            new DirectorRepositoryImpl(connection)
                    .get(List.of("porn"))
                    .forEach(System.out::println);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
