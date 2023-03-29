package Shmidt.lesson75.task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class task1 {
    public static void main(String[] args) {
        if (Arrays.stream(args).findAny().isEmpty()) {
            System.out.println("Ввод пустой");
            System.exit(0);
        }

        Set<String> output = new HashSet<>(Arrays.asList(args));//забавный момент, что слова втыкаются в сет не по порядку

        System.out.println("Ввод:");
        for (String word: args)
            System.out.print(word + " ");
        System.out.println("\nВывод:");
        for (String word: output)
            System.out.print(word + " ");

    }
}
