package Shmidt.DEBT.lesson5_6_Exceptions.task2.fruitBase;

import Shmidt.DEBT.lesson5_6_Exceptions.task2.fruitBase.fruits.Fruit;

import java.math.BigDecimal;
import java.util.List;

public interface Delivery {
    double getWeight();
    BigDecimal getPrice();
    void addFruit(Fruit fruit);
    List<Fruit> getFruits();
    Fruit removeFruit(Fruit fruit);
}
