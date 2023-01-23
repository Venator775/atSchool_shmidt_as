package Shmidt;

public class SomeTests {

    SomeTests(String s) {
        this(1);
        System.out.print("1");
    }

    SomeTests(long i) {
        this("2", 2);
        System.out.print("2");
    }

    SomeTests(float i) {
        this("3", 3);
        System.out.print("3");
    }

    SomeTests(Integer i) {
        this("4");
        System.out.print("4");
    }

    SomeTests(String s, Integer i) {
        System.out.print(5);
    }

    SomeTests(Integer i, String s) {
        this(i);
        System.out.print(6);
    }

    public static void main(String[] args) {
        SomeTests t = new SomeTests(7, "7");
        System.out.print(7);
    }
}
