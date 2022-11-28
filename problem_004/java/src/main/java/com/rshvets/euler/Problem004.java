package com.rshvets.euler;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem004 {

    public static void main(String[] args) {
        System.out.printf("Result: %s\n", getLargestPalindrome(2));
    }

    public static long getLargestPalindrome(int digits) {
        var lowerBound = Double.valueOf(Math.pow(10, digits - 1)).longValue();
        var upperBound = Double.valueOf(Math.pow(10, digits) - 1).longValue();

        var largestPalindrome = 0L;

        for (var i = upperBound; i >= lowerBound; --i) {
            for (var j = upperBound; j >= lowerBound; --j) {
                var product = i * j;
                if (product > largestPalindrome && isPalindrome(toDigits(product))) {
                    largestPalindrome = product;
                }
            }
        }

        return largestPalindrome;
    }

    public static List<Long> toDigits(long n) {
        if (n == 0) {
            return Collections.singletonList(0L);
        }

        var result = new LinkedList<Long>();

        while (n > 0) {
            result.add(0, n % 10);
            n = n / 10;
        }

        return result;
    }

    public static boolean isPalindrome(List<Long> digits) {
        var len = digits.size();

        for (int i = 0; i < len / 2; ++i) {
            var first = digits.get(i);
            var last = digits.get(len - i - 1);

            if (!first.equals(last)) {
                return false;
            }
        }

        return true;
    }
}