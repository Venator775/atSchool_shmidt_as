package Shmidt.lesson_19_2.ru.pflb.vehicles;

import Shmidt.lesson_19_2.ru.pflb.details.Engine;
import Shmidt.lesson_19_2.ru.pflb.professions.Driver;
import Shmidt.lesson_19_2.ru.pflb.vehicles.Car;

public class Lorry extends Car {
    int loadingAmount;//грузоподъемность в киллограммах

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tГрузоподъемность: " + loadingAmount;
    }


    public Lorry(Car car, int loadingAmount) {
        super(car.model, car.weight, car.vehicleClass, car.driver, car.engine);
        if (car.vehicleClass == VehicleClass.MEDIUM || car.vehicleClass == VehicleClass.LARGE)
            this.vehicleClass = car.vehicleClass;
        else {
            System.err.println("Значение vehicleClass для \'" + car.model + "\' при инициализации устанавливается как MEDIUM или LARGE. Если указано иное, то установится MEDIUM");
            this.vehicleClass = VehicleClass.MEDIUM;
        }

        this.model = car.model;
        this.weight = car.weight;
        this.driver = car.driver;
        this.engine = car.engine;
        this.loadingAmount = loadingAmount;
    }

}
/*
Создать класс Lorry (грузовик), производный класса Car,
в этом же пакете.
Класс имеет дополнительный параметр:
    loadingAmount - грузоподъемность в киллограммах
Значение vehicleClass устанавливается как MEDIUM или LARGE.
Метод toString надо переопределить.
К выводу в характеристики добавляется грузоподъемность.
 */
