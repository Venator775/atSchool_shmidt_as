package main.java.Shmidt.lambdas.fruitBase.fruits;

public enum Freshness {
    FRESH("Продукт свежий"),
    OVERRIPED("Продукт перезрелый"),
    SPOILED("Продукт испорченный");

    private String description;

    Freshness(String description) {
        this.description = description;
    }
}
