package Shmidt.lambdas.fruitBase.customers;

import Shmidt.lambdas.fruitBase.Delivery;
import Shmidt.lambdas.fruitBase.fruits.Fruit;

import java.util.List;

public class FreshCustomer extends Customer {
    public FreshCustomer(String name) {
        super(name);
    }


    public List<Fruit> takeFruits(Delivery cargo) {

        List<Fruit> freshfruits = cargo.getFruits();

        for (int i = 0; i < freshfruits.size(); i++) {
            Fruit fruit = freshfruits.get(i);
            if (fruit.isFresh()) {
                this.purchases.add(fruit);
                cargo.removeFruit(fruit);
                i--;
            }
        }

        /*
        freshfruits.stream().filter(Fruit::isFresh).forEach(fruit -> {
            this.purchases.add(fruit);
            cargo.removeFruit(fruit);//удаляется ссылка на объект в обоих массивах -> java.util.ConcurrentModificationException
        });
        */

        return this.purchases;
    }

}
