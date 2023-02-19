package Shmidt.lesson47.task6;

import java.time.LocalDateTime;

public class Task6 {
    public static void main(String[] args) {
        if (Integer.valueOf(args[0]) < 0) {
            System.out.println("Ошибка. Значение < 0");
            System.exit(0);
        }

        Timer waiter = new Timer(Integer.valueOf(args[0]));
        waiter.start();


        System.out.println(LocalDateTime.now().getNano());
        System.out.println(LocalDateTime.now().getSecond());
        System.out.println(LocalDateTime.now().getMinute());
        System.out.println(LocalDateTime.now().getHour());
    }
}

/*
Реализуйте класс Timer, который содержит:
- целочисленное поле seconds - общее число секунд, устанавливается в конструкторе
- статический метод void waitSecond() - метод реализует паузу
одной секунды. Реализовать с помощью цикла.
- метод printTime вывода оставшегося времени в минутах и секундах.
- объектный метод start() - запускает обратный отсчет
и каждую секунды выводит оставшееся количество секунд.

Напишите программу-таймер обратного отсчета в минутах и секундах,

используя созданные класс Timer.
Через аргументы командной строки передается число секунд.

Проверку на наличие аргумента делать не надо.
Нужно проверить, что введенное число больше или равно нуля.
В противном случае выведите сообщение об ошибке
и завершите программу.


Например, для 61 секунды формат вывода:
01:01
01:00
00:59
...
00:01
00:00
 */