package io.contralto.processor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntAverage extends StatisticsProcessor<Integer, Double> {
    private static Function<List<Integer>, Double> avg = items -> items.stream().collect(Collectors.averagingInt(item -> item));

    public IntAverage() {
        super(avg);
    }
}
