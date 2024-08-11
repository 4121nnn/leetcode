func nearestValidPoint(x int, y int, points [][]int) int {
    res := math.MaxInt
    ind := -1
    for i, a := range points{
        if a[0] == x || a[1] == y{
            cur := int(math.Abs(float64(x - a[0])) + math.Abs(float64(y - a[1])))
            if cur < res{
                res = cur
                ind = i
            }
        }
    }
    return ind
}
