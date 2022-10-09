package com.rshvets.euler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Optional;

import static com.rshvets.euler.Problem003.getLargestPrimeFactor;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem003Test {

    @Disabled
    @Test
    void testLargestPrimeFactor() {
        assertEquals(Optional.empty(), getLargestPrimeFactor(23L));
        assertEquals(Optional.empty(), getLargestPrimeFactor(59L));
        assertEquals(Optional.empty(), getLargestPrimeFactor(83L));

        assertEquals(Optional.of(7L), getLargestPrimeFactor(392L));
        assertEquals(Optional.of(3L), getLargestPrimeFactor(648L));
        assertEquals(Optional.of(29L), getLargestPrimeFactor(13195L));
        assertEquals(Optional.of(43L), getLargestPrimeFactor(14534L));
        assertEquals(Optional.of(331L), getLargestPrimeFactor(45347L));
        assertEquals(Optional.of(193L), getLargestPrimeFactor(75849L));
        assertEquals(Optional.of(997L), getLargestPrimeFactor(105682L));
    }

    @Test
    void testLargestPrimeFactorPerformance() {
        var upperBound = 100_000L;

        var durations = new LinkedList<Long>();

        for (var i = 0; i < 1000; ++i) {
            var start = Instant.now();

            for (var n = 2; n <= upperBound; ++n) {
                var largestPrimeFactor = getLargestPrimeFactor(n);
            }

            var duration = Duration.between(start, Instant.now()).toNanos() / 1000L;
            durations.add(duration);
        }

        var average = durations.stream().mapToLong(i -> i).average().orElse(0D);

        System.out.printf("Calculated the largest prime factor for each number up to %s in %s %ss\n",
                upperBound, Double.valueOf(average).longValue(), "\u00B5");
    }
}