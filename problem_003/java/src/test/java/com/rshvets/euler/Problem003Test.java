package com.rshvets.euler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

import static com.rshvets.euler.Problem003.getLargestPrimeFactor;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem003Test {

    @Disabled
    @Test
    void testLargestPrimeFactor() {
        assertEquals(7L, getLargestPrimeFactor(392));
        assertEquals(29L, getLargestPrimeFactor(13195));
        assertEquals(331L, getLargestPrimeFactor(45347));
        assertEquals(997L, getLargestPrimeFactor(105682));
    }

    @Test
    void testLargestPrimeFactorPerformance() {
        var upperBounds = new long[]{10_000L, 100_000L, 1_000_000L};

        for (long upperBound : upperBounds) {
            var durations = new LinkedList<Long>();

            for (var i = 0; i < 100; ++i) {
                var start = Instant.now();

                for (var n = 2; n <= upperBound; ++n) {
                    var maxPrimeFactor = getLargestPrimeFactor(n);
                }

                var duration = Duration.between(start, Instant.now()).toNanos() / 1000L;
                durations.add(duration);
            }

            var average = durations.stream().mapToLong(i -> i).average().orElse(0D);

            System.out.printf("Calculated prime factors for each number up to %s in %s %ss\n",
                    upperBound, Double.valueOf(average).longValue(), "\u00B5");
        }
    }
}