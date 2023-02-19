package Shmidt.lesson47.task5;


import static Shmidt.lesson47.task5.Calculator.*;

public class Task5 {
    public static void main(String[] args) {
        switch (args[1]) {
            case ("+"):
                System.out.println(args[0] + "+" + args[2] + "=" + add(Integer.parseInt(args[0]), Integer.parseInt(args[2])));
                break;
            case ("-"):
                System.out.println(args[0] + "-" + args[2] + "=" + sub(Integer.parseInt(args[0]), Integer.parseInt(args[2])));
                break;
            case ("*"):
                System.out.println(args[0] + "*" + args[2] + "=" + mult(Integer.parseInt(args[0]), Integer.parseInt(args[2])));
                break;
            case ("/"):
                System.out.println(args[0] + "/" + args[2] + "=" + divide(Integer.parseInt(args[0]), Integer.parseInt(args[2])));
                break;
            default:
                System.out.println("Не верная операция. Список поддерживаемых операций: +, -, *, /");
        }
    }
}
/*
Используя класс Calculator, напишите программу, которая будет
получать через аргументы командной строки два целых числа,
знак операции и после этого выводить результат операции.
через аргументы командной строки.

Пример ввода аргументов:
 10 + 12
 10 - 12
 10 * 12
 10 / 0


Проверку на наличие аргументов делать не надо.
Для проверки знака операции используйте оператор switch.
Если введена неподдерживаемая операция,
то выводить список поддерживаемых операций и завершать программу.
 */