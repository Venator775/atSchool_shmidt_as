package Shmidt.lessonStreamAPI.task1.vegetables;

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
