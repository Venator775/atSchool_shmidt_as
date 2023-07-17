package Shmidt.lambdas.task3;

import Shmidt.lambdas.task3.queue.QueueFirst;
import Shmidt.lambdas.task3.queue.QueueSecond;
import Shmidt.lambdas.task3.queue.Swap;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Переданные аргументы:");
        List.of(args).forEach(arg -> System.out.print(arg + " "));

        System.out.println("\n\nСоздание очередей:");

        QueueFirst queue1 = new QueueFirst();
        List.of(args).forEach(arg -> {
            queue1.add(Integer.parseInt(arg));
        });
        System.out.println("Очередь #1: " + queue1);

        Swap methodAsc = new Swap() {//оставил анонимным классом, чтоб был его пример перед глазами
            public boolean needToSwap(int a, int b) {
                return a > b;
            }
        };
        queue1.sort(methodAsc);
        System.out.println("Очередь #1 (отсортированная по возрастанию): " + queue1);

//        for (int i = 0; i < queue1.getQueue().size(); i++) {
//            System.out.println("Удалён эемент " + queue1.remove() + ". Новая очередь: " + queue1);
//            i--;
//        }

        System.out.println();
        QueueSecond queue2 = new QueueSecond();
        List.of(args).forEach(arg -> {
            queue2.add(Integer.parseInt(arg));
        });
        System.out.println("Очередь #2: " + queue2);

        queue2.sort((a, b) -> a < b);
        System.out.println("Очередь #2 (отсортированная по убыванию): " + queue2);

//        for (int i = 0; i < queue2.getQueue().size(); i++) {
//            System.out.println("Удалён эемент " + queue2.remove() + ". Новая очередь: " + queue2);
//            i--;
//        }
    }
}
/*
Напишите программу, в которой через аргументы командной строки передаются целые числа;
Для обоих типов очереди:
    создается очередь, в которую добавляются эти числа.
    Когда все значения добавлены выводится содержимое очереди.
    Далее по одному удаляются элементы из очереди и печатается текущее содержимое очереди.
 */