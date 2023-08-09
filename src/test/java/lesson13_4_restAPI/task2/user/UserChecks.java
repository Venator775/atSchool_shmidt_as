package lesson13_4_restAPI.task2.user;

import org.json.JSONObject;

import static lesson13_4_restAPI.task2.JsonHelper.getJsonIntParameter;
import static lesson13_4_restAPI.task2.JsonHelper.getJsonStringParameter;

public class UserChecks {
    public static void checkUserJson(JSONObject json) {
        getJsonIntParameter(json, "id");
        getJsonStringParameter(json, "username");
        getJsonStringParameter(json, "password");
    }
}
