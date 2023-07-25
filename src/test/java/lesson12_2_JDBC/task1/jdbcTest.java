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
    @MethodSource("lesson12_2_JDBC.task1.testDataProviders.TestDataProvider#directorsProvider")
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


    @AfterAll
    static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
