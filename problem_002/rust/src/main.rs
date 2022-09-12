fn main() {
    println!("Result: {}", sum_of_even_fibonacci_numbers(4_000_000));
}

fn sum_of_even_fibonacci_numbers(upper_bound: u64) -> u64 {
    let mut a = 1;
    let mut b = 2;

    let mut c = 0;

    let mut sum = b;

    while c <= upper_bound {
        c = a + b;

        if c % 2 == 0 {
            sum += c;
        }

        a = b;
        b = c;
    }

    sum
}

#[cfg(test)]
mod tests {

    use crate::sum_of_even_fibonacci_numbers;

    #[test]
    pub fn test_sum_of_even_fibonacci_numbers() {
        let fibonacci_under_50: Vec<u64> = vec![1, 2, 3, 5, 8, 13, 21, 34];

        let mut sum_of_even_fibonacci_under_50 = 0;

        for n in fibonacci_under_50 {
            if n % 2 == 0 {
                sum_of_even_fibonacci_under_50 += n;
            }
        }

        assert_eq!(sum_of_even_fibonacci_under_50, sum_of_even_fibonacci_numbers(50));
    }
}