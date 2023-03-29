package Shmidt.lesson75.fruitBase;

import Shmidt.lesson75.fruitBase.fruits.Fruit;

public class FruitBase {
    private FruitCatalogue fruitCatalogue;

    public FruitBase() {
        fruitCatalogue = new FruitCatalogue();
    }

    public Cargo takeOrder(String[] fruitsOrder) {
        Cargo cargo = new Cargo();

        for (String fruitOrder : fruitsOrder) {
            Fruit fruit = fruitCatalogue.getFruit(fruitOrder);
            if (fruit != null) {
                fruit.setRandFresh();//устанавливаем рандомную свежесть
                cargo.addFruit(fruit);
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

            cargoOrder.removeFruit(4);
            System.out.println("Убрали фрукт с 4 позиции");
            System.out.println(cargoOrder);

            cargoOrder.addFruit(base.fruitCatalogue.getFruit(2));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit(2));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit("Banana"));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit("Banana"));
            cargoOrder.addFruit(base.fruitCatalogue.getFruit("Banana"));
            System.out.println("Добавили бананов");
            System.out.println(cargoOrder);

            cargoOrder.removeFruit(base.fruitCatalogue.getFruitCatalogue().get(0));
            System.out.println("Убрали яблоко");
            System.out.println(cargoOrder);

            cargoOrder.removeFruit(base.fruitCatalogue.getFruitCatalogue().get(0));
            System.out.println("Попытались ещё убрать яблоко");
            System.out.println(cargoOrder);
        } else {
            System.out.println("Заказ пуст.");
            System.exit(0);
        }
    }
}
