package main.java.Shmidt.lambdas.fruitBase;


import main.java.Shmidt.lambdas.fruitBase.customers.Customer;
import main.java.Shmidt.lambdas.fruitBase.customers.FreshCustomer;
import main.java.Shmidt.lambdas.fruitBase.customers.UniqueCustomer;
import main.java.Shmidt.lambdas.fruitBase.fruits.Fruit;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Набор фруктов для запуска по умолчанию, без импорта/экспорта
//Orange Kiwi Blueberry Pineapple Pineapple бульбазавр Orange Mango Orange Orange  Banana Apple Grape Pineapple Banana Mango Kiwi Banana Kiwi Grape Mango Apple Grape

//Набор фруктов с указанием путей для файлов
//-e=/src/main.java.Shmidt/lambdas/fruitBase/fruitCatalogue_OUT.dat -i=/src/main.java.Shmidt/lambdas/fruitBase/fruitCatalogue_IN.dat Orange Kiwi Blueberry Pineapple Pineapple бульбазавр Orange Mango Orange Orange  Banana Apple Grape Pineapple Banana Mango Kiwi Banana Kiwi Grape Mango Apple Grape

public class Simulation {

    private static String outputFilePath;
    private static String inputFilePath;

    public static void main(String[] args) {
        initFilePaths(args);

        FruitBase base = inputFilePath == null ? new FruitBase(false) : new FruitBase(true);//проверка, если путь ввода указан, то загружаем каталог из файла. Если не указан - берём по умолчанию

        List<Customer> customers = List.of(
                new FreshCustomer("Серёга"),
                new UniqueCustomer("Пашок"),
                new Customer("Семёныч") {
            /*
            - в классе Simulation, используя анонимный класс, добавьте покупателя, который выбирает дорогие фрукты.
    Дорогими считаются, те, чья стоимость больше или равна 75% от максимальной.
             */
                    public List<Fruit> takeFruits(Delivery cargo) {
                        List<Fruit> fruits = cargo.getFruits();
                        BigDecimal expensivePrice = getMaxPrice(fruits).multiply(BigDecimal.valueOf(0.75));
                        for (int i = 0; i < fruits.size(); i++) {
                            Fruit fruit = fruits.get(i);
                            if (fruit.getPrice().compareTo(expensivePrice) > 0) {
                                this.purchases.add(cargo.removeFruit(fruit));
                                i--;
                            }
                        }
                        return this.purchases;
                    }

                    private BigDecimal getMaxPrice(List<Fruit> fruits) {
                        BigDecimal maxPrice = BigDecimal.ZERO;
                        for (Fruit fruit : fruits) {
                            if (maxPrice.compareTo(fruit.getPrice()) == -1)
                                maxPrice = fruit.getPrice();
                        }
                        return maxPrice;
                    }
                });//создаём список заказчиков


        /*
        Следующей строкой вылетает исключение:
        Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:71)
	at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:75)
	at main.java.Shmidt.lambdas.fruitBase.Simulation.main(Simulation.java:36)
         */
/*        customers.add(new Customer("Семёныч") {//fixme сюда не добавляется
            public List<Fruit> takeFruits(Delivery cargo) {
                List<Fruit> freshfruits = cargo.getFruits();

                for (int i = 0; i < freshfruits.size(); i++) {
                    Fruit fruit = freshfruits.get(i);
                    if (fruit.getPrice().compareTo(BigDecimal.valueOf(40))>0) {
                        this.purchases.add(fruit);
                        cargo.removeFruit(fruit);
                        i--;
                    }
                }
                return this.purchases;
            }
        });*/

        if (args.length > 0) {
            customers.forEach(customer -> {//для каждого заказчика делаем заказ
                Delivery deliveryOrder = base.takeOrder(args);
                System.out.println("Заказ у " + customer.getName() + ":");
                printAvailableFruits(deliveryOrder);

                List<Fruit> recievedOrder = customer.takeFruits(deliveryOrder);
                if (recievedOrder.size() > 0) {
                    System.out.println(customer.getName() + " собрал заказ:");
                    recievedOrder.forEach(System.out::println);
                } else System.out.println(customer.getName() + " не собрал подходящих фруктов");

                System.out.println("Список не взятых фруктов в заказе у " + customer.getName() + ":\n" + deliveryOrder.getFruits() + "\n");
            });

            System.out.println("Вывод покупок заказчиков=====================================================================================");
            for (Customer c : customers)
                c.printPurchases();
        } else {
            System.out.println("Заказ пуст.");
        }


        if (outputFilePath != null)
            base.exportCatalogue();
        else
            System.out.println("Файл для экспорта не указан");
    }

    /**
     * Вывод в консоль списка доступных продуктов
     *
     * @param deliveryOrder заказ с продуктами
     */
    private static void printAvailableFruits(Delivery deliveryOrder) {
        System.out.println("\nДоступных фруктов для заказа: " + deliveryOrder.getFruits().size());
        System.out.println(deliveryOrder);
        System.out.println();
    }

    /**
     * Получение пути к файлу на экспорт
     *
     * @param arg аргумент -e=path
     * @return путь path в аргументе -e
     */
    private static String initFilePathExport(String arg) {
        String regex = "-e=(.+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(arg);

        if (matcher.find())
            return matcher.group(1);
        else
            return null;
    }

    /**
     * Получение пути к файлу на импорт
     *
     * @param arg аргумент -i=path
     * @return путь path в аргументе -i
     */
    private static String initFilePathImport(String arg) {
        String regex = "-i=(.+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(arg);

        if (matcher.find())
            return matcher.group(1);
        else
            return null;
    }

    private static void initFilePaths(String[] args) {
        for (String arg : args) {
            if (arg.contains("-e="))
                outputFilePath = initFilePathExport(arg);

            if (arg.contains("-i="))
                inputFilePath = initFilePathImport(arg);
        }
        FruitBase.setOutputFileName(outputFilePath);
        FruitBase.setInputFileName(inputFilePath);
    }
}
