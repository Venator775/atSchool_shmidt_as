package Shmidt.lesson66.task2.fruitBase;

import Shmidt.lesson66.task2.fruitBase.fruits.Fruit;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class Cargo {
    private List<Fruit> fruits;

    public Cargo() {
        this.fruits = new ArrayList<>();
    }

    /**
     * возвращает суммарный вес груза
     *
     * @return
     */
    public double getWeight() {
        double cargoWeight = 0;
        for (Fruit f : fruits)
            cargoWeight += f.getWeight();
        return cargoWeight;
    }

    /**
     * возвращает суммарную цену груза
     *
     * @return
     */
    public BigDecimal getPrice() {
        BigDecimal cargoPrice = BigDecimal.valueOf(0);
        for (Fruit f : fruits)
            cargoPrice = cargoPrice.add(f.getPrice());
        return cargoPrice;
    }

    /**
     * добавляет Fruit во внутренний массив
     *
     * @param fruit
     */
    void addFruit(Fruit fruit) {
        this.fruits.add(fruit);
    }

    /**
     * Удаляет Fruit из внутреннего массива с позиции n
     * Написал его просто так, чтоб был логически
     * @param n
     */
    void removeFruitAt(int n) {
        this.fruits.remove(n);
    }

    void removeFruitAt(Fruit fruit) {
        if(this.fruits.contains(fruit))
            this.fruits.remove(this.fruits.lastIndexOf(fruit));
        else System.out.println("Фрукта нет в списке");
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    @Override
    public String toString() {
        StringBuilder cargoInfo = new StringBuilder();

        Set fruitSet = new HashSet<>();//Список неповторяющихся фруктов в заказе
        HashMap<Fruit, Integer> fruitsCount = new HashMap<>();//Список, содержащий какого фрукта в каком количестве есть в заказе

        for (Fruit f : fruits) {
            if (fruitSet.add(f)) {//если фрукт отсутствовал, он добавляется и его количество = 1
                fruitsCount.put(f, 1);
            } else {
                int fCount = fruitsCount.get(f);
                fruitsCount.replace(f, fruitsCount.get(f), ++fCount);//увеличиваем количество фруктов, если он уже был в списке
            }
        }//на выходе получаем список с указанием какие фрукты в каком количестве есть в заказе

        if (fruits.size() > 0) {
            for (var f : fruitsCount.entrySet())
                cargoInfo.append(f.getKey().getName() + ":\t" + f.getValue() + " [" + f.getKey().getPrice() + " у.е./" + f.getKey().getWeight() + "гр.]" + "\n");

            var totalWeight = new DecimalFormat("#0.00").format(this.getWeight());
            var totalPrice = new DecimalFormat("# ###.00").format(this.getPrice());

            cargoInfo.append("Общий вес заказа: " + totalWeight + "\n");
            cargoInfo.append("Общая сумма заказа: " + totalPrice + "\n");
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