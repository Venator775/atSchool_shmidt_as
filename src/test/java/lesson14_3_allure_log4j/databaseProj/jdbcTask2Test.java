package lesson14_3_allure_log4j.databaseProj;


import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Connection.ConnectToDB;
import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Director.Director;
import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Director.DirectorRepositoryImpl;
import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Movies.Movie;
import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Movies.MovieRepositoryImpl;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

//mvn -Dgroups=lesson14_3_allure_log4j_db test
public class jdbcTask2Test {
    private static final Logger logger = LogManager.getLogger(jdbcTask2Test.class);
    final private static String dbName = "testprojectjdbc";
    final private static String dbUser = "postgres";
    final private static String dbPassword = "123456";

    private static Connection connection;

    @Link("Где брал инфу по аннотациям: https://dzen.ru/a/ZGnrocsnFljbBbD5")
    @Epic("Выборка из базы")
    @Story("Получение всех фильмов")
    @Owner("Shmidt-AS")
    @Tag("lesson14_3_allure_log4j_db")
    @DisplayName("Тест getAllMovies")
    @Test
    void getAllMoviesTest() {
        logger.info("void getAllMoviesTest() - Начало теста");
        List<LinkedHashMap<String, Object>> allMovies = executeSQLQuery("select * from movies");
        Assertions.assertNotNull(allMovies);
        StringBuilder allMoviesResult = new StringBuilder("Фильмы:\n");
        allMovies.stream()
                .map(AbstractMap::toString)
                .forEach(film -> allMoviesResult.append(film).append("\n"));

        addFileToAllureAttachment("allMovies", allMoviesResult.toString(), "Список фильмов");
    }

    @Link("Где брал инфу по аннотациям: https://dzen.ru/a/ZGnrocsnFljbBbD5")
    @Epic("Выборка из базы")
    @Story("Получение одного фильма")
    @Step("Получение фильма из БД по идентификатору: Id={movID}")
    @Owner("Shmidt-AS")
    @Tag("lesson14_3_allure_log4j_db")
    @ParameterizedTest(name = " - id={0} ")
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("Тест getMovie")
    void getMovieTest(int movID) {
        logger.info("void getMovieTest() - Начало теста");
        MovieRepositoryImpl mri = new MovieRepositoryImpl(connection);
        Movie expectedMovie = mri.get(movID);
        String fileName = "Movie" + expectedMovie.getId();
        Assertions.assertNotNull(expectedMovie, "Не удалось выбрать запись");
        addFileToAllureAttachment(fileName, expectedMovie.toString(), "Загруженный файл с фильмом");
    }

    @Link("Где брал инфу по аннотациям: https://dzen.ru/a/ZGnrocsnFljbBbD5")
    @Epic("Сохранение фильма в БД")
    @Step("Сохранение фильма в БД: id={id} title=({title})")
    @Owner("Shmidt-AS")
    @Tag("lesson14_3_allure_log4j_db")
    @ParameterizedTest(name = " - {0} ({2})")
    @MethodSource("lesson12_2_JDBC.task2.testDataProviders.TestDataProvider#randMovieProvider")
    @DisplayName("Тест saveMovie")
    @Description("Директор выбирается рандомный из имеющихся в таблице directors")
    void saveMovieTest(int id, String title, String genre, LocalDate release) {
        MovieRepositoryImpl mri = new MovieRepositoryImpl(connection);
        DirectorRepositoryImpl dri = new DirectorRepositoryImpl(connection);
        Movie expectedMovie = new Movie(id, title, genre, release, dri.getRandom());
        logger.info("void saveMovieTest() - Начало теста. Сохраняем фильм |" + expectedMovie + "|");
        mri.save(expectedMovie);
        Movie movieInDB = mri.get(id);
        boolean moviesAreEqual = areMoviesEqual(expectedMovie, movieInDB);

        if (moviesAreEqual)
            logger.info("void saveMovieTest() - Сохранение фильма |" + expectedMovie + "| прошло успешно");
        else
            logger.error("void saveMovieTest() - Сохранение фильма |" + expectedMovie + "| не удалось");

        Assertions.assertTrue(moviesAreEqual, "Сохранённый фильм уже существует в таблице |" + expectedMovie + "|");
    }

