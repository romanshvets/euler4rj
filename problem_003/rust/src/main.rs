fn main() {
    let prime_factors = get_prime_factors(600851475143);

    println!("Result: {}", get_largest_prime_factor(&prime_factors));
}

fn get_prime_factors(mut n: u64) -> Vec<u64> {
    let mut result = vec![];
    let mut divider = 2;

    while n != 1 {
        while n % divider == 0 {
            n = n / divider;

            if !result.contains(&divider) {
                result.push(divider);
            }
        }

        divider += 1;
    }

    result
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
        let now = Instant::now();
        for n in 2..=1_000_000 {
            let prime_factors = get_prime_factors(n);

            if prime_factors.len() > 1_000_000 {
                println!("This should not happen");
            }
        }

        let elapsed = now.elapsed();
        println!("Duration = {:?}", elapsed);
    }
}
