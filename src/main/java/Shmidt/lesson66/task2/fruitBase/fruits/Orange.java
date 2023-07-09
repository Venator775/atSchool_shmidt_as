package Shmidt.lesson66.task2.fruitBase.fruits;

import java.math.BigDecimal;

public class Orange extends Fruit {
    public Orange(String name, BigDecimal price, double weight) {
        super(name, price, weight);
    }
}
/*
    Каждый класс наследуется от Fruit
    В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
 */
