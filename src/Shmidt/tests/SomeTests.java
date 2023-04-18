package Shmidt.tests;


public class SomeTests {
    public static void main(String[] args) {
        Beetle b = new Beetle();
        System.out.println(b.getNumberOfSections(5));
    }
}


interface HasExoskeleton {
    double size = 2.0f;

    int getNumberOfSections();
}

abstract class Insect implements HasExoskeleton {
    int getNumberOfSections(int count) {
        return count;
    }
}

class Beetle extends Insect {
    public int getNumberOfSections() {
        return 0;
    }
}
