func maxPoints(points [][]int) int64 {
    n := len(points[0])
    cur := make([]int64, n)
    prev := make([]int64, n)
    var max int64
    for _, row := range points{
        max = 0
        for j := 0; j < n ; j++{
            max = max64(max - 1, prev[j])
            cur[j] = max
        }
        max = 0
        for j := n-1; j >= 0 ; j--{
            max = max64(max -1, prev[j])
            cur[j] = max64(cur[j], max) + int64(row[j])
        }
        copy(prev, cur)
    }
    max = 0
    for i := 0; i< n; i++{
        max = max64(max, prev[i])
    }

    return max
}
func max64(a, b int64) int64{
    if a > b {
        return a
    }
    return b
}
