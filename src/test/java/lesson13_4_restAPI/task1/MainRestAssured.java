package lesson13_4_restAPI.task1;

import io.restassured.response.Response;
import jdk.jfr.Description;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.restassured.RestAssured.given;

public class MainRestAssured {

    final String host = "http://httpbin.org";
    final String uriAnything = "/anything";
    final String uriBasicAuth = "/basic-auth/user/password";
    final String uriBearer = "/bearer";

    @Description("Напишите тест, в котором отправляется запрос\n" +
            "GET на httpbin.org/anything с параметрами p1 = v1 и p2 = v2\n" +
            "и проверяется, что вернулся ответ с кодом 200,\n" +
            "а в ответном json'е объект args содержит переданные параметры.")
    @Test
    public void checkArgsTest() {
        String par1 = "value1";
        String par2 = "value2";

        String queryString = "?p1=" + par1 + "&p2=" + par2;

        Response response = getResponse(host, uriAnything, queryString);
        String res = response.getBody().asString();
        System.out.println(res);

        JSONObject jsonObject = new JSONObject(res);
        JSONObject args = jsonObject.getJSONObject("args");
        assert args != null;
        String v1FromResponseJson = args.getString("p1");
        String v2FromResponseJson = args.getString("p2");
        System.out.println("p1 = " + v1FromResponseJson);
        System.out.println("p2 = " + v2FromResponseJson);


        Assertions.assertAll(
                () -> Assertions.assertEquals(v1FromResponseJson, par1, "v1 - ошибка"),
                () -> Assertions.assertEquals(v2FromResponseJson, par2, "v2 - ошибка")
        );
    }

    @Description("Напишите тест, в которм отправляется запрос\n" +
            "POST на httpbin.org/anything с телом запроса:\n" +
            "{\n" +
            "  \"parameter\": \"value\"\n" +
            "}\n" +
            "Проверяется, что вернулся ответ с кодом 200,\n" +
            "а в ответном json'е объект \"json\" с переданным в теле параметром.")
    @Test
    public void checkParameterTest() {
        String json = readJSONFromFileToString("src/test/resources/anythingParameter.json");

        Response response = postResponse(host, uriAnything, json);

        String resText = response.getBody().asString();
        System.out.println(resText);

        String parameterFromResponse = new JSONObject(resText)
                .getJSONObject("json")
                .getString("parameter");
        System.out.println("parameter = " + parameterFromResponse);

        Assertions.assertEquals(parameterFromResponse, "value", "parameter - ошибка");
    }


    @Description("Напишите тест, в котором отправляется запрос\n" +
            "   GET httpbin.org/basic-auth/user/password с авторизацией по логину с паролем\n" +
            "   и проверяется, что вернулся ответ с кодом 200.\n" +
            "   (см. github.com/rest-assured/rest-assured/wiki/Usage#basic-authentication)")
    @Test
    public void checkGetAuth() {
        Response response = getAuthResponse(host, uriBasicAuth, "user", "password");

        String resText = response.getBody().asString();
        System.out.println(resText);
        JSONObject jsonResponse = new JSONObject(resText);
        boolean isAuthenticated = jsonResponse
                .getBoolean("authenticated");
        String userName = jsonResponse
                .getString("user");

        Assertions.assertEquals("user", userName, "user - ошибка");
        Assertions.assertTrue(isAuthenticated, "authenticated - ошибка");
    }

    @Description("Напишите тест, в котором отправляется запрос\n" +
            "   GET httpbin.org/bearer с авторизацией по токену\n" +
            "   (в данном случае токен может быть некорректным, например, 123)\n" +
            "   и проверяется, что вернулся ответ с кодом 200.\n" +
            "   (см. github.com/rest-assured/rest-assured/wiki/Usage#oauth-2 или\n" +
            "   swagger.io/docs/specification/authentication/bearer-authentication/)")
    @Test
    public void checkBearer() {
        Response response = getBearerResponse(host,uriBearer,"1324");

        String resText = response.getBody().asString();
        System.out.println(resText);
        JSONObject jsonResponse = new JSONObject(resText);

        boolean isAuthenticated = jsonResponse
                .getBoolean("authenticated");
        String tokenValue = jsonResponse
                .getString("token");

        Assertions.assertTrue(isAuthenticated, "authenticated - ошибка");
        Assertions.assertEquals("1324", tokenValue, "token - ошибка");
    }


    private static Response getResponse(String host, String uri, String queryString) {
        return given()//позволяет узнать, что было передано в запросе.
                .baseUri(host)
                .when()//с каким методом и на какой эндпойнт отправляем запрос.
                .get(uri + queryString)
                .then()//как проверяется пришедший ответ.
                .statusCode(200)
                .extract()
                .response();
    }

    private static Response postResponse(String host, String uri, String json) {
        return given()
                .baseUri(host)
                .and()
                .body(json)
                .when()
                .post(uri)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    private static Response getAuthResponse(String host, String uri, String username, String password) {
        return given()
                .baseUri(host)
                .auth()
                .basic(username, password)
                .when()
                .get(uri)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    private static Response getBearerResponse(String host, String uri, String token){
        return given()
                .baseUri(host)
                .auth()
                .oauth2(token)
                .when()
                .get(uri)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }


    public static String readJSONFromFileToString(String path) {
        Path filePath = Path.of(path);
        try {
            return Files.readString(filePath, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
