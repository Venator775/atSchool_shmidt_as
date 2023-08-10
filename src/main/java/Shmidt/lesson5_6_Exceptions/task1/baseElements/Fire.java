package Shmidt.lesson5_6_Exceptions.task1.baseElements;

import Shmidt.lesson5_6_Exceptions.task1.NatureElement;
import Shmidt.lesson5_6_Exceptions.task1.resultElements.Energy;
import Shmidt.lesson5_6_Exceptions.task1.resultElements.Lava;
import Shmidt.lesson5_6_Exceptions.task1.resultElements.Steam;

public class Fire extends NatureElement {
    public NatureElement connect(NatureElement natElem) {
        String element = natElem.getClass().getSimpleName();
        switch (element) {
            case ("Water"):
                return new Steam();
            case ("Fire"):
                return new Fire();
            case ("Ground"):
                return new Lava();
            case ("Air"):
                return new Energy();
            default:
                throw new UnsupportedOperationException("Комбинация не найдена. Неизвестный элемент " + element);
        }
    }

}
