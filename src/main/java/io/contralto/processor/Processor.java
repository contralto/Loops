package io.contralto.processor;

import java.util.List;

public interface Processor<In, Out> {
    public Out process(List<In> items);
}
