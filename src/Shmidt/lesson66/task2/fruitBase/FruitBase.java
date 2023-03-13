package Shmidt.lesson66.task2.fruitBase;

import Shmidt.lesson66.task2.fruitBase.fruits.Fruit;

public class FruitBase {
    FruitCatalogue fruitCatalogue;

    public FruitBase() {
        fruitCatalogue = new FruitCatalogue();
    }

    public Cargo takeOrder(String[] fruitsOrder) {
        Cargo cargo = new Cargo();
        for (String fruitOrder : fruitsOrder) {
            for (Fruit fruitInCat : fruitCatalogue.getFruitCatalogue()) {
                if (fruitInCat.getName().equals(fruitOrder)) {//если фрукт заказа есть в каталоге - добавляем его
                    cargo.addFruit(fruitInCat);
                    break;
                }
            }
        }
        return cargo;
    }


    //Orange Blueberry Blueberry Pineapple Pineapple бульбазавр Orange Banana Apple Grape Pineapple
    public static void main(String[] args) {
        FruitBase base = new FruitBase();

        if (args.length > 0) {
            Cargo cargoOrder = base.takeOrder(args);
            System.out.println("Груз заказа заполнен:");
            System.out.println(cargoOrder);

            cargoOrder.removeFruitAt(4);
            System.out.println("Убрали фрукт с 4 позиции");
            System.out.println(cargoOrder);

            cargoOrder.addFruit(base.fruitCatalogue.getFruit(2));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit(2));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit("Banana"));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit("Banana"));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit("Banana"));
            System.out.println("Добавили бананов");
            System.out.println(cargoOrder);

            cargoOrder.removeFruitAt(base.fruitCatalogue.getFruitCatalogue().get(0));
            System.out.println("Убрали яблоко");
            System.out.println(cargoOrder);

            cargoOrder.removeFruitAt(base.fruitCatalogue.getFruitCatalogue().get(0));
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