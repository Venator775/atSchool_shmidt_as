package Shmidt.generiks.task2.fruits;


public class Banana implements Fruit {
    final private String name = "Банан";
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Banana";
    }
}
