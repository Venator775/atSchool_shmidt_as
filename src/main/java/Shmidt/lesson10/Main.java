package main.java.Shmidt.lesson10;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Integer integer1 = 5;
        Integer integer2 = 50;
        BigInteger integer3 = BigInteger.valueOf(13_050_048);
        BigInteger integer4 = BigInteger.valueOf(531_230_111);
        BigDecimal decimal3 = BigDecimal.valueOf(13_050_048_196_378_961_786_312.0);
        BigDecimal decimal4 = BigDecimal.valueOf(53_123_025_191_977_991_796_349_534.0);
        BigDecimal decimal5 = BigDecimal.valueOf(13.050_048_196_378_961_786_312);
        BigDecimal decimal6 = BigDecimal.valueOf(53.123_025_191_977_991_796_434);
        int int1 = 50;
        int int2 = 30;
        double double3 = 5.201d;
        double double4 = 200.3d;

        System.out.println("int1+int2=" + (int1 + int2));
        System.out.println("int1*int2=" + (int1 * int2));
        System.out.println("double4-double3=" + (double4 - double3));
        System.out.println("integer4/integer3=" + integer4.divide(integer3));
        System.out.println("integer2*integer1=" + integer2*integer1);
        System.out.println("int1/double3=" + (int1 / double3));
        System.out.println("int1%int2=" + (int1 % int2));
        System.out.println("decimal4-decimal3=" + (decimal4.subtract(decimal3)));
        System.out.println("decimal5-decimal6=" + (decimal5.subtract(decimal6)));
        System.out.println("decimal5+decimal6=" + (decimal5.add(decimal6)));

        int num = 461;
        int result = 0;
        while (num > 0)
        {
            result = result + num % 10;
            num = num / 10;
        }
        System.out.println(result);
    }
}
