func maximumBeauty(nums []int, k int) int {
    sort.Ints(nums)
    r, l := 0, 0
    for ; r < len(nums); r++ {
        if nums[r] - nums[l] > 2 * k {
            l++
        }
    }
    return r - l
}
