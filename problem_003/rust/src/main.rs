fn main() {
    let prime_factors = get_prime_factors(600851475143);

    println!("Result: {}", get_largest_prime_factor(&prime_factors));
}

fn get_largest_prime_factor(prime_factors: &[u64]) -> u64 {
    if prime_factors.is_empty() {
        return 0;
    }

    prime_factors[prime_factors.len() - 1]
}

fn get_prime_factors(mut n: u64) -> Vec<u64> {
    if is_prime(n) {
        return vec![];
    }

    let mut next_prime = 2;
    let mut result = vec![];

    while n != 1 {
        while n % next_prime == 0 {
            n = n / next_prime;

            if !result.contains(&next_prime) {
                result.push(next_prime);
            }
        }

        next_prime = get_next_prime(next_prime);
    }

    result
}

fn get_next_prime(base: u64) -> u64 {
    let mut n = base + 1;

    while !is_prime(n) {
        n += 1;
    }

    n
}

fn is_prime(n: u64) -> bool {
    if n <= 1 {
        panic!("Argument \"{}\" is not acceptable for isPrime function", n);
    }

    let upper_bound = (n as f64).sqrt().floor() as u64;

    for i in 2..=upper_bound {
        if n % i == 0 {
            return false;
        }
    }

    true
}