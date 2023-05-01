package Shmidt.lessonExceptions.task2.fruitBase.customers;

import Shmidt.lessonExceptions.task2.fruitBase.Delivery;
import Shmidt.lessonExceptions.task2.fruitBase.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class UniqueCustomer extends Customer {
    public UniqueCustomer(String name) {
        super(name);
    }

    public List<Fruit> takeFruits(Delivery cargo) {

        for (int i = 0; i < cargo.getFruits().size(); i++) {
            Fruit cargoFruit = cargo.getFruits().get(i);

            boolean isFruitContained = this.purchases.stream().anyMatch(
                    purchaseFruit -> purchaseFruit.getName().equals(cargoFruit.getName())
            );

            if (!isFruitContained) {
                this.purchases.add(cargo.removeFruit(cargoFruit));
                i--;
            }
        }

        return this.purchases;

        /*
        List<Fruit> fruitList = cargo.getFruits();
        List<Fruit> resultList = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            if (resultList.stream().noneMatch(orderList -> (orderList.getName().equals(fruit.getName())))) {
                resultList.add(fruit);
            }
            cargo.removeFruit(fruit);//удаляется ссылка на объект в обоих массивах -> java.util.ConcurrentModificationException + ломается цикл перебора фруктов
        }
        return resultList;
        */
    }
}
