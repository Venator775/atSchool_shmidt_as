package Shmidt.abstractAndInterfaces.lesson10.fruitBase.fruits;

import java.math.BigDecimal;

public class Orange extends Fruit {
    public Orange(String name, BigDecimal price, double weight) {
        super(name, price, weight);
    }

    public Fruit clone() {
        return new Orange(this.name, this.price, this.weight);
    }
}
/*
    Каждый класс наследуется от Fruit
    В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
 */
