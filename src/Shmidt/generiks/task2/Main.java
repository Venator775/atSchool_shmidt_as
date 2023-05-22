package Shmidt.generiks.task2;

import Shmidt.generiks.task2.fruits.Apple;
import Shmidt.generiks.task2.fruits.Banana;
import Shmidt.generiks.task2.fruits.Fruit;
import Shmidt.generiks.task2.vegetables.Cucumber;
import Shmidt.generiks.task2.vegetables.Tomato;
import Shmidt.generiks.task2.vegetables.Vegetable;

import java.util.Map;

public class Main<T> {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Banana banana = new Banana();
        Cucumber cucumber = new Cucumber();
        Tomato tomato = new Tomato();

        Basket<Fruit> fruits = new Basket<>();
        Basket<Vegetable> vegetables = new Basket<>();

/*        fruits.addItem(apple);
        fruits.addItem(banana);
        vegetables.addItem(cucumber);
        vegetables.addItem(tomato);

        System.out.println("Фрукты:");
        fruits.getPlants().forEach(System.out::println);
        System.out.println("Овощи:");
        vegetables.getPlants().forEach(System.out::println);*/

        fruits.addItemToMap(apple);
        fruits.addItemToMap(banana);
        vegetables.addItemToMap(cucumber);
        vegetables.addItemToMap(tomato);

        Main m = new Main();//костыль =/
        m.makeSalad(fruits);
        m.makeSalad(vegetables);
    }

    void makeSalad(Basket<T> basket) {//почему нельзя статик?
        System.out.print("Режем салат:");
        var mapIterator = basket.getPlantsMap().entrySet().iterator();
        while (mapIterator.hasNext()) {//намеренно оставил этот пример, чтоб был перед глазами, взамен for ( : ). С итераторами никогда не имел дел.
            Map.Entry<Plant, T> entry = mapIterator.next();
            System.out.print(entry.getKey().getName() + " ");
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
