func minimumSize(nums []int, maxOperations int) int {
    l, r := 1, 1000000000
    for l <= r {
        m := (r + l) / 2
        k := 0
        for _, i := range nums {
            k += (i - 1) / m
        }
        if k <= maxOperations {
            r = m - 1
        }else {
            l = m + 1
        }
    }
    return l
}
