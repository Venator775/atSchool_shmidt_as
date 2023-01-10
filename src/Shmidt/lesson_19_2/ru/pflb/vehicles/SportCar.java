package Shmidt.lesson_19_2.ru.pflb.vehicles;

import Shmidt.lesson_19_2.ru.pflb.details.Engine;
import Shmidt.lesson_19_2.ru.pflb.professions.Driver;

public class SportCar extends Car {
    int maxVelocity;//максимальная скорость в км/ч

    public void setVehicleClass(VehicleClass vehicleClass) {
        this.vehicleClass = VehicleClass.SPORT_CAR;
    }

    @Override
    public String toString(){
        String parentText = super.toString();
        String text = String.format("\tМаксимальная скорость: %s",maxVelocity);
        return parentText +"\n"+ text;
    }

    public SportCar(Car car, int maxVelocity){

        this.vehicleClass = VehicleClass.SPORT_CAR;
        this.model = car.model;
        this.weight = car.weight;
        this.driver = car.driver;
        this.engine = car.engine;
        this.maxVelocity = maxVelocity;
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
