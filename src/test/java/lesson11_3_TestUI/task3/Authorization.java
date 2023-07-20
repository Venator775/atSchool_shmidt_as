package lesson11_3_TestUI.task3;

import com.codeborne.selenide.Configuration;
import lesson11_3_TestUI.task3.LoginPage.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class Authorization {
    final private static String URL = "https://www.saucedemo.com/";
    public static void authorize(User user){
        open(URL);
        Configuration.timeout = 10000;
        new LoginPage()
                .fillLogin(user.getLogin())
                .fillPassword(user.getPassword())
                .loginButtonClick();
    }
}
