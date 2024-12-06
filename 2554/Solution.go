func maxCount(banned []int, n int, maxSum int) int {
    a := make([]bool, 10001)
    for _, i := range banned {
        a[i] = true
    }
    count, sum := 0, 0
    for i := 1; i <= n; i++ {
        if a[i] {
            continue
        }
        sum += i
        if sum > maxSum {
            break
        }
        count++
    }
    return count
}
