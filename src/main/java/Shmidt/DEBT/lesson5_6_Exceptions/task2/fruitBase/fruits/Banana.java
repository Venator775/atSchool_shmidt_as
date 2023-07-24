package Shmidt.DEBT.lesson5_6_Exceptions.task2.fruitBase.fruits;

import java.math.BigDecimal;

public class Banana extends Fruit {
    public Banana(BigDecimal price, double weight) {
        super(price, weight);
        this.name="Banana";
    }

    public Fruit clone() {
        return new Banana(this.price, this.weight);
    }
}
/*
    Каждый класс наследуется от Fruit
    В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
 */
