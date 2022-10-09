const N: u64 = 600851475143;

fn main() {
    match get_largest_prime_factor(N) {
        None => {
            println!("{} is a prime number", N);
        }
        Some(largest_prime_factor) => {
            println!("Result: {:?}", largest_prime_factor);
        }
    }
}

fn get_largest_prime_factor(mut n: u64) -> Option<u64> {
    let mut result = 0;

    while n % 2 == 0 {
        result = 2;

        n = n / 2;
    }

    let upper_bound = (n as f64).sqrt().floor() as u64;

    for i in (3..=upper_bound).step_by(2) {
        while n % i == 0 {
            result = i;

            n = n / i;
        }
    }

    if result == 0 {
        None
    } else {
        if n > 2 {
            result = n;
        }

        Some(result)
    }
}

#[cfg(test)]
mod tests {
    use std::time::Instant;

    use crate::get_largest_prime_factor;

    #[ignore]
    #[test]
    fn test_get_prime_factors() {
        assert_eq!(None, get_largest_prime_factor(23));
        assert_eq!(None, get_largest_prime_factor(59));
        assert_eq!(None, get_largest_prime_factor(83));

        assert_eq!(Some(7), get_largest_prime_factor(392));
        assert_eq!(Some(3), get_largest_prime_factor(648));
        assert_eq!(Some(29), get_largest_prime_factor(13195));
        assert_eq!(Some(43), get_largest_prime_factor(14534));
        assert_eq!(Some(331), get_largest_prime_factor(45347));
        assert_eq!(Some(193), get_largest_prime_factor(75849));
        assert_eq!(Some(997), get_largest_prime_factor(105682));
    }

    #[test]
    fn test_prime_factors_performance() {
        let upper_bound = 100_000;

        let mut durations = vec![];

        for _ in 0..1000 {
            let now = Instant::now();

            for n in 2..=upper_bound {
                let _largest_prime_factor = get_largest_prime_factor(n);
            }

            durations.push(now.elapsed().as_micros());
        }

        let average = durations.iter().sum::<u128>() / (durations.len() as u128);

        println!(
            "Calculated the largest prime factor for each number up to {} in {} μs",
            upper_bound, average
        );
    }
}
