package lesson11_3_TestUI.task4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    Condition enVis = and("visible and enabled", Condition.visible, Condition.enabled);
    SelenideElement header3(){
        return $x(".//h3");
    }
    SelenideElement header4(){
        return $x(".//h4");
    }

    SelenideElement startButton(){
        return $x(".//button");
    }

    SelenideElement loader(){
        return $x(".//div[@id='loading']");
    }

    SelenideElement helloWorldLabel(){
        return $x(".//div[@id='finish']");
    }

    void startButtonClick(){
        startButton().shouldBe(enVis).click();
    }
    public void smokeCheck(){
        header3().shouldBe(Condition.visible);
        header4().shouldBe(Condition.visible);
        startButton().shouldBe(enVis);
        loader().shouldHave(Condition.hidden);
        helloWorldLabel().shouldHave(Condition.attribute("style","display: none;"));
    }
}
