package lesson11_3_TestUI;

public class User {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static User getStandardUser(){
        return new User("standard_user","secret_sauce");
    }
}
