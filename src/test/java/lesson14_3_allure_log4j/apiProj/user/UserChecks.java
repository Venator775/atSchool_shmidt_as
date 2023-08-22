package lesson14_3_allure_log4j.apiProj.user;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.Objects;

import static lesson13_4_restAPI.task2.JsonHelper.getJsonIntParameter;
import static lesson13_4_restAPI.task2.JsonHelper.getJsonStringParameter;

public class UserChecks {
    private static final Logger logger = LogManager.getLogger(UserChecks.class);

    @Step("Верификация ответа с информацией о пользователе")
    public static void checkUserJson(JSONObject json) {
        Integer id = getJsonIntParameter(json, "id");
        String username = getJsonStringParameter(json, "username");
        String password = getJsonStringParameter(json, "password");
        String userParameters = id.getClass().getSimpleName() + " id:\t\t" + id + "\n"
                + username.getClass().getSimpleName() + " username:\t" + username + "\n"
                + password.getClass().getSimpleName() + " password:\t" + password;
        Allure.addAttachment("Параметры пользователя:", userParameters);
        if (Objects.nonNull(id)
        && Objects.nonNull(username)
        && Objects.nonNull(password))
            logger.warn("checkUserJson() - Верификация пользователя успешная: " + userParameters);
        else
            logger.error("checkUserJson() - Верификация пользователя прошла с ошибкой: " + userParameters);
    }
}
