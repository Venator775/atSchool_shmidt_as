package Shmidt.DEBT.lesson5_6_Exceptions.task2.fruitBase.fruits;

import java.math.BigDecimal;

public class Pineapple extends Fruit {
    public Pineapple(BigDecimal price, double weight) {
        super(price, weight);
        this.name="Pineapple";
    }

    public Fruit clone() {
        return new Pineapple(this.price, this.weight);
    }
}
/*
    Каждый класс наследуется от Fruit
    В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
 */
