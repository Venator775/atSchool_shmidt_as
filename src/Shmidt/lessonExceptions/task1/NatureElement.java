package lessonExceptions.task1;

import lessonExceptions.task1.baseElements.*;

import java.util.NoSuchElementException;

public class NatureElement {

    protected NatureElement connect(NatureElement natElem) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Не известный элемент " + natElem.getClass().getSimpleName());
    }

    static public NatureElement create(String elemName) throws NoSuchElementException {
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
                throw new NoSuchElementException("Элемент " + elemName + " не найден");
        }
    }

}
