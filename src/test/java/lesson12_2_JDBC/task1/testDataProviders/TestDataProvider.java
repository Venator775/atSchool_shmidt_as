package lesson12_2_JDBC.task1.testDataProviders;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.provider.Arguments;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.stream.Stream;

import static Shmidt.tests.sideMethods.rnd;

public class TestDataProvider {
    private static Stream<Arguments> directorsFromDBProvider() {
        return Stream.of(
                Arguments.arguments(1, "Anakin", "Skywalker", LocalDate.of(2000, 1, 1), "Tatooine"),
                Arguments.arguments(2, "Obi-wan", "Kenobi", LocalDate.of(2023, 7, 24), "Stewjon"),
                Arguments.arguments(4, "Jar Jar", "Binks", LocalDate.of(1967, 6, 22), "Naboo"),
                Arguments.arguments(5, "Jar Jar2", "Binks", LocalDate.of(1967, 6, 22), "Naboo2"),
                Arguments.arguments(6, "Jar Jar1", "Binks", LocalDate.of(1967, 6, 22), "Naboo1")
        );
    }

    private static Stream<Arguments> newDirectorsProvider() {
        return Stream.of(
                Arguments.arguments(rnd(10,14), new Faker().name().firstName(), new Faker().funnyName().name(), new Faker().date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Faker().country().name()),
                Arguments.arguments(rnd(15,17), new Faker().name().firstName(), new Faker().funnyName().name(), new Faker().date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Faker().country().name()),
                Arguments.arguments(rnd(18,20), new Faker().name().firstName(), new Faker().funnyName().name(), new Faker().date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Faker().country().name())
        );
    }
}
