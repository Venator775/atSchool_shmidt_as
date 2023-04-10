package Shmidt.abstractAndInterfaces.lesson10.fruitBase.customers;

import Shmidt.abstractAndInterfaces.lesson10.fruitBase.Cargo;
import Shmidt.abstractAndInterfaces.lesson10.fruitBase.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {

    protected String name;
    protected List<Fruit> purchases;

    public Customer(String name) {
        this.name = name;
        purchases = new ArrayList<>();
    }

    protected abstract List<Fruit> takeFruits(Cargo cargo);


    public void printPurchases() {
        System.out.println("\nСписок покупок " + getClass().getSimpleName() + ":");
        purchases.forEach(purchase -> {
            System.out.println(purchase + ": " + purchase.getPrice() + "у.е." + " " + purchase.getFreshness());
        });
    }

    public String getName() {
        return name;
    }
}
