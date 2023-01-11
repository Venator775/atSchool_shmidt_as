package Shmidt.lesson_19_1;

import static Shmidt.lesson_19_1.HealthState.*;

public class Main {
    public static void main(String[] args) {

        Cat.setFoodCounter(10);
        Dog.setFoodCounter(12);
        Horse.setFoodCounter(123);
        Cat cat1 = new Cat("Барсик", HEALTHY);
        cat1.eat();
        cat1.makeSound();
        cat1.sleep();
        System.out.println("\nВывод Барсика");
        System.out.println(cat1);

        Cat cat3 = new Cat("Пикси", HEALTHY);
        Cat cat2 = new Cat("ЧЁРНАЯТЬМА", HEALTHY);
        System.out.println("\nВывод ЧЁРНОЙТЬМЫ");
        System.out.println(cat2);


        Dog dog1 = new Dog("Бобик", UNHEALTHY);
        Dog dog2 = new Dog("Брут", HEALTHY);
        dog1.eat(7);
        dog2.makeSound();
        dog2.sleep();
        System.out.println("\nВывод Брута");
        System.out.println(dog2);


        Horse horse1 = new Horse("Сабатон", UNHEALTHY);
        horse1.eat();
        horse1.makeSound();
        horse1.sleep();
        System.out.println("\nВывод Сабатона");
        System.out.println(horse1);


        System.out.println("\nПоходы к ветеринару:");
        Vet vet = new Vet("Айболит");
        vet.treatAnimal(horse1);
        vet.treatAnimal(dog1);
        vet.treatAnimal(dog2);
        vet.treatAnimal(cat1);
        vet.treatAnimal(cat3);
        System.out.println(horse1);
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(cat1);
        System.out.println(cat3);

        System.out.println("\nЖивотные идут спать");
        cat3.sleep();
        dog2.sleep();
        horse1.sleep();
    }
}
/*
Создайте класс Main со статическим метод main, в котором:

- добавьте переменные в классов Dog, Cat, Horse
- выведите внутреннию информацию о каждой особи
- выведите результат makeSound для каждой особи
- вызовите метод eat у некоторых животных
- создайте ветеринара и отведите каждого животного на прием
- вызовите метод sleep у некоторых животных
 */
