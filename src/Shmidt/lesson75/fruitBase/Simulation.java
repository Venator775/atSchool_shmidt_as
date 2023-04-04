package Shmidt.lesson75.fruitBase;


import Shmidt.lesson75.fruitBase.customers.Customer;
import Shmidt.lesson75.fruitBase.customers.FreshCustomer;
import Shmidt.lesson75.fruitBase.customers.UniqueCustomer;
import Shmidt.lesson75.fruitBase.fruits.Fruit;

import java.util.List;

public class Simulation {
    //Orange Blueberry Blueberry Pineapple Pineapple бульбазавр Orange Orange Orange Orange  Banana Apple Grape Pineapple Banana Apple Grape Banana Apple Grape Banana Apple Grape
    //Orange Banana Apple Grape Pineapple Banana Banana Apple Grape Banana Apple Grape Blueberry
    public static void main(String[] args) {
        FruitBase base = new FruitBase();


        List<Customer> customers = List.of(new FreshCustomer("Серёга"), new UniqueCustomer("Пашок"));
        if (args.length > 0) {
            Cargo cargoOrder = base.takeOrder(args);

            System.out.println("\nИмеющиеся фрукты:");
            for (Fruit c: cargoOrder.getFruits()){
                System.out.println(c + " " + c.getFreshness());
            }

            //todo доделать изъятие фруктов из груза
            System.out.println("\nДо заказа cargoOrder.size()=" + cargoOrder.getFruits().size());
            System.out.println(cargoOrder);
            System.out.println();
            ((FreshCustomer) customers.get(0)).takeFruits(cargoOrder);
            ((UniqueCustomer) customers.get(1)).takeFruits(cargoOrder);

            for (Customer c: customers)
                c.printPurchases();

            System.out.println("\nПосле заказа argoOrder.size()=" + cargoOrder.getFruits().size());
            System.out.println(cargoOrder);
        } else {
            System.out.println("Заказ пуст.");
        }
    }

}
