package io.contralto.processor;

import java.util.List;
import java.util.function.Function;

public class StatisticsProcessor<In, Out> implements Processor<In, Out> {
    private final Function<List<In>, Out> processor;

    public StatisticsProcessor(Function<List<In> , Out> fun) {
        processor = fun;
    }

    public Out process(List<In> items) {
        return processor.apply(items);
    }

}
