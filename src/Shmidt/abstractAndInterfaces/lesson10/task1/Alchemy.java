package Shmidt.abstractAndInterfaces.lesson10.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alchemy {
    public static void main(String[] args) {
        if (args.length > 0) {
            List<NatureElement> elements = new ArrayList<>();
            List<NatureElement> uniqElements = new ArrayList<>();

            System.out.println("Набор изначальных элементов:");
            Arrays.stream(args).forEach(elem -> elements.add(NatureElement.create(elem)));

            System.out.println("Получившиеся элементы:");
            for (int i = 0; i < elements.size(); i += 2) {
                NatureElement result = elements.get(i).connect(elements.get(i + 1));
                System.out.println(getElemName(elements.get(i)) + " + " + getElemName(elements.get(i + 1)) + " = " + getElemName(result));
//                System.out.println(elements.get(i).getClass().getSimpleName() + " + " + elements.get(i+1).getClass().getSimpleName() + " = " + result.getClass().getSimpleName());
                uniqElements.add(result);
            }

        } else System.out.println("Ввод пуст.");
    }

    private static String getElemName(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
