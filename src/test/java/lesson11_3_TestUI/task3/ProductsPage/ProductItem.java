package lesson11_3_TestUI.task3.ProductsPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lesson11_3_TestUI.task3.Enums.ItemDataElement;

import java.math.BigDecimal;

import static com.codeborne.selenide.Condition.and;

public class ProductItem {
    private Condition enVis = and("visible and enabled", Condition.visible, Condition.enabled);
    private String name;
    private String desc;
    private String price;

    private SelenideElement source;

    public ProductItem(SelenideElement source) {
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

    public SelenideElement addToCartButton() {
        return source.$x(".//button[@class='btn btn_primary btn_small btn_inventory']");
    }

    public SelenideElement removeFromCartButton() {
        return source.$x(".//button[@class='btn btn_secondary btn_small btn_inventory']");
    }

    /**
     * Возвращает BigDecimal стоимость товара
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

    /**
     * Клик по кнопке Добавить в корзину
     */
    public void addToCartButtonClick() {
        addToCartButton().shouldBe(enVis).click();
    }

    /**
     * Клик по кнопке Убрать из корзины
     */
    public void removeFromCartButtonClick() {
        removeFromCartButton().shouldBe(enVis).click();
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
