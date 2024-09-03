func getLucky(s string, k int) int {
    sum := 0
    for _, c := range s {
        sum += sumDigits(int(c) - 96)
    }

    for k > 1 {
        sum = sumDigits(sum)
        k--
    }
    return sum
}

func sumDigits(x int) int {
    sum := 0
    for x > 0 {
        sum += x % 10
        x /= 10
    }
    return sum
}
