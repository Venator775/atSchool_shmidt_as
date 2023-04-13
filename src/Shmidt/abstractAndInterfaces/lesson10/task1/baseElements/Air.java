package Shmidt.abstractAndInterfaces.lesson10.task1.baseElements;

import Shmidt.abstractAndInterfaces.lesson10.task1.NatureElement;
import Shmidt.abstractAndInterfaces.lesson10.task1.resultElements.*;

public class Air extends NatureElement {
    public NatureElement connect(NatureElement natElem) {
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
                System.out.println("HZ");
                return null;
        }
    }
}
