package Shmidt.generiks.task3;

import Shmidt.generiks.task3.fruits.Apple;
import Shmidt.generiks.task3.fruits.Banana;
import Shmidt.generiks.task3.vegetables.Cucumber;
import Shmidt.generiks.task3.vegetables.Tomato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main<T> {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Banana banana = new Banana();
        Cucumber cucumber = new Cucumber();
        Tomato tomato = new Tomato();

        ArrayList<Plant> plants = new ArrayList<>(List.of(apple, banana, cucumber, tomato));

        HashMap<String,Plant> map = new HashMap<>();

        plants.forEach(plant -> map.put(plant.getName(), plant));

        map.keySet().forEach(key -> System.out.println(key + " " + map.get(key).getClass().getSimpleName()));
    }
}
/*
Создать ArrayList plants и заполнить его экземплярами фруктов и овощей всех видов по 1 штуке каждого (!в 1 ArrayList).
Создать HashMap и заполнить его фруктами и овощами с помощью forEach, в ключ записывая название фрукта/овоща, а в значение - само растение.
Вывести на экран название растения из карты и рядом с ним имя класса через пробел.
 */
