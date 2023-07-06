package task1.baseElements;


import task1.NatureElement;
import task1.resultElements.Dust;
import task1.resultElements.Energy;
import task1.resultElements.Pressure;
import task1.resultElements.Rain;

public class Air extends NatureElement {
    public NatureElement connect(NatureElement natElem) {
        if (natElem != null)
            switch (natElem.getClass().getSimpleName()) {
                case ("Water"):
                    return new Rain();
                case ("Fire"):
                    return new Energy();
                case ("Ground"):
                    return new Dust();
                case ("Air"):
                    return new Pressure();
                default:
                    return null;
            }
        else return null;
    }
}
