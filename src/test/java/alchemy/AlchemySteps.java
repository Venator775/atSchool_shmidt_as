package alchemy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import task1.NatureElement;
import task1.baseElements.*;


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
        assert element1 != null;
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
        assert element1 != null;
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


    //region вода
    @Given("Создать элемент вода {string}")
    public void createWater(String water) {
        NatureElement waterElement = NatureElement.create(water);
        Assertions.assertNotNull(waterElement, "Не удалось создать воду");
        System.out.println("Создали воду");
    }

    @Given("Соединить воду с {string}")
    public void connectWater(String elementName) {
        System.out.println("Соединение воды с элементом " + elementName);
        Water element1 = (Water) NatureElement.create("Water");
        NatureElement element2 = NatureElement.create(elementName);
        assert element1 != null;
        resultElementWithWater = element1.connect(element2);
    }

    @Then("Проверить результат соединения воды с {string}: {string}")
    public void checkWaterConnectCreation(String elementToConnect, String resultConnectCreation) {
        if (resultConnectCreation.equalsIgnoreCase("null"))
            resultConnectCreation = null;
        Assertions.assertEquals(resultConnectCreation, resultElementWithWater == null ? null : resultElementWithWater.getClass().getSimpleName());
        System.out.println("Результат соединения воды c " + elementToConnect + ": " + resultConnectCreation + "\n");
    }

    //endregion вода


    @Given("Создать элемент земля {string}")
    public void createGround(String ground) {
        NatureElement groundElement = NatureElement.create(ground);
        Assertions.assertNotNull(groundElement, "Не удалось создать землю");
        System.out.println("Создали землю");
    }

    @Given("Соединить землю с {string}")
    public void connectGround(String elementName) {
        System.out.println("Соединение земли с элементом " + elementName);
        Ground element1 = (Ground) NatureElement.create("Ground");
        NatureElement element2 = NatureElement.create(elementName);
        assert element1 != null;
        resultElementWithGround = element1.connect(element2);
    }

    @Then("Проверить результат соединения земли с {string}: {string}")
    public void checkGroundConnectCreation(String elementToConnect, String resultConnectCreation) {
        if (resultConnectCreation.equalsIgnoreCase("null"))
            resultConnectCreation = null;
        Assertions.assertEquals(resultConnectCreation, resultElementWithGround == null ? null : resultElementWithGround.getClass().getSimpleName());
        System.out.println("Результат соединения земли c " + elementToConnect + ": " + resultConnectCreation + "\n");
    }
}


