package lesson11_3_TestUI.task3.ProductsPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {

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
     * Кнопка logout во всплывающем меню
     *
     * @return
     */
    public SelenideElement logoutSidebarLink() {
        return $x(".//a[@id='logout_sidebar_link']");
    }

    public void burgerMenuIconClick() {
        burgerMenuIcon().shouldBe(Condition.visible, Condition.enabled).click();
    }
}
