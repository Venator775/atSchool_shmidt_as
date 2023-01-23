package Shmidt.sketches;

public class SomeTests {

    static String x;
    {
        x = "1";
    }
    static {
        x += 2;
    }
    static void m() {
        x += 3;
    }

    public static void main(String[] args) {
        x += 4;
        SomeTests t = new SomeTests();
        t.m();
        System.out.println(x);
    }
}

