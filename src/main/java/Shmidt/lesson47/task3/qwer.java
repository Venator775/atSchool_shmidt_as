package main.java.Shmidt.lesson47.task3;

public class qwer {
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        int col = Integer.valueOf(args[1]);
        int[] allNumber = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            allNumber[i] = i + 1;
        }

        boolean direction = true;
        int count = 0;
        String result = "";

        for (int i = 0; i < allNumber.length; i++) {

            if (direction) {
                result = result + allNumber[i] + " ";
            } else {
                result = allNumber[i] + " " + result;
            }

            count++;

            if (count == col) {
                System.out.print(result);
                direction = direction ? false : true;
                System.out.println();
                result = "";
                count = 0;
            }
        }
    }
}