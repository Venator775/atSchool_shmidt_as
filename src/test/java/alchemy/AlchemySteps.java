package alchemy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import task1.NatureElement;
import task1.baseElements.Air;
import task1.resultElements.Dust;
import task1.resultElements.Energy;
import task1.resultElements.Pressure;
import task1.resultElements.Rain;

import java.util.ArrayList;
import java.util.List;

public class AlchemySteps {
    private final List<NatureElement> elements = new ArrayList<>();
    private NatureElement resultElementWithAir;

    //region Воздух
    @Given("^Создать элемент воздух$")
    public void createAir() {
        elements.add(NatureElement.create("Air"));
        System.out.println("Создали воздух");
    }

    @Given("^Соединить воздух с {string}$")
    public void connectAir(String elementName) {
        System.out.println("Соединение возуха с элементом " + elementName);
        Air element1 = (Air) NatureElement.create("Air");
        Assertions.assertNotNull(element1);//вариант 1
        NatureElement element2 = NatureElement.create(elementName);
        assert element2 != null;//вариант 2
        resultElementWithAir = element1.connect(element2);
        Assertions.assertNotNull(resultElementWithAir, "Соединение воздуха с " + elementName + " вернуло null");
    }

    @Then("^Проверить результат соединения воздуха с {string} {string}$")
    public void checkConnectCreation(String elementToConnect, String resultConnectCreation) {
        switch (elementToConnect) {
            case ("Water"):
                Assertions.assertEquals(Rain.class.getSimpleName(), resultConnectCreation);
                break;
            case ("Fire"):
                Assertions.assertEquals(Energy.class.getSimpleName(), resultConnectCreation);
                break;
            case ("Ground"):
                Assertions.assertEquals(Dust.class.getSimpleName(), resultConnectCreation);
                break;
            case ("Air"):
                Assertions.assertEquals(Pressure.class.getSimpleName(), resultConnectCreation);
                break;
        }
    }
    //endregion Воздух

    @Given("^Создать элемент вода$")
    public void createWater() {
        elements.add(NatureElement.create("Water"));
        System.out.println("Создали воду");
    }

    @Given("^Создать элемент огонь$")
    public void createFire() {
        elements.add(NatureElement.create("Fire"));
        System.out.println("Создали огонь");
    }

    @Given("^Создать элемент земля$")
    public void createGround() {
        elements.add(NatureElement.create("Ground"));
        System.out.println("Создали землю");
    }
}


