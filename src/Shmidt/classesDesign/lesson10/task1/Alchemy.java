package classesDesign.lesson10.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alchemy {
    public static void main(String[] args) {
        if (args.length > 0) {
            List<NatureElement> elements = new ArrayList<>();

            System.out.println("Набор изначальных элементов:");
            Arrays.stream(args).forEach(elem -> elements.add(NatureElement.create(elem)));

            System.out.println("\nПолучившиеся элементы:");
            for (int i = 0; i < elements.size(); i += 2) {
                String result = elements.get(i).connect(elements.get(i + 1)).getClass().getSimpleName();
                String elem1 = elements.get(i).getClass().getSimpleName();
                String elem2 = elements.get(i+1).getClass().getSimpleName();
                System.out.println(elem1 + " + " + elem2 + " -> " + result);
            }

        } else System.out.println("Ввод пуст.");
    }
}
