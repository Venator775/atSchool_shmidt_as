package lesson11_3_TestUI.task3;

import com.codeborne.selenide.Configuration;
import dev.failsafe.internal.util.Assert;
import lesson11_3_TestUI.User;
import lesson11_3_TestUI.task3.LoginPage.LoginPage;
import lesson11_3_TestUI.task3.ProductsPage.ProductItemsList;
import lesson11_3_TestUI.task3.ProductsPage.ProductsPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
//mvn -Dgroups=task3 test

public class SwagLabsTest {

    final private static String URL = "https://www.saucedemo.com/";

    @DisplayName("Страница авторизации")
    @BeforeEach
    void loginPageTest(){
        Authorization.authorize(User.getStandardUser());
//        System.out.println("Страница авторизации");
//        Configuration.timeout = 10000;
//        LoginPage loginPage = new LoginPage();
//
//        open(URL);
//        Assert.isTrue(loginPage.logo().isDisplayed(), "Страница не открыта");
//        Assert.isTrue(loginPage.logo().getText().equals("Swag Labs"), "Лого не содержит искомый текст");
    }

//    @DisplayName("Ввод данных и вход в учётную запись")
//    @Tag("task3")
    //@Test
    void inputLoginTest(){
        System.out.println("Ввод данных и вход в учётную запись");

        LoginPage loginPage = new LoginPage();
        Assert.isTrue(loginPage.usernameField().isDisplayed() && loginPage.usernameField().isEnabled(),"Поле ввода логина не доступно");
        Assert.isTrue(loginPage.passwordField().isDisplayed() && loginPage.passwordField().isEnabled(),"Поле ввода пароля не доступно");


        loginPage.fillLogin("standard_user");
        loginPage.fillPassword("secret_sauce");

        Assert.isTrue(loginPage.loginButton().isDisplayed() && loginPage.loginButton().isEnabled(), "Кнопка логина недоступна");
        loginPage.loginButton().click();

        ProductsPage productsPage = new ProductsPage();
        Assert.isTrue(productsPage.productsTitle().getText().equals("Products"), "Не открыта страница продуктов");
        System.out.println("Залогинились");

    }


    @DisplayName("Страница продуктов")
    @Tag("task3")
    @Test
    void productsPageListTest() {
        //inputLoginTest();

        ProductItemsList list = new ProductItemsList();
        list.selectRandItem().itemName().text();
        list.selectFewRandomItems(3)
                .stream()
                .forEach((item)-> System.out.println(item.itemName().text()));

        //list.productList.subList()

//        String productItemName = itemsList.get(0).$("div.inventory_item_name").getText();
//        String productItemDesc = itemsList.get(0).$("div.inventory_item_desc").getText();
//        String productItemPrice = itemsList.get(0).$("div.inventory_item_price").getText();
//        SelenideElement addButton = itemsList.get(0).$x("button[@class='btn btn_primary btn_small btn_inventory']");
//        String g = addButton.getText();//не работает
    }
}
