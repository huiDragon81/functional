package org.jack;

import java.util.stream.IntStream;

/**
 * Created by root on 16. 12. 9.
 */
public class NumberClassfier8 {

    public static IntStream factors(final int number) {
        return IntStream.range(1, number+1).filter(value -> number % value == 0);

    }

    public static int aliquoSum(int number) {
        return factors(number).sum() - number;
    }

    public static boolean isPerfect(final int number) {
        return aliquoSum((number)) == number;
    }

    public static boolean isAboudant(final int number) {
        return aliquoSum((number)) > number;
    }

    public static boolean isDeficient(final int number) {
        return aliquoSum((number)) < number;
    }

    public static void main(String[] args) {
        // write your code here


        System.out.println("isperfect = " + NumberClassfier8.isPerfect(12));
        System.out.println("isabundant = " + NumberClassfier8.isAboudant(12));
        System.out.println("isdeficient = " + NumberClassfier8.isDeficient(12));
    }
}
