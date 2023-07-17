package main.java.Shmidt.lessonExceptions.task1.baseElements;

import main.java.Shmidt.lessonExceptions.task1.NatureElement;
import main.java.Shmidt.lessonExceptions.task1.resultElements.Dust;
import main.java.Shmidt.lessonExceptions.task1.resultElements.Energy;
import main.java.Shmidt.lessonExceptions.task1.resultElements.Pressure;
import main.java.Shmidt.lessonExceptions.task1.resultElements.Rain;

public class Air extends NatureElement {
    public NatureElement connect(NatureElement natElem) {
        String element = natElem.getClass().getSimpleName();
        switch (element) {
            case ("Water"):
                return new Rain();
            case ("Fire"):
                return new Energy();
            case ("Ground"):
                return new Dust();
            case ("Air"):
                return new Pressure();
            default:
                throw new UnsupportedOperationException("Комбинация не найдена. Неизвестный элемент " + element);
        }
    }
}
