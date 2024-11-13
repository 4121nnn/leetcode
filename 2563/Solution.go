func countFairPairs(nums []int, lower int, upper int) int64 {
    sort.Ints(nums)
    return find(nums, upper) - find(nums, lower - 1)
}

func find(nums []int, target int) int64 {
    var res int64
    for i, j := 0, len(nums) - 1; i < j; {
        if nums[i] + nums[j] > target {
            j--
        } else {
            res += int64(j - i)
            i++
        }
    }
    return res
}
