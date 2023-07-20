package lesson11_3_TestUI.task2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BurgerMenu {

    SelenideElement getItemList(){
        return $x(".//nav[@class='bm-item-list']");
    }

    SelenideElement getAllItems(){
        return getSidebarItemDataElement("inventory");
    }

    SelenideElement getAbout(){
        return getSidebarItemDataElement("about");
    }

    SelenideElement getLogout(){
        return getSidebarItemDataElement("logout");
    }

    SelenideElement getReset(){
        return getSidebarItemDataElement("reset");
    }

    public void logoutClick(){
        getLogout().shouldBe(Condition.visible, Condition.enabled).click();
    }

    private SelenideElement getSidebarItemDataElement(String attribute) {
        return $x(String.format(".//a[@id='%s_sidebar_link']", attribute));
    }

}
