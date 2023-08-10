package lesson14_3_allure_log4j.apiProj.testDataProviders;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataProvider {
    private static Stream<Arguments> jsonUserProvider() {
        return Stream.of(
                Arguments.arguments("{\"id\": 1,\"username\": \"atuny0\",\"password\": \"9uQFF1Lh\"}"),
                Arguments.arguments("{\"id\": 6,\"username\": \"jtreleven5\",\"password\": \"zY1nE46Zm\"}"),
                Arguments.arguments("{\"id\": 10,\"username\": \"umcgourty9\",\"password\": \"i0xzpX\"}")
        );
    }
}
