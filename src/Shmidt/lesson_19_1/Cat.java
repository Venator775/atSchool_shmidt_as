package Shmidt.lesson_19_1;

public class Cat extends Animal {
    static private int counter;
    static private int foodCounter;

    Cat(String name, HealthState health) {
        this.name = name;
        this.health = health;
        food = "Пурина ван";
        location = "Там, где тепло, есть еда, пакеты и человеки";
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Cat.counter = counter;
    }

    public static int getFoodCounter() {
        return foodCounter;
    }

    public static void setFoodCounter(int foodCounter) {
        Cat.foodCounter = foodCounter;
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
            System.out.println("Котик ест: " + food);
            System.out.println("Осталось корма: " + --foodCounter);
        }
    }

    void eat(int foodCount) {
        if (foodCounter == 0)
            System.out.println("Еды для кошек нет!");
        else {
            System.out.println("Пёсик ест: " + food);
            System.out.println("Осталось костей: " + (foodCounter -= foodCount));
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