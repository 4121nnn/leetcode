func missingRolls(rolls []int, mean int, n int) []int {
    dif := (n + len(rolls)) * mean
    for _, x := range rolls {
        dif -= x
    }
    if dif < n || dif > n * 6 {
        return []int{}
    }
    res := make([]int, n)
    d := dif / n
    for i, _ := range res {
        res[i] = d
    }
    for i := 0; i < dif % n; i++ {
        res[i]++
    }
    return res
}
