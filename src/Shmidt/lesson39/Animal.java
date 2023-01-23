package Shmidt.lesson39;

public class Animal {


    public static void testStaticMethod(){
        System.out.println("Это статическое животное");
    }

    public void testM(int a){
        System.out.println("1");
    }
    public String testM(){
        System.out.println("2");
        return "G";
    }


    public static String skyBody = "Планета Земля";
}
