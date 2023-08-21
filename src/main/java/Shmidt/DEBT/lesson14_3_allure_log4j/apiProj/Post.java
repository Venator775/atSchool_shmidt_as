package Shmidt.DEBT.lesson14_3_allure_log4j.apiProj;

public class Post {
    private int id;
    private String title;
    private int userId;

    public Post(int id, String title, int userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
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