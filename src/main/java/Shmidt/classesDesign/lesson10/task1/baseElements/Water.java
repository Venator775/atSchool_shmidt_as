package Shmidt.classesDesign.lesson10.task1.baseElements;

import Shmidt.classesDesign.lesson10.task1.NatureElement;
import Shmidt.classesDesign.lesson10.task1.resultElements.*;

public class Water extends NatureElement {

    public NatureElement connect(NatureElement natElem) {
        switch (natElem.getClass().getSimpleName()) {
            case ("Water"):
                return new Sea();
            case ("Fire"):
                return new Steam();
            case ("Ground"):
                return new Mud();
            case ("Air"):
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