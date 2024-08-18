func nthUglyNumber(n int) int {
    res := make([]int, n)
    n2, n3, n5 := 0, 0, 0
    res[0] = 1
    for i := 1; i < n; i++{
        res[i] = min(res[n2] * 2, min(res[n3] * 3, res[n5] * 5))
        if res[i] == res[n2] * 2 { n2++ }
        if res[i] == res[n3] * 3 { n3++ }
        if res[i] == res[n5] * 5 { n5++ }
    }
    return res[n-1]
}
 func min(a, b int) int{
    if a < b {
        return a
    }
    return b
 }
