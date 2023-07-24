package Shmidt.lesson6_generiks.task1.vegetables;

public class Cucumber implements Vegetable{
    private String name = "Cucumber";
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Cucumber";
    }
}
