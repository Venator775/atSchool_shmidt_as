package Shmidt.tests;

public class SomeTests {
    public static void main(String[] args) {
        Temp a = new Temp(10);
        Temp b = new Temp(10);
        Temp c = null;
        Temp d = new Temp(42);

        boolean result = a.equals(b);
        result = result ^ a.equals(c);
        result = result ^ a.equals(d);

        System.out.println(result);

    }
}
class Temp {
    private int value;

    Temp(int v) {
        value = v;
    }

    @Override
    public boolean equals(Object obj) {
        Temp temp = (Temp) obj;
        return this.value == temp.value;
    }
}


