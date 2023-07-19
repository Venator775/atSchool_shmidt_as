package lesson11_3_TestUI.task2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage {
    public SelenideElement logo() {
        return $x("//div[@class = 'login_logo']");
    }

    public SelenideElement usernameField() {
        return $x("//input[@name = 'user-name']");
    }

    public SelenideElement passwordField() {
        return $x("//input[@name = 'password']");
    }

    public SelenideElement loginButton() {
        return $x("//input[@id='login-button']");
    }
}
/*
Проверка логина и выхода.
В ранее созданном классе LoginPage добавьте следующие параметры:
-  веб-элемент поля username
-  веб-элемент поля password
-  веб-элемент кнопки Login
Также добавьте класс для страницы с продуктами, ProductsPage,
которая открывается после успешного логина.
У класса есть следующие параметры:
-  веб-элемент плашки с текстом "Products"
-  веб-элемент "бургер" (три горизонтальные черты)
  в левом верхнем углу страницы,
  который используется для открытия бокового меню
-  веб-элемент кнопки "Logout" в боковом меню

Напишите тест, в котором:
-  открывается страница LoginPage
-  вводится логин/пароль (standard_user) и нажимается кнопка Login
-  проверяется, что перешли на страницу ProductPage
  (перешли на страницу с нужным адресом
  и есть плашка с текстом Products)
-  проверяется, что отображается "бургер"
-  нажимаете на "бургер"
-  проверяется, что отображается кнопка "Logout"
-  нажимаете на кнопку "Logout"
-  проверяется, что перешли на страницу LoginPage
  (перешли на страницу с нужным адресом
  и есть лого с текстом "Swag Labs")
 */