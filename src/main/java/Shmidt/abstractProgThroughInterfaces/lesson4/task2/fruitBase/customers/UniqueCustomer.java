package Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.customers;

import Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.Delivery;
import Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.fruits.Fruit;

import java.util.List;

public class UniqueCustomer extends Customer {
    public UniqueCustomer(String name) {
        super(name);
    }

//    public List<Fruit> takeFruits(Cargo cargo) {
    public List<Fruit> takeFruits(Delivery cargo) {
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
