package Shmidt.lesson66.task2.fruitBase.fruits;

import java.math.BigDecimal;

public abstract class Fruit {
    protected String name;
    protected BigDecimal price;
    protected double weight;

    public Fruit(String name, BigDecimal price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
/*
- абстрактный класс Fruit
    находится в пакете com.fruitbase.fruits
    содержит наследуемое поле вес
    содержит наследуемое поле цена
    содержит наследуемое поле name
    содержит общедоступный метод по-умолчанию для получения значения веса getWeight
    содержит общедоступный метод по-умолчанию для получения значения цены getPrice
    содержит общедоступный метод по-умолчанию для получения значения цены getName
 */
