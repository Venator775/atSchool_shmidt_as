package lesson13_4_restAPI.task2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class JsonHelper {
    public static String getJsonStringParameter(JSONObject json, String parameter) {
        String paramValue = null;
        try {
            paramValue = json.getString(parameter);
        } catch (JSONException ex) {
            Assertions.assertNotNull(paramValue, "Поля String" + parameter + " не существует");
        }
        return paramValue;
    }

    public static Integer getJsonIntParameter(JSONObject json, String parameter) {
        Integer paramValue = null;
        try {
            paramValue = json.getInt(parameter);
        } catch (JSONException ex) {
            Assertions.fail("Поля int" + parameter + " не существует");
        }
        return paramValue;
    }

    public static JSONArray getJsonArray(JSONObject json, String parameter){
        JSONArray paramValue = null;
        try {
            paramValue = json.getJSONArray(parameter);
        } catch (JSONException ex) {
            Assertions.fail("поля Array" + parameter + " не существует");
        }
        return paramValue;
    }
}
