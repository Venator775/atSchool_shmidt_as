package lesson11_3_TestUI.task3;

import lesson11_3_TestUI.task3.Enums.UserAccounts;

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

    public User(UserAccounts userAcc) {
        this.login = userAcc.getLogin();
        this.password = userAcc.getPassword();
    }

    public static User getStandardUser(){
        return new User(UserAccounts.standard_user);
    }

    public static User getEnumUser(UserAccounts userAcc){
        return new User(userAcc);
    }
}
