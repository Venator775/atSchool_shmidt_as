package lessonStreamAPI.task21.fruits;


public class Banana implements Fruit {
    private String name = "Банан";
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Banana";
    }
}
