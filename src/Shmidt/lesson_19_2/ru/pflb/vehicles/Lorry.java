package Shmidt.lesson_19_2.ru.pflb.vehicles;

import Shmidt.lesson_19_2.ru.pflb.details.Engine;
import Shmidt.lesson_19_2.ru.pflb.professions.Driver;
import Shmidt.lesson_19_2.ru.pflb.vehicles.Car;

public class Lorry extends Car {
    private int loadingAmount;//грузоподъемность в киллограммах

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tГрузоподъемность: " + loadingAmount;
    }


    public Lorry(Car car, int loadingAmount) {
        super(car.getModel(), car.getWeight(), car.getVehicleClass(), car.getDriver(), car.getEngine());
        if (car.getVehicleClass() == VehicleClass.MEDIUM || car.getVehicleClass() == VehicleClass.LARGE)
            this.setVehicleClass(car.getVehicleClass());
        else {
            System.err.println("Значение vehicleClass для \'" + car.getModel() + "\' при инициализации устанавливается как MEDIUM или LARGE. Если указано иное, то установится MEDIUM");
            this.setVehicleClass(VehicleClass.MEDIUM);
        }

        this.setModel(car.getModel());
        this.setWeight(car.getWeight());
        this.setDriver(car.getDriver());
        this.setEngine(car.getEngine());
        this.loadingAmount = loadingAmount;
    }

    public int getLoadingAmount() {
        return loadingAmount;
    }

    public void setLoadingAmount(int loadingAmount) {
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
