package Shmidt.lesson39;

import java.lang.reflect.Type;
import java.util.List;

import static Shmidt.lesson39.Summa.sum;

public class Main {
    public static void main(String[] args) {

        //Task 1
        Cat cat1 = new Cat();
        Cat cat2 = new Cat(1, 2.1, "gray", "orange");
        Cat cat3 = new Cat(3, 3.6);
        Cat cat4 = new Cat("brown", "green");
        Cat cat5 = new Cat(5, 4, "white", "green");
        Cat cat6 = new Cat(4, "blue");

        List.of(cat1, cat2, cat3, cat4, cat5, cat6).stream().forEach(
                catX -> {
                    System.out.println(catX + "\n");
                }
        );


        //Task 2
        int a = 1, b = 2;
        double x = 1.1, y = 2.2, z = 3.3;

        System.out.println("сумма int от 2х переменных int:" + sum(a,b));
        System.out.println("сумма double от 3х переменных int:" + sum(a,b,a));
        System.out.println("сумма double от 2х переменных double:" + sum(x,z));
        System.out.println("сумма double от 3х переменных double:" + sum(y,x,z));
        System.out.println("сумма double от 1 int и от 2х переменных double:" + sum(a,y,z));
        System.out.println("сумма double из 2х переменных типа Integer:" + sum(Integer.valueOf(a),Integer.valueOf(b)));



    }
}
