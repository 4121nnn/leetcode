func maxMatrixSum(matrix [][]int) int64 {
    mn, neg, sum := math.MaxInt, 0, 0
    for _, r := range matrix {
        for _, i := range r {
            if i < 0 {
                i *= -1
                neg ^= 1
            }
            sum += i

            mn = min(mn, i)
        }
    }

    return int64(sum - neg * mn * 2)
}
