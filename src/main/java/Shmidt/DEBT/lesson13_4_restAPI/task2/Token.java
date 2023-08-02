package Shmidt.DEBT.lesson13_4_restAPI.task2;

import org.json.JSONObject;

public class Token {
    private String token;

    public Token(String token) {
        this.token = token;
    }
    public Token(JSONObject jsonObject) {
        this.token = jsonObject.getString("token");
    }

    //region getters/setters
    public String getToken() {
        return token;
    }
    //endregion
}
