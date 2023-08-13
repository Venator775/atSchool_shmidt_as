package lesson14_3_allure_log4j.apiProj;

import Shmidt.DEBT.lesson14_3_allure_log4j.apiProj.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static lesson14_3_allure_log4j.apiProj.JsonHelper.*;
import static lesson14_3_allure_log4j.apiProj.Response.ResponseChecks.checkResponse;
import static lesson14_3_allure_log4j.apiProj.login.LoginChecks.checkLoginToken;
import static lesson14_3_allure_log4j.apiProj.user.UserChecks.checkUserJson;

public class MainApacheTest {

    private static DummyJsonClientImpl clientImpl;

    @Owner("Shmidt-AS")
    @Step("Инициализация клиента")
    @BeforeEach
    public void initNewClient() {
        clientImpl = new DummyJsonClientImpl();
    }

    @Story("/users/USER_ID")
    @Tag("dummyjson")
    @ParameterizedTest(name = " - id={0} ")
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("Тест checkGetUser")
    @Description("Получение информации о пользователе по уникальному id (dummyjson.com/docs/users).  На сайте предустановлены пользователи с id от 1 до 100.")
    public void checkGetUser(int userId) {

        Response getUserResp = null;

        try {
            getUserResp = clientImpl.getUser(userId);
            checkResponse(getUserResp);
            checkUserJson(getUserResp.getJsonBody());
        } catch (Exception e) {
            Assertions.assertNotNull(getUserResp);
            System.out.println(e.getMessage());
        }
    }

    @Story("/auth/login")
    @Tag("dummyjson")
    @ParameterizedTest(name = " - {0}")
    @MethodSource("lesson13_4_restAPI.task2.testDataProviders.TestDataProvider#jsonUserProvider")
    @DisplayName("Тест checkPostLogin")
    @Description("Аутентификация пользователя по логину и паролю (dummyjson.com/docs/auth).  Логин и пароль возвращаются со всей информацией пользователя из пункта 1.\n" +
            "В ответе возвращается токен, который далее используется для отправки запросов.")
    public void checkPostLogin(String jsonString) {

        User user = new User(new JSONObject(jsonString));

        Response postLoginResp = null;

        try {
            postLoginResp = clientImpl.login(user);
            checkResponse(postLoginResp);
            checkLoginToken(postLoginResp);

        } catch (Exception ex) {
            Assertions.assertNotNull(postLoginResp);
            System.out.println(ex.getMessage());
        }
    }

    @Story("auth/posts/user/USER_ID")
    @Tag("dummyjson")
    @ParameterizedTest(name = " - {0}")
    @MethodSource("lesson13_4_restAPI.task2.testDataProviders.TestDataProvider#jsonUserProvider")
    @DisplayName("Тест checkPostGettingPosts")
    @Description("Получение списка сообщений по уникальному id пользователя, используя токен, полученный при аутентификации. " +
            "Токен передается через заголовок \"Authorization\" (см. swagger.io/docs/specification/authentication/bearer-authentication/ и dummyjson.com/docs )")
    public void checkPostGettingPostsWithToken(String jsonString) {

        User user = new User(new JSONObject(jsonString));

        Response getAuthPosts = null;
        try {
            getAuthPosts = clientImpl.login(user);
            checkLoginToken(getAuthPosts);

            getAuthPosts = clientImpl.getPosts(user, new Token(getAuthPosts.getJsonBody()));
            checkResponse(getAuthPosts);

            List<Post> posts = getPosts(getAuthPosts);
            verificatePosts(posts);

        } catch (Exception ex) {
            Assertions.assertNotNull(getAuthPosts);
            System.out.println(ex.getMessage());
        }
    }

    @Step("Получение списка постов пользователя")
    private static List<Post> getPosts(Response getAuthPosts) {
        try {
            JSONArray jsonArrayPosts = getJsonArray(getAuthPosts.getJsonBody(), "posts");
            return StreamSupport.stream(jsonArrayPosts.spliterator(), false)
                    .map(o -> o instanceof JSONObject ? (JSONObject) o : null)
                    .filter(Objects::nonNull)
                    .map(obj -> new Post(getJsonIntParameter(obj, "id"),
                                    getJsonStringParameter(obj, "title"),
                                    getJsonIntParameter(obj, "userId")
                            )
                    )
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Step("Верификация списка постов пользователя")
    private static void verificatePosts(List<Post> posts) {
        Assertions.assertNotNull(posts);
        StringBuilder postList = new StringBuilder();
        posts.stream()
                .map(Post::getTitle)
                .forEach(title -> postList.append(title).append("\n"));
        Allure.addAttachment("Список постов пользователя:", postList.toString());
    }

}
