package Shmidt.lesson2_47_usingCycles.task5;

public class Calculator {
    public static int add(int x, int y){
        return x+y;
    }

    public static int sub(int x, int y){
        return x-y;
    }

    public static int mult(int x, int y){
        return x*y;
    }

    public static int divide(int x, int y){
        if(y!=0)
            return x/y;
        else{
            System.out.println("Операция не может быть выполнена");
            System.exit(0);
        }
        return -1;
    }
}
/*
Реализуйте класс Calculator со статическими методами:
- int add(int x, int y) - выполнение x + y
- int sub(int x, int y) - выполнение x - y
- int mult(int x, int y) - выполнение x * y
- int divide(int x, int y) - выполнение x / y.
  Имеет проверку y == 0 или нет.
  Если равно, то пишется сообщение, что операция не может быть выполнена,
  и программа завершается, используя System.exit(0);
 */