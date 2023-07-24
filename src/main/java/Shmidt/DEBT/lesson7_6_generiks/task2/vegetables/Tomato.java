package Shmidt.DEBT.lesson7_6_generiks.task2.vegetables;

public class Tomato implements Vegetable {
    final private String name = "Помидор";
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Tomato";
    }
}
