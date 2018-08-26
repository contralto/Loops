package io.contralto.processor;

import java.util.List;

public class CountPrimes implements Processor<Integer, Integer> {


    @Override
    public Integer process(List<Integer> items) {
        Integer totalsum = 0;
        for (int i = 0; i < items.size(); i++) {
            Integer sum = 0;
            Integer number = items.get(i);
            for (int j = 0; j < items.size(); j++) {
                Integer divisor = items.get(j);
                if (isDivisor(number, divisor) == true) {
                    sum++;
                }
            }
            if (sum == 2)
                totalsum++;
        }
        System.out.println("totalsum is " + totalsum);
        return totalsum;
    }

    private static boolean isDivisor(Integer num, Integer div) {
        if (num % div == 0) {
            return true;
        }
        return false;
    }
}
