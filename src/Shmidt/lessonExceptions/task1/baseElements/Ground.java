package Shmidt.lessonExceptions.task1.baseElements;

import Shmidt.lessonExceptions.task1.NatureElement;
import Shmidt.lessonExceptions.task1.resultElements.Dust;
import Shmidt.lessonExceptions.task1.resultElements.Lava;
import Shmidt.lessonExceptions.task1.resultElements.Mud;
import Shmidt.lessonExceptions.task1.resultElements.Pressure;

public class Ground extends NatureElement {


    public NatureElement connect(NatureElement natElem) {
        String element = natElem.getClass().getSimpleName();
        switch (element) {
            case ("Water"):
                return new Mud();
            case ("Fire"):
                return new Lava();
            case ("Ground"):
                return new Pressure();
            case ("Air"):
                return new Dust();
            default:
                throw new UnsupportedOperationException("Комбинация не найдена. Неизвестный элемент " + element);
        }
    }
}
