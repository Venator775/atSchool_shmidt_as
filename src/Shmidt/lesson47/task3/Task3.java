package Shmidt.lesson47.task3;

public class Task3 {
    public static void main(String[] args) {
        if(Integer.valueOf(args[0])>=1 && Integer.valueOf(args[1])>0)
        snakePrint(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
        else System.out.println("Ошибка, числа не удовлетворяют условиям");
    }

    public static void snakePrint(int n, int col) {
        System.out.println("Max число: " + n + "\n" + "Количество элементов в строке: " + col);
        int rowCount = n / col;
        if (n % col != 0)
            rowCount++;
        System.out.println("Количество строк: " + rowCount);
        int i = 1;
        boolean direction = true;
        for (int j = 0; j < rowCount; j++) {
            int endRowPosition = j * col + col - 1;

            if (j != rowCount - 1) {
                for (int k = 1; i <= endRowPosition + 1; i++) {
                    if (direction) {
                        System.out.print(i + "\t");
                    } else {
                        System.out.print(i + col - k + "\t");
                        k += 2;
                    }
                }
            } else {
                for (int k = 1; i <= endRowPosition+1; i++) {
                    if (direction) {
                        System.out.print(i + "\t");
                    } else {
                        int h = i + col - k;
                        if (h > n)
                            System.out.print("\t");
                        else
                            System.out.print(h + "\t");
                        k += 2;
                    }
                }
            }
            System.out.println();
            direction = !direction;
        }
    }
}
/*
Напишите метод snakePrint(int n, int col),
который выводит числа "змейкой" от 1 до n:
    1 2 3 4
    8 7 6 5
    9 10 11 12
    ... n
где:
n - максимальное число
col - количество цифр в одной строке
Выводимые числа разделены пробелами.



Используя реализованный метод, напишите программу, которая через
аргументы командной строки получает целочисленные значения n и col,
а затем печатает соответствующего размера змейку.


Проверку на наличие аргументов делать не надо.
Сделайте проверку, что n больше или равно 1, а m больше 0.
В противном случае выведите сообщение об ошибке
и завершите программу.
*/