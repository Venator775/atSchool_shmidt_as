package task1.baseElements;


import task1.NatureElement;
import task1.resultElements.*;

public class Fire extends NatureElement {
    public NatureElement connect(NatureElement natElem) {
        switch (natElem.getClass().getSimpleName()) {
            case ("Water"):
                return new Steam();
            case ("Fire"):
                return new Fire();
            case ("Ground"):
                return new Lava();
            case ("Air"):
                return new Energy();
            default:
                System.out.println("HZ");
                return null;
        }
    }

}
