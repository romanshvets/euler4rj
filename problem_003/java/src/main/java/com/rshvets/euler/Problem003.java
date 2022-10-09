package com.rshvets.euler;

import java.util.Optional;

public class Problem003 {

    private static final long N = 600851475143L;

    public static void main(String[] args) {
        var largestPrimeFactor = getLargestPrimeFactor(N);
        if (largestPrimeFactor.isEmpty()) {
            System.out.printf("%s is a prime number", N);
        } else {
            System.out.printf("Result: %s\n", largestPrimeFactor.get());
        }
    }

    public static Optional<Long> getLargestPrimeFactor(long n) {
        var result = 0L;

        while (n % 2 == 0) {
            result = 2;

            n = n / 2;
        }

        var upperBound = Double.valueOf(Math.floor(Math.sqrt(n))).longValue();

        for (var i = 3; i <= upperBound; i = i + 2) {
            while (n % i == 0) {
                result = i;

                n = n / i;
            }
        }

        if (result == 0) {
            return Optional.empty();
        } else {
            if (n > 2) {
                result = n;
            }

            return Optional.of(result);
        }
    }
}