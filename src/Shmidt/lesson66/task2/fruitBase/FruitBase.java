package Shmidt.lesson66.task2.fruitBase;

import Shmidt.lesson66.task2.fruitBase.fruits.Apple;
import Shmidt.lesson66.task2.fruitBase.fruits.Fruit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FruitBase {
    List<Fruit> FruitCatalogue;

    public FruitBase() {
        FruitCatalogue = new ArrayList<>();

        FruitCatalogue.add(new Apple("Apple", BigDecimal.valueOf(10), 150));
        FruitCatalogue.add(new Apple("Orange", BigDecimal.valueOf(20), 170.5));
        FruitCatalogue.add(new Apple("Banana", BigDecimal.valueOf(35), 130.3));
        FruitCatalogue.add(new Apple("Pineapple", BigDecimal.valueOf(151), 280.4));
    }

    public Cargo takeOrder(String[] fruitsOrder) {
        Cargo cargo = new Cargo();
        for (String fruitOrder : fruitsOrder) {
            for (Fruit fruitInCat : FruitCatalogue) {
                if (fruitInCat.getName().equals(fruitOrder)) {
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