    @Link("Где брал инфу по аннотациям: https://dzen.ru/a/ZGnrocsnFljbBbD5")
    @Epic("Удаление фильма из БД")
    @Step("Удаление записи о фильме из БД")
    @Owner("Shmidt-AS")
    @ParameterizedTest
    @MethodSource("lesson12_2_JDBC.task2.testDataProviders.TestDataProvider#idAndLimitProvider")
    @DisplayName("Тест deleteMovie")
    @Tag("lesson14_3_allure_log4j_db")
    void deleteMovieTest(int idMoreThan, int limit) {
        logger.info("void deleteMovieTest() - Начало теста");
        MovieRepositoryImpl mri = new MovieRepositoryImpl(connection);
        DirectorRepositoryImpl dri = new DirectorRepositoryImpl(connection);
        String query = "select * from movies where id > ? limit ?";
        PreparedStatement psSelect;

        try {
            psSelect = connection.prepareStatement(query);
            psSelect.setInt(1, idMoreThan);
            psSelect.setInt(2, limit);
            psSelect.execute();

            ResultSet executionResult = psSelect.getResultSet();
            StringBuilder deletedMovies = new StringBuilder();
            while (executionResult.next()) {
                Movie deleteMovie = new Movie(executionResult.getInt("id"),
                        executionResult.getString("title"),
                        executionResult.getString("genre"),
                        LocalDate.parse(executionResult.getString("release")),
                        dri.get(executionResult.getInt("director")));

                mri.delete(deleteMovie);
                deletedMovies.append(deleteMovie).append("\n");
            }
            addFileToAllureAttachment("deleteMovies", deletedMovies.toString(), "Удалённые фильмы");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Link("Где брал инфу по аннотациям: https://dzen.ru/a/ZGnrocsnFljbBbD5")
    @Epic("Выборка из базы")
    @Story("Получение списка режисёров по жанрам")
    @Step("Выборка режисёров по жанрам фильмов: {genre}")
    @Owner("Shmidt-AS")
    @Tag("lesson14_3_allure_log4j_db")
    @ParameterizedTest(name = " - {0}")
    @MethodSource("lesson12_2_JDBC.task2.testDataProviders.TestDataProvider#genresProvider")
    @DisplayName("Тест getGenreDirectors")
    void getGenreDirectorsTest(List<String> genres) {
        logger.info("void getGenreDirectorsTest() - Начало теста");
        System.out.println(genres);
        List<Director> genreDirectors = new DirectorRepositoryImpl(connection).getX(genres);
        genreDirectors.forEach(System.out::println);
        Assertions.assertNotNull(genreDirectors);

        String str = genreDirectors.stream()
                .map((s) -> "'" + s + "'")
                .collect(Collectors.joining("\n"));

        addFileToAllureAttachment(genres.toString(), str, "Загруженный файл с режиссёрами");
    }

    @Step("Подключение к базе данных")
    @Owner("Shmidt-AS")
    @BeforeAll
    static void connectionTest() {
        logger.info("Начали тесты");
        try {
            Files.copy(Path.of("src/test/resources/environment.properties"),
                    Path.of("target/allure-results/environment.properties"),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Не удалось перенести файл src/test/resources/environment.properties -> target/allure-results/environment.properties");
        }

        try {
            Connection connectionTemp = ConnectToDB.InitDBConnection(dbName, dbUser, dbPassword);
            Assertions.assertNotNull(connectionTemp, "Не удалось подключиться к БД");
            connection = connectionTemp;

            logger.info("void connectionTest()  - Connection is OK " + connection.getSchema());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Owner("Shmidt-AS")
    @AfterAll
    static void endingTests() {
        logger.info("Закончили тесты");
    }

    @Step("Проверка добавленного фильма после сохранения")
    private static boolean areMoviesEqual(Movie expectedMovie, Movie factMovie) {
        return Objects.equals(expectedMovie.getId(), factMovie.getId())
                && Objects.equals(expectedMovie.getTitle(), factMovie.getTitle())
                && Objects.equals(expectedMovie.getGenre(), factMovie.getGenre())
                && Objects.equals(expectedMovie.getRelease(), factMovie.getRelease())
                && Objects.equals(expectedMovie.getDirector().getId(), factMovie.getDirector().getId());
    }


    @Step("Сохранение результатов в файл {logFileName}")
    private static void saveResultsInFile(String logFileName, String logText) {
        String savePath = "target/allure-results/" + logFileName + ".txt";
        try (FileWriter writer = new FileWriter(savePath, false)) {
            writer.write(logText + "\n");
            writer.flush();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void addFileToAllureAttachment(String logFileName, String logText, String allureAttachmentFileName) {
        saveResultsInFile(logFileName, logText);
        try {
            Allure.addAttachment(allureAttachmentFileName, new FileInputStream("target/allure-results/" + logFileName + ".txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Выполнение SQL запроса")
    private static List<LinkedHashMap<String, Object>> executeSQLQuery(String query) {
        List<LinkedHashMap<String, Object>> result = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            result = new ArrayList<>();

            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                String columnName;
                LinkedHashMap<String, Object> map = new LinkedHashMap<>();

                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    columnName = metaData.getColumnName(i);
                    Object objStr = resultSet.getObject(columnName);
                    map.put(columnName, objStr);
                }
                result.add(map);
            }
        } catch (SQLException e) {
            logger.error("List<LinkedHashMap<String, Object>> executeSQLQuery() - " + e.getMessage());
        }
        logger.debug("List<LinkedHashMap<String, Object>> executeSQLQuery() - Выполнен запрос: " + query);
        return result;
    }

    //region
    void getFilms() {
        List<LinkedHashMap<String, Object>> allStringFromDB = getAllStringFromDB();
        LocalDate resultDate = LocalDate.parse(allStringFromDB.get(1).get("release").toString());
        allStringFromDB.stream()
                .filter(releases -> LocalDate.parse(releases.get("release").toString()).isAfter(LocalDate.parse("2000-12-31")))
                .filter(directors -> directors.get("director") != null)
                .filter(id -> (int) id.get("id") >= 5)
                .forEach(System.out::println);
    }

    private static List<LinkedHashMap<String, Object>> getAllStringFromDB() {
        String query = "select * from movies";
        List<LinkedHashMap<String, Object>> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                String columnName;
                LinkedHashMap<String, Object> map = new LinkedHashMap<>();

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


    //endregion

}
