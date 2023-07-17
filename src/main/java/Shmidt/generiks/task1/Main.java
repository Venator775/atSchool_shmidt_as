package Shmidt.generiks.task1;

import Shmidt.generiks.task1.fruits.*;
import Shmidt.generiks.task1.vegetables.*;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Banana banana = new Banana();
        Cucumber cucumber = new Cucumber();
        Tomato tomato = new Tomato();

        Basket<Fruit> fruits = new Basket<>();
        Basket<Vegetable> vegetables = new Basket<>();

        fruits.addItem(apple);
        fruits.addItem(banana);
        vegetables.addItem(cucumber);
        vegetables.addItem(tomato);
//        fruits.addItem(cucumber);//тут будет ошибка компиляции

        System.out.println("Фрукты:");
        fruits.getPlants().forEach(System.out::println);
        System.out.println("Овощи:");
        vegetables.getPlants().forEach(System.out::println);
    }
}
/*
4.В отдельном классе в методе main создать по одному фрукту, овощу и по одной корзине для фруктов и для овощей отдельно (всего две).
Всю клетчатку надо разложить по соответствующим корзинам,
если получится положить огурец в корзину для фруктов, то стоит ещё раз пересмотреть тему с дженериками.
 */
