package com.rshvets.euler;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem003 {

    public static void main(String[] args) {
        var primeFactors = getPrimeFactors(600851475143L);

        System.out.printf("Result: %s", getLargestPrimeFactor(primeFactors));
    }

    public static long getLargestPrimeFactor(List<Long> primeFactors) {
        if (primeFactors.isEmpty())
            return 0;

        return primeFactors.get(primeFactors.size() - 1);
    }

    public static List<Long> getPrimeFactors(long n) {
        if (isPrime(n)) {
            return Collections.emptyList();
        }

        var nextPrime = 2L;
        var result = new LinkedList<Long>();

        while (n != 1) {
            while (n % nextPrime == 0) {
                n = n / nextPrime;

                if (!result.contains(nextPrime))
                    result.add(nextPrime);
            }

            nextPrime = getNextPrime(nextPrime);
        }

        return result;
    }

    public static long getNextPrime(long base) {
        var n = base + 1;

        while (!isPrime(n)) {
            ++n;
        }

        return n;
    }

    public static boolean isPrime(long n) {
        if (n <= 1) {
            throw new IllegalArgumentException(String.format("Argument \"%s\" is not acceptable for isPrime function", n));
        }

        var upperBound = (long) Math.floor(Math.sqrt(n));

        for (var i = 2; i <= upperBound; ++i) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
