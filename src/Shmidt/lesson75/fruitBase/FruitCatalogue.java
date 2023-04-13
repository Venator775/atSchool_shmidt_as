package Shmidt.lesson75.fruitBase;

import Shmidt.lesson75.fruitBase.fruits.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FruitCatalogue implements Serializable {
    private List<Fruit> fruitCatalogue;


    /**
     * Инициализируется список фруктов, имеющихся в продаже
     */
    public FruitCatalogue() {
        fruitCatalogue = new ArrayList<>();
        fruitCatalogue.add(new Apple("Apple", BigDecimal.valueOf(10), 15));
        fruitCatalogue.add(new Orange("Orange", BigDecimal.valueOf(20), 17.5));
        fruitCatalogue.add(new Banana("Banana", BigDecimal.valueOf(30), 13.3));
        fruitCatalogue.add(new Pineapple("Pineapple", BigDecimal.valueOf(151), 26.4));
    }

    public Fruit getFruit(int n) {
        return fruitCatalogue.size() >= n ? fruitCatalogue.get(n) : null;
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

    public void setFruitCatalogue(List<Fruit> fruitCatalogue) {
        this.fruitCatalogue = fruitCatalogue;
    }
}
