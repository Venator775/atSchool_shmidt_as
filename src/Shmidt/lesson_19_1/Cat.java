package Shmidt.lesson_19_1;

public class Cat extends Animal {
    static int counter;
    static int foodCounter;

    Cat(String name, HealthState health) {
        this.name = name;
        this.health = health;
        food = "Пурина ван";
        location = "Там, где тепло, есть еда, пакеты и человеки";
        counter++;
    }

    @Override
    void makeSound() {
        System.out.println("Meow motherfucka!");
    }

    @Override
    void eat() {
        if (foodCounter == 0)
            System.out.println("Еды для кошек нет!");
        else {
            System.out.println(String.format("Котик ест: %s", food));
            System.out.println(String.format("Осталось корма: %s", --foodCounter));
        }
    }

    void eat(int foodCount) {
        if (foodCounter == 0)
            System.out.println("Еды для кошек нет!");
        else {
            System.out.println(String.format("Пёсик ест: %s", food));
            System.out.println(String.format("Осталось костей: %s", foodCounter -= foodCount));
        }
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
        return "Животное - кот\n" +
                "\tКличка:" + name + "\n" +
                "\tСтрана обитания:" + location + "\n" +
                "\tСостояние здоровья:" + health + "\n" +
                "\tСколько особей:" + counter;
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