package Shmidt.tests;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class sideMethods {

    /**
     * Возвращает рандомное число от min до max включая оба числа
     *
     * @param min
     * @param max
     * @return
     */
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    /**
     * Заполняет массив длинной n рандомными числами от -9 до 9
     *
     * @param n
     * @return
     */
    static public int[] fillArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd(-9, 9);
        }
        return a;
    }

    /**
     * Заполняет массив длинной n рандомными числами от min до max
     *
     * @param n
     * @return
     */
    static public int[] fillArray(int n, int min, int max) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd(min, max);
        }
        return a;
    }

    /**
     * Пузырьковая сортировка массива a
     *
     * @param a
     * @return
     */
    static int[] bubbleSort(int[] a) {
        int counter = 0;
        boolean sorted = false;
        while (!sorted) {
            counter++;
            sorted = true;
            for (int i = 0; i < a.length; i++) {
                if ((i + 1) != a.length) {
                    if (a[i] > a[i + 1]) {
                        a[i] += a[i + 1];
                        a[i + 1] = a[i] - a[i + 1];
                        a[i] -= a[i + 1];
                        sorted = false;
                    }
                }
            }
        }
        return a;
    }

    /**
     * Находит медиану массива a
     *
     * @param a
     * @return
     */
    static double median(int[] a) {
        double median;

        if (a.length % 2 == 0)
            median = (double) (a[a.length / 2] + a[a.length / 2 + 1]) / 2;
        else
            median = a[a.length / 2];
        return median;
    }

    /**
     * Находит максимальное значение массива ar
     *
     * @param ar
     * @return
     */
    public static int getMax(int[] ar) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            int tempMax = max;
            max = ar[i];
            if (tempMax > max)
                max = tempMax;
        }
        return max;
    }

    /**
     * Находит минимальное значение массива ar
     *
     * @param ar
     * @return
     */
    public static int getMin(int[] ar) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ar.length; i++) {
            int tempMax = min;
            min = ar[i];
            if (tempMax < min)
                min = tempMax;
        }
        return min;
    }

    /**
     * Определяет явзяется ли значение в строке числом
     *
     * @param str
     * @return
     */
    static public boolean isInteger(String str) {
        int i = 0;
        if (str.charAt(i) == '-')
            i = 1;
        for (; i < str.length(); i++)
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        return true;
    }

    /**
     * Приводит значение строки в число
     *
     * @param str
     * @return
     */
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

        grade = sb.length();

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
                    System.out.println("сообщение об ошибке");
                    System.exit(-1);
                }

        BigDecimal resultBig = new BigDecimal(0);
        i = grade;
        for (; i > 0; i--) {
            var k = Math.pow(10, grade - i) * (sb.charAt(i - 1) - '0');
            resultBig = resultBig.add(BigDecimal.valueOf(k));
        }
        resultBig = resultBig.multiply(BigDecimal.valueOf(minusModifier));

        if (resultBig.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) == -1 || resultBig.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) == 1) {
            System.out.println("Число не входит в диапазон int " + Integer.MIN_VALUE + "..." + Integer.MAX_VALUE);
            System.exit(-1);
        }

        return resultBig.intValue();
    }

    /**
     * Преобразует массив строк в массив интов
     *
     * @param arrStr массив строковых чисел
     * @return arrInt массив интов
     */
    static public int[] arrString2Int(String[] arrStr) {
        int[] arrInt = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            if (isInteger(arrStr[i]))
                arrInt[i] = toInt(arrStr[i]);
        }
        return arrInt;
    }

    static public Integer[] arrString2Integer(String[] arrStr) {
        Integer[] arrInteger = new Integer[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            if (isInteger(arrStr[i]))
                arrInteger[i] = Integer.valueOf(toInt(arrStr[i]));
        }
        return arrInteger;
    }

    public static void printLog(String text) {
        try {
            String logFileName = " ";
            String path = new java.io.File(".").getCanonicalPath() + "\\src\\Shmidt\\tests\\logs\\";
            logFileName = path + "pokeLog" + "[" + DateTimeFormatter.ofPattern("dd.MM hh_mm_ss").format(LocalDateTime.now()) + "]" + ".txt";
            System.out.println(logFileName);
            try (FileWriter writer = new FileWriter(logFileName, true)) {
                writer.write(text + "\n");
                writer.flush();
            }
        } catch (Exception exception) {
            System.out.println("Ошибка вывода в файл:\n" + exception.getMessage());
        }
    }

}
