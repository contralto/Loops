package io.contralto.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StrLoop implements Loop<String> {

    private final List<String> list;

    public StrLoop(List<String> l) {
        list = l;
    }

    @Override
    public List<String> apply(Function<String, String> f) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            output.add(f.apply(list.get(i)));
        }

        return output;
    }
}
