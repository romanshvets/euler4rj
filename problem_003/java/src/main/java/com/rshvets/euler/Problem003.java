package com.rshvets.euler;

public class Problem003 {

    public static void main(String[] args) {
        System.out.printf("Result: %s\n", getLargestPrimeFactor(600851475143L));
    }

    public static long getLargestPrimeFactor(long n) {
        long maxPrimeFactor = 0;

        while (n % 2 == 0) {
            maxPrimeFactor = 2;

            n = n / 2;
        }

        long upperBound = (long) Math.floor(Math.sqrt(n));

        for (var i = 3; i <= upperBound; i = i + 2) {
            while (n % i == 0) {
                maxPrimeFactor = i;

                n = n / i;
            }
        }

        if (n > 2) {
            maxPrimeFactor = n;
        }

        return maxPrimeFactor;
    }
}
