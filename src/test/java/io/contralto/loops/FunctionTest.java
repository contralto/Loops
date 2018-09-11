package io.contralto.loops;

import io.contralto.processor.CountPrimes;
import io.contralto.processor.Divisors;
import io.contralto.processor.IntAverage;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Function<Integer, Integer> sq = i -> i*i;
        assertTrue(sq.apply(3) == 9);
    }

    public void testAverage() {
        List<Integer> list = Arrays.asList(5, 8, 1, 4, 3);
        Double avgval = 4.2;

        IntAverage average = new IntAverage();
        Double test = average.process(list);

        assertThat(test, is(avgval));
    }

    public void testDivisorSum() {
        int n = 100000;
        List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        Double logn = Math.log(n);

        Divisors divsum = new Divisors();
        Double avgDivs = divsum.process(list) / (double)n;

        assertThat("", Math.abs(avgDivs - logn) < 0.2);
    }

    public void testCountPrimes() {
        int n = 10000;
        List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        Double approx = n/Math.log(n);
        System.out.println(approx);

        CountPrimes primenums = new CountPrimes();
        Double totalPrime = (double)(primenums.process(list));

        assertThat("", Math.abs(totalPrime - approx) / 1000 < 1.3);
    }

    public void testBaseConverter() {
        BaseConverter bc = new BaseConverter(6);

        assertThat(bc.convert(247), is((double)1051));
        assertThat(bc.convert(36), is((double)100));

        bc.changeBase(8);

        assertThat(bc.convert(1245), is((double)2335));

        bc.changeBase(3);

        assertThat(bc.convert(21), is((double)4));

    }
}
