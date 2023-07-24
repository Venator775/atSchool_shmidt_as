package Shmidt.lesson6_generiks.task2;

import Shmidt.lesson6_generiks.task2.fruits.Apple;
import Shmidt.lesson6_generiks.task2.fruits.Banana;
import Shmidt.lesson6_generiks.task2.fruits.Fruit;
import Shmidt.lesson6_generiks.task2.vegetables.Cucumber;
import Shmidt.lesson6_generiks.task2.vegetables.Tomato;
import Shmidt.lesson6_generiks.task2.vegetables.Vegetable;

import java.util.Iterator;

public class Main<T> {
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

        makeSalad(fruits);
        makeSalad(vegetables);

    }

    static void makeSalad(Basket<? extends Plant> basket) {
        System.out.print("Режем салат:");
        Iterator<Plant> mapIterator = basket.getIterator();
        while (mapIterator.hasNext()) {//намеренно оставил этот пример, чтоб был перед глазами, взамен for ( : ). С итераторами никогда не имел дел.
            System.out.print(mapIterator.next().getName() + " ");
        }
        System.out.println("\nКушать подано");
    }
}
/*
Реализовать метод makeSalad, в классе, где добавляли фрукты и овощи в корзине, в который можно кидать корзину.
Результатом работы этого метода должен был вывод в консоль строк (в методе вывод должен быть с помощью итератора, который реализовали в этом задании):
```
Готовим салатик:
Режем - тут должно быть столько же фруктов, сколько было элементов в корзине

Угощайся!
```
 */
