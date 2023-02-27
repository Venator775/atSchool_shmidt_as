package Shmidt.lesson66.task2.fruitBase;

import Shmidt.lesson66.task2.fruitBase.fruits.Apple;
import Shmidt.lesson66.task2.fruitBase.fruits.Banana;
import Shmidt.lesson66.task2.fruitBase.fruits.Fruit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FruitBase {
    List<Fruit> fruitCatalogue;

    public FruitBase() {
        fruitCatalogue = new ArrayList<>();

        fruitCatalogue.add(new Apple("Apple", BigDecimal.valueOf(10), 150));
        fruitCatalogue.add(new Apple("Orange", BigDecimal.valueOf(20), 170.5));
        fruitCatalogue.add(new Apple("Banana", BigDecimal.valueOf(35), 130.3));
        fruitCatalogue.add(new Apple("Pineapple", BigDecimal.valueOf(151), 280.4));
    }

    public Cargo takeOrder(String[] fruitsOrder) {
        Cargo cargo = new Cargo();
        for (String fruitOrder : fruitsOrder) {
            for (Fruit fruitInCat : fruitCatalogue) {
                if (fruitInCat.getName().equals(fruitOrder)) {//если фрукт заказа есть в каталоге - добавляем его
                    cargo.addFruit(fruitInCat);
                    break;
                }
            }
        }
        return cargo;
    }


    public static void main(String[] args) {
        FruitBase base = new FruitBase();

        if (args.length > 0) {
            Cargo cargoOrder = base.takeOrder(args);
            System.out.println("Груз заказа заполнен:");
            System.out.println(cargoOrder);

            cargoOrder.removeFruitAt(4);
            System.out.println("Убрали фрукт с 4 позиции");
            System.out.println(cargoOrder);

            cargoOrder.addFruit(base.fruitCatalogue.get(2));
            cargoOrder.addFruit(base.fruitCatalogue.get(2));
            cargoOrder.addFruit(base.fruitCatalogue.get(2));
            cargoOrder.addFruit(base.fruitCatalogue.get(2));
            cargoOrder.addFruit(base.fruitCatalogue.get(2));
            System.out.println("Добавили бананов");
            System.out.println(cargoOrder);

            cargoOrder.removeFruitAt(base.fruitCatalogue.get(0));
            System.out.println("Убрали яблоко");
            System.out.println(cargoOrder);

            cargoOrder.removeFruitAt(base.fruitCatalogue.get(0));
            System.out.println("Попытались ещё убрать яблоко");
            System.out.println(cargoOrder);
        } else {
            System.out.println("Заказ пуст.");
            System.exit(0);
        }
    }
}
/*
- класс FruitBase
    находится в пакете com.fruitbase
    содержит поле FruitCatalogue
    содержит конструктор без параметров
        в нем инициализируется поле FruitCatalogue
    содержит общедоступный метод для обработки заказа takeOrder
        в этом методе происходит поиск слов из заказа в FruitCatalogue
        если хотя бы одно название найдено, то формируется груз Cargo с информацией о найденных фруктах
        Если среди запроса не встретились известные названия,
        то возвращается груз Cargo с нулевым количеством фруктов
    содержит метод main
        здесь происходит выполнение программы согласно описанию выше
        основные шаги:
            создается фруктовая база
            проверяется наличие заказа от пользователя
            если есть заказ, то он передается в метод takeOrder
            выводим результат
 */