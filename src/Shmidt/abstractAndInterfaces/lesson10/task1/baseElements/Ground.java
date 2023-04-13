package Shmidt.abstractAndInterfaces.lesson10.task1.baseElements;

import Shmidt.abstractAndInterfaces.lesson10.task1.NatureElement;
import Shmidt.abstractAndInterfaces.lesson10.task1.resultElements.*;

public class Ground extends NatureElement {


    public NatureElement connect(NatureElement natElem) {
        switch (natElem.getClass().getSimpleName()) {
            case ("Water"):
                //System.out.println("Mud");
                return new Mud();
            case ("Fire"):
                //System.out.println("Lava");
                return new Lava();
            case ("Ground"):
                //System.out.println("Pressure");
                return new Pressure();
            case ("Air"):
                //System.out.println("Dust");
                return new Dust();
            default:
                System.out.println("HZ");
                return null;
        }
    }
}
