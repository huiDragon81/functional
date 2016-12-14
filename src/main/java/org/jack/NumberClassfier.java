package org.jack;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 16. 12. 9.
 */
public class NumberClassfier {
    
    public static boolean isFactor(final int candidate, int number) {
        return number % candidate == 0;
    }

    public static Set<Integer> factors(final int number) {
        Set<Integer> factors = new HashSet<Integer>();
        factors.add(1);
        factors.add(number);

        for (int i = 2 ; i < number ; ++i) {
            if(isFactor(i,number)) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static int aliquoSum(final Collection<Integer> factors) {

        int s = 0;
        int targetNumger = Collections.max(factors);
        for(int n: factors) {
            s += n;
        }
        return s - targetNumger;
    }

    public static boolean isPerfect(final int number) {
        return aliquoSum(factors(number)) == number;
    }

    public static boolean isAboudant(final int number) {
        return aliquoSum(factors(number)) > number;
    }

    public static boolean isDeficient(final int number) {
        return aliquoSum(factors(number)) < number;
    }

    public static void main(String[] args) {
        // write your code here


        System.out.println("isperfect = " + NumberClassfier.isPerfect(12));
        System.out.println("isabundant = " + NumberClassfier.isAboudant(12));
        System.out.println("isdeficient = " + NumberClassfier.isDeficient(12));
    }
}
