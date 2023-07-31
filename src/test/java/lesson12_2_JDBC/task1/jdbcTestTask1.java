package lesson12_2_JDBC.task1;

import Shmidt.lesson12_2_JDBC.task1.Connection.ConnectToDB;
import lesson12_2_JDBC.task1.Director.Director;
import lesson12_2_JDBC.task1.Director.DirectorRepositoryImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

//mvn -Dgroups=lesson12_2_JDBCtask1 test
public class jdbcTestTask1 {
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
    @MethodSource("lesson12_2_JDBC.task2.testDataProviders.TestDataProvider#genresProvider")
    @Tag("lesson12_2_JDBCtask1")
    void selectTest(int id, String firstName, String lastName, LocalDate birthDate, String country) {
        Director expectedDirector = new Director(id, firstName, lastName, birthDate, country);

        DirectorRepositoryImpl dri = new DirectorRepositoryImpl(connection);
        Director selectedDirector = dri.get(id);
        Assertions.assertNotNull(selectedDirector, "Не удалось выбрать запись");
        assertDirectorsAreEqual(expectedDirector, selectedDirector);
    }

    @ParameterizedTest(name = "{displayName} - {0} ({2})")
    @MethodSource("lesson12_2_JDBC.task1.testDataProviders.TestDataProvider#newDirectorsProvider")
    @DisplayName("Тест insert")
    @Tag("lesson12_2_JDBCtask1")
    void insertTest(int id, String firstName, String lastName, LocalDate birthDate, String country) {
        Director expectedDirector = new Director(id, firstName, lastName, birthDate, country);

        DirectorRepositoryImpl dri = new DirectorRepositoryImpl(connection);
        dri.save(expectedDirector);
        Director addedDirector = dri.get(id);
        assertDirectorsAreEqual(expectedDirector, addedDirector);
    }

    @Test
    @DisplayName("Тест delete")
    @Tag("lesson12_2_JDBCtask1")
    void deleteTest() {
        DirectorRepositoryImpl dri = new DirectorRepositoryImpl(connection);
        String query = "select * from directors where id > ? limit ?";
        PreparedStatement psSelect;

        try {
            psSelect = connection.prepareStatement(query);
            psSelect.setInt(1, 10);
            psSelect.setInt(2, 3);
            psSelect.execute();
            ResultSet executionResult = psSelect.getResultSet();
            while (executionResult.next()){
                dri.delete(new Director(executionResult.getInt(1),
                        executionResult.getString(2),
                        executionResult.getString(3),
                        LocalDate.parse(executionResult.getString(4)),
                        executionResult.getString(5)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterAll
    static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void assertDirectorsAreEqual(Director expectedDirector, Director factDirector) {
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedDirector.getId(), factDirector.getId()),
                () -> Assertions.assertEquals(expectedDirector.getFirstName(), factDirector.getFirstName()),
                () -> Assertions.assertEquals(expectedDirector.getLastName(), factDirector.getLastName()),
                () -> Assertions.assertEquals(expectedDirector.getBirthDate(), factDirector.getBirthDate()),
                () -> Assertions.assertEquals(expectedDirector.getCountry(), factDirector.getCountry())
        );
    }

    private void showResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String fName = resultSet.getString("first_name");
            String lName = resultSet.getString("last_name");
            LocalDate birthDate = resultSet.getDate("birth_date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String country = resultSet.getString("country");
            System.out.printf("%d %s %s %s %s\n", id, fName, lName, birthDate, country);
        }
    }
}
