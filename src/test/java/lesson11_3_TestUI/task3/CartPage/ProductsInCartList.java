package lesson11_3_TestUI.task3.CartPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lesson11_3_TestUI.task3.ProductsPage.ProductItem;

import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;

public class ProductsInCartList {

    private SelenideElement objectRoot;

    private final ElementsCollection productList = objectRoot == null
            ? $$x(".//div[@class = 'cart_list']//div[@class = 'cart_item']")
            : objectRoot.$$x(".//div[@class = 'cart_list']//div[@class = 'cart_item']");

    public ProductsInCartList() {
    }

    public ProductsInCartList(@Nonnull SelenideElement objectRoot) {
        this.objectRoot = objectRoot;
    }

    /**
     * Список товаров ProductInCartItem на странице
     * @return
     */
    public ArrayList<ProductInCartItem> productInCartItemsList() {//productItem список
        ArrayList<ProductInCartItem> items = new ArrayList<>();

        ElementsCollection elements = $$x(".//div[@class = 'cart_list']//div[@class = 'cart_item']");
        for (SelenideElement el : elements) {
            items.add(new ProductInCartItem(el));
        }

        return items;
    }


    /**
     * Возвращает рандомный товар из списка продуктов
     * @return
     */
    public void removeRandItem() {
        new ProductInCartItem(productList.get(new Random().nextInt(productList.size())))
                .removeItemFromCartButtonClick();
    }

}
