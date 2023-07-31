package Shmidt.lesson6_generiks.task1.vegetables;

public class Tomato implements Vegetable {
    private String name = "Tomato";
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Tomato";
    }
}
