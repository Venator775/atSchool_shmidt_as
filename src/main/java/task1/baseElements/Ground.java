package task1.baseElements;


import task1.NatureElement;
import task1.resultElements.*;

public class Ground extends NatureElement {


    public NatureElement connect(NatureElement natElem) {
        switch (natElem.getClass().getSimpleName()) {
            case ("Water"):
                return new Mud();
            case ("Fire"):
                return new Lava();
            case ("Ground"):
                return new Pressure();
            case ("Air"):
                return new Dust();
            default:
                System.out.println("HZ");
                return null;
        }
    }
}
