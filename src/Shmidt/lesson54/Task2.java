package Shmidt.lesson54;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        if (args[0].equals("\\") || args[0].equals("/")) {
            System.out.println("Введен некорректный путь до файла.");
            return;
        }
        //fixme На самом деле у файла бы указать расширение, но видимо смысл задачи в другом. А так просто чуть глаз режет)

        //это тут нужно для обработки пробела в пути
        String str = "";
        if (args.length > 1) {
            StringBuilder finalStr = new StringBuilder(str);
            List.of(args).forEach((arg) -> {
                finalStr.append(arg + " ");
            });
            str=finalStr.toString();
        }
        else str = args[0];

        String path = "empty", file = "empty";
        if (str.contains("\\")) {
            path = str.substring(0, str.lastIndexOf("\\")+1);
            file = str.substring(str.lastIndexOf("\\") + 1);
        } else if (str.contains("/")) {
            path = str.substring(0, str.lastIndexOf("/")+1);
            file = str.substring(str.lastIndexOf("/") + 1);
        }

        if(file.equals("")||file.equals(" "))
            file = "Введен некорректный путь до файла.";

        System.out.println("path=" + path);
        System.out.println("file=" + file);
    }
}
/*
Через аругмент командной строки передается строка - путь до некоторого файла -
содержащая знак «/» или «\». Например, "/bin/java" или "C:\Program Files\Java\bin\java".

Напишите программу, которая для обоих вариантов разделителей, может вывести отдельно путь и имя файла.
Если имя файла отсутствует, т.е. строка оканчивается на "\" или "/",
то выдать ошибку: "Введен некорректный путь до файла."

Пример:
1) Через аргументы передается "/bin/java", выводится:
Путь: /bin/
Имя файла: java

2) Через аргументы передается "C:\Program Files\Java\bin\java", выводится:
Путь: C:\Program Files\Java\bin\
Имя файла: java

3) Через аргументы передается "/", выводится:
Введен некорректный путь до файла.
Проверку на наличие и корректность аргумента делать не надо.
 */