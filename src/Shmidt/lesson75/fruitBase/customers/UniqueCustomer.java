package Shmidt.lesson75.fruitBase.customers;

import Shmidt.lesson75.fruitBase.Cargo;
import Shmidt.lesson75.fruitBase.fruits.Fruit;

import java.util.List;

public class UniqueCustomer extends Customer {
    public UniqueCustomer(String name) {
        super(name);
    }

    @Override
    public List<Fruit> takeFruits(Cargo cargo) {
        if (cargo != null)
            if (cargo.getFruits().size() > 0)
                for (int i = 0; i < cargo.getFruits().size(); i++) {
                    Fruit fruit = cargo.getFruits().get(i);
                    if (!this.purchases.contains(fruit)) {
                        this.purchases.add(fruit);
                        cargo.removeFruit(cargo.getFruits().get(i));
                    }
                }
        return cargo.getFruits();
    }
}
