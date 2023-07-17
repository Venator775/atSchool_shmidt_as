package Shmidt.lesson75.task3;

import java.util.ArrayList;
import java.util.List;

import static Shmidt.tests.sideMethods.rnd;

/*
Попробуйте вновь увеличить n до 10_000_000 и переместить строчки, добавленные на шаге 3, в конец тела цикла по l.
По очереди закомментируйте их и посмотрите, будут ли печататься сообщения из finalize.
 */
public class task35 {
    public static void main(String[] args) {


        int l = 1, n = 10, m = 5;

        for (int i = 0; i < l; i++) {
            System.out.println("Итерация: " + i);

            Element[] arr = new Element[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = new Element(j + l);
            }

            List<Integer> notNullElementPositions = getNotNullElementPositions(arr);
            while (notNullElementPositions.size() > m) {
                int delPosition = notNullElementPositions.get(rnd(0, notNullElementPositions.size() - 1));
                arr[delPosition] = null;

                notNullElementPositions = getNotNullElementPositions(arr);

            }
            System.gc();//только с этой строкой освобождаются не все ресурсы
            System.runFinalization();//только с этой строкой "ничего не освобождается".
            /*
            Итерация: 0
Finalize. 2
Finalize. 1
Finalize. 6
Finalize. 8
Finalize. 7
             */
        }
    }

    static List<Integer> getNotNullElementPositions(Element[] arr) {
        List<Integer> notNullPositions = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                notNullPositions.add(i);
            }
        }

        return notNullPositions;
    }
}
