package lesson12_2_JDBC.task2;


import Shmidt.lesson12_2_JDBC.task2.Connection.ConnectToDB;
import Shmidt.lesson12_2_JDBC.task2.Director.DirectorRepositoryImpl;
import Shmidt.lesson12_2_JDBC.task2.Movies.Movie;
import Shmidt.lesson12_2_JDBC.task2.Movies.MovieRepositoryImpl;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

//mvn -Dgroups=lesson12_2_JDBCtask2 test
public class jdbcTestTask2 {

    final private static String dbName = "testprojectjdbc";
    final private static String dbUser = "postgres";
    final private static String dbPassword = "123456";

    private static Connection connection;

    @BeforeAll
    static void connectionTest() {
        try {
            Connection connectionTemp = ConnectToDB.InitDBConnection(dbName, dbUser, dbPassword);
            Assertions.assertNotNull(connectionTemp, "Не удалось подключиться к БД");
            connection = connectionTemp;

            System.out.println("Connection is OK " + connection.getSchema());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest(name = "{displayName} - id={0} ")
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("Тест getMovie")
    void getMovieTest(int movID) {
        MovieRepositoryImpl mri = new MovieRepositoryImpl(connection);
        Movie expectedMovie = mri.get(movID);
        Assertions.assertNotNull(expectedMovie, "Не удалось выбрать запись");
    }

    @ParameterizedTest(name = "{displayName} - {0} ({2})")
    @MethodSource("lesson12_2_JDBC.task2.testDataProviders.TestDataProvider#randMovieProvider")
    @DisplayName("Тест saveMovie")
    @Description("Директор выбирается рандомный из имеющихся в таблице directors")
    void saveMovieTest(int id, String title, String genre, LocalDate release) {
        MovieRepositoryImpl mri = new MovieRepositoryImpl(connection);
        DirectorRepositoryImpl dri = new DirectorRepositoryImpl(connection);
        Movie expectedMovie = new Movie(id, title, genre, release, dri.getRandom());
        mri.save(expectedMovie);
        Movie addedMovie = mri.get(id);
        assertMoviesAreEqual(expectedMovie, addedMovie);
    }



    private static void assertMoviesAreEqual(Movie expectedMovie, Movie factMovie) {
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedMovie.getId(), factMovie.getId()),
                () -> Assertions.assertEquals(expectedMovie.getTitle(), factMovie.getTitle()),
                () -> Assertions.assertEquals(expectedMovie.getGenre(), factMovie.getGenre()),
                () -> Assertions.assertEquals(expectedMovie.getRelease(), factMovie.getRelease()),
                () -> Assertions.assertEquals(expectedMovie.getDirector().getId(), factMovie.getDirector().getId())
        );
    }
}
