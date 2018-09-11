package io.contralto.loops;

import io.contralto.processor.IntAvg;
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

    private Function<Integer, Integer> sq = i -> i * i;

    private Function<Integer, Integer> qb = i -> i * i * i;

    private Function<String, String> lc = a -> a.toLowerCase();

    private Function<String, String> uc = a -> a.toUpperCase();

    private Function<String, Integer> len = a -> a.length();


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
        List<Integer> l = Arrays.asList(0, 1, 2, 3);
        List<Integer> expected = Arrays.asList(0, 1, 4, 9);

        Loop intTest = new IntLoop(l);
        List<Integer> output = intTest.apply(sq);

        assertThat(output, is(expected));
    }

    public void testQb() {
        List<Integer> l = Arrays.asList(0, 1, 2, 3);
        List<Integer> expected = Arrays.asList(0, 1, 8, 27);

        Loop intTest = new IntLoop(l);
        List<Integer> output = intTest.apply(qb);

        assertThat(output, is(expected));
    }

    public void testLower() {
        List<String> l = Arrays.asList("A", "B", "C");
        List<String> expected = Arrays.asList("a", "b", "c");

        Loop strTest = new StrLoop(l);
        List<String> output = strTest.apply(lc);

        assertThat(output, is(expected));
    }

    public void testUpper() {
        List<String> l = Arrays.asList("a", "b", "c");
        List<String> expected = Arrays.asList("A", "B", "C");

        Loop strTest = new StrLoop(l);
        List<String> output = strTest.apply(uc);

        assertThat(output, is(expected));
    }

    public void testLength() {
        List<String> l = Arrays.asList("cat", "dog", "java", "compile");
        List<Integer> expected = Arrays.asList(3, 3, 4, 7);

        Loop strintTest = new StrintLoop(l);
        List<Integer> output = strintTest.apply(len);

        assertThat(output, is(expected));
    }

    public void testAvg() {
        List<Integer> l = Arrays.asList(0, 1, 2, 3);

        IntAvg intTest = new IntAvg();
        double output = intTest.average(l);
        double expected1 = 1.5;

        assertThat(output, is(expected1));

        l = Arrays.asList(0, 1, 2, 3, 6);
        double output2 = intTest.average(l);
        double expected2 = 2.0;
        assertThat(output2, is(expected2));
    }
}
