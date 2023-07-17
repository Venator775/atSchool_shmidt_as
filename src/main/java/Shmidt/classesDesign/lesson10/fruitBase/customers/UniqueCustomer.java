package Shmidt.classesDesign.lesson10.fruitBase.customers;

import Shmidt.classesDesign.lesson10.fruitBase.fruits.Fruit;
import Shmidt.classesDesign.lesson10.fruitBase.Cargo;

import java.util.List;

public class UniqueCustomer extends Customer {
    public UniqueCustomer(String name) {
        super(name);
    }

    public List<Fruit> takeFruits(Cargo cargo) {
        if (cargo != null) {
            if (cargo.getFruits().size() > 0) {
                for (int i = 0; i < cargo.getFruits().size(); i++) {
                    Fruit cargoFruit = cargo.getFruits().get(i);
                    boolean isFruitContained = false;
                    for (Fruit purchaseFruit : this.purchases) {
                        if (purchaseFruit.getName().equals(cargoFruit.getName())) {
                            isFruitContained = true;
                            break;
                        }
                    }

                    if (!isFruitContained) {
                        this.purchases.add(cargo.withdrawFruit(cargoFruit));
                    }
                }
            } else return null;
        } else return null;

        return this.purchases;
    }
}
