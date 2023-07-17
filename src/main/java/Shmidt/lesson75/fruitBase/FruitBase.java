package main.java.Shmidt.lesson75.fruitBase;

import main.java.Shmidt.lesson75.fruitBase.fruits.Fruit;

import java.io.*;

public class FruitBase implements Serializable {
    private FruitCatalogue fruitCatalogue;
    final private String serializeFileName = "fruitCatalogue.dat";
    final private String serializeFileName_new = "fruitCatalogue_new.dat";

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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializeFileName_new))) {
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
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializeFileName))) {
            FruitCatalogue fc = (FruitCatalogue) ois.readObject();
            System.out.println("Десериализация из файла " + serializeFileName + " успешна. Набор каталога:");
//            fc.getFruitCatalogue().forEach(fruit -> {
//                System.out.println(fruit.getName() + " " + fruit.getWeight() + " " + fruit.getPrice());
//            });
//            this.fruitCatalogue = fc;

            StringBuilder catInfo = new StringBuilder();
            fc.getFruitCatalogue().forEach(f -> {
                catInfo.append(f.getName() + ":\t" + " [" + f.getPrice() + " у.е./" + f.getWeight() + "гр.]" + ";\n");
            });
            System.out.println(catInfo);
            this.fruitCatalogue = fc;
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