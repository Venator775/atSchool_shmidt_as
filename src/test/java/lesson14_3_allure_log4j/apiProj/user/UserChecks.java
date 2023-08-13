package lesson14_3_allure_log4j.apiProj.user;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.JSONObject;

import static lesson13_4_restAPI.task2.JsonHelper.getJsonIntParameter;
import static lesson13_4_restAPI.task2.JsonHelper.getJsonStringParameter;

public class UserChecks {
    @Step("Верификация ответа с информацией о пользователе")
    public static void checkUserJson(JSONObject json) {
        Integer id = getJsonIntParameter(json, "id");
        String username = getJsonStringParameter(json, "username");
        String password = getJsonStringParameter(json, "password");

        Allure.addAttachment("Параметры пользователя:",
                id.getClass().getSimpleName() + " id:\t\t" + id + "\n"
                        + username.getClass().getSimpleName() + " username:\t" + username + "\n"
                        + password.getClass().getSimpleName() + " password:\t" + password);
    }
}
