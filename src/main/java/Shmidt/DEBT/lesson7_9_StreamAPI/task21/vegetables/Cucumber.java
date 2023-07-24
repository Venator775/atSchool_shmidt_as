package Shmidt.DEBT.lesson7_9_StreamAPI.task21.vegetables;

public class Cucumber implements Vegetable {
    private static int index = 0;

    public Cucumber() {
        this.name = "Огурец" + ++index;
    }

    private String name = "Огурец";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cucumber";
    }
}
