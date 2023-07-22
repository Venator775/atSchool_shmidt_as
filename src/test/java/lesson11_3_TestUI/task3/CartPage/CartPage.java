package lesson11_3_TestUI.task3.CartPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    Condition enVis = and("visible and enabled", Condition.visible, Condition.enabled);
    public SelenideElement title() {
        return $x(".//span[@class='title']");
    }

    public SelenideElement cartList() {
        return $x(".//div[@class='cart_list']");
    }

    public SelenideElement continueShoppingButton() {
        return $x(".//button[@id='continue-shopping']");
    }

    public SelenideElement checkoutButton() {
        return $x(".//button[@id='checkout']");
    }

    public void smokeCheck() {
        Assertions.assertEquals("Your Cart", title().text());
        cartList().shouldBe(Condition.visible);
        continueShoppingButton().shouldBe(enVis);
        checkoutButton().shouldBe(enVis);
    }
}
