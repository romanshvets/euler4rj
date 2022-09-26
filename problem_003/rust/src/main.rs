fn main() {
    println!("Result: {}", get_largest_prime_factor(600851475143));
}

fn get_largest_prime_factor(mut n: u64) -> u64 {
    let mut max_prime_factor = 0;

    while n % 2 == 0 {
        max_prime_factor = 2;

        n = n / 2;
    }

    let upper_bound = (n as f64).sqrt().floor() as u64;

    for i in (3..=upper_bound).step_by(2) {
        while n % i == 0 {
            max_prime_factor = i;

            n = n / i;
        }
    }

    if n > 2 {
        max_prime_factor = n;
    }

    max_prime_factor
}

#[cfg(test)]
mod tests {
    use crate::get_largest_prime_factor;
    use std::time::Instant;

    #[ignore]
    #[test]
    fn test_get_largest_prime_factor() {
        assert_eq!(7, get_largest_prime_factor(392));
        assert_eq!(29, get_largest_prime_factor(13195));
        assert_eq!(331, get_largest_prime_factor(45347));
        assert_eq!(997, get_largest_prime_factor(105682));
    }

    #[test]
    fn test_prime_factors_performance() {
        let upper_bounds = vec![10_000, 100_000, 1_000_000];

        for upper_bound in upper_bounds {
            let mut durations = vec![];

            for _ in 0..100 {
                let now = Instant::now();

                for n in 2..=upper_bound {
                    let _max_prime_factors = get_largest_prime_factor(n);
                }

                durations.push(now.elapsed().as_micros());
            }

            let average = durations.iter().sum::<u128>() / (durations.len() as u128);

            println!(
                "Calculated prime factors for each number up to {} in {} μs",
                upper_bound, average
            );
        }
    }
}
