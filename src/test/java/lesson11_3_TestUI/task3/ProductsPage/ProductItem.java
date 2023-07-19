package lesson11_3_TestUI.task3.ProductsPage;

import com.codeborne.selenide.SelenideElement;

import java.math.BigDecimal;

public class ProductItem {
    private SelenideElement source;

    public ProductItem(SelenideElement source) {
        this.source = source;
    }

    public SelenideElement itemName() {
//        return source.$x(".//div[@class='inventory_item_name']");
        return getItemDataElement("name");
    }

    public SelenideElement itemDesc() {
//        return source.$x(".//div[@class='inventory_item_desc']");
        return getItemDataElement("desc");
    }

    public SelenideElement itemPrice() {
//        return source.$x(".//div[@class='inventory_item_price']");
        return getItemDataElement("price");
    }

//    public SelenideElement addItemButton(){
//        return source.$x(".//button[@class='btn btn_primary btn_small btn_inventory']");
//    }
//
//    public SelenideElement removeItemButton(){
//        return source.$x(".//button[@class='btn btn_secondary btn_small btn_inventory']");
//    }

    public BigDecimal getPrice() {
        return new BigDecimal(itemPrice().getText().replace("$", ""));
    }

    private SelenideElement getItemDataElement(String attribute) {
        return source.$x(String.format(".//div[@class='inventory_item_%s']", attribute));
    }
}
