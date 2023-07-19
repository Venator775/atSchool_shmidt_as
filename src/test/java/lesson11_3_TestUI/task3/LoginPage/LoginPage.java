package lesson11_3_TestUI.task3.LoginPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {

    /**
     * Заголовок на странице
     *
     * @return
     */
    public SelenideElement logo() {
        return $x(".//div[@class = 'login_logo']");
    }


    /**
     * Поле ввода логина
     *
     * @return
     */
    public SelenideElement usernameField() {
        return $x(".//input[@name = 'user-name']");
    }

    /**
     * Поле ввода пароля
     *
     * @return
     */
    public SelenideElement passwordField() {
        return $x(".//input[@name = 'password']");
    }

    /**
     * Кнопка для авторизации под логин/паролем
     *
     * @return
     */
    public SelenideElement loginButton() {
        return $x(".//input[@id='login-button']");
    }


    public LoginPage fillLogin(String login){
        usernameField().shouldBe(Condition.visible, Condition.enabled).sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String password){
        passwordField().shouldBe(Condition.visible, Condition.enabled).sendKeys(password);
        return this;
    }

    public LoginPage loginButtonClick(){
        loginButton().shouldBe(Condition.visible, Condition.enabled).click();
        return this;
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