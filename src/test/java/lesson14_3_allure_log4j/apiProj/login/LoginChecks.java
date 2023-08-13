package lesson14_3_allure_log4j.apiProj.login;

import Shmidt.DEBT.lesson14_3_allure_log4j.apiProj.Response;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static lesson13_4_restAPI.task2.JsonHelper.getJsonStringParameter;

public class LoginChecks {
    @Step("Проверка токена ответа авторизации")
    public static void checkLoginToken(Response response) {
        String firstName = getJsonStringParameter(response.getJsonBody(), "firstName");
        String lastName = getJsonStringParameter(response.getJsonBody(), "lastName");
        String token = getJsonStringParameter(response.getJsonBody(), "token");
        Allure.addAttachment("Пользователь:", "Имя:\t\t" + firstName
                + "\nФамилия:\t" + lastName);
        Allure.addAttachment("Токен сессии:", token);
    }
}
