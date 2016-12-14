package org.jack;
import fj.F;
import fj.data.List;
/**
 * Created by root on 16. 12. 9.
 */
public class NumberClassfier_functional {

    public static List<Integer> factorsOf(final int number) {
        return List.range(1,number+1).filter(new F<Integer, Boolean>() {
            public Boolean f(Integer i) {
                return number % i == 0;
            }
        });
    }

    public static int aliquoSum(List<Integer> factors) {
        System.out.println(factors.toString());
        return factors.foldLeft(fj.function.Integers.add,0) - factors.last();
    }

    public static boolean isPerfect(final int number) {
        return aliquoSum(factorsOf(number)) == number;
    }

    public static boolean isAboudant(final int number) {
        return aliquoSum(factorsOf(number)) > number;
    }

    public static boolean isDeficient(final int number) {
        return aliquoSum(factorsOf(number)) < number;
    }

    public static void main(String[] args) {
        // write your code here


        System.out.println("isperfect = " + NumberClassfier_functional.isPerfect(12));
        System.out.println("isabundant = " + NumberClassfier_functional.isAboudant(12));
        System.out.println("isdeficient = " + NumberClassfier_functional.isDeficient(12));
    }
}
