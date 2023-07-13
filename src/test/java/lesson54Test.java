import lesson54.Task2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lesson54.Task1.getFirstInputOfsymbol;
import static lesson54.Task2.getPathAndName;

public class lesson54Test {

    @DisplayName("Задание 2.54. Упражнение 1")
    @Test
    void les54_1Test() {
        for (Map.Entry<Integer, String> item : symbolMapProvider().entrySet()) {
            System.out.println("Проверка комбинации:" + item.getKey() + " - " + item.getValue());
            Assertions.assertEquals(item.getKey(), getFirstInputOfsymbol(new String[]{item.getValue()}, stringProvider()), "Не верное значение позиции буквы");
        }
    }

    private HashMap<Integer, String> symbolMapProvider() {
        HashMap<Integer, String> symbolMap = new HashMap<>();
        symbolMap.put(0, "Ц");
        symbolMap.put(2, "к");
        symbolMap.put(8, "з");
        symbolMap.put(13, "т");
        symbolMap.put(57, ".");
        symbolMap.put(-1, "ю");
//        symbolMap.put(3, "э");
        return symbolMap;
    }

    private String stringProvider() {
        return "Циклом называется многократное выполнение одних и тех же действий.";
    }

    @DisplayName("Задание 2.54. Упражнение 2")
    @Test
    void les54_2Test() {
        String[] pathProvider = pathProvider();
        for (int i = 0; i < pathProvider.length; i++) {
            String path = pathProvider[i];
            System.out.println("Проверка пути: " + path);
            Assertions.assertEquals(resultPathProvider().get(i), getPathAndName(new String[]{path}).get(0));
            System.out.println();
        }
    }

    private String[] pathProvider() {
        return new String[]{
                "C:\\Users\\Алексей\\IdeaProjects\\atSchool_shmidt_as.rar",
                "C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as.rar",
                "C:/Users/Алексей/IdeaProjects/",
                //"C:\\Users/Алексей\\IdeaProjects/atSchool_shmidt_as.rar",
                "/Users/Алексей/IdeaProjects/",
                "\\",
                "/",
//                "dfg",
//                null
        };
    }

    private List<List<String>> resultPathProvider() {
        List<List<String>> pathFile = new ArrayList<>();

        pathFile.add(new ArrayList<>(Arrays.asList("C:\\Users\\Алексей\\IdeaProjects\\", "atSchool_shmidt_as.rar")));
        pathFile.add(new ArrayList<>(Arrays.asList("C:/Users/Алексей/IdeaProjects/", "atSchool_shmidt_as.rar")));
        pathFile.add(new ArrayList<>(Arrays.asList("C:/Users/Алексей/IdeaProjects/", "Введен некорректный путь до файла.")));
        //pathFile.add(new ArrayList<>(Arrays.asList("C:\\Users/Алексей\\IdeaProjects/", "atSchool_shmidt_as.rar")));
        pathFile.add(new ArrayList<>(Arrays.asList("/Users/Алексей/IdeaProjects/", "Введен некорректный путь до файла.")));
        pathFile.add(new ArrayList<>(Arrays.asList("Введен некорректный путь.","Введен некорректный путь до файла.")));
        pathFile.add(new ArrayList<>(Arrays.asList("Введен некорректный путь.","Введен некорректный путь до файла.")));
//        pathFile.add(new ArrayList<>(Arrays.asList("dfg")));
//        pathFile.add(new ArrayList<>(Arrays.asList(null)));

        return pathFile;
    }

}