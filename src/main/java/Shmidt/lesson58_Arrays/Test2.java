package Shmidt.lesson58_Arrays;

public class Test2 {
    public static void main(String[] args) {

        int max = 0;

        if (args.length != 0) {
            StringBuilder wordInArgs;
            System.out.print("Ввод: ");
            for (int i = 0; i < args.length; i++) {//по каждому слову

                int tempMax = max;
                max = args[i].length();
                if (tempMax > max)//вычисляем максимальную длину
                    max = tempMax;


                wordInArgs = new StringBuilder(args[i]);
                char[] c = new char[wordInArgs.length()];
                wordInArgs.getChars(0, wordInArgs.length(), c, 0);//получаем буквы слова

                for (int j = 0; j < c.length; j++) {//проверка на символы в слове
                    if (!Character.isLetter(c[j]) && !Character.isDigit(c[j])) {
                        System.out.println("Неподходящий символ в слове ");
                        System.exit(-1);
                    }
                }
                System.out.print(wordInArgs + " ");
            }

        } else {
            System.out.println("ввод пустой");
            System.exit(-1);
        }

        System.out.print("\nСлова с максимальной длиной: ");
        for (String s : args) {
            if (s.length() == max)
                System.out.print(s + " ");
        }
    }
}
/*
Через аргументы командной строки передаются "слова" - последовательность строчных латинских букв и цифр. Каждый аргумент - отдельное "слово".
Напишите программу, которая выводит слова наибольшей длины.

Сделайте проверку на наличие аргументов командной строки.
Если аргументы не переданы, то выведите соответствующее сообщение и завершите программу.
Сделайте проверку, что "слова" состоят только из строчных латинских букв и цифр.
Иначе выведите сообщение об ошибке и завершите программу.

Например:
Ввод: 123 abcd b33f 0s 12
Вывод: abcd b33f

 */