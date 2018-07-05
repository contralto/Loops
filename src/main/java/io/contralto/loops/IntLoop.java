package io.contralto.loops;

import java.util.*;
import java.util.function.Function;

public class IntLoop implements Loop<Integer> {
    private final List<Integer> list;

    public IntLoop(List<Integer> l) {
        list = l;
    }

    public List<Integer> apply(Function<Integer, Integer> f) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            output.add(f.apply(list.get(i)));
        }
        return output;
    }
}
