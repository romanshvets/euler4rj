fn main() {
    println!("Result: {}", sum_of_multiples(1000));
}

fn sum_of_multiples(upper_bound: u128) -> u128 {
    let mut sum = 0;

    let base = 3;

    for n in 0.. {
        let product = n * base;

        if product >= upper_bound {
            break;
        }

        sum += product;
    }

    let base = 5;

    for n in 0.. {
        if n % 3 == 0 {
            continue;
        }

        let product = n * base;

        if product >= upper_bound {
            break;
        }

        sum += product;
    }

    sum
}

#[cfg(test)]
mod tests {
    use crate::sum_of_multiples;
    use std::time::Instant;

    #[ignore]
    #[test]
    fn test_sum_of_multiples() {
        assert_eq!(23, sum_of_multiples(10));
        assert_eq!(233168, sum_of_multiples(1000));
    }

    #[test]
    fn test_sum_of_multiples_performance() {
        for n in 4..10 {
            let upper_bound = 10u128.pow(n);

            let now = Instant::now();
            let res = sum_of_multiples(upper_bound);
            let elapsed = now.elapsed();

            println!(
                "Upper bound: {:>10}, Result: {:>20}, Time: {:>10?}",
                upper_bound,
                res,
                elapsed.as_micros()
            );
        }
    }
}
