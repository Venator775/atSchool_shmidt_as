package lesson14_3_allure_log4j.databaseProj;


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

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Tag("lesson12_2_JDBCtask2")
    @ParameterizedTest(name = "{displayName}")
    @MethodSource("lesson12_2_JDBC.task2.testDataProviders.TestDataProvider#genresProvider")
    @DisplayName("Тест getGenreDirectors")
    void getGenreDirectorsTest(List<String> genre) {
        System.out.println(genre);
        List<Director> genreDirectors = new DirectorRepositoryImpl(connection).getX(genre);
        genreDirectors.forEach(System.out::println);
        Assertions.assertNotNull(genreDirectors);
    }


   void getFilms() {
        List<Map<String, Object>> allStringFromDB = getAllStringFromDB();
        allStringFromDB = getAllStringFromDB("select * from movies");
        LocalDate resultDate = LocalDate.parse(allStringFromDB.get(1).get("release").toString());
        allStringFromDB.stream()
                .filter(releases -> LocalDate.parse(releases.get("release").toString()).isAfter(LocalDate.parse("2000-12-31")))
                .filter(directors -> directors.get("director") != null)
                .filter(id -> (int) id.get("id") >= 5)
                .forEach(System.out::println);
    }

    private static List<Map<String, Object>> getAllStringFromDB() {
        String query = "select * from movies";
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                String columnName;
                Map<String, Object> map = new HashMap<>();

                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    columnName = metaData.getColumnName(i);
                    Object objStr = resultSet.getObject(columnName);
                    map.put(columnName, objStr);
                }
                result.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private static List<Map<String, Object>> getAllStringFromDB(String query) {
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                String columnName;
                Map<String, Object> map = new HashMap<>();

                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    columnName = metaData.getColumnName(i);
                    Object objStr = resultSet.getObject(columnName);
                    map.put(columnName, objStr);
                }
                result.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
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
