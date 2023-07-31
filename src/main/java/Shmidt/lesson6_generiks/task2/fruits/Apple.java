package Shmidt.lesson6_generiks.task2.fruits;

public class Apple implements Fruit {
    final private String name = "Яблоко";
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Apple";
    }
}
