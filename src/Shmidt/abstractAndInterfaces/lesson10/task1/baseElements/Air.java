package Shmidt.abstractAndInterfaces.lesson10.task1.baseElements;

import Shmidt.abstractAndInterfaces.lesson10.task1.NatureElement;
import Shmidt.abstractAndInterfaces.lesson10.task1.resultElements.*;

public class Air extends NatureElement {
    public NatureElement connect(NatureElement natElem) {
        switch (natElem.getClass().getSimpleName()) {
            case ("Water"):
                //System.out.println("Rain");
                return new Rain();
            case ("Fire"):
                //System.out.println("Energy");
                return new Energy();
            case ("Ground"):
                //System.out.println("Dust");
                return new Dust();
            case ("Air"):
                //System.out.println("Pressure");
                return new Pressure();
            default:
                System.out.println("HZ");
                return null;
        }
    }
}
