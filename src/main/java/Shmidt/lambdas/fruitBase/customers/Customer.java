package main.java.Shmidt.lambdas.fruitBase.customers;

import main.java.Shmidt.lambdas.fruitBase.Delivery;
import main.java.Shmidt.lambdas.fruitBase.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {

    protected String name;
    protected List<Fruit> purchases;

    public Customer(String name) {
        this.name = name;
        purchases = new ArrayList<>();
    }

    public abstract List<Fruit> takeFruits(Delivery cargo);//protected


    public void printPurchases() {
        System.out.println("\nСписок покупок " + getClass().getSimpleName() + " " + this.name + ":");
        purchases.forEach(purchase -> {
            System.out.println(purchase + ": " + purchase.getPrice() + "у.е." + " " + purchase.getFreshness());
        });
    }

    public String getName() {
        return name;
    }
}
