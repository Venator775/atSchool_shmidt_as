package lesson11_3_TestUI.task2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {

    /**
     * Заголовок на странице продуктов
     * @return
     */
    public SelenideElement productsTitle() {
        return $x("//span[@class = 'title' and contains(text(), Products)]");
    }

    /**
     * Список товаров на странице
     * @return
     */
    public SelenideElement inventoryList() {
        return $x("//div[@class = 'inventory_list']");
    }

    /**
     * Всплывающее меню
     *
     * @return
     */
    public SelenideElement burgerMenuIcon() {
        return $x(".//button[@id = 'react-burger-menu-btn']");
    }
    public void burgerMenuIconClick() {
        burgerMenuIcon().shouldBe(visible, enabled).click();
    }
}
