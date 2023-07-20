package lesson11_3_TestUI.task3;

import com.codeborne.selenide.Condition;
import lesson11_3_TestUI.task3.CartPage.CartPage;
import lesson11_3_TestUI.task3.CartPage.ProductsInCartList;
import lesson11_3_TestUI.task3.Enums.UserAccounts;
import lesson11_3_TestUI.task3.ProductsPage.ProductItem;
import lesson11_3_TestUI.task3.ProductsPage.ProductItemsList;
import lesson11_3_TestUI.task3.ProductsPage.ProductsPage;
import lesson11_3_TestUI.task3.ProductsPage.ShoppingCartButton;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
//mvn -Dgroups=task3 test

public class SwagLabsTest3 {

    private static List<ProductItem> addedProductsList;

    @DisplayName("Страница авторизации")
    @BeforeEach
    void loginPageTest() {
        Authorization.authorize(User.getEnumUser(UserAccounts.standard_user));
        webdriver().shouldHave(url("https://www.saucedemo.com/inventory.html"));
        System.out.println("Залогинились");
    }

    @DisplayName("Закрытие браузера")
    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @DisplayName("Страница продуктов")
    @Tag("task3")
    @Tag("smoke")
    @Test
    void productsPageListTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductItemsList itemList = new ProductItemsList();

        productsPage.productsTitle().shouldBe(Condition.visible);
        productsPage.inventoryList().shouldBe(Condition.visible, Condition.enabled);
        System.out.println("Открыли страницу продуктов");

        int addProductsCount = 3;
        itemList.selectFewRandomItems(addProductsCount)
                .forEach(ProductItem::addToCartButtonClick);
        addedProductsList = new ArrayList<>(itemList.selectFewRandomItems(addProductsCount));

        System.out.println("Добавили в корзину");

        ShoppingCartButton shoppingCartButton = new ShoppingCartButton();
        shoppingCartButton.cartButton().shouldBe(Condition.visible);

        Assertions.assertEquals(addProductsCount, shoppingCartButton.productsInCartCount(), "Количество продуктов, добавленных в корзину не соответствует требуемому");

        shoppingCartButton.cartButtonClick();
        System.out.println("Перешли в корзину");
    }


    @Test
    @Tag("task3")
    @DisplayName("Экран товаров в корзине")
    void shoppingCartTest() {
        productsPageListTest();

        CartPage cartPage = new CartPage();
        cartPage.title().shouldBe(Condition.visible);
        cartPage.cartList().shouldBe(Condition.visible);

        ProductsInCartList productsInCartList = new ProductsInCartList();

        Assertions.assertEquals(addedProductsList.size(), productsInCartList.productInCartItemsList().size());
        for (int i = 0; i < addedProductsList.size(); i++) {
            Assertions.assertEquals(addedProductsList.get(i).getName(), productsInCartList.productInCartItemsList().get(i).getName());
            Assertions.assertEquals(addedProductsList.get(i).getDesc(), productsInCartList.productInCartItemsList().get(i).getDesc());
            Assertions.assertEquals(addedProductsList.get(i).getPrice(), productsInCartList.productInCartItemsList().get(i).getPrice());
        }

        productsInCartList.removeRandItem();
        Assertions.assertEquals(1, addedProductsList.size() - productsInCartList.productInCartItemsList().size());

    }
}
