package classesDesign.lesson10.task1.baseElements;

import classesDesign.lesson10.task1.NatureElement;
import classesDesign.lesson10.task1.resultElements.*;

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
