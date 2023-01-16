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
        long startProgram = System.currentTimeMillis();

        Date birthdayDate = new Date(1995, 0, 25);
        LocalDate birthdayLocalDate = LocalDate.of(1995, 1, 25);
        LocalDateTime birthdayLocalDateTime = LocalDateTime.of(1995, 1, 25, 10, 10, 10);
        ZonedDateTime birthdayZonedDateTime = ZonedDateTime.of(birthdayLocalDateTime, ZoneId.of("Asia/Krasnoyarsk"));
        GregorianCalendar birthdayGregorianCalendar = new GregorianCalendar(1995, 0, 25);

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
        long endProgram = System.currentTimeMillis();
        System.out.println("task1 execute time(ms)=" + (endProgram - startProgram));

        System.out.println("\nЗадание 2.");
        Date nowDate = new Date();
        LocalDate nowLocalDate = LocalDate.now();
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        ZonedDateTime nowZonedDateTime = ZonedDateTime.now();
        Calendar nowCalendar = GregorianCalendar.getInstance();

        System.out.println("Date: " + getDiff(nowDate, birthdayDate));
        System.out.println("LocalDate: " + getDiff(nowLocalDate, birthdayLocalDate));
        System.out.println("LocalDateTime: " + getDiff(nowLocalDateTime, birthdayLocalDateTime));
        System.out.println("ZonedDateTime: " + getDiff(nowZonedDateTime, birthdayZonedDateTime));
        System.out.println("GregorianCalendar: " + getDiff(nowCalendar, birthdayGregorianCalendar));


        System.out.println("\nЗадание 3.");
        System.out.println("Время выполнения задания 1: " + (endProgram - startProgram) + "ms");


        System.out.println("\nЗадание 4.");
        long startDate = System.currentTimeMillis();
        Date birthdayDate4 = new Date(1995, 0, 25);
        System.out.println("Дата рождения Date: " + birthdayDate4.getDay() + "-" + birthdayDate4.getMonth() + "-" + birthdayDate4.getYear());
        long endDate = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endDate - startDate));

        long startLocalDate = System.currentTimeMillis();
        LocalDate birthdayLocalDat4e = LocalDate.of(1995, 1, 25);
        System.out.println("Дата рождения LocalDate: " + birthdayLocalDat4e);
        long endLocalDate = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endLocalDate - startLocalDate));

        long startLocalDateTime = System.currentTimeMillis();
        LocalDateTime birthdayLocalDateTime4 = LocalDateTime.of(1995, 1, 25, 10, 10, 10);
        System.out.println("Дата рождения LocalDateTime: " + birthdayLocalDateTime4);
        long endLocalDateTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endLocalDateTime - startLocalDateTime));

        long startZonedDateTime = System.currentTimeMillis();
        ZonedDateTime birthdayZonedDateTime4 = ZonedDateTime.of(birthdayLocalDateTime, ZoneId.of("Asia/Krasnoyarsk"));
        System.out.println("Дата рождения ZonedDateTime: " + birthdayZonedDateTime4);
        long endZonedDateTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endZonedDateTime - startZonedDateTime));

        long startCalendar = System.currentTimeMillis();
        Calendar birthdayGregorianCalendar4 = new GregorianCalendar(1995, 0, 25);
        System.out.println("Дата рождения Calendar: " + birthdayGregorianCalendar4.getTime());
        long endCalendar = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endCalendar - startCalendar));
    }

    /**
     * Выводит на экран дату принимаемого объекта
     * @param dateClass Объект даты Date/LocalDate/LocalDateTime/ZonedDateTime/GregorianCalendar
     */
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

    /**
     * Сравнивает даты и возвращает их отличия строкой
     * @param nowDate дата нынешняя
     * @param birthdayDate дата для сравнения(рождения)
     * @return строку, в которой говорится, на сколько лет,дней и месяцев даты отличаются
     */
    public static String getDiff(Object nowDate, Object birthdayDate) {
        switch (nowDate.getClass().toString()) {
            case ("class java.util.Date"):
                Date _nowDate = (Date) nowDate;
                Date _birthdayDate = (Date) birthdayDate;
                return "Даты отличаются на: " + Math.abs((_nowDate.getYear() + 1900) - _birthdayDate.getYear()) + " лет, " +
                        Math.abs((_nowDate.getMonth() - _birthdayDate.getMonth())) + " месяцев, " +
                        Math.abs((_nowDate.getDate() - _birthdayDate.getDate())) + " дней";

            case ("class java.time.LocalDate"):
                LocalDate _nowLocalDate = (LocalDate) nowDate;
                LocalDate _birthdayLocalDate = (LocalDate) birthdayDate;
                return "Даты отличаются на: " + Math.abs(_nowLocalDate.getYear() - _birthdayLocalDate.getYear()) + " лет, " +
                        Math.abs((_nowLocalDate.getMonthValue() - _birthdayLocalDate.getMonthValue())) + " месяцев, " +
                        Math.abs((_nowLocalDate.getDayOfMonth() - _birthdayLocalDate.getDayOfMonth())) + " дней";

            case ("class java.time.LocalDateTime"):
                LocalDateTime _nowLocalDateTime = (LocalDateTime) nowDate;
                LocalDateTime _birthdayLocalDateTime = (LocalDateTime) birthdayDate;
                return "Даты отличаются на: " + Math.abs(_nowLocalDateTime.getYear() - _birthdayLocalDateTime.getYear()) + " лет, " +
                        Math.abs((_nowLocalDateTime.getMonthValue() - _birthdayLocalDateTime.getMonthValue())) + " месяцев, " +
                        Math.abs((_nowLocalDateTime.getDayOfMonth() - _birthdayLocalDateTime.getDayOfMonth())) + " дней";

            case ("class java.time.ZonedDateTime"):
                ZonedDateTime _nowZonedDateTime = (ZonedDateTime) nowDate;
                ZonedDateTime _birthdayZonedDateTime = (ZonedDateTime) birthdayDate;
                return "Даты отличаются на: " + Math.abs(_nowZonedDateTime.getYear() - _birthdayZonedDateTime.getYear()) + " лет, " +
                        Math.abs((_nowZonedDateTime.getMonthValue() - _birthdayZonedDateTime.getMonthValue())) + " месяцев, " +
                        Math.abs((_nowZonedDateTime.getDayOfMonth() - _birthdayZonedDateTime.getDayOfMonth())) + " дней";

            case ("class java.util.GregorianCalendar"):
                Calendar _nowCalendar = (Calendar) nowDate;
                GregorianCalendar _birthdayGregorianCalendar = (GregorianCalendar) birthdayDate;
                return "Даты отличаются на: " + Math.abs(_nowCalendar.get(Calendar.YEAR) - _birthdayGregorianCalendar.get(Calendar.YEAR)) + " лет, " +
                        Math.abs(_nowCalendar.get(Calendar.MONTH) - _birthdayGregorianCalendar.get(Calendar.MONTH)) + " месяцев, " +
                        Math.abs(_nowCalendar.get(Calendar.DATE) - _birthdayGregorianCalendar.get(Calendar.DATE)) + " дней";

            default:
                System.out.println("Дата рождения отличается: ");
        }
        return "";
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