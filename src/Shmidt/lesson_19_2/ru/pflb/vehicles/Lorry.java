package Shmidt.lesson_19_2.ru.pflb.vehicles;

import Shmidt.lesson_19_2.ru.pflb.details.Engine;
import Shmidt.lesson_19_2.ru.pflb.professions.Driver;
import Shmidt.lesson_19_2.ru.pflb.vehicles.Car;

public class Lorry extends Car {
    int loadingAmount;//грузоподъемность в киллограммах

    public void setVehicleClass(VehicleClass vehicleClass) {
        if (vehicleClass == VehicleClass.MEDIUM || vehicleClass == VehicleClass.LARGE)
            this.vehicleClass = vehicleClass;
        else System.out.println("Значение vehicleClass устанавливается как MEDIUM или LARGE.");
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\n\tГрузоподъемность: %s", loadingAmount);
    }

    public void Lorry(String model,
                      VehicleClass vehicleClass,
                      int weight,
                      Driver driver,
                      Engine engine) {
        if (vehicleClass == VehicleClass.MEDIUM || vehicleClass == VehicleClass.LARGE)
            this.vehicleClass = vehicleClass;
        else {
            System.out.println("Значение vehicleClass устанавливается как MEDIUM или LARGE. По умолчанию установится MEDIUM");
            this.vehicleClass = VehicleClass.MEDIUM;
        }

        this.model = model;//название модели автомобиля
        this.weight = weight;//вес автомобиля в килограммах
        this.driver = driver;//водитель, за которым закреплен автомобиль
        this.engine = engine;//тип мотора типа Engine
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
