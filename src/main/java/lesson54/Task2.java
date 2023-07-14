package lesson54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
C:\Users\Алексей\IdeaProjects\atSchool_shmidt_as.rar
C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as.rar
C:/Users\Алексей/IdeaProjects\atSchool_shmidt_as.rar
C:\Users\Алексей\IdeaProjects\
C:/
sdfsdf
null
 */
public class Task2 {
    public static void main(String[] args) {
        /*
        if (args[0].equals("\\") || args[0].equals("/")) {
            System.out.println("Введен некорректный путь до файла.");
            return;
        }

        //это тут нужно для обработки пробела в пути
        String str = "";
        if (args.length > 1) {
            StringBuilder finalStr = new StringBuilder(str);
//            List.of(args).forEach((arg) -> {
//                finalStr.append(arg + " ");
//            });
//            str=finalStr.toString();

            Arrays.stream(args)
                    .collect(Collectors.toList())
                    .forEach((arg) -> {
                finalStr.append(arg).append(" ");
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
        System.out.println("file=" + file);*/
        System.out.println(getPathAndName(args));
    }

    public static List<String> getPathAndName(String[] args) {
        List<String> pathFile = new ArrayList<>();
        String path = "undefined", file = "undefined";

        //это тут нужно для обработки пробела в пути
        String str = "";
        if (args.length > 1) {
            StringBuilder finalStr = new StringBuilder(str);
//            List.of(args).forEach((arg) -> {
//                finalStr.append(arg + " ");
//            });
//            str=finalStr.toString();
//java 8 -->
            Arrays.stream(args)
                    .collect(Collectors.toList())
                    .forEach((arg) -> {
                        finalStr.append(arg).append(" ");
                    });
            str = finalStr.toString();
        } else str = args[0];


        if (str.contains("\\")) {
            path = str.substring(0, str.lastIndexOf("\\") + 1);
            file = str.substring(str.lastIndexOf("\\") + 1);
        } else if (str.contains("/")) {
            path = str.substring(0, str.lastIndexOf("/") + 1);
            file = str.substring(str.lastIndexOf("/") + 1);
        }

        if (file.equals("") || file.equals(" "))
            file = "Файл не указан";
        System.out.println("str = |" + str + "|");
        System.out.println("path = |" + path + "|");
        System.out.println("file = |" + file + "|");
        pathFile.add(path);
        pathFile.add(file);
        return pathFile;
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