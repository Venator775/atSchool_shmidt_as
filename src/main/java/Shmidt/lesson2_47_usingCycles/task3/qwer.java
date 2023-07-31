package Shmidt.lesson2_47_usingCycles.task3;

public class qwer {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        int[] allNumber = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            allNumber[i] = i + 1;
        }

        boolean direction = true;
        int count = 0;
        StringBuilder result = new StringBuilder();

        for (int j : allNumber) {

            if (direction) {
                result.append(j).append(" ");
            } else {
                result.insert(0, j + " ");
            }

            count++;

            if (count == col) {
                System.out.print(result);
                direction = direction ? false : true;
                System.out.println();
                result = new StringBuilder();
                count = 0;
            }
        }
    }
}