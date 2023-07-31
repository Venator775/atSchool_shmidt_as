package Shmidt.DEBT.lesson5_6_Exceptions.task2.fruitBase;

import Shmidt.DEBT.lesson5_6_Exceptions.task2.fruitBase.fruits.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static Shmidt.tests.sideMethods.rnd;

public class FruitCatalogue implements Serializable {
    private List<Fruit> fruitCatalogue;

    /**
     * Инициализируется список фруктов, имеющихся в продаже
     */
    public FruitCatalogue() {
        fruitCatalogue = new ArrayList<>();
        fruitCatalogue.add(new Apple(BigDecimal.valueOf(rnd(10,20)), rnd(110,130)));
        fruitCatalogue.add(new Orange(BigDecimal.valueOf(rnd(10,20)), rnd(90,105)));
        fruitCatalogue.add(new Banana(BigDecimal.valueOf(rnd(25,35)), rnd(95,110)));
        fruitCatalogue.add(new Pineapple(BigDecimal.valueOf(rnd(120,150)), rnd(210,250)));
    }

    public Fruit getFruit(String fruitName) {
        for (Fruit fruit : fruitCatalogue)
            if (fruit.getName().equals(fruitName)) {
                return fruit.clone();
            }
        return null;
    }

    public List<Fruit> getFruitCatalogue() {
        return fruitCatalogue;
    }

}
