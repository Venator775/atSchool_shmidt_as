package Shmidt.generiks.task1;

import java.util.ArrayList;

public class Basket<T> {
    private ArrayList<T> plants;

    public void addItem(T plant) {
        if (plants == null)
            plants = new ArrayList<>();

        plants.add(plant);
    }

    public ArrayList<T> getPlants() {
        return plants;
    }

//    public void addItem1(<T>) {
//        fruits.add(fruit);
//        System.out.println();
//    }
//
//    public static <T> T getLastMessage(getLastMessageType returnType, int n) {
//        switch (returnType) {
//            case webElement -> {
//                List<WebElement> mess = driver.findElements(By.xpath("//div[@class='_im_peer_history im-page-chat-contain glubs-container']//div[@class='im-mess--text wall_module _im_log_body']"));
//                return (T) mess.get(mess.size() - 1 - n);
//            }
//            case text -> {
//                List<WebElement> mess = driver.findElements(By.xpath("//div[@class='_im_peer_history im-page-chat-contain glubs-container']//div[@class='im-mess--text wall_module _im_log_body']"));
//                WebElement s = mess.get(mess.size() - 1 - n);
//                return (T) s.getText();
//            }
//        }
//        return null;
//    }

}
//3.Реализовать класс Basket,
// с методом addItem, который будет принимать в себя только овощи или фрукты
// и помещать это всё в глобальную переменную - массив (5 элементов достаточно) внутри класса.