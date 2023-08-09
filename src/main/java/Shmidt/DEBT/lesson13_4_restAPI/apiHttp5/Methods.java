package Shmidt.DEBT.lesson13_4_restAPI.apiHttp5;

import org.json.JSONObject;

public interface Methods {
    HttpResponseDecorator get();
    HttpResponseDecorator post(String json);
    HttpResponseDecorator post(JSONObject jsonObj);

}
