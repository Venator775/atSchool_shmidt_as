package lesson54;

import java.math.BigDecimal;

public class Task6 {
    public static void main(String[] args) {

        String argValue = args[0];

        System.out.println("Строка: " + argValue);

        System.out.println(toInt(argValue));
//        if (isInteger(argValue)) {
//            System.out.println("Строка '" + argValue + "' является целым числом");
//            System.out.println("2 * " + toInt(argValue) + " = " + toInt(argValue) * 2);
//        } else System.out.println("Строка не является целым числом");

    }

    static public boolean isInteger(String str) {
        if(str.contains(".")||str.contains(","))
            return false;
        int i = 0;
        if (str.charAt(i) == '-')
            i = 1;
        for (; i < str.length(); i++)
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        return true;
    }

    static public int toInt(String str) {
        StringBuilder sb = new StringBuilder(str);
        int grade;//разряд числа
        int minusModifier = 1;//отрицательное или положительное число

        int i = 0;

        if (sb.charAt(0) == '-') {//проверка на отрицательность
            i = 1;
            sb.replace(0, 1, "");
            minusModifier = -1;
        }

        boolean firstZerosEnded = false;

        if (sb.length() > 1)//на случай, если введён только один 0
            for (; i < sb.length(); i++)//удаление лидирующих нулей
                if (Character.isDigit(sb.charAt(i))) {
                    if (sb.charAt(i) == '0' && !firstZerosEnded) {
                        sb.replace(i, i + 1, "");
                        i--;
                    } else {
                        firstZerosEnded = true;
                    }
                } else {
//                    System.out.println("сообщение об ошибке");
//                    System.exit(-1);
                    System.out.println("Строка |"+str+"| не является целым числом");
                    return 0;
                }

        BigDecimal resultBig = new BigDecimal(0);
        grade = sb.length();
        i = grade;
        for (; i > 0; i--) {
            double k = Math.pow(10, grade - i) * (sb.charAt(i - 1) - '0');
            resultBig = resultBig.add(BigDecimal.valueOf(k));
        }
        resultBig = resultBig.multiply(BigDecimal.valueOf(minusModifier));

//        if (resultBig.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) == -1 || resultBig.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) == 1) {
//            System.out.println("Число не входит в диапазон int " + Integer.MIN_VALUE + "..." + Integer.MAX_VALUE);
//            System.exit(-1);
//        }
        if (resultBig.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) == -1) {
            System.out.println("Число меньше допустимого минимума диапазона int " + Integer.MIN_VALUE);
            return Integer.MIN_VALUE;
        }
        if (resultBig.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) == 1) {
            System.out.println("Число больше допустимого максимума диапазона int " + Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        return resultBig.intValue();
    }

}
/*
Реализуйте метод static int toInt(String str), который принимает в качестве аргумента строковое представление целого числа и возвращает его целочисленное значение.
Т.е. результатом вызова toInt("-14") будет целое число -14. Или toInt("0012") вернет 12.
Использовать Integer.parseInt, Integer.valueOf и подобные "готовые" методы нельзя.

Напишите программу, которая получает строку через аргумент командной строки, проверяет можно ли преобразовать строку в целое число.
Если переданная строка не может быть преобразована в целое число или получаемое число не cможет поместиться в диапазон int, то выводится сообщение об ошибке и программа завершается.
Если может, то преобразуйте строку в целое число, используя метод toInt, и выведите результат умножения этого числа на 2.
Проверку на наличие аргумента командной строки делать не надо.
 */