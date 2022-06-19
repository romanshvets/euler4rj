package com.rshvets.euler;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static com.rshvets.euler.Problem001.sumOfMultiples;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem001Test {

    @Test
    void sumOfMultiplesTest() {
        assertEquals(23, sumOfMultiples(10));
        assertEquals(233168, sumOfMultiples(1000));
    }

    @Test
    void sumOfMultiplesPerformanceTest() {
        // warming up to improve java class lazy-loading system and JIT compilation
        for (int i = 0; i < 1_000_000; ++i) {
            var x = sumOfMultiples(25_000);
            if (x <= 0) {
                System.out.println("");
            }
        }

        for (int n = 4; n < 10; ++n) {
            var upperBound = (long) Math.pow(10, n);

            var start = Instant.now();
            var result = sumOfMultiples(upperBound);
            var finish = Instant.now();
            var elapsed = Duration.between(start, finish).toNanos() / 1000L;

            System.out.printf("Upper bound: 10^%s,  Time: %8s\n", n, elapsed);

            // had to add this to prevent compiler optimization. Just in case...
            if (result <= 0) {
                System.out.println("");
            }
        }
    }
}