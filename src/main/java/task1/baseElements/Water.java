package task1.baseElements;


import task1.NatureElement;
import task1.resultElements.Mud;
import task1.resultElements.Rain;
import task1.resultElements.Sea;
import task1.resultElements.Steam;


public class Water extends NatureElement {

    public NatureElement connect(NatureElement natElem) {
        if (natElem != null)
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
                    return null;
            }
        else return null;
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