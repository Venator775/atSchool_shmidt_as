package Shmidt.lesson2_16_DaysOfWeek;

public class Week {
    public Day monday = new Day();
    public Day tuesday = new Day();
    public Day wednesday = new Day();
    public Day thursday = new Day();
    public Day friday = new Day();
    public Day saturday = new Day();
    public Day sunday = new Day();

    public int weekNumber;

    int monthNumber;

    public Week(int _weekNumber) {
        this.weekNumber = _weekNumber;

        monday.dayOfWeek = DaysOfWeek.monday;
        tuesday.dayOfWeek = DaysOfWeek.tuesday;
        wednesday.dayOfWeek = DaysOfWeek.wednesday;
        thursday.dayOfWeek = DaysOfWeek.thursday;
        friday.dayOfWeek = DaysOfWeek.friday;
        saturday.dayOfWeek = DaysOfWeek.saturday;
        sunday.dayOfWeek = DaysOfWeek.sunday;
    }

    public void getInfo() {
        int countDays = 0;
        int lastDayOfTheWeek = 0;
        Day[] week = {sunday, saturday, friday, thursday, wednesday, tuesday, monday};
        if (getMonth())
            if (weekNumber == 1) {
                saturday.dayNumber = 1;
                sunday.dayNumber = 2;
                System.out.println("Неделя {" + weekNumber + "}:");
                System.out.println(saturday.dayOfWeek + " - " + saturday.dayNumber);
                System.out.println(sunday.dayOfWeek + " - " + sunday.dayNumber);
            } else if (weekNumber == 53) {
                monday.dayNumber = 26;
                tuesday.dayNumber = 27;
                wednesday.dayNumber = 28;
                thursday.dayNumber = 29;
                friday.dayNumber = 30;
                saturday.dayNumber = 31;
                System.out.println("Неделя {" + weekNumber + "}:");
                System.out.println(monday.dayOfWeek + " - " + monday.dayNumber);
                System.out.println(tuesday.dayOfWeek + " - " + tuesday.dayNumber);
                System.out.println(wednesday.dayOfWeek + " - " + wednesday.dayNumber);
                System.out.println(thursday.dayOfWeek + " - " + thursday.dayNumber);
                System.out.println(friday.dayOfWeek + " - " + friday.dayNumber);
                System.out.println(saturday.dayOfWeek + " - " + saturday.dayNumber);
            } else {
                switch (monthNumber) {
                    case 1:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays;//37 не 6 неделе

                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 31)
                                date -= 31;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 2:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 28)
                                date -= 28;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 3:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31 - 28;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 31)
                                date -= 31;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 4:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31 - 28 - 31;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 30)
                                date -= 30;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 5:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31 - 28 - 31 - 30;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 31)
                                date -= 31;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 6:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31 - 28 - 31 - 30 - 31;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 30)
                                date -= 30;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 7:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31 - 28 - 31 - 30 - 31 - 30;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 31)
                                date -= 31;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 8:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31 - 28 - 31 - 30 - 31 - 30 - 31;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 31)
                                date -= 31;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 9:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31 - 28 - 31 - 30 - 31 - 30 - 31 - 31;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 30)
                                date -= 30;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 10:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31 - 28 - 31 - 30 - 31 - 30 - 31 - 31 - 30;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 31)
                                date -= 31;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 11:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31 - 28 - 31 - 30 - 31 - 30 - 31 - 31 - 30 - 31;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 30)
                                date -= 30;
                            week[i].dayNumber = date;
                        }
                        break;
                    case 12:
                        countDays = weekNumber * 7 - 5;
                        lastDayOfTheWeek = countDays - 31 - 28 - 31 - 30 - 31 - 30 - 31 - 31 - 30 - 31 - 30;
                        for (int i = week.length - 1; i >= 0; i--) {
                            int date = lastDayOfTheWeek - i;
                            if (date > 31)
                                date -= 31;
                            week[i].dayNumber = date;
                        }
                        break;
                }
                System.out.println("Неделя {" + weekNumber + "}:");
                System.out.println(monday.dayOfWeek + " - " + monday.dayNumber);
                System.out.println(tuesday.dayOfWeek + " - " + tuesday.dayNumber);
                System.out.println(wednesday.dayOfWeek + " - " + wednesday.dayNumber);
                System.out.println(thursday.dayOfWeek + " - " + thursday.dayNumber);
                System.out.println(friday.dayOfWeek + " - " + friday.dayNumber);
                System.out.println(saturday.dayOfWeek + " - " + saturday.dayNumber);
                System.out.println(sunday.dayOfWeek + " - " + sunday.dayNumber);
            }
        else System.out.println("Введите значение от 1 до 53. Ваше значение = " + weekNumber);
    }

    boolean getMonth() {
        if (weekNumber <= 0 || weekNumber > 53)
            return false;
        else if (weekNumber > 0 && weekNumber <= 6)
            monthNumber = 1;
        else if (weekNumber > 6 && weekNumber <= 10)
            monthNumber = 2;
        else if (weekNumber > 10 && weekNumber <= 14)
            monthNumber = 3;
        else if (weekNumber > 14 && weekNumber <= 18)
            monthNumber = 4;
        else if (weekNumber > 18 && weekNumber <= 23)
            monthNumber = 5;
        else if (weekNumber > 23 && weekNumber <= 27)
            monthNumber = 6;
        else if (weekNumber > 27 && weekNumber <= 31)
            monthNumber = 7;
        else if (weekNumber > 31 && weekNumber <= 36)
            monthNumber = 8;
        else if (weekNumber > 36 && weekNumber <= 40)
            monthNumber = 9;
        else if (weekNumber > 40 && weekNumber <= 45)
            monthNumber = 10;
        else if (weekNumber > 45 && weekNumber <= 49)
            monthNumber = 11;
        else if (weekNumber > 49 && weekNumber <= 53)
            monthNumber = 12;
        return true;
    }
}
//    Создать класс Week содержащий 7 полей Day и поле номера недели относительно начала года (не статическое).
/*
месяца
        31
        28
        31
        30
        31
        30
        31
        31
        30
        31
        30
        31*/