package Shmidt.lesson75.fruitBase.fruits;

import java.math.BigDecimal;

public class Banana extends Fruit {
    public Banana(String name, BigDecimal price, double weight) {
        super(name, price, weight);
    }

    public Banana(String name, BigDecimal price, double weight, Freshness freshness) {
        super(name, price, weight, freshness);
    }
}
/*
    Каждый класс наследуется от Fruit
    В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
 */
