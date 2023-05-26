package Shmidt.lambdas.task1;

import Shmidt.lambdas.task1.functions.Double;
import Shmidt.lambdas.task1.functions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static Shmidt.tests.sideMethods.arrString2Int;
import static Shmidt.tests.sideMethods.isInteger;

//Double 1 -5 69 8 -1 0 4 -6
//Half 1 -5 69 8 -1 0 4 -6
//Exact 1 -5 69 8 -1 0 4 -6
//Square 1 -5 69 8 -1 0 4 -6
//Square
//1 -5 69 8 -1 0 4 -6
public class MainClass {
    public static void main(String[] args) {

        if (!checkInput(args)) {
            System.exit(0);
        }

        System.out.println("Исходный массив:");
        Stream.of(args).forEach(elem -> {
            System.out.print(elem + " ");
        });
        System.out.println();

        String[] stringParameters = new String[args.length - 1];
        System.arraycopy(args, 1, stringParameters, 0, args.length - 1);
        int[] values = arrString2Int(stringParameters);
        System.out.println();
        Function operation = getFunction(args[0]);


        System.out.println("Обработанный массив:");
        applyFunction(values, operation);

    }

    static void applyFunction(int[] values, Function function) {
//        System.out.print(function.getClass().getSimpleName() + " ");
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
            case ("Wave")://используя анонимный класс, добавьте операцию Wave: к каждому числу прибавляется значение предыдущего.
                return new Function() {
                    int previous = 0;

                    public int evaluate(int param) {
                        int result = previous + param;
                        previous = param;
                        return result;
                    }
                };
            case ("SquareEven"):
                return param -> {
                    if (param % 2 == 0)
                        return param * param;
                    else return param;
                };
            default: {
                System.out.println("Операция " + operation + " не поддерживается");
                return null;
            }
        }
    }

    private static boolean checkInput(String[] args) {
        if (args.length == 0) {
            System.out.println("Не передано название операции и аргументы");
            return false;
        } else if (Collections.disjoint(List.of("Double", "Exact", "Half", "Square", "Wave", "SquareEven"), Arrays.asList(args))) {
            System.out.println("Не передана поддерживаемая операция");
            return false;
        } else if (args.length == 1 & !isInteger(args[0])) {
            System.out.println("Не переданы аргументы");
            return false;
        }
        return true;
    }
}
