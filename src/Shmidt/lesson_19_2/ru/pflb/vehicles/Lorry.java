package Shmidt.lesson_19_2.ru.pflb.vehicles;

import Shmidt.lesson_19_2.ru.pflb.details.Engine;
import Shmidt.lesson_19_2.ru.pflb.professions.Driver;
import Shmidt.lesson_19_2.ru.pflb.vehicles.Car;

public class Lorry extends Car {
    int loadingAmount;//грузоподъемность в киллограммах

    @Override
    public String toString() {
        String parentText = super.toString();
        String text = String.format("\tГрузоподъемность: %s", loadingAmount);
        return parentText +"\n"+ text;
    }


    public Lorry(Car car, int loadingAmount) {
        if (car.vehicleClass == VehicleClass.MEDIUM || car.vehicleClass == VehicleClass.LARGE)
            this.vehicleClass = car.vehicleClass;
        else {
            System.err.println(String.format("Значение vehicleClass для \'%s\' при инициализации устанавливается как MEDIUM или LARGE. Если указано иное, то установится MEDIUM",car.model));
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
