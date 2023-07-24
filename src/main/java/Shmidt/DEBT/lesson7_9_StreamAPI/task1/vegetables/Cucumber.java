package Shmidt.DEBT.lesson7_9_StreamAPI.task1.vegetables;

public class Cucumber implements Vegetable {
    private String name = "Огурец";
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Cucumber";
    }
}
