package Shmidt.lesson43.task3;

public class Main {
    public static void main(String[] args) {

        int year = Integer.parseInt(args[0]);
        if (year > 0 && year <= 30000)
            if (year % 4 == 0 && year % 100 != 0
                    || year % 400 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
    }
}
/*
год является високосным, если его номер кратен 4, но не кратен 100, а также если он кратен 400.
Требуется вывести слово YES, если год является високосным и NO - в противном случае.
 */