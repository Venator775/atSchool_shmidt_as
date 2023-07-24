package Shmidt.lesson6_generiks.task1.fruits;


public class Banana implements Fruit {
    private String name = "Banana";
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Banana";
    }
}
