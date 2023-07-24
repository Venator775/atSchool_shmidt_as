package Shmidt.DEBT.lesson5_6_Exceptions.task2.fruitBase.customers;

import Shmidt.DEBT.lesson5_6_Exceptions.task2.fruitBase.Delivery;
import Shmidt.DEBT.lesson5_6_Exceptions.task2.fruitBase.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {

    protected String name;
    protected List<Fruit> purchases;

    public Customer(String name) {
        this.name = name;
        purchases = new ArrayList<>();
    }

    protected abstract List<Fruit> takeFruits(Delivery cargo);


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
