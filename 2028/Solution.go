func missingRolls(rolls []int, mean int, n int) []int {
    dif := (n + len(rolls)) * mean
    for _, x := range rolls {
        dif -= x
    }
    if dif < n || dif > n * 6 {
        return []int{}
    }
    res := make([]int, n)
    d, r := dif / n, dif % n

    for i := 0; i < r; i++ {
        res[i] = d + 1
    }
    for i := r; i < n; i++ {
        res[i] = d
    }
    return res
}
