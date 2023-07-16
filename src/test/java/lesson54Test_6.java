import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lesson54.Task6.isInteger;
import static lesson54.Task6.toInt;

public class lesson54Test_6 {
    @DisplayName("Задание 2.54. Упражнение 6. isInteger")
    @Test
    void les54_6IsIntTest() {
        boolean isNumeric;
        for (String s : numberProvider()) {
            try {
                int checkInput = Integer.parseInt(s);
                isNumeric = true;
            } catch (NumberFormatException nfe) {
                isNumeric = false;
            }
            Assertions.assertEquals(isNumeric, isInteger(s));
            System.out.println("Строка: " + s + "\tЯвляется ли строка целым числом по методу isInteger(): " + isInteger(s));
        }
    }

    @DisplayName("Задание 2.54. Упражнение 6. toInt")
    @Test
    void les54_6ToIntTest() {
        for (String s : numberProvider()) {
            int number=0;
            if (isInteger(s))
                number = Integer.parseInt(s);
            System.out.println("Проверка строки " + s);
            int toIntValue = toInt(s);
            Assertions.assertEquals(number,toIntValue);
        }
    }

    private String[] numberProvider() {
        return new String[]{
                "156",
                "-9",
                "0",
                "fjhg",
                "1.0",
                "9,5",
                "0015"
        };
    }

}
