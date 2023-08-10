package Shmidt.lesson5_6_Exceptions.task1;

import Shmidt.lesson5_6_Exceptions.task1.resultElements.ShitElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static Shmidt.tests.ConsoleColors.RED;
import static Shmidt.tests.ConsoleColors.RESET;

//Air Air Fire Ground Water Air Fire Fire
public class Alchemy {
    public static void main(String[] args) {
        if (args.length > 0) {
            List<NatureElement> elements = new ArrayList<>();

            System.out.println("Набор изначальных элементов:");

            try {
                Arrays.stream(args).forEach(elem -> elements.add(NatureElement.create(elem)));
            } catch (NoSuchElementException exception) {
                System.out.println(RED + exception.getMessage() + RESET);
                //System.exit(0);
            }

            elements.add(new ShitElement());
            elements.add(new ShitElement());

            System.out.println("\nПолучившиеся элементы:");

            for (int i = 0; i < elements.size() - 1; i++) {
                try {
                    String result = elements.get(i).connect(elements.get(i + 1)).getClass().getSimpleName();
                    String elem1 = elements.get(i).getClass().getSimpleName();
                    String elem2 = elements.get(i + 1).getClass().getSimpleName();
                    System.out.println(elem1 + " + " + elem2 + " -> " + result);
                } catch (UnsupportedOperationException exception) {
                    System.out.println(RED + exception.getMessage() + RESET);
                }
            }

        } else System.out.println("Ввод пуст.");
    }
}
