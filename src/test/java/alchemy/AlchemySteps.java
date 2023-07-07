package alchemy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import task1.NatureElement;
import task1.baseElements.Air;
import task1.baseElements.Fire;


public class AlchemySteps {

    private NatureElement resultElementWithAir;
    private NatureElement resultElementWithFire;
    private NatureElement resultElementWithGround;
    private NatureElement resultElementWithWater;

    //region Воздух
    @Given("Создать элемент воздух {string}")
    public void createAir(String air) {
        NatureElement airElement = NatureElement.create(air);
        Assertions.assertNotNull(airElement, "Не удалось создать воздух");
        System.out.println("Создали воздух");
    }

    @Given("Соединить воздух с {string}")
    public void connectAir(String elementName) {
        System.out.println("Соединение возуха с элементом " + elementName);
        Air element1 = (Air) NatureElement.create("Air");
        NatureElement element2 = NatureElement.create(elementName);
        resultElementWithAir = element1.connect(element2);
    }

    @Then("Проверить результат соединения воздуха с {string}: {string}")
    public void checkAirConnectCreation(String elementToConnect, String resultConnectCreation) {
        if (resultConnectCreation.equalsIgnoreCase("null"))
            resultConnectCreation = null;
        Assertions.assertEquals(resultConnectCreation, resultElementWithAir == null ? null : resultElementWithAir.getClass().getSimpleName());
        System.out.println("Результат соединения воздуха c " + elementToConnect + ": " + resultConnectCreation + "\n");
    }
    //endregion Воздух


    //region огонь
    @Given("Создать элемент огонь {string}")
    public void createFire(String fire) {
        NatureElement fireElement = NatureElement.create(fire);
        Assertions.assertNotNull(fireElement, "Не удалось создать огонь");
        System.out.println("Создали огонь");
    }

    @Given("Соединить огонь с {string}")
    public void connectFire(String elementName) {
        System.out.println("Соединение огня с элементом " + elementName);
        Fire element1 = (Fire) NatureElement.create("Fire");
        NatureElement element2 = NatureElement.create(elementName);
        resultElementWithFire = element1.connect(element2);
    }

    @Then("Проверить результат соединения огня с {string}: {string}")
    public void checkFireConnectCreation(String elementToConnect, String resultConnectCreation) {
        if (resultConnectCreation.equalsIgnoreCase("null"))
            resultConnectCreation = null;
        Assertions.assertEquals(resultConnectCreation, resultElementWithFire == null ? null : resultElementWithFire.getClass().getSimpleName());
        System.out.println("Результат соединения огня c " + elementToConnect + ": " + resultConnectCreation + "\n");
    }
    //endregion огонь


    @Given("Создать элемент вода {string}")
    public void createWater() {
        NatureElement.create("Water");
        System.out.println("Создали воду");
    }


    @Given("Создать элемент земля {string}")
    public void createGround() {
        NatureElement.create("Ground");
        System.out.println("Создали землю");
    }
}


