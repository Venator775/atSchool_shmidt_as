package Shmidt.lesson75.fruitBase;


public class Simulation {
    //Orange Blueberry Blueberry Pineapple Pineapple бульбазавр Orange Banana Apple Grape Pineapple
    public static void main(String[] args) {
        FruitBase base = new FruitBase();



        if (args.length > 0) {
            Cargo cargoOrder = base.takeOrder(args);


        } else {
            System.out.println("Заказ пуст.");
        }
    }

}
