package Shmidt.lesson_19_1;

public class Dog extends Animal {
    static int counter;
    static int foodCounter;

    Dog(String name, HealthState health) {
        this.name = name;
        this.health = health;
        food = "Люксовые кости";
        location = "Там, где тепло человеки и кости";
        counter++;
    }

    @Override
    void makeSound() {
        System.out.println("WOOF-WOOF mothefucka!");
    }

    @Override
    void eat() {
        if (foodCounter == 0)
            System.out.println("Еды для собак нет!");
        else {
            System.out.println(String.format("Пёсик ест: %s", food));
            System.out.println(String.format("Осталось костей: %s", --foodCounter));
        }
    }

    void eat(int foodCount) {
        if (foodCounter == 0)
            System.out.println("Еды для собак нет!");
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
        return "Животное - собака\n" +
                "\tКличка:" + name + "\n" +
                "\tСтрана обитания:" + location + "\n" +
                "\tСостояние здоровья:" + health + "\n" +
                "\tСколько особей:" + counter;
    }
}
