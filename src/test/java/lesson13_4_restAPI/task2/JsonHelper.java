package lesson13_4_restAPI.task2;

import lesson14_3_allure_log4j.apiProj.user.UserChecks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public class JsonHelper {
    private static final Logger logger = LogManager.getLogger(JsonHelper.class);
    public static String getJsonStringParameter(JSONObject json, String parameter) {
        String paramValue = null;
        try {
            paramValue = json.getString(parameter);
        } catch (JSONException ex) {
            logger.error("getJsonStringParameter() - Поля String " + parameter + " не существует");
            logger.trace("getJsonStringParameter() - " + ex.getMessage());
            Assertions.assertNotNull(paramValue, "Поля String " + parameter + " не существует");
        }
        return paramValue;
    }

    public static Integer getJsonIntParameter(JSONObject json, String parameter) {
        Integer paramValue = null;
        try {
            paramValue = json.getInt(parameter);
        } catch (JSONException ex) {
            logger.error("getJsonIntParameter() - Поля int " + parameter + " не существует");
            logger.trace("getJsonIntParameter() - " + ex.getMessage());
            Assertions.fail("Поля int " + parameter + " не существует");
        }
        return paramValue;
    }

    public static JSONArray getJsonArray(JSONObject json, String parameter){
        JSONArray paramValue = null;
        try {
            paramValue = json.getJSONArray(parameter);
        } catch (JSONException ex) {
            logger.error("getJsonArray() - Поля Array " + parameter + " не существует");
            logger.trace("getJsonArray() - " + ex.getMessage());
            Assertions.fail("Поля Array " + parameter + " не существует");
        }
        return paramValue;
    }
}
