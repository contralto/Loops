package io.contralto.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StrintLoop implements Loop<String,Integer> {
    public final List<String> list;

    public StrintLoop(List<String> l) {
        list = l;
    }


    @Override
    public List<Integer> apply(Function<String, Integer> f) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            output.add(f.apply(list.get(i)));
        }


        return output;
    }
}
