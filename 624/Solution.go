func maxDistance(a [][]int) int {
    min, max := a[0][0], a[0][len(a[0]) - 1]
    res := 0
    for i  := 1; i < len(a); i++{
        curMin, curMax := a[i][0], a[i][len(a[i]) - 1]
        res = maxInt(res, maxInt(curMax - min, max - curMin))
        if min > curMin { min = curMin }
        if max < curMax { max = curMax }
    }
    return res
}
func maxInt(x, y int) int {
    if x > y {
        return x
    }
    return y
}
