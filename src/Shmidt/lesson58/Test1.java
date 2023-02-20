package Shmidt.lesson58;

public class Test1 {
    public static void main(String[] args) {
        int[] a;
        a = fillArray(20);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static public int[] fillArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd(-9, 9);
        }
        return a;
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
/*
Реализуйте метод void fillArray(int[] a),
который устанавливает элементам целочисленного массива а случайные целые числа -9 до 9.

Напишите программу, которая создает массив из 20 целочисленных элементов,
заполняет его случайными значениями, используя метод fillArray,
и печатает его элементы в одну строку, разделив пробелами.
 */