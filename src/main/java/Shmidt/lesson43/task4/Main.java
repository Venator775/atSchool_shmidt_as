package Shmidt.lesson43.task4;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введены значения сторон:");
        for (String s : args)
            System.out.print(s + " ");

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, mid = 0;

        for (int i = 0; i < 3; i++) {
            int tempMax = max;
            int tempMin = min;
            max = Integer.valueOf(args[i]);
            min = Integer.valueOf(args[i]);
            mid = Integer.valueOf(args[i]);

            if (tempMax > max)
                max = tempMax;

            if (tempMin < min)
                min = tempMin;

            if (i == 2)
                mid = Integer.valueOf(args[0]) + Integer.valueOf(args[1]) + Integer.valueOf(args[2]) - max - min;
        }

        int a = max, b = mid, c = min;

        System.out.println("\nОпределены стороны:");
        System.out.println("max=" + a + "\n" + "mid=" + b + "\n" + "min=" + c);

        double cosA = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c);
        System.out.println("cosA=" + cosA);

        if (Math.abs(cosA) <= 1.0) {
            if (cosA == 0.0)
                System.out.println("right - треугольник прямой");//a=5, b=3, c=4

            if (cosA < 0.0)
                System.out.println("obtuse - треугольник тупоугольный ");//a=9, b=5, c=6

            if (cosA > 0.0)
                System.out.println("acute - треугольник остроугольный");//a=7, b=8, c=6

        } else System.out.println("Треугольник со сторонами " + a + ", " + b + ", " + c + " невозможен");
    }
}

/*
В программу через аргументы командной строки передаются
три натуральных числа – стороны треугольника.

Необходимо определить тип треугольника с данными сторонами
(остроугольный, тупоугольный, прямоугольный)
вывести одно из слов:
- right для прямоугольного треугольника,
- acute для остроугольного треугольника,
- obtuse для тупоугольного треугольника
- или impossible, если входные числа не образуют треугольника.


Стороны сторон передаются через аргументы командной строки.
Проверку на наличие аргументов делать не надо.
 */
