package Shmidt.DEBT.lesson13_4_restAPI.task2;

import org.json.JSONObject;

public class Post {
    private int id;
    private String title;
    private int userId;

    Post(JSONObject jsonObject) {
        this.title = jsonObject.toString();
    }

    //region getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    //endregion
}
