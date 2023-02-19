package Shmidt.lesson54;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("Строка: " + args[0]);

        if (isInteger(args[0]))
            System.out.println("Строка является целым числом");
        else
            System.out.println("Строка не является целым числом");
    }

    static boolean isInteger(String str) {
        int i = 0;
        if (str.charAt(i) == '-')
            i = 1;
        for (; i < str.length(); i++)
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        return true;
    }
}
/*
Напишите метод "static boolean isInteger(String str)", который получает на вход строку и возвращает true, если строка str состоит только из цифр.

С использованием этого метода напишите программу,
которая проверяет является ли строка, переданная через аргументы командной строки, целым числом, и выводит результат проверки.

Проверку на наличие аргументов делать не надо.
Например:
1)
Входная строка: "1234567890"
Вывод: Строка является целым числом

2)
Входная строка: "1,234E567890"
Вывод: Строка не является целым числом
 */