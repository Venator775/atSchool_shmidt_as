package Shmidt.lesson19_1;

public class Horse extends Animal {
    static private int counter;
    static private int foodCounter;

    public Horse(String name, HealthState health) {
        this.name = name;
        this.health = health;
        food = "Сено, травка, яблочки.... соль О.О";
        location = "В деревнях с человеками";
        counter++;
    }

    public static void setFoodCounter(int foodCounter) {
        Horse.foodCounter = foodCounter;
    }

    @Override
    public void eat() {
        super.eat(foodCounter);
    }

    @Override
    public void makeSound() {
        System.out.println("I-GO-GO mothefucka!");
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
        return String.format(super.toString(), "Лошадь", counter);
    }
}
