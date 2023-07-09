package Shmidt.classesDesign.lesson10.task1;

import Shmidt.classesDesign.lesson10.task1.baseElements.*;

public class NatureElement {

    protected NatureElement connect(NatureElement natElem) {
        return null;
    }

    static public NatureElement create(String elemName) {
        switch (elemName) {
            case ("Fire"): {
                System.out.println("Fire");
                return new Fire();
            }
            case ("Air"): {
                System.out.println("Air");
                return new Air();
            }
            case ("Ground"): {
                System.out.println("Ground");
                return new Ground();
            }
            case ("Water"): {
                System.out.println("Water");
                return new Water();
            }
            default:
                System.out.println();
                return null;
        }
    }

}
