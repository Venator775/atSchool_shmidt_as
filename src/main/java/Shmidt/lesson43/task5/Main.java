package Shmidt.lesson43.task5;

public class Main {
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]),
                b = Integer.parseInt(args[1]),
                c = Integer.parseInt(args[2]),
                d = Integer.parseInt(args[3]);

        if ((a <= 0 || b <= 0) && (c <= 0 || d <= 0)) {//Нужно добавить проверку, что числа больше или равны нулю.
            System.out.println("Некорректный ввод. Есть значение<0");
            return;//В противном случае нужно вывести пользователю сообщение об ошибке, и завершить программу.
        }

        System.out.println("Цена: " + a +" руб, " + b + " коп;\n" +"Деньги: " + c + " руб, " + d + " коп.");
        int price, money, change;

        price = b + a * 100;
        money = d + c * 100;

        change = money - price;

        if (change > 0) {//Так же нужно проверить, что уплаченной суммы хватает для оплаты товара.
            System.out.println("Сдача составит " + change / 100 + " руб и " + change % 100 + " коп.");
        } else {
            System.out.println("Не хватает денег");
        }

    }
}
/*
Товар стоит a руб. b коп. За него заплатили c руб. d коп.

Напишите программу, расчитывающую сдачу.
Целые числа a, b, c, d передаются через аргументы командной строки.

Проверку на наличие аргументов делать не надо.
Нужно добавить проверку, что числа больше или равны нулю.
В противном случае нужно вывести пользователю сообщение об ошибке,
и завершить программу.
Так же нужно проверить, что уплаченной суммы хватает для оплаты товара.
В противном случае нужно вывести соответствующее сообщение и завершить программу.


Формат вывода:
Сдача составит e рублей и f копеек.
 */