package io.contralto.processor;

import java.util.List;

public class Divisors implements Processor<Integer, Integer> {

    @Override
    public Integer process(List<Integer> items) {
        Integer sum = 0;
        for (int i = 0; i < items.size(); i++) {
            Integer number = items.get(i);
            for (Integer divisor : items) {
                if (isDivisor(number, divisor)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static boolean isDivisor(Integer num, Integer div) {
        return (num % div == 0);
    }
}
