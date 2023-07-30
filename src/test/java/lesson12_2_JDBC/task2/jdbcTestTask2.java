package lesson12_2_JDBC.task2;


import Shmidt.lesson12_2_JDBC.task2.Connection.ConnectToDB;
import Shmidt.lesson12_2_JDBC.task2.Director.Director;
import Shmidt.lesson12_2_JDBC.task2.Director.DirectorRepositoryImpl;
import Shmidt.lesson12_2_JDBC.task2.Movies.Movie;
import Shmidt.lesson12_2_JDBC.task2.Movies.MovieRepositoryImpl;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

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

    @Tag("lesson12_2_JDBCtask2")
    @ParameterizedTest(name = "{displayName} - id={0} ")
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("Тест getMovie")
    void getMovieTest(int movID) {
        MovieRepositoryImpl mri = new MovieRepositoryImpl(connection);
        Movie expectedMovie = mri.get(movID);
        Assertions.assertNotNull(expectedMovie, "Не удалось выбрать запись");
    }

    @Tag("lesson12_2_JDBCtask2")
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

    @Test
    @DisplayName("Тест delete")
    @Tag("lesson12_2_JDBCtask2")
    void deleteTest() {
        MovieRepositoryImpl mri = new MovieRepositoryImpl(connection);
        DirectorRepositoryImpl dri = new DirectorRepositoryImpl(connection);
        String query = "select * from movies where id > ? limit ?";
        PreparedStatement psSelect;

        try {
            psSelect = connection.prepareStatement(query);
            psSelect.setInt(1, 10);
            psSelect.setInt(2, 3);
            psSelect.execute();
            ResultSet executionResult = psSelect.getResultSet();
            while (executionResult.next()) {
                mri.delete(new Movie(executionResult.getInt("id"),
                        executionResult.getString("title"),
                        executionResult.getString("genre"),
                        LocalDate.parse(executionResult.getString("release")),
                        dri.get(executionResult.getInt("director"))));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    @Tag("lesson12_2_JDBCtask2")
//    @ParameterizedTest(name = "{displayName}")
//    @MethodSource("lesson12_2_JDBC.task2.testDataProviders.TestDataProvider#genresProvider")
//    @DisplayName("Тест getGenreDirectors")
//    void getGenreDirectorsTest(List<String> genre) {
////        void getGenreDirectorsTest(String... genre) {
////        List<Director> genreDirectors = new DirectorRepositoryImpl(connection)
////                .get(Arrays.stream(genre).collect(Collectors.toList()));
//        List<Director> genreDirectors = new DirectorRepositoryImpl(connection).get(genre);
//        Assertions.assertNotNull(genreDirectors);
//
//    }

    @Tag("lesson12_2_JDBCtask2")
    @Test
    @DisplayName("Тест getGenreDirectors")
    void getGenreDirectorsTest() {
        List<String> genres = List.of("shit", "action", "comedy");
        List<Director> genreDirectors = new DirectorRepositoryImpl(connection).get(genres);
        Assertions.assertNotNull(genreDirectors);
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
