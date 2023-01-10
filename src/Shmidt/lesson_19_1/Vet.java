package Shmidt.lesson_19_1;

public class Vet {
    //Имя ветеринара
    public String name;
    Vet(String name){
        this.name = name;
    }

    //Лечение животного во время приёма
    public void treatAnimal(Animal animal){
        if (animal.health != Animal.HealthState.HEALTHY) {
            animal.health = Animal.HealthState.HEALTHY;
            System.out.println(String.format("%s вылечился.",animal.name));
        }
        else
            System.out.println(String.format("%s здоров!",animal.name));
    }
}
/*
Создайте класс Vet. Класс содержит параметр:
- name - имя ветеринара
Класс содержит методы:
- void treatAnimal(Animal animal) - осуществляет прием у ветеринара,
вылечивает здоровье животного
 */
