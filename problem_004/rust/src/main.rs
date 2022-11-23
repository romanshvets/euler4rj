fn main() {
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
}

#[cfg(test)]
mod tests {
    use std::time::Instant;

    use crate::{is_palindrome, largest_palindrome, amount_of_digits, to_digits};

    #[test]
    fn test_largest_palindrome() {
        assert_eq!(9009, largest_palindrome(2));
    }

    #[test]
    fn test_largest_palindrome_preformance() {
        for i in 1..=4 {
            let now = Instant::now();

            let largest_palindrome = largest_palindrome(i);

            let elapsed = now.elapsed().as_micros();

            println!("Calculated largest palindrome for {}-digit numbers in {:?} µs. Result is {}", i, elapsed, largest_palindrome);
        }

        assert_eq!(9009, largest_palindrome(2));
    }

    #[test]
    fn test_amount_of_digits() {
        assert_eq!(1, amount_of_digits(0));
        assert_eq!(2, amount_of_digits(45));
        assert_eq!(3, amount_of_digits(156));
        assert_eq!(5, amount_of_digits(69434));
    }

    #[test]
    fn test_to_digits() {
        assert_eq!(vec![0], to_digits(0));
        assert_eq!(vec![1], to_digits(1));
        assert_eq!(vec![1, 5, 8], to_digits(158));
        assert_eq!(vec![2, 7, 3, 1, 4], to_digits(27314));
    }

    #[test]
    fn test_is_palindrome() {
        assert_eq!(false, is_palindrome(&vec![1, 2, 3]));
        assert_eq!(false, is_palindrome(&vec![1, 5, 9]));
        assert_eq!(false, is_palindrome(&vec![1, 2]));
        assert_eq!(false, is_palindrome(&vec![1, 4, 5, 9]));

        assert_eq!(true, is_palindrome(&vec![1]));
        assert_eq!(true, is_palindrome(&vec![1, 2, 1]));
        assert_eq!(true, is_palindrome(&vec![5, 6, 5]));
        assert_eq!(true, is_palindrome(&vec![1, 5, 3, 5, 1]));
    }
}
