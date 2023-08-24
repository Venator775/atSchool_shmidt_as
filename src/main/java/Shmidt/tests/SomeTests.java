package Shmidt.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SomeTests {
    private static String deserializeFileName = "/src/Shmidt/lambdas/fruitBase/fruitCatalogue_IN.dat";

    public static void main(String[] args) {
        testsWithPaths();

    }

    public static void importCatalogue() {
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        String pf = path + deserializeFileName;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pf))) {
            System.out.println();
            System.out.println(pf);

        } catch (Exception ex) {
            System.out.println("Непредведенная ошибка при импорте каталога из файла " + deserializeFileName + "\n" + ex.getMessage() + "\n" + ex.getStackTrace());
        }

    }

    public static void testsWithDate() {
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

    public static void testsWithPaths() {
        Path testFilePath = Paths.get("C:\\Users\\Алексей\\IdeaProjects\\atSchool_shmidt_as\\marks.txt");
        System.out.println("Path testFilePath: " + testFilePath);

        Path fileName = testFilePath.getFileName();
        System.out.println("Path fileName: " + fileName);

        Path parent = testFilePath.getParent();
        System.out.println("Path parent: " + parent);

        Path root = testFilePath.getRoot();
        System.out.println("Path root: " + root);

        boolean endWithTxt = testFilePath.endsWith("atSchool_shmidt_as\\marks.txt");
        System.out.println("boolean endWithTxt: " + endWithTxt);

        boolean startsWithLalala = testFilePath.startsWith("C:\\Users");
        System.out.println("boolean startsWithLalala: " + startsWithLalala);
    }


    public static void fileCopy(){
        // копируем файл с помощью потоков
        long start = System.nanoTime();
        Path testFilePath = Paths.get("target/logs/logFile_API.log");
        File source = testFilePath.toFile();
        File dest = Paths.get("target/allure-results/" + testFilePath.getFileName()).toFile();
        start = System.nanoTime();
        copyFileUsingJava7Files(source, dest);
        System.out.println("Время копирования файла с помощью класса Files Java 7 = "+(System.nanoTime()-start));
    }
    // простой и удобный метод копирования файла в Java 7
    private static void copyFileUsingJava7Files(File source, File dest) {
        try {
            Files.copy(source.toPath(), dest.toPath());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
