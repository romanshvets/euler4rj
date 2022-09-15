package com.rshvets.euler;

import java.util.Collections;
import java.util.List;

public class Problem003 {

    public static void main(String[] args) {
        var primeFactors = primeFactors(600851475143L);

        System.out.printf("Result: %s", largestPrimeFactor(primeFactors));
    }

    public static long largestPrimeFactor(List<Long> primeFactors) {
        if (primeFactors.isEmpty())
            return 0;

        return primeFactors.get(primeFactors.size() - 1);
    }

    public static List<Long> primeFactors(long n) {
        return Collections.emptyList();
    }

    public static boolean isPrime(long n) {
        return false;
    }
}
