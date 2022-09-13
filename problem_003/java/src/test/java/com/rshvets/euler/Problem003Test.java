package com.rshvets.euler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import static com.rshvets.euler.Problem003.isPrime;
import static com.rshvets.euler.Problem003.primeFactors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem003Test {

    @Test
    void testLargestPrimeFactor() {

    }

    @Test
    void testPrimeFactors() {
        BiPredicate<List<Long>, List<Long>> listsComparator = (list1, list2) -> {
            if (list1.isEmpty()) {

            }


            return false;
        };

        assertTrue(listsComparator.test(Arrays.asList(5L, 7L, 13L, 29L), primeFactors(13195L)));
    }

    @Test
    void testIsPrime() {
        var primesUnder100 = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

        for (var i = 0; i < 100; ++i) {
            assertEquals(isPrime(i), primesUnder100.contains(i));
        }
    }

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