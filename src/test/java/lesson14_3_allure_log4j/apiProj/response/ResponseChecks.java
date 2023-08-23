package lesson14_3_allure_log4j.apiProj.response;

import Shmidt.DEBT.lesson14_3_allure_log4j.apiProj.Response;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ResponseChecks {
    private static final Logger logger = LogManager.getLogger(ResponseChecks.class);

    @Step("Верификация ответа")
    public static void checkResponse(Response response) {
        Allure.addAttachment("Код ответа:", String.valueOf(response.getCode()));
        Allure.addAttachment("Тело ответа:\n", response.getJsonBody().toString());

        Assertions.assertEquals(200, response.getCode(), "Код ответа не соответствует ожидаемому");
        Assertions.assertNotNull(response.getJsonBody(), "Тело ответа отсутствует");
        logger.debug("checkResponse() - ответ верифицирован. code " + response.getCode());
    }
}
