package Shmidt.DEBT.lesson7_9_StreamAPI.task1;

import Shmidt.DEBT.lesson7_9_StreamAPI.task1.fruits.Apple;
import Shmidt.DEBT.lesson7_9_StreamAPI.task1.fruits.Banana;
import Shmidt.DEBT.lesson7_9_StreamAPI.task1.fruits.Fruit;
import Shmidt.DEBT.lesson7_9_StreamAPI.task1.vegetables.Cucumber;
import Shmidt.DEBT.lesson7_9_StreamAPI.task1.vegetables.Tomato;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main<T> {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Banana banana = new Banana();
        Cucumber cucumber = new Cucumber();
        Tomato tomato = new Tomato();

        ArrayList<Plant> plants = new ArrayList<>(List.of(apple, banana, cucumber, tomato));

        ArrayList<Fruit> multifruit = new ArrayList<>();

        multifruit.addAll(plants.stream()
                .filter(p -> {
                    if (p instanceof Fruit)
                        return true;
                    else return false;
                })
                .map(plant -> (Fruit) plant)
                .collect(Collectors.toList()));

        multifruit.forEach(System.out::println);
    }
}
/*
Создать общий родительский интерфейс для овощей и фруктов Plant.
Создать ArrayList plants и заполнить его экземплярами фруктов и овощей всех видов по 1 штуке каждого (!в 1 ArrayList).
Создать ArrayList, который принимает только фрукты, назвать multifruit.
Заполнить multifruit только фруктами из plants, используя streamAPI.
Один только stream, никаких циклов, вторых stream открывать не надо.
Вывести на экран названия фруктов.
 */
