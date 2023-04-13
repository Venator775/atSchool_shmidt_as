package Shmidt.abstractAndInterfaces.lesson10.task1;

import Shmidt.abstractAndInterfaces.lesson10.task1.baseElements.Air;
import Shmidt.abstractAndInterfaces.lesson10.task1.baseElements.Fire;
import Shmidt.abstractAndInterfaces.lesson10.task1.baseElements.Ground;
import Shmidt.abstractAndInterfaces.lesson10.task1.baseElements.Water;

public class NatureElement {
    /*содержит метод connect, который в качестве параметра получает другой NatureElement содержит пустое тело*/
    protected NatureElement connect(NatureElement natElem) {
        return null;
    }



    /*
          содержит статический метод create
          в качестве параметра принимает строку - название базового элемента
          по названию создает базовый элемент
          если название неизвестно, то печатается сообщение "Неизвестный элемент" и возвращается null.
     */
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
