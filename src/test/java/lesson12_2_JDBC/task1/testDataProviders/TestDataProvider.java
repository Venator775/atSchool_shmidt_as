package lesson12_2_JDBC.task1.testDataProviders;

import org.junit.jupiter.params.provider.Arguments;

import java.time.LocalDate;
import java.util.stream.Stream;

public class TestDataProvider {
    private static Stream<Arguments> directorsProvider() {
        return Stream.of(
                Arguments.arguments(1, "Anakin", "Skywalker", LocalDate.of(2000, 1, 1), "Tatooine"),
                Arguments.arguments(2, "Obi-wan", "Kenobi", LocalDate.of(2023, 7, 24), "Stewjon"),
                Arguments.arguments(4, "Jar Jar", "Binks", LocalDate.of(1967, 6, 22), "Naboo"),
                Arguments.arguments(5, "Jar Jar2", "Binks", LocalDate.of(1967, 6, 22), "Naboo2"),
                Arguments.arguments(6, "Jar Jar1", "Binks", LocalDate.of(1967, 6, 22), "Naboo1")
        );
    }
}
