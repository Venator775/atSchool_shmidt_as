package main.java.Shmidt.lesson19_1;

import java.util.List;

import static main.java.Shmidt.lesson19_1.HealthState.HEALTHY;
import static main.java.Shmidt.lesson19_1.HealthState.UNHEALTHY;

public class Main {
    public static void main(String[] args) {

        Cat.setFoodCounter(10);
        Dog.setFoodCounter(12);
        Horse.setFoodCounter(123);

        Cat cat1 = new Cat("Барсик", HEALTHY,3);
        Cat cat2 = new Cat("ЧЁРНАЯТЬМА", HEALTHY,2);
        Cat cat3 = new Cat("Пикси", HEALTHY,5);
        Dog dog1 = new Dog("Бобик", UNHEALTHY);
        Dog dog2 = new Dog("Брут", HEALTHY);
        Horse horse1 = new Horse("Сабатон", UNHEALTHY);
        Vet vet = new Vet("Айболит");

        List.of(cat1, cat2, cat3, dog1, dog2, horse1)
                .stream().forEach((animal)->{
                    System.out.println(animal.toString());
                    animal.makeSound();
                    animal.eat();
                    vet.treatAnimal(animal);
                    animal.sleep();
                });


        //List<Animal> listOfAnimals = List.of(cat1, cat2, cat3, dog1, dog2, horse1);
//        for (Animal animal : listOfAnimals) {
//            System.out.println(animal.toString());
//            animal.makeSound();
//            animal.eat();
//            vet.treatAnimal(animal);
//            animal.sleep();
//        }
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
