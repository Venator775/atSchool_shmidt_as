package lesson11_3_TestUI.task2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SwagLabsTest2 {

    final private static String URL = "https://www.saucedemo.com/";

    @DisplayName("Тест входа/выхода на сайт")
    @Test
    void loginAndLogoutTest() {
        Configuration.timeout = 30000;
        open(URL);

        LoginPage loginPage = new LoginPage();

        Assert.isTrue(loginPage.logo().isDisplayed(), "Страница не открыта");
        Assert.isTrue(loginPage.logo().getText().equals("Swag Labs"), "Лого не содержит искомый текст");


        loginPage.fillLoginPassword("standard_user", "secret_sauce");
        loginPage.loginButtonClick();
        System.out.println("Залогинились");

        ProductsPage productsPage = new ProductsPage();
        productsPage.burgerMenuIconClick();
        System.out.println("Открыли меню");
        BurgerMenu burgerMenu = new BurgerMenu();
        burgerMenu.logoutClick();

        System.out.println("Разлогинились");
        loginPage.logo().shouldBe(visible);
    }
}
