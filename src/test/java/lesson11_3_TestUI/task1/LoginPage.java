package lesson11_3_TestUI.task1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage {
    final private static String URL = "https://www.saucedemo.com/";
    final private static SelenideElement logo = $x("//div[@class = 'login_logo']");

    @Test
    void testLogo() {
        Configuration.timeout = 30000;

        open(URL);
        Assert.isTrue(logo.isDisplayed(), "Страница не открыта");
        Assert.isTrue(logo.getText().equals("Swag Labs"), "Лого не содержит искомый текст");
    }
}
/*
Проверка открытия страницы www.saucedemo.com.
Добавьте класс LoginPage, представляющий проверяемую страницу.
У класса есть следующие параметры:
-  адрес страницы
-  веб-элемент лого страницы с текстом "Swag Labs"

Напишите тест, в котором:
-  открывается страница
-  проверяется, что перешли на страницу LoginPage
   (отображается элемент с заголовком и содержит верный текст "Swag Labs")
 */