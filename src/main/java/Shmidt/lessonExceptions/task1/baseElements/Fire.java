package Shmidt.lessonExceptions.task1.baseElements;

import Shmidt.lessonExceptions.task1.NatureElement;
import Shmidt.lessonExceptions.task1.resultElements.Energy;
import Shmidt.lessonExceptions.task1.resultElements.Lava;
import Shmidt.lessonExceptions.task1.resultElements.Steam;

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
