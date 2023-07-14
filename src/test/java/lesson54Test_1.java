import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lesson54.Task1.getFirstInputOfsymbol;
import static lesson54.Task2.getPathAndName;

public class lesson54Test_1 {

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
        return symbolMap;
    }

    private String stringProvider() {
        return "Циклом называется многократное выполнение одних и тех же действий.";
    }

}
/*
([A-Za-z]:[\\\/])((?:.*[\\\/])?)([\w\s]+\.\w+)
C:\Users\Алексей\IdeaProjects\atSchool_shmidt_as.rar
C:/Users/Алексей/IdeaProjects/atSchool_shmidt_as.rar
C:/Users\Алексей/IdeaProjects\atSchool_shmidt_as.rar
C:/
C:/Users
sdfsdf
*/