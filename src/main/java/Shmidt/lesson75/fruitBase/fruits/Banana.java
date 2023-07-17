package main.java.Shmidt.lesson75.fruitBase.fruits;

import java.math.BigDecimal;

public class Banana extends Fruit {
    public Banana(String name, BigDecimal price, double weight) {
        super(name, price, weight);
    }

    public Fruit clone() {
        return new Banana(this.name, this.price, this.weight);
    }
}
/*
    Каждый класс наследуется от Fruit
    В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
 */
