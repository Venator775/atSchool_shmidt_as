package Shmidt.classesDesign.lesson10.fruitBase;

import Shmidt.classesDesign.lesson10.fruitBase.fruits.Fruit;

import java.io.*;

public class FruitBase implements Serializable {
    private FruitCatalogue fruitCatalogue;
    final String path = "C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as/src/Shmidt/abstractAndInterfaces/lesson10/fruitBase/";
    final private String serializeFileName = path + "fruitCatalogue.dat";
    final private String serializeFileName_new = path + "fruitCatalogue_new.dat";

    public FruitBase() {
        fruitCatalogue = new FruitCatalogue();
    }

    public Cargo takeOrder(String[] fruitsOrder) {
        Cargo cargo = new Cargo();
        for (String orderedFruit : fruitsOrder) {
            Fruit fruit = fruitCatalogue.getFruit(orderedFruit);
            if (fruit != null) {
                fruit.setRandFresh();//устанавливаем рандомную свежесть
                cargo.addFruit(fruit);
            }
        }
        return cargo;
    }

    public void exportCatalogue() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializeFileName))) {
            oos.writeObject(this.fruitCatalogue);
            System.out.println("Сериализация в файл " + serializeFileName_new + " успешна. Набор каталога:");

            StringBuilder catInfo = new StringBuilder();
            this.fruitCatalogue.getFruitCatalogue().forEach(f -> {
                catInfo.append(f.getName() + ":\t" + " [" + f.getPrice() + " у.е./" + f.getWeight() + "гр.]" + ";\n");
            });
            System.out.println(catInfo);
        } catch (Exception ex) {
            System.out.println("Ошибка сериализации:\n" + ex.getMessage());
        }
    }

    public void importCatalogue() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializeFileName_new))) {
            this.fruitCatalogue = (FruitCatalogue) ois.readObject();
            System.out.println("Десериализация из файла " + serializeFileName + " успешна. Набор каталога:");

            StringBuilder catInfo = new StringBuilder();
            this.fruitCatalogue.getFruitCatalogue().forEach(f -> {
                catInfo.append(f.getName() + ":\t" + " [" + f.getPrice() + " у.е./" + f.getWeight() + "гр.]" + ";\n");
            });

            System.out.println(catInfo);

        } catch (Exception ex) {
            System.out.println("Ошибка десериализации:\n" + ex.getMessage());
        }
    }


    //Orange Blueberry Blueberry Pineapple Pineapple бульбазавр Orange Banana Apple Grape Pineapple
    public static void main(String[] args) {
        FruitBase base = new FruitBase();

        if (args.length > 0) {
            Cargo cargoOrder = base.takeOrder(args);
            System.out.println("Груз заказа заполнен:");
            System.out.println(cargoOrder);

            cargoOrder.removeFruit(4);
            System.out.println("Убрали фрукт с 4 позиции");
            System.out.println(cargoOrder);

            cargoOrder.addFruit(base.fruitCatalogue.getFruit(2));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit(2));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit("Banana"));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit("Banana"));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit("Banana"));
            System.out.println("Добавили бананов");
            System.out.println(cargoOrder);

            System.out.println("Убрали " + cargoOrder.removeFruit(base.fruitCatalogue.getFruitCatalogue().get(0)));
            System.out.println(cargoOrder);

            cargoOrder.removeFruit(base.fruitCatalogue.getFruitCatalogue().get(0));
            System.out.println("Попытались ещё убрать яблоко");
            System.out.println(cargoOrder);
        } else {
            System.out.println("Заказ пуст.");
            System.exit(0);
        }
    }
}
/*
   Добавьте в класс FruitBase следующие методы:
   - общедоступный метод exportCatalogue
     Сериализует внутренний объект FruitCatalogue в проект.
     Выводится сообщение "каталог экспортирован"

   - общедоступный метод importCatalogue
     Десериализует из проекта объект FruitCatalogue и результатом заменяет текущий
 */