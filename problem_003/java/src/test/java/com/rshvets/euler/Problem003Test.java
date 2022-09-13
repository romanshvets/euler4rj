package com.rshvets.euler;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import static com.rshvets.euler.Problem003.isPrime;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem003Test {

//    The prime factors of 13195 are 5, 7, 13 and 29.

    @Test
    void testLargestPrimeFactor() {

    }

    @Test
    void testPrimeFactors() {
        BiPredicate<List<Number>, List<Number>> listsComparator = (list1, list2) -> {
            return false;
        };


    }


    @Test
    void testIsPrime() {
        var primesUnder100 = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

        for (var i = 0; i < 100; ++i) {
            assertEquals(isPrime(i), primesUnder100.contains(i));
        }
    }
}