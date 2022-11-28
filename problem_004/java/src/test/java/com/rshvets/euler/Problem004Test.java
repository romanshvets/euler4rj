package com.rshvets.euler;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static com.rshvets.euler.Problem004.*;
import static java.util.Collections.singletonList;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

class Problem004Test {

    @Test
    void getLargestPalindromeTest() {
        assertEquals(9009, getLargestPalindrome(2));
    }

    @Test
    void getLargestPalindromePerformanceTest() {
        for (int i = 0; i < 1_000_000; ++i) {
            getLargestPalindrome(2);
        }

        for (int i = 1; i <= 4; ++i) {
            var start = Instant.now();

            var largestPalindrome = 0L;

            for (int j = 0; j < 100; ++j) {
                largestPalindrome = getLargestPalindrome(i);
            }

            var duration = Duration.between(start, Instant.now()).getNano() / 100 / 1000L;

            System.out.printf("Calculated largest palindrome for %s-digit numbers in %s %ss. Result is %s\n",
                    i, duration, "\u00B5", largestPalindrome);
        }
    }

    @Test
    void toDigitsTest() {
        assertEquals(singletonList(0L), toDigits(0));
        assertEquals(singletonList(1L), toDigits(1));
        assertEquals(of(1L, 5L, 8L), toDigits(158));
        assertEquals(of(2L, 7L, 3L, 1L, 4L), toDigits(27314));
    }

    @Test
    void isPalindromeTest() {
        assertFalse(isPalindrome(of(1L, 2L, 3L)));
        assertFalse(isPalindrome(of(1L, 5L, 9L)));
        assertFalse(isPalindrome(of(1L, 2L)));
        assertFalse(isPalindrome(of(1L, 4L, 5L, 9L)));

        assertTrue(isPalindrome(of(1L)));
        assertTrue(isPalindrome(of(1L, 2L, 1L)));
        assertTrue(isPalindrome(of(5L, 6L, 5L)));
        assertTrue(isPalindrome(of(1L, 5L, 3L, 5L, 1L)));
    }
}
