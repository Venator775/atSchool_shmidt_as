package lesson11_3_TestUI.task3.ProductsPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {
    private Condition enVis = and("visible and enabled", Condition.visible, Condition.enabled);

    /**
     * Заголовок на странице продуктов
     *
     * @return
     */
    public SelenideElement productsTitle() {
        return $x("//span[@class = 'title' and contains(text(), Products)]");
    }

    /**
     * Список товаров на странице
     *
     * @return
     */
    public SelenideElement inventoryList() {
        return $x(".//div[@class = 'inventory_list']");
    }

    /**
     * Всплывающее меню
     *
     * @return
     */
    public SelenideElement burgerMenuIcon() {
        return $x(".//button[@id = 'react-burger-menu-btn']");
    }

    /**
     * Кнопка корзины
     * @return
     */
    public SelenideElement cartIcon(){
        return $x(".//a[@class='shopping_cart_link']");
    }

    /**
     * Проверяет наличие базовых атрибутов страницы
     */
    public void smokeCheck() {
        productsTitle().shouldBe(Condition.visible);
        burgerMenuIcon().shouldBe(Condition.visible, Condition.enabled);
        inventoryList().shouldBe(Condition.visible, Condition.enabled);
        cartIcon().shouldBe(Condition.visible, Condition.enabled);
        System.out.println("Смок проверки страницы продуктов пройдены");
    }

    public void burgerMenuIconClick() {
        burgerMenuIcon().shouldBe(enVis).click();
    }
}
