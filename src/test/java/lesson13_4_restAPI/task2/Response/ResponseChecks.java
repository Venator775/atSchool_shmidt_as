package lesson13_4_restAPI.task2.Response;

import Shmidt.DEBT.lesson13_4_restAPI.task2.Response;
import org.junit.jupiter.api.Assertions;

public class ResponseChecks {

    public static void checkResponse(Response response){
        Assertions.assertEquals(200, response.getCode(), "Код ответа не соответствует ожидаемому");
        Assertions.assertNotNull(response.getJsonBody(), "Тело ответа отсутствует");
    }
}
