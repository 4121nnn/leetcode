func findScore(nums []int) int64 {
    a := make([][]int, len(nums))
    for i := range nums{
        a[i] = []int{nums[i], i}
    }
    sort.Slice(a, func(i, j int) bool {
        if a[i][0] == a[j][0] {
            return a[i][1] < a[j][1]
        }
        return a[i][0] < a[j][0]
    })
    res := 0
    for _, r := range a{
        i := r[1]
        if nums[i] == -1{
            continue
        }
        res += nums[i]
        nums[i] = -1
        if i > 0 { nums[i - 1] = -1 }
        if i < len(a) -1 { nums[i + 1] = -1 }
    }
    return int64(res)
}
