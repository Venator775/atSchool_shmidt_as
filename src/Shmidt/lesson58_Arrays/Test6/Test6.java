package Shmidt.lesson58_Arrays.Test6;

import static Shmidt.lesson54.Task5.isInteger;
import static Shmidt.lesson54.Task6.toInt;

public class Test6 {
    public static void main(String[] args) {

        int[] ars = new int[args.length];

        for (int i = 0; i < ars.length; i++) {
            if (isInteger(args[i])) {
                int g = toInt(args[i]);
                ars[i]=g;
            } else {
                System.out.println("Элемент не является целым числом");
                System.exit(-1);
            }
        }

        DynamicArray dynArray = new DynamicArray(ars);
        System.out.println("Получили массив dynArray:\n" + "[" + dynArray + "]");

        DynamicArray dynArray2 = new DynamicArray(dynArray.getArray());
        int delInd = 0;
        System.out.println("Массив dynArray2:\n" + "[" + dynArray2 + "]");
        dynArray2.delete(delInd);
        System.out.println("Массив dynArray2 после удаления из него " + delInd + " элемента:\n" + "[" + dynArray2 + "]");

        System.out.println("\nПросто проверка работы остальных методов.");
        int from = 2, to = 5;
        DynamicArray ar1 = new DynamicArray(dynArray.get(from, to));
        System.out.println("dynArray get(from = " + from + ",to = " + to + "):\n" + "[" + ar1 + "]");

        int at = 5;
        System.out.println("dynArray getAt " + at + ":\n" + "[" + dynArray.getAt(at) + "]");

        int addVal = -18;
        System.out.println("ar1 add " + addVal + ":");
        System.out.println("[" + ar1 + "]");
        ar1.add(addVal);
        System.out.println("[" + ar1 + "]");

        System.out.println("ar1 add[] {1,2,-3,5}:");
        ar1.add(new int[]{1, 2, -3, 5});
        System.out.println("[" + ar1 + "]");

        System.out.println("ar1 deleteAll:");
        ar1.deleteAll();
        System.out.println("[" + ar1 + "]");
    }
}
/*
Напишите программу, которая:
- получает через аргументы командной строки целочисленные значения,
- создает объект DynamicArray
- добавляет в него переданные элементы
- печатает полученный объект
- создает второй объект DynamicArray
- копирует все значения из первого во второй
- удаляет один элемент второго объекта
- печатает элементы первого объекта
- печатает элементы второго объекта


Напишите класс DynamicArray - класс, реализующий массив целых чисел с изменяемым размером.
Для хранения значений используется внутренний приватный обычный массив.

У данного класса нужно реализовать:
- конструктор с целочисленным параметром - начальным размером массива
  создает внутренний массив указанного размера
- конструктор с параметром-массивом
  создает внутреннюю копию переданного массива

Класс также должен реализовать методы:
- String toString() - возвращает строку, где все элементы массива в строку записаны через пробел
- void add(int x) - добавить один элемент в конец внутреннего массива
- void add(int[] x) - добавить элементы из переданного массива в конец внутреннего
- int getAt(int n) - получить один элемент массива с позиции n
- int[] get(int from, int to) - получить массив элементов с начиная с позиции from до to,
  не включая to. Например, при вызове get(0, 5) метод должен вернуть массив
  с элементами из внутреннего приватного с индексами: 0, 1, 2, 3, 4
- void delete(int n) - удалить элемент из массива на позиции n
- void deleteAll()- удалить все элементы


 */