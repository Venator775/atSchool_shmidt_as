package lesson11_3_TestUI.task4;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;

public class HeroukappTest {

    @Test
    void dynamicButtonStartTest() {
        open("https://the-internet.herokuapp.com/dynamic_loading/1");
        MainPage mainPage = new MainPage();
        mainPage.smokeCheck();

        mainPage.startButtonClick();
        mainPage.loader().shouldBe(Condition.visible, Duration.ofSeconds(2));

        mainPage.helloWorldLabel().shouldHave(Condition.attribute("style",""), Duration.ofSeconds(10));

    }
}
/*
По аналогии с предыдущими заданиями, напишите тест для страницы
the-internet.herokuapp.com/dynamic_loading/1,
в котором:
- отрывается страница
- проверяется, что отсутсвует элемент с текстом "Hello World"
- нажимается кнопка
- через некоторое время  появляется элемент с текстом
 */