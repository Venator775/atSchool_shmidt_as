package lesson14_3_allure_log4j.apiProj.Response;

import Shmidt.DEBT.lesson14_3_allure_log4j.apiProj.Response;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class ResponseChecks {

    @Step("Верификация ответа")
    public static void checkResponse(Response response) {
        Assertions.assertEquals(200, response.getCode(), "Код ответа не соответствует ожидаемому");
        Assertions.assertNotNull(response.getJsonBody(), "Тело ответа отсутствует");
        Allure.addAttachment("Код ответа:", String.valueOf(response.getCode()));
        Allure.addAttachment("Тело ответа:\n", response.getJsonBody().toString());
    }
}
