package Shmidt.DEBT.lesson14_3_allure_log4j.apiProj;

import org.json.JSONObject;

public class Token {
    private String token;

    public Token(String token) {
        this.token = token;
    }

    public Token(JSONObject jsonObject) {
        try {
            this.token = jsonObject.getString("token");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //region getters/setters
    public String getToken() {
        return token;
    }
    //endregion
}
