package Shmidt.lesson75.fruitBase.customers;

import Shmidt.lesson75.fruitBase.Cargo;
import Shmidt.lesson75.fruitBase.fruits.Fruit;

import java.util.List;

public class FreshCustomer extends Customer {
    public FreshCustomer(String name) {
        super(name);
    }

    @Override
    protected void takeFruits(Cargo cargo) {//todo на всякий потом перепроверить на предмет нескольких одинаковых фруктов

        List<Fruit> freshfruits = cargo.getFruits();//fixme что эффективнее: создавать такой список фруктов и обращаться к его элементам или же напрямую всегда дёргать список фруктов в заказе и уже из него брать фрукты, как я сделал в UniqueCustomer?

        if (freshfruits != null)
            if (freshfruits.size() > 0) {
                int cntrFruits = freshfruits.size();
                while (cntrFruits>0){
                    cntrFruits--;
                    if(!freshfruits.get(cntrFruits).isFresh())
                        freshfruits.remove(cntrFruits);
                }
            }
        this.purchases=freshfruits;
    }
}
