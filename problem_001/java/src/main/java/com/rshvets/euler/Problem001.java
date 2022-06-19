package com.rshvets.euler;

public class Problem001 {

    public static void main(String[] args) {
        System.out.printf("Result: %s", sumOfMultiples(1000L));
    }

    public static long sumOfMultiples(long upperBound) {
        var sum = 0L;

        var base = 3L;

        for (int n = 0; ; ++n) {
            var product = n * base;

            if (product >= upperBound)
                break;

            sum += product;
        }

        base = 5L;

        for (int n = 0; ; ++n) {
            if (n % 3 == 0)
                continue;

            var product = n * base;

            if (product >= upperBound)
                break;

            sum += product;
        }

        return sum;
    }
}