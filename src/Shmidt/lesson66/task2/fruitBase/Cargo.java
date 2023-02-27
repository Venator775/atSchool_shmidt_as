package Shmidt.lesson66.task2.fruitBase;

import Shmidt.lesson66.task2.fruitBase.fruits.Fruit;

import java.math.BigDecimal;
import java.util.*;

public class Cargo {
    private List<Fruit> fruits;

    public Cargo() {
        this.fruits = new ArrayList<>();
    }

    public double getWeight() {
        double cargoWeight = 0;
        for (Fruit f : fruits)
            cargoWeight += f.getWeight();
        return cargoWeight;
    }

    public BigDecimal getPrice() {
        BigDecimal cargoPrice = BigDecimal.valueOf(0);
        for (Fruit f : fruits)
            cargoPrice = cargoPrice.add(f.getPrice());
        return cargoPrice;
    }

    void addFruit(Fruit fruit) {
        this.fruits.add(fruit);
    }

    void removeFruitAt(int n) {
        this.fruits.remove(n);
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    @Override
    public String toString() {
        StringBuilder cargoInfo = new StringBuilder();

        Set fruitSet = new HashSet<>();
        HashMap<Fruit, Integer> fruitsCount = new HashMap<>();

        for (Fruit f : fruits) {
            if (fruitSet.add(f)) {
                fruitsCount.put(f, 1);
            } else {
                int fCount = fruitsCount.get(f);
                fruitsCount.replace(f, fruitsCount.get(f), ++fCount);
            }
        }


        if (fruits.size() > 0) {
            for (var f : fruitsCount.entrySet())
                cargoInfo.append(f.getKey().getName() + ":\t" + f.getValue() + " [" + f.getKey().getPrice() + " у.е./" + f.getKey().getWeight() + "гр.]" + "\n");

            cargoInfo.append("Общий вес заказа: " + this.getWeight() + "\n");
            cargoInfo.append("Общая сумма заказа: " + this.getPrice() + "\n");
        } else cargoInfo.append("Заказ пуст.");
        return cargoInfo.toString();
    }

    /*    private Fruit[] fruits;

    public Cargo() {
        this.fruits = new Fruit[]{};
    }

    public double getWeight() {
        double cargoWeight = 0;
        for (int i = 0; i < fruits.length; i++) {
            cargoWeight += fruits[i].getWeight();
        }
        return cargoWeight;
    }

    public BigDecimal getPrice() {
        BigDecimal cargoPrice = new BigDecimal(0);
        for (int i = 0; i < fruits.length; i++) {
            cargoPrice.add(fruits[i].getPrice());
        }
        return cargoPrice;
    }

    void addFruit(Fruit fruit) {
        Fruit[] ar = new Fruit[this.fruits.length+1];
        for (int i = 0; i < this.fruits.length; i++) {
            ar[i] = this.fruits[i];
        }
        ar[ar.length - 1] = fruit;
        this.fruits = ar;
    }*/
}
/*
- класс Cargo
    находится в пакете com.fruitbase
    содержит поле массив Fruit - записи о фруктах, добавленных в груз
    содержит консткрутор без параметров
        в нем инициализируется внутренний массив
    содержит общедоступный метод getWeight - возвращает суммарный вес груза
    содержит общедоступный метод getPrice - возвращает суммарную цену груза
    содержит метод addFruit, доступный только в пакете - добавляет Fruit во внутренний массив

 */