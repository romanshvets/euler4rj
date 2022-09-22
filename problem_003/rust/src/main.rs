fn main() {
    let prime_factors = get_prime_factors(600851475143);

    println!("Result: {}", get_largest_prime_factor(&prime_factors));
}

fn get_prime_factors(mut n: u64) -> Vec<u64> {
    let mut result = vec![];

    while n % 2 == 0 {
        add_if_unique(&mut result, 2);

        n = n / 2;
    }

    let upper_bound = (n as f64).sqrt().floor() as u64;

    for i in (3..=upper_bound).step_by(2) {
        while n % i == 0 {
            add_if_unique(&mut result, i);

            n = n / i;
        }
    }

    if n > 2 {
        add_if_unique(&mut result, n);
    }

    result
}

fn add_if_unique(array: &mut Vec::<u64>, value: u64) -> () {
    if !array.contains(&value) {
        array.push(value);
    }
}

fn get_largest_prime_factor(prime_factors: &[u64]) -> u64 {
    if prime_factors.is_empty() {
        return 0;
    }

    prime_factors[prime_factors.len() - 1]
}

#[cfg(test)]
mod tests {
    use crate::{get_largest_prime_factor, get_prime_factors};
    use std::time::Instant;

    #[test]
    fn test_get_largest_prime_factor() {
        assert_eq!(7, get_largest_prime_factor(&vec![2, 7]));
        assert_eq!(29, get_largest_prime_factor(&vec![5, 7, 13, 29]));
        assert_eq!(997, get_largest_prime_factor(&vec![2, 53, 997]));
    }

    #[test]
    fn test_prime_factors() {
        assert_eq!(vec![2, 7], get_prime_factors(392));
        assert_eq!(vec![5, 7, 13, 29], get_prime_factors(13195));
        assert_eq!(vec![2, 53, 997], get_prime_factors(105682));
    }

    #[test]
    fn test_prime_factors_performance() {
        let upper_bounds = vec![10_000, 100_000, 1_000_000, 10_000_000];

        for upper_bound in upper_bounds {
            let now = Instant::now();

            for n in 2..=upper_bound {
                let _prime_factors = get_prime_factors(n);
            }

            let elapsed = now.elapsed();
            println!("Upper bound = {}, Duration = {:?}", upper_bound, elapsed);
        }
    }
}
