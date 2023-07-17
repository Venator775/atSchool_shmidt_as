package main.java.Shmidt.lessonStreamAPI.task1.vegetables;

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
