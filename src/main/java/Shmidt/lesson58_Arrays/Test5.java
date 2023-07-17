package main.java.Shmidt.lesson58_Arrays;

import static main.java.Shmidt.lesson58_Arrays.Test1.fillArray;
import static main.java.Shmidt.lesson58_Arrays.Test1.rnd;

public class Test5 {
    public static void main(String[] args) {

        int rows = rnd(1, 5);
        int cols = rnd(1, 7);

        int[][] h = new int[rows][cols];
        int maxLength = 0;

        //заполнение массива
        for (int i = 0; i < h.length; i++) {
            int[] a = fillArray(rnd(1, cols));
            h[i] = a;
            for (int j = 0; j < h.length; j++) {
                int tempMax = maxLength;
                maxLength = h[i].length;
                if (tempMax > maxLength)//вычисляем максимальную длину массивов
                    maxLength = tempMax;
            }
        }

        //вывод массива
        System.out.println("Вывод массива:");
        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < h[i].length; j++) {
                System.out.print(h[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Лесенка:");
        while (maxLength > 0) {
            for (int[] row : h) {
                if (row.length == maxLength) {
                    for (int col : row) {
                        System.out.print(col + " ");
                    }
                    System.out.println();
                }
            }
            maxLength--;
        }

    }

    public static int getMax(int[] ar) {
        int max = 0;
        for (int i = 0; i < ar.length; i++) {
            int tempMax = max;
            max = ar[i];
            if (tempMax > max)//вычисляем максимальную длину
                max = tempMax;
        }
        return max;
    }
}


/*
Напишите программу, которая создает зубчатый массив целочисленных элементов, сгенеренных случайным образов в диапазоне -9 до 9.
Массив должен содержать не более 5 строк и каждая строка иметь не более 7 столбцов.
Выведите массив на экран в порядке убывания сумм элементов строк.
 */