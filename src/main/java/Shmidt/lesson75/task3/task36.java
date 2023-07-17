package main.java.Shmidt.lesson75.task3;

import java.util.ArrayList;
import java.util.List;

import static main.java.Shmidt.tests.sideMethods.rnd;

/*
Далее установите n, l и m исходные значения, уберите добавленные на прошлом шаге строчки.
Далее запускайте программу, увеличивая l в 2 раза после каждого запуска, и отследите следующие значения какие в среднем получаются значения
 */
public class task36 {
    public static void main(String[] args) {


        int l = 13500, n = 10, m = 5;

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
