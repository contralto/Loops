package io.contralto.loops;

import java.util.List;
import java.util.function.Function;

public interface Loop<A, B> {
    List<B> apply(Function<A, B> f);
}
