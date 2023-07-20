package lesson11_3_TestUI.task3.Enums;

public enum UserAccounts {

    standard_user("standard_user","secret_sauce"),
    locked_out_user("locked_out_user","secret_sauce"),
    problem_user("problem_user","secret_sauce"),
    performance_glitch_user("performance_glitch_user","secret_sauce"),
    ;
    private String login;
    private String pass;

    UserAccounts(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return pass;
    }
}
