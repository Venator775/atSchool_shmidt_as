package Shmidt.lambdas.fruitBase;

import Shmidt.lambdas.fruitBase.fruits.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static Shmidt.lambdas.fruitBase.fruits.Freshness.FRESH;
import static Shmidt.tests.sideMethods.rnd;

public class FruitCatalogue implements Serializable {
    private List<Fruit> fruitCatalogue;

    /**
     * Инициализируется список фруктов, имеющихся в продаже
     */
    public FruitCatalogue() {
        fruitCatalogue = new ArrayList<>();
        fruitCatalogue.add(new Apple(BigDecimal.valueOf(rnd(10, 20)), rnd(110, 130)));
        fruitCatalogue.add(new Orange(BigDecimal.valueOf(rnd(10, 20)), rnd(90, 105)));
        fruitCatalogue.add(new Banana(BigDecimal.valueOf(rnd(25, 35)), rnd(95, 110)));
        fruitCatalogue.add(new Pineapple(BigDecimal.valueOf(rnd(120, 150)), rnd(210, 250)));
        fruitCatalogue.add(new Fruit("Mango", BigDecimal.valueOf(rnd(120, 150)), rnd(210, 250), FRESH) {
            @Override
            public Fruit clone() {
                return new Fruit(this.name, this.price, this.weight, this.freshness) {
                    @Override
                    public Fruit clone() {//fixme какая-то хрень
                        return this;
                    }
                };
            }
        });
        fruitCatalogue.add(new Fruit("Kiwi", BigDecimal.valueOf(rnd(120, 150)), rnd(210, 250), FRESH) {
            @Override
            public Fruit clone() {
                return new Fruit(this.name, this.price, this.weight, this.freshness) {
                    @Override
                    public Fruit clone() {//fixme какая-то хрень
                        return this;
                    }
                };
            }
        });
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
