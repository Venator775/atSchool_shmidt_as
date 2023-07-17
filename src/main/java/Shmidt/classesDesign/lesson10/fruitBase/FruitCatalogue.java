package Shmidt.classesDesign.lesson10.fruitBase;

import Shmidt.classesDesign.lesson10.fruitBase.fruits.*;


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
        fruitCatalogue.add(new Apple("Apple", BigDecimal.valueOf(11), 121));
        fruitCatalogue.add(new Orange("Orange", BigDecimal.valueOf(24), 111.5));
        fruitCatalogue.add(new Banana("Banana", BigDecimal.valueOf(45), 131.6));
        fruitCatalogue.add(new Pineapple("Pineapple", BigDecimal.valueOf(180), 300.1));
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
