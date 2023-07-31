package Shmidt.tests;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;

import static Shmidt.tests.sideMethods.parseDate;

public class SomeTests {
    private static String deserializeFileName = "/src/Shmidt/lambdas/fruitBase/fruitCatalogue_IN.dat";
    public static void main(String[] args) {

        //importCatalogue();
        /*
        var g = parseDate("2023-07-25");
        System.out.println(g);
        System.out.println(g.getYear());
        System.out.println(g.getMonthValue());
        System.out.println(g.getDayOfMonth());*/

        // create an LocalDate object
        LocalDate lt = LocalDate.parse("2018-12-27");
        // print result
        System.out.println("LocalDate : " + lt);
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
