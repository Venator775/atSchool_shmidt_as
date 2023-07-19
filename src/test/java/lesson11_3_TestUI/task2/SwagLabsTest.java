package lesson11_3_TestUI.task2;

import com.codeborne.selenide.Configuration;
import dev.failsafe.internal.util.Assert;
import lesson11_3_TestUI.task3.ProductsPage.ProductsPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SwagLabsTest {

    final private static String URL = "https://www.saucedemo.com/";

    @Test
    void testLogo() {
        Configuration.timeout = 30000;

        LoginPage loginPage = new LoginPage();

        open(URL);
        Assert.isTrue(loginPage.logo().isDisplayed(), "Страница не открыта");
        Assert.isTrue(loginPage.logo().getText().equals("Swag Labs"), "Лого не содержит искомый текст");

        loginPage.usernameField().sendKeys("standard_user");
        loginPage.passwordField().sendKeys("secret_sauce");
        loginPage.loginButton().click();
        System.out.println("Залогинились");

        ProductsPage productsPage = new ProductsPage();

        productsPage.burgerMenu().isDisplayed();
        productsPage.burgerMenu().click();
        System.out.println("Открыли меню");
        productsPage.logoutSidebarLink().isDisplayed();
        productsPage.logoutSidebarLink().click();
        System.out.println("Разлогинились");
        loginPage.logo().isDisplayed();


    }
}
