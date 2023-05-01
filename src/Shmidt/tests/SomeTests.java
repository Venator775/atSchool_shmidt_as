package Shmidt.tests;


import java.util.Scanner;

public class SomeTests {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("input number:");
        int num = in.nextInt();

        System.out.printf("input = %d \n", num);
        in.close();
    }

    public static void printExamples(){
        int a = 1;
        double ad = 1d;
        int b = 2;
        float c = 3;
        char d = '4';
        double e = 5;
        System.out.printf("%s, %s \n", a, ad);
        System.out.printf("%d \n", b);
        System.out.printf("%.4f \n", c);
        System.out.printf("%c \n", d);
        System.out.printf("%e \n", e);
        System.out.printf("%s \n %s %n %s %n", e, ad, c);
        System.out.printf("'%-15s' %n", "asdffg");
    }
}
