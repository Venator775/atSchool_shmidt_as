package Shmidt.lesson75.fruitBase.customers;

import Shmidt.lesson75.fruitBase.Cargo;
import Shmidt.lesson75.fruitBase.fruits.Fruit;

public class UniqueCustomer extends Customer {
    public UniqueCustomer(String name) {
        super(name);
    }

    @Override
    protected void takeFruits(Cargo cargo) {
        if (cargo != null)
            if (cargo.getFruits().size() > 0)
                for (Fruit uniqFruit : cargo.getFruits())
                    if (!this.purchases.contains(uniqFruit))
                        this.purchases.add(uniqFruit);
    }
}
