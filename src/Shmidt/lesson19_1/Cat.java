package Shmidt.lesson19_1;

public class Cat extends Animal {
    static private int counter;
    static private int foodCounter;

    public Cat(String name, HealthState health, int foodCounter) {
        this.name = name;
        this.health = health;
        food = "Пурина ван";
        location = "Там, где тепло, есть еда, пакеты и человеки";
        counter++;
    }

    public static void setFoodCounter(int foodCounter) {
        Cat.foodCounter = foodCounter;
        return;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow motherfucka!");
    }

    @Override
    public void eat() {
        super.eat(foodCounter);
    }

    @Override
    public String toString() {
        /*
        Формат вывода:
        <Кличка>
        Страна обитания: ...
        Состояние здоровья: ...
        Сколько особей: ...
        */
        return String.format(super.toString(), "Кот", counter);
    }
}

/*
Написать классы Dog, Cat, Horse, которые наследуют Animal
и переопределяют методы makeSound, eat, toString.
Создайте класс Vet. Класс содержит параметр:
- name - имя ветеринара
Класс содержит методы:
- void treatAnimal(Animal animal) - осуществляет прием у ветеринара,
вылечивает здоровье животного
 */