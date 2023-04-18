package Shmidt.classesDesign.lesson10.fruitBase.fruits;

import java.math.BigDecimal;

public class Pineapple extends Fruit {
    public Pineapple(String name, BigDecimal price, double weight) {
        super(name, price, weight);
    }

    public Fruit clone() {
        return new Pineapple(this.name, this.price, this.weight);
    }
}
/*
    Каждый класс наследуется от Fruit
    В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
 */
