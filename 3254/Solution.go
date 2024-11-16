func resultsArray(nums []int, k int) []int {
    a := make([]int, len(nums))

    for i := 1; i < len(nums); i++ {
        a[i] = a[i-1]
        if nums[i] - 1 != nums[i-1] {
            a[i]++
        }
    }

    res := make([]int, len(nums) - k + 1)

    for i := 0; i < len(res); i++ {
        if a[i] == a[i + k - 1] {
            res[i] = nums[i + k - 1]
        } else {
            res[i] = -1
        }
    }
    return res
}
