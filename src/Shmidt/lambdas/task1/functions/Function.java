package Shmidt.lambdas.task1.functions;

public interface Function {
    int evaluate(int param);
}

/*
Создайте интерфейс Function, который объявляет абстрактный метод evaluate.
Метод принимает параметр int и возвращает int.

Создайте классы Half, Double, Exact, Square, реализующие интерфейс Function.
В этих классах реализуется метод evaluate:
- у класса Half метод evaluate делит полученный параметр на 2
- у класса Double метод evaluate умножает полученный параметр на 2
- у класса Exact метод evaluate возвращет параметр без изменения
- у класса Square метод evaluate возвращет параметр, умноженный на сам себя
 */