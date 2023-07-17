package main.java.Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.customers;

import main.java.Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.Delivery;
import main.java.Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.fruits.Fruit;

import java.util.List;

public class FreshCustomer extends Customer {
    public FreshCustomer(String name) {
        super(name);
    }

//    public List<Fruit> takeFruits(Cargo cargo) {
    public List<Fruit> takeFruits(Delivery cargo) {

        List<Fruit> freshfruits = cargo.getFruits();

        if (freshfruits != null) {
            if (freshfruits.size() > 0) {
                int cntr = 0;
                while (cntr < freshfruits.size()) {
                    if (freshfruits.get(cntr).isFresh()){
                        this.purchases.add(cargo.withdrawFruit(freshfruits.get(cntr)));
                        cntr--;
                    }
                    cntr++;
                }
            } else return null;
        } else return null;

        return this.purchases;
    }

}
