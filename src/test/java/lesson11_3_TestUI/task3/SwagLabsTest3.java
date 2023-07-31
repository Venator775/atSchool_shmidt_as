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

        System.out.println("Залогинились");
    }


    @DisplayName("Страница продуктов")
    @Tag("task3")
    @Tag("smoke")
    @Test
    void productsPageTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductItemsList itemList = new ProductItemsList();

        productsPage.smokeCheck();
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


    @DisplayName("Экран товаров в корзине")
    @Tag("task3")
    @Test
    void shoppingCartTest() {
        productsPageTest();

        CartPage cartPage = new CartPage();
        cartPage.smokeCheck();


        ProductsInCartList productsInCartList = new ProductsInCartList();
        checkProductCartCondition(productsInCartList);

        productsInCartList.removeRandItem();
        Assertions.assertEquals(1, addedProductsList.size() - productsInCartList.productInCartItemsList().size());

    }


    /**
     * Проверяет соответствие добавленных продуктов и имеющихся в корзине
     * @param productsInCartList
     */
    private void checkProductCartCondition(ProductsInCartList productsInCartList){
        Assertions.assertEquals(addedProductsList.size(), productsInCartList.productInCartItemsList().size());
        for (int i = 0; i < addedProductsList.size(); i++) {
            Assertions.assertEquals(addedProductsList.get(i).getName(), productsInCartList.productInCartItemsList().get(i).getName());
            Assertions.assertEquals(addedProductsList.get(i).getDesc(), productsInCartList.productInCartItemsList().get(i).getDesc());
            Assertions.assertEquals(addedProductsList.get(i).getPrice(), productsInCartList.productInCartItemsList().get(i).getPrice());
        }
    }


    @DisplayName("Закрытие браузера")
    @AfterEach
    void closeBrowser() {
        closeWebDriver();
        System.out.println("Закрыли браузер");
    }
}
