package io.contralto.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StrLoop implements Loop<String, String> {

    private final List<String> list;

    public StrLoop(List<String> l) {
        list = l;
    }

    @Override
    public List<String> apply(Function<String, String> f) {
        List<String> output = new ArrayList<>();
        for (String aList : list) {
            output.add(f.apply(aList));
        }

        return output;
    }
}
