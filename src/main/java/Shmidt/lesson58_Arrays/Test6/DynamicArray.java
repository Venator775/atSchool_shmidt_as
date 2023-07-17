package main.java.Shmidt.lesson58_Arrays.Test6;

public class DynamicArray {
    private int[] array;

    /**
     * конструктор с параметром-массивом
     */
    public DynamicArray(int[] array) {
        this.array = array.clone();
    }

    /**
     * конструктор с целочисленным параметром - начальным размером массива
     */
    public DynamicArray(int len) {
        this.array = new int[len];
    }

    /**
     * возвращает строку, где все элементы массива в строку записаны через пробел
     */
    @Override
    public String toString() {
        StringBuilder ar = new StringBuilder();
        for (int i = 0; i < this.array.length; i++) {
            ar.append(this.array[i] + " ");
        }
        return ar.toString();
    }

    /**
     * добавить один элемент в конец внутреннего массива
     */
    void add(int x) {
        int[] ar = new int[this.array.length + 1];
        for (int i = 0; i < this.array.length; i++) {
            ar[i] = this.array[i];
        }
        ar[ar.length - 1] = x;
        this.array = ar;
    }

    /**
     * добавить элементы из переданного массива в конец внутреннего
     */
    void add(int[] x) {
        int[] ar = new int[this.array.length + x.length];
        for (int i = 0; i < this.array.length; i++) {
            ar[i] = this.array[i];
        }
        for (int i = 0; i < x.length; i++) {
            ar[i + this.array.length] = x[i];
        }
        this.array = ar;
    }

    /**
     * получить один элемент массива с позиции n
     */
    int getAt(int n) {
        return this.array[n];
    }

    /**
     * получить массив элементов с начиная с позиции from до to,
     * не включая to
     */
    int[] get(int from, int to) {
        int[] getAr = new int[to - from];
        for (int i = from; i < to; i++) {
            getAr[i - from]  = this.array[i];
        }
        return getAr;
    }

    /**
     * удалить элемент из массива на позиции n
     */
    void delete(int n) {
        int[] delAr = new int[this.array.length - 1];

        for (int i = 0; i < delAr.length; i++) {
            if (i >= n - 1)
                delAr[i] = this.array[i + 1];
            else
                delAr[i] = this.array[i];
        }
        this.array = delAr;
    }

    /**
     * удалить все элементы
     */
    void deleteAll() {
        this.array = new int[0];
    }


    //Конструкторы
    public int[] getArray() {
        return array;
    }
}
/*
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