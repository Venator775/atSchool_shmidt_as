import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lesson54.Task1.getFirstInputOfsymbol;
import static lesson54.Task2.getPathAndName;

public class lesson54Test_2 {

    @DisplayName("Задание 2.54. Упражнение 2")
    @Test
    void les54_2Test() {
        String[] pathProvider = pathProvider();
        for (int i = 0; i < pathProvider.length; i++) {
            String path = pathProvider[i];
            System.out.println("Проверка пути: |" + path + "|");
            Assertions.assertEquals(regexPathChecker(path),getPathAndName(new String[]{path}));
            System.out.println();
        }
    }

    private String[] pathProvider() {
        return new String[]{
                "C:\\Users\\Алексей\\Idea Projects\\atSchool_shmidt_as.rar",
                "C:/Users/Алексей/Idea Projects/atSchool_shmidt_as.rar",
                "C:/Users/Алексей/Idea Projects/",
                "C:\\",
                "dfgkghj"
        };
    }

    private List<String> regexPathChecker(String Path) {
        List<String> result = new ArrayList<>();
        String pathResult = "undefined";
        String fileResult = "undefined";

        if(Path == null){
            result.add(pathResult);
            result.add(fileResult);
            return result;
        }

        String regexFullPath = "([A-Za-z]:[\\\\\\/](?:.*[\\\\\\/])?)([\\w\\s]+\\.\\w+)";
        Pattern patternFull = Pattern.compile(regexFullPath);
        Matcher matcherFull = patternFull.matcher(Path);

        String regexOnlyPath = "([A-Za-z]:[\\\\\\/](?:.*[\\\\\\/])?)";
        Pattern patternOnlyPath = Pattern.compile(regexOnlyPath);
        Matcher matcherOnlyPath = patternOnlyPath.matcher(Path);

        if (matcherFull.find()) {
            pathResult = matcherFull.group(1);
            System.out.println("Ожидаемый путь: " + pathResult);
            fileResult = matcherFull.group(2);
            System.out.println("Ожидаемый файл: " + fileResult);
        } else if (matcherOnlyPath.find()) {
            pathResult = matcherOnlyPath.group(1);
            fileResult = "Файл не указан";
            System.out.println("Ожидаемый путь: " + pathResult);
        }

        result.add(pathResult);
        result.add(fileResult);
        return result;
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