package Shmidt.DEBT.lesson7_9_StreamAPI.task21;

import Shmidt.DEBT.lesson7_9_StreamAPI.task21.vegetables.Cucumber;
import Shmidt.DEBT.lesson7_9_StreamAPI.task21.vegetables.Tomato;

public class Main<T> {
    public static void main(String[] args) {

        Basket basket = new Basket();
        basket.addItemToMap(new Cucumber());
        basket.addItemToMap(new Cucumber());
        basket.addItemToMap(new Cucumber());
        basket.addItemToMap(new Tomato());
        basket.addItemToMap(new Tomato());

        System.out.println("map: " + basket.getPlantsMap() +
                "\nbasket size: " + basket.size());
    }
}
/*
Реализовать для корзины метод size, возвращающий, количество элементов в корзине.

Реализовать класс с огурцами так, чтобы можно было добавить в одну и ту же корзину, в которую добавляем овощи, один и тот же огурец несколько раз.
Помидоры не трогать.

Другими словами, делаем одно поле с огурцом и одно поле с помидором в корзину для овощей
(из третьего задания, в котором складываем всё в глобальное поле HashMap).
Добавляем этот огурец три раза подряд и два раза подряд добавляем помидор, вызывая метод addItem.
После этого вызываем метод size и он должен вывести ответ 4.
 */
