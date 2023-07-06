package task1;

import task1.baseElements.*;

public class NatureElement {

    protected NatureElement connect(NatureElement natElem) {
        return null;
    }

    static public NatureElement create(String elemName) {
        switch (elemName) {
            case ("Fire"): {
                return new Fire();
            }
            case ("Air"): {
                return new Air();
            }
            case ("Ground"): {
                return new Ground();
            }
            case ("Water"): {
                return new Water();
            }
            default:
                return null;
        }
    }

}
