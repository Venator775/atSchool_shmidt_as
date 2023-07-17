package main.java.Shmidt.lessonExceptions.task2.fruitBase.fruits;

import java.math.BigDecimal;

public class Orange extends Fruit {
    public Orange(BigDecimal price, double weight) {
        super(price, weight);
        this.name="Orange";
    }

    public Fruit clone() {
        return new Orange(this.price, this.weight);
    }
}
/*
    Каждый класс наследуется от Fruit
    В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
 */
