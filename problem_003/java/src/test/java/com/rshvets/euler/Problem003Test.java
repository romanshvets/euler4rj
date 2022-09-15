package com.rshvets.euler;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.List;

import static com.rshvets.euler.Problem003.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem003Test {

    @Test
    void testLargestPrimeFactor() {
        assertEquals(7L, largestPrimeFactor(primeFactors(392L)));
        assertEquals(29L, largestPrimeFactor(primeFactors(13195L)));
        assertEquals(997L, largestPrimeFactor(primeFactors(105682L)));
    }

    @Test
    void testPrimeFactors() {
        assertListsEquals(Arrays.asList(2L, 7L), primeFactors(392L));
        assertListsEquals(Arrays.asList(5L, 7L, 13L, 29L), primeFactors(13195L));
        assertListsEquals(Arrays.asList(2L, 53L, 997L), primeFactors(105682L));
    }

    @Test
    void testIsPrime() {
        var primesUnder100 = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

        for (var i = 0; i < 100; ++i) {
            assertEquals(isPrime(i), primesUnder100.contains(i));
        }
    }

    /**
     * Helper method
     */
    private static void assertListsEquals(List<Long> a, List<Long> b) {
        if (a.size() != b.size())
            throw new AssertionFailedError();

        for (var i = 0; i < a.size(); ++i) {
            var aElement = a.get(i);
            var bElement = b.get(i);

            assertEquals(aElement, bElement);
        }
    }
}