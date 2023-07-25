package lesson12_2_JDBC.task1;

import Shmidt.lesson12_2_JDBC.task1.Connection.ConnectToDB;
import lesson12_2_JDBC.task1.Director.Director;
import lesson12_2_JDBC.task1.Director.DirectorRepositoryImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.stream.Stream;

public class jdbcTest {
    final private static String dbName = "testprojectjdbc";
    final private static String dbUser = "postgres";
    final private static String dbPassword = "123456";

    private static Connection connection;

    @BeforeAll
    static void connectionTest() {
        Connection connectionTemp = ConnectToDB.InitDBConnection(dbName, dbUser, dbPassword);
        Assertions.assertNotNull(connectionTemp, "Не удалось подключиться к БД");
        connection = connectionTemp;
    }


    @ParameterizedTest(name = "{displayName} - {0} ({2})")
    @DisplayName("Тест select")
    @MethodSource({"directorsProvider"})
    @Tag("select")
    void selectTest(int id, String firstName, String lastName, LocalDate birthDate, String country) {
        Director expectedDirector = new Director(id, firstName, lastName, birthDate, country);

        DirectorRepositoryImpl dri = new DirectorRepositoryImpl(connection);
        Director selectedDirector = dri.get(id);
        Assertions.assertNotNull(selectedDirector, "Не удалось выбрать запись");
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedDirector.getId(), selectedDirector.getId()),
                () -> Assertions.assertEquals(expectedDirector.getFirstName(), selectedDirector.getFirstName()),
                () -> Assertions.assertEquals(expectedDirector.getLastName(), selectedDirector.getLastName()),
                () -> Assertions.assertEquals(expectedDirector.getBirthDate(), selectedDirector.getBirthDate()),
                () -> Assertions.assertEquals(expectedDirector.getCountry(), selectedDirector.getCountry())
        );

    }


    private static Stream<Arguments> directorsProvider() {
        return Stream.of(
                Arguments.arguments(1, "Anakin", "Skywalker", LocalDate.of(2000, 1, 1), "Tatooine"),
                Arguments.arguments(2, "Obi-wan", "Kenobi", LocalDate.of(2023, 7, 24), "Stewjon"),
                Arguments.arguments(4, "Jar Jar", "Binks", LocalDate.of(1967, 6, 22), "Naboo"),
                Arguments.arguments(5, "Jar Jar2", "Binks", LocalDate.of(1967, 6, 22), "Naboo2"),
                Arguments.arguments(6, "Jar Jar1", "Binks", LocalDate.of(1967, 6, 22), "Naboo1")
        );
    }

    @AfterAll
    static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
