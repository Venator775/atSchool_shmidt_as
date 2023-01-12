package Shmidt.lesson_19_1;

public class Dog extends Animal {
    static private int counter;
    static private int foodCounter;

    Dog(String name, HealthState health) {
        this.name = name;
        this.health = health;
        food = "Люксовые кости";
        location = "Там, где тепло человеки и кости";
        counter++;
    }

    public static void setFoodCounter(int foodCounter) {
        Dog.foodCounter = foodCounter;
    }

    @Override
    public void eat() {
        super.eat(foodCounter);
    }

    @Override
    void makeSound() {
        System.out.println("WOOF-WOOF mothefucka!");
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
        return String.format(super.toString(), "Собака", counter);
    }
}
