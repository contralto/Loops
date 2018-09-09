package io.contralto.processor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntAverage implements Processor<Integer, Double> {      //stateless
    private static Function<List<Integer>, Double> avg = items -> items.stream().collect(Collectors.averagingInt(item -> item));

    @Override
    public Double process(List<Integer> items) {
        return avg.apply(items);
    }
}

