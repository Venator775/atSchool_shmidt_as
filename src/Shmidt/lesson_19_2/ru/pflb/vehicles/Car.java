package Shmidt.lesson_19_2.ru.pflb.vehicles;

import Shmidt.lesson_19_2.ru.pflb.details.Engine;
import Shmidt.lesson_19_2.ru.pflb.professions.Driver;

public class Car {
    String model;//название модели автомобиля
    VehicleClass vehicleClass;//класc автомобиля типа vehicleClass
    int weight;//вес автомобиля в килограммах
    Driver driver;//водитель, за которым закреплен автомобиль
    Engine engine;//тип мотора типа Engine

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
        String text = String.format("\tМодель: %s, класс: %s\n" +
                        "\tХарактеристики:\n" +
                        "\tвес: %s\n" +
                        "\tдвигатель: %s\n" +
                        "\tВодитель: %s",
                model, vehicleClass, weight, engine.toString(), driver.toString());
        System.out.println(text);
        return text;
    }

    public void Car(String model,
               int weight,
               VehicleClass vehicleClass,
               Driver driver,
               Engine engine) {
        this.vehicleClass = vehicleClass;//класc автомобиля типа vehicleClass
        this.model = model;//название модели автомобиля
        this.weight = weight;//вес автомобиля в килограммах
        this.driver = driver;//водитель, за которым закреплен автомобиль
        this.engine = engine;//тип мотора типа Engine
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
