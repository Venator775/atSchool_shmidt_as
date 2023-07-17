package main.java.Shmidt.lesson47.task1;

public class Task1 {
    public static void main(String[] args) {
        int x, m, n, k=0;

        if (Integer.parseInt(args[0]) < Integer.parseInt(args[1])) {
            m = Integer.parseInt(args[0]);
            n = Integer.parseInt(args[1]);
            x = m;
        } else {
            m = Integer.parseInt(args[1]);
            n = Integer.parseInt(args[0]);
            x = n;
        }

        System.out.println("m: " + m + "\tn: " + n);

        while (x <= n) {
            if (x % 3 == 0 && x % 5 != 0) {
                System.out.println("x" + k + "=" + x);
                k++;
            }
            x++;
        }
    }
}
/*
Напишите программу, которая получает два целых числа m и n
через аргументы командной строки и печатает целые числа x:
     m <= x <= n, которые делятся на 3, но не делятся на 5.
 */
