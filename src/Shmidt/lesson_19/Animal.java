package Shmidt.lesson_19;

import jdk.jfr.Description;
import jdk.jfr.Label;

import java.lang.annotation.Target;

public abstract class Animal {
    //Кличка
    public String name;
    //Название типа пищи
    public String food;
    //Кол-во запасов пищи
    public int foodCounter;
    //название страны обитания
    public String location;
    //все животные имеют внутреннюю связь с сородичами, в переменной содержится общее кол-во осыбей данного вида
    public int counter;
    //состояние здоровья животного
    public HealthState health;

    enum HealthState {
        HEALTHY,
        UNHEALTHY
    }

    /**
     * выводит текст, как звучит животное
     */
    abstract void makeSound();

    /**
     * - eat - выводит текст, что животное ест;
     * уменьшает кол-во еды у животного;
     * также выводит сколько запасов осталось
     */
    abstract void eat();

    /**
     * выводит текст, что животное спит
     */
    void sleep() {
        System.out.println("Животное спит");
    }

    /**
     * вовзращает в виде строки текущую информацию об особи
     */
    @Override
    public String toString() {
        System.out.println("Кличка:" + name + "" +
                "Страна обитания:" + location +
                "Состояние здоровья:" + health +
                "Сколько особей:" + counter
        );
        /*
        Формат вывода:
        <Кличка>
        Страна обитания: ...
        Состояние здоровья: ...
        Сколько особей: ...
        */
        return null;
    }
}
/*
Создать класс Animal и расширяющие его классы Dog, Cat, Horse.


Класс Animal - абстрактный.

Содержит параметры:
- name - кличка животного
- food - название типа пищи
- foodCounter - кол-во запасов пищи
- location - название страны обитания
- counter - все животные имеют внутреннюю связь с сородичами,
    в переменной содержится общее кол-во осыбей данного вида

- health - состояние здоровья животного типа HealthState
Возможные значения HealthState
  HEALTHY,
  UNHEALTHY

Класс Animal содержит методы:
- makeSound - выводит текст, как звучит животное
- eat - выводит текст, что животное ест;
          уменьшает кол-во еды у животного;
          также выводит сколько запасов осталось
- sleep - выводит текст, что животное спит
- toString - вовзращает в виде строки текущую информацию об особи
Формат вывода:
<Кличка>
  Страна обитания: ...
  Состояние здоровья: ...
  Сколько особей: ...
*/