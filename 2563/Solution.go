func countFairPairs(nums []int, lower int, upper int) int64 {
    sort.Ints(nums)
    return find(nums, upper) - find(nums, lower -1)
}
func find(nums []int, upper int) int64 {
    l, r, res := 0, len(nums) - 1, 0
    for l < r {
        for l < r && nums[l] + nums[r] > upper {
            r--
        }
        res += r - l
        l++
    }
    return int64(res)
}
