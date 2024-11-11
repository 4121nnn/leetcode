var primes []int

func primeSubOperation(nums []int) bool {
    if primes == nil {
        for i := 2; i < 1000; i++ {
            if isPrime(i) {
                primes = append(primes, i)
            }
        }
    }

    prev := 0

    for _, num := range nums {
        if prev >= num {
            return false;
        }
        i := bs(primes, num - prev) - 1
        if i != -1 {
            num -= primes[i]
        }
        prev = num
    }
    return true
}

func bs(a []int, target int) int {
    l, r := 0, len(a)
    for l < r {
        m := l + (r - l) / 2
        if a[m] >= target {
            r = m
        } else {
            l = m + 1
        }
    }
    return l
}

func isPrime(x int) bool {
    if x < 2 {
        return false
    }
    for i := 2; i * i <= x; i++ {
        if x % i == 0 {
            return false
        }
    }
    return true
}
