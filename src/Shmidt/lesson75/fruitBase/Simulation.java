package Shmidt.lesson75.fruitBase;


import Shmidt.lesson75.fruitBase.customers.Customer;
import Shmidt.lesson75.fruitBase.customers.FreshCustomer;
import Shmidt.lesson75.fruitBase.customers.UniqueCustomer;
import Shmidt.lesson75.fruitBase.fruits.Fruit;

import java.util.List;

public class Simulation {
    //Orange Blueberry Blueberry Pineapple Pineapple бульбазавр Orange Orange Orange Orange  Banana Apple Grape Pineapple Banana Apple Grape Banana Apple Grape Banana Apple Grape
    //Pineapple Pineapple Pineapple Pineapple Pineapple Pineapple Pineapple Pineapple Pineapple Pineapple Pineapple Pineapple
    public static void main(String[] args) {
        FruitBase base = new FruitBase();


        List<Customer> customers = List.of(new FreshCustomer("Серёга"), new UniqueCustomer("Пашок"));
        if (args.length > 0) {
            Cargo cargoOrder = base.takeOrder(args);

            for (Fruit c: cargoOrder.getFruits()){
                System.out.println(c + " " + c.getFreshness());
            }

            //todo доделать изъятие фруктов из груза

            ((UniqueCustomer) customers.get(1)).takeFruits(cargoOrder);
            ((FreshCustomer) customers.get(0)).takeFruits(cargoOrder);


            for (Customer c: customers)
                c.printPurchases();

            System.out.println(cargoOrder);
        } else {
            System.out.println("Заказ пуст.");
        }
    }

}
