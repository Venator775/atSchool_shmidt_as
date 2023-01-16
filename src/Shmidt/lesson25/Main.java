package Shmidt.lesson25;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1.");
        long startProgram = new Date().getTime();
        Date birthdayDate = new Date(1995, 0, 25);
        LocalDate birthdayLocalDate = LocalDate.of(1995, 01, 25);
        LocalDateTime birthdayLocalDateTime = LocalDateTime.of(1995, 01, 25, 10, 10, 10);
        ZonedDateTime birthdayZonedDateTime = ZonedDateTime.of(birthdayLocalDateTime, ZoneId.of("Asia/Krasnoyarsk"));
        Calendar birthdayGregorianCalendar = new GregorianCalendar(1995, 0, 25);

//        List.of(birthdayDate,
//                        birthdayLocalDate,
//                        birthdayLocalDateTime,
//                        birthdayZonedDateTime,
//                        birthdayGregorianCalendar,
//                        DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.of(1995, 1, 25)))
//                .stream().forEach((printDate) -> {
//                    printDate(printDate);
//                });

        var birthdayDates = List.of(birthdayDate,
                birthdayLocalDate,
                birthdayLocalDateTime,
                birthdayZonedDateTime,
                birthdayGregorianCalendar,
                DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.of(1995, 1, 25))
        );

        birthdayDates.stream().forEach((printDate) -> {
            printDate(printDate);
        });
        long endProgram = new Date().getTime();

        System.out.println("\nЗадание 2.");
        Date nowDate = new Date();
        LocalDate nowLocalDate = LocalDate.now();
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        ZonedDateTime nowZonedDateTime = ZonedDateTime.now();
        Calendar nowCalendar = Calendar.getInstance();

        //тут не соображаю, почему он так выводит инфу
        /*
        -1
        28
        28
        -1
        -1
         */
        System.out.println("nowDate.before(birthdayDate)=" + nowDate.before(birthdayDate));
        System.out.println("nowLocalDate.isAfter(birthdayLocalDate)=" + nowLocalDate.isAfter(birthdayLocalDate));
        System.out.println("nowLocalDateTime.isEqual(birthdayLocalDateTime)=" + nowLocalDateTime.isEqual(birthdayLocalDateTime));
        System.out.println("birthdayZonedDateTime.compareTo(nowZonedDateTime)=" + birthdayZonedDateTime.compareTo(nowZonedDateTime));
        System.out.println("birthdayZonedDateTime.compareTo(birthdayZonedDateTime)=" + birthdayZonedDateTime.compareTo(birthdayZonedDateTime));
        System.out.println("" + birthdayGregorianCalendar.compareTo(nowCalendar));

