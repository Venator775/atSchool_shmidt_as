package Shmidt.lesson_19_2.ru.pflb;

import Shmidt.lesson_19_2.ru.pflb.details.Engine;
import Shmidt.lesson_19_2.ru.pflb.professions.Driver;
import Shmidt.lesson_19_2.ru.pflb.vehicles.Car;
import Shmidt.lesson_19_2.ru.pflb.vehicles.Lorry;
import Shmidt.lesson_19_2.ru.pflb.vehicles.SportCar;
import Shmidt.lesson_19_2.ru.pflb.vehicles.VehicleClass;

public class Main {
    public static void main(String[] args) {
        Engine zmz3302 = new Engine(120, "ЗМЗ");
        Engine twoJZ = new Engine(220, "Toyota");
        Engine valve16 = new Engine(100, "LADA");
        Engine ecoBoost = new Engine(150, "Ford");

        Person jamshut = new Person();
        jamshut.Person(42, "Джамшут");
        Person serega = new Person();
        serega.Person(32, "Серёга");
        Person johny = new Person();
        johny.Person(25, "Джонни");

        Driver jamshut_d = new Driver(jamshut, 22, "c15cee9c-0e9b-4d3f-b029-a543cf62076c");
        Driver serega_d = new Driver(serega, 14, "643e27b6-8c4f-46bd-ba0a-d414671d9261");
        Driver johny_d = new Driver(johny, 3, "9658b666-ce92-4051-af5c-95e63c715e14");


        Car gazel = new Car();
        gazel.Car("Джамшут-мобиль Газель", 1900, VehicleClass.LARGE, jamshut_d, zmz3302);
        Car transit = new Car();
        transit.Car("Джамшут-мобиль Транзит", 2200, VehicleClass.LUXURY, jamshut_d, ecoBoost);
        Car mark2 = new Car();
        mark2.Car("Хороший марк 90", 1415, VehicleClass.LUXURY, serega_d, twoJZ);
        Car dvoika = new Car();
        dvoika.Car("Двоечка на шестнаре", 915, VehicleClass.SMALL, johny_d, valve16);


        Lorry gazel_l = new Lorry(gazel, 1100);
        Lorry transit_l = new Lorry(transit, 700);
        SportCar mark2_sc = new SportCar(mark2, 220);


        System.out.println("\nПринт двигателя");
        System.out.println(twoJZ);

        System.out.println("\nПринт человека");
        System.out.println(jamshut);

        System.out.println("\nПринт водителя");
        System.out.println(serega_d);

        System.out.println("\nПринт обычной машины");
        System.out.println(dvoika);

        System.out.println("\nПринт спорткара");
        System.out.println(mark2_sc);



        System.out.println("\nПринт Финальный");
        System.out.println(gazel_l + "\n\n" +
                transit_l + "\n\n" +
                mark2_sc);


    }
}
/*
Создайте класс Main со статическим метод main, в котором:
- создаются 3 разных типа автомобиля (Lorry, SportCar, Car)
    все необходимые для этого объекты
    также создаются в main и передаются в необходимые конструкторы
- вывести всю информацию о созданных машинах и вложенных объектах
 */
