package main.java.Shmidt.lesson54;

public class Task3 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(args[0]);
        System.out.println(sb);

        for (int i = 0; i < sb.length(); i++)
            if (sb.charAt(i) == '1')
                sb.replace(i, i + 1, "0");
            else if (sb.charAt(i) == '0')
                sb.replace(i, i + 1, "1");

        System.out.println(sb);
    }
}
/*
Через аргумент командной строки передается строка.
Используя StringBuilder, напишите программу,
которая в переданной строке заменяет все нули на единицы и наоборот.
Остальные символы не должны изменится.
Выведите результирующую строку.

Пример аргумента: 01a10vt0101c
Вывод: 10a01vt1010c
Проверку на наличие и корректность аргумента делать не надо.
 */
