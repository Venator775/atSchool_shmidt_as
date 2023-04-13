package Shmidt.abstractAndInterfaces.lesson10.task1.baseElements;

import Shmidt.abstractAndInterfaces.lesson10.task1.NatureElement;
import Shmidt.abstractAndInterfaces.lesson10.task1.resultElements.*;

public class Fire extends NatureElement {
    public NatureElement connect(NatureElement natElem) {
        switch (natElem.getClass().getSimpleName()) {
            case ("Water"):
                //System.out.println("Steam");
                return new Steam();
            case ("Fire"):
                //System.out.println("Не производит новый элемент");
                return new Fire();
            case ("Ground"):
                //System.out.println("Lava");
                return new Lava();
            case ("Air"):
                //System.out.println("Energy");
                return new Energy();
            default:
                System.out.println("HZ");
                return null;
        }
    }

}
