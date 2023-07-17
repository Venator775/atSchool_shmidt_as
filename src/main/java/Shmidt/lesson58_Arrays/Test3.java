package main.java.Shmidt.lesson58_Arrays;

import static main.java.Shmidt.lesson58_Arrays.Test1.*;

public class Test3 {
    public static void main(String[] args) {

        int[] a = fillArray(20);
        System.out.print("Начальный массив:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        int[] b = bubbleSort(a);

        System.out.println("\nОтсортированный массив:");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }


    static int[] bubbleSort(int[] a) {
        int counter = 0;
        boolean sorted = false;
        while (!sorted) {
            counter++;
            //System.out.print("\nШаг " + counter + ": ");
            sorted = true;
            for (int i = 0; i < a.length; i++) {
                if ((i + 1) != a.length) {
                    if (a[i] > a[i + 1]) {
                        a[i] += a[i + 1];
                        a[i + 1] = a[i] - a[i + 1];
                        a[i] -= a[i + 1];
                        sorted = false;
                    }
                }
                //System.out.print(a[i] + " ");
            }

        }

        return a;
    }


}
/*
Реализуйте метод void bubbleSort(int[] a),
который сортирует целочисленные элементы в массиве a по возрастанию (первый элемент - минимальный) согласно алгоритму пузырьковой сортировки.
en.wikipedia.org/wiki/Bubble_sort

Используя метод fillArray из первого задания и метод bubbleSort, напишите программу, которая создает массив из 20 целочисленных элементов, выводит элементы в одну строку, разделив пробелами.
Затем, используя метод bubbleSort, сортирует созданный массив
и выводит элементы отсортированного массива в одну строку, разделив пробелами.
 */