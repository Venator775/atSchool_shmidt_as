package lesson11_3_TestUI.task3.ProductsPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartButton {
    private Condition enVis = and("visible and enabled", Condition.visible, Condition.enabled);
    /**
     * Кнопка корзины
     * @return
     */
    public SelenideElement cartButton(){
        return $x(".//a[@class='shopping_cart_link']");
    }

    /**
     * Значок на корзине
     * @return
     */
    public SelenideElement cartButtonBadge(){
        return cartButton().$x(".//span[@class='shopping_cart_badge']");
    }

    /**
     * Количество продуктов в корзине
     * @return
     */
    public int productsInCartCount(){
        cartButtonBadge().shouldBe(Condition.visible);
        return Integer.parseInt(cartButtonBadge().text());
    }

    /**
     * Клик по корзине
     */
    public void cartButtonClick(){
        cartButton().shouldBe(enVis).click();
    }
}
