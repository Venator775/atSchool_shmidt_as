package lessonExceptions.task1.baseElements;

import lessonExceptions.task1.NatureElement;
import lessonExceptions.task1.resultElements.*;

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
