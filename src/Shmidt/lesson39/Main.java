package Shmidt.lesson39;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat(1,2.1,"gray","orange");
        Cat cat3 = new Cat(3,3.6);
        Cat cat4 = new Cat("brown","green");
        Cat cat5 = new Cat(5,4,"white","green");
        Cat cat6 = new Cat(4,"blue");

        List.of(cat1,cat2,cat3,cat4,cat5,cat6).stream().forEach(
                catX -> {
                    System.out.println(catX+"\n");
                }
        );

    }
}