//        var nowDates = List.of(nowDate,
//                nowLocalDate,
//                nowLocalDateTime,
//                nowZonedDateTime,
//                nowCalendar
//        );

        //checkDates(birthdayDates,nowDates);//не работает. Передаю объекты, он их вроде переводит в список. Затем я обращаюсь .get(0) и там лежит ещё один список, к которому уже не могу обратиться


        System.out.println("\nЗадание 3.");
        System.out.println("Время выполнения задания 1: " + (endProgram - startProgram) + "ms");


        System.out.println("\nЗадание 4.");
        long startDate = new Date().getTime();
        Date birthdayDate4 = new Date(1995, 0, 25);
        System.out.println("Дата рождения Date: " + birthdayDate4.getDay() + "-" + birthdayDate4.getMonth() + "-" + birthdayDate4.getYear());
        long endDate = new Date().getTime();
        System.out.println("Время выполнения: " + (endDate - startDate));

        long startLocalDate = new Date().getTime();
        LocalDate birthdayLocalDat4e = LocalDate.of(1995, 01, 25);
        System.out.println("Дата рождения LocalDate: " + birthdayLocalDate);
        long endLocalDate = new Date().getTime();
        System.out.println("Время выполнения: " + (endLocalDate - startLocalDate));

        long startLocalDateTime = new Date().getTime();
        LocalDateTime birthdayLocalDateTime4 = LocalDateTime.of(1995, 01, 25, 10, 10, 10);
        System.out.println("Дата рождения LocalDateTime: " + birthdayLocalDateTime);
        long endLocalDateTime = new Date().getTime();
        System.out.println("Время выполнения: " + (endLocalDateTime - startLocalDateTime));

        long startZonedDateTime = new Date().getTime();
        ZonedDateTime birthdayZonedDateTime4 = ZonedDateTime.of(birthdayLocalDateTime, ZoneId.of("Asia/Krasnoyarsk"));
        System.out.println("Дата рождения ZonedDateTime: " + birthdayZonedDateTime);
        long endZonedDateTime = new Date().getTime();
        System.out.println("Время выполнения: " + (endZonedDateTime - startZonedDateTime));

        long startCalendar = new Date().getTime();
        Calendar birthdayGregorianCalendar4 = new GregorianCalendar(1995, 0, 25);
        System.out.println("Дата рождения Calendar: " + birthdayGregorianCalendar4.getTime());
        long endCalendar = new Date().getTime();
        System.out.println("Время выполнения: " + (endCalendar - startCalendar));


    }

    private static void printDate(Object dateClass) {

        switch (dateClass.getClass().toString()) {
            case ("class java.util.Date"):
                System.out.println("Дата рождения Date: " + dateClass);
                break;
            case ("class java.time.LocalDate"):
                System.out.println("Дата рождения LocalDate: " + dateClass);
                break;
            case ("class java.time.LocalDateTime"):
                System.out.println("Дата рождения LocalDateTime: " + dateClass);
                break;
            case ("class java.time.ZonedDateTime"):
                System.out.println("Дата рождения ZonedDateTime: " + dateClass);
                break;
            case ("class java.util.GregorianCalendar"):
                System.out.println("Дата рождения GregorianCalendar: " + ((GregorianCalendar) dateClass).getTime());
                break;
            default:
                System.out.println("Дата рождения: " + dateClass);
        }
    }

    private static void compareDate(Object birthdateClass, Object nowDateClass) {

        switch (birthdateClass.getClass().toString()) {
            case ("class java.util.Date"):
                System.out.println("Сравнение дат Date: " + ((Date) birthdateClass).compareTo((Date) nowDateClass));
                break;
            case ("class java.time.LocalDate"):
                System.out.println("Сравнение дат LocalDate: " + ((LocalDate) birthdateClass).compareTo((LocalDate) nowDateClass));
                break;
            case ("class java.time.LocalDateTime"):
                System.out.println("Сравнение дат LocalDateTime: " + ((LocalDateTime) birthdateClass).compareTo((LocalDateTime) nowDateClass));
                break;
            case ("class java.time.ZonedDateTime"):
                System.out.println("Сравнение дат ZonedDateTime: " + ((ZonedDateTime) birthdateClass).compareTo((ZonedDateTime) nowDateClass));
                break;
            case ("class java.util.GregorianCalendar"):
                System.out.println("Сравнение дат GregorianCalendar: " + ((GregorianCalendar) birthdateClass).compareTo((GregorianCalendar) nowDateClass));
                break;
        }
    }

    private static void checkDates(Object birthdates, Object nowDates) {

        for (int i = 0; i < List.of(nowDates).size(); i++) {
            var b = List.of(birthdates);
            var n = List.of(nowDates);
            compareDate(List.of(birthdates).get(i), List.of(nowDates).get(i));
            //((ImmutableCollections.ListN) List.of(birthdates).get(0)).get(3);
        }
    }

    private static void alltime() {

    }
}
/*
1) Создайте объект даты вашего рождения
и выведите на экран 5ю различными форматами вывода.
Повторите, используя каждый класс для работы с датой:
Date, LocalDate, LocalDateTime, ZonedDateTime, GregorianCalendar



2) Для каждого класса из задания 1 создайте объект текущего времени
и сравните с датой вашего рождения соответствующего типа.
Выведите разницу на экран.



3) Посчитайте общее количество времени,
за которое выполняется программа из 1го задания
и выведите результат на экран.
Используйте класс по желанию.
Пример вывода:
Alltime - ms



4) Аналогично 3му заданию, время выполнения в миллисекундах
(создание объекта + вывод на экран),
но для каждого класса из первого задания по отдельности.
Пример вывода:
Date - ms
LocalDate - ms
LocalDateTime - ms
...
(для 5 классов из 1го задания)
 */