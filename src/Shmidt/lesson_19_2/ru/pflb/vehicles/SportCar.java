package Shmidt.lesson_19_2.ru.pflb.vehicles;

import Shmidt.lesson_19_2.ru.pflb.details.Engine;
import Shmidt.lesson_19_2.ru.pflb.professions.Driver;
import Shmidt.lesson_19_2.ru.pflb.vehicles.Car;

public class SportCar extends Car {
    int maxVelocity;//максимальная скорость в км/ч

    public void setVehicleClass(VehicleClass vehicleClass) {
        this.vehicleClass = VehicleClass.SPORTS_CAR;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("\n\tМаксимальная скорость: %s",maxVelocity);
    }

    public void SportCar(String model,
                         VehicleClass vehicleClass,
                         int weight,
                         Driver driver,
                         Engine engine){

        this.vehicleClass = VehicleClass.SPORTS_CAR;
        this.model = model;//название модели автомобиля
        this.weight = weight;//вес автомобиля в килограммах
        this.driver = driver;//водитель, за которым закреплен автомобиль
        this.engine = engine;//тип мотора типа Engine
    }
}
/*
Создать класс SportCar, производный класса Car,
в этом же пакете.
Класс имеет дополнительный параметр:
    maxVelocity - максимальная скорость в км/ч
Значение vehicleClass устанавливается как SPORTS_CAR.
Метод toString надо переопределить.
К выводу в характеристики добавляется максимальная скорость.
 */
