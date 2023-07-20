package lesson11_3_TestUI.task3.CartPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lesson11_3_TestUI.task3.Enums.ItemDataElement;

import java.math.BigDecimal;


public class ProductInCartItem {

    private String name;
    private String desc;
    private String price;
    private SelenideElement source;

    public ProductInCartItem(SelenideElement source) {
        this.source = source;
    }

    public SelenideElement itemName() {
        this.name = getItemDataElement(ItemDataElement.NAME).text();
        return getItemDataElement(ItemDataElement.NAME);
    }

    public SelenideElement itemDesc() {
        this.desc = getItemDataElement(ItemDataElement.DESC).text();
        return getItemDataElement(ItemDataElement.DESC);
    }

    public SelenideElement itemPrice() {
        this.price = getItemDataElement(ItemDataElement.PRICE).text();
        return getItemDataElement(ItemDataElement.PRICE);
    }

    public SelenideElement removeItemFromCartButton() {
        return source.$x(".//button[@class='btn btn_secondary btn_small cart_button']");
    }

    /**
     * Удалить товар из корзины
     */
    public void removeItemFromCartButtonClick() {
        removeItemFromCartButton().shouldBe(Condition.visible, Condition.enabled).click();
    }

    /**
     * Возвращает значение стоимости товара
     *
     * @return
     */
    public BigDecimal getPriceValue() {
        return new BigDecimal(itemPrice().getText().replace("$", ""));
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

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }
}
