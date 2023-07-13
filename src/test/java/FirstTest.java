import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static lesson54.Task1.method;

public class FirstTest {

    @Test
    void les54Test() {
        System.out.println("Запуск les54Test");
        String[] shit = new String[]{"а"};
        Assertions.assertEquals(7, method(shit));
    }


}