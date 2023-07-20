package lesson11_3_TestUI.task3;

import com.codeborne.selenide.Condition;
import lesson11_3_TestUI.task3.CartPage.CartPage;
import lesson11_3_TestUI.task3.CartPage.ProductsInCartList;
import lesson11_3_TestUI.task3.ProductsPage.ShoppingCartButton;
import lesson11_3_TestUI.task3.ProductsPage.ProductItem;
import lesson11_3_TestUI.task3.ProductsPage.ProductItemsList;
import lesson11_3_TestUI.task3.ProductsPage.ProductsPage;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.closeWebDriver;
//mvn -Dgroups=task3 test

public class SwagLabsTest {

    final private static String URL = "https://www.saucedemo.com/";

    @DisplayName("Страница авторизации")
    @BeforeEach
    void loginPageTest() {
        Authorization.authorize(User.getStandardUser());
        System.out.println("Залогинились");
//        System.out.println("Страница авторизации");
//        Configuration.timeout = 10000;
//        LoginPage loginPage = new LoginPage();
//
//        open(URL);
//        Assert.isTrue(loginPage.logo().isDisplayed(), "Страница не открыта");
//        Assert.isTrue(loginPage.logo().getText().equals("Swag Labs"), "Лого не содержит искомый текст");
    }

    @DisplayName("Закрытие браузера")
    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @DisplayName("Страница продуктов")
    @Tag("task3")
    @Test
    void productsPageListTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductItemsList itemList = new ProductItemsList();

        productsPage.productsTitle().shouldBe(Condition.visible);
        productsPage.inventoryList().shouldBe(Condition.visible,Condition.enabled);
        System.out.println("Открыли страницу продуктов");

//        itemList.selectFewRandomItems(3)
//                .forEach((item) -> System.out.println(item.itemName().text()));

        int addProductsCount = 3;
        itemList.selectFewRandomItems(addProductsCount)
                .forEach(ProductItem::addToCartButtonClick);
        List<ProductItem> addedProdList = new ArrayList<>(itemList.selectFewRandomItems(addProductsCount));

        System.out.println("Добавили в корзину");

        ShoppingCartButton shoppingCartButton = new ShoppingCartButton();
        shoppingCartButton.cartButton().shouldBe(Condition.visible);

        Assertions.assertEquals(addProductsCount, shoppingCartButton.productsInCartCount(),"Количество продуктов, добавленных в корзину не соответствует требуемому");

        shoppingCartButton.cartButtonClick();
        System.out.println("Перешли в корзину");

        CartPage cartPage = new CartPage();
        cartPage.title().shouldBe(Condition.visible);
        cartPage.cartList().shouldBe(Condition.visible);

        ProductsInCartList productsInCartList = new ProductsInCartList();
        productsInCartList.productList.first().text();
        productsInCartList.productInCartItemsList().get(0).itemPrice().text();
        productsInCartList.removeRandItem();

        /*
        -  проверяется, что в списке товаров указаны все выбранные товары
  (совпадает название, сумма, описание)
        */
    }
}
