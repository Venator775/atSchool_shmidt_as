package Shmidt.lesson19_2.ru.pflb.vehicles;


public class SportCar extends Car {
    private int maxVelocity;//максимальная скорость в км/ч

    public SportCar(Car car, int maxVelocity) {
        super(car.getModel(), car.getWeight(), car.getVehicleClass(), car.getDriver(), car.getEngine());

        this.setVehicleClass(VehicleClass.SPORT_CAR);
        this.maxVelocity = maxVelocity;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tМаксимальная скорость: " + maxVelocity;
    }

    public int getMaxVelocity() {
        return maxVelocity;
    }

    public void setMaxVelocity(int maxVelocity) {
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
