package main.java.Shmidt.lesson75.fruitBase.fruits;

public enum Freshness {
    FRESH("Продукт свежий"),
    OVERRIPED("Продукт перезрелый"),
    SPOILED("Продукт испорченный");

    private String description;

    Freshness(String description) {
        this.description = description;
    }
}