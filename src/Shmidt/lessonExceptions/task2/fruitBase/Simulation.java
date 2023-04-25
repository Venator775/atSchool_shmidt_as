package Shmidt.lessonExceptions.task2.fruitBase;


import Shmidt.lessonExceptions.task2.fruitBase.customers.Customer;
import Shmidt.lessonExceptions.task2.fruitBase.customers.FreshCustomer;
import Shmidt.lessonExceptions.task2.fruitBase.customers.UniqueCustomer;
import Shmidt.lessonExceptions.task2.fruitBase.fruits.Fruit;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simulation {
    //todo сделать поиск в аргументах тегов -i -e
    //Orange Blueberry Blueberry Pineapple Pineapple бульбазавр Orange Orange Orange Orange  Banana Apple Grape Pineapple Banana Apple Grape Banana Apple Grape Banana Apple Grape
    //-e=C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as/src/Shmidt/lessonExceptions/task2/fruitBase/fruitCatalogue_OUT.dat -i=C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as/src/Shmidt/lessonExceptions/task2/fruitBase/fruitCatalogue_IN.dat Orange Banana Apple Grape Pineapple Banana Banana Apple Grape Banana Apple Grape Blueberry
    //-i=C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as/src/Shmidt/lessonExceptions/task2/fruitBase/fruitCatalogue_IN.dat Orange Banana Apple Grape Pineapple Banana Banana Apple Grape Banana Apple Grape Blueberry
    //-e=C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as/src/Shmidt/lessonExceptions/task2/fruitBase/fruitCatalogue_OUT.dat Orange Banana Apple Grape Pineapple Banana Banana Apple Grape Banana Apple Grape Blueberry
    private static String outputFilePath = null;
    private static String inputFilePath = null;

    public static void main(String[] args) {
//        String outputFilePath = initFilePathExport(args[0]);
//        String inputFilePath = initFilePathImport(args[1]);
        initFilePaths(args);

        FruitBase.setSerializeFileName(outputFilePath);
        FruitBase.setDeserializeFileName(inputFilePath);

        FruitBase base = inputFilePath == null ? new FruitBase(false) : new FruitBase(true);

        List<Customer> customers = List.of(new FreshCustomer("Серёга"), new UniqueCustomer("Пашок"));

        if (args.length > 0) {
            Delivery deliveryOrder = base.takeOrder(args);
            printFruitsListByFreshness(deliveryOrder);
            printAvailableFruits(deliveryOrder);

            for (Customer c : customers) {
                String className = c.getClass().getSimpleName();
                switch (className) {
                    case ("FreshCustomer"):
                        List<Fruit> zakaz1 = ((FreshCustomer) c).takeFruits(deliveryOrder);
                        System.out.println("FreshCustomer собрал заказ:");
                        for (Fruit f : zakaz1)
                            System.out.println(f);
                        break;
                    case ("UniqueCustomer"):
                        List<Fruit> zakaz2 = ((UniqueCustomer) c).takeFruits(deliveryOrder);
                        System.out.println("UniqueCustomer собрал заказ:");
                        for (Fruit f : zakaz2)
                            System.out.println(f);
                        break;
                }
                System.out.println("Список оставшихся фруктов:");
                System.out.println(deliveryOrder.getFruits() + "\n");
            }

            System.out.println("Вывод покупок заказчиков=====================================================================================");
            for (Customer c : customers)
                c.printPurchases();

            printAvailableFruits(deliveryOrder);
        } else {
            System.out.println("Заказ пуст.");
        }


        if (outputFilePath != null)
            base.exportCatalogue();
        else
            System.out.println("Файл для экспорта не указан");
    }

    /**
     * Краткий список фруктов в заказе с указанием свежести
     *
     * @param deliveryOrder
     */
    private static void printFruitsListByFreshness(Delivery deliveryOrder) {
        System.out.println("\nИмеющиеся фрукты:");
        int n = 0;
        for (Fruit c : deliveryOrder.getFruits()) {
            System.out.println(++n + ") " + c + " " + c.getFreshness());
        }
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
    }
}
