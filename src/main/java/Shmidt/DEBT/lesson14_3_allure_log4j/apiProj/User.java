package Shmidt.DEBT.lesson14_3_allure_log4j.apiProj;

import org.json.JSONObject;

public class User {
    private int id;
    private String login;
    private String password;

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(JSONObject userJson) {
        this.id = userJson.getInt("id");
        this.login = userJson.getString("username");
        this.password = userJson.getString("password");
    }

    //region getters/setters
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    //endregion
}
