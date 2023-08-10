package lesson14_3_allure_log4j.apiProj.Response;

import Shmidt.DEBT.lesson14_3_allure_log4j.apiProj.Response;
import org.junit.jupiter.api.Assertions;

public class ResponseChecks {

    public static void checkResponse(Response response){
        Assertions.assertEquals(200, response.getCode(), "Код ответа не соответствует ожидаемому");
        Assertions.assertNotNull(response.getJsonBody(), "Тело ответа отсутствует");
    }
}
