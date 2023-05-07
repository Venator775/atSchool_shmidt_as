package Shmidt.lambdas.fruitBase;

import Shmidt.lambdas.fruitBase.fruits.Fruit;

import java.io.*;

import static Shmidt.tests.ConsoleColors.GREEN;
import static Shmidt.tests.ConsoleColors.RESET;

public class FruitBase implements Serializable {
    private FruitCatalogue fruitCatalogue;
    private static String deserializeFileName;
    private static String serializeFileName;

    public FruitBase() {
        fruitCatalogue = new FruitCatalogue();
    }

    public FruitBase(boolean doImport) {
        if (doImport) {
            System.out.println("Загрузка каталога из файла");
            this.importCatalogue();
        } else {
            System.out.println("Загрузка каталога по умолчанию");
            fruitCatalogue = new FruitCatalogue();
        }
    }

    public Cargo takeOrder(String[] fruitsOrder) {
        Cargo cargo = new Cargo();
        for (String orderedFruit : fruitsOrder) {
            Fruit fruit = fruitCatalogue.getFruit(orderedFruit);//todo тут возвращается null на Kiwi и Mango, надо доработать их Clone
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
            System.out.println("\n" + GREEN + "Экспорт в файл " + serializeFileName + " успешен. Набор каталога:" + RESET);

            StringBuilder catInfo = new StringBuilder();
            this.fruitCatalogue.getFruitCatalogue().forEach(f -> {
                catInfo.append(f.getName() + ":\t" + " [" + f.getPrice() + " у.е./" + f.getWeight() + "гр.]" + ";\n");
            });
            System.out.println(catInfo);
        } catch (NullPointerException ex) {
            System.out.println("Ошибка экспорта: Передано null имя файла\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка экспорта: файл " + serializeFileName + " не найден\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        } catch (IOException ex) {
            System.out.println("Непредвиденная ошибка вывода: файл " + serializeFileName + "\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        } catch (Exception ex) {
            System.out.println("Непредведенная ошибка при экспорте каталога из файла " + serializeFileName + "\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        }
    }

    public void importCatalogue() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(deserializeFileName))) {
            this.fruitCatalogue = (FruitCatalogue) ois.readObject();
            System.out.println(GREEN + "Импорт из файла " + deserializeFileName + " успешен. Набор каталога:" + RESET);

            StringBuilder catInfo = new StringBuilder();
            this.fruitCatalogue.getFruitCatalogue().forEach(f -> {
                catInfo.append(f.getName() + ":\t" + " [" + f.getPrice() + " у.е./" + f.getWeight() + "гр.]" + ";\n");
            });

            System.out.println(catInfo);

        } catch (NullPointerException ex) {
            System.out.println("Ошибка импорта: Передано null имя файла\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка импорта: файл " + deserializeFileName + " не найден\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        } catch (InvalidClassException ex) {
            System.out.println("Невозможно импортировать каталог: неподдерживаемая версия файла " + deserializeFileName + "\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        } catch (IOException ex) {
            System.out.println("Непредвиденная ошибка ввода: файл " + deserializeFileName + "\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        } catch (Exception ex) {
            System.out.println("Непредведенная ошибка при импорте каталога из файла " + deserializeFileName + "\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        }

    }


    public static void setInputFileName(String FileName) {
        deserializeFileName = FileName;
    }

    public static void setOutputFileName(String FileName) {
        serializeFileName = FileName;
    }
}