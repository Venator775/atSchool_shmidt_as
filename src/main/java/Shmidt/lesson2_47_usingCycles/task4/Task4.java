package Shmidt.lesson2_47_usingCycles.task4;

import java.math.BigInteger;

public class Task4 {
    static int n = 200;

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            int s = nextInt(n);
            if(isPrime(s)){
                System.out.println("Сгенерили простое число: " + s);
                break;
            }
            System.out.println("Сгенерили число: " + s);
        }
    }

    private static boolean isPrime(int x) {
        return BigInteger.valueOf(x).isProbablePrime((int) Math.log(x));
    }

    private static int nextInt(int x) {
        return (int) (Math.random() * (++x - 1));
    }

}
/*
В основном классе программы объявлена и инициализиована целочисленная переменная n.
Реализуйте метод boolean isPrime(int x),
который возвращает true, если x - простое число.
Реализуйте метод int nextInt(int x),
который возвращает случайно сгенерированное целое число от 0 до x, x не включая.

Используя эти методы, напишите программу, которая генерит целые
числа в диапазоне от 1 до n (не включая n) до тех пор, пока не сгенерит простое число.
Для генерации простых чисел можно пользоваться классом
java.lang.Math или java.util.Random.
*/