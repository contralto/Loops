package io.contralto.loops;

import java.util.*;
import java.util.function.Function;

public class IntLoop implements Loop<Integer, Integer> {
    private final List<Integer> list;

    public IntLoop(List<Integer> l) {
        list = l;
    }

    public List<Integer> apply(Function<Integer, Integer> f) {
        List<Integer> output = new ArrayList<>();
        for (Integer aList : list) {
            output.add(f.apply(aList));
        }
        return output;
    }
}
