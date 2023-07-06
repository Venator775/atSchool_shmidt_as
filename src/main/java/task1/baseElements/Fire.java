package task1.baseElements;


import task1.NatureElement;
import task1.resultElements.Energy;
import task1.resultElements.Lava;
import task1.resultElements.Steam;

public class Fire extends NatureElement {
    public NatureElement connect(NatureElement natElem) {
        if (natElem != null)
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
                    return null;
            }
        else return null;
    }

}
