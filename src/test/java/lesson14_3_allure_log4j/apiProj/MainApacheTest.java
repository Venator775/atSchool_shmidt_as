package lesson14_3_allure_log4j.apiProj;

import Shmidt.DEBT.lesson14_3_allure_log4j.apiProj.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static lesson14_3_allure_log4j.apiProj.JsonHelper.*;
import static lesson14_3_allure_log4j.apiProj.login.LoginChecks.checkLoginToken;
import static lesson14_3_allure_log4j.apiProj.response.ResponseChecks.checkResponse;
import static lesson14_3_allure_log4j.apiProj.user.UserChecks.checkUserJson;

//-Dlog4j.configurationFile=log4jConf_Apache.xml -Dlog4j.enableJndiJdbc=true
public class MainApacheTest {

    private static final Logger logger = LogManager.getLogger(MainApacheTest.class);
    private static DummyJsonClientImpl clientImpl;


    @Story("/users/USER_ID")
    @Tag("dummyjson")
    @ParameterizedTest(name = " - id={0} ")
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("Тест checkGetUser")
    @Description("Получение информации о пользователе по уникальному id (dummyjson.com/docs/users).  На сайте предустановлены пользователи с id от 1 до 100.")
    public void checkGetUser(int userId) {
        logger.info("checkGetUser() - Получение информации о пользователе по уникальному id = " + userId);
        Response getUserResp = null;

        try {
            getUserResp = clientImpl.getUser(userId);
            checkResponse(getUserResp);
            checkUserJson(getUserResp.getJsonBody());
            logger.info("checkGetUser() - Пользователь получен: " + getUserResp.getUserName());
        } catch (Exception ex) {
            logger.error("checkGetUser() - " + ex.getMessage());
            Assertions.fail(ex.getMessage());
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
        logger.info("checkPostLogin() - Аутентификация пользователя по логину и паролю");
        User user = new User(new JSONObject(jsonString));

        Response postLoginResp = null;

        try {
            postLoginResp = clientImpl.login(user);
            checkResponse(postLoginResp);
            checkLoginToken(postLoginResp);

            logger.info("checkPostLogin() - Аутентификация успешна. Token: " + new Token(postLoginResp.getJsonBody()).getToken());
        } catch (Exception ex) {
            logger.error("checkPostLogin() - Аутентификация провалена. " + ex.getMessage());
            Assertions.fail(ex.getMessage());
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
        logger.info("checkPostGettingPostsWithToken() - Получение списка сообщений по уникальному id пользователя");
        User user = new User(new JSONObject(jsonString));

        Response getAuthPosts = null;
        try {
            getAuthPosts = clientImpl.login(user);
            checkLoginToken(getAuthPosts);

            getAuthPosts = clientImpl.getPosts(user, new Token(getAuthPosts.getJsonBody()));
            checkResponse(getAuthPosts);

            List<Post> posts = getPosts(getAuthPosts);
            verificatePosts(posts);
            logger.info("checkPostGettingPostsWithToken() - Получение списка сообщений завершено");
        } catch (Exception ex) {
            logger.error("checkPostGettingPostsWithToken() - " + ex.getMessage());
            Assertions.fail(ex.getMessage());
        }
    }

    @Owner("Shmidt-AS")
    @DisplayName("Начало теста")
    @Description("Инициализация клиента")
    @BeforeAll
    public static void initNewClient() {
        try {
            Files.copy(Path.of("src/test/resources/environmentAPI.properties"),
                    Path.of("target/allure-results/environment.properties"),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        clientImpl = new DummyJsonClientImpl();

        logger.info("initNewClient() - Начало теста. Инициализация клиента");
    }

    @Owner("Shmidt-AS")
    @DisplayName("Конец теста")
    @Description("Окончание теста")
    @AfterAll
    public static void closeClient() {
        logger.info("void closeClient() - Конец теста.");
        addFileToAllureAttachment("target/logs/logFile_API.log", "Отчёт о тестах");
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
            logger.error(ex.getMessage());
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
        logger.debug("verificatePosts() - Список постов пользователя: " + postList);
    }

    private static void addFileToAllureAttachment(String logFileName, String allureAttachmentFileName) {
        Path src = Paths.get(logFileName);
        Path dest = Paths.get("target/allure-results/" + src.getFileName());
        copyFileUsingJava7Files(src, dest);
        try {
            Allure.addAttachment(allureAttachmentFileName, new FileInputStream(dest.toString()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // простой и удобный метод копирования файла в Java 7
    private static void copyFileUsingJava7Files(Path source, Path dest) {
        try {
            Files.copy(source, dest);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
