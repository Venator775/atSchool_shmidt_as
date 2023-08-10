package Shmidt.lesson7_6_generiks.task3.vegetables;

public class Tomato implements Vegetable {
    private String name = "Помидор";
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Tomato";
    }
}
