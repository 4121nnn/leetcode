func minimizedMaximum(n int, quantities []int) int {
    l, r, res := 1, math.MaxInt32, 0
    for l <= r {
        m := l + (r - l) / 2
        if canDistribute(n, quantities, m) {
            res = m
            r = m - 1
        } else {
            l = m + 1
        }
    }
    return res
}

func canDistribute(n int, quantities []int, k int) bool {
    count := 0
    for _, q := range quantities {
        count += q / k
        if q % k != 0 {
            count++;
        }
    }
    return count <= n
}
