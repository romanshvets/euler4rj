package com.rshvets.euler;

public class Problem002 {

    public static void main(String[] args) {
        System.out.printf("Result: %s", sumOfEvenFibonacciNumbers(4_000_000L));
    }

    public static long sumOfEvenFibonacciNumbers(long upperBound) {
        var a = 1;
        var b = 2;

        var c = 0;

        var sum = b;

        while (c <= upperBound) {
            c = a + b;

            if (c % 2 == 0)
                sum += c;

            a = b;
            b = c;
        }

        return sum;
    }
}
