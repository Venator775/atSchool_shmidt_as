package lesson14_3_allure_log4j.apiProj.login;

import Shmidt.DEBT.lesson14_3_allure_log4j.apiProj.Response;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

import static lesson13_4_restAPI.task2.JsonHelper.getJsonStringParameter;

public class LoginChecks {
    private static final Logger logger = LogManager.getLogger(LoginChecks.class);

    @Step("Проверка токена ответа авторизации")
    public static void checkLoginToken(Response response) {
        String firstName = getJsonStringParameter(response.getJsonBody(), "firstName");
        String lastName = getJsonStringParameter(response.getJsonBody(), "lastName");
        String token = getJsonStringParameter(response.getJsonBody(), "token");
        Allure.addAttachment("Пользователь:", "Имя:\t\t" + firstName
                + "\nФамилия:\t" + lastName);
        Allure.addAttachment("Токен сессии:", token);

        if (Objects.nonNull(firstName)
                && Objects.nonNull(lastName)
                && Objects.nonNull(token))
            logger.info("checkLoginToken() - Проверка токена ответа авторизации успешная." +
                    " Пользователь:  " + firstName + " " + lastName +
                    " Токен сессии: " + token);
        else
            logger.error("checkLoginToken() - Проверка токена ответа авторизации прошла с ошибкой:" +
                    " Пользователь:  " + firstName + " " + lastName +
                    " Токен сессии: " + token);
    }
}
