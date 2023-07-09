package Shmidt.abstractProgThroughInterfaces.lesson4.task1;

import Shmidt.abstractProgThroughInterfaces.lesson4.task1.functions.Double;
import Shmidt.abstractProgThroughInterfaces.lesson4.task1.functions.Exact;
import Shmidt.abstractProgThroughInterfaces.lesson4.task1.functions.Function;
import Shmidt.abstractProgThroughInterfaces.lesson4.task1.functions.Half;
import Shmidt.abstractProgThroughInterfaces.lesson4.task1.functions.Square;

import java.util.stream.Stream;

import static Shmidt.someTests.sideMethods.arrString2Int;
import static Shmidt.someTests.sideMethods.isInteger;


//Double 4 -5 69 8 -1 0
//Half 4 -5 69 8 -1 0
//Exact 4 -5 69 8 -1 0
//Square 4 -5 69 8 -1 0
//Square
//4 -5 69 8 -1 0
public class MainClass {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Не передано название операции и аргументы");
            return;
        } else if (isInteger(args[0])) {
            System.out.println("Не передано название операции");
            return;
        } else if (args.length == 1 & !isInteger(args[0])) {
            System.out.println("Не переданы аргументы");
            return;
        }

        System.out.println("Исходный массив:");
        Stream.of(args).forEach(elem -> {
            System.out.print(elem + " ");
        });
        System.out.println();

        String[] stringValues = new String[args.length - 1];
        System.arraycopy(args, 1, stringValues, 0, args.length - 1);

        int[] values = arrString2Int(stringValues);
        Function func = getFunction(args[0]);

        System.out.println("Обработанный массив:");
        applyFunction(values, func);

    }

    static void applyFunction(int[] values, Function function) {
        if (function == null) {
            System.out.println("Передана пустая операция");
            return;
        }
        System.out.print(function.getClass().getSimpleName() + ": ");
        for (int v : values) {
            System.out.print(function.evaluate(v) + " ");
        }
    }

    static Function getFunction(String operation) {
        switch (operation) {
            case ("Double"):
                return new Double();
            case ("Half"):
                return new Half();
            case ("Exact"):
                return new Exact();
            case ("Square"):
                return new Square();
            default: {
                System.out.println("Операция " + operation + " не поддерживается");
                return null;
            }
        }
    }
}
