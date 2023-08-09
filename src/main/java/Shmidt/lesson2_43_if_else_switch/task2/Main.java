package Shmidt.lesson2_43_if_else_switch.task2;

public class Main {
    public static void main(String[] args) {

        int dayNum = Integer.parseInt(args[0]);

        switch (dayNum) {
            case (1):
                System.out.println("Понедельник");
                break;
            case (2):
                System.out.println("Вторник");
                break;
            case (3):
                System.out.println("Среда");
                break;
            case (4):
                System.out.println("Четверг");
                break;
            case (5):
                System.out.println("Пятница");
                break;
            case (6):
                System.out.println("Суббота");
                break;
            case (7):
                System.out.println("Воскресенье");
                break;
            default:
                System.out.println("Число вне диапазона");
                break;
        }
    }
}
