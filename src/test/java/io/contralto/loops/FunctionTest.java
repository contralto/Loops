package io.contralto.loops;

import io.contralto.processor.IntAverage;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple App.
 */
public class FunctionTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FunctionTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FunctionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testFunction() {
        Function<Integer, Integer> sq = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i*i;
            }
        };
        assertTrue(sq.apply(3) == 9);
    }

    public void testAverage() {
        List<Integer> list = Arrays.asList(5, 8, 1, 4, 3);
        Double avgval = 4.2;

        IntAverage average = new IntAverage();
        Double test = average.process(list);

        assertThat(test, is(avgval));

    }
}
