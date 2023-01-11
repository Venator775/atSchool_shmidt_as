package Shmidt.lesson_19_1;

public class Horse extends Animal {
    static private int counter;
    static private int foodCounter;

    Horse(String name, HealthState health) {
        this.name = name;
        this.health = health;
        food = "Сено, травка, яблочки.... соль О.О";
        location = "В деревнях с человеками";
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Horse.counter = counter;
    }

    public static int getFoodCounter() {
        return foodCounter;
    }

    public static void setFoodCounter(int foodCounter) {
        Horse.foodCounter = foodCounter;
    }

    @Override
    void makeSound() {
        System.out.println("I-GO-GO mothefucka!");
    }

    @Override
    void eat() {
        System.out.println("Лошадь ест: " + food);
        System.out.println("Осталось травы: " + --foodCounter);
    }

    void eat(int foodCount) {
        System.out.println("Пёсик ест: " + food);
        System.out.println("Осталось костей: " + (foodCounter -= foodCount));
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
        return "Животное - лошадь\n" +
                "\tКличка:" + name + "\n" +
                "\tСтрана обитания:" + location + "\n" +
                "\tСостояние здоровья:" + health + "\n" +
                "\tСколько особей:" + counter;
    }
}
