package Shmidt.lesson_19_1;

import static Shmidt.lesson_19_1.HealthState.*;

public class Vet {
    //Имя ветеринара
    private String name;
    Vet(String name){
        this.name = name;
    }

    //Лечение животного во время приёма
    public void treatAnimal(Animal animal){
        if (animal.health != HEALTHY) {
            animal.health = HEALTHY;
            System.out.println(animal.name+" вылечился.");
        }
        else
            System.out.println(animal.name+" здоров!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*
Создайте класс Vet. Класс содержит параметр:
- name - имя ветеринара
Класс содержит методы:
- void treatAnimal(Animal animal) - осуществляет прием у ветеринара,
вылечивает здоровье животного
 */
