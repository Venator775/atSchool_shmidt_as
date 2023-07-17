package main.java.Shmidt.lesson43.task1;

public class Main {
    public static void main(String[] args) {
        for(String s:args)
            System.out.println(s);

        int max=0;
        for (String s: args){
            int tempMax = max;
            max = Integer.valueOf(s);
            if(tempMax>max)
                max=tempMax;
        }
        System.out.println("max=" + max);
    }
}
