package Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.customers;

import Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.Cargo;
import Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.fruits.Fruit;

import java.util.List;

public class FreshCustomer extends Customer {
    public FreshCustomer(String name) {
        super(name);
    }

    public List<Fruit> takeFruits(Cargo cargo) {

        List<Fruit> freshfruits = cargo.getFruits();//fixme что эффективнее: создавать такой список фруктов freshfruits и обращаться к его элементам или же напрямую всегда дёргать список фруктов в заказе и уже из него брать фрукты, как я сделал в UniqueCustomer?

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
