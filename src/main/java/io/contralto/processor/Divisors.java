package io.contralto.processor;

import java.util.List;

public class Divisors implements Processor<Integer, Integer> {

    @Override
    public Integer process(List<Integer> items) {
        Integer sum = 0;
        for (int i = 0; i < items.size(); i++) {
            Integer number = items.get(i);
            for (int j = 0; j < items.size(); j++) {
                Integer divisor = items.get(j);
                if (isDivisor(number, divisor) == true) {
                    sum ++;
                }
            }
        }
        return sum;
    }

    private static boolean isDivisor(Integer num, Integer div) {
        if (num % div == 0) {
            return true;
        }
        return false;
    }
}
