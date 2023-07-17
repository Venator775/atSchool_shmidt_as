package main.java.Shmidt.lessonExceptions.task2.fruitBase.fruits;

import java.math.BigDecimal;

public class Apple extends Fruit {
    public Apple(BigDecimal price, double weight) {
        super(price, weight);
        this.name="Apple";
    }

    public Fruit clone() {
        return new Apple(this.price, this.weight);
    }
}
/*
    Каждый класс наследуется от Fruit
    В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
 */