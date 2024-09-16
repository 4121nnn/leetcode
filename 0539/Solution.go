func findMinDifference(timePoints []string) int {
    res := math.MaxInt32
    min := make([]int, len(timePoints))
    for i, s := range timePoints {
        h, _ := strconv.Atoi(s[0:2])
        m, _ := strconv.Atoi(s[3:])
        min[i] = 60 * h + m
    }
    sort.Ints(min)
    for i := 1; i < len(min); i++ {
        cur := min[i] - min[i-1]
        if res > cur {
            res = cur
        }
    }
    rev := 24 * 60 + min[0] - min[len(min) - 1]
    if rev < res {
        return rev
    } 
    return res
}
