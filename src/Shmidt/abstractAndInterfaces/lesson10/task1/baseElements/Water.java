package Shmidt.abstractAndInterfaces.lesson10.task1.baseElements;

import Shmidt.abstractAndInterfaces.lesson10.task1.NatureElement;
import Shmidt.abstractAndInterfaces.lesson10.task1.resultElements.*;

public class Water extends NatureElement {
    /*
          Water + Water = Sea
      Water + Fire = Steam
      Water + Earth = Mud
      Water + Air = Rain
     */

    public NatureElement connect(NatureElement natElem) {
        switch (natElem.getClass().getSimpleName()) {
            case ("Water"):
                //System.out.println("Sea");
                return new Sea();
            case ("Fire"):
                //System.out.println("Steam");
                return new Steam();
            case ("Ground"):
                //System.out.println("Mud");
                return new Mud();
            case ("Air"):
                //System.out.println("Rain");
                return new Rain();
            default:
                System.out.println("HZ");
                return null;
        }
    }
}
/*
    public static <T> T getLastMessage(getLastMessageType returnType, int n) {
        switch (returnType) {
            case webElement -> {
                List<WebElement> mess = driver.findElements(By.xpath("//div[@class='_im_peer_history im-page-chat-contain glubs-container']//div[@class='im-mess--text wall_module _im_log_body']"));
                return (T) mess.get(mess.size() - 1 - n);
            }
            case text -> {
                List<WebElement> mess = driver.findElements(By.xpath("//div[@class='_im_peer_history im-page-chat-contain glubs-container']//div[@class='im-mess--text wall_module _im_log_body']"));
                WebElement s = mess.get(mess.size() - 1 - n);
                return (T) s.getText();
            }
        }
        return null;
    }*/