package Shmidt.lesson19_2.ru.pflb.vehicles;


public class Lorry extends Car {
    private int loadingAmount;//грузоподъемность в киллограммах

    public Lorry(Car car, int loadingAmount) {
        super(car.getModel(), car.getWeight(), car.getVehicleClass(), car.getDriver(), car.getEngine());

        if (car.getVehicleClass() == VehicleClass.MEDIUM || car.getVehicleClass() == VehicleClass.LARGE) {
            this.loadingAmount = loadingAmount;
        } else
            System.err.println("Значение vehicleClass для \'" + car.getModel() + "\' может быть MEDIUM или LARGE. Грузовой автомобиль из данного не возможен");
    }

    @Override
    public String toString() {
        if (this.getVehicleClass() == VehicleClass.MEDIUM || this.getVehicleClass() == VehicleClass.LARGE) {
            return super.toString() + "\n"
                    + "\tГрузоподъемность: " + loadingAmount;
        } else
            return "Значение vehicleClass может быть MEDIUM или LARGE. Грузовой автомобиль из \'" + this.getModel() + "\' не возможен";
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
