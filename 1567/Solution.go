func getMaxLen(nums []int) int {
    max, n := 0, len(nums)
    for i := 0; i < n; i++ {
        j, neg, leftNeg, rightNeg := i, 0, -1, -1
        for i < n && nums[i] != 0 {
            if nums[i] < 0 {
                neg++
                if leftNeg == -1 {
                    leftNeg = i
                } else {
                    rightNeg = i
                }
            }
            i++
        }
        if neg % 2 == 0 {
            max = maxInt(max, i - j)
        } else{
            leftMax := maxInt(leftNeg, rightNeg) - j
            rightMax := i - leftNeg - 1
            max = maxInt(max, maxInt(leftMax, rightMax))
        }
    }
    return max
}
func maxInt(a, b int) int{
    if a > b {
        return a
    }
    return b
}
