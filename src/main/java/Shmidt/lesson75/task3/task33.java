package Shmidt.lesson75.task3;

import java.util.ArrayList;
import java.util.List;

import static Shmidt.tests.sideMethods.rnd;

/*
3) Верните n исходное значение и в конец тела метода main добавьте следующие строчки:
    System.gc();
    System.runFinalization();
 */
public class task33 {
    public static void main(String[] args) {


        int l = 1, n = 10, m = 5;

        for (int i = 0; i < l; i++) {

            System.out.println("Итерация: " + i);

            Element[] arr = new Element[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = new Element(j + l);
            }

            List<Integer> notNullElementPositions = getNotNullElementPositions(arr);
            while (notNullElementPositions.size() > m) {
                int delPosition = notNullElementPositions.get(rnd(0, notNullElementPositions.size() - 1));
                arr[delPosition] = null;

                notNullElementPositions = getNotNullElementPositions(arr);
            }
        }
        System.gc();//я так понял это ручной вызов сборщика мусора. если оставить одну эту строку, то будет вывод метода finalize
        System.runFinalization();//запускает методы финализации для объектов, ожидающих своей "уборки", но я так и не понял, почему нет вывода
    }

    static List<Integer> getNotNullElementPositions(Element[] arr) {
        List<Integer> notNullPositions = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                notNullPositions.add(i);
            }
        }

        return notNullPositions;
    }
}
