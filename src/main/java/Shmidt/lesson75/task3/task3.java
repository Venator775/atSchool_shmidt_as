package main.java.Shmidt.lesson75.task3;

import java.util.ArrayList;
import java.util.List;

import static main.java.Shmidt.tests.sideMethods.rnd;

public class task3 {
    public static void main(String[] args) {

        //!! Посмотрите какой номер и как называется ваша версия jdk. - в данный момент используется jdk-11.0.9
        int l = 1, n = 10000, m = 5;

        for (int i = 0; i < l; i++) {//Напишите программу, в которой выполняются l итераций следующих действий:

            System.out.println("Итерация: " + i);//1) Выводится номер итерации

            Element[] arr = new Element[n];//2) создается массив из n элеметов типа Element, значение каждого элемента = порядковому номеру + l.
            for (int j = 0; j < arr.length; j++) {
                arr[j] = new Element(j + l);
            }

            List<Integer> notNullElementPositions = getNotNullElementPositions(arr);
            while (notNullElementPositions.size() > m) { //Это продолжается пока в массиве не останется m элементов, отличных от null.
                int delPosition = notNullElementPositions.get(rnd(0, notNullElementPositions.size() - 1));//3) случайным образом выбирается элемент и "уничтожается" (в массив на эту позицию записывается null).
                arr[delPosition] = null;

                notNullElementPositions = getNotNullElementPositions(arr);
            }
        }
    }

    static List<Integer> getNotNullElementPositions(Element[] arr) {
        List<Integer> notNullPositions = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                notNullPositions.add(i);
            }
        }

        return notNullPositions;
    }
}
