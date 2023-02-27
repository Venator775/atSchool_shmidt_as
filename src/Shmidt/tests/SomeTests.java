package Shmidt.tests;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Shmidt.tests.sideMethods.printLog;

public class SomeTests {
    private String name;

    String name() {
        return name;
    }

    public static void main(String[] args) {

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM-hh:mm:ss");
//        String text = dtf.format(LocalDateTime.now());
//        System.out.println("formatted=" + text);

        printLog("boobs");


/*        //53 вопрос 2
        String s = "Hello";
        String t = new String(s);
        if ("Hello".equals(s))
            System.out.println("1");
        if (t == s)
            System.out.println("2");
        if (t.intern() == s)
            System.out.println("3");
        if ("Hello" == s)
            System.out.println("4");


        if ("Hello".intern() == t)//todo почему false?
            System.out.println("5");*/
    }
}


