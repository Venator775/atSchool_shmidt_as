package Shmidt.lessonExceptions.task2.fruitBase;


import Shmidt.lessonExceptions.task2.fruitBase.customers.Customer;
import Shmidt.lessonExceptions.task2.fruitBase.customers.FreshCustomer;
import Shmidt.lessonExceptions.task2.fruitBase.customers.UniqueCustomer;
import Shmidt.lessonExceptions.task2.fruitBase.fruits.Fruit;

import java.util.List;

public class Simulation {
    //Orange Blueberry Blueberry Pineapple Pineapple бульбазавр Orange Orange Orange Orange  Banana Apple Grape Pineapple Banana Apple Grape Banana Apple Grape Banana Apple Grape
    //Orange Banana Apple Grape Pineapple Banana Banana Apple Grape Banana Apple Grape Blueberry
    public static void main(String[] args) {
        FruitBase base = new FruitBase();


        List<Customer> customers = List.of(new FreshCustomer("Серёга"), new UniqueCustomer("Пашок"));
        if (args.length > 0) {
            Cargo cargoOrder = base.takeOrder(args);
            Delivery deliveryOrder = base.takeOrder(args);

            System.out.println("\nИмеющиеся фрукты:");
            int n=0;
//            for (Fruit c: cargoOrder.getFruits()){
            for (Fruit c: deliveryOrder.getFruits()){
                System.out.println(++n + ") " + c + " " + c.getFreshness());
            }


//            System.out.println("\nДо заказа cargoOrder.size()=" + cargoOrder.getFruits().size());
//            System.out.println(cargoOrder);
            System.out.println("\nДо заказа deliveryOrder.size()=" + deliveryOrder.getFruits().size());
            System.out.println(deliveryOrder);
            System.out.println();


            for(Customer c :customers){
                String className = c.getClass().getSimpleName();
                switch (className){
                    case ("FreshCustomer"):
//                        List<Fruit> zakaz1 = ((FreshCustomer) c).takeFruits(cargoOrder);
                        List<Fruit> zakaz1 = ((FreshCustomer) c).takeFruits(deliveryOrder);
                        System.out.println("FreshCustomer собрал заказ:");
                        for(Fruit f: zakaz1)
                            System.out.println(f);
                        break;
                    case ("UniqueCustomer"):
//                        List<Fruit> zakaz2 = ((UniqueCustomer) c).takeFruits(cargoOrder);
                        List<Fruit> zakaz2 = ((UniqueCustomer) c).takeFruits(deliveryOrder);
                        System.out.println("UniqueCustomer собрал заказ:");
                        for(Fruit f: zakaz2)
                            System.out.println(f);
                        break;
                }
                System.out.println("Список оставшихся фруктов:");
//                System.out.println(cargoOrder.getFruits() + "\n");
                System.out.println(deliveryOrder.getFruits() + "\n");
            }

            System.out.println("=====================================================================================");
            //Вывод покупок заказчиков
            for (Customer c: customers)
                c.printPurchases();

//            System.out.println("\nПосле заказа cargoOrder.size()=" + cargoOrder.getFruits().size());
            System.out.println("\nПосле заказа deliveryOrder.size()=" + deliveryOrder.getFruits().size());
            System.out.println(deliveryOrder);
        } else {
            System.out.println("Заказ пуст.");
        }


        base.importCatalogue();
        base.exportCatalogue();

    }
}
