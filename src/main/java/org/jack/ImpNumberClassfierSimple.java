package org.jack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImpNumberClassfierSimple {

    private int _number;
    private Map<Integer,Integer> _cache;

    public ImpNumberClassfierSimple(int targetNumger) {
        _number = targetNumger;
        _cache = new HashMap<Integer,Integer>();
    }

    public boolean isFactor(int potential) {
        return _number % potential == 0;
    }

    public Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<Integer>();
        factors.add(1);
        factors.add(_number);

        for (int i = 2 ; i<_number ; ++i) {
            if(isFactor(i)) {
                factors.add(i);
            }
        }

        return factors;
    }

    public int aliquoSum() {
        if(_cache.get(_number) == null) {
            int sum = 0;
            for (int i : getFactors()) {
                sum+=i;
                _cache.put(_number,sum-_number);
            }
        }
        return _cache.get(_number);
    }

    public boolean isPerfect() {
        return aliquoSum() == _number;
    }

    public boolean isAboudant() {
        return aliquoSum() > _number;
    }

    public boolean isDeficient() {
        return aliquoSum() < _number;
    }

    public static void main(String[] args) {
	    // write your code here

        ImpNumberClassfierSimple s = new ImpNumberClassfierSimple(12);
        System.out.println("isperfect = " + s.isPerfect());
        System.out.println("isabundant = " + s.isAboudant());
        System.out.println("isdeficient = " + s.isDeficient());
    }
}
