package com.rshvets.euler;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.rshvets.euler.Problem002.sumOfEvenFibonacciNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem002Test {

    @Test
    void testSumOfEvenFibonacciNumbers() {
        var fibonacciUnder50 = Arrays.asList(1, 2, 3, 5, 8, 13, 21, 34);

        var sumOfEvenFibonacciUnder50 = 0;

        for (var fibonacci : fibonacciUnder50) {
            if (fibonacci % 2 == 0)
                sumOfEvenFibonacciUnder50 += fibonacci;
        }

        assertEquals(sumOfEvenFibonacciUnder50, sumOfEvenFibonacciNumbers(50));
    }
}