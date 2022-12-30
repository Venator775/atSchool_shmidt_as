package Shmidt.lesson16_enum;

public class Main {
    public static void main(String[] args) {
        Week week12 = new Week(36);

        week12.getInfo();
    }
}
/*
Создать класс DaysOfWeek cо статическими финальными полями - днями недель (Значения: "Понедельник", "Вторник" и тд)
Создать класс Day c полем String dayOfWeek и поле с номером относительно начала месяца (не статические).
Создать класс Week содержащий 7 полей Day и поле номера недели относительно начала года (не статическое).


В методе main создать 3 разные недели и вывести всю информацию о них (для ориентира за год считать 2022)
    Формат вывода:
Неделя {номер недели}:
День - Число
День - Число
...

P.S День должен отображать число месяца и название дня недели ,
Неделя должна отображать номер недели относительно начала года и как положено - 7 дней,
при создании объектов недели и выводе на экран ориентироваться на календарь 2022 года.
Например : 2 неделя 2022 года - Понедельник 3 число , Вторник 4 число и тд.

Необходимо повторить задание №1, но DaysOfWeek  теперь необходимо описать не как класс, а как enum с днями недель
(Значения: "Понедельник", "Вторник" и тд.) и в классе Day тип поля dayOfWeek должен быть DaysOfWeek
 */
