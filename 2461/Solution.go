func maximumSubarraySum(nums []int, k int) int64 {
    mx, dup, r, prev:= 0, 0, 0, 0
    for _, n := range nums {
        mx = max(mx, n)
    }
    m := make([]int, mx + 1)
    var res int64
    var sum int64

    for ; r < k - 1; r++ {
        if m[nums[r]] > 0 {
            dup++
        }
        sum += int64(nums[r])
        m[nums[r]]++
    }

    for ; r < len(nums); r++{
        sum += int64(nums[r] - prev)
        if m[nums[r]] > 0 {
            dup++
        }

        m[nums[r]]++
        
        if dup == 0 {
            res = max(res, sum)
        }
        
        prev = nums[r - k + 1]
        if m[prev]  > 1 {
            dup--
        }
        m[prev]--
    }
    return res
}
