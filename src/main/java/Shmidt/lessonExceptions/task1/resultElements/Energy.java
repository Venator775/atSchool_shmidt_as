package Shmidt.lessonExceptions.task1.resultElements;

import Shmidt.lessonExceptions.task1.NatureElement;

public class Energy extends NatureElement {
    public NatureElement connect(NatureElement natElem) {
        String element = natElem.getClass().getSimpleName();
        switch (element) {
            case ("Water"):
                return new Steam();
            default:
                throw new UnsupportedOperationException("Комбинация не найдена. Неизвестный элемент " + element);
        }
    }
}
