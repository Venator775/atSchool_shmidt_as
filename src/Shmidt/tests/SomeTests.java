package Shmidt.tests;

import Shmidt.lambdas.fruitBase.FruitCatalogue;

import java.io.*;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import static Shmidt.tests.ConsoleColors.*;

public class SomeTests {
    private static String deserializeFileName = "/src/Shmidt/lambdas/fruitBase/fruitCatalogue_IN.dat";
    public static void main(String[] args) {

        importCatalogue();

    }

    public static void importCatalogue() {
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        String pf = path+deserializeFileName;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pf))) {
            System.out.println();
            System.out.println(pf);

        }
        catch (Exception ex) {
            System.out.println("Непредведенная ошибка при импорте каталога из файла " + deserializeFileName + "\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        }

    }
}
