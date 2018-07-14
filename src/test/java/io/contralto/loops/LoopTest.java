package io.contralto.loops;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Unit test for simple App.
 */
public class LoopTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LoopTest(String testName) {
        super(testName);
    }

    private Function<Integer, Integer> sq = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer i) {
            return i * i;
        }
    };

    private Function<Integer, Integer> qb = i -> i*i*i;


    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(LoopTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testSq() {
        List<Integer> l = Arrays.asList(0,1,2,3);
        List<Integer> expected = Arrays.asList(0,1,4,9);

        Loop intTest = new IntLoop(l);
        List<Integer> output = intTest.apply(sq);

        assertThat(output, is(expected));
    }

    public void testQb() {
        List<Integer> l = Arrays.asList(0,1,2,3);
        List<Integer> expected = Arrays.asList(0,1,8,27);

        Loop intTest = new IntLoop(l);
        List<Integer> output = intTest.apply(qb);

        assertThat(output, is(expected));
    }
}
