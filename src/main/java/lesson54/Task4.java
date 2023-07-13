package lesson54;

public class Task4 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(args[0]);
        System.out.println(sb);

        for (int i = 0; i < sb.length(); i++)
            if (!Character.isDigit(sb.charAt(i))) {
                sb.replace(i, i + 1, "");
                i--;
            }

        System.out.println(sb);
    }
}
/*
Через аргумент командной строки передается строка.
Используя StringBuilder, напишите программу, которая в переданной строке удаляет из неё всё, кроме цифр.
Выведите результирующую строку.

1)
Пример аргумента: 01a10vt0101c
Вывод: 01100101

2)
Пример аргумента: avtc
Вывод:

Проверку на наличие и корректность аргумента делать не надо.
 */