package task1.baseElements;


import task1.NatureElement;
import task1.resultElements.Dust;
import task1.resultElements.Lava;
import task1.resultElements.Mud;
import task1.resultElements.Pressure;

public class Ground extends NatureElement {


    public NatureElement connect(NatureElement natElem) {
        if (natElem != null)
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
                    return null;
            }
        else return null;
    }
}
