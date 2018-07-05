package io.contralto.loops;

import java.util.List;
import java.util.function.Function;

public interface Loop<A> {
    List<A> apply(Function<A, A> f);
}
