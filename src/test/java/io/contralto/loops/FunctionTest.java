package io.contralto.loops;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.function.Function;

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
}
