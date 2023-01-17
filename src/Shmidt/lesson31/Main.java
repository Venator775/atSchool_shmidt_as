package Shmidt.lesson31;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1(9, 1);
        task2(3, 7);
        task3();
        task4();
    }

    /**
     * Даны две целые переменные a, b. Напишите программу, после исполнения которой значения переменных поменялись бы местами (новое значение a равно старому значению b и наоборот).
     * Выведите исходные значения и результат.
     */
    public static void task1(int a, int b) {
        System.out.println("task1:");

        System.out.println("old a=" + a + "\n" +
                "old b=" + b);
        int c = a;
        a = b;
        b = c;

        System.out.println("new a=" + a + "\n" +
                "new b=" + b);
    }

    /**
     * Даны две целые переменные a, b. Напишите программу, после исполнения которой значения переменных поменялись бы местами (новое значение a равно старому значению b и наоборот), но без использования дополнительной переменной.
     * Выведите исходные значения и результат.
     */
    public static void task2(int a, int b) {
        System.out.println("task2:");

        System.out.println("old a=" + a + "\n" +
                "old b=" + b);
        a += b;//a=10
        b = a - b;//a=3
        a -= b;//a=7
        System.out.println("new a=" + a + "\n" +
                "new b=" + b);
    }

    /**
     * Напишите программу, которая получает два положительных числа через программные аргументы командной строки
     * и выводит true, если первое из чисел нацело делится на другое.
     * * Попробуйте решить задание без использования if.
     * * Проверку на кол-во введенных аргументов делать не надо.
     * Выведите исходные значения и результат.
     */
    public static void task3() {
        System.out.println("task3:");
        Scanner in = new Scanner(System.in);

        System.out.print("Input a number1: ");
        int num1 = in.nextInt();
        //System.out.printf("Your number1: %d \n", num1);

        System.out.print("Input a number2: ");
        int num2 = in.nextInt();
        //System.out.printf("Your number2: %d \n", num2);

        in.close();

        System.out.println(num1 % num2 == 0);
    }

    /**
     * Напишите программу, которая вычисляет и выводит сумму, которую вы получите через t лет
     * при размещении суммы P на счете под ежегодный процент r.
     * Это расчитывается по формуле: P*e^(r*t).
     * Для вычисления экспоненты воспользуйтесь функцией стандартной библиотеки Math.exp().
     * Значение суммы P, процент r и кол-во лет t необходимо получать через аргументы командной строки.
     * Проверку на кол-во введенных аргументов делать не надо.
     */
    public static void task4() {
        System.out.println("task4:");

        Scanner in = new Scanner(System.in);

        System.out.print("Input time t: ");
        int t = in.nextInt();

        System.out.print("Input your sum P: ");
        int P = in.nextInt();

        System.out.print("Input percent r: ");
        double r = in.nextDouble()/100;

        System.out.println("Amount: " + String.format("%.2f",P * Math.exp(r * t)));
    }
}
