package main.java.Shmidt.generiks.task2.vegetables;

public class Cucumber implements Vegetable {
    final private String name = "Огурец";
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Cucumber";
    }
}
