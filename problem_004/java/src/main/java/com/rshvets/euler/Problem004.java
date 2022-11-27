package com.rshvets.euler;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem004 {

    public static void main(String[] args) {
        System.out.println("Hello world");
    }

    public long getLargestPalindrome(int digits) {
        var lowerBound = Double.valueOf(Math.pow(10, digits - 1)).longValue();
        var upperBound = Double.valueOf(Math.pow(10, digits) - 1).longValue();

        var largestPalindrome = 0L;

//        for (int i = )
//
//        let mut largest_palindrome = 0;
//
//        for i in (lower_bound..=upper_bound).rev() {
//            for j in (lower_bound..=upper_bound).rev() {
//                let product = i * j;
//                if product > largest_palindrome && is_palindrome(&to_digits(product)) {
//                    largest_palindrome = product;
//                }
//            }
//        }
//
//        largest_palindrome

        return largestPalindrome;
    }

    public List<Long> toDigits(long n) {
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

    public boolean isPalindrome(List<Long> digits) {
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

/*fn main() {
    println!("Result: {}", largest_palindrome(2));
}

fn largest_palindrome(digits: u32) -> u128 {
    let lower_bound = 10u128.pow(digits - 1);
    let upper_bound = 10u128.pow(digits) - 1;

    let mut largest_palindrome = 0;

    for i in (lower_bound..=upper_bound).rev() {
        for j in (lower_bound..=upper_bound).rev() {
            let product = i * j;
            if product > largest_palindrome && is_palindrome(&to_digits(product)) {
                largest_palindrome = product;
            }
        }
    }

    largest_palindrome
}

fn to_digits(mut n: u128) -> Vec<u128> {
    if n == 0 {
        return vec![0];
    }

    let mut res = Vec::<u128>::new();

    while n > 0 {
        res.insert(0, n % 10);

        n = n / 10;
    }

    res
}

fn is_palindrome(digits: &Vec<u128>) -> bool {
    let len = digits.len();

    for i in 0..len / 2 {
        let first = digits[i];
        let last = digits[len - i - 1];

        if first != last {
            return false;
        }
    }

    true
}*/