package Shmidt.generiks.task2.fruits;

public class Apple implements Fruit {
    private String name = "Яблоко";
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Apple";
    }
}
