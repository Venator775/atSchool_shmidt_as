package Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase;

import Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.fruits.Fruit;

import java.math.BigDecimal;

public interface Delivery {
    double getWeight();
    BigDecimal getPrice();
    void addFruit(Fruit fruit);
    Fruit[] getFruits();
    Fruit removeFruit(Fruit fruit);
}
