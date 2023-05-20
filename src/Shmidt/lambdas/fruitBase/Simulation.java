package Shmidt.lambdas.fruitBase;


import Shmidt.lambdas.fruitBase.customers.Customer;
import Shmidt.lambdas.fruitBase.customers.FreshCustomer;
import Shmidt.lambdas.fruitBase.customers.UniqueCustomer;
import Shmidt.lambdas.fruitBase.fruits.Fruit;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simulation {
    //Orange Kiwi Blueberry Pineapple Pineapple бульбазавр Orange Mango Orange Orange  Banana Apple Grape Pineapple Banana Mango Kiwi Banana Kiwi Grape Mango Apple Grape
    //-e=/src/Shmidt/lambdas/fruitBase/fruitCatalogue_OUT.dat -i=/src/Shmidt/lambdas/fruitBase/fruitCatalogue_IN.dat Orange Kiwi Blueberry Pineapple Pineapple бульбазавр Orange Mango Orange Orange  Banana Apple Grape Pineapple Banana Mango Kiwi Banana Kiwi Grape Mango Apple Grape
    //-e=C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as/src/Shmidt/lambdas/fruitBase/fruitCatalogue_OUT.dat -i=C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as/src/Shmidt/lambdas/fruitBase/fruitCatalogue_IN.dat Orange Kiwi Blueberry Pineapple Pineapple бульбазавр Orange Mango Orange Orange  Banana Apple Grape Pineapple Banana Mango Kiwi Banana Kiwi Grape Mango Apple Grape
    private static String outputFilePath;
    private static String inputFilePath;

    public static void main(String[] args) {
        initFilePaths(args);

        FruitBase base = inputFilePath == null ? new FruitBase(false) : new FruitBase(true);//проверка, если путь ввода указан, то загружаем каталог из файла. Если не указан - берём по умолчанию

        List<Customer> customers = List.of(new FreshCustomer("Серёга"), new UniqueCustomer("Пашок"));


//        customers.add(new Customer("Семёныч") {//fixme сюда не добавляется
//            @Override
//            protected List<Fruit> takeFruits(Delivery cargo) {
//                List<Fruit> freshfruits = cargo.getFruits();
//
//                for (int i = 0; i < freshfruits.size(); i++) {
//                    Fruit fruit = freshfruits.get(i);
//                    if (fruit.getPrice().compareTo(BigDecimal.valueOf(40))>0) {
//                        this.purchases.add(fruit);
//                        cargo.removeFruit(fruit);
//                        i--;
//                    }
//                }
//                return this.purchases;
//            }
//        });

        if (args.length > 0) {
            for (Customer c : customers) {
                Delivery deliveryOrder = base.takeOrder(args);
                System.out.println("Заказ у " + c.getName() + ":");
                printAvailableFruits(deliveryOrder);
                String className = c.getClass().getSimpleName();

                switch (className) {//fixme вот тут не получится вывести "анонимного" заказчика. Он имеет класс в дебаггере Simulation. Если таких заказчиков будет несколько, то хз, как
                    case ("FreshCustomer"):
                        List<Fruit> zakaz1 = ((FreshCustomer) c).takeFruits(deliveryOrder);
                        if (zakaz1.size() > 0) {
                            System.out.println(c.getName() + " собрал заказ:");
                            for (Fruit f : zakaz1)
                                System.out.println(f);
                        } else System.out.println(c.getName() + " не собрал подходящих фруктов");
                        break;
                    case ("UniqueCustomer"):
                        List<Fruit> zakaz2 = ((UniqueCustomer) c).takeFruits(deliveryOrder);
                        System.out.println(c.getName() + " собрал заказ:");
                        if (zakaz2.size() > 0) {
                            for (Fruit f : zakaz2)
                                System.out.println(f);
                        } else System.out.println(c.getName() + " не собрал подходящих фруктов");
                        break;
                    default:
                        //List<Fruit> zakaz3 = c.takeFruits(deliveryOrder);
                }


                System.out.println("Список оставшихся фруктов в заказе у " + c.getName() + ":\n" + deliveryOrder.getFruits() + "\n");
            }

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
