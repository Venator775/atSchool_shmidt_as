package lesson11_3_TestUI.task3.CartPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lesson11_3_TestUI.task3.Enums.ItemDataElement;


public class ProductInCartItem {
    private SelenideElement source;

    public ProductInCartItem(SelenideElement source) {
        this.source = source;
    }

    public SelenideElement itemName() {
        return getItemDataElement(ItemDataElement.NAME);
    }

    public SelenideElement itemDesc() {
        return getItemDataElement(ItemDataElement.DESC);
    }

    public SelenideElement itemPrice() {
        return getItemDataElement(ItemDataElement.PRICE);
    }

    public SelenideElement removeItemFromCartButton() {
        return source.$x(".//button[@class='btn btn_secondary btn_small cart_button']");
    }

    public void removeItemFromCartButtonClick() {
        removeItemFromCartButton().shouldBe(Condition.visible, Condition.enabled).click();
    }

    /**
     * Возвращает искомый inventory_item_attribute на объекте по xpath
     *
     * @param attribute
     * @return
     */
    private SelenideElement getItemDataElement(ItemDataElement attribute) {
        return source.$x(String.format(".//div[@class='inventory_item_%s']", attribute.getValue()));
    }
}
