package Shmidt.lesson47.task6;

public class Timer {

    public Timer(int seconds) {
        this.seconds = seconds;//сколько секунд ждать
    }

    private int seconds;
    private long finalSecondsValue;
    private long minutesToWait;//сколько минут осталось ждать
    private long secondsToWait;//сколько секунд осталось ждать

    public void waitSecond() {
        long sec = System.currentTimeMillis() + 1000;
        while (sec > System.currentTimeMillis()) {
        }
    }

    public void printTime() {
        long timeToWait = (finalSecondsValue - System.currentTimeMillis()) / 1000;
        secondsToWait = timeToWait % 60;
        minutesToWait = timeToWait / 60;

        System.out.println("Осталось времени: " + String.format("%02d", minutesToWait) + ":" + String.format("%02d", secondsToWait));
    }

    public void start() {
        finalSecondsValue = System.currentTimeMillis() + seconds * 1000;

        while (System.currentTimeMillis() < finalSecondsValue) {
            printTime();
            waitSecond();
        }

        System.out.println("Таймер окончен");
    }
}
/*
Реализуйте класс Timer, который содержит:
- целочисленное поле seconds - общее число секунд, устанавливается в конструкторе
- статический метод void waitSecond() - метод реализует паузу одной секунды. Реализовать с помощью цикла.
- метод printTime вывода оставшегося времени в минутах и секундах.
- объектный метод start() - запускает обратный отсчет
и каждую секунды выводит оставшееся количество секунд.
 */