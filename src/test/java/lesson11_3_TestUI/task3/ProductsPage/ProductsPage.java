package lesson11_3_TestUI.task3.ProductsPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
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
     * Всплывающее меню
     * @return
     */
    public SelenideElement burgerMenu() {
        return $x(".//button[@id = 'react-burger-menu-btn']");
    }

    /**
     * Кнопка logout во всплывающем меню
     * @return
     */
    public SelenideElement logoutSidebarLink() {
        return $x(".//a[@id='logout_sidebar_link']");
    }

    /**
     * Кнопка корзины
     * @return
     */
    public SelenideElement busketButton(){
        return $x(".//a[@class='shopping_cart_link']");
    }

    /**
     * Значок на корзине
     * @return
     */
    public SelenideElement buscetButtonBadge(){
        return busketButton().$x(".//span[@class='shopping_cart_badge']");
    }

}
