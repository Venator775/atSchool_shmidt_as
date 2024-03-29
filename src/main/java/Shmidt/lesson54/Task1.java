package Shmidt.lesson54;

public class Task1 {
    static String s = "Циклом называется многократное выполнение одних и тех же действий.";

    public static void main(String[] args) {
        String arg = args[0];
        System.out.println(s.replace(" ","").indexOf(arg));
    }
}
/*
В классе объявлена статическая переменная строкового типа со значением (кавычки не включены):
«Циклом называется многократное выполнение одних и тех же действий.»

Используя только методы класса String (без циклов, условий),
напишите программу, которая печатает количество букв (без пробелов и точки) в переменной до определенного символа (не включая его).
Значение символа передается через аргумент командной строки.

Пример:
Через аргументы передается "Ц", Вывод: 0.
Через аргументы передается "а", Вывод: 7.
Через аргументы передается ".", Вывод: 57.

 */