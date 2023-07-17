package main.java.Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase;

import main.java.Shmidt.abstractProgThroughInterfaces.lesson4.task2.fruitBase.fruits.Fruit;

import java.io.*;

public class FruitBase implements Serializable {
    private FruitCatalogue fruitCatalogue;
    final String path = "C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as/src/main.java.Shmidt/abstractProgThroughInterfaces/lesson4/task2/fruitBase/";
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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializeFileName_new))) {
            oos.writeObject(this.fruitCatalogue);
            System.out.println("Сериализация в файл " + serializeFileName_new + " успешна. Набор каталога:");

            StringBuilder catInfo = new StringBuilder();
            this.fruitCatalogue.getFruitCatalogue().forEach(f -> {
                catInfo.append(f.getName() + ":\t" + " [" + f.getPrice() + " у.е./" + f.getWeight() + "гр.]" + ";\n");
            });
            System.out.println(catInfo);
        } catch (Exception ex) {
            System.out.println("Ошибка сериализации:\n" + ex.getMessage() + "/n" + ex.getStackTrace());
        }
    }

    public void importCatalogue() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializeFileName))) {
            this.fruitCatalogue = (FruitCatalogue) ois.readObject();
            System.out.println("Десериализация из файла " + serializeFileName + " успешна. Набор каталога:");

            StringBuilder catInfo = new StringBuilder();
            this.fruitCatalogue.getFruitCatalogue().forEach(f -> {
                catInfo.append(f.getName() + ":\t" + " [" + f.getPrice() + " у.е./" + f.getWeight() + "гр.]" + ";\n");
            });

            System.out.println(catInfo);

        } catch (Exception ex) {
            System.out.println("Ошибка десериализации:\n" + ex.getMessage() + "/n" + ex.getStackTrace());
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