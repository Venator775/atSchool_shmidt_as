package lesson11_3_TestUI.task3.CartPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    public SelenideElement title() {
        return $x(".//span[@class='title']");
    }

    public SelenideElement cartList() {
        return $x(".//div[@class='cart_list']//div[@class='cart_item']");
    }

    public SelenideElement continueShoppingButton() {
        return $x(".//button[@id='continue-shopping']");
    }

    public SelenideElement checkoutButton() {
        return $x(".//button[@id='checkout']");
    }
}
