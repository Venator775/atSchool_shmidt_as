package main.java.Shmidt.lesson19_2.ru.pflb.vehicles;

import main.java.Shmidt.lesson19_2.ru.pflb.details.Engine;
import main.java.Shmidt.lesson19_2.ru.pflb.professions.Driver;

public class Car {
    private String model;//название модели автомобиля
    private VehicleClass vehicleClass;//класc автомобиля типа vehicleClass
    private int weight;//вес автомобиля в килограммах
    private Driver driver;//водитель, за которым закреплен автомобиль
    private Engine engine;//тип мотора типа Engine

    public Car(String model, int weight, VehicleClass vehicleClass, Driver driver, Engine engine) {
        this.vehicleClass = vehicleClass;//класc автомобиля типа vehicleClass
        this.model = model;//название модели автомобиля
        this.weight = weight;//вес автомобиля в килограммах
        this.driver = driver;//водитель, за которым закреплен автомобиль
        this.engine = engine;//тип мотора типа Engine
    }

    public void start() {
        System.out.println("Поехали");
    }

    public void stop() {
        System.out.println("Останавливаемся");
    }

    public void turnRight() {
        System.out.println("Поворот направо");
    }

    public void turnLeft() {
        System.out.println("Поворот налево");
    }

    @Override
    public String toString() {
        return "\tМодель: " + model + ", класс: " + vehicleClass + "\n" +
                "\tХарактеристики:\n" +
                "\tвес: " + weight + "\n" +
                "\tдвигатель:" + engine.toString() + "\n" +
                "\tВодитель: " + driver.toString();
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleClass getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(VehicleClass vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
/*
Создать класс Car в пакете ru.pflb.vehicles
Класс содержит поля:
    model - название модели автомобиля
    vehicleClass - класc автомобиля типа vehicleClass
    weight - вес автомобиля в килограммах
    driver - водитель, за которым закреплен автомобиль
    engine - тип мотора типа Engine
Класс содержит методы:
- start         - вывод строку "Поехали"
- stop()        - выводит строку "Останавливаемся"
- turnRight()   - выводит строку "Поворот направо"
- turnLeft()    - выводит строку "Поворот налево"
- toString      - возвращает строку со всей информацией
  Формат вывода:
    Модель: <model>, класс: <vehicleClass>
    Характеристики:
        вес: <weight>
        двигатель: <вывод информации по engine>
    Водитель: <вывод информации по driver>
 */